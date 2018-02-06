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
    private TbImageView dMA;
    private boolean dMB;
    private View dMz;
    private Animation dyp;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dyp = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dMB = false;
        d(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dyp = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dMB = false;
        d(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dyp = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dMB = false;
        d(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        aj.c(this.dMA, this.mIconId);
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(d.l.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.dMB = obtainStyledAttributes.getBoolean(d.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            aj.s(this, d.C0140d.cp_bg_line_d_alpha98);
            if (this.dMB) {
                this.dMz = new View(context);
                this.dMz.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                aj.s(this.dMz, d.C0140d.cp_bg_line_b);
                addView(this.dMz);
            }
            this.dMA = new TbImageView(context);
            int t = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(t, t);
            layoutParams.topMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds20);
            this.dMA.setLayoutParams(layoutParams);
            aj.c(this.dMA, this.mIconId);
            addView(this.dMA);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.s(this.dMz, d.C0140d.cp_bg_line_b);
            aj.c(this.dMA, this.mIconId);
            aj.s(this, d.C0140d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.dyp == null) {
            this.dyp = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.dyp.setInterpolator(new LinearInterpolator());
            this.dyp.setFillAfter(true);
        }
        return this.dyp;
    }

    public void ati() {
        this.dMA.startAnimation(getClickRotateAnimation());
    }

    public void atj() {
        this.dMA.clearAnimation();
    }
}
