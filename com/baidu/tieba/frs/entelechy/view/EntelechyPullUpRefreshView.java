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
    private View bUe;
    private TbImageView bUf;
    private Animation bUg;
    private int bUh;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bUg = null;
        this.bUh = w.g.icon_frs_reload;
        e(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bUg = null;
        this.bUh = w.g.icon_frs_reload;
        e(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.bUg = null;
        this.bUh = w.g.icon_frs_reload;
        e(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.bUh = i;
        com.baidu.tbadk.core.util.aq.c(this.bUf, this.bUh);
    }

    public void e(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.EntelechyPullUpRefreshView);
                this.bUh = obtainStyledAttributes.getResourceId(0, w.g.icon_frs_reload);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            com.baidu.tbadk.core.util.aq.j(this, w.g.bg_pull_up_refresh_selector);
            this.bUe = new View(context);
            this.bUe.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(w.f.ds1)));
            com.baidu.tbadk.core.util.aq.j(this.bUe, w.e.common_color_10208);
            addView(this.bUe);
            this.bUf = new TbImageView(context);
            int g = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20);
            this.bUf.setLayoutParams(layoutParams);
            com.baidu.tbadk.core.util.aq.c(this.bUf, this.bUh);
            addView(this.bUf);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.bUe, w.e.common_color_10208);
            com.baidu.tbadk.core.util.aq.c(this.bUf, this.bUh);
            com.baidu.tbadk.core.util.aq.j(this, w.g.bg_pull_up_refresh_selector);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.bUg == null) {
            this.bUg = AnimationUtils.loadAnimation(getContext(), w.a.refresh_rotate);
            this.bUg.setInterpolator(new LinearInterpolator());
            this.bUg.setFillAfter(true);
        }
        return this.bUg;
    }

    public void aaZ() {
        this.bUf.startAnimation(getClickRotateAnimation());
    }

    public void aba() {
        this.bUf.clearAnimation();
    }
}
