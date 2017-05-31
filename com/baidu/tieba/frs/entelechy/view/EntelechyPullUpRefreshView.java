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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private View bZY;
    private TbImageView bZZ;
    private Animation caa;
    private int cab;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.caa = null;
        this.cab = w.g.icon_frs_reload;
        e(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.caa = null;
        this.cab = w.g.icon_frs_reload;
        e(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.caa = null;
        this.cab = w.g.icon_frs_reload;
        e(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.cab = i;
        com.baidu.tbadk.core.util.aq.c(this.bZZ, this.cab);
    }

    public void e(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.EntelechyPullUpRefreshView);
                this.cab = obtainStyledAttributes.getResourceId(0, w.g.icon_frs_reload);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            com.baidu.tbadk.core.util.aq.j(this, w.g.bg_pull_up_refresh_selector);
            this.bZY = new View(context);
            this.bZY.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(w.f.ds1)));
            com.baidu.tbadk.core.util.aq.j(this.bZY, w.e.common_color_10208);
            addView(this.bZY);
            this.bZZ = new TbImageView(context);
            int g = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20);
            this.bZZ.setLayoutParams(layoutParams);
            com.baidu.tbadk.core.util.aq.c(this.bZZ, this.cab);
            addView(this.bZZ);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.bZY, w.e.common_color_10208);
            com.baidu.tbadk.core.util.aq.c(this.bZZ, this.cab);
            com.baidu.tbadk.core.util.aq.j(this, w.g.bg_pull_up_refresh_selector);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.caa == null) {
            this.caa = AnimationUtils.loadAnimation(getContext(), w.a.refresh_rotate);
            this.caa.setInterpolator(new LinearInterpolator());
            this.caa.setFillAfter(true);
        }
        return this.caa;
    }

    public void acd() {
        this.bZZ.startAnimation(getClickRotateAnimation());
    }

    public void ace() {
        this.bZZ.clearAnimation();
    }
}
