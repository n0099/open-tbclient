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
    private String bFy;
    private GifView ckp;
    private ImageView ckq;
    private boolean ckr;
    private com.baidu.tbadk.h.c cks;
    private com.baidu.tbadk.h.d ckt;
    private final com.baidu.tbadk.h.d cku;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.ckr = false;
        this.cku = new com.baidu.tbadk.h.d() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.h.d
            public boolean aE(View view) {
                if (BannerGifView.this.ckt == null || !BannerGifView.this.ckt.aE(view)) {
                    BannerGifView.this.aoW();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.ckq) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gif_banner_view, this);
        this.ckq = (ImageView) inflate.findViewById(R.id.btn_close);
        this.mMaskView = inflate.findViewById(R.id.image_mask);
        this.ckp = (GifView) inflate.findViewById(R.id.image_gif);
        this.ckp.setShowStaticDrawable(false);
        this.ckp.setSupportNoImage(false);
        this.ckp.setAutoPlay(true);
        this.ckq.setOnClickListener(this.mOnClickListener);
        this.ckp.setOnInterceptClickListener(this.cku);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.ckp;
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.ckp.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        al.c(this.ckp, i);
    }

    public void setNeedNightMask(boolean z) {
        this.ckr = z;
        jL(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.ckq.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.cks = cVar;
    }

    public void setOnClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.ckt = dVar;
    }

    public void onChangeSkinType(int i) {
        al.h(this.mMaskView, R.color.black_alpha30, i);
        jL(i);
    }

    private void jL(int i) {
        int i2 = 0;
        this.mMaskView.setVisibility((this.ckr && (i == 1)) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoW() {
        try {
            if (!TextUtils.isEmpty(this.bFy)) {
                ba.aiz().c((TbPageContext) i.ab(getContext()), new String[]{this.bFy});
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
        if (this.cks != null) {
            this.cks.a(this, i == 0, this.mPicUrl);
        }
    }
}
