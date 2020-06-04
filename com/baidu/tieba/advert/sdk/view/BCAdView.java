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
    protected com.baidu.tieba.advert.sdk.a.a eRP;
    protected BCAdView eRQ;
    protected TbImageView eRR;
    protected AdInfo eRS;
    protected AdInfo eRT;
    protected AdType eRU;
    protected c eRV;
    public RedirectType eRW;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.eRQ = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.eRU = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.eRT = new AdInfo();
        this.eRT.placeId = this.placeId;
        this.eRT.adHeight = this.mHeight;
        this.eRT.adWidth = this.mWidth;
        this.eRT.typeId = this.eRU;
        b.bnF().a(this.mPageContext, new a(this), this.eRT);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.eRP = aVar;
        }
    }

    private void bnK() {
        if (this.eRP != null) {
            this.eRP.bnz();
        }
    }

    public void avV() {
        if (this.eRP != null) {
            this.eRP.bnA();
        }
        pG();
    }

    private void pG() {
        try {
            this.eRR = null;
            removeAllViews();
            this.eRS = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bnK();
    }

    /* loaded from: classes10.dex */
    static class a implements b.a {
        AdInfo eRT;
        AdType eRU;
        c eRV;
        final WeakReference<BCAdView> eRX;

        public a(BCAdView bCAdView) {
            this.eRT = bCAdView.eRT;
            this.eRV = bCAdView.eRV;
            this.eRU = bCAdView.eRU;
            this.eRX = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Ay(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!aq.isEmpty(str)) {
                this.eRT = AdInfo.jsonToObject(str);
                if (this.eRU == AdType.SPLASH && !aq.isEmpty(this.eRT.adImgUrl)) {
                    com.baidu.adp.lib.e.c.kX().a(this.eRT.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.eRV.Ax(str);
                BCAdView bCAdView = this.eRX.get();
                if (bCAdView != null && (aVar = bCAdView.eRP) != null) {
                    aVar.bny();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Az(String str) {
            BCAdView bCAdView = this.eRX.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.eRP != null) {
                            bCAdView.eRP.a(aVar);
                        }
                    }
                    if (bCAdView.eRU == AdType.SPLASH) {
                        bCAdView.eRV.Ax("");
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
