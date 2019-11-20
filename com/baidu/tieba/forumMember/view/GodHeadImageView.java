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
/* loaded from: classes5.dex */
public class GodHeadImageView extends FrameLayout {
    private a fsr;
    private ImageView fss;
    private int fst;
    private int fsu;
    private int fsv;
    private int fsw;
    private int fsy;
    private int mRadius;
    private static final int aey = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int fsx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.fst = 0;
        this.fsu = this.fst;
        this.fsv = 1;
        this.fsw = this.fsv;
        this.fsy = aey;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fst = 0;
        this.fsu = this.fst;
        this.fsv = 1;
        this.fsw = this.fsv;
        this.fsy = aey;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fst = 0;
        this.fsu = this.fst;
        this.fsv = 1;
        this.fsw = this.fsv;
        this.fsy = aey;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.fsy = obtainStyledAttributes.getDimensionPixelSize(0, aey);
            this.fsw = obtainStyledAttributes.getInteger(3, this.fsv);
            this.fsu = obtainStyledAttributes.getInteger(2, this.fst);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.fsr = new a(getContext());
        this.fss = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.fsr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.fsr, layoutParams);
        addView(this.fss, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.fsu = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.fsw = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.fsr.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.fsu) {
            case 0:
                this.fsr.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.fsr.setPadding(fsx, fsx, 0, 0);
                break;
        }
        switch (this.fsw) {
            case 1:
                this.fsr.setIsRound(true);
                if (this.fsu == 0) {
                    am.setImageResource(this.fss, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    am.setImageResource(this.fss, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.fsr.setIsRound(false);
                this.fsr.setRadius(this.mRadius);
                am.setImageResource(this.fss, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.fsr.setIsRound(true);
                am.setImageResource(this.fss, R.drawable.browser_null_drawable);
                return;
            default:
                this.fsr.setIsRound(false);
                this.fsr.setRadius(this.mRadius);
                am.setImageResource(this.fss, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.fsy != i) {
            this.fsy = i;
            this.fsr.invalidate();
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
            if (GodHeadImageView.this.fsu == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.fsy, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.fsy, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
