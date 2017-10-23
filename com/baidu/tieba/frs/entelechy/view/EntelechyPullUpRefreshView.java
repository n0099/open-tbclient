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
    private Animation clk;
    private View cya;
    private TbImageView cyb;
    private int cyc;
    private boolean cyd;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.clk = null;
        this.cyc = d.g.icon_frs_reload;
        this.cyd = false;
        d(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.clk = null;
        this.cyc = d.g.icon_frs_reload;
        this.cyd = false;
        d(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.clk = null;
        this.cyc = d.g.icon_frs_reload;
        this.cyd = false;
        d(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.cyc = i;
        aj.c(this.cyb, this.cyc);
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.EntelechyPullUpRefreshView);
                this.cyc = obtainStyledAttributes.getResourceId(d.n.EntelechyPullUpRefreshView_tb_pull_up_icon, d.g.icon_frs_reload);
                this.cyd = obtainStyledAttributes.getBoolean(d.n.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            aj.j(this, d.e.cp_bg_line_d_alpha98);
            if (this.cyd) {
                this.cya = new View(context);
                this.cya.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.f.ds1)));
                aj.j(this.cya, d.e.cp_bg_line_b);
                addView(this.cya);
            }
            this.cyb = new TbImageView(context);
            int f = com.baidu.adp.lib.util.l.f(getContext(), d.f.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f, f);
            layoutParams.topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.f.ds20);
            this.cyb.setLayoutParams(layoutParams);
            aj.c(this.cyb, this.cyc);
            addView(this.cyb);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.j(this.cya, d.e.cp_bg_line_b);
            aj.c(this.cyb, this.cyc);
            aj.j(this, d.e.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.clk == null) {
            this.clk = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.clk.setInterpolator(new LinearInterpolator());
            this.clk.setFillAfter(true);
        }
        return this.clk;
    }

    public void afs() {
        this.cyb.startAnimation(getClickRotateAnimation());
    }

    public void aft() {
        this.cyb.clearAnimation();
    }
}
