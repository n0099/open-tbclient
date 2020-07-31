package com.baidu.tieba.forumMember.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class GodHeadImageView extends FrameLayout {
    private a hCZ;
    private ImageView hDa;
    private int hDb;
    private int hDc;
    private int hDd;
    private int hDe;
    private int hDg;
    private int mRadius;
    private static final int aTl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int hDf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.hDb = 0;
        this.hDc = this.hDb;
        this.hDd = 1;
        this.hDe = this.hDd;
        this.hDg = aTl;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hDb = 0;
        this.hDc = this.hDb;
        this.hDd = 1;
        this.hDe = this.hDd;
        this.hDg = aTl;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hDb = 0;
        this.hDc = this.hDb;
        this.hDd = 1;
        this.hDe = this.hDd;
        this.hDg = aTl;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.hDg = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GodHeadImageView_extra_padding, aTl);
            this.hDe = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_shape_type, this.hDd);
            this.hDc = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_show_type, this.hDb);
            this.mRadius = obtainStyledAttributes.getInteger(R.styleable.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.hCZ = new a(getContext());
        this.hDa = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.hCZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.hCZ, layoutParams);
        addView(this.hDa, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.hDc = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.hDe = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.hCZ.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.hDc) {
            case 0:
                this.hCZ.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.hCZ.setPadding(hDf, hDf, 0, 0);
                break;
        }
        switch (this.hDe) {
            case 1:
                this.hCZ.setIsRound(true);
                if (this.hDc == 0) {
                    ao.setImageResource(this.hDa, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    ao.setImageResource(this.hDa, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.hCZ.setIsRound(false);
                this.hCZ.setRadius(this.mRadius);
                ao.setImageResource(this.hDa, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.hCZ.setIsRound(true);
                ao.setImageResource(this.hDa, R.drawable.browser_null_drawable);
                return;
            default:
                this.hCZ.setIsRound(false);
                this.hCZ.setRadius(this.mRadius);
                ao.setImageResource(this.hDa, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.hDg != i) {
            this.hDg = i;
            this.hCZ.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.hDc == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.hDg, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.hDg, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
