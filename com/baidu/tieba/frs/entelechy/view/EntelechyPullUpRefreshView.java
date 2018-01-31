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
    private boolean dJA;
    private View dJy;
    private TbImageView dJz;
    private Animation dvx;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dvx = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dJA = false;
        d(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dvx = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dJA = false;
        d(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dvx = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dJA = false;
        d(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        aj.c(this.dJz, this.mIconId);
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(d.l.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.dJA = obtainStyledAttributes.getBoolean(d.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            aj.s(this, d.C0108d.cp_bg_line_d_alpha98);
            if (this.dJA) {
                this.dJy = new View(context);
                this.dJy.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                aj.s(this.dJy, d.C0108d.cp_bg_line_b);
                addView(this.dJy);
            }
            this.dJz = new TbImageView(context);
            int s = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(s, s);
            layoutParams.topMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds20);
            this.dJz.setLayoutParams(layoutParams);
            aj.c(this.dJz, this.mIconId);
            addView(this.dJz);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.s(this.dJy, d.C0108d.cp_bg_line_b);
            aj.c(this.dJz, this.mIconId);
            aj.s(this, d.C0108d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.dvx == null) {
            this.dvx = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.dvx.setInterpolator(new LinearInterpolator());
            this.dvx.setFillAfter(true);
        }
        return this.dvx;
    }

    public void ass() {
        this.dJz.startAnimation(getClickRotateAnimation());
    }

    public void ast() {
        this.dJz.clearAnimation();
    }
}
