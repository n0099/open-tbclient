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
    protected com.baidu.tieba.advert.sdk.a.a eDf;
    protected BCAdView eDg;
    protected TbImageView eDh;
    protected AdInfo eDi;
    protected AdInfo eDj;
    protected AdType eDk;
    protected c eDl;
    public RedirectType eDm;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.eDg = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.eDk = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.eDj = new AdInfo();
        this.eDj.placeId = this.placeId;
        this.eDj.adHeight = this.mHeight;
        this.eDj.adWidth = this.mWidth;
        this.eDj.typeId = this.eDk;
        b.bhs().a(this.mPageContext, new a(this), this.eDj);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.eDf = aVar;
        }
    }

    private void bhx() {
        if (this.eDf != null) {
            this.eDf.bhm();
        }
    }

    public void aso() {
        if (this.eDf != null) {
            this.eDf.bhn();
        }
        pA();
    }

    private void pA() {
        try {
            this.eDh = null;
            removeAllViews();
            this.eDi = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bhx();
    }

    /* loaded from: classes10.dex */
    static class a implements b.a {
        AdInfo eDj;
        AdType eDk;
        c eDl;
        final WeakReference<BCAdView> eDn;

        public a(BCAdView bCAdView) {
            this.eDj = bCAdView.eDj;
            this.eDl = bCAdView.eDl;
            this.eDk = bCAdView.eDk;
            this.eDn = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void yS(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!aq.isEmpty(str)) {
                this.eDj = AdInfo.jsonToObject(str);
                if (this.eDk == AdType.SPLASH && !aq.isEmpty(this.eDj.adImgUrl)) {
                    com.baidu.adp.lib.e.c.kV().a(this.eDj.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.eDl.yR(str);
                BCAdView bCAdView = this.eDn.get();
                if (bCAdView != null && (aVar = bCAdView.eDf) != null) {
                    aVar.bhl();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void yT(String str) {
            BCAdView bCAdView = this.eDn.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.eDf != null) {
                            bCAdView.eDf.a(aVar);
                        }
                    }
                    if (bCAdView.eDk == AdType.SPLASH) {
                        bCAdView.eDl.yR("");
                    } else {
                        bCAdView.aso();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
