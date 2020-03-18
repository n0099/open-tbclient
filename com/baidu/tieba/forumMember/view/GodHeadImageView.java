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
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class GodHeadImageView extends FrameLayout {
    private a gmV;
    private ImageView gmW;
    private int gmX;
    private int gmY;
    private int gmZ;
    private int gna;
    private int gnc;
    private int mRadius;
    private static final int aqO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int gnb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.gmX = 0;
        this.gmY = this.gmX;
        this.gmZ = 1;
        this.gna = this.gmZ;
        this.gnc = aqO;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gmX = 0;
        this.gmY = this.gmX;
        this.gmZ = 1;
        this.gna = this.gmZ;
        this.gnc = aqO;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gmX = 0;
        this.gmY = this.gmX;
        this.gmZ = 1;
        this.gna = this.gmZ;
        this.gnc = aqO;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.gnc = obtainStyledAttributes.getDimensionPixelSize(0, aqO);
            this.gna = obtainStyledAttributes.getInteger(3, this.gmZ);
            this.gmY = obtainStyledAttributes.getInteger(2, this.gmX);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.gmV = new a(getContext());
        this.gmW = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.gmV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.gmV, layoutParams);
        addView(this.gmW, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.gmY = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.gna = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.gmV.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.gmY) {
            case 0:
                this.gmV.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.gmV.setPadding(gnb, gnb, 0, 0);
                break;
        }
        switch (this.gna) {
            case 1:
                this.gmV.setIsRound(true);
                if (this.gmY == 0) {
                    am.setImageResource(this.gmW, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    am.setImageResource(this.gmW, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.gmV.setIsRound(false);
                this.gmV.setRadius(this.mRadius);
                am.setImageResource(this.gmW, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.gmV.setIsRound(true);
                am.setImageResource(this.gmW, R.drawable.browser_null_drawable);
                return;
            default:
                this.gmV.setIsRound(false);
                this.gmV.setRadius(this.mRadius);
                am.setImageResource(this.gmW, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.gnc != i) {
            this.gnc = i;
            this.gmV.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.gmY == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.gnc, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.gnc, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
