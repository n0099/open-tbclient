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
    private a iFC;
    private ImageView iFD;
    private int iFE;
    private int iFF;
    private int iFG;
    private int iFH;
    private int iFJ;
    private int mRadius;
    private static final int bfG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int iFI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.iFE = 0;
        this.iFF = this.iFE;
        this.iFG = 1;
        this.iFH = this.iFG;
        this.iFJ = bfG;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iFE = 0;
        this.iFF = this.iFE;
        this.iFG = 1;
        this.iFH = this.iFG;
        this.iFJ = bfG;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iFE = 0;
        this.iFF = this.iFE;
        this.iFG = 1;
        this.iFH = this.iFG;
        this.iFJ = bfG;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.iFJ = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GodHeadImageView_extra_padding, bfG);
            this.iFH = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_shape_type, this.iFG);
            this.iFF = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_show_type, this.iFE);
            this.mRadius = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.iFC = new a(getContext());
        this.iFD = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.iFC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.iFC, layoutParams);
        addView(this.iFD, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.iFF = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.iFH = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.iFC.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.iFF) {
            case 0:
                this.iFC.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.iFC.setPadding(iFI, iFI, 0, 0);
                break;
        }
        switch (this.iFH) {
            case 1:
                this.iFC.setIsRound(true);
                if (this.iFF == 0) {
                    ap.setImageResource(this.iFD, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    ap.setImageResource(this.iFD, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.iFC.setIsRound(false);
                this.iFC.setRadius(this.mRadius);
                ap.setImageResource(this.iFD, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.iFC.setIsRound(true);
                ap.setImageResource(this.iFD, R.drawable.browser_null_drawable);
                return;
            default:
                this.iFC.setIsRound(false);
                this.iFC.setRadius(this.mRadius);
                ap.setImageResource(this.iFD, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.iFJ != i) {
            this.iFJ = i;
            this.iFC.invalidate();
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
            if (GodHeadImageView.this.iFF == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.iFJ, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.iFJ, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
