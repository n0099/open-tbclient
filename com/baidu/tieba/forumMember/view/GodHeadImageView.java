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
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class GodHeadImageView extends FrameLayout {
    private a ftV;
    private ImageView ftW;
    private int ftX;
    private int ftY;
    private int ftZ;
    private int fua;
    private int fuc;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
    private static final int fub = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.ftX = 0;
        this.ftY = this.ftX;
        this.ftZ = 1;
        this.fua = this.ftZ;
        this.fuc = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ftX = 0;
        this.ftY = this.ftX;
        this.ftZ = 1;
        this.fua = this.ftZ;
        this.fuc = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ftX = 0;
        this.ftY = this.ftX;
        this.ftZ = 1;
        this.fua = this.ftZ;
        this.fuc = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.a.GodHeadImageView);
            this.fuc = obtainStyledAttributes.getDimensionPixelSize(0, DS6);
            this.fua = obtainStyledAttributes.getInteger(3, this.ftZ);
            this.ftY = obtainStyledAttributes.getInteger(2, this.ftX);
            this.mRadius = obtainStyledAttributes.getInteger(1, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.ftV = new a(getContext());
        this.ftW = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.ftV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.ftV, layoutParams);
        addView(this.ftW, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.ftY = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.fua = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.ftV.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.ftY) {
            case 0:
                this.ftV.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.ftV.setPadding(fub, fub, 0, 0);
                break;
        }
        switch (this.fua) {
            case 1:
                this.ftV.setIsRound(true);
                if (this.ftY == 0) {
                    am.c(this.ftW, (int) R.drawable.pic_shen_avatar_big);
                    return;
                } else {
                    am.c(this.ftW, (int) R.drawable.pic_shen_avatar);
                    return;
                }
            case 2:
                this.ftV.setIsRound(false);
                this.ftV.setRadius(this.mRadius);
                am.c(this.ftW, (int) R.drawable.pic_frs_shen_avatar);
                return;
            case 3:
                this.ftV.setIsRound(true);
                am.c(this.ftW, (int) R.drawable.browser_null_drawable);
                return;
            default:
                this.ftV.setIsRound(false);
                this.ftV.setRadius(this.mRadius);
                am.c(this.ftW, (int) R.drawable.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.fuc != i) {
            this.fuc = i;
            this.ftV.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.ftY == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.fuc, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.fuc, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
