package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private View bGE;
    private TbImageView bGF;
    private Animation bGG;
    private int bGH;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bGG = null;
        this.bGH = r.f.icon_frs_reload;
        e(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bGG = null;
        this.bGH = r.f.icon_frs_reload;
        e(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.bGG = null;
        this.bGH = r.f.icon_frs_reload;
        e(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.bGH = i;
        com.baidu.tbadk.core.util.ar.c(this.bGF, this.bGH);
    }

    public void e(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.l.EntelechyPullUpRefreshView);
                this.bGH = obtainStyledAttributes.getResourceId(0, r.f.icon_frs_reload);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            com.baidu.tbadk.core.util.ar.k(this, r.f.bg_pull_up_refresh_selector);
            this.bGE = new View(context);
            this.bGE.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(r.e.ds1)));
            com.baidu.tbadk.core.util.ar.k(this.bGE, r.d.common_color_10208);
            addView(this.bGE);
            this.bGF = new TbImageView(context);
            int e = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e, e);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds20);
            this.bGF.setLayoutParams(layoutParams);
            com.baidu.tbadk.core.util.ar.c(this.bGF, this.bGH);
            addView(this.bGF);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.k(this.bGE, r.d.common_color_10208);
            com.baidu.tbadk.core.util.ar.c(this.bGF, this.bGH);
            com.baidu.tbadk.core.util.ar.k(this, r.f.bg_pull_up_refresh_selector);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.bGG == null) {
            this.bGG = AnimationUtils.loadAnimation(getContext(), r.a.refresh_rotate);
            this.bGG.setInterpolator(new LinearInterpolator());
            this.bGG.setFillAfter(true);
        }
        return this.bGG;
    }

    public void Zv() {
        this.bGF.startAnimation(getClickRotateAnimation());
    }

    public void Zw() {
        this.bGF.clearAnimation();
    }
}
