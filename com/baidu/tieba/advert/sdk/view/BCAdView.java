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
    protected com.baidu.tieba.advert.sdk.a.a fsb;
    protected BCAdView fsc;
    protected TbImageView fsd;
    protected AdInfo fse;
    protected AdInfo fsf;
    protected AdType fsg;
    protected c fsh;
    public RedirectType fsi;
    protected Context mContext;
    protected int mHeight;
    protected TbPageContext<?> mPageContext;
    protected int mWidth;
    protected String placeId;

    public BCAdView(TbPageContext<?> tbPageContext, String str, AdType adType, int i, int i2) {
        super(tbPageContext.getPageActivity());
        this.mPageContext = tbPageContext;
        this.fsc = this;
        this.mContext = tbPageContext.getPageActivity();
        this.placeId = str;
        this.fsg = adType;
        this.mHeight = i;
        this.mWidth = i2;
    }

    public void loadAd() {
        this.fsf = new AdInfo();
        this.fsf.placeId = this.placeId;
        this.fsf.adHeight = this.mHeight;
        this.fsf.adWidth = this.mWidth;
        this.fsf.typeId = this.fsg;
        b.bCe().a(this.mPageContext, new a(this), this.fsf);
    }

    public void setBCAdCallBack(com.baidu.tieba.advert.sdk.a.a aVar) {
        if (aVar != null) {
            this.fsb = aVar;
        }
    }

    private void bCj() {
        if (this.fsb != null) {
            this.fsb.bBZ();
        }
    }

    public void aHZ() {
        if (this.fsb != null) {
            this.fsb.bCa();
        }
        rx();
    }

    private void rx() {
        try {
            this.fsd = null;
            removeAllViews();
            this.fse = null;
        } catch (Exception e) {
            BdLog.e("Ad close failed" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bCj();
    }

    /* loaded from: classes17.dex */
    static class a implements b.a {
        AdInfo fsf;
        AdType fsg;
        c fsh;
        final WeakReference<BCAdView> fsj;

        public a(BCAdView bCAdView) {
            this.fsf = bCAdView.fsf;
            this.fsh = bCAdView.fsh;
            this.fsg = bCAdView.fsg;
            this.fsj = new WeakReference<>(bCAdView);
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void DX(String str) {
            com.baidu.tieba.advert.sdk.a.a aVar;
            if (!at.isEmpty(str)) {
                this.fsf = AdInfo.jsonToObject(str);
                if (this.fsg == AdType.SPLASH && !at.isEmpty(this.fsf.adImgUrl)) {
                    com.baidu.adp.lib.e.c.mM().a(this.fsf.adImgUrl, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.advert.sdk.view.BCAdView.a.1
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
                this.fsh.DW(str);
                BCAdView bCAdView = this.fsj.get();
                if (bCAdView != null && (aVar = bCAdView.fsb) != null) {
                    aVar.bBY();
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.b.b.a
        public void DY(String str) {
            BCAdView bCAdView = this.fsj.get();
            if (bCAdView != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.tieba.advert.sdk.data.a aVar = new com.baidu.tieba.advert.sdk.data.a(new JSONObject(str));
                        if (bCAdView.fsb != null) {
                            bCAdView.fsb.a(aVar);
                        }
                    }
                    if (bCAdView.fsg == AdType.SPLASH) {
                        bCAdView.fsh.DW("");
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
