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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class BannerGifView extends RelativeLayout {
    private View aAH;
    private GifView aJP;
    private ImageView aJQ;
    private boolean aJR;
    private com.baidu.tbadk.f.a aJS;
    private com.baidu.tbadk.f.b aJT;
    private final com.baidu.tbadk.f.b aJU;
    private String ahG;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.aJR = false;
        this.aJU = new com.baidu.tbadk.f.b() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.f.b
            public boolean F(View view) {
                if (BannerGifView.this.aJT == null || !BannerGifView.this.aJT.F(view)) {
                    BannerGifView.this.GU();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.aJQ) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    public BannerGifView(Context context, float f) {
        super(context);
        this.mRatio = 5.744f;
        this.aJR = false;
        this.aJU = new com.baidu.tbadk.f.b() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.f.b
            public boolean F(View view) {
                if (BannerGifView.this.aJT == null || !BannerGifView.this.aJT.F(view)) {
                    BannerGifView.this.GU();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.aJQ) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        this.mRatio = f;
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.gif_banner_view, this);
        this.aJQ = (ImageView) inflate.findViewById(e.g.btn_close);
        this.aAH = inflate.findViewById(e.g.image_mask);
        this.aJP = (GifView) inflate.findViewById(e.g.image_gif);
        this.aJP.setShowStaticDrawable(false);
        this.aJP.setSupportNoImage(false);
        this.aJP.setAutoPlay(true);
        this.aJQ.setOnClickListener(this.mOnClickListener);
        this.aJP.setOnInterceptClickListener(this.aJU);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.aJP;
    }

    public void au(String str, String str2) {
        this.mPicUrl = str;
        this.ahG = str2;
        this.aJP.F(str, 38);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.aJP.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        al.c(this.aJP, i);
    }

    public void setNeedNightMask(boolean z) {
        this.aJR = z;
        eF(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.aJQ.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aJS = aVar;
    }

    public void setOnClickEventListener(com.baidu.tbadk.f.b bVar) {
        this.aJT = bVar;
    }

    public void onChangeSkinType(int i) {
        al.e(this.aAH, e.d.black_alpha30, i);
        eF(i);
    }

    private void eF(int i) {
        int i2 = 0;
        this.aAH.setVisibility((this.aJR && (i == 1)) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU() {
        try {
            if (!TextUtils.isEmpty(this.ahG)) {
                ay.AN().c((TbPageContext) i.aK(getContext()), new String[]{this.ahG});
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
        if (this.aJS != null) {
            this.aJS.a(this, i == 0, this.mPicUrl);
        }
    }
}
