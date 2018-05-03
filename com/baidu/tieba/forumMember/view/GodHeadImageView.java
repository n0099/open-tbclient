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
    private int cVC;
    private a cVv;
    private ImageView cVw;
    private int cVx;
    private int cVy;
    private int cVz;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int cVB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.cVx = 0;
        this.cVy = this.cVx;
        this.cVz = 1;
        this.cVA = this.cVz;
        this.cVC = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVx = 0;
        this.cVy = this.cVx;
        this.cVz = 1;
        this.cVA = this.cVz;
        this.cVC = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cVx = 0;
        this.cVy = this.cVx;
        this.cVz = 1;
        this.cVA = this.cVz;
        this.cVC = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.m.GodHeadImageView);
            this.cVC = obtainStyledAttributes.getDimensionPixelSize(d.m.GodHeadImageView_extra_padding, DS6);
            this.cVA = obtainStyledAttributes.getInteger(d.m.GodHeadImageView_shape_type, this.cVz);
            this.cVy = obtainStyledAttributes.getInteger(d.m.GodHeadImageView_show_type, this.cVx);
            this.mRadius = obtainStyledAttributes.getInteger(d.m.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.cVv = new a(getContext());
        this.cVw = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.cVv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.cVv, layoutParams);
        addView(this.cVw, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.cVy = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.cVA = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.cVv.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.cVy) {
            case 0:
                this.cVv.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.cVv.setPadding(cVB, cVB, 0, 0);
                break;
        }
        switch (this.cVA) {
            case 1:
                this.cVv.setIsRound(true);
                if (this.cVy == 0) {
                    ak.c(this.cVw, d.f.pic_shen_avatar_big);
                    return;
                } else {
                    ak.c(this.cVw, d.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.cVv.setIsRound(false);
                this.cVv.setRadius(this.mRadius);
                ak.c(this.cVw, d.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.cVv.setIsRound(true);
                ak.c(this.cVw, d.f.browser_null_drawable);
                return;
            default:
                this.cVv.setIsRound(false);
                this.cVv.setRadius(this.mRadius);
                ak.c(this.cVw, d.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.cVC != i) {
            this.cVC = i;
            this.cVv.invalidate();
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
            if (GodHeadImageView.this.cVy == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.cVC, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.cVC, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
