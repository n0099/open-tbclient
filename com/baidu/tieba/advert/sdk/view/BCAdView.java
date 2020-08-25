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
/* loaded from: classes17.dex */
public class BCAdView extends RelativeLayout {
    protected com.baidu.tieba.advert.sdk.a.a frX;
    protected BCAdView frY;
    protected TbImageView frZ;
    protected AdInfo fsa;
    protected AdInfo fsb;
    protected AdType fsc;
    protected c fsd;
    public RedirectType fse;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.frY = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.fsc = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.fsb = new AdInfo();
        this.fsb.placeId = this.placeId;
        this.fsb.adHeight = this.mHeight;
        this.fsb.adWidth = this.mWidth;
        this.fsb.typeId = this.fsc;
        b.bCd().a(this.mPageContext, new a(this), this.fsb);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.frX = aVar;
        }
    }

    private void bCi() {
        if (this.frX != null) {
            this.frX.bBY();
        }
    }

    public void aHZ() {
        if (this.frX != null) {
            this.frX.bBZ();
        }
        rx();
    }

    private void rx() {
        try {
            this.frZ = null;
            removeAllViews();
            this.fsa = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bCi();
    }

    /* loaded from: classes17.dex */
    static class a implements b.a {
        AdInfo fsb;
        AdType fsc;
        c fsd;
        final WeakReference<BCAdView> fsf;

        public a(BCAdView bCAdView) {
            this.fsb = bCAdView.fsb;
            this.fsd = bCAdView.fsd;
            this.fsc = bCAdView.fsc;
            this.fsf = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void DW(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!at.isEmpty(str)) {
                this.fsb = AdInfo.jsonToObject(str);
                if (this.fsc == AdType.SPLASH && !at.isEmpty(this.fsb.adImgUrl)) {
                    com.baidu.adp.lib.e.c.mM().a(this.fsb.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.fsd.DV(str);
                BCAdView bCAdView = this.fsf.get();
                if (bCAdView != null && (aVar = bCAdView.frX) != null) {
                    aVar.bBX();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void DX(String str) {
            BCAdView bCAdView = this.fsf.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.frX != null) {
                            bCAdView.frX.a(aVar);
                        }
                    }
                    if (bCAdView.fsc == AdType.SPLASH) {
                        bCAdView.fsd.DV("");
                    } else {
                        bCAdView.aHZ();
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }
}
