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
    private a gWh;
    private ImageView gWi;
    private int gWj;
    private int gWk;
    private int gWl;
    private int gWm;
    private int gWo;
    private int mRadius;
    private static final int aJD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int gWn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.gWj = 0;
        this.gWk = this.gWj;
        this.gWl = 1;
        this.gWm = this.gWl;
        this.gWo = aJD;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gWj = 0;
        this.gWk = this.gWj;
        this.gWl = 1;
        this.gWm = this.gWl;
        this.gWo = aJD;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gWj = 0;
        this.gWk = this.gWj;
        this.gWl = 1;
        this.gWm = this.gWl;
        this.gWo = aJD;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.gWo = obtainStyledAttributes.getDimensionPixelSize(0, aJD);
            this.gWm = obtainStyledAttributes.getInteger(3, this.gWl);
            this.gWk = obtainStyledAttributes.getInteger(2, this.gWj);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.gWh = new a(getContext());
        this.gWi = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.gWh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.gWh, layoutParams);
        addView(this.gWi, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.gWk = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.gWm = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.gWh.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.gWk) {
            case 0:
                this.gWh.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.gWh.setPadding(gWn, gWn, 0, 0);
                break;
        }
        switch (this.gWm) {
            case 1:
                this.gWh.setIsRound(true);
                if (this.gWk == 0) {
                    am.setImageResource(this.gWi, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    am.setImageResource(this.gWi, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.gWh.setIsRound(false);
                this.gWh.setRadius(this.mRadius);
                am.setImageResource(this.gWi, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.gWh.setIsRound(true);
                am.setImageResource(this.gWi, R.drawable.browser_null_drawable);
                return;
            default:
                this.gWh.setIsRound(false);
                this.gWh.setRadius(this.mRadius);
                am.setImageResource(this.gWi, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.gWo != i) {
            this.gWo = i;
            this.gWh.invalidate();
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
            if (GodHeadImageView.this.gWk == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.gWo, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.gWo, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
