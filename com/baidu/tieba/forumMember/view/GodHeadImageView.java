package com.baidu.tieba.forumMember.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class GodHeadImageView extends FrameLayout {
    private a hxl;
    private ImageView hxm;
    private int hxn;
    private int hxo;
    private int hxp;
    private int hxq;
    private int hxs;
    private int mRadius;
    private static final int aRS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int hxr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.hxn = 0;
        this.hxo = this.hxn;
        this.hxp = 1;
        this.hxq = this.hxp;
        this.hxs = aRS;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hxn = 0;
        this.hxo = this.hxn;
        this.hxp = 1;
        this.hxq = this.hxp;
        this.hxs = aRS;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hxn = 0;
        this.hxo = this.hxn;
        this.hxp = 1;
        this.hxq = this.hxp;
        this.hxs = aRS;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.hxs = obtainStyledAttributes.getDimensionPixelSize(0, aRS);
            this.hxq = obtainStyledAttributes.getInteger(3, this.hxp);
            this.hxo = obtainStyledAttributes.getInteger(2, this.hxn);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.hxl = new a(getContext());
        this.hxm = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.hxl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.hxl, layoutParams);
        addView(this.hxm, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.hxo = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.hxq = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.hxl.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.hxo) {
            case 0:
                this.hxl.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.hxl.setPadding(hxr, hxr, 0, 0);
                break;
        }
        switch (this.hxq) {
            case 1:
                this.hxl.setIsRound(true);
                if (this.hxo == 0) {
                    an.setImageResource(this.hxm, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    an.setImageResource(this.hxm, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.hxl.setIsRound(false);
                this.hxl.setRadius(this.mRadius);
                an.setImageResource(this.hxm, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.hxl.setIsRound(true);
                an.setImageResource(this.hxm, R.drawable.browser_null_drawable);
                return;
            default:
                this.hxl.setIsRound(false);
                this.hxl.setRadius(this.mRadius);
                an.setImageResource(this.hxm, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.hxs != i) {
            this.hxs = i;
            this.hxl.invalidate();
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
            if (GodHeadImageView.this.hxo == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.hxs, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.hxs, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
