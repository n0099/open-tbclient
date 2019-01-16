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
    private a dJB;
    private ImageView dJC;
    private int dJD;
    private int dJE;
    private int dJF;
    private int dJG;
    private int dJI;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds6);
    private static final int dJH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.dJD = 0;
        this.dJE = this.dJD;
        this.dJF = 1;
        this.dJG = this.dJF;
        this.dJI = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dJD = 0;
        this.dJE = this.dJD;
        this.dJF = 1;
        this.dJG = this.dJF;
        this.dJI = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dJD = 0;
        this.dJE = this.dJD;
        this.dJF = 1;
        this.dJG = this.dJF;
        this.dJI = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.l.GodHeadImageView);
            this.dJI = obtainStyledAttributes.getDimensionPixelSize(e.l.GodHeadImageView_extra_padding, DS6);
            this.dJG = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_shape_type, this.dJF);
            this.dJE = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_show_type, this.dJD);
            this.mRadius = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.dJB = new a(getContext());
        this.dJC = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dJB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.dJB, layoutParams);
        addView(this.dJC, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.dJE = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.dJG = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.dJB.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.dJE) {
            case 0:
                this.dJB.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.dJB.setPadding(dJH, dJH, 0, 0);
                break;
        }
        switch (this.dJG) {
            case 1:
                this.dJB.setIsRound(true);
                if (this.dJE == 0) {
                    al.c(this.dJC, e.f.pic_shen_avatar_big);
                    return;
                } else {
                    al.c(this.dJC, e.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.dJB.setIsRound(false);
                this.dJB.setRadius(this.mRadius);
                al.c(this.dJC, e.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.dJB.setIsRound(true);
                al.c(this.dJC, e.f.browser_null_drawable);
                return;
            default:
                this.dJB.setIsRound(false);
                this.dJB.setRadius(this.mRadius);
                al.c(this.dJC, e.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.dJI != i) {
            this.dJI = i;
            this.dJB.invalidate();
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
            if (GodHeadImageView.this.dJE == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.dJI, AiAppsFileUtils.GB);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.dJI, AiAppsFileUtils.GB);
            }
            super.onMeasure(i, i2);
        }
    }
}
