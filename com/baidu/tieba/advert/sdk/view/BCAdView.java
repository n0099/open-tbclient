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
    protected com.baidu.tieba.advert.sdk.a.a eRE;
    protected BCAdView eRF;
    protected TbImageView eRG;
    protected AdInfo eRH;
    protected AdInfo eRI;
    protected AdType eRJ;
    protected c eRK;
    public RedirectType eRL;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.eRF = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.eRJ = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.eRI = new AdInfo();
        this.eRI.placeId = this.placeId;
        this.eRI.adHeight = this.mHeight;
        this.eRI.adWidth = this.mWidth;
        this.eRI.typeId = this.eRJ;
        b.bnD().a(this.mPageContext, new a(this), this.eRI);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.eRE = aVar;
        }
    }

    private void bnI() {
        if (this.eRE != null) {
            this.eRE.bnx();
        }
    }

    public void avV() {
        if (this.eRE != null) {
            this.eRE.bny();
        }
        pG();
    }

    private void pG() {
        try {
            this.eRG = null;
            removeAllViews();
            this.eRH = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bnI();
    }

    /* loaded from: classes10.dex */
    static class a implements b.a {
        AdInfo eRI;
        AdType eRJ;
        c eRK;
        final WeakReference<BCAdView> eRM;

        public a(BCAdView bCAdView) {
            this.eRI = bCAdView.eRI;
            this.eRK = bCAdView.eRK;
            this.eRJ = bCAdView.eRJ;
            this.eRM = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Ay(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!aq.isEmpty(str)) {
                this.eRI = AdInfo.jsonToObject(str);
                if (this.eRJ == AdType.SPLASH && !aq.isEmpty(this.eRI.adImgUrl)) {
                    com.baidu.adp.lib.e.c.kX().a(this.eRI.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.eRK.Ax(str);
                BCAdView bCAdView = this.eRM.get();
                if (bCAdView != null && (aVar = bCAdView.eRE) != null) {
                    aVar.bnw();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Az(String str) {
            BCAdView bCAdView = this.eRM.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.eRE != null) {
                            bCAdView.eRE.a(aVar);
                        }
                    }
                    if (bCAdView.eRJ == AdType.SPLASH) {
                        bCAdView.eRK.Ax("");
                    } else {
                        bCAdView.avV();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
