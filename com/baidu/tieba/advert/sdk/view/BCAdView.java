package com.baidu.tieba.advert.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.e.d;
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
/* loaded from: classes8.dex */
public class BCAdView extends RelativeLayout {
    protected com.baidu.tieba.advert.sdk.a.a gmR;
    protected BCAdView gmS;
    protected TbImageView gmT;
    protected AdInfo gmU;
    protected AdInfo gmV;
    protected AdType gmW;
    protected c gmX;
    public RedirectType gmY;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.gmS = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.gmW = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.gmV = new AdInfo();
        this.gmV.placeId = this.placeId;
        this.gmV.adHeight = this.mHeight;
        this.gmV.adWidth = this.mWidth;
        this.gmV.typeId = this.gmW;
        b.bPP().a(this.mPageContext, new a(this), this.gmV);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.gmR = aVar;
        }
    }

    private void bPU() {
        if (this.gmR != null) {
            this.gmR.bPJ();
        }
    }

    public void aUE() {
        if (this.gmR != null) {
            this.gmR.bPK();
        }
        onAdClose();
    }

    private void onAdClose() {
        try {
            this.gmT = null;
            removeAllViews();
            this.gmU = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bPU();
    }

    /* loaded from: classes8.dex */
    static class a implements b.a {
        AdInfo gmV;
        AdType gmW;
        c gmX;
        final WeakReference<BCAdView> gmZ;

        public a(BCAdView bCAdView) {
            this.gmV = bCAdView.gmV;
            this.gmX = bCAdView.gmX;
            this.gmW = bCAdView.gmW;
            this.gmZ = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void FZ(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!at.isEmpty(str)) {
                this.gmV = AdInfo.jsonToObject(str);
                if (this.gmW == AdType.SPLASH && !at.isEmpty(this.gmV.adImgUrl)) {
                    d.mx().a(this.gmV.adImgUrl, 10, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str2, int i) {
                            super.onLoaded((AnonymousClass1) aVar2, str2, i);
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
                        public void onProgressUpdate(Object... objArr) {
                            super.onProgressUpdate(objArr);
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
                        public void onCancelled(String str2) {
                            super.onCancelled(str2);
                        }
                    }, 0, 0, null, new Object[0]);
                }
                this.gmX.FY(str);
                BCAdView bCAdView = this.gmZ.get();
                if (bCAdView != null && (aVar = bCAdView.gmR) != null) {
                    aVar.bPI();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Ga(String str) {
            BCAdView bCAdView = this.gmZ.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.gmR != null) {
                            bCAdView.gmR.a(aVar);
                        }
                    }
                    if (bCAdView.gmW == AdType.SPLASH) {
                        bCAdView.gmX.FY("");
                    } else {
                        bCAdView.aUE();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
