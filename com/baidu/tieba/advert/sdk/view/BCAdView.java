package com.baidu.tieba.advert.sdk.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.advert.sdk.b.b;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.baidu.tieba.advert.sdk.data.AdType;
import com.baidu.tieba.advert.sdk.data.RedirectType;
import com.baidu.tieba.advert.sdk.data.c;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class BCAdView extends RelativeLayout {
    protected com.baidu.tieba.advert.sdk.a.a fVH;
    protected BCAdView fVI;
    protected TbImageView fVJ;
    protected AdInfo fVK;
    protected AdInfo fVL;
    protected AdType fVM;
    protected c fVN;
    public RedirectType fVO;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.fVI = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.fVM = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.fVL = new AdInfo();
        this.fVL.placeId = this.placeId;
        this.fVL.adHeight = this.mHeight;
        this.fVL.adWidth = this.mWidth;
        this.fVL.typeId = this.fVM;
        b.bKu().a(this.mPageContext, new a(this), this.fVL);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.fVH = aVar;
        }
    }

    private void bKz() {
        if (this.fVH != null) {
            this.fVH.bKp();
        }
    }

    public void aPN() {
        if (this.fVH != null) {
            this.fVH.bKq();
        }
        rC();
    }

    private void rC() {
        try {
            this.fVJ = null;
            removeAllViews();
            this.fVK = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bKz();
    }

    /* loaded from: classes23.dex */
    static class a implements b.a {
        AdInfo fVL;
        AdType fVM;
        c fVN;
        final WeakReference<BCAdView> fVP;

        public a(BCAdView bCAdView) {
            this.fVL = bCAdView.fVL;
            this.fVN = bCAdView.fVN;
            this.fVM = bCAdView.fVM;
            this.fVP = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void FM(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!at.isEmpty(str)) {
                this.fVL = AdInfo.jsonToObject(str);
                if (this.fVM == AdType.SPLASH && !at.isEmpty(this.fVL.adImgUrl)) {
                    com.baidu.adp.lib.e.c.mS().a(this.fVL.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.fVN.FL(str);
                BCAdView bCAdView = this.fVP.get();
                if (bCAdView != null && (aVar = bCAdView.fVH) != null) {
                    aVar.bKo();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void FN(String str) {
            BCAdView bCAdView = this.fVP.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.fVH != null) {
                            bCAdView.fVH.a(aVar);
                        }
                    }
                    if (bCAdView.fVM == AdType.SPLASH) {
                        bCAdView.fVN.FL("");
                    } else {
                        bCAdView.aPN();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
