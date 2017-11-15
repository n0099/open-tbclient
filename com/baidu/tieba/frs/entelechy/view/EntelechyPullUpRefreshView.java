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
    private View cGm;
    private TbImageView cGn;
    private int cGo;
    private boolean cGp;
    private Animation csY;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.csY = null;
        this.cGo = d.f.icon_frs_reload;
        this.cGp = false;
        d(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.csY = null;
        this.cGo = d.f.icon_frs_reload;
        this.cGp = false;
        d(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.csY = null;
        this.cGo = d.f.icon_frs_reload;
        this.cGp = false;
        d(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.cGo = i;
        aj.c(this.cGn, this.cGo);
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.EntelechyPullUpRefreshView);
                this.cGo = obtainStyledAttributes.getResourceId(d.l.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.cGp = obtainStyledAttributes.getBoolean(d.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            aj.j(this, d.C0080d.cp_bg_line_d_alpha98);
            if (this.cGp) {
                this.cGm = new View(context);
                this.cGm.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                aj.j(this.cGm, d.C0080d.cp_bg_line_b);
                addView(this.cGm);
            }
            this.cGn = new TbImageView(context);
            int f = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f, f);
            layoutParams.topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds20);
            this.cGn.setLayoutParams(layoutParams);
            aj.c(this.cGn, this.cGo);
            addView(this.cGn);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.j(this.cGm, d.C0080d.cp_bg_line_b);
            aj.c(this.cGn, this.cGo);
            aj.j(this, d.C0080d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.csY == null) {
            this.csY = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.csY.setInterpolator(new LinearInterpolator());
            this.csY.setFillAfter(true);
        }
        return this.csY;
    }

    public void ahO() {
        this.cGn.startAnimation(getClickRotateAnimation());
    }

    public void ahP() {
        this.cGn.clearAnimation();
    }
}
