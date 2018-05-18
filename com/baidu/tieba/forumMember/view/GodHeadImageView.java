package com.baidu.tieba.forumMember.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class GodHeadImageView extends FrameLayout {
    private a cWC;
    private ImageView cWD;
    private int cWE;
    private int cWF;
    private int cWG;
    private int cWH;
    private int cWJ;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int cWI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.cWE = 0;
        this.cWF = this.cWE;
        this.cWG = 1;
        this.cWH = this.cWG;
        this.cWJ = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cWE = 0;
        this.cWF = this.cWE;
        this.cWG = 1;
        this.cWH = this.cWG;
        this.cWJ = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cWE = 0;
        this.cWF = this.cWE;
        this.cWG = 1;
        this.cWH = this.cWG;
        this.cWJ = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.m.GodHeadImageView);
            this.cWJ = obtainStyledAttributes.getDimensionPixelSize(d.m.GodHeadImageView_extra_padding, DS6);
            this.cWH = obtainStyledAttributes.getInteger(d.m.GodHeadImageView_shape_type, this.cWG);
            this.cWF = obtainStyledAttributes.getInteger(d.m.GodHeadImageView_show_type, this.cWE);
            this.mRadius = obtainStyledAttributes.getInteger(d.m.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.cWC = new a(getContext());
        this.cWD = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.cWC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.cWC, layoutParams);
        addView(this.cWD, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.cWF = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.cWH = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.cWC.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.cWF) {
            case 0:
                this.cWC.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.cWC.setPadding(cWI, cWI, 0, 0);
                break;
        }
        switch (this.cWH) {
            case 1:
                this.cWC.setIsRound(true);
                if (this.cWF == 0) {
                    ak.c(this.cWD, d.f.pic_shen_avatar_big);
                    return;
                } else {
                    ak.c(this.cWD, d.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.cWC.setIsRound(false);
                this.cWC.setRadius(this.mRadius);
                ak.c(this.cWD, d.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.cWC.setIsRound(true);
                ak.c(this.cWD, d.f.browser_null_drawable);
                return;
            default:
                this.cWC.setIsRound(false);
                this.cWC.setRadius(this.mRadius);
                ak.c(this.cWD, d.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.cWJ != i) {
            this.cWJ = i;
            this.cWC.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.cWF == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.cWJ, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.cWJ, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
