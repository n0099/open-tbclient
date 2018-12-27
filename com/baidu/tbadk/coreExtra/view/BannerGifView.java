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
    private GifView aSI;
    private ImageView aSJ;
    private boolean aSK;
    private com.baidu.tbadk.f.a aSL;
    private com.baidu.tbadk.f.b aSM;
    private final com.baidu.tbadk.f.b aSN;
    private String aqQ;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.aSK = false;
        this.aSN = new com.baidu.tbadk.f.b() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.f.b
            public boolean F(View view) {
                if (BannerGifView.this.aSM == null || !BannerGifView.this.aSM.F(view)) {
                    BannerGifView.this.Km();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.aSJ) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    public BannerGifView(Context context, float f) {
        super(context);
        this.mRatio = 5.744f;
        this.aSK = false;
        this.aSN = new com.baidu.tbadk.f.b() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.f.b
            public boolean F(View view) {
                if (BannerGifView.this.aSM == null || !BannerGifView.this.aSM.F(view)) {
                    BannerGifView.this.Km();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.aSJ) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        this.mRatio = f;
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.gif_banner_view, this);
        this.aSJ = (ImageView) inflate.findViewById(e.g.btn_close);
        this.mMaskView = inflate.findViewById(e.g.image_mask);
        this.aSI = (GifView) inflate.findViewById(e.g.image_gif);
        this.aSI.setShowStaticDrawable(false);
        this.aSI.setSupportNoImage(false);
        this.aSI.setAutoPlay(true);
        this.aSJ.setOnClickListener(this.mOnClickListener);
        this.aSI.setOnInterceptClickListener(this.aSN);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.aSI;
    }

    public void aI(String str, String str2) {
        this.mPicUrl = str;
        this.aqQ = str2;
        this.aSI.H(str, 38);
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.aSI.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        al.c(this.aSI, i);
    }

    public void setNeedNightMask(boolean z) {
        this.aSK = z;
        fr(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.aSJ.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.f.a aVar) {
        this.aSL = aVar;
    }

    public void setOnClickEventListener(com.baidu.tbadk.f.b bVar) {
        this.aSM = bVar;
    }

    public void onChangeSkinType(int i) {
        al.e(this.mMaskView, e.d.black_alpha30, i);
        fr(i);
    }

    private void fr(int i) {
        int i2 = 0;
        this.mMaskView.setVisibility((this.aSK && (i == 1)) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Km() {
        try {
            if (!TextUtils.isEmpty(this.aqQ)) {
                ay.Ef().c((TbPageContext) i.aK(getContext()), new String[]{this.aqQ});
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
        if (this.aSL != null) {
            this.aSL.a(this, i == 0, this.mPicUrl);
        }
    }
}
