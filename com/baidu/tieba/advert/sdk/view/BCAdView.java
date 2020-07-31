package com.baidu.tieba.advert.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.advert.sdk.b.b;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.AdType;
import com.baidu.tieba.advert.sdk.data.RedirectType;
import com.baidu.tieba.advert.sdk.data.c;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class BCAdView extends RelativeLayout {
    protected com.baidu.tieba.advert.sdk.a.a fgC;
    protected BCAdView fgD;
    protected TbImageView fgE;
    protected AdInfo fgF;
    protected AdInfo fgG;
    protected AdType fgH;
    protected c fgI;
    public RedirectType fgJ;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.fgD = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.fgH = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.fgG = new AdInfo();
        this.fgG.placeId = this.placeId;
        this.fgG.adHeight = this.mHeight;
        this.fgG.adWidth = this.mWidth;
        this.fgG.typeId = this.fgH;
        b.bti().a(this.mPageContext, new a(this), this.fgG);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.fgC = aVar;
        }
    }

    private void btn() {
        if (this.fgC != null) {
            this.fgC.btc();
        }
    }

    public void azP() {
        if (this.fgC != null) {
            this.fgC.btd();
        }
        pY();
    }

    private void pY() {
        try {
            this.fgE = null;
            removeAllViews();
            this.fgF = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        btn();
    }

    /* loaded from: classes17.dex */
    static class a implements b.a {
        AdInfo fgG;
        AdType fgH;
        c fgI;
        final WeakReference<BCAdView> fgK;

        public a(BCAdView bCAdView) {
            this.fgG = bCAdView.fgG;
            this.fgI = bCAdView.fgI;
            this.fgH = bCAdView.fgH;
            this.fgK = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void BC(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!as.isEmpty(str)) {
                this.fgG = AdInfo.jsonToObject(str);
                if (this.fgH == AdType.SPLASH && !as.isEmpty(this.fgG.adImgUrl)) {
                    com.baidu.adp.lib.e.c.ln().a(this.fgG.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.fgI.BB(str);
                BCAdView bCAdView = this.fgK.get();
                if (bCAdView != null && (aVar = bCAdView.fgC) != null) {
                    aVar.btb();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void BD(String str) {
            BCAdView bCAdView = this.fgK.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.fgC != null) {
                            bCAdView.fgC.a(aVar);
                        }
                    }
                    if (bCAdView.fgH == AdType.SPLASH) {
                        bCAdView.fgI.BB("");
                    } else {
                        bCAdView.azP();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
