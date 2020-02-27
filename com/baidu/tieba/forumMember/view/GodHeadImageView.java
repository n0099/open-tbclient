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
    private a glY;
    private ImageView glZ;
    private int gma;
    private int gmb;
    private int gmc;
    private int gmd;
    private int gmf;
    private int mRadius;
    private static final int aqD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int gme = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.gma = 0;
        this.gmb = this.gma;
        this.gmc = 1;
        this.gmd = this.gmc;
        this.gmf = aqD;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gma = 0;
        this.gmb = this.gma;
        this.gmc = 1;
        this.gmd = this.gmc;
        this.gmf = aqD;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gma = 0;
        this.gmb = this.gma;
        this.gmc = 1;
        this.gmd = this.gmc;
        this.gmf = aqD;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.gmf = obtainStyledAttributes.getDimensionPixelSize(0, aqD);
            this.gmd = obtainStyledAttributes.getInteger(3, this.gmc);
            this.gmb = obtainStyledAttributes.getInteger(2, this.gma);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.glY = new a(getContext());
        this.glZ = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.glY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.glY, layoutParams);
        addView(this.glZ, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.gmb = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.gmd = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.glY.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.gmb) {
            case 0:
                this.glY.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.glY.setPadding(gme, gme, 0, 0);
                break;
        }
        switch (this.gmd) {
            case 1:
                this.glY.setIsRound(true);
                if (this.gmb == 0) {
                    am.setImageResource(this.glZ, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    am.setImageResource(this.glZ, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.glY.setIsRound(false);
                this.glY.setRadius(this.mRadius);
                am.setImageResource(this.glZ, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.glY.setIsRound(true);
                am.setImageResource(this.glZ, R.drawable.browser_null_drawable);
                return;
            default:
                this.glY.setIsRound(false);
                this.glY.setRadius(this.mRadius);
                am.setImageResource(this.glZ, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.gmf != i) {
            this.gmf = i;
            this.glY.invalidate();
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
            if (GodHeadImageView.this.gmb == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.gmf, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.gmf, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
