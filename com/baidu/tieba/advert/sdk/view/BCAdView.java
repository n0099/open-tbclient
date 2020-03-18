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
/* loaded from: classes10.dex */
public class BCAdView extends RelativeLayout {
    protected com.baidu.tieba.advert.sdk.a.a edj;
    protected BCAdView edk;
    protected TbImageView edl;
    protected AdInfo edm;
    protected AdInfo edn;
    protected AdType edo;
    protected c edp;
    public RedirectType edq;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.edk = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.edo = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.edn = new AdInfo();
        this.edn.placeId = this.placeId;
        this.edn.adHeight = this.mHeight;
        this.edn.adWidth = this.mWidth;
        this.edn.typeId = this.edo;
        b.aZq().a(this.mPageContext, new a(this), this.edn);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.edj = aVar;
        }
    }

    private void aZv() {
        if (this.edj != null) {
            this.edj.aZk();
        }
    }

    public void ake() {
        if (this.edj != null) {
            this.edj.aZl();
        }
        kW();
    }

    private void kW() {
        try {
            this.edl = null;
            removeAllViews();
            this.edm = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        aZv();
    }

    /* loaded from: classes10.dex */
    static class a implements b.a {
        AdInfo edn;
        AdType edo;
        c edp;
        final WeakReference<BCAdView> edr;

        public a(BCAdView bCAdView) {
            this.edn = bCAdView.edn;
            this.edp = bCAdView.edp;
            this.edo = bCAdView.edo;
            this.edr = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void xC(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!aq.isEmpty(str)) {
                this.edn = AdInfo.jsonToObject(str);
                if (this.edo == AdType.SPLASH && !aq.isEmpty(this.edn.adImgUrl)) {
                    com.baidu.adp.lib.e.c.gr().a(this.edn.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.edp.xB(str);
                BCAdView bCAdView = this.edr.get();
                if (bCAdView != null && (aVar = bCAdView.edj) != null) {
                    aVar.aZj();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void xD(String str) {
            BCAdView bCAdView = this.edr.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.edj != null) {
                            bCAdView.edj.a(aVar);
                        }
                    }
                    if (bCAdView.edo == AdType.SPLASH) {
                        bCAdView.edp.xB("");
                    } else {
                        bCAdView.ake();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
