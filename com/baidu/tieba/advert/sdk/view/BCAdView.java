package com.baidu.tieba.advert.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.advert.sdk.b.b;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.AdType;
import com.baidu.tieba.advert.sdk.data.RedirectType;
import com.baidu.tieba.advert.sdk.data.c;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class BCAdView extends RelativeLayout {
    protected com.baidu.tieba.advert.sdk.a.a dkN;
    protected BCAdView dkO;
    protected TbImageView dkP;
    protected AdInfo dkQ;
    protected AdInfo dkR;
    protected AdType dkS;
    protected c dkT;
    public RedirectType dkU;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.dkO = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.dkS = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void aEN() {
        this.dkR = new AdInfo();
        this.dkR.placeId = this.placeId;
        this.dkR.adHeight = this.mHeight;
        this.dkR.adWidth = this.mWidth;
        this.dkR.typeId = this.dkS;
        b.aEI().a(this.mPageContext, new a(this), this.dkR);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.dkN = aVar;
        }
    }

    private void aEO() {
        if (this.dkN != null) {
            this.dkN.aEB();
        }
    }

    public void aEP() {
        if (this.dkN != null) {
            this.dkN.aEC();
        }
        kp();
    }

    private void kp() {
        try {
            this.dkP = null;
            removeAllViews();
            this.dkQ = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        aEO();
    }

    /* loaded from: classes5.dex */
    static class a implements b.a {
        AdInfo dkR;
        AdType dkS;
        c dkT;
        final WeakReference<BCAdView> dkV;

        public a(BCAdView bCAdView) {
            this.dkR = bCAdView.dkR;
            this.dkT = bCAdView.dkT;
            this.dkS = bCAdView.dkS;
            this.dkV = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void rX(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!aq.isEmpty(str)) {
                this.dkR = AdInfo.jsonToObject(str);
                if (this.dkS == AdType.SPLASH && !aq.isEmpty(this.dkR.adImgUrl)) {
                    com.baidu.adp.lib.f.c.fT().a(this.dkR.adImgUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str2, int i) {
                            super.onLoaded((AnonymousClass1) aVar2, str2, i);
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onProgressUpdate(Object... objArr) {
                            super.onProgressUpdate(objArr);
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            super.onCancelled(str2);
                        }
                    }, 0, 0, null, new Object[0]);
                }
                this.dkT.rW(str);
                BCAdView bCAdView = this.dkV.get();
                if (bCAdView != null && (aVar = bCAdView.dkN) != null) {
                    aVar.aEA();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void rY(String str) {
            BCAdView bCAdView = this.dkV.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.dkN != null) {
                            bCAdView.dkN.a(aVar);
                        }
                    }
                    if (bCAdView.dkS == AdType.SPLASH) {
                        bCAdView.dkT.rW("");
                    } else {
                        bCAdView.aEP();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
