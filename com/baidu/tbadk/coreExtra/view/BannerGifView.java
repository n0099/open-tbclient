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
    private com.baidu.tbadk.h.c aiX;
    private String eAG;
    private ImageView ecx;
    private GifView fhS;
    private boolean fhT;
    private d fhU;
    private final d fhV;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.fhT = false;
        this.fhV = new d() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.h.d
            public boolean onClickEvent(View view) {
                if (BannerGifView.this.fhU == null || !BannerGifView.this.fhU.onClickEvent(view)) {
                    BannerGifView.this.bxC();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.ecx) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gif_banner_view, this);
        this.ecx = (ImageView) inflate.findViewById(R.id.btn_close);
        this.mMaskView = inflate.findViewById(R.id.image_mask);
        this.fhS = (GifView) inflate.findViewById(R.id.image_gif);
        this.fhS.setShowStaticDrawable(false);
        this.fhS.setSupportNoImage(false);
        this.fhS.setAutoPlay(true);
        this.ecx.setOnClickListener(this.mOnClickListener);
        this.fhS.setOnInterceptClickListener(this.fhV);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.fhS;
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.fhS.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        ap.setImageResource(this.fhS, i);
    }

    public void setNeedNightMask(boolean z) {
        this.fhT = z;
        qS(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.ecx.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.aiX = cVar;
    }

    public void setOnClickEventListener(d dVar) {
        this.fhU = dVar;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mMaskView, R.color.black_alpha30, i);
        qS(i);
    }

    private void qS(int i) {
        boolean z = true;
        int i2 = 0;
        if (i != 1 && i != 4) {
            z = false;
        }
        this.mMaskView.setVisibility((this.fhT && z) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxC() {
        try {
            if (!TextUtils.isEmpty(this.eAG)) {
                be.brr().b((TbPageContext) i.I(getContext()), new String[]{this.eAG});
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
        if (this.aiX != null) {
            this.aiX.a(this, i == 0, this.mPicUrl);
        }
    }
}
