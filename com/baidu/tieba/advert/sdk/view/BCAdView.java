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
    protected com.baidu.tieba.advert.sdk.a.a ecG;
    protected BCAdView ecH;
    protected TbImageView ecI;
    protected AdInfo ecJ;
    protected AdInfo ecK;
    protected AdType ecL;
    protected c ecM;
    public RedirectType ecN;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.ecH = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.ecL = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.ecK = new AdInfo();
        this.ecK.placeId = this.placeId;
        this.ecK.adHeight = this.mHeight;
        this.ecK.adWidth = this.mWidth;
        this.ecK.typeId = this.ecL;
        b.aZl().a(this.mPageContext, new a(this), this.ecK);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.ecG = aVar;
        }
    }

    private void aZq() {
        if (this.ecG != null) {
            this.ecG.aZf();
        }
    }

    public void akb() {
        if (this.ecG != null) {
            this.ecG.aZg();
        }
        kW();
    }

    private void kW() {
        try {
            this.ecI = null;
            removeAllViews();
            this.ecJ = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        aZq();
    }

    /* loaded from: classes10.dex */
    static class a implements b.a {
        AdInfo ecK;
        AdType ecL;
        c ecM;
        final WeakReference<BCAdView> ecO;

        public a(BCAdView bCAdView) {
            this.ecK = bCAdView.ecK;
            this.ecM = bCAdView.ecM;
            this.ecL = bCAdView.ecL;
            this.ecO = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void xB(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!aq.isEmpty(str)) {
                this.ecK = AdInfo.jsonToObject(str);
                if (this.ecL == AdType.SPLASH && !aq.isEmpty(this.ecK.adImgUrl)) {
                    com.baidu.adp.lib.e.c.gr().a(this.ecK.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.ecM.xA(str);
                BCAdView bCAdView = this.ecO.get();
                if (bCAdView != null && (aVar = bCAdView.ecG) != null) {
                    aVar.aZe();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void xC(String str) {
            BCAdView bCAdView = this.ecO.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.ecG != null) {
                            bCAdView.ecG.a(aVar);
                        }
                    }
                    if (bCAdView.ecL == AdType.SPLASH) {
                        bCAdView.ecM.xA("");
                    } else {
                        bCAdView.akb();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
