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
import com.baidu.tieba.c;
/* loaded from: classes5.dex */
public class GodHeadImageView extends FrameLayout {
    private a frJ;
    private ImageView frK;
    private int frL;
    private int frM;
    private int frN;
    private int frO;
    private int frQ;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int frP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.frL = 0;
        this.frM = this.frL;
        this.frN = 1;
        this.frO = this.frN;
        this.frQ = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.frL = 0;
        this.frM = this.frL;
        this.frN = 1;
        this.frO = this.frN;
        this.frQ = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.frL = 0;
        this.frM = this.frL;
        this.frN = 1;
        this.frO = this.frN;
        this.frQ = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.a.GodHeadImageView);
            this.frQ = obtainStyledAttributes.getDimensionPixelSize(0, DS6);
            this.frO = obtainStyledAttributes.getInteger(3, this.frN);
            this.frM = obtainStyledAttributes.getInteger(2, this.frL);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.frJ = new a(getContext());
        this.frK = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.frJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.frJ, layoutParams);
        addView(this.frK, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.frM = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.frO = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.frJ.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.frM) {
            case 0:
                this.frJ.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.frJ.setPadding(frP, frP, 0, 0);
                break;
        }
        switch (this.frO) {
            case 1:
                this.frJ.setIsRound(true);
                if (this.frM == 0) {
                    am.c(this.frK, (int) R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    am.c(this.frK, (int) R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.frJ.setIsRound(false);
                this.frJ.setRadius(this.mRadius);
                am.c(this.frK, (int) R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.frJ.setIsRound(true);
                am.c(this.frK, (int) R.drawable.browser_null_drawable);
                return;
            default:
                this.frJ.setIsRound(false);
                this.frJ.setRadius(this.mRadius);
                am.c(this.frK, (int) R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.frQ != i) {
            this.frQ = i;
            this.frJ.invalidate();
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
            if (GodHeadImageView.this.frM == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.frQ, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.frQ, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
