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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.h.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BannerGifView extends RelativeLayout {
    private com.baidu.tbadk.h.c ahh;
    private String dIt;
    private ImageView dkh;
    private GifView eoA;
    private boolean eoB;
    private d eoC;
    private final d eoD;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.eoB = false;
        this.eoD = new d() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.h.d
            public boolean onClickEvent(View view) {
                if (BannerGifView.this.eoC == null || !BannerGifView.this.eoC.onClickEvent(view)) {
                    BannerGifView.this.bdm();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.dkh) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gif_banner_view, this);
        this.dkh = (ImageView) inflate.findViewById(R.id.btn_close);
        this.mMaskView = inflate.findViewById(R.id.image_mask);
        this.eoA = (GifView) inflate.findViewById(R.id.image_gif);
        this.eoA.setShowStaticDrawable(false);
        this.eoA.setSupportNoImage(false);
        this.eoA.setAutoPlay(true);
        this.dkh.setOnClickListener(this.mOnClickListener);
        this.eoA.setOnInterceptClickListener(this.eoD);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.eoA;
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.eoA.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        an.setImageResource(this.eoA, i);
    }

    public void setNeedNightMask(boolean z) {
        this.eoB = z;
        nj(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.dkh.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.ahh = cVar;
    }

    public void setOnClickEventListener(d dVar) {
        this.eoC = dVar;
    }

    public void onChangeSkinType(int i) {
        an.setBackgroundColor(this.mMaskView, R.color.black_alpha30, i);
        nj(i);
    }

    private void nj(int i) {
        boolean z = true;
        int i2 = 0;
        if (i != 1 && i != 4) {
            z = false;
        }
        this.mMaskView.setVisibility((this.eoB && z) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdm() {
        try {
            if (!TextUtils.isEmpty(this.dIt)) {
                bc.aWU().b((TbPageContext) i.G(getContext()), new String[]{this.dIt});
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
        if (this.ahh != null) {
            this.ahh.a(this, i == 0, this.mPicUrl);
        }
    }
}
