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
    private Animation cRX;
    private View dfX;
    private TbImageView dfY;
    private boolean dfZ;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cRX = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dfZ = false;
        g(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cRX = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dfZ = false;
        g(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cRX = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dfZ = false;
        g(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        ak.c(this.dfY, this.mIconId);
    }

    public void g(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(d.m.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.dfZ = obtainStyledAttributes.getBoolean(d.m.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            ak.i(this, d.C0126d.cp_bg_line_d_alpha98);
            if (this.dfZ) {
                this.dfX = new View(context);
                this.dfX.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                ak.i(this.dfX, d.C0126d.cp_bg_line_b);
                addView(this.dfX);
            }
            this.dfY = new TbImageView(context);
            int e = l.e(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e, e);
            layoutParams.topMargin = l.e(getContext(), d.e.ds20);
            this.dfY.setLayoutParams(layoutParams);
            ak.c(this.dfY, this.mIconId);
            addView(this.dfY);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.i(this.dfX, d.C0126d.cp_bg_line_b);
            ak.c(this.dfY, this.mIconId);
            ak.i(this, d.C0126d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.cRX == null) {
            this.cRX = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.cRX.setInterpolator(new LinearInterpolator());
            this.cRX.setFillAfter(true);
        }
        return this.cRX;
    }

    public void anw() {
        this.dfY.startAnimation(getClickRotateAnimation());
    }

    public void anx() {
        this.dfY.clearAnimation();
    }
}
