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
    private a hle;
    private ImageView hlf;
    private int hlg;
    private int hlh;
    private int hli;
    private int hlj;
    private int hll;
    private int mRadius;
    private static final int aPm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int hlk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.hlg = 0;
        this.hlh = this.hlg;
        this.hli = 1;
        this.hlj = this.hli;
        this.hll = aPm;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hlg = 0;
        this.hlh = this.hlg;
        this.hli = 1;
        this.hlj = this.hli;
        this.hll = aPm;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hlg = 0;
        this.hlh = this.hlg;
        this.hli = 1;
        this.hlj = this.hli;
        this.hll = aPm;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.hll = obtainStyledAttributes.getDimensionPixelSize(0, aPm);
            this.hlj = obtainStyledAttributes.getInteger(3, this.hli);
            this.hlh = obtainStyledAttributes.getInteger(2, this.hlg);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.hle = new a(getContext());
        this.hlf = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.hle.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.hle, layoutParams);
        addView(this.hlf, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.hlh = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.hlj = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.hle.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.hlh) {
            case 0:
                this.hle.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.hle.setPadding(hlk, hlk, 0, 0);
                break;
        }
        switch (this.hlj) {
            case 1:
                this.hle.setIsRound(true);
                if (this.hlh == 0) {
                    am.setImageResource(this.hlf, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    am.setImageResource(this.hlf, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.hle.setIsRound(false);
                this.hle.setRadius(this.mRadius);
                am.setImageResource(this.hlf, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.hle.setIsRound(true);
                am.setImageResource(this.hlf, R.drawable.browser_null_drawable);
                return;
            default:
                this.hle.setIsRound(false);
                this.hle.setRadius(this.mRadius);
                am.setImageResource(this.hlf, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.hll != i) {
            this.hll = i;
            this.hle.invalidate();
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
            if (GodHeadImageView.this.hlh == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.hll, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.hll, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
