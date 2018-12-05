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
    private a dGe;
    private ImageView dGf;
    private int dGg;
    private int dGh;
    private int dGi;
    private int dGj;
    private int dGl;
    private int mRadius;
    private static final int DS6 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds6);
    private static final int dGk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds1);
    private static int DEFAULT_RADIUS = 7;

    public GodHeadImageView(Context context) {
        super(context);
        this.dGg = 0;
        this.dGh = this.dGg;
        this.dGi = 1;
        this.dGj = this.dGi;
        this.dGl = DS6;
        this.mRadius = 7;
        init(null);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dGg = 0;
        this.dGh = this.dGg;
        this.dGi = 1;
        this.dGj = this.dGi;
        this.dGl = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    public GodHeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dGg = 0;
        this.dGh = this.dGg;
        this.dGi = 1;
        this.dGj = this.dGi;
        this.dGl = DS6;
        this.mRadius = 7;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.l.GodHeadImageView);
            this.dGl = obtainStyledAttributes.getDimensionPixelSize(e.l.GodHeadImageView_extra_padding, DS6);
            this.dGj = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_shape_type, this.dGi);
            this.dGh = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_show_type, this.dGg);
            this.mRadius = obtainStyledAttributes.getInteger(e.l.GodHeadImageView_extra_radius, DEFAULT_RADIUS);
            obtainStyledAttributes.recycle();
        }
        this.dGe = new a(getContext());
        this.dGf = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dGe.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.dGe, layoutParams);
        addView(this.dGf, new FrameLayout.LayoutParams(-1, -1));
        refreshUI();
    }

    public void setShowType(int i) {
        this.dGh = i;
        refreshUI();
    }

    public void setShapeType(int i) {
        this.dGj = i;
        refreshUI();
    }

    public void startLoad(String str, int i, boolean z) {
        this.dGe.startLoad(str, i, z);
    }

    private void refreshUI() {
        switch (this.dGh) {
            case 0:
                this.dGe.setPadding(0, 0, 0, 0);
                break;
            case 1:
                this.dGe.setPadding(dGk, dGk, 0, 0);
                break;
        }
        switch (this.dGj) {
            case 1:
                this.dGe.setIsRound(true);
                if (this.dGh == 0) {
                    al.c(this.dGf, e.f.pic_shen_avatar_big);
                    return;
                } else {
                    al.c(this.dGf, e.f.pic_shen_avatar);
                    return;
                }
            case 2:
                this.dGe.setIsRound(false);
                this.dGe.setRadius(this.mRadius);
                al.c(this.dGf, e.f.pic_frs_shen_avatar);
                return;
            case 3:
                this.dGe.setIsRound(true);
                al.c(this.dGf, e.f.browser_null_drawable);
                return;
            default:
                this.dGe.setIsRound(false);
                this.dGe.setRadius(this.mRadius);
                al.c(this.dGf, e.f.pic_shen_avatar_square);
                return;
        }
    }

    public void setRadius(int i) {
        this.mRadius = i;
        refreshUI();
    }

    public void setExtraPadding(int i) {
        if (this.dGl != i) {
            this.dGl = i;
            this.dGe.invalidate();
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
            if (GodHeadImageView.this.dGh == 1) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                i = View.MeasureSpec.makeMeasureSpec(size - GodHeadImageView.this.dGl, AiAppsFileUtils.GB);
                i2 = View.MeasureSpec.makeMeasureSpec(size2 - GodHeadImageView.this.dGl, AiAppsFileUtils.GB);
            }
            super.onMeasure(i, i2);
        }
    }
}
