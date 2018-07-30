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
    private Animation dbW;
    private View dvj;
    private TbImageView dvk;
    private boolean dvl;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dbW = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dvl = false;
        d(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dbW = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dvl = false;
        d(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dbW = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dvl = false;
        d(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        am.c(this.dvk, this.mIconId);
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(d.l.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.dvl = obtainStyledAttributes.getBoolean(d.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            am.i(this, d.C0140d.cp_bg_line_d_alpha98);
            if (this.dvl) {
                this.dvj = new View(context);
                this.dvj.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                am.i(this.dvj, d.C0140d.cp_bg_line_b);
                addView(this.dvj);
            }
            this.dvk = new TbImageView(context);
            int f = l.f(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f, f);
            layoutParams.topMargin = l.f(getContext(), d.e.ds20);
            this.dvk.setLayoutParams(layoutParams);
            am.c(this.dvk, this.mIconId);
            addView(this.dvk);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.i(this.dvj, d.C0140d.cp_bg_line_b);
            am.c(this.dvk, this.mIconId);
            am.i(this, d.C0140d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.dbW == null) {
            this.dbW = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.dbW.setInterpolator(new LinearInterpolator());
            this.dbW.setFillAfter(true);
        }
        return this.dbW;
    }

    public void arw() {
        this.dvk.startAnimation(getClickRotateAnimation());
    }

    public void arx() {
        this.dvk.clearAnimation();
    }
}
