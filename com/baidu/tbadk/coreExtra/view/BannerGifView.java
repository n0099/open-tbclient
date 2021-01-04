package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.base.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.h.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BannerGifView extends RelativeLayout {
    private com.baidu.tbadk.h.c akD;
    private String ePM;
    private ImageView eqT;
    private GifView fyj;
    private boolean fyk;
    private d fyl;
    private final d fym;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.fyk = false;
        this.fym = new d() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.h.d
            public boolean onClickEvent(View view) {
                if (BannerGifView.this.fyl == null || !BannerGifView.this.fyl.onClickEvent(view)) {
                    BannerGifView.this.bCM();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.eqT) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gif_banner_view, this);
        this.eqT = (ImageView) inflate.findViewById(R.id.btn_close);
        this.mMaskView = inflate.findViewById(R.id.image_mask);
        this.fyj = (GifView) inflate.findViewById(R.id.image_gif);
        this.fyj.setShowStaticDrawable(false);
        this.fyj.setSupportNoImage(false);
        this.fyj.setAutoPlay(true);
        this.eqT.setOnClickListener(this.mOnClickListener);
        this.fyj.setOnInterceptClickListener(this.fym);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.fyj;
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.fyj.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        ao.setImageResource(this.fyj, i);
    }

    public void setNeedNightMask(boolean z) {
        this.fyk = z;
        sd(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.eqT.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.akD = cVar;
    }

    public void setOnClickEventListener(d dVar) {
        this.fyl = dVar;
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mMaskView, R.color.black_alpha30, i);
        sd(i);
    }

    private void sd(int i) {
        boolean z = true;
        int i2 = 0;
        if (i != 1 && i != 4) {
            z = false;
        }
        this.mMaskView.setVisibility((this.fyk && z) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCM() {
        try {
            if (!TextUtils.isEmpty(this.ePM)) {
                be.bwu().b((TbPageContext) j.K(getContext()), new String[]{this.ePM});
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
        if (this.akD != null) {
            this.akD.a(this, i == 0, this.mPicUrl);
        }
    }
}
