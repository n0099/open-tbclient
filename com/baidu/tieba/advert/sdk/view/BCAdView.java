package com.baidu.tieba.advert.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.advert.sdk.b.b;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.AdType;
import com.baidu.tieba.advert.sdk.data.RedirectType;
import com.baidu.tieba.advert.sdk.data.c;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class BCAdView extends RelativeLayout {
    protected com.baidu.tieba.advert.sdk.a.a fvn;
    protected BCAdView fvo;
    protected TbImageView fvp;
    protected AdInfo fvq;
    protected AdInfo fvr;
    protected AdType fvs;
    protected c fvt;
    public RedirectType fvu;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.fvo = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.fvs = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.fvr = new AdInfo();
        this.fvr.placeId = this.placeId;
        this.fvr.adHeight = this.mHeight;
        this.fvr.adWidth = this.mWidth;
        this.fvr.typeId = this.fvs;
        b.bDq().a(this.mPageContext, new a(this), this.fvr);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.fvn = aVar;
        }
    }

    private void bDv() {
        if (this.fvn != null) {
            this.fvn.bDl();
        }
    }

    public void aIK() {
        if (this.fvn != null) {
            this.fvn.bDm();
        }
        rC();
    }

    private void rC() {
        try {
            this.fvp = null;
            removeAllViews();
            this.fvq = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bDv();
    }

    /* loaded from: classes22.dex */
    static class a implements b.a {
        AdInfo fvr;
        AdType fvs;
        c fvt;
        final WeakReference<BCAdView> fvv;

        public a(BCAdView bCAdView) {
            this.fvr = bCAdView.fvr;
            this.fvt = bCAdView.fvt;
            this.fvs = bCAdView.fvs;
            this.fvv = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Eu(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!at.isEmpty(str)) {
                this.fvr = AdInfo.jsonToObject(str);
                if (this.fvs == AdType.SPLASH && !at.isEmpty(this.fvr.adImgUrl)) {
                    com.baidu.adp.lib.e.c.mR().a(this.fvr.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str2, int i) {
                            super.onLoaded((AnonymousClass1) aVar2, str2, i);
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onProgressUpdate(Object... objArr) {
                            super.onProgressUpdate(objArr);
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onCancelled(String str2) {
                            super.onCancelled(str2);
                        }
                    }, 0, 0, null, new Object[0]);
                }
                this.fvt.Et(str);
                BCAdView bCAdView = this.fvv.get();
                if (bCAdView != null && (aVar = bCAdView.fvn) != null) {
                    aVar.bDk();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Ev(String str) {
            BCAdView bCAdView = this.fvv.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.fvn != null) {
                            bCAdView.fvn.a(aVar);
                        }
                    }
                    if (bCAdView.fvs == AdType.SPLASH) {
                        bCAdView.fvt.Et("");
                    } else {
                        bCAdView.aIK();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
