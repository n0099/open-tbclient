package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.base.i;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class BannerGifView extends RelativeLayout {
    private GifView aPh;
    private ImageView aPi;
    private boolean aPj;
    private com.baidu.tbadk.f.a aPk;
    private com.baidu.tbadk.f.b aPl;
    private final com.baidu.tbadk.f.b aPm;
    private String anp;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.aPj = false;
        this.aPm = new com.baidu.tbadk.f.b() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.f.b
            public boolean F(View view) {
                if (BannerGifView.this.aPl == null || !BannerGifView.this.aPl.F(view)) {
                    BannerGifView.this.Jh();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.aPi) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    public BannerGifView(Context context, float f) {
        super(context);
        this.mRatio = 5.744f;
        this.aPj = false;
        this.aPm = new com.baidu.tbadk.f.b() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.f.b
            public boolean F(View view) {
                if (BannerGifView.this.aPl == null || !BannerGifView.this.aPl.F(view)) {
                    BannerGifView.this.Jh();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.aPi) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        this.mRatio = f;
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.gif_banner_view, this);
        this.aPi = (ImageView) inflate.findViewById(e.g.btn_close);
        this.mMaskView = inflate.findViewById(e.g.image_mask);
        this.aPh = (GifView) inflate.findViewById(e.g.image_gif);
        this.aPh.setShowStaticDrawable(false);
        this.aPh.setSupportNoImage(false);
        this.aPh.setAutoPlay(true);
        this.aPi.setOnClickListener(this.mOnClickListener);
        this.aPh.setOnInterceptClickListener(this.aPm);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.aPh;
    }

    public void aF(String str, String str2) {
        this.mPicUrl = str;
        this.anp = str2;
        this.aPh.G(str, 38);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.aPh.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        al.c(this.aPh, i);
    }

    public void setNeedNightMask(boolean z) {
        this.aPj = z;
        fc(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.aPi.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aPk = aVar;
    }

    public void setOnClickEventListener(com.baidu.tbadk.f.b bVar) {
        this.aPl = bVar;
    }

    public void onChangeSkinType(int i) {
        al.e(this.mMaskView, e.d.black_alpha30, i);
        fc(i);
    }

    private void fc(int i) {
        int i2 = 0;
        this.mMaskView.setVisibility((this.aPj && (i == 1)) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh() {
        try {
            if (!TextUtils.isEmpty(this.anp)) {
                ay.Db().c((TbPageContext) i.aK(getContext()), new String[]{this.anp});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        View.MeasureSpec.getMode(i);
        View.MeasureSpec.getMode(i2);
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i2) - getPaddingBottom()) - getPaddingTop();
        if (this.mRatio > 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) ((size / this.mRatio) + 0.5f), AiAppsFileUtils.GB);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aPk != null) {
            this.aPk.a(this, i == 0, this.mPicUrl);
        }
    }
}
