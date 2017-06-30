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
    private View cii;
    private TbImageView cij;
    private Animation cik;
    private int cil;
    private boolean cim;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cik = null;
        this.cil = w.g.icon_frs_reload;
        this.cim = false;
        e(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cik = null;
        this.cil = w.g.icon_frs_reload;
        this.cim = false;
        e(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cik = null;
        this.cil = w.g.icon_frs_reload;
        this.cim = false;
        e(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.cil = i;
        com.baidu.tbadk.core.util.as.c(this.cij, this.cil);
    }

    public void e(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.EntelechyPullUpRefreshView);
                this.cil = obtainStyledAttributes.getResourceId(0, w.g.icon_frs_reload);
                this.cim = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            com.baidu.tbadk.core.util.as.j(this, w.g.bg_pull_up_refresh_selector);
            if (this.cim) {
                this.cii = new View(context);
                this.cii.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(w.f.ds1)));
                com.baidu.tbadk.core.util.as.j(this.cii, w.e.common_color_10208);
                addView(this.cii);
            }
            this.cij = new TbImageView(context);
            int g = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20);
            this.cij.setLayoutParams(layoutParams);
            com.baidu.tbadk.core.util.as.c(this.cij, this.cil);
            addView(this.cij);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.as.j(this.cii, w.e.common_color_10208);
            com.baidu.tbadk.core.util.as.c(this.cij, this.cil);
            com.baidu.tbadk.core.util.as.j(this, w.g.bg_pull_up_refresh_selector);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.cik == null) {
            this.cik = AnimationUtils.loadAnimation(getContext(), w.a.refresh_rotate);
            this.cik.setInterpolator(new LinearInterpolator());
            this.cik.setFillAfter(true);
        }
        return this.cik;
    }

    public void afV() {
        this.cij.startAnimation(getClickRotateAnimation());
    }

    public void afW() {
        this.cij.clearAnimation();
    }
}
