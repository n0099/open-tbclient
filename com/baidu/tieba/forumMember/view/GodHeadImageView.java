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
    private a eWF;
    private ImageView eWG;
    private int eWH;
    private int eWI;
    private int eWJ;
    private int eWK;
    private int eWM;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int eWL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.eWH = 0;
        this.eWI = this.eWH;
        this.eWJ = 1;
        this.eWK = this.eWJ;
        this.eWM = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWH = 0;
        this.eWI = this.eWH;
        this.eWJ = 1;
        this.eWK = this.eWJ;
        this.eWM = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWH = 0;
        this.eWI = this.eWH;
        this.eWJ = 1;
        this.eWK = this.eWJ;
        this.eWM = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.l.GodHeadImageView);
            this.eWM = obtainStyledAttributes.getDimensionPixelSize(d.l.GodHeadImageView_extra_padding, DS6);
            this.eWK = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_shape_type, this.eWJ);
            this.eWI = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_show_type, this.eWH);
            this.mRadius = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.eWF = new a(getContext());
        this.eWG = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eWF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.eWF, layoutParams);
        addView(this.eWG, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.eWI = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.eWK = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.eWF.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.eWI) {
            case 0:
                this.eWF.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.eWF.setPadding(eWL, eWL, 0, 0);
                break;
        }
        switch (this.eWK) {
            case 1:
                this.eWF.setIsRound(true);
                if (this.eWI == 0) {
                    al.c(this.eWG, d.f.pic_shen_avatar_big);
                    return;
                } else {
                    al.c(this.eWG, d.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.eWF.setIsRound(false);
                this.eWF.setRadius(this.mRadius);
                al.c(this.eWG, d.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.eWF.setIsRound(true);
                al.c(this.eWG, d.f.browser_null_drawable);
                return;
            default:
                this.eWF.setIsRound(false);
                this.eWF.setRadius(this.mRadius);
                al.c(this.eWG, d.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.eWM != i) {
            this.eWM = i;
            this.eWF.invalidate();
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
            if (GodHeadImageView.this.eWI == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.eWM, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.eWM, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
