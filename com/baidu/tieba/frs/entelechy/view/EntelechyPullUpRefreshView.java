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
    private Animation clA;
    private View cxv;
    private TbImageView cxw;
    private int cxx;
    private boolean cxy;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.clA = null;
        this.cxx = d.g.icon_frs_reload;
        this.cxy = false;
        e(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.clA = null;
        this.cxx = d.g.icon_frs_reload;
        this.cxy = false;
        e(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.clA = null;
        this.cxx = d.g.icon_frs_reload;
        this.cxy = false;
        e(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.cxx = i;
        aj.c(this.cxw, this.cxx);
    }

    public void e(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.EntelechyPullUpRefreshView);
                this.cxx = obtainStyledAttributes.getResourceId(d.n.EntelechyPullUpRefreshView_tb_pull_up_icon, d.g.icon_frs_reload);
                this.cxy = obtainStyledAttributes.getBoolean(d.n.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            aj.j(this, d.e.cp_bg_line_d_alpha98);
            if (this.cxy) {
                this.cxv = new View(context);
                this.cxv.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.f.ds1)));
                aj.j(this.cxv, d.e.cp_bg_line_b);
                addView(this.cxv);
            }
            this.cxw = new TbImageView(context);
            int f = com.baidu.adp.lib.util.k.f(getContext(), d.f.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f, f);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.f(getContext(), d.f.ds20);
            this.cxw.setLayoutParams(layoutParams);
            aj.c(this.cxw, this.cxx);
            addView(this.cxw);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.j(this.cxv, d.e.cp_bg_line_b);
            aj.c(this.cxw, this.cxx);
            aj.j(this, d.e.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.clA == null) {
            this.clA = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.clA.setInterpolator(new LinearInterpolator());
            this.clA.setFillAfter(true);
        }
        return this.clA;
    }

    public void afF() {
        this.cxw.startAnimation(getClickRotateAnimation());
    }

    public void afG() {
        this.cxw.clearAnimation();
    }
}
