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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class BannerGifView extends RelativeLayout {
    private String bym;
    private GifView ccj;
    private ImageView cck;
    private boolean ccl;
    private com.baidu.tbadk.h.a ccm;
    private com.baidu.tbadk.h.b ccn;
    private final com.baidu.tbadk.h.b cco;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.ccl = false;
        this.cco = new com.baidu.tbadk.h.b() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.h.b
            public boolean ay(View view) {
                if (BannerGifView.this.ccn == null || !BannerGifView.this.ccn.ay(view)) {
                    BannerGifView.this.ajV();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.cck) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.gif_banner_view, this);
        this.cck = (ImageView) inflate.findViewById(d.g.btn_close);
        this.mMaskView = inflate.findViewById(d.g.image_mask);
        this.ccj = (GifView) inflate.findViewById(d.g.image_gif);
        this.ccj.setShowStaticDrawable(false);
        this.ccj.setSupportNoImage(false);
        this.ccj.setAutoPlay(true);
        this.cck.setOnClickListener(this.mOnClickListener);
        this.ccj.setOnInterceptClickListener(this.cco);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.ccj;
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.ccj.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        al.c(this.ccj, i);
    }

    public void setNeedNightMask(boolean z) {
        this.ccl = z;
        iX(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.cck.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.a aVar) {
        this.ccm = aVar;
    }

    public void setOnClickEventListener(com.baidu.tbadk.h.b bVar) {
        this.ccn = bVar;
    }

    public void onChangeSkinType(int i) {
        al.f(this.mMaskView, d.C0277d.black_alpha30, i);
        iX(i);
    }

    private void iX(int i) {
        int i2 = 0;
        this.mMaskView.setVisibility((this.ccl && (i == 1)) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajV() {
        try {
            if (!TextUtils.isEmpty(this.bym)) {
                ba.adA().c((TbPageContext) i.aK(getContext()), new String[]{this.bym});
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
        if (this.ccm != null) {
            this.ccm.a(this, i == 0, this.mPicUrl);
        }
    }
}
