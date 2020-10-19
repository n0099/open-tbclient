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
/* loaded from: classes23.dex */
public class BCAdView extends RelativeLayout {
    protected AdInfo fHA;
    protected AdType fHB;
    protected c fHC;
    public RedirectType fHD;
    protected com.baidu.tieba.advert.sdk.a.a fHw;
    protected BCAdView fHx;
    protected TbImageView fHy;
    protected AdInfo fHz;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.fHx = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.fHB = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.fHA = new AdInfo();
        this.fHA.placeId = this.placeId;
        this.fHA.adHeight = this.mHeight;
        this.fHA.adWidth = this.mWidth;
        this.fHA.typeId = this.fHB;
        b.bGc().a(this.mPageContext, new a(this), this.fHA);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.fHw = aVar;
        }
    }

    private void bGh() {
        if (this.fHw != null) {
            this.fHw.bFX();
        }
    }

    public void aLt() {
        if (this.fHw != null) {
            this.fHw.bFY();
        }
        rC();
    }

    private void rC() {
        try {
            this.fHy = null;
            removeAllViews();
            this.fHz = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bGh();
    }

    /* loaded from: classes23.dex */
    static class a implements b.a {
        AdInfo fHA;
        AdType fHB;
        c fHC;
        final WeakReference<BCAdView> fHE;

        public a(BCAdView bCAdView) {
            this.fHA = bCAdView.fHA;
            this.fHC = bCAdView.fHC;
            this.fHB = bCAdView.fHB;
            this.fHE = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Ff(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!at.isEmpty(str)) {
                this.fHA = AdInfo.jsonToObject(str);
                if (this.fHB == AdType.SPLASH && !at.isEmpty(this.fHA.adImgUrl)) {
                    com.baidu.adp.lib.e.c.mS().a(this.fHA.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.fHC.Fe(str);
                BCAdView bCAdView = this.fHE.get();
                if (bCAdView != null && (aVar = bCAdView.fHw) != null) {
                    aVar.bFW();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Fg(String str) {
            BCAdView bCAdView = this.fHE.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.fHw != null) {
                            bCAdView.fHw.a(aVar);
                        }
                    }
                    if (bCAdView.fHB == AdType.SPLASH) {
                        bCAdView.fHC.Fe("");
                    } else {
                        bCAdView.aLt();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
