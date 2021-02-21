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
    protected com.baidu.tieba.advert.sdk.a.a gle;
    protected BCAdView glf;
    protected TbImageView glg;
    protected AdInfo glh;
    protected AdInfo gli;
    protected AdType glj;
    protected c glk;
    public RedirectType gll;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.glf = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.glj = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.gli = new AdInfo();
        this.gli.placeId = this.placeId;
        this.gli.adHeight = this.mHeight;
        this.gli.adWidth = this.mWidth;
        this.gli.typeId = this.glj;
        b.bMF().a(this.mPageContext, new a(this), this.gli);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.gle = aVar;
        }
    }

    private void bML() {
        if (this.gle != null) {
            this.gle.bMt();
        }
    }

    public void aRc() {
        if (this.gle != null) {
            this.gle.bMu();
        }
        onAdClose();
    }

    private void onAdClose() {
        try {
            this.glg = null;
            removeAllViews();
            this.glh = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bML();
    }

    /* loaded from: classes8.dex */
    static class a implements b.a {
        AdInfo gli;
        AdType glj;
        c glk;
        final WeakReference<BCAdView> glm;

        public a(BCAdView bCAdView) {
            this.gli = bCAdView.gli;
            this.glk = bCAdView.glk;
            this.glj = bCAdView.glj;
            this.glm = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Fm(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!au.isEmpty(str)) {
                this.gli = AdInfo.jsonToObject(str);
                if (this.glj == AdType.SPLASH && !au.isEmpty(this.gli.adImgUrl)) {
                    d.mw().a(this.gli.adImgUrl, 10, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.glk.Fl(str);
                BCAdView bCAdView = this.glm.get();
                if (bCAdView != null && (aVar = bCAdView.gle) != null) {
                    aVar.bMs();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Fn(String str) {
            BCAdView bCAdView = this.glm.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.gle != null) {
                            bCAdView.gle.a(aVar);
                        }
                    }
                    if (bCAdView.glj == AdType.SPLASH) {
                        bCAdView.glk.Fl("");
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
