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
/* loaded from: classes5.dex */
public class BCAdView extends RelativeLayout {
    protected com.baidu.tieba.advert.sdk.a.a dci;
    protected BCAdView dcj;
    protected TbImageView dck;
    protected AdInfo dcl;
    protected AdInfo dcm;
    protected AdType dcn;
    protected c dco;
    public RedirectType dcp;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.dcj = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.dcn = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.dcm = new AdInfo();
        this.dcm.placeId = this.placeId;
        this.dcm.adHeight = this.mHeight;
        this.dcm.adWidth = this.mWidth;
        this.dcm.typeId = this.dcn;
        b.aEA().a(this.mPageContext, new a(this), this.dcm);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.dci = aVar;
        }
    }

    private void aEF() {
        if (this.dci != null) {
            this.dci.aEt();
        }
    }

    public void aEG() {
        if (this.dci != null) {
            this.dci.aEu();
        }
        pu();
    }

    private void pu() {
        try {
            this.dck = null;
            removeAllViews();
            this.dcl = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        aEF();
    }

    /* loaded from: classes5.dex */
    static class a implements b.a {
        AdInfo dcm;
        AdType dcn;
        c dco;
        final WeakReference<BCAdView> dcq;

        public a(BCAdView bCAdView) {
            this.dcm = bCAdView.dcm;
            this.dco = bCAdView.dco;
            this.dcn = bCAdView.dcn;
            this.dcq = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void to(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!aq.isEmpty(str)) {
                this.dcm = AdInfo.jsonToObject(str);
                if (this.dcn == AdType.SPLASH && !aq.isEmpty(this.dcm.adImgUrl)) {
                    com.baidu.adp.lib.f.c.iE().a(this.dcm.adImgUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str2, int i) {
                            super.onLoaded((AnonymousClass1) aVar2, str2, i);
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onProgressUpdate(Object... objArr) {
                            super.onProgressUpdate(objArr);
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            super.onCancelled(str2);
                        }
                    }, 0, 0, null, new Object[0]);
                }
                this.dco.tn(str);
                BCAdView bCAdView = this.dcq.get();
                if (bCAdView != null && (aVar = bCAdView.dci) != null) {
                    aVar.aEs();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void tp(String str) {
            BCAdView bCAdView = this.dcq.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.dci != null) {
                            bCAdView.dci.a(aVar);
                        }
                    }
                    if (bCAdView.dcn == AdType.SPLASH) {
                        bCAdView.dco.tn("");
                    } else {
                        bCAdView.aEG();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
