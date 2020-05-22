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
    private a hkT;
    private ImageView hkU;
    private int hkV;
    private int hkW;
    private int hkX;
    private int hkY;
    private int hla;
    private int mRadius;
    private static final int aPm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int hkZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.hkV = 0;
        this.hkW = this.hkV;
        this.hkX = 1;
        this.hkY = this.hkX;
        this.hla = aPm;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hkV = 0;
        this.hkW = this.hkV;
        this.hkX = 1;
        this.hkY = this.hkX;
        this.hla = aPm;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hkV = 0;
        this.hkW = this.hkV;
        this.hkX = 1;
        this.hkY = this.hkX;
        this.hla = aPm;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.hla = obtainStyledAttributes.getDimensionPixelSize(0, aPm);
            this.hkY = obtainStyledAttributes.getInteger(3, this.hkX);
            this.hkW = obtainStyledAttributes.getInteger(2, this.hkV);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.hkT = new a(getContext());
        this.hkU = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.hkT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.hkT, layoutParams);
        addView(this.hkU, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.hkW = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.hkY = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.hkT.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.hkW) {
            case 0:
                this.hkT.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.hkT.setPadding(hkZ, hkZ, 0, 0);
                break;
        }
        switch (this.hkY) {
            case 1:
                this.hkT.setIsRound(true);
                if (this.hkW == 0) {
                    am.setImageResource(this.hkU, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    am.setImageResource(this.hkU, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.hkT.setIsRound(false);
                this.hkT.setRadius(this.mRadius);
                am.setImageResource(this.hkU, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.hkT.setIsRound(true);
                am.setImageResource(this.hkU, R.drawable.browser_null_drawable);
                return;
            default:
                this.hkT.setIsRound(false);
                this.hkT.setRadius(this.mRadius);
                am.setImageResource(this.hkU, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.hla != i) {
            this.hla = i;
            this.hkT.invalidate();
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
            if (GodHeadImageView.this.hkW == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.hla, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.hla, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
