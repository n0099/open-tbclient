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
    protected com.baidu.tieba.advert.sdk.a.a ecF;
    protected BCAdView ecG;
    protected TbImageView ecH;
    protected AdInfo ecI;
    protected AdInfo ecJ;
    protected AdType ecK;
    protected c ecL;
    public RedirectType ecM;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.ecG = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.ecK = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.ecJ = new AdInfo();
        this.ecJ.placeId = this.placeId;
        this.ecJ.adHeight = this.mHeight;
        this.ecJ.adWidth = this.mWidth;
        this.ecJ.typeId = this.ecK;
        b.aZj().a(this.mPageContext, new a(this), this.ecJ);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.ecF = aVar;
        }
    }

    private void aZo() {
        if (this.ecF != null) {
            this.ecF.aZd();
        }
    }

    public void ajZ() {
        if (this.ecF != null) {
            this.ecF.aZe();
        }
        kW();
    }

    private void kW() {
        try {
            this.ecH = null;
            removeAllViews();
            this.ecI = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        aZo();
    }

    /* loaded from: classes10.dex */
    static class a implements b.a {
        AdInfo ecJ;
        AdType ecK;
        c ecL;
        final WeakReference<BCAdView> ecN;

        public a(BCAdView bCAdView) {
            this.ecJ = bCAdView.ecJ;
            this.ecL = bCAdView.ecL;
            this.ecK = bCAdView.ecK;
            this.ecN = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void xB(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!aq.isEmpty(str)) {
                this.ecJ = AdInfo.jsonToObject(str);
                if (this.ecK == AdType.SPLASH && !aq.isEmpty(this.ecJ.adImgUrl)) {
                    com.baidu.adp.lib.e.c.gr().a(this.ecJ.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.ecL.xA(str);
                BCAdView bCAdView = this.ecN.get();
                if (bCAdView != null && (aVar = bCAdView.ecF) != null) {
                    aVar.aZc();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void xC(String str) {
            BCAdView bCAdView = this.ecN.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.ecF != null) {
                            bCAdView.ecF.a(aVar);
                        }
                    }
                    if (bCAdView.ecK == AdType.SPLASH) {
                        bCAdView.ecL.xA("");
                    } else {
                        bCAdView.ajZ();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
