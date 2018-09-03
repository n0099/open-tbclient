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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class BannerGifView extends RelativeLayout {
    private GifView aGB;
    private ImageView aGC;
    private boolean aGD;
    private com.baidu.tbadk.f.a aGE;
    private com.baidu.tbadk.f.b aGF;
    private final com.baidu.tbadk.f.b aGG;
    private String aff;
    private View axB;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.aGD = false;
        this.aGG = new com.baidu.tbadk.f.b() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.f.b
            public boolean v(View view) {
                if (BannerGifView.this.aGF == null || !BannerGifView.this.aGF.v(view)) {
                    BannerGifView.this.FE();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.aGC) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    public BannerGifView(Context context, float f) {
        super(context);
        this.mRatio = 5.744f;
        this.aGD = false;
        this.aGG = new com.baidu.tbadk.f.b() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.f.b
            public boolean v(View view) {
                if (BannerGifView.this.aGF == null || !BannerGifView.this.aGF.v(view)) {
                    BannerGifView.this.FE();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.aGC) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        this.mRatio = f;
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(f.h.gif_banner_view, this);
        this.aGC = (ImageView) inflate.findViewById(f.g.btn_close);
        this.axB = inflate.findViewById(f.g.image_mask);
        this.aGB = (GifView) inflate.findViewById(f.g.image_gif);
        this.aGB.setShowStaticDrawable(false);
        this.aGB.setSupportNoImage(false);
        this.aGB.setAutoPlay(true);
        this.aGC.setOnClickListener(this.mOnClickListener);
        this.aGB.setOnInterceptClickListener(this.aGG);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.aGB;
    }

    public void am(String str, String str2) {
        this.mPicUrl = str;
        this.aff = str2;
        this.aGB.A(str, 38);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.aGB.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        am.c(this.aGB, i);
    }

    public void setNeedNightMask(boolean z) {
        this.aGD = z;
        et(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.aGC.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aGE = aVar;
    }

    public void setOnClickEventListener(com.baidu.tbadk.f.b bVar) {
        this.aGF = bVar;
    }

    public void onChangeSkinType(int i) {
        am.e(this.axB, f.d.black_alpha30, i);
        et(i);
    }

    private void et(int i) {
        int i2 = 0;
        this.axB.setVisibility((this.aGD && (i == 1)) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FE() {
        try {
            if (!TextUtils.isEmpty(this.aff)) {
                az.zI().c((TbPageContext) i.ad(getContext()), new String[]{this.aff});
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
        if (this.aGE != null) {
            this.aGE.a(this, i == 0, this.mPicUrl);
        }
    }
}
