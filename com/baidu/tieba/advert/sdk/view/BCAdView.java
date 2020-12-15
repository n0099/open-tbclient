package com.baidu.tieba.advert.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.au;
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
    protected com.baidu.tieba.advert.sdk.a.a gdA;
    protected BCAdView gdB;
    protected TbImageView gdC;
    protected AdInfo gdD;
    protected AdInfo gdE;
    protected AdType gdF;
    protected c gdG;
    public RedirectType gdH;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.gdB = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.gdF = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.gdE = new AdInfo();
        this.gdE.placeId = this.placeId;
        this.gdE.adHeight = this.mHeight;
        this.gdE.adWidth = this.mWidth;
        this.gdE.typeId = this.gdF;
        b.bNw().a(this.mPageContext, new a(this), this.gdE);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.gdA = aVar;
        }
    }

    private void bNB() {
        if (this.gdA != null) {
            this.gdA.bNr();
        }
    }

    public void aSk() {
        if (this.gdA != null) {
            this.gdA.bNs();
        }
        rE();
    }

    private void rE() {
        try {
            this.gdC = null;
            removeAllViews();
            this.gdD = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bNB();
    }

    /* loaded from: classes23.dex */
    static class a implements b.a {
        AdInfo gdE;
        AdType gdF;
        c gdG;
        final WeakReference<BCAdView> gdI;

        public a(BCAdView bCAdView) {
            this.gdE = bCAdView.gdE;
            this.gdG = bCAdView.gdG;
            this.gdF = bCAdView.gdF;
            this.gdI = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Gb(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!au.isEmpty(str)) {
                this.gdE = AdInfo.jsonToObject(str);
                if (this.gdF == AdType.SPLASH && !au.isEmpty(this.gdE.adImgUrl)) {
                    com.baidu.adp.lib.e.c.mS().a(this.gdE.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.gdG.Ga(str);
                BCAdView bCAdView = this.gdI.get();
                if (bCAdView != null && (aVar = bCAdView.gdA) != null) {
                    aVar.bNq();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Gc(String str) {
            BCAdView bCAdView = this.gdI.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.gdA != null) {
                            bCAdView.gdA.a(aVar);
                        }
                    }
                    if (bCAdView.gdF == AdType.SPLASH) {
                        bCAdView.gdG.Ga("");
                    } else {
                        bCAdView.aSk();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
