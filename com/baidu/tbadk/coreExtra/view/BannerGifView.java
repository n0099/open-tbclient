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
    private String byh;
    private GifView cch;
    private ImageView cci;
    private boolean ccj;
    private com.baidu.tbadk.h.a cck;
    private com.baidu.tbadk.h.b ccl;
    private final com.baidu.tbadk.h.b ccm;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.ccj = false;
        this.ccm = new com.baidu.tbadk.h.b() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.h.b
            public boolean ay(View view) {
                if (BannerGifView.this.ccl == null || !BannerGifView.this.ccl.ay(view)) {
                    BannerGifView.this.ajZ();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.cci) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.gif_banner_view, this);
        this.cci = (ImageView) inflate.findViewById(d.g.btn_close);
        this.mMaskView = inflate.findViewById(d.g.image_mask);
        this.cch = (GifView) inflate.findViewById(d.g.image_gif);
        this.cch.setShowStaticDrawable(false);
        this.cch.setSupportNoImage(false);
        this.cch.setAutoPlay(true);
        this.cci.setOnClickListener(this.mOnClickListener);
        this.cch.setOnInterceptClickListener(this.ccm);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.cch;
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.cch.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        al.c(this.cch, i);
    }

    public void setNeedNightMask(boolean z) {
        this.ccj = z;
        iY(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.cci.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.a aVar) {
        this.cck = aVar;
    }

    public void setOnClickEventListener(com.baidu.tbadk.h.b bVar) {
        this.ccl = bVar;
    }

    public void onChangeSkinType(int i) {
        al.f(this.mMaskView, d.C0236d.black_alpha30, i);
        iY(i);
    }

    private void iY(int i) {
        int i2 = 0;
        this.mMaskView.setVisibility((this.ccj && (i == 1)) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajZ() {
        try {
            if (!TextUtils.isEmpty(this.byh)) {
                ba.adD().c((TbPageContext) i.aK(getContext()), new String[]{this.byh});
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
        if (this.cck != null) {
            this.cck.a(this, i == 0, this.mPicUrl);
        }
    }
}
