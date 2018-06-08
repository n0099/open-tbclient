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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class BannerGifView extends RelativeLayout {
    private GifView aFJ;
    private ImageView aFK;
    private View aFL;
    private boolean aFM;
    private com.baidu.tbadk.e.a aFN;
    private com.baidu.tbadk.e.b aFO;
    private final com.baidu.tbadk.e.b aFP;
    private String afw;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.aFM = false;
        this.aFP = new com.baidu.tbadk.e.b() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.e.b
            public boolean v(View view) {
                if (BannerGifView.this.aFO == null || !BannerGifView.this.aFO.v(view)) {
                    BannerGifView.this.Fq();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.aFK) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    public BannerGifView(Context context, float f) {
        super(context);
        this.mRatio = 5.744f;
        this.aFM = false;
        this.aFP = new com.baidu.tbadk.e.b() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.e.b
            public boolean v(View view) {
                if (BannerGifView.this.aFO == null || !BannerGifView.this.aFO.v(view)) {
                    BannerGifView.this.Fq();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.aFK) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        this.mRatio = f;
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.i.gif_banner_view, this);
        this.aFK = (ImageView) inflate.findViewById(d.g.btn_close);
        this.aFL = inflate.findViewById(d.g.image_mask);
        this.aFJ = (GifView) inflate.findViewById(d.g.image_gif);
        this.aFJ.setShowStaticDrawable(false);
        this.aFJ.setSupportNoImage(false);
        this.aFJ.setAutoPlay(true);
        this.aFK.setOnClickListener(this.mOnClickListener);
        this.aFJ.setOnInterceptClickListener(this.aFP);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.aFJ;
    }

    public void ap(String str, String str2) {
        this.mPicUrl = str;
        this.afw = str2;
        this.aFJ.E(str, 38);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.aFJ.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        al.c(this.aFJ, i);
    }

    public void setNeedNightMask(boolean z) {
        this.aFM = z;
        eq(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.aFK.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.e.a aVar) {
        this.aFN = aVar;
    }

    public void setOnClickEventListener(com.baidu.tbadk.e.b bVar) {
        this.aFO = bVar;
    }

    public void onChangeSkinType(int i) {
        al.e(this.aFL, d.C0141d.black_alpha30, i);
        eq(i);
    }

    private void eq(int i) {
        int i2 = 0;
        this.aFL.setVisibility((this.aFM && (i == 1)) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fq() {
        try {
            if (!TextUtils.isEmpty(this.afw)) {
                ay.zG().c((TbPageContext) i.ad(getContext()), new String[]{this.afw});
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
        if (this.aFN != null) {
            this.aFN.a(this, i == 0, this.mPicUrl);
        }
    }
}
