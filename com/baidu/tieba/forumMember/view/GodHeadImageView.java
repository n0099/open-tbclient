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
    private a jdW;
    private ImageView jdX;
    private int jdY;
    private int jdZ;
    private int jea;
    private int jeb;
    private int jed;
    private int mRadius;
    private static final int bkc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int jec = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.jdY = 0;
        this.jdZ = this.jdY;
        this.jea = 1;
        this.jeb = this.jea;
        this.jed = bkc;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jdY = 0;
        this.jdZ = this.jdY;
        this.jea = 1;
        this.jeb = this.jea;
        this.jed = bkc;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jdY = 0;
        this.jdZ = this.jdY;
        this.jea = 1;
        this.jeb = this.jea;
        this.jed = bkc;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.jed = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GodHeadImageView_extra_padding, bkc);
            this.jeb = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_shape_type, this.jea);
            this.jdZ = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_show_type, this.jdY);
            this.mRadius = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.jdW = new a(getContext());
        this.jdX = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.jdW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.jdW, layoutParams);
        addView(this.jdX, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.jdZ = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.jeb = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.jdW.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.jdZ) {
            case 0:
                this.jdW.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.jdW.setPadding(jec, jec, 0, 0);
                break;
        }
        switch (this.jeb) {
            case 1:
                this.jdW.setIsRound(true);
                if (this.jdZ == 0) {
                    ap.setImageResource(this.jdX, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    ap.setImageResource(this.jdX, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.jdW.setIsRound(false);
                this.jdW.setRadius(this.mRadius);
                ap.setImageResource(this.jdX, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.jdW.setIsRound(true);
                ap.setImageResource(this.jdX, R.drawable.browser_null_drawable);
                return;
            default:
                this.jdW.setIsRound(false);
                this.jdW.setRadius(this.mRadius);
                ap.setImageResource(this.jdX, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.jed != i) {
            this.jed = i;
            this.jdW.invalidate();
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
            if (GodHeadImageView.this.jdZ == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.jed, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.jed, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
