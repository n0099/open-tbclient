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
    private Animation dAT;
    private View dUU;
    private TbImageView dUV;
    private boolean dUW;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dAT = null;
        this.mIconId = e.f.icon_frs_reload;
        this.dUW = false;
        e(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dAT = null;
        this.mIconId = e.f.icon_frs_reload;
        this.dUW = false;
        e(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dAT = null;
        this.mIconId = e.f.icon_frs_reload;
        this.dUW = false;
        e(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        al.c(this.dUV, this.mIconId);
    }

    public void e(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(e.l.EntelechyPullUpRefreshView_tb_pull_up_icon, e.f.icon_frs_reload);
                this.dUW = obtainStyledAttributes.getBoolean(e.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            al.i(this, e.d.cp_bg_line_d_alpha98);
            if (this.dUW) {
                this.dUU = new View(context);
                this.dUU.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(e.C0210e.ds1)));
                al.i(this.dUU, e.d.cp_bg_line_b);
                addView(this.dUU);
            }
            this.dUV = new TbImageView(context);
            int h = l.h(getContext(), e.C0210e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(h, h);
            layoutParams.topMargin = l.h(getContext(), e.C0210e.ds20);
            this.dUV.setLayoutParams(layoutParams);
            al.c(this.dUV, this.mIconId);
            addView(this.dUV);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this.dUU, e.d.cp_bg_line_b);
            al.c(this.dUV, this.mIconId);
            al.i(this, e.d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.dAT == null) {
            this.dAT = AnimationUtils.loadAnimation(getContext(), e.a.refresh_rotate);
            this.dAT.setInterpolator(new LinearInterpolator());
            this.dAT.setFillAfter(true);
        }
        return this.dAT;
    }

    public void azc() {
        this.dUV.startAnimation(getClickRotateAnimation());
    }

    public void azd() {
        this.dUV.clearAnimation();
    }
}
