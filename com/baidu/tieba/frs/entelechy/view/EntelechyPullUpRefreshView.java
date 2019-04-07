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
    private Animation eNW;
    private View fiv;
    private TbImageView fiw;
    private boolean fiy;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eNW = null;
        this.mIconId = d.f.icon_frs_reload;
        this.fiy = false;
        i(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eNW = null;
        this.mIconId = d.f.icon_frs_reload;
        this.fiy = false;
        i(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eNW = null;
        this.mIconId = d.f.icon_frs_reload;
        this.fiy = false;
        i(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        al.c(this.fiw, this.mIconId);
    }

    public void i(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(d.l.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.fiy = obtainStyledAttributes.getBoolean(d.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            al.k(this, d.C0277d.cp_bg_line_d_alpha98);
            if (this.fiy) {
                this.fiv = new View(context);
                this.fiv.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                al.k(this.fiv, d.C0277d.cp_bg_line_b);
                addView(this.fiv);
            }
            this.fiw = new TbImageView(context);
            int h = l.h(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(h, h);
            layoutParams.topMargin = l.h(getContext(), d.e.ds20);
            this.fiw.setLayoutParams(layoutParams);
            al.c(this.fiw, this.mIconId);
            addView(this.fiw);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.k(this.fiv, d.C0277d.cp_bg_line_b);
            al.c(this.fiw, this.mIconId);
            al.k(this, d.C0277d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.eNW == null) {
            this.eNW = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.eNW.setInterpolator(new LinearInterpolator());
            this.eNW.setFillAfter(true);
        }
        return this.eNW;
    }

    public void aZz() {
        this.fiw.startAnimation(getClickRotateAnimation());
    }

    public void aZA() {
        this.fiw.clearAnimation();
    }
}
