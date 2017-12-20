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
    private Animation cBV;
    private View cPH;
    private TbImageView cPI;
    private int cPJ;
    private boolean cPK;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cBV = null;
        this.cPJ = d.f.icon_frs_reload;
        this.cPK = false;
        d(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cBV = null;
        this.cPJ = d.f.icon_frs_reload;
        this.cPK = false;
        d(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cBV = null;
        this.cPJ = d.f.icon_frs_reload;
        this.cPK = false;
        d(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.cPJ = i;
        aj.c(this.cPI, this.cPJ);
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.EntelechyPullUpRefreshView);
                this.cPJ = obtainStyledAttributes.getResourceId(d.l.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.cPK = obtainStyledAttributes.getBoolean(d.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            aj.j(this, d.C0096d.cp_bg_line_d_alpha98);
            if (this.cPK) {
                this.cPH = new View(context);
                this.cPH.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                aj.j(this.cPH, d.C0096d.cp_bg_line_b);
                addView(this.cPH);
            }
            this.cPI = new TbImageView(context);
            int f = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f, f);
            layoutParams.topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds20);
            this.cPI.setLayoutParams(layoutParams);
            aj.c(this.cPI, this.cPJ);
            addView(this.cPI);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.j(this.cPH, d.C0096d.cp_bg_line_b);
            aj.c(this.cPI, this.cPJ);
            aj.j(this, d.C0096d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.cBV == null) {
            this.cBV = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.cBV.setInterpolator(new LinearInterpolator());
            this.cBV.setFillAfter(true);
        }
        return this.cBV;
    }

    public void ajK() {
        this.cPI.startAnimation(getClickRotateAnimation());
    }

    public void ajL() {
        this.cPI.clearAnimation();
    }
}
