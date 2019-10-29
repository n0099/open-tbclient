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
    protected com.baidu.tieba.advert.sdk.a.a dlE;
    protected BCAdView dlF;
    protected TbImageView dlG;
    protected AdInfo dlH;
    protected AdInfo dlI;
    protected AdType dlJ;
    protected c dlK;
    public RedirectType dlL;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.dlF = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.dlJ = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void aEP() {
        this.dlI = new AdInfo();
        this.dlI.placeId = this.placeId;
        this.dlI.adHeight = this.mHeight;
        this.dlI.adWidth = this.mWidth;
        this.dlI.typeId = this.dlJ;
        b.aEK().a(this.mPageContext, new a(this), this.dlI);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.dlE = aVar;
        }
    }

    private void aEQ() {
        if (this.dlE != null) {
            this.dlE.aED();
        }
    }

    public void aER() {
        if (this.dlE != null) {
            this.dlE.aEE();
        }
        kp();
    }

    private void kp() {
        try {
            this.dlG = null;
            removeAllViews();
            this.dlH = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        aEQ();
    }

    /* loaded from: classes5.dex */
    static class a implements b.a {
        AdInfo dlI;
        AdType dlJ;
        c dlK;
        final WeakReference<BCAdView> dlM;

        public a(BCAdView bCAdView) {
            this.dlI = bCAdView.dlI;
            this.dlK = bCAdView.dlK;
            this.dlJ = bCAdView.dlJ;
            this.dlM = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void rX(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!aq.isEmpty(str)) {
                this.dlI = AdInfo.jsonToObject(str);
                if (this.dlJ == AdType.SPLASH && !aq.isEmpty(this.dlI.adImgUrl)) {
                    com.baidu.adp.lib.f.c.fT().a(this.dlI.adImgUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.dlK.rW(str);
                BCAdView bCAdView = this.dlM.get();
                if (bCAdView != null && (aVar = bCAdView.dlE) != null) {
                    aVar.aEC();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void rY(String str) {
            BCAdView bCAdView = this.dlM.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.dlE != null) {
                            bCAdView.dlE.a(aVar);
                        }
                    }
                    if (bCAdView.dlJ == AdType.SPLASH) {
                        bCAdView.dlK.rW("");
                    } else {
                        bCAdView.aER();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
