package com.baidu.tieba.advert.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
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
    protected com.baidu.tieba.advert.sdk.a.a fca;
    protected BCAdView fcb;
    protected TbImageView fcc;
    protected AdInfo fcd;
    protected AdInfo fce;
    protected AdType fcf;
    protected c fcg;
    public RedirectType fch;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.fcb = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.fcf = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.fce = new AdInfo();
        this.fce.placeId = this.placeId;
        this.fce.adHeight = this.mHeight;
        this.fce.adWidth = this.mWidth;
        this.fce.typeId = this.fcf;
        b.bqf().a(this.mPageContext, new a(this), this.fce);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.fca = aVar;
        }
    }

    private void bqk() {
        if (this.fca != null) {
            this.fca.bpZ();
        }
    }

    public void axb() {
        if (this.fca != null) {
            this.fca.bqa();
        }
        pX();
    }

    private void pX() {
        try {
            this.fcc = null;
            removeAllViews();
            this.fcd = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bqk();
    }

    /* loaded from: classes10.dex */
    static class a implements b.a {
        AdInfo fce;
        AdType fcf;
        c fcg;
        final WeakReference<BCAdView> fci;

        public a(BCAdView bCAdView) {
            this.fce = bCAdView.fce;
            this.fcg = bCAdView.fcg;
            this.fcf = bCAdView.fcf;
            this.fci = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void AR(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!ar.isEmpty(str)) {
                this.fce = AdInfo.jsonToObject(str);
                if (this.fcf == AdType.SPLASH && !ar.isEmpty(this.fce.adImgUrl)) {
                    com.baidu.adp.lib.e.c.ln().a(this.fce.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.fcg.AQ(str);
                BCAdView bCAdView = this.fci.get();
                if (bCAdView != null && (aVar = bCAdView.fca) != null) {
                    aVar.bpY();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void AS(String str) {
            BCAdView bCAdView = this.fci.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.fca != null) {
                            bCAdView.fca.a(aVar);
                        }
                    }
                    if (bCAdView.fcf == AdType.SPLASH) {
                        bCAdView.fcg.AQ("");
                    } else {
                        bCAdView.axb();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
