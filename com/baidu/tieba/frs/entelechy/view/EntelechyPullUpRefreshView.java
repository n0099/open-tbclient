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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private Animation dbU;
    private View dvg;
    private TbImageView dvh;
    private boolean dvi;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dbU = null;
        this.mIconId = f.C0146f.icon_frs_reload;
        this.dvi = false;
        d(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dbU = null;
        this.mIconId = f.C0146f.icon_frs_reload;
        this.dvi = false;
        d(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dbU = null;
        this.mIconId = f.C0146f.icon_frs_reload;
        this.dvi = false;
        d(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        am.c(this.dvh, this.mIconId);
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.l.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(f.l.EntelechyPullUpRefreshView_tb_pull_up_icon, f.C0146f.icon_frs_reload);
                this.dvi = obtainStyledAttributes.getBoolean(f.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            am.i(this, f.d.cp_bg_line_d_alpha98);
            if (this.dvi) {
                this.dvg = new View(context);
                this.dvg.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(f.e.ds1)));
                am.i(this.dvg, f.d.cp_bg_line_b);
                addView(this.dvg);
            }
            this.dvh = new TbImageView(context);
            int f = l.f(getContext(), f.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f, f);
            layoutParams.topMargin = l.f(getContext(), f.e.ds20);
            this.dvh.setLayoutParams(layoutParams);
            am.c(this.dvh, this.mIconId);
            addView(this.dvh);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.i(this.dvg, f.d.cp_bg_line_b);
            am.c(this.dvh, this.mIconId);
            am.i(this, f.d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.dbU == null) {
            this.dbU = AnimationUtils.loadAnimation(getContext(), f.a.refresh_rotate);
            this.dbU.setInterpolator(new LinearInterpolator());
            this.dbU.setFillAfter(true);
        }
        return this.dbU;
    }

    public void arw() {
        this.dvh.startAnimation(getClickRotateAnimation());
    }

    public void arx() {
        this.dvh.clearAnimation();
    }
}
