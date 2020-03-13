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
    private a gmn;
    private ImageView gmo;
    private int gmp;
    private int gmq;
    private int gmr;
    private int gms;
    private int gmu;
    private int mRadius;
    private static final int aqE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int gmt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.gmp = 0;
        this.gmq = this.gmp;
        this.gmr = 1;
        this.gms = this.gmr;
        this.gmu = aqE;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gmp = 0;
        this.gmq = this.gmp;
        this.gmr = 1;
        this.gms = this.gmr;
        this.gmu = aqE;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gmp = 0;
        this.gmq = this.gmp;
        this.gmr = 1;
        this.gms = this.gmr;
        this.gmu = aqE;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.gmu = obtainStyledAttributes.getDimensionPixelSize(0, aqE);
            this.gms = obtainStyledAttributes.getInteger(3, this.gmr);
            this.gmq = obtainStyledAttributes.getInteger(2, this.gmp);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.gmn = new a(getContext());
        this.gmo = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.gmn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.gmn, layoutParams);
        addView(this.gmo, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.gmq = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.gms = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.gmn.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.gmq) {
            case 0:
                this.gmn.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.gmn.setPadding(gmt, gmt, 0, 0);
                break;
        }
        switch (this.gms) {
            case 1:
                this.gmn.setIsRound(true);
                if (this.gmq == 0) {
                    am.setImageResource(this.gmo, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    am.setImageResource(this.gmo, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.gmn.setIsRound(false);
                this.gmn.setRadius(this.mRadius);
                am.setImageResource(this.gmo, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.gmn.setIsRound(true);
                am.setImageResource(this.gmo, R.drawable.browser_null_drawable);
                return;
            default:
                this.gmn.setIsRound(false);
                this.gmn.setRadius(this.mRadius);
                am.setImageResource(this.gmo, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.gmu != i) {
            this.gmu = i;
            this.gmn.invalidate();
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
            if (GodHeadImageView.this.gmq == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.gmu, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.gmu, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
