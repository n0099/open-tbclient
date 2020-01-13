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
/* loaded from: classes8.dex */
public class GodHeadImageView extends FrameLayout {
    private a gjX;
    private ImageView gjY;
    private int gjZ;
    private int gka;
    private int gkb;
    private int gkc;
    private int gke;
    private int mRadius;
    private static final int anl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int gkd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.gjZ = 0;
        this.gka = this.gjZ;
        this.gkb = 1;
        this.gkc = this.gkb;
        this.gke = anl;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gjZ = 0;
        this.gka = this.gjZ;
        this.gkb = 1;
        this.gkc = this.gkb;
        this.gke = anl;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gjZ = 0;
        this.gka = this.gjZ;
        this.gkb = 1;
        this.gkc = this.gkb;
        this.gke = anl;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.gke = obtainStyledAttributes.getDimensionPixelSize(0, anl);
            this.gkc = obtainStyledAttributes.getInteger(3, this.gkb);
            this.gka = obtainStyledAttributes.getInteger(2, this.gjZ);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.gjX = new a(getContext());
        this.gjY = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.gjX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.gjX, layoutParams);
        addView(this.gjY, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.gka = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.gkc = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.gjX.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.gka) {
            case 0:
                this.gjX.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.gjX.setPadding(gkd, gkd, 0, 0);
                break;
        }
        switch (this.gkc) {
            case 1:
                this.gjX.setIsRound(true);
                if (this.gka == 0) {
                    am.setImageResource(this.gjY, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    am.setImageResource(this.gjY, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.gjX.setIsRound(false);
                this.gjX.setRadius(this.mRadius);
                am.setImageResource(this.gjY, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.gjX.setIsRound(true);
                am.setImageResource(this.gjY, R.drawable.browser_null_drawable);
                return;
            default:
                this.gjX.setIsRound(false);
                this.gjX.setRadius(this.mRadius);
                am.setImageResource(this.gjY, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.gke != i) {
            this.gke = i;
            this.gjX.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.gka == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.gke, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.gke, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
