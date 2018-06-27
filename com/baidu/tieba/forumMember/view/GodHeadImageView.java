package com.baidu.tieba.forumMember.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class GodHeadImageView extends FrameLayout {
    private a dhG;
    private ImageView dhH;
    private int dhI;
    private int dhJ;
    private int dhK;
    private int dhL;
    private int dhN;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int dhM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.dhI = 0;
        this.dhJ = this.dhI;
        this.dhK = 1;
        this.dhL = this.dhK;
        this.dhN = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dhI = 0;
        this.dhJ = this.dhI;
        this.dhK = 1;
        this.dhL = this.dhK;
        this.dhN = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dhI = 0;
        this.dhJ = this.dhI;
        this.dhK = 1;
        this.dhL = this.dhK;
        this.dhN = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.m.GodHeadImageView);
            this.dhN = obtainStyledAttributes.getDimensionPixelSize(d.m.GodHeadImageView_extra_padding, DS6);
            this.dhL = obtainStyledAttributes.getInteger(d.m.GodHeadImageView_shape_type, this.dhK);
            this.dhJ = obtainStyledAttributes.getInteger(d.m.GodHeadImageView_show_type, this.dhI);
            this.mRadius = obtainStyledAttributes.getInteger(d.m.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.dhG = new a(getContext());
        this.dhH = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dhG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.dhG, layoutParams);
        addView(this.dhH, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.dhJ = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.dhL = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.dhG.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.dhJ) {
            case 0:
                this.dhG.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.dhG.setPadding(dhM, dhM, 0, 0);
                break;
        }
        switch (this.dhL) {
            case 1:
                this.dhG.setIsRound(true);
                if (this.dhJ == 0) {
                    am.c(this.dhH, d.f.pic_shen_avatar_big);
                    return;
                } else {
                    am.c(this.dhH, d.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.dhG.setIsRound(false);
                this.dhG.setRadius(this.mRadius);
                am.c(this.dhH, d.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.dhG.setIsRound(true);
                am.c(this.dhH, d.f.browser_null_drawable);
                return;
            default:
                this.dhG.setIsRound(false);
                this.dhG.setRadius(this.mRadius);
                am.c(this.dhH, d.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.dhN != i) {
            this.dhN = i;
            this.dhG.invalidate();
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
            if (GodHeadImageView.this.dhJ == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.dhN, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.dhN, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
