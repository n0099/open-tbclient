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
    private a fmJ;
    private ImageView fmK;
    private int fmL;
    private int fmM;
    private int fmN;
    private int fmO;
    private int fmQ;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int fmP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.fmL = 0;
        this.fmM = this.fmL;
        this.fmN = 1;
        this.fmO = this.fmN;
        this.fmQ = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmL = 0;
        this.fmM = this.fmL;
        this.fmN = 1;
        this.fmO = this.fmN;
        this.fmQ = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmL = 0;
        this.fmM = this.fmL;
        this.fmN = 1;
        this.fmO = this.fmN;
        this.fmQ = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.a.GodHeadImageView);
            this.fmQ = obtainStyledAttributes.getDimensionPixelSize(0, DS6);
            this.fmO = obtainStyledAttributes.getInteger(3, this.fmN);
            this.fmM = obtainStyledAttributes.getInteger(2, this.fmL);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.fmJ = new a(getContext());
        this.fmK = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.fmJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.fmJ, layoutParams);
        addView(this.fmK, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.fmM = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.fmO = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.fmJ.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.fmM) {
            case 0:
                this.fmJ.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.fmJ.setPadding(fmP, fmP, 0, 0);
                break;
        }
        switch (this.fmO) {
            case 1:
                this.fmJ.setIsRound(true);
                if (this.fmM == 0) {
                    al.c(this.fmK, (int) R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    al.c(this.fmK, (int) R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.fmJ.setIsRound(false);
                this.fmJ.setRadius(this.mRadius);
                al.c(this.fmK, (int) R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.fmJ.setIsRound(true);
                al.c(this.fmK, (int) R.drawable.browser_null_drawable);
                return;
            default:
                this.fmJ.setIsRound(false);
                this.fmJ.setRadius(this.mRadius);
                al.c(this.fmK, (int) R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.fmQ != i) {
            this.fmQ = i;
            this.fmJ.invalidate();
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
            if (GodHeadImageView.this.fmM == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.fmQ, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.fmQ, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
