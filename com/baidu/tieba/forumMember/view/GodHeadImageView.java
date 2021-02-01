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
/* loaded from: classes8.dex */
public class GodHeadImageView extends FrameLayout {
    private a jdI;
    private ImageView jdJ;
    private int jdK;
    private int jdL;
    private int jdM;
    private int jdN;
    private int jdP;
    private int mRadius;
    private static final int bkc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int jdO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.jdK = 0;
        this.jdL = this.jdK;
        this.jdM = 1;
        this.jdN = this.jdM;
        this.jdP = bkc;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jdK = 0;
        this.jdL = this.jdK;
        this.jdM = 1;
        this.jdN = this.jdM;
        this.jdP = bkc;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jdK = 0;
        this.jdL = this.jdK;
        this.jdM = 1;
        this.jdN = this.jdM;
        this.jdP = bkc;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.jdP = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GodHeadImageView_extra_padding, bkc);
            this.jdN = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_shape_type, this.jdM);
            this.jdL = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_show_type, this.jdK);
            this.mRadius = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.jdI = new a(getContext());
        this.jdJ = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.jdI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.jdI, layoutParams);
        addView(this.jdJ, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.jdL = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.jdN = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.jdI.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.jdL) {
            case 0:
                this.jdI.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.jdI.setPadding(jdO, jdO, 0, 0);
                break;
        }
        switch (this.jdN) {
            case 1:
                this.jdI.setIsRound(true);
                if (this.jdL == 0) {
                    ap.setImageResource(this.jdJ, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    ap.setImageResource(this.jdJ, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.jdI.setIsRound(false);
                this.jdI.setRadius(this.mRadius);
                ap.setImageResource(this.jdJ, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.jdI.setIsRound(true);
                ap.setImageResource(this.jdJ, R.drawable.browser_null_drawable);
                return;
            default:
                this.jdI.setIsRound(false);
                this.jdI.setRadius(this.mRadius);
                ap.setImageResource(this.jdJ, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.jdP != i) {
            this.jdP = i;
            this.jdI.invalidate();
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
            if (GodHeadImageView.this.jdL == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.jdP, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.jdP, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
