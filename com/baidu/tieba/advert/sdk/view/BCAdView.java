package com.baidu.tieba.advert.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.e.d;
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
/* loaded from: classes8.dex */
public class BCAdView extends RelativeLayout {
    protected com.baidu.tieba.advert.sdk.a.a gkQ;
    protected BCAdView gkR;
    protected TbImageView gkS;
    protected AdInfo gkT;
    protected AdInfo gkU;
    protected AdType gkV;
    protected c gkW;
    public RedirectType gkX;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.gkR = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.gkV = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.gkU = new AdInfo();
        this.gkU.placeId = this.placeId;
        this.gkU.adHeight = this.mHeight;
        this.gkU.adWidth = this.mWidth;
        this.gkU.typeId = this.gkV;
        b.bMy().a(this.mPageContext, new a(this), this.gkU);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.gkQ = aVar;
        }
    }

    private void bME() {
        if (this.gkQ != null) {
            this.gkQ.bMm();
        }
    }

    public void aRc() {
        if (this.gkQ != null) {
            this.gkQ.bMn();
        }
        onAdClose();
    }

    private void onAdClose() {
        try {
            this.gkS = null;
            removeAllViews();
            this.gkT = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bME();
    }

    /* loaded from: classes8.dex */
    static class a implements b.a {
        AdInfo gkU;
        AdType gkV;
        c gkW;
        final WeakReference<BCAdView> gkY;

        public a(BCAdView bCAdView) {
            this.gkU = bCAdView.gkU;
            this.gkW = bCAdView.gkW;
            this.gkV = bCAdView.gkV;
            this.gkY = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Fl(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!au.isEmpty(str)) {
                this.gkU = AdInfo.jsonToObject(str);
                if (this.gkV == AdType.SPLASH && !au.isEmpty(this.gkU.adImgUrl)) {
                    d.mw().a(this.gkU.adImgUrl, 10, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.gkW.Fk(str);
                BCAdView bCAdView = this.gkY.get();
                if (bCAdView != null && (aVar = bCAdView.gkQ) != null) {
                    aVar.bMl();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Fm(String str) {
            BCAdView bCAdView = this.gkY.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.gkQ != null) {
                            bCAdView.gkQ.a(aVar);
                        }
                    }
                    if (bCAdView.gkV == AdType.SPLASH) {
                        bCAdView.gkW.Fk("");
                    } else {
                        bCAdView.aRc();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
