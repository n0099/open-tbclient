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
/* loaded from: classes7.dex */
public class GodHeadImageView extends FrameLayout {
    private a ggN;
    private ImageView ggO;
    private int ggP;
    private int ggQ;
    private int ggR;
    private int ggS;
    private int ggU;
    private int mRadius;
    private static final int amy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int ggT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.ggP = 0;
        this.ggQ = this.ggP;
        this.ggR = 1;
        this.ggS = this.ggR;
        this.ggU = amy;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ggP = 0;
        this.ggQ = this.ggP;
        this.ggR = 1;
        this.ggS = this.ggR;
        this.ggU = amy;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ggP = 0;
        this.ggQ = this.ggP;
        this.ggR = 1;
        this.ggS = this.ggR;
        this.ggU = amy;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GodHeadImageView);
            this.ggU = obtainStyledAttributes.getDimensionPixelSize(0, amy);
            this.ggS = obtainStyledAttributes.getInteger(3, this.ggR);
            this.ggQ = obtainStyledAttributes.getInteger(2, this.ggP);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.ggN = new a(getContext());
        this.ggO = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.ggN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.ggN, layoutParams);
        addView(this.ggO, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.ggQ = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.ggS = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.ggN.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.ggQ) {
            case 0:
                this.ggN.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.ggN.setPadding(ggT, ggT, 0, 0);
                break;
        }
        switch (this.ggS) {
            case 1:
                this.ggN.setIsRound(true);
                if (this.ggQ == 0) {
                    am.setImageResource(this.ggO, R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    am.setImageResource(this.ggO, R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.ggN.setIsRound(false);
                this.ggN.setRadius(this.mRadius);
                am.setImageResource(this.ggO, R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.ggN.setIsRound(true);
                am.setImageResource(this.ggO, R.drawable.browser_null_drawable);
                return;
            default:
                this.ggN.setIsRound(false);
                this.ggN.setRadius(this.mRadius);
                am.setImageResource(this.ggO, R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.ggU != i) {
            this.ggU = i;
            this.ggN.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.ggQ == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.ggU, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.ggU, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
