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
    private a eWS;
    private ImageView eWT;
    private int eWU;
    private int eWV;
    private int eWW;
    private int eWX;
    private int eWZ;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int eWY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.eWU = 0;
        this.eWV = this.eWU;
        this.eWW = 1;
        this.eWX = this.eWW;
        this.eWZ = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWU = 0;
        this.eWV = this.eWU;
        this.eWW = 1;
        this.eWX = this.eWW;
        this.eWZ = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWU = 0;
        this.eWV = this.eWU;
        this.eWW = 1;
        this.eWX = this.eWW;
        this.eWZ = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.l.GodHeadImageView);
            this.eWZ = obtainStyledAttributes.getDimensionPixelSize(d.l.GodHeadImageView_extra_padding, DS6);
            this.eWX = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_shape_type, this.eWW);
            this.eWV = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_show_type, this.eWU);
            this.mRadius = obtainStyledAttributes.getInteger(d.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.eWS = new a(getContext());
        this.eWT = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.eWS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.eWS, layoutParams);
        addView(this.eWT, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.eWV = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.eWX = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.eWS.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.eWV) {
            case 0:
                this.eWS.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.eWS.setPadding(eWY, eWY, 0, 0);
                break;
        }
        switch (this.eWX) {
            case 1:
                this.eWS.setIsRound(true);
                if (this.eWV == 0) {
                    al.c(this.eWT, d.f.pic_shen_avatar_big);
                    return;
                } else {
                    al.c(this.eWT, d.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.eWS.setIsRound(false);
                this.eWS.setRadius(this.mRadius);
                al.c(this.eWT, d.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.eWS.setIsRound(true);
                al.c(this.eWT, d.f.browser_null_drawable);
                return;
            default:
                this.eWS.setIsRound(false);
                this.eWS.setRadius(this.mRadius);
                al.c(this.eWT, d.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.eWZ != i) {
            this.eWZ = i;
            this.eWS.invalidate();
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
            if (GodHeadImageView.this.eWV == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.eWZ, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.eWZ, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
