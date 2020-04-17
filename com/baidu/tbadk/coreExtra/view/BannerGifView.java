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
    private ImageView cUp;
    private GifView dRq;
    private boolean dRr;
    private com.baidu.tbadk.h.c dRs;
    private com.baidu.tbadk.h.d dRt;
    private final com.baidu.tbadk.h.d dRu;
    private String dnT;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.dRr = false;
        this.dRu = new com.baidu.tbadk.h.d() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.h.d
            public boolean onClickEvent(View view) {
                if (BannerGifView.this.dRt == null || !BannerGifView.this.dRt.onClickEvent(view)) {
                    BannerGifView.this.aVb();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.cUp) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gif_banner_view, this);
        this.cUp = (ImageView) inflate.findViewById(R.id.btn_close);
        this.mMaskView = inflate.findViewById(R.id.image_mask);
        this.dRq = (GifView) inflate.findViewById(R.id.image_gif);
        this.dRq.setShowStaticDrawable(false);
        this.dRq.setSupportNoImage(false);
        this.dRq.setAutoPlay(true);
        this.cUp.setOnClickListener(this.mOnClickListener);
        this.dRq.setOnInterceptClickListener(this.dRu);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.dRq;
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.dRq.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        am.setImageResource(this.dRq, i);
    }

    public void setNeedNightMask(boolean z) {
        this.dRr = z;
        mk(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.cUp.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.dRs = cVar;
    }

    public void setOnClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.dRt = dVar;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mMaskView, R.color.black_alpha30, i);
        mk(i);
    }

    private void mk(int i) {
        boolean z = true;
        int i2 = 0;
        if (i != 1 && i != 4) {
            z = false;
        }
        this.mMaskView.setVisibility((this.dRr && z) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVb() {
        try {
            if (!TextUtils.isEmpty(this.dnT)) {
                ba.aOY().b((TbPageContext) i.T(getContext()), new String[]{this.dnT});
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
        if (this.dRs != null) {
            this.dRs.a(this, i == 0, this.mPicUrl);
        }
    }
}
