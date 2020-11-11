package com.baidu.tieba.forumMember.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class GodHeadImageView extends FrameLayout {
    private a iEO;
    private ImageView iEP;
    private int iEQ;
    private int iER;
    private int iES;
    private int iET;
    private int iEV;
    private int mRadius;
    private static final int bhs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int iEU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.iEQ = 0;
        this.iER = this.iEQ;
        this.iES = 1;
        this.iET = this.iES;
        this.iEV = bhs;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iEQ = 0;
        this.iER = this.iEQ;
        this.iES = 1;
        this.iET = this.iES;
        this.iEV = bhs;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iEQ = 0;
        this.iER = this.iEQ;
        this.iES = 1;
        this.iET = this.iES;
        this.iEV = bhs;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.iEV = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GodHeadImageView_extra_padding, bhs);
            this.iET = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_shape_type, this.iES);
            this.iER = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_show_type, this.iEQ);
            this.mRadius = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.iEO = new a(getContext());
        this.iEP = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.iEO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.iEO, layoutParams);
        addView(this.iEP, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.iER = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.iET = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.iEO.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.iER) {
            case 0:
                this.iEO.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.iEO.setPadding(iEU, iEU, 0, 0);
                break;
        }
        switch (this.iET) {
            case 1:
                this.iEO.setIsRound(true);
                if (this.iER == 0) {
                    ap.setImageResource(this.iEP, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    ap.setImageResource(this.iEP, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.iEO.setIsRound(false);
                this.iEO.setRadius(this.mRadius);
                ap.setImageResource(this.iEP, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.iEO.setIsRound(true);
                ap.setImageResource(this.iEP, R.drawable.browser_null_drawable);
                return;
            default:
                this.iEO.setIsRound(false);
                this.iEO.setRadius(this.mRadius);
                ap.setImageResource(this.iEP, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.iEV != i) {
            this.iEV = i;
            this.iEO.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.iER == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.iEV, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.iEV, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
