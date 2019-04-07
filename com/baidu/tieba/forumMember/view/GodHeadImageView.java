package com.baidu.tieba.forumMember.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class GodHeadImageView extends FrameLayout {
    private a eWE;
    private ImageView eWF;
    private int eWG;
    private int eWH;
    private int eWI;
    private int eWJ;
    private int eWL;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int eWK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.eWG = 0;
        this.eWH = this.eWG;
        this.eWI = 1;
        this.eWJ = this.eWI;
        this.eWL = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWG = 0;
        this.eWH = this.eWG;
        this.eWI = 1;
        this.eWJ = this.eWI;
        this.eWL = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWG = 0;
        this.eWH = this.eWG;
        this.eWI = 1;
        this.eWJ = this.eWI;
        this.eWL = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.l.GodHeadImageView);
            this.eWL = obtainStyledAttributes.getDimensionPixelSize(d.l.GodHeadImageView_extra_padding, DS6);
            this.eWJ = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_shape_type, this.eWI);
            this.eWH = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_show_type, this.eWG);
            this.mRadius = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.eWE = new a(getContext());
        this.eWF = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eWE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.eWE, layoutParams);
        addView(this.eWF, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.eWH = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.eWJ = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.eWE.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.eWH) {
            case 0:
                this.eWE.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.eWE.setPadding(eWK, eWK, 0, 0);
                break;
        }
        switch (this.eWJ) {
            case 1:
                this.eWE.setIsRound(true);
                if (this.eWH == 0) {
                    al.c(this.eWF, d.f.pic_shen_avatar_big);
                    return;
                } else {
                    al.c(this.eWF, d.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.eWE.setIsRound(false);
                this.eWE.setRadius(this.mRadius);
                al.c(this.eWF, d.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.eWE.setIsRound(true);
                al.c(this.eWF, d.f.browser_null_drawable);
                return;
            default:
                this.eWE.setIsRound(false);
                this.eWE.setRadius(this.mRadius);
                al.c(this.eWF, d.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.eWL != i) {
            this.eWL = i;
            this.eWE.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.eWH == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.eWL, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.eWL, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
