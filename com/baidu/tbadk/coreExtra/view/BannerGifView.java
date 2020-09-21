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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.h.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BannerGifView extends RelativeLayout {
    private com.baidu.tbadk.h.c aiE;
    private ImageView dCi;
    private d eHA;
    private final d eHB;
    private GifView eHy;
    private boolean eHz;
    private String eal;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.eHz = false;
        this.eHB = new d() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.h.d
            public boolean onClickEvent(View view) {
                if (BannerGifView.this.eHA == null || !BannerGifView.this.eHA.onClickEvent(view)) {
                    BannerGifView.this.bqA();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.dCi) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gif_banner_view, this);
        this.dCi = (ImageView) inflate.findViewById(R.id.btn_close);
        this.mMaskView = inflate.findViewById(R.id.image_mask);
        this.eHy = (GifView) inflate.findViewById(R.id.image_gif);
        this.eHy.setShowStaticDrawable(false);
        this.eHy.setSupportNoImage(false);
        this.eHy.setAutoPlay(true);
        this.dCi.setOnClickListener(this.mOnClickListener);
        this.eHy.setOnInterceptClickListener(this.eHB);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.eHy;
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.eHy.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        ap.setImageResource(this.eHy, i);
    }

    public void setNeedNightMask(boolean z) {
        this.eHz = z;
        pZ(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.dCi.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.aiE = cVar;
    }

    public void setOnClickEventListener(d dVar) {
        this.eHA = dVar;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mMaskView, R.color.black_alpha30, i);
        pZ(i);
    }

    private void pZ(int i) {
        boolean z = true;
        int i2 = 0;
        if (i != 1 && i != 4) {
            z = false;
        }
        this.mMaskView.setVisibility((this.eHz && z) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqA() {
        try {
            if (!TextUtils.isEmpty(this.eal)) {
                be.bkp().b((TbPageContext) i.I(getContext()), new String[]{this.eal});
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
        if (this.aiE != null) {
            this.aiE.a(this, i == 0, this.mPicUrl);
        }
    }
}
