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
/* loaded from: classes7.dex */
public class GodHeadImageView extends FrameLayout {
    private a jfF;
    private ImageView jfG;
    private int jfH;
    private int jfI;
    private int jfJ;
    private int jfK;
    private int jfM;
    private int mRadius;
    private static final int blC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int jfL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.jfH = 0;
        this.jfI = this.jfH;
        this.jfJ = 1;
        this.jfK = this.jfJ;
        this.jfM = blC;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jfH = 0;
        this.jfI = this.jfH;
        this.jfJ = 1;
        this.jfK = this.jfJ;
        this.jfM = blC;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jfH = 0;
        this.jfI = this.jfH;
        this.jfJ = 1;
        this.jfK = this.jfJ;
        this.jfM = blC;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.jfM = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GodHeadImageView_extra_padding, blC);
            this.jfK = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_shape_type, this.jfJ);
            this.jfI = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_show_type, this.jfH);
            this.mRadius = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.jfF = new a(getContext());
        this.jfG = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.jfF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.jfF, layoutParams);
        addView(this.jfG, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.jfI = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.jfK = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.jfF.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.jfI) {
            case 0:
                this.jfF.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.jfF.setPadding(jfL, jfL, 0, 0);
                break;
        }
        switch (this.jfK) {
            case 1:
                this.jfF.setIsRound(true);
                if (this.jfI == 0) {
                    ap.setImageResource(this.jfG, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    ap.setImageResource(this.jfG, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.jfF.setIsRound(false);
                this.jfF.setRadius(this.mRadius);
                ap.setImageResource(this.jfG, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.jfF.setIsRound(true);
                ap.setImageResource(this.jfG, R.drawable.browser_null_drawable);
                return;
            default:
                this.jfF.setIsRound(false);
                this.jfF.setRadius(this.mRadius);
                ap.setImageResource(this.jfG, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.jfM != i) {
            this.jfM = i;
            this.jfF.invalidate();
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
            if (GodHeadImageView.this.jfI == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.jfM, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.jfM, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
