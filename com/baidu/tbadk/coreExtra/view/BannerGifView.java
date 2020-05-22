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
import com.baidu.tbadk.h.d;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BannerGifView extends RelativeLayout {
    private String dBY;
    private ImageView dfv;
    private GifView efO;
    private boolean efP;
    private com.baidu.tbadk.h.c efQ;
    private d efR;
    private final d efS;
    private View mMaskView;
    private final View.OnClickListener mOnClickListener;
    private String mPicUrl;
    private float mRatio;

    public BannerGifView(Context context) {
        super(context);
        this.mRatio = 5.744f;
        this.efP = false;
        this.efS = new d() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.1
            @Override // com.baidu.tbadk.h.d
            public boolean onClickEvent(View view) {
                if (BannerGifView.this.efR == null || !BannerGifView.this.efR.onClickEvent(view)) {
                    BannerGifView.this.bbj();
                }
                return true;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.BannerGifView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == BannerGifView.this.dfv) {
                    BannerGifView.this.setCloseVisibility(false);
                }
            }
        };
        initUI();
    }

    private void initUI() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gif_banner_view, this);
        this.dfv = (ImageView) inflate.findViewById(R.id.btn_close);
        this.mMaskView = inflate.findViewById(R.id.image_mask);
        this.efO = (GifView) inflate.findViewById(R.id.image_gif);
        this.efO.setShowStaticDrawable(false);
        this.efO.setSupportNoImage(false);
        this.efO.setAutoPlay(true);
        this.dfv.setOnClickListener(this.mOnClickListener);
        this.efO.setOnInterceptClickListener(this.efS);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public String getUrl() {
        return this.mPicUrl;
    }

    public GifView getGifView() {
        return this.efO;
    }

    public void setRatio(float f) {
        this.mRatio = f;
        invalidate();
    }

    public void setErrorResid(int i) {
        this.efO.setErrorResid(i);
    }

    public void setDefaultResid(int i) {
        am.setImageResource(this.efO, i);
    }

    public void setNeedNightMask(boolean z) {
        this.efP = z;
        mN(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setCloseVisibility(boolean z) {
        this.dfv.setVisibility(z ? 0 : 8);
    }

    public void setIWindowChangedListener(com.baidu.tbadk.h.c cVar) {
        this.efQ = cVar;
    }

    public void setOnClickEventListener(d dVar) {
        this.efR = dVar;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mMaskView, R.color.black_alpha30, i);
        mN(i);
    }

    private void mN(int i) {
        boolean z = true;
        int i2 = 0;
        if (i != 1 && i != 4) {
            z = false;
        }
        this.mMaskView.setVisibility((this.efP && z) ? 8 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbj() {
        try {
            if (!TextUtils.isEmpty(this.dBY)) {
                ba.aUZ().b((TbPageContext) i.G(getContext()), new String[]{this.dBY});
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
        if (this.efQ != null) {
            this.efQ.a(this, i == 0, this.mPicUrl);
        }
    }
}
