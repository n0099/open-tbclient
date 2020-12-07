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
    private int iQB;
    private a iQu;
    private ImageView iQv;
    private int iQw;
    private int iQx;
    private int iQy;
    private int iQz;
    private int mRadius;
    private static final int bjW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int iQA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.iQw = 0;
        this.iQx = this.iQw;
        this.iQy = 1;
        this.iQz = this.iQy;
        this.iQB = bjW;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iQw = 0;
        this.iQx = this.iQw;
        this.iQy = 1;
        this.iQz = this.iQy;
        this.iQB = bjW;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iQw = 0;
        this.iQx = this.iQw;
        this.iQy = 1;
        this.iQz = this.iQy;
        this.iQB = bjW;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.iQB = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GodHeadImageView_extra_padding, bjW);
            this.iQz = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_shape_type, this.iQy);
            this.iQx = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_show_type, this.iQw);
            this.mRadius = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.iQu = new a(getContext());
        this.iQv = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.iQu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.iQu, layoutParams);
        addView(this.iQv, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.iQx = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.iQz = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.iQu.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.iQx) {
            case 0:
                this.iQu.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.iQu.setPadding(iQA, iQA, 0, 0);
                break;
        }
        switch (this.iQz) {
            case 1:
                this.iQu.setIsRound(true);
                if (this.iQx == 0) {
                    ap.setImageResource(this.iQv, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    ap.setImageResource(this.iQv, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.iQu.setIsRound(false);
                this.iQu.setRadius(this.mRadius);
                ap.setImageResource(this.iQv, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.iQu.setIsRound(true);
                ap.setImageResource(this.iQv, R.drawable.browser_null_drawable);
                return;
            default:
                this.iQu.setIsRound(false);
                this.iQu.setRadius(this.mRadius);
                ap.setImageResource(this.iQv, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.iQB != i) {
            this.iQB = i;
            this.iQu.invalidate();
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
            if (GodHeadImageView.this.iQx == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.iQB, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.iQB, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
