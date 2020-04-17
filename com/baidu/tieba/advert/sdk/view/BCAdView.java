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
    protected com.baidu.tieba.advert.sdk.a.a eDa;
    protected BCAdView eDb;
    protected TbImageView eDc;
    protected AdInfo eDd;
    protected AdInfo eDe;
    protected AdType eDf;
    protected c eDg;
    public RedirectType eDh;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.eDb = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.eDf = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.eDe = new AdInfo();
        this.eDe.placeId = this.placeId;
        this.eDe.adHeight = this.mHeight;
        this.eDe.adWidth = this.mWidth;
        this.eDe.typeId = this.eDf;
        b.bhu().a(this.mPageContext, new a(this), this.eDe);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.eDa = aVar;
        }
    }

    private void bhz() {
        if (this.eDa != null) {
            this.eDa.bho();
        }
    }

    public void asp() {
        if (this.eDa != null) {
            this.eDa.bhp();
        }
        pA();
    }

    private void pA() {
        try {
            this.eDc = null;
            removeAllViews();
            this.eDd = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bhz();
    }

    /* loaded from: classes10.dex */
    static class a implements b.a {
        AdInfo eDe;
        AdType eDf;
        c eDg;
        final WeakReference<BCAdView> eDi;

        public a(BCAdView bCAdView) {
            this.eDe = bCAdView.eDe;
            this.eDg = bCAdView.eDg;
            this.eDf = bCAdView.eDf;
            this.eDi = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void yP(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!aq.isEmpty(str)) {
                this.eDe = AdInfo.jsonToObject(str);
                if (this.eDf == AdType.SPLASH && !aq.isEmpty(this.eDe.adImgUrl)) {
                    com.baidu.adp.lib.e.c.kV().a(this.eDe.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.eDg.yO(str);
                BCAdView bCAdView = this.eDi.get();
                if (bCAdView != null && (aVar = bCAdView.eDa) != null) {
                    aVar.bhn();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void yQ(String str) {
            BCAdView bCAdView = this.eDi.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.eDa != null) {
                            bCAdView.eDa.a(aVar);
                        }
                    }
                    if (bCAdView.eDf == AdType.SPLASH) {
                        bCAdView.eDg.yO("");
                    } else {
                        bCAdView.asp();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
