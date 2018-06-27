package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.base.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class BannerGifView extends RelativeLayout {
    private GifView aGC;
    private ImageView aGD;
    private boolean aGE;
    private com.baidu.tbadk.e.a aGF;
    private com.baidu.tbadk.e.b aGG;
    private final com.baidu.tbadk.e.b aGH;
    private String afL;
    private View axY;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.aGE = false;
        this.aGH = new com.baidu.tbadk.e.b() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.e.b
            public boolean v(View view) {
                if (BannerGifView.this.aGG == null || !BannerGifView.this.aGG.v(view)) {
                    BannerGifView.this.FI();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.aGD) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    public BannerGifView(Context context, float f) {
        super(context);
        this.mRatio = 5.744f;
        this.aGE = false;
        this.aGH = new com.baidu.tbadk.e.b() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.e.b
            public boolean v(View view) {
                if (BannerGifView.this.aGG == null || !BannerGifView.this.aGG.v(view)) {
                    BannerGifView.this.FI();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.aGD) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        this.mRatio = f;
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.i.gif_banner_view, this);
        this.aGD = (ImageView) inflate.findViewById(d.g.btn_close);
        this.axY = inflate.findViewById(d.g.image_mask);
        this.aGC = (GifView) inflate.findViewById(d.g.image_gif);
        this.aGC.setShowStaticDrawable(false);
        this.aGC.setSupportNoImage(false);
        this.aGC.setAutoPlay(true);
        this.aGD.setOnClickListener(this.mOnClickListener);
        this.aGC.setOnInterceptClickListener(this.aGH);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.aGC;
    }

    public void ap(String str, String str2) {
        this.mPicUrl = str;
        this.afL = str2;
        this.aGC.E(str, 38);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.aGC.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        am.c(this.aGC, i);
    }

    public void setNeedNightMask(boolean z) {
        this.aGE = z;
        er(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.aGD.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.e.a aVar) {
        this.aGF = aVar;
    }

    public void setOnClickEventListener(com.baidu.tbadk.e.b bVar) {
        this.aGG = bVar;
    }

    public void onChangeSkinType(int i) {
        am.e(this.axY, d.C0142d.black_alpha30, i);
        er(i);
    }

    private void er(int i) {
        int i2 = 0;
        this.axY.setVisibility((this.aGE && (i == 1)) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FI() {
        try {
            if (!TextUtils.isEmpty(this.afL)) {
                az.zV().c((TbPageContext) i.ad(getContext()), new String[]{this.afL});
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
            i2 = View.MeasureSpec.makeMeasureSpec((int) ((size / this.mRatio) + 0.5f), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.aGF != null) {
            this.aGF.a(this, i == 0, this.mPicUrl);
        }
    }
}
