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
    private Animation cBZ;
    private View cPL;
    private TbImageView cPM;
    private int cPN;
    private boolean cPO;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cBZ = null;
        this.cPN = d.f.icon_frs_reload;
        this.cPO = false;
        d(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cBZ = null;
        this.cPN = d.f.icon_frs_reload;
        this.cPO = false;
        d(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cBZ = null;
        this.cPN = d.f.icon_frs_reload;
        this.cPO = false;
        d(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.cPN = i;
        aj.c(this.cPM, this.cPN);
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.EntelechyPullUpRefreshView);
                this.cPN = obtainStyledAttributes.getResourceId(d.l.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.cPO = obtainStyledAttributes.getBoolean(d.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            aj.j(this, d.C0095d.cp_bg_line_d_alpha98);
            if (this.cPO) {
                this.cPL = new View(context);
                this.cPL.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                aj.j(this.cPL, d.C0095d.cp_bg_line_b);
                addView(this.cPL);
            }
            this.cPM = new TbImageView(context);
            int f = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f, f);
            layoutParams.topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds20);
            this.cPM.setLayoutParams(layoutParams);
            aj.c(this.cPM, this.cPN);
            addView(this.cPM);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.j(this.cPL, d.C0095d.cp_bg_line_b);
            aj.c(this.cPM, this.cPN);
            aj.j(this, d.C0095d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.cBZ == null) {
            this.cBZ = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.cBZ.setInterpolator(new LinearInterpolator());
            this.cBZ.setFillAfter(true);
        }
        return this.cBZ;
    }

    public void ajK() {
        this.cPM.startAnimation(getClickRotateAnimation());
    }

    public void ajL() {
        this.cPM.clearAnimation();
    }
}
