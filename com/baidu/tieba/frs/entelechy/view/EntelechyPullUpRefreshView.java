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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private Animation cQQ;
    private View deQ;
    private TbImageView deR;
    private boolean deS;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cQQ = null;
        this.mIconId = d.f.icon_frs_reload;
        this.deS = false;
        g(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cQQ = null;
        this.mIconId = d.f.icon_frs_reload;
        this.deS = false;
        g(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cQQ = null;
        this.mIconId = d.f.icon_frs_reload;
        this.deS = false;
        g(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        ak.c(this.deR, this.mIconId);
    }

    public void g(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(d.m.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.deS = obtainStyledAttributes.getBoolean(d.m.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            ak.i(this, d.C0126d.cp_bg_line_d_alpha98);
            if (this.deS) {
                this.deQ = new View(context);
                this.deQ.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                ak.i(this.deQ, d.C0126d.cp_bg_line_b);
                addView(this.deQ);
            }
            this.deR = new TbImageView(context);
            int e = l.e(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e, e);
            layoutParams.topMargin = l.e(getContext(), d.e.ds20);
            this.deR.setLayoutParams(layoutParams);
            ak.c(this.deR, this.mIconId);
            addView(this.deR);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.i(this.deQ, d.C0126d.cp_bg_line_b);
            ak.c(this.deR, this.mIconId);
            ak.i(this, d.C0126d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.cQQ == null) {
            this.cQQ = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.cQQ.setInterpolator(new LinearInterpolator());
            this.cQQ.setFillAfter(true);
        }
        return this.cQQ;
    }

    public void anx() {
        this.deR.startAnimation(getClickRotateAnimation());
    }

    public void any() {
        this.deR.clearAnimation();
    }
}
