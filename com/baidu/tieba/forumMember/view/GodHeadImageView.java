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
    private int cVA;
    private int cVB;
    private int cVC;
    private int cVD;
    private int cVF;
    private a cVy;
    private ImageView cVz;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int cVE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.cVA = 0;
        this.cVB = this.cVA;
        this.cVC = 1;
        this.cVD = this.cVC;
        this.cVF = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVA = 0;
        this.cVB = this.cVA;
        this.cVC = 1;
        this.cVD = this.cVC;
        this.cVF = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cVA = 0;
        this.cVB = this.cVA;
        this.cVC = 1;
        this.cVD = this.cVC;
        this.cVF = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.m.GodHeadImageView);
            this.cVF = obtainStyledAttributes.getDimensionPixelSize(d.m.GodHeadImageView_extra_padding, DS6);
            this.cVD = obtainStyledAttributes.getInteger(d.m.GodHeadImageView_shape_type, this.cVC);
            this.cVB = obtainStyledAttributes.getInteger(d.m.GodHeadImageView_show_type, this.cVA);
            this.mRadius = obtainStyledAttributes.getInteger(d.m.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.cVy = new a(getContext());
        this.cVz = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.cVy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.cVy, layoutParams);
        addView(this.cVz, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.cVB = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.cVD = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.cVy.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.cVB) {
            case 0:
                this.cVy.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.cVy.setPadding(cVE, cVE, 0, 0);
                break;
        }
        switch (this.cVD) {
            case 1:
                this.cVy.setIsRound(true);
                if (this.cVB == 0) {
                    ak.c(this.cVz, d.f.pic_shen_avatar_big);
                    return;
                } else {
                    ak.c(this.cVz, d.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.cVy.setIsRound(false);
                this.cVy.setRadius(this.mRadius);
                ak.c(this.cVz, d.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.cVy.setIsRound(true);
                ak.c(this.cVz, d.f.browser_null_drawable);
                return;
            default:
                this.cVy.setIsRound(false);
                this.cVy.setRadius(this.mRadius);
                ak.c(this.cVz, d.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.cVF != i) {
            this.cVF = i;
            this.cVy.invalidate();
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
            if (GodHeadImageView.this.cVB == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.cVF, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.cVF, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
