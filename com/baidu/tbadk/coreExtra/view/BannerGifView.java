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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BannerGifView extends RelativeLayout {
    private String cOB;
    private ImageView cvi;
    private GifView drg;
    private boolean drh;
    private com.baidu.tbadk.h.c dri;
    private com.baidu.tbadk.h.d drj;
    private final com.baidu.tbadk.h.d drk;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.drh = false;
        this.drk = new com.baidu.tbadk.h.d() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.h.d
            public boolean onClickEvent(View view) {
                if (BannerGifView.this.drj == null || !BannerGifView.this.drj.onClickEvent(view)) {
                    BannerGifView.this.aMA();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.cvi) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gif_banner_view, this);
        this.cvi = (ImageView) inflate.findViewById(R.id.btn_close);
        this.mMaskView = inflate.findViewById(R.id.image_mask);
        this.drg = (GifView) inflate.findViewById(R.id.image_gif);
        this.drg.setShowStaticDrawable(false);
        this.drg.setSupportNoImage(false);
        this.drg.setAutoPlay(true);
        this.cvi.setOnClickListener(this.mOnClickListener);
        this.drg.setOnInterceptClickListener(this.drk);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.drg;
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.drg.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        am.setImageResource(this.drg, i);
    }

    public void setNeedNightMask(boolean z) {
        this.drh = z;
        lW(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.cvi.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.dri = cVar;
    }

    public void setOnClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.drj = dVar;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mMaskView, R.color.black_alpha30, i);
        lW(i);
    }

    private void lW(int i) {
        boolean z = true;
        int i2 = 0;
        if (i != 1 && i != 4) {
            z = false;
        }
        this.mMaskView.setVisibility((this.drh && z) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMA() {
        try {
            if (!TextUtils.isEmpty(this.cOB)) {
                ba.aGG().b((TbPageContext) i.ab(getContext()), new String[]{this.cOB});
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
        if (this.dri != null) {
            this.dri.a(this, i == 0, this.mPicUrl);
        }
    }
}
