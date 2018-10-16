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
    private GifView aOr;
    private ImageView aOs;
    private boolean aOt;
    private com.baidu.tbadk.f.a aOu;
    private com.baidu.tbadk.f.b aOv;
    private final com.baidu.tbadk.f.b aOw;
    private String amC;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.aOt = false;
        this.aOw = new com.baidu.tbadk.f.b() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.f.b
            public boolean F(View view) {
                if (BannerGifView.this.aOv == null || !BannerGifView.this.aOv.F(view)) {
                    BannerGifView.this.IV();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.aOs) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    public BannerGifView(Context context, float f) {
        super(context);
        this.mRatio = 5.744f;
        this.aOt = false;
        this.aOw = new com.baidu.tbadk.f.b() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.f.b
            public boolean F(View view) {
                if (BannerGifView.this.aOv == null || !BannerGifView.this.aOv.F(view)) {
                    BannerGifView.this.IV();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.aOs) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        this.mRatio = f;
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.gif_banner_view, this);
        this.aOs = (ImageView) inflate.findViewById(e.g.btn_close);
        this.mMaskView = inflate.findViewById(e.g.image_mask);
        this.aOr = (GifView) inflate.findViewById(e.g.image_gif);
        this.aOr.setShowStaticDrawable(false);
        this.aOr.setSupportNoImage(false);
        this.aOr.setAutoPlay(true);
        this.aOs.setOnClickListener(this.mOnClickListener);
        this.aOr.setOnInterceptClickListener(this.aOw);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.aOr;
    }

    public void aF(String str, String str2) {
        this.mPicUrl = str;
        this.amC = str2;
        this.aOr.G(str, 38);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.aOr.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        al.c(this.aOr, i);
    }

    public void setNeedNightMask(boolean z) {
        this.aOt = z;
        eO(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.aOs.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aOu = aVar;
    }

    public void setOnClickEventListener(com.baidu.tbadk.f.b bVar) {
        this.aOv = bVar;
    }

    public void onChangeSkinType(int i) {
        al.e(this.mMaskView, e.d.black_alpha30, i);
        eO(i);
    }

    private void eO(int i) {
        int i2 = 0;
        this.mMaskView.setVisibility((this.aOt && (i == 1)) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IV() {
        try {
            if (!TextUtils.isEmpty(this.amC)) {
                ay.CU().c((TbPageContext) i.aK(getContext()), new String[]{this.amC});
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
        if (this.aOu != null) {
            this.aOu.a(this, i == 0, this.mPicUrl);
        }
    }
}
