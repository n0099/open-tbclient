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
    protected com.baidu.tieba.advert.sdk.a.a dao;
    protected BCAdView dap;
    protected TbImageView daq;
    protected AdInfo dar;
    protected AdInfo das;
    protected AdType dat;
    protected c dau;
    public RedirectType dav;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.dap = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.dat = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.das = new AdInfo();
        this.das.placeId = this.placeId;
        this.das.adHeight = this.mHeight;
        this.das.adWidth = this.mWidth;
        this.das.typeId = this.dat;
        b.aDU().a(this.mPageContext, new a(this), this.das);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.dao = aVar;
        }
    }

    private void aDZ() {
        if (this.dao != null) {
            this.dao.aDN();
        }
    }

    public void aEa() {
        if (this.dao != null) {
            this.dao.aDO();
        }
        pt();
    }

    private void pt() {
        try {
            this.daq = null;
            removeAllViews();
            this.dar = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        aDZ();
    }

    /* loaded from: classes5.dex */
    static class a implements b.a {
        AdInfo das;
        AdType dat;
        c dau;
        final WeakReference<BCAdView> daw;

        public a(BCAdView bCAdView) {
            this.das = bCAdView.das;
            this.dau = bCAdView.dau;
            this.dat = bCAdView.dat;
            this.daw = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void sP(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!aq.isEmpty(str)) {
                this.das = AdInfo.jsonToObject(str);
                if (this.dat == AdType.SPLASH && !aq.isEmpty(this.das.adImgUrl)) {
                    com.baidu.adp.lib.f.c.iE().a(this.das.adImgUrl, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.dau.sO(str);
                BCAdView bCAdView = this.daw.get();
                if (bCAdView != null && (aVar = bCAdView.dao) != null) {
                    aVar.aDM();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void sQ(String str) {
            BCAdView bCAdView = this.daw.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.dao != null) {
                            bCAdView.dao.a(aVar);
                        }
                    }
                    if (bCAdView.dat == AdType.SPLASH) {
                        bCAdView.dau.sO("");
                    } else {
                        bCAdView.aEa();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
