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
    private a iyR;
    private ImageView iyS;
    private int iyT;
    private int iyU;
    private int iyV;
    private int iyW;
    private int iyY;
    private int mRadius;
    private static final int bfY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int iyX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.iyT = 0;
        this.iyU = this.iyT;
        this.iyV = 1;
        this.iyW = this.iyV;
        this.iyY = bfY;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iyT = 0;
        this.iyU = this.iyT;
        this.iyV = 1;
        this.iyW = this.iyV;
        this.iyY = bfY;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iyT = 0;
        this.iyU = this.iyT;
        this.iyV = 1;
        this.iyW = this.iyV;
        this.iyY = bfY;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.iyY = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GodHeadImageView_extra_padding, bfY);
            this.iyW = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_shape_type, this.iyV);
            this.iyU = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_show_type, this.iyT);
            this.mRadius = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.iyR = new a(getContext());
        this.iyS = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.iyR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.iyR, layoutParams);
        addView(this.iyS, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.iyU = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.iyW = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.iyR.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.iyU) {
            case 0:
                this.iyR.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.iyR.setPadding(iyX, iyX, 0, 0);
                break;
        }
        switch (this.iyW) {
            case 1:
                this.iyR.setIsRound(true);
                if (this.iyU == 0) {
                    ap.setImageResource(this.iyS, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    ap.setImageResource(this.iyS, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.iyR.setIsRound(false);
                this.iyR.setRadius(this.mRadius);
                ap.setImageResource(this.iyS, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.iyR.setIsRound(true);
                ap.setImageResource(this.iyS, R.drawable.browser_null_drawable);
                return;
            default:
                this.iyR.setIsRound(false);
                this.iyR.setRadius(this.mRadius);
                ap.setImageResource(this.iyS, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.iyY != i) {
            this.iyY = i;
            this.iyR.invalidate();
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
            if (GodHeadImageView.this.iyU == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.iyY, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.iyY, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
