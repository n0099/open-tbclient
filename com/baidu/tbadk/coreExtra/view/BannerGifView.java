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
    private String bGZ;
    private GifView cmF;
    private ImageView cmG;
    private boolean cmH;
    private com.baidu.tbadk.h.c cmI;
    private com.baidu.tbadk.h.d cmJ;
    private final com.baidu.tbadk.h.d cmK;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.cmH = false;
        this.cmK = new com.baidu.tbadk.h.d() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.h.d
            public boolean aG(View view) {
                if (BannerGifView.this.cmJ == null || !BannerGifView.this.cmJ.aG(view)) {
                    BannerGifView.this.aqq();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.cmG) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gif_banner_view, this);
        this.cmG = (ImageView) inflate.findViewById(R.id.btn_close);
        this.mMaskView = inflate.findViewById(R.id.image_mask);
        this.cmF = (GifView) inflate.findViewById(R.id.image_gif);
        this.cmF.setShowStaticDrawable(false);
        this.cmF.setSupportNoImage(false);
        this.cmF.setAutoPlay(true);
        this.cmG.setOnClickListener(this.mOnClickListener);
        this.cmF.setOnInterceptClickListener(this.cmK);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.cmF;
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.cmF.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        am.c(this.cmF, i);
    }

    public void setNeedNightMask(boolean z) {
        this.cmH = z;
        jV(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.cmG.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.cmI = cVar;
    }

    public void setOnClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.cmJ = dVar;
    }

    public void onChangeSkinType(int i) {
        am.h(this.mMaskView, R.color.black_alpha30, i);
        jV(i);
    }

    private void jV(int i) {
        boolean z = true;
        int i2 = 0;
        if (i != 1 && i != 4) {
            z = false;
        }
        this.mMaskView.setVisibility((this.cmH && z) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqq() {
        try {
            if (!TextUtils.isEmpty(this.bGZ)) {
                ba.ajK().c((TbPageContext) i.ab(getContext()), new String[]{this.bGZ});
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
        if (this.cmI != null) {
            this.cmI.a(this, i == 0, this.mPicUrl);
        }
    }
}
