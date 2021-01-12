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
/* loaded from: classes7.dex */
public class BCAdView extends RelativeLayout {
    protected com.baidu.tieba.advert.sdk.a.a gik;
    protected BCAdView gil;
    protected TbImageView gim;
    protected AdInfo gin;
    protected AdInfo gio;
    protected AdType gip;
    protected c giq;
    public RedirectType gir;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.gil = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.gip = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.gio = new AdInfo();
        this.gio.placeId = this.placeId;
        this.gio.adHeight = this.mHeight;
        this.gio.adWidth = this.mWidth;
        this.gio.typeId = this.gip;
        b.bLY().a(this.mPageContext, new a(this), this.gio);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.gik = aVar;
        }
    }

    private void bMd() {
        if (this.gik != null) {
            this.gik.bLS();
        }
    }

    public void aQL() {
        if (this.gik != null) {
            this.gik.bLT();
        }
        onAdClose();
    }

    private void onAdClose() {
        try {
            this.gim = null;
            removeAllViews();
            this.gin = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bMd();
    }

    /* loaded from: classes7.dex */
    static class a implements b.a {
        AdInfo gio;
        AdType gip;
        c giq;
        final WeakReference<BCAdView> gis;

        public a(BCAdView bCAdView) {
            this.gio = bCAdView.gio;
            this.giq = bCAdView.giq;
            this.gip = bCAdView.gip;
            this.gis = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void EN(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!at.isEmpty(str)) {
                this.gio = AdInfo.jsonToObject(str);
                if (this.gip == AdType.SPLASH && !at.isEmpty(this.gio.adImgUrl)) {
                    d.mx().a(this.gio.adImgUrl, 10, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.giq.EM(str);
                BCAdView bCAdView = this.gis.get();
                if (bCAdView != null && (aVar = bCAdView.gik) != null) {
                    aVar.bLR();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void EO(String str) {
            BCAdView bCAdView = this.gis.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.gik != null) {
                            bCAdView.gik.a(aVar);
                        }
                    }
                    if (bCAdView.gip == AdType.SPLASH) {
                        bCAdView.giq.EM("");
                    } else {
                        bCAdView.aQL();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
