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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private Animation eOk;
    private View fiK;
    private TbImageView fiL;
    private boolean fiM;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eOk = null;
        this.mIconId = d.f.icon_frs_reload;
        this.fiM = false;
        i(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eOk = null;
        this.mIconId = d.f.icon_frs_reload;
        this.fiM = false;
        i(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eOk = null;
        this.mIconId = d.f.icon_frs_reload;
        this.fiM = false;
        i(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        al.c(this.fiL, this.mIconId);
    }

    public void i(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(d.l.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.fiM = obtainStyledAttributes.getBoolean(d.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            al.k(this, d.C0277d.cp_bg_line_d_alpha98);
            if (this.fiM) {
                this.fiK = new View(context);
                this.fiK.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                al.k(this.fiK, d.C0277d.cp_bg_line_b);
                addView(this.fiK);
            }
            this.fiL = new TbImageView(context);
            int h = l.h(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(h, h);
            layoutParams.topMargin = l.h(getContext(), d.e.ds20);
            this.fiL.setLayoutParams(layoutParams);
            al.c(this.fiL, this.mIconId);
            addView(this.fiL);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.k(this.fiK, d.C0277d.cp_bg_line_b);
            al.c(this.fiL, this.mIconId);
            al.k(this, d.C0277d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.eOk == null) {
            this.eOk = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.eOk.setInterpolator(new LinearInterpolator());
            this.eOk.setFillAfter(true);
        }
        return this.eOk;
    }

    public void aZC() {
        this.fiL.startAnimation(getClickRotateAnimation());
    }

    public void aZD() {
        this.fiL.clearAnimation();
    }
}
