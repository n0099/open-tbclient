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
    protected com.baidu.tieba.advert.sdk.a.a fPR;
    protected BCAdView fPS;
    protected TbImageView fPT;
    protected AdInfo fPU;
    protected AdInfo fPV;
    protected AdType fPW;
    protected c fPX;
    public RedirectType fPY;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.fPS = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.fPW = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.fPV = new AdInfo();
        this.fPV.placeId = this.placeId;
        this.fPV.adHeight = this.mHeight;
        this.fPV.adWidth = this.mWidth;
        this.fPV.typeId = this.fPW;
        b.bHV().a(this.mPageContext, new a(this), this.fPV);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.fPR = aVar;
        }
    }

    private void bIa() {
        if (this.fPR != null) {
            this.fPR.bHQ();
        }
    }

    public void aNn() {
        if (this.fPR != null) {
            this.fPR.bHR();
        }
        rC();
    }

    private void rC() {
        try {
            this.fPT = null;
            removeAllViews();
            this.fPU = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bIa();
    }

    /* loaded from: classes23.dex */
    static class a implements b.a {
        AdInfo fPV;
        AdType fPW;
        c fPX;
        final WeakReference<BCAdView> fPZ;

        public a(BCAdView bCAdView) {
            this.fPV = bCAdView.fPV;
            this.fPX = bCAdView.fPX;
            this.fPW = bCAdView.fPW;
            this.fPZ = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Fy(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!at.isEmpty(str)) {
                this.fPV = AdInfo.jsonToObject(str);
                if (this.fPW == AdType.SPLASH && !at.isEmpty(this.fPV.adImgUrl)) {
                    com.baidu.adp.lib.e.c.mS().a(this.fPV.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.fPX.Fx(str);
                BCAdView bCAdView = this.fPZ.get();
                if (bCAdView != null && (aVar = bCAdView.fPR) != null) {
                    aVar.bHP();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Fz(String str) {
            BCAdView bCAdView = this.fPZ.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.fPR != null) {
                            bCAdView.fPR.a(aVar);
                        }
                    }
                    if (bCAdView.fPW == AdType.SPLASH) {
                        bCAdView.fPX.Fx("");
                    } else {
                        bCAdView.aNn();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
