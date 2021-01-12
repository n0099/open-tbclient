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
    private com.baidu.tbadk.h.c ajM;
    private String eLb;
    private ImageView eme;
    private GifView ftB;
    private boolean ftC;
    private d ftD;
    private final d ftE;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.ftC = false;
        this.ftE = new d() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.h.d
            public boolean onClickEvent(View view) {
                if (BannerGifView.this.ftD == null || !BannerGifView.this.ftD.onClickEvent(view)) {
                    BannerGifView.this.byT();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.eme) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gif_banner_view, this);
        this.eme = (ImageView) inflate.findViewById(R.id.btn_close);
        this.mMaskView = inflate.findViewById(R.id.image_mask);
        this.ftB = (GifView) inflate.findViewById(R.id.image_gif);
        this.ftB.setShowStaticDrawable(false);
        this.ftB.setSupportNoImage(false);
        this.ftB.setAutoPlay(true);
        this.eme.setOnClickListener(this.mOnClickListener);
        this.ftB.setOnInterceptClickListener(this.ftE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.ftB;
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.ftB.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        ao.setImageResource(this.ftB, i);
    }

    public void setNeedNightMask(boolean z) {
        this.ftC = z;
        qx(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.eme.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.ajM = cVar;
    }

    public void setOnClickEventListener(d dVar) {
        this.ftD = dVar;
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mMaskView, R.color.black_alpha30, i);
        qx(i);
    }

    private void qx(int i) {
        boolean z = true;
        int i2 = 0;
        if (i != 1 && i != 4) {
            z = false;
        }
        this.mMaskView.setVisibility((this.ftC && z) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byT() {
        try {
            if (!TextUtils.isEmpty(this.eLb)) {
                be.bsB().b((TbPageContext) j.K(getContext()), new String[]{this.eLb});
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
        if (this.ajM != null) {
            this.ajM.a(this, i == 0, this.mPicUrl);
        }
    }
}
