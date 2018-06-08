package com.baidu.tieba.forumMember.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class GodHeadImageView extends FrameLayout {
    private a dfP;
    private ImageView dfQ;
    private int dfR;
    private int dfS;
    private int dfT;
    private int dfU;
    private int dfW;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
    private static final int dfV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.dfR = 0;
        this.dfS = this.dfR;
        this.dfT = 1;
        this.dfU = this.dfT;
        this.dfW = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dfR = 0;
        this.dfS = this.dfR;
        this.dfT = 1;
        this.dfU = this.dfT;
        this.dfW = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dfR = 0;
        this.dfS = this.dfR;
        this.dfT = 1;
        this.dfU = this.dfT;
        this.dfW = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.m.GodHeadImageView);
            this.dfW = obtainStyledAttributes.getDimensionPixelSize(d.m.GodHeadImageView_extra_padding, DS6);
            this.dfU = obtainStyledAttributes.getInteger(d.m.GodHeadImageView_shape_type, this.dfT);
            this.dfS = obtainStyledAttributes.getInteger(d.m.GodHeadImageView_show_type, this.dfR);
            this.mRadius = obtainStyledAttributes.getInteger(d.m.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.dfP = new a(getContext());
        this.dfQ = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dfP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.dfP, layoutParams);
        addView(this.dfQ, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.dfS = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.dfU = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.dfP.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.dfS) {
            case 0:
                this.dfP.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.dfP.setPadding(dfV, dfV, 0, 0);
                break;
        }
        switch (this.dfU) {
            case 1:
                this.dfP.setIsRound(true);
                if (this.dfS == 0) {
                    al.c(this.dfQ, d.f.pic_shen_avatar_big);
                    return;
                } else {
                    al.c(this.dfQ, d.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.dfP.setIsRound(false);
                this.dfP.setRadius(this.mRadius);
                al.c(this.dfQ, d.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.dfP.setIsRound(true);
                al.c(this.dfQ, d.f.browser_null_drawable);
                return;
            default:
                this.dfP.setIsRound(false);
                this.dfP.setRadius(this.mRadius);
                al.c(this.dfQ, d.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.dfW != i) {
            this.dfW = i;
            this.dfP.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends HeadImageView {
        public a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
        public void onMeasure(int i, int i2) {
            if (GodHeadImageView.this.dfS == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.dfW, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.dfW, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }
}
