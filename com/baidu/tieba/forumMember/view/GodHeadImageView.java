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
import com.baidu.tieba.R;
import com.baidu.tieba.c;
/* loaded from: classes5.dex */
public class GodHeadImageView extends FrameLayout {
    private a fmK;
    private ImageView fmL;
    private int fmM;
    private int fmN;
    private int fmO;
    private int fmP;
    private int fmR;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int fmQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.fmM = 0;
        this.fmN = this.fmM;
        this.fmO = 1;
        this.fmP = this.fmO;
        this.fmR = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmM = 0;
        this.fmN = this.fmM;
        this.fmO = 1;
        this.fmP = this.fmO;
        this.fmR = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmM = 0;
        this.fmN = this.fmM;
        this.fmO = 1;
        this.fmP = this.fmO;
        this.fmR = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.a.GodHeadImageView);
            this.fmR = obtainStyledAttributes.getDimensionPixelSize(0, DS6);
            this.fmP = obtainStyledAttributes.getInteger(3, this.fmO);
            this.fmN = obtainStyledAttributes.getInteger(2, this.fmM);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.fmK = new a(getContext());
        this.fmL = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.fmK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.fmK, layoutParams);
        addView(this.fmL, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.fmN = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.fmP = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.fmK.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.fmN) {
            case 0:
                this.fmK.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.fmK.setPadding(fmQ, fmQ, 0, 0);
                break;
        }
        switch (this.fmP) {
            case 1:
                this.fmK.setIsRound(true);
                if (this.fmN == 0) {
                    al.c(this.fmL, (int) R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    al.c(this.fmL, (int) R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.fmK.setIsRound(false);
                this.fmK.setRadius(this.mRadius);
                al.c(this.fmL, (int) R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.fmK.setIsRound(true);
                al.c(this.fmL, (int) R.drawable.browser_null_drawable);
                return;
            default:
                this.fmK.setIsRound(false);
                this.fmK.setRadius(this.mRadius);
                al.c(this.fmL, (int) R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.fmR != i) {
            this.fmR = i;
            this.fmK.invalidate();
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
            if (GodHeadImageView.this.fmN == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.fmR, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.fmR, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
