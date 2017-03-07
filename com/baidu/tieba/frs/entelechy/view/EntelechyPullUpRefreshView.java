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
    private View bUb;
    private TbImageView bUc;
    private Animation bUd;
    private int bUe;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bUd = null;
        this.bUe = w.g.icon_frs_reload;
        e(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bUd = null;
        this.bUe = w.g.icon_frs_reload;
        e(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.bUd = null;
        this.bUe = w.g.icon_frs_reload;
        e(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.bUe = i;
        com.baidu.tbadk.core.util.aq.c(this.bUc, this.bUe);
    }

    public void e(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.EntelechyPullUpRefreshView);
                this.bUe = obtainStyledAttributes.getResourceId(0, w.g.icon_frs_reload);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            com.baidu.tbadk.core.util.aq.j(this, w.g.bg_pull_up_refresh_selector);
            this.bUb = new View(context);
            this.bUb.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(w.f.ds1)));
            com.baidu.tbadk.core.util.aq.j(this.bUb, w.e.common_color_10208);
            addView(this.bUb);
            this.bUc = new TbImageView(context);
            int g = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20);
            this.bUc.setLayoutParams(layoutParams);
            com.baidu.tbadk.core.util.aq.c(this.bUc, this.bUe);
            addView(this.bUc);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.bUb, w.e.common_color_10208);
            com.baidu.tbadk.core.util.aq.c(this.bUc, this.bUe);
            com.baidu.tbadk.core.util.aq.j(this, w.g.bg_pull_up_refresh_selector);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.bUd == null) {
            this.bUd = AnimationUtils.loadAnimation(getContext(), w.a.refresh_rotate);
            this.bUd.setInterpolator(new LinearInterpolator());
            this.bUd.setFillAfter(true);
        }
        return this.bUd;
    }

    public void abv() {
        this.bUc.startAnimation(getClickRotateAnimation());
    }

    public void abw() {
        this.bUc.clearAnimation();
    }
}
