package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private View cpp;
    private TbImageView cpq;
    private Animation cpr;
    private int cps;
    private boolean cpt;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cpr = null;
        this.cps = d.g.icon_frs_reload;
        this.cpt = false;
        e(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cpr = null;
        this.cps = d.g.icon_frs_reload;
        this.cpt = false;
        e(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cpr = null;
        this.cps = d.g.icon_frs_reload;
        this.cpt = false;
        e(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.cps = i;
        ai.c(this.cpq, this.cps);
    }

    public void e(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.EntelechyPullUpRefreshView);
                this.cps = obtainStyledAttributes.getResourceId(d.n.EntelechyPullUpRefreshView_tb_pull_up_icon, d.g.icon_frs_reload);
                this.cpt = obtainStyledAttributes.getBoolean(d.n.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            ai.j(this, d.g.bg_pull_up_refresh_selector);
            if (this.cpt) {
                this.cpp = new View(context);
                this.cpp.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.f.ds1)));
                ai.j(this.cpp, d.e.common_color_10208);
                addView(this.cpp);
            }
            this.cpq = new TbImageView(context);
            int g = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds20);
            this.cpq.setLayoutParams(layoutParams);
            ai.c(this.cpq, this.cps);
            addView(this.cpq);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.j(this.cpp, d.e.common_color_10208);
            ai.c(this.cpq, this.cps);
            ai.j(this, d.g.bg_pull_up_refresh_selector);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.cpr == null) {
            this.cpr = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.cpr.setInterpolator(new LinearInterpolator());
            this.cpr.setFillAfter(true);
        }
        return this.cpr;
    }

    public void ahm() {
        this.cpq.startAnimation(getClickRotateAnimation());
    }

    public void ahn() {
        this.cpq.clearAnimation();
    }
}
