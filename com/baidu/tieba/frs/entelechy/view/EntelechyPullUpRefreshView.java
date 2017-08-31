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
/* loaded from: classes.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private Animation ckI;
    private View cwD;
    private TbImageView cwE;
    private int cwF;
    private boolean cwG;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ckI = null;
        this.cwF = d.g.icon_frs_reload;
        this.cwG = false;
        e(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ckI = null;
        this.cwF = d.g.icon_frs_reload;
        this.cwG = false;
        e(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ckI = null;
        this.cwF = d.g.icon_frs_reload;
        this.cwG = false;
        e(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.cwF = i;
        aj.c(this.cwE, this.cwF);
    }

    public void e(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.EntelechyPullUpRefreshView);
                this.cwF = obtainStyledAttributes.getResourceId(d.n.EntelechyPullUpRefreshView_tb_pull_up_icon, d.g.icon_frs_reload);
                this.cwG = obtainStyledAttributes.getBoolean(d.n.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            aj.j(this, d.e.cp_bg_line_d_alpha98);
            if (this.cwG) {
                this.cwD = new View(context);
                this.cwD.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.f.ds1)));
                aj.j(this.cwD, d.e.cp_bg_line_b);
                addView(this.cwD);
            }
            this.cwE = new TbImageView(context);
            int g = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds20);
            this.cwE.setLayoutParams(layoutParams);
            aj.c(this.cwE, this.cwF);
            addView(this.cwE);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.j(this.cwD, d.e.cp_bg_line_b);
            aj.c(this.cwE, this.cwF);
            aj.j(this, d.e.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.ckI == null) {
            this.ckI = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.ckI.setInterpolator(new LinearInterpolator());
            this.ckI.setFillAfter(true);
        }
        return this.ckI;
    }

    public void afu() {
        this.cwE.startAnimation(getClickRotateAnimation());
    }

    public void afv() {
        this.cwE.clearAnimation();
    }
}
