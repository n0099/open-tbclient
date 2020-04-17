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
    private a gWb;
    private ImageView gWc;
    private int gWd;
    private int gWe;
    private int gWf;
    private int gWg;
    private int gWi;
    private int mRadius;
    private static final int aJx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int gWh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.gWd = 0;
        this.gWe = this.gWd;
        this.gWf = 1;
        this.gWg = this.gWf;
        this.gWi = aJx;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gWd = 0;
        this.gWe = this.gWd;
        this.gWf = 1;
        this.gWg = this.gWf;
        this.gWi = aJx;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gWd = 0;
        this.gWe = this.gWd;
        this.gWf = 1;
        this.gWg = this.gWf;
        this.gWi = aJx;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.gWi = obtainStyledAttributes.getDimensionPixelSize(0, aJx);
            this.gWg = obtainStyledAttributes.getInteger(3, this.gWf);
            this.gWe = obtainStyledAttributes.getInteger(2, this.gWd);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.gWb = new a(getContext());
        this.gWc = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.gWb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.gWb, layoutParams);
        addView(this.gWc, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.gWe = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.gWg = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.gWb.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.gWe) {
            case 0:
                this.gWb.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.gWb.setPadding(gWh, gWh, 0, 0);
                break;
        }
        switch (this.gWg) {
            case 1:
                this.gWb.setIsRound(true);
                if (this.gWe == 0) {
                    am.setImageResource(this.gWc, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    am.setImageResource(this.gWc, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.gWb.setIsRound(false);
                this.gWb.setRadius(this.mRadius);
                am.setImageResource(this.gWc, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.gWb.setIsRound(true);
                am.setImageResource(this.gWc, R.drawable.browser_null_drawable);
                return;
            default:
                this.gWb.setIsRound(false);
                this.gWb.setRadius(this.mRadius);
                am.setImageResource(this.gWc, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.gWi != i) {
            this.gWi = i;
            this.gWb.invalidate();
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
            if (GodHeadImageView.this.gWe == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.gWi, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.gWi, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
