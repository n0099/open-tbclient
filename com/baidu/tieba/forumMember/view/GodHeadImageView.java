package com.baidu.tieba.forumMember.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class GodHeadImageView extends FrameLayout {
    private int imB;
    private a imu;
    private ImageView imv;
    private int imw;
    private int imx;
    private int imy;
    private int imz;
    private int mRadius;
    private static final int beI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int imA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.imw = 0;
        this.imx = this.imw;
        this.imy = 1;
        this.imz = this.imy;
        this.imB = beI;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.imw = 0;
        this.imx = this.imw;
        this.imy = 1;
        this.imz = this.imy;
        this.imB = beI;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.imw = 0;
        this.imx = this.imw;
        this.imy = 1;
        this.imz = this.imy;
        this.imB = beI;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.imB = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GodHeadImageView_extra_padding, beI);
            this.imz = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_shape_type, this.imy);
            this.imx = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_show_type, this.imw);
            this.mRadius = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.imu = new a(getContext());
        this.imv = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.imu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.imu, layoutParams);
        addView(this.imv, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.imx = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.imz = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.imu.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.imx) {
            case 0:
                this.imu.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.imu.setPadding(imA, imA, 0, 0);
                break;
        }
        switch (this.imz) {
            case 1:
                this.imu.setIsRound(true);
                if (this.imx == 0) {
                    ap.setImageResource(this.imv, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    ap.setImageResource(this.imv, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.imu.setIsRound(false);
                this.imu.setRadius(this.mRadius);
                ap.setImageResource(this.imv, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.imu.setIsRound(true);
                ap.setImageResource(this.imv, R.drawable.browser_null_drawable);
                return;
            default:
                this.imu.setIsRound(false);
                this.imu.setRadius(this.mRadius);
                ap.setImageResource(this.imv, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.imB != i) {
            this.imB = i;
            this.imu.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.imx == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.imB, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.imB, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
