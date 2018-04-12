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
    private Animation cQT;
    private View deT;
    private TbImageView deU;
    private boolean deV;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cQT = null;
        this.mIconId = d.f.icon_frs_reload;
        this.deV = false;
        g(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cQT = null;
        this.mIconId = d.f.icon_frs_reload;
        this.deV = false;
        g(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cQT = null;
        this.mIconId = d.f.icon_frs_reload;
        this.deV = false;
        g(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        ak.c(this.deU, this.mIconId);
    }

    public void g(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(d.m.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.deV = obtainStyledAttributes.getBoolean(d.m.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            ak.i(this, d.C0126d.cp_bg_line_d_alpha98);
            if (this.deV) {
                this.deT = new View(context);
                this.deT.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                ak.i(this.deT, d.C0126d.cp_bg_line_b);
                addView(this.deT);
            }
            this.deU = new TbImageView(context);
            int e = l.e(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e, e);
            layoutParams.topMargin = l.e(getContext(), d.e.ds20);
            this.deU.setLayoutParams(layoutParams);
            ak.c(this.deU, this.mIconId);
            addView(this.deU);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.i(this.deT, d.C0126d.cp_bg_line_b);
            ak.c(this.deU, this.mIconId);
            ak.i(this, d.C0126d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.cQT == null) {
            this.cQT = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.cQT.setInterpolator(new LinearInterpolator());
            this.cQT.setFillAfter(true);
        }
        return this.cQT;
    }

    public void anx() {
        this.deU.startAnimation(getClickRotateAnimation());
    }

    public void any() {
        this.deU.clearAnimation();
    }
}
