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
/* loaded from: classes7.dex */
public class BCAdView extends RelativeLayout {
    protected com.baidu.tieba.advert.sdk.a.a dYs;
    protected BCAdView dYt;
    protected TbImageView dYu;
    protected AdInfo dYv;
    protected AdInfo dYw;
    protected AdType dYx;
    protected c dYy;
    public RedirectType dYz;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.dYt = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.dYx = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.dYw = new AdInfo();
        this.dYw.placeId = this.placeId;
        this.dYw.adHeight = this.mHeight;
        this.dYw.adWidth = this.mWidth;
        this.dYw.typeId = this.dYx;
        b.aWA().a(this.mPageContext, new a(this), this.dYw);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.dYs = aVar;
        }
    }

    private void aWF() {
        if (this.dYs != null) {
            this.dYs.aWu();
        }
    }

    public void ahs() {
        if (this.dYs != null) {
            this.dYs.aWv();
        }
        kG();
    }

    private void kG() {
        try {
            this.dYu = null;
            removeAllViews();
            this.dYv = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        aWF();
    }

    /* loaded from: classes7.dex */
    static class a implements b.a {
        final WeakReference<BCAdView> dYA;
        AdInfo dYw;
        AdType dYx;
        c dYy;

        public a(BCAdView bCAdView) {
            this.dYw = bCAdView.dYw;
            this.dYy = bCAdView.dYy;
            this.dYx = bCAdView.dYx;
            this.dYA = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void xd(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!aq.isEmpty(str)) {
                this.dYw = AdInfo.jsonToObject(str);
                if (this.dYx == AdType.SPLASH && !aq.isEmpty(this.dYw.adImgUrl)) {
                    com.baidu.adp.lib.e.c.gs().a(this.dYw.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.dYy.xc(str);
                BCAdView bCAdView = this.dYA.get();
                if (bCAdView != null && (aVar = bCAdView.dYs) != null) {
                    aVar.aWt();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void xe(String str) {
            BCAdView bCAdView = this.dYA.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.dYs != null) {
                            bCAdView.dYs.a(aVar);
                        }
                    }
                    if (bCAdView.dYx == AdType.SPLASH) {
                        bCAdView.dYy.xc("");
                    } else {
                        bCAdView.ahs();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
