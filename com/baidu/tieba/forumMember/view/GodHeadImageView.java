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
/* loaded from: classes8.dex */
public class GodHeadImageView extends FrameLayout {
    private a jcI;
    private ImageView jcJ;
    private int jcK;
    private int jcL;
    private int jcM;
    private int jcN;
    private int jcP;
    private int mRadius;
    private static final int blA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int jcO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.jcK = 0;
        this.jcL = this.jcK;
        this.jcM = 1;
        this.jcN = this.jcM;
        this.jcP = blA;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jcK = 0;
        this.jcL = this.jcK;
        this.jcM = 1;
        this.jcN = this.jcM;
        this.jcP = blA;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jcK = 0;
        this.jcL = this.jcK;
        this.jcM = 1;
        this.jcN = this.jcM;
        this.jcP = blA;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.jcP = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GodHeadImageView_extra_padding, blA);
            this.jcN = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_shape_type, this.jcM);
            this.jcL = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_show_type, this.jcK);
            this.mRadius = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.jcI = new a(getContext());
        this.jcJ = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.jcI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.jcI, layoutParams);
        addView(this.jcJ, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.jcL = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.jcN = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.jcI.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.jcL) {
            case 0:
                this.jcI.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.jcI.setPadding(jcO, jcO, 0, 0);
                break;
        }
        switch (this.jcN) {
            case 1:
                this.jcI.setIsRound(true);
                if (this.jcL == 0) {
                    ao.setImageResource(this.jcJ, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    ao.setImageResource(this.jcJ, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.jcI.setIsRound(false);
                this.jcI.setRadius(this.mRadius);
                ao.setImageResource(this.jcJ, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.jcI.setIsRound(true);
                ao.setImageResource(this.jcJ, R.drawable.browser_null_drawable);
                return;
            default:
                this.jcI.setIsRound(false);
                this.jcI.setRadius(this.mRadius);
                ao.setImageResource(this.jcJ, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.jcP != i) {
            this.jcP = i;
            this.jcI.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.jcL == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.jcP, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.jcP, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
