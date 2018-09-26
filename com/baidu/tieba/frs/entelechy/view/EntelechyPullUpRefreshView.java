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
/* loaded from: classes2.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private View dBQ;
    private TbImageView dBR;
    private boolean dBS;
    private Animation dhP;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dhP = null;
        this.mIconId = e.f.icon_frs_reload;
        this.dBS = false;
        d(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dhP = null;
        this.mIconId = e.f.icon_frs_reload;
        this.dBS = false;
        d(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dhP = null;
        this.mIconId = e.f.icon_frs_reload;
        this.dBS = false;
        d(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        al.c(this.dBR, this.mIconId);
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(e.l.EntelechyPullUpRefreshView_tb_pull_up_icon, e.f.icon_frs_reload);
                this.dBS = obtainStyledAttributes.getBoolean(e.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            al.i(this, e.d.cp_bg_line_d_alpha98);
            if (this.dBS) {
                this.dBQ = new View(context);
                this.dBQ.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(e.C0141e.ds1)));
                al.i(this.dBQ, e.d.cp_bg_line_b);
                addView(this.dBQ);
            }
            this.dBR = new TbImageView(context);
            int h = l.h(getContext(), e.C0141e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(h, h);
            layoutParams.topMargin = l.h(getContext(), e.C0141e.ds20);
            this.dBR.setLayoutParams(layoutParams);
            al.c(this.dBR, this.mIconId);
            addView(this.dBR);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this.dBQ, e.d.cp_bg_line_b);
            al.c(this.dBR, this.mIconId);
            al.i(this, e.d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.dhP == null) {
            this.dhP = AnimationUtils.loadAnimation(getContext(), e.a.refresh_rotate);
            this.dhP.setInterpolator(new LinearInterpolator());
            this.dhP.setFillAfter(true);
        }
        return this.dhP;
    }

    public void atk() {
        this.dBR.startAnimation(getClickRotateAnimation());
    }

    public void atl() {
        this.dBR.clearAnimation();
    }
}
