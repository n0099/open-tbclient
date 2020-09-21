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
/* loaded from: classes22.dex */
public class GodHeadImageView extends FrameLayout {
    private int hXB;
    private a hXu;
    private ImageView hXv;
    private int hXw;
    private int hXx;
    private int hXy;
    private int hXz;
    private int mRadius;
    private static final int baY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int hXA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.hXw = 0;
        this.hXx = this.hXw;
        this.hXy = 1;
        this.hXz = this.hXy;
        this.hXB = baY;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hXw = 0;
        this.hXx = this.hXw;
        this.hXy = 1;
        this.hXz = this.hXy;
        this.hXB = baY;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hXw = 0;
        this.hXx = this.hXw;
        this.hXy = 1;
        this.hXz = this.hXy;
        this.hXB = baY;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.hXB = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GodHeadImageView_extra_padding, baY);
            this.hXz = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_shape_type, this.hXy);
            this.hXx = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_show_type, this.hXw);
            this.mRadius = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.hXu = new a(getContext());
        this.hXv = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.hXu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.hXu, layoutParams);
        addView(this.hXv, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.hXx = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.hXz = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.hXu.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.hXx) {
            case 0:
                this.hXu.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.hXu.setPadding(hXA, hXA, 0, 0);
                break;
        }
        switch (this.hXz) {
            case 1:
                this.hXu.setIsRound(true);
                if (this.hXx == 0) {
                    ap.setImageResource(this.hXv, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    ap.setImageResource(this.hXv, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.hXu.setIsRound(false);
                this.hXu.setRadius(this.mRadius);
                ap.setImageResource(this.hXv, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.hXu.setIsRound(true);
                ap.setImageResource(this.hXv, R.drawable.browser_null_drawable);
                return;
            default:
                this.hXu.setIsRound(false);
                this.hXu.setRadius(this.mRadius);
                ap.setImageResource(this.hXv, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.hXB != i) {
            this.hXB = i;
            this.hXu.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.hXx == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.hXB, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.hXB, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
