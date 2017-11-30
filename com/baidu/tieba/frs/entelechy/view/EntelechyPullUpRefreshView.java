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
    private Animation cBN;
    private View cPw;
    private TbImageView cPx;
    private int cPy;
    private boolean cPz;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cBN = null;
        this.cPy = d.f.icon_frs_reload;
        this.cPz = false;
        d(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cBN = null;
        this.cPy = d.f.icon_frs_reload;
        this.cPz = false;
        d(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cBN = null;
        this.cPy = d.f.icon_frs_reload;
        this.cPz = false;
        d(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.cPy = i;
        aj.c(this.cPx, this.cPy);
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.EntelechyPullUpRefreshView);
                this.cPy = obtainStyledAttributes.getResourceId(d.l.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.cPz = obtainStyledAttributes.getBoolean(d.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            aj.j(this, d.C0082d.cp_bg_line_d_alpha98);
            if (this.cPz) {
                this.cPw = new View(context);
                this.cPw.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                aj.j(this.cPw, d.C0082d.cp_bg_line_b);
                addView(this.cPw);
            }
            this.cPx = new TbImageView(context);
            int f = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f, f);
            layoutParams.topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds20);
            this.cPx.setLayoutParams(layoutParams);
            aj.c(this.cPx, this.cPy);
            addView(this.cPx);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.j(this.cPw, d.C0082d.cp_bg_line_b);
            aj.c(this.cPx, this.cPy);
            aj.j(this, d.C0082d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.cBN == null) {
            this.cBN = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.cBN.setInterpolator(new LinearInterpolator());
            this.cBN.setFillAfter(true);
        }
        return this.cBN;
    }

    public void ajD() {
        this.cPx.startAnimation(getClickRotateAnimation());
    }

    public void ajE() {
        this.cPx.clearAnimation();
    }
}
