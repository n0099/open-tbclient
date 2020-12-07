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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.h.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BannerGifView extends RelativeLayout {
    private com.baidu.tbadk.h.c akb;
    private String eFW;
    private ImageView ehQ;
    private GifView foA;
    private boolean foB;
    private d foC;
    private final d foD;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.foB = false;
        this.foD = new d() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.h.d
            public boolean onClickEvent(View view) {
                if (BannerGifView.this.foC == null || !BannerGifView.this.foC.onClickEvent(view)) {
                    BannerGifView.this.bAs();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.ehQ) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gif_banner_view, this);
        this.ehQ = (ImageView) inflate.findViewById(R.id.btn_close);
        this.mMaskView = inflate.findViewById(R.id.image_mask);
        this.foA = (GifView) inflate.findViewById(R.id.image_gif);
        this.foA.setShowStaticDrawable(false);
        this.foA.setSupportNoImage(false);
        this.foA.setAutoPlay(true);
        this.ehQ.setOnClickListener(this.mOnClickListener);
        this.foA.setOnInterceptClickListener(this.foD);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.foA;
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.foA.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        ap.setImageResource(this.foA, i);
    }

    public void setNeedNightMask(boolean z) {
        this.foB = z;
        rR(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.ehQ.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.akb = cVar;
    }

    public void setOnClickEventListener(d dVar) {
        this.foC = dVar;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mMaskView, R.color.black_alpha30, i);
        rR(i);
    }

    private void rR(int i) {
        boolean z = true;
        int i2 = 0;
        if (i != 1 && i != 4) {
            z = false;
        }
        this.mMaskView.setVisibility((this.foB && z) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAs() {
        try {
            if (!TextUtils.isEmpty(this.eFW)) {
                bf.bua().b((TbPageContext) i.J(getContext()), new String[]{this.eFW});
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
        if (this.akb != null) {
            this.akb.a(this, i == 0, this.mPicUrl);
        }
    }
}
