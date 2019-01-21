package com.baidu.tieba.forumMember.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class GodHeadImageView extends FrameLayout {
    private a dJC;
    private ImageView dJD;
    private int dJE;
    private int dJF;
    private int dJG;
    private int dJH;
    private int dJJ;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds6);
    private static final int dJI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.dJE = 0;
        this.dJF = this.dJE;
        this.dJG = 1;
        this.dJH = this.dJG;
        this.dJJ = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dJE = 0;
        this.dJF = this.dJE;
        this.dJG = 1;
        this.dJH = this.dJG;
        this.dJJ = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dJE = 0;
        this.dJF = this.dJE;
        this.dJG = 1;
        this.dJH = this.dJG;
        this.dJJ = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.l.GodHeadImageView);
            this.dJJ = obtainStyledAttributes.getDimensionPixelSize(e.l.GodHeadImageView_extra_padding, DS6);
            this.dJH = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_shape_type, this.dJG);
            this.dJF = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_show_type, this.dJE);
            this.mRadius = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.dJC = new a(getContext());
        this.dJD = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dJC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.dJC, layoutParams);
        addView(this.dJD, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.dJF = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.dJH = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.dJC.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.dJF) {
            case 0:
                this.dJC.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.dJC.setPadding(dJI, dJI, 0, 0);
                break;
        }
        switch (this.dJH) {
            case 1:
                this.dJC.setIsRound(true);
                if (this.dJF == 0) {
                    al.c(this.dJD, e.f.pic_shen_avatar_big);
                    return;
                } else {
                    al.c(this.dJD, e.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.dJC.setIsRound(false);
                this.dJC.setRadius(this.mRadius);
                al.c(this.dJD, e.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.dJC.setIsRound(true);
                al.c(this.dJD, e.f.browser_null_drawable);
                return;
            default:
                this.dJC.setIsRound(false);
                this.dJC.setRadius(this.mRadius);
                al.c(this.dJD, e.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.dJJ != i) {
            this.dJJ = i;
            this.dJC.invalidate();
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
            if (GodHeadImageView.this.dJF == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.dJJ, AiAppsFileUtils.GB);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.dJJ, AiAppsFileUtils.GB);
            }
            super.onMeasure(i, i2);
        }
    }
}
