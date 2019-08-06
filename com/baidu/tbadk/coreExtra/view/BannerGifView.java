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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BannerGifView extends RelativeLayout {
    private String bGB;
    private GifView clJ;
    private ImageView clK;
    private boolean clL;
    private com.baidu.tbadk.h.c clM;
    private com.baidu.tbadk.h.d clN;
    private final com.baidu.tbadk.h.d clO;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.clL = false;
        this.clO = new com.baidu.tbadk.h.d() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.h.d
            public boolean aG(View view) {
                if (BannerGifView.this.clN == null || !BannerGifView.this.clN.aG(view)) {
                    BannerGifView.this.aqe();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.clK) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gif_banner_view, this);
        this.clK = (ImageView) inflate.findViewById(R.id.btn_close);
        this.mMaskView = inflate.findViewById(R.id.image_mask);
        this.clJ = (GifView) inflate.findViewById(R.id.image_gif);
        this.clJ.setShowStaticDrawable(false);
        this.clJ.setSupportNoImage(false);
        this.clJ.setAutoPlay(true);
        this.clK.setOnClickListener(this.mOnClickListener);
        this.clJ.setOnInterceptClickListener(this.clO);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.clJ;
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.clJ.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        am.c(this.clJ, i);
    }

    public void setNeedNightMask(boolean z) {
        this.clL = z;
        jS(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.clK.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.clM = cVar;
    }

    public void setOnClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.clN = dVar;
    }

    public void onChangeSkinType(int i) {
        am.h(this.mMaskView, R.color.black_alpha30, i);
        jS(i);
    }

    private void jS(int i) {
        int i2 = 0;
        this.mMaskView.setVisibility((this.clL && (i == 1)) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqe() {
        try {
            if (!TextUtils.isEmpty(this.bGB)) {
                bb.ajE().c((TbPageContext) i.ab(getContext()), new String[]{this.bGB});
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
        if (this.clM != null) {
            this.clM.a(this, i == 0, this.mPicUrl);
        }
    }
}
