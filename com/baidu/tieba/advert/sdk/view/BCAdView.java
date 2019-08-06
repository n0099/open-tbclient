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
    protected AdInfo daA;
    protected AdType daB;
    protected c daC;
    public RedirectType daD;
    protected com.baidu.tieba.advert.sdk.a.a dav;
    protected BCAdView daw;
    protected TbImageView dax;
    protected AdInfo daz;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.daw = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.daB = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.daA = new AdInfo();
        this.daA.placeId = this.placeId;
        this.daA.adHeight = this.mHeight;
        this.daA.adWidth = this.mWidth;
        this.daA.typeId = this.daB;
        b.aDW().a(this.mPageContext, new a(this), this.daA);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.dav = aVar;
        }
    }

    private void aEb() {
        if (this.dav != null) {
            this.dav.aDP();
        }
    }

    public void aEc() {
        if (this.dav != null) {
            this.dav.aDQ();
        }
        pt();
    }

    private void pt() {
        try {
            this.dax = null;
            removeAllViews();
            this.daz = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        aEb();
    }

    /* loaded from: classes5.dex */
    static class a implements b.a {
        AdInfo daA;
        AdType daB;
        c daC;
        final WeakReference<BCAdView> daE;

        public a(BCAdView bCAdView) {
            this.daA = bCAdView.daA;
            this.daC = bCAdView.daC;
            this.daB = bCAdView.daB;
            this.daE = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void sP(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!aq.isEmpty(str)) {
                this.daA = AdInfo.jsonToObject(str);
                if (this.daB == AdType.SPLASH && !aq.isEmpty(this.daA.adImgUrl)) {
                    com.baidu.adp.lib.f.c.iE().a(this.daA.adImgUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.daC.sO(str);
                BCAdView bCAdView = this.daE.get();
                if (bCAdView != null && (aVar = bCAdView.dav) != null) {
                    aVar.aDO();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void sQ(String str) {
            BCAdView bCAdView = this.daE.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.dav != null) {
                            bCAdView.dav.a(aVar);
                        }
                    }
                    if (bCAdView.daB == AdType.SPLASH) {
                        bCAdView.daC.sO("");
                    } else {
                        bCAdView.aEc();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
