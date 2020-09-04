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
/* loaded from: classes17.dex */
public class GodHeadImageView extends FrameLayout {
    private int hQB;
    private a hQu;
    private ImageView hQv;
    private int hQw;
    private int hQx;
    private int hQy;
    private int hQz;
    private int mRadius;
    private static final int aYB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int hQA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.hQw = 0;
        this.hQx = this.hQw;
        this.hQy = 1;
        this.hQz = this.hQy;
        this.hQB = aYB;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hQw = 0;
        this.hQx = this.hQw;
        this.hQy = 1;
        this.hQz = this.hQy;
        this.hQB = aYB;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hQw = 0;
        this.hQx = this.hQw;
        this.hQy = 1;
        this.hQz = this.hQy;
        this.hQB = aYB;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.hQB = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GodHeadImageView_extra_padding, aYB);
            this.hQz = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_shape_type, this.hQy);
            this.hQx = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_show_type, this.hQw);
            this.mRadius = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.hQu = new a(getContext());
        this.hQv = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.hQu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.hQu, layoutParams);
        addView(this.hQv, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.hQx = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.hQz = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.hQu.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.hQx) {
            case 0:
                this.hQu.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.hQu.setPadding(hQA, hQA, 0, 0);
                break;
        }
        switch (this.hQz) {
            case 1:
                this.hQu.setIsRound(true);
                if (this.hQx == 0) {
                    ap.setImageResource(this.hQv, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    ap.setImageResource(this.hQv, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.hQu.setIsRound(false);
                this.hQu.setRadius(this.mRadius);
                ap.setImageResource(this.hQv, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.hQu.setIsRound(true);
                ap.setImageResource(this.hQv, R.drawable.browser_null_drawable);
                return;
            default:
                this.hQu.setIsRound(false);
                this.hQu.setRadius(this.mRadius);
                ap.setImageResource(this.hQv, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.hQB != i) {
            this.hQB = i;
            this.hQu.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.hQx == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.hQB, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.hQB, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
