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
    private View dJQ;
    private TbImageView dJR;
    private boolean dJS;
    private Animation dpT;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dpT = null;
        this.mIconId = e.f.icon_frs_reload;
        this.dJS = false;
        d(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dpT = null;
        this.mIconId = e.f.icon_frs_reload;
        this.dJS = false;
        d(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dpT = null;
        this.mIconId = e.f.icon_frs_reload;
        this.dJS = false;
        d(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        al.c(this.dJR, this.mIconId);
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(e.l.EntelechyPullUpRefreshView_tb_pull_up_icon, e.f.icon_frs_reload);
                this.dJS = obtainStyledAttributes.getBoolean(e.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            al.i(this, e.d.cp_bg_line_d_alpha98);
            if (this.dJS) {
                this.dJQ = new View(context);
                this.dJQ.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(e.C0175e.ds1)));
                al.i(this.dJQ, e.d.cp_bg_line_b);
                addView(this.dJQ);
            }
            this.dJR = new TbImageView(context);
            int h = l.h(getContext(), e.C0175e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(h, h);
            layoutParams.topMargin = l.h(getContext(), e.C0175e.ds20);
            this.dJR.setLayoutParams(layoutParams);
            al.c(this.dJR, this.mIconId);
            addView(this.dJR);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this.dJQ, e.d.cp_bg_line_b);
            al.c(this.dJR, this.mIconId);
            al.i(this, e.d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.dpT == null) {
            this.dpT = AnimationUtils.loadAnimation(getContext(), e.a.refresh_rotate);
            this.dpT.setInterpolator(new LinearInterpolator());
            this.dpT.setFillAfter(true);
        }
        return this.dpT;
    }

    public void awG() {
        this.dJR.startAnimation(getClickRotateAnimation());
    }

    public void awH() {
        this.dJR.clearAnimation();
    }
}
