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
    private com.baidu.tbadk.h.c ajc;
    private ImageView eaP;
    private String eyX;
    private GifView fha;
    private boolean fhb;
    private d fhc;
    private final d fhd;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.fhb = false;
        this.fhd = new d() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.h.d
            public boolean onClickEvent(View view) {
                if (BannerGifView.this.fhc == null || !BannerGifView.this.fhc.onClickEvent(view)) {
                    BannerGifView.this.bwS();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.eaP) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gif_banner_view, this);
        this.eaP = (ImageView) inflate.findViewById(R.id.btn_close);
        this.mMaskView = inflate.findViewById(R.id.image_mask);
        this.fha = (GifView) inflate.findViewById(R.id.image_gif);
        this.fha.setShowStaticDrawable(false);
        this.fha.setSupportNoImage(false);
        this.fha.setAutoPlay(true);
        this.eaP.setOnClickListener(this.mOnClickListener);
        this.fha.setOnInterceptClickListener(this.fhd);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.fha;
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.fha.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        ap.setImageResource(this.fha, i);
    }

    public void setNeedNightMask(boolean z) {
        this.fhb = z;
        rq(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.eaP.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.ajc = cVar;
    }

    public void setOnClickEventListener(d dVar) {
        this.fhc = dVar;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mMaskView, R.color.black_alpha30, i);
        rq(i);
    }

    private void rq(int i) {
        boolean z = true;
        int i2 = 0;
        if (i != 1 && i != 4) {
            z = false;
        }
        this.mMaskView.setVisibility((this.fhb && z) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwS() {
        try {
            if (!TextUtils.isEmpty(this.eyX)) {
                bf.bqF().b((TbPageContext) i.I(getContext()), new String[]{this.eyX});
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
        if (this.ajc != null) {
            this.ajc.a(this, i == 0, this.mPicUrl);
        }
    }
}
