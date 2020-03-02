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
    private a gma;
    private ImageView gmb;
    private int gmc;
    private int gmd;
    private int gme;
    private int gmf;
    private int gmh;
    private int mRadius;
    private static final int aqD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int gmg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.gmc = 0;
        this.gmd = this.gmc;
        this.gme = 1;
        this.gmf = this.gme;
        this.gmh = aqD;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gmc = 0;
        this.gmd = this.gmc;
        this.gme = 1;
        this.gmf = this.gme;
        this.gmh = aqD;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gmc = 0;
        this.gmd = this.gmc;
        this.gme = 1;
        this.gmf = this.gme;
        this.gmh = aqD;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.gmh = obtainStyledAttributes.getDimensionPixelSize(0, aqD);
            this.gmf = obtainStyledAttributes.getInteger(3, this.gme);
            this.gmd = obtainStyledAttributes.getInteger(2, this.gmc);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.gma = new a(getContext());
        this.gmb = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.gma.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.gma, layoutParams);
        addView(this.gmb, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.gmd = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.gmf = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.gma.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.gmd) {
            case 0:
                this.gma.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.gma.setPadding(gmg, gmg, 0, 0);
                break;
        }
        switch (this.gmf) {
            case 1:
                this.gma.setIsRound(true);
                if (this.gmd == 0) {
                    am.setImageResource(this.gmb, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    am.setImageResource(this.gmb, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.gma.setIsRound(false);
                this.gma.setRadius(this.mRadius);
                am.setImageResource(this.gmb, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.gma.setIsRound(true);
                am.setImageResource(this.gmb, R.drawable.browser_null_drawable);
                return;
            default:
                this.gma.setIsRound(false);
                this.gma.setRadius(this.mRadius);
                am.setImageResource(this.gmb, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.gmh != i) {
            this.gmh = i;
            this.gma.invalidate();
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
            if (GodHeadImageView.this.gmd == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.gmh, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.gmh, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
