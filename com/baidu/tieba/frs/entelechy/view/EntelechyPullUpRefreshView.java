package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private Animation cZf;
    private View dsv;
    private TbImageView dsw;
    private boolean dsx;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cZf = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dsx = false;
        g(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cZf = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dsx = false;
        g(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cZf = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dsx = false;
        g(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        am.c(this.dsw, this.mIconId);
    }

    public void g(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(d.m.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.dsx = obtainStyledAttributes.getBoolean(d.m.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            am.i(this, d.C0142d.cp_bg_line_d_alpha98);
            if (this.dsx) {
                this.dsv = new View(context);
                this.dsv.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                am.i(this.dsv, d.C0142d.cp_bg_line_b);
                addView(this.dsv);
            }
            this.dsw = new TbImageView(context);
            int e = l.e(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e, e);
            layoutParams.topMargin = l.e(getContext(), d.e.ds20);
            this.dsw.setLayoutParams(layoutParams);
            am.c(this.dsw, this.mIconId);
            addView(this.dsw);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.i(this.dsv, d.C0142d.cp_bg_line_b);
            am.c(this.dsw, this.mIconId);
            am.i(this, d.C0142d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.cZf == null) {
            this.cZf = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.cZf.setInterpolator(new LinearInterpolator());
            this.cZf.setFillAfter(true);
        }
        return this.cZf;
    }

    public void aqW() {
        this.dsw.startAnimation(getClickRotateAnimation());
    }

    public void aqX() {
        this.dsw.clearAnimation();
    }
}
