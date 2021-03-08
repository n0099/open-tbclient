package com.baidu.tieba.advert.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.advert.sdk.c.b;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.AdType;
import com.baidu.tieba.advert.sdk.data.RedirectType;
import com.baidu.tieba.advert.sdk.data.c;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class BCAdView extends RelativeLayout {
    protected com.baidu.tieba.advert.sdk.a.a gmN;
    protected BCAdView gmO;
    protected TbImageView gmP;
    protected AdInfo gmQ;
    protected AdInfo gmR;
    protected AdType gmS;
    protected c gmT;
    public RedirectType gmU;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.gmO = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.gmS = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.gmR = new AdInfo();
        this.gmR.placeId = this.placeId;
        this.gmR.adHeight = this.mHeight;
        this.gmR.adWidth = this.mWidth;
        this.gmR.typeId = this.gmS;
        b.bML().a(this.mPageContext, new a(this), this.gmR);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.gmN = aVar;
        }
    }

    private void bMR() {
        if (this.gmN != null) {
            this.gmN.bMx();
        }
    }

    public void aRf() {
        if (this.gmN != null) {
            this.gmN.bMy();
        }
        onAdClose();
    }

    private void onAdClose() {
        try {
            this.gmP = null;
            removeAllViews();
            this.gmQ = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bMR();
    }

    /* loaded from: classes7.dex */
    static class a implements b.a {
        AdInfo gmR;
        AdType gmS;
        c gmT;
        final WeakReference<BCAdView> gmV;

        public a(BCAdView bCAdView) {
            this.gmR = bCAdView.gmR;
            this.gmT = bCAdView.gmT;
            this.gmS = bCAdView.gmS;
            this.gmV = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.c.b.a
        public void Fv(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!au.isEmpty(str)) {
                this.gmR = AdInfo.jsonToObject(str);
                if (this.gmS == AdType.SPLASH && !au.isEmpty(this.gmR.adImgUrl)) {
                    d.mw().a(this.gmR.adImgUrl, 10, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.gmT.Fs(str);
                BCAdView bCAdView = this.gmV.get();
                if (bCAdView != null && (aVar = bCAdView.gmN) != null) {
                    aVar.bMw();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.c.b.a
        public void Fw(String str) {
            BCAdView bCAdView = this.gmV.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.gmN != null) {
                            bCAdView.gmN.a(aVar);
                        }
                    }
                    if (bCAdView.gmS == AdType.SPLASH) {
                        bCAdView.gmT.Fs("");
                    } else {
                        bCAdView.aRf();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
