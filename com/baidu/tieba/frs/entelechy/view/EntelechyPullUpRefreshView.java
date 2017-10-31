package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private View cFT;
    private TbImageView cFU;
    private int cFV;
    private boolean cFW;
    private Animation csF;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.csF = null;
        this.cFV = d.f.icon_frs_reload;
        this.cFW = false;
        d(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.csF = null;
        this.cFV = d.f.icon_frs_reload;
        this.cFW = false;
        d(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.csF = null;
        this.cFV = d.f.icon_frs_reload;
        this.cFW = false;
        d(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.cFV = i;
        aj.c(this.cFU, this.cFV);
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.EntelechyPullUpRefreshView);
                this.cFV = obtainStyledAttributes.getResourceId(d.l.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.cFW = obtainStyledAttributes.getBoolean(d.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            aj.j(this, d.C0080d.cp_bg_line_d_alpha98);
            if (this.cFW) {
                this.cFT = new View(context);
                this.cFT.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                aj.j(this.cFT, d.C0080d.cp_bg_line_b);
                addView(this.cFT);
            }
            this.cFU = new TbImageView(context);
            int f = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f, f);
            layoutParams.topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds20);
            this.cFU.setLayoutParams(layoutParams);
            aj.c(this.cFU, this.cFV);
            addView(this.cFU);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.j(this.cFT, d.C0080d.cp_bg_line_b);
            aj.c(this.cFU, this.cFV);
            aj.j(this, d.C0080d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.csF == null) {
            this.csF = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.csF.setInterpolator(new LinearInterpolator());
            this.csF.setFillAfter(true);
        }
        return this.csF;
    }

    public void ahA() {
        this.cFU.startAnimation(getClickRotateAnimation());
    }

    public void ahB() {
        this.cFU.clearAnimation();
    }
}
