package com.baidu.tieba.forumMember.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class GodHeadImageView extends FrameLayout {
    private a iYb;
    private ImageView iYc;
    private int iYd;
    private int iYe;
    private int iYf;
    private int iYg;
    private int iYi;
    private int mRadius;
    private static final int bgL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int iYh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.iYd = 0;
        this.iYe = this.iYd;
        this.iYf = 1;
        this.iYg = this.iYf;
        this.iYi = bgL;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iYd = 0;
        this.iYe = this.iYd;
        this.iYf = 1;
        this.iYg = this.iYf;
        this.iYi = bgL;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iYd = 0;
        this.iYe = this.iYd;
        this.iYf = 1;
        this.iYg = this.iYf;
        this.iYi = bgL;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.iYi = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GodHeadImageView_extra_padding, bgL);
            this.iYg = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_shape_type, this.iYf);
            this.iYe = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_show_type, this.iYd);
            this.mRadius = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.iYb = new a(getContext());
        this.iYc = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.iYb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.iYb, layoutParams);
        addView(this.iYc, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.iYe = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.iYg = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.iYb.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.iYe) {
            case 0:
                this.iYb.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.iYb.setPadding(iYh, iYh, 0, 0);
                break;
        }
        switch (this.iYg) {
            case 1:
                this.iYb.setIsRound(true);
                if (this.iYe == 0) {
                    ao.setImageResource(this.iYc, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    ao.setImageResource(this.iYc, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.iYb.setIsRound(false);
                this.iYb.setRadius(this.mRadius);
                ao.setImageResource(this.iYc, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.iYb.setIsRound(true);
                ao.setImageResource(this.iYc, R.drawable.browser_null_drawable);
                return;
            default:
                this.iYb.setIsRound(false);
                this.iYb.setRadius(this.mRadius);
                ao.setImageResource(this.iYc, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.iYi != i) {
            this.iYi = i;
            this.iYb.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.iYe == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.iYi, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.iYi, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
