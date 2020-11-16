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
/* loaded from: classes22.dex */
public class BCAdView extends RelativeLayout {
    protected com.baidu.tieba.advert.sdk.a.a fVo;
    protected BCAdView fVp;
    protected TbImageView fVq;
    protected AdInfo fVr;
    protected AdInfo fVs;
    protected AdType fVt;
    protected c fVu;
    public RedirectType fVv;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.fVp = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.fVt = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.fVs = new AdInfo();
        this.fVs.placeId = this.placeId;
        this.fVs.adHeight = this.mHeight;
        this.fVs.adWidth = this.mWidth;
        this.fVs.typeId = this.fVt;
        b.bJN().a(this.mPageContext, new a(this), this.fVs);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.fVo = aVar;
        }
    }

    private void bJS() {
        if (this.fVo != null) {
            this.fVo.bJI();
        }
    }

    public void aPf() {
        if (this.fVo != null) {
            this.fVo.bJJ();
        }
        rC();
    }

    private void rC() {
        try {
            this.fVq = null;
            removeAllViews();
            this.fVr = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bJS();
    }

    /* loaded from: classes22.dex */
    static class a implements b.a {
        AdInfo fVs;
        AdType fVt;
        c fVu;
        final WeakReference<BCAdView> fVw;

        public a(BCAdView bCAdView) {
            this.fVs = bCAdView.fVs;
            this.fVu = bCAdView.fVu;
            this.fVt = bCAdView.fVt;
            this.fVw = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Fn(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!au.isEmpty(str)) {
                this.fVs = AdInfo.jsonToObject(str);
                if (this.fVt == AdType.SPLASH && !au.isEmpty(this.fVs.adImgUrl)) {
                    com.baidu.adp.lib.e.c.mS().a(this.fVs.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.fVu.Fm(str);
                BCAdView bCAdView = this.fVw.get();
                if (bCAdView != null && (aVar = bCAdView.fVo) != null) {
                    aVar.bJH();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void Fo(String str) {
            BCAdView bCAdView = this.fVw.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.fVo != null) {
                            bCAdView.fVo.a(aVar);
                        }
                    }
                    if (bCAdView.fVt == AdType.SPLASH) {
                        bCAdView.fVu.Fm("");
                    } else {
                        bCAdView.aPf();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
