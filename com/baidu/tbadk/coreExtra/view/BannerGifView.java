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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BannerGifView extends RelativeLayout {
    private String bFz;
    private GifView ckq;
    private ImageView ckr;
    private boolean cks;
    private com.baidu.tbadk.h.c ckt;
    private com.baidu.tbadk.h.d cku;
    private final com.baidu.tbadk.h.d ckv;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.cks = false;
        this.ckv = new com.baidu.tbadk.h.d() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.h.d
            public boolean aE(View view) {
                if (BannerGifView.this.cku == null || !BannerGifView.this.cku.aE(view)) {
                    BannerGifView.this.aoW();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.ckr) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gif_banner_view, this);
        this.ckr = (ImageView) inflate.findViewById(R.id.btn_close);
        this.mMaskView = inflate.findViewById(R.id.image_mask);
        this.ckq = (GifView) inflate.findViewById(R.id.image_gif);
        this.ckq.setShowStaticDrawable(false);
        this.ckq.setSupportNoImage(false);
        this.ckq.setAutoPlay(true);
        this.ckr.setOnClickListener(this.mOnClickListener);
        this.ckq.setOnInterceptClickListener(this.ckv);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.ckq;
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.ckq.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        al.c(this.ckq, i);
    }

    public void setNeedNightMask(boolean z) {
        this.cks = z;
        jL(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.ckr.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.ckt = cVar;
    }

    public void setOnClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.cku = dVar;
    }

    public void onChangeSkinType(int i) {
        al.h(this.mMaskView, R.color.black_alpha30, i);
        jL(i);
    }

    private void jL(int i) {
        int i2 = 0;
        this.mMaskView.setVisibility((this.cks && (i == 1)) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoW() {
        try {
            if (!TextUtils.isEmpty(this.bFz)) {
                ba.aiz().c((TbPageContext) i.ab(getContext()), new String[]{this.bFz});
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
        if (this.ckt != null) {
            this.ckt.a(this, i == 0, this.mPicUrl);
        }
    }
}
