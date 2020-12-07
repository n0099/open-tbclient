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
    protected TbImageView gdA;
    protected AdInfo gdB;
    protected AdInfo gdC;
    protected AdType gdD;
    protected c gdE;
    public RedirectType gdF;
    protected com.baidu.tieba.advert.sdk.a.a gdy;
    protected BCAdView gdz;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.gdz = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.gdD = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.gdC = new AdInfo();
        this.gdC.placeId = this.placeId;
        this.gdC.adHeight = this.mHeight;
        this.gdC.adWidth = this.mWidth;
        this.gdC.typeId = this.gdD;
        b.bNv().a(this.mPageContext, new a(this), this.gdC);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.gdy = aVar;
        }
    }

    private void bNA() {
        if (this.gdy != null) {
            this.gdy.bNq();
        }
    }

    public void aSk() {
        if (this.gdy != null) {
            this.gdy.bNr();
        }
        rE();
    }

    private void rE() {
        try {
            this.gdA = null;
            removeAllViews();
            this.gdB = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bNA();
    }

    /* loaded from: classes23.dex */
    static class a implements b.a {
        AdInfo gdC;
        AdType gdD;
        c gdE;
        final WeakReference<BCAdView> gdG;

        public a(BCAdView bCAdView) {
            this.gdC = bCAdView.gdC;
            this.gdE = bCAdView.gdE;
            this.gdD = bCAdView.gdD;
            this.gdG = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Gb(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!au.isEmpty(str)) {
                this.gdC = AdInfo.jsonToObject(str);
                if (this.gdD == AdType.SPLASH && !au.isEmpty(this.gdC.adImgUrl)) {
                    com.baidu.adp.lib.e.c.mS().a(this.gdC.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.gdE.Ga(str);
                BCAdView bCAdView = this.gdG.get();
                if (bCAdView != null && (aVar = bCAdView.gdy) != null) {
                    aVar.bNp();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Gc(String str) {
            BCAdView bCAdView = this.gdG.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.gdy != null) {
                            bCAdView.gdy.a(aVar);
                        }
                    }
                    if (bCAdView.gdD == AdType.SPLASH) {
                        bCAdView.gdE.Ga("");
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
