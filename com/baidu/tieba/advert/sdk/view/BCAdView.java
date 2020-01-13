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
/* loaded from: classes8.dex */
public class BCAdView extends RelativeLayout {
    protected com.baidu.tieba.advert.sdk.a.a dYB;
    protected BCAdView dYC;
    protected TbImageView dYD;
    protected AdInfo dYE;
    protected AdInfo dYF;
    protected AdType dYG;
    protected c dYH;
    public RedirectType dYI;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.dYC = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.dYG = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.dYF = new AdInfo();
        this.dYF.placeId = this.placeId;
        this.dYF.adHeight = this.mHeight;
        this.dYF.adWidth = this.mWidth;
        this.dYF.typeId = this.dYG;
        b.aWU().a(this.mPageContext, new a(this), this.dYF);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.dYB = aVar;
        }
    }

    private void aWZ() {
        if (this.dYB != null) {
            this.dYB.aWO();
        }
    }

    public void ahL() {
        if (this.dYB != null) {
            this.dYB.aWP();
        }
        kH();
    }

    private void kH() {
        try {
            this.dYD = null;
            removeAllViews();
            this.dYE = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        aWZ();
    }

    /* loaded from: classes8.dex */
    static class a implements b.a {
        AdInfo dYF;
        AdType dYG;
        c dYH;
        final WeakReference<BCAdView> dYJ;

        public a(BCAdView bCAdView) {
            this.dYF = bCAdView.dYF;
            this.dYH = bCAdView.dYH;
            this.dYG = bCAdView.dYG;
            this.dYJ = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void xh(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!aq.isEmpty(str)) {
                this.dYF = AdInfo.jsonToObject(str);
                if (this.dYG == AdType.SPLASH && !aq.isEmpty(this.dYF.adImgUrl)) {
                    com.baidu.adp.lib.e.c.gr().a(this.dYF.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.dYH.xg(str);
                BCAdView bCAdView = this.dYJ.get();
                if (bCAdView != null && (aVar = bCAdView.dYB) != null) {
                    aVar.aWN();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void xi(String str) {
            BCAdView bCAdView = this.dYJ.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.dYB != null) {
                            bCAdView.dYB.a(aVar);
                        }
                    }
                    if (bCAdView.dYG == AdType.SPLASH) {
                        bCAdView.dYH.xg("");
                    } else {
                        bCAdView.ahL();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
