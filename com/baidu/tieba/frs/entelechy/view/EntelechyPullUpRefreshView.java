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
/* loaded from: classes2.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private View dEC;
    private TbImageView dED;
    private boolean dEE;
    private Animation dqC;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dqC = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dEE = false;
        d(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dqC = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dEE = false;
        d(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dqC = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dEE = false;
        d(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        aj.c(this.dED, this.mIconId);
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(d.l.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.dEE = obtainStyledAttributes.getBoolean(d.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            aj.s(this, d.C0108d.cp_bg_line_d_alpha98);
            if (this.dEE) {
                this.dEC = new View(context);
                this.dEC.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                aj.s(this.dEC, d.C0108d.cp_bg_line_b);
                addView(this.dEC);
            }
            this.dED = new TbImageView(context);
            int s = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(s, s);
            layoutParams.topMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds20);
            this.dED.setLayoutParams(layoutParams);
            aj.c(this.dED, this.mIconId);
            addView(this.dED);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.s(this.dEC, d.C0108d.cp_bg_line_b);
            aj.c(this.dED, this.mIconId);
            aj.s(this, d.C0108d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.dqC == null) {
            this.dqC = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.dqC.setInterpolator(new LinearInterpolator());
            this.dqC.setFillAfter(true);
        }
        return this.dqC;
    }

    public void ark() {
        this.dED.startAnimation(getClickRotateAnimation());
    }

    public void arl() {
        this.dED.clearAnimation();
    }
}
