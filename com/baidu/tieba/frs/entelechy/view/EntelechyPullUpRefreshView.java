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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private View dKU;
    private TbImageView dKV;
    private boolean dKW;
    private Animation dqX;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dqX = null;
        this.mIconId = e.f.icon_frs_reload;
        this.dKW = false;
        d(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dqX = null;
        this.mIconId = e.f.icon_frs_reload;
        this.dKW = false;
        d(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dqX = null;
        this.mIconId = e.f.icon_frs_reload;
        this.dKW = false;
        d(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        al.c(this.dKV, this.mIconId);
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(e.l.EntelechyPullUpRefreshView_tb_pull_up_icon, e.f.icon_frs_reload);
                this.dKW = obtainStyledAttributes.getBoolean(e.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            al.i(this, e.d.cp_bg_line_d_alpha98);
            if (this.dKW) {
                this.dKU = new View(context);
                this.dKU.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(e.C0200e.ds1)));
                al.i(this.dKU, e.d.cp_bg_line_b);
                addView(this.dKU);
            }
            this.dKV = new TbImageView(context);
            int h = l.h(getContext(), e.C0200e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(h, h);
            layoutParams.topMargin = l.h(getContext(), e.C0200e.ds20);
            this.dKV.setLayoutParams(layoutParams);
            al.c(this.dKV, this.mIconId);
            addView(this.dKV);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this.dKU, e.d.cp_bg_line_b);
            al.c(this.dKV, this.mIconId);
            al.i(this, e.d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.dqX == null) {
            this.dqX = AnimationUtils.loadAnimation(getContext(), e.a.refresh_rotate);
            this.dqX.setInterpolator(new LinearInterpolator());
            this.dqX.setFillAfter(true);
        }
        return this.dqX;
    }

    public void awf() {
        this.dKV.startAnimation(getClickRotateAnimation());
    }

    public void awg() {
        this.dKV.clearAnimation();
    }
}
