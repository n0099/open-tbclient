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
    private Animation clw;
    private View cym;
    private TbImageView cyn;
    private int cyo;
    private boolean cyp;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.clw = null;
        this.cyo = d.g.icon_frs_reload;
        this.cyp = false;
        d(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.clw = null;
        this.cyo = d.g.icon_frs_reload;
        this.cyp = false;
        d(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.clw = null;
        this.cyo = d.g.icon_frs_reload;
        this.cyp = false;
        d(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.cyo = i;
        aj.c(this.cyn, this.cyo);
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.EntelechyPullUpRefreshView);
                this.cyo = obtainStyledAttributes.getResourceId(d.n.EntelechyPullUpRefreshView_tb_pull_up_icon, d.g.icon_frs_reload);
                this.cyp = obtainStyledAttributes.getBoolean(d.n.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            aj.j(this, d.e.cp_bg_line_d_alpha98);
            if (this.cyp) {
                this.cym = new View(context);
                this.cym.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.f.ds1)));
                aj.j(this.cym, d.e.cp_bg_line_b);
                addView(this.cym);
            }
            this.cyn = new TbImageView(context);
            int f = com.baidu.adp.lib.util.l.f(getContext(), d.f.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f, f);
            layoutParams.topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.f.ds20);
            this.cyn.setLayoutParams(layoutParams);
            aj.c(this.cyn, this.cyo);
            addView(this.cyn);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.j(this.cym, d.e.cp_bg_line_b);
            aj.c(this.cyn, this.cyo);
            aj.j(this, d.e.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.clw == null) {
            this.clw = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.clw.setInterpolator(new LinearInterpolator());
            this.clw.setFillAfter(true);
        }
        return this.clw;
    }

    public void afx() {
        this.cyn.startAnimation(getClickRotateAnimation());
    }

    public void afy() {
        this.cyn.clearAnimation();
    }
}
