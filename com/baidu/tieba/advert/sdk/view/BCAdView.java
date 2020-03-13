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
    protected com.baidu.tieba.advert.sdk.a.a ecT;
    protected BCAdView ecU;
    protected TbImageView ecV;
    protected AdInfo ecW;
    protected AdInfo ecX;
    protected AdType ecY;
    protected c ecZ;
    public RedirectType eda;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.ecU = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.ecY = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.ecX = new AdInfo();
        this.ecX.placeId = this.placeId;
        this.ecX.adHeight = this.mHeight;
        this.ecX.adWidth = this.mWidth;
        this.ecX.typeId = this.ecY;
        b.aZm().a(this.mPageContext, new a(this), this.ecX);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.ecT = aVar;
        }
    }

    private void aZr() {
        if (this.ecT != null) {
            this.ecT.aZg();
        }
    }

    public void akb() {
        if (this.ecT != null) {
            this.ecT.aZh();
        }
        kW();
    }

    private void kW() {
        try {
            this.ecV = null;
            removeAllViews();
            this.ecW = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        aZr();
    }

    /* loaded from: classes10.dex */
    static class a implements b.a {
        AdInfo ecX;
        AdType ecY;
        c ecZ;
        final WeakReference<BCAdView> edb;

        public a(BCAdView bCAdView) {
            this.ecX = bCAdView.ecX;
            this.ecZ = bCAdView.ecZ;
            this.ecY = bCAdView.ecY;
            this.edb = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void xC(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!aq.isEmpty(str)) {
                this.ecX = AdInfo.jsonToObject(str);
                if (this.ecY == AdType.SPLASH && !aq.isEmpty(this.ecX.adImgUrl)) {
                    com.baidu.adp.lib.e.c.gr().a(this.ecX.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.ecZ.xB(str);
                BCAdView bCAdView = this.edb.get();
                if (bCAdView != null && (aVar = bCAdView.ecT) != null) {
                    aVar.aZf();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void xD(String str) {
            BCAdView bCAdView = this.edb.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.ecT != null) {
                            bCAdView.ecT.a(aVar);
                        }
                    }
                    if (bCAdView.ecY == AdType.SPLASH) {
                        bCAdView.ecZ.xB("");
                    } else {
                        bCAdView.akb();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
