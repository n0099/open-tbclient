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
    private a dzF;
    private ImageView dzG;
    private int dzH;
    private int dzI;
    private int dzJ;
    private int dzK;
    private int dzM;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds6);
    private static final int dzL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.dzH = 0;
        this.dzI = this.dzH;
        this.dzJ = 1;
        this.dzK = this.dzJ;
        this.dzM = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dzH = 0;
        this.dzI = this.dzH;
        this.dzJ = 1;
        this.dzK = this.dzJ;
        this.dzM = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dzH = 0;
        this.dzI = this.dzH;
        this.dzJ = 1;
        this.dzK = this.dzJ;
        this.dzM = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.l.GodHeadImageView);
            this.dzM = obtainStyledAttributes.getDimensionPixelSize(e.l.GodHeadImageView_extra_padding, DS6);
            this.dzK = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_shape_type, this.dzJ);
            this.dzI = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_show_type, this.dzH);
            this.mRadius = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.dzF = new a(getContext());
        this.dzG = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dzF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.dzF, layoutParams);
        addView(this.dzG, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.dzI = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.dzK = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.dzF.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.dzI) {
            case 0:
                this.dzF.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.dzF.setPadding(dzL, dzL, 0, 0);
                break;
        }
        switch (this.dzK) {
            case 1:
                this.dzF.setIsRound(true);
                if (this.dzI == 0) {
                    al.c(this.dzG, e.f.pic_shen_avatar_big);
                    return;
                } else {
                    al.c(this.dzG, e.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.dzF.setIsRound(false);
                this.dzF.setRadius(this.mRadius);
                al.c(this.dzG, e.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.dzF.setIsRound(true);
                al.c(this.dzG, e.f.browser_null_drawable);
                return;
            default:
                this.dzF.setIsRound(false);
                this.dzF.setRadius(this.mRadius);
                al.c(this.dzG, e.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.dzM != i) {
            this.dzM = i;
            this.dzF.invalidate();
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
            if (GodHeadImageView.this.dzI == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.dzM, AiAppsFileUtils.GB);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.dzM, AiAppsFileUtils.GB);
            }
            super.onMeasure(i, i2);
        }
    }
}
