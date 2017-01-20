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
    private View bMT;
    private TbImageView bMU;
    private Animation bMV;
    private int bMW;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bMV = null;
        this.bMW = r.g.icon_frs_reload;
        e(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.bMV = null;
        this.bMW = r.g.icon_frs_reload;
        e(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.bMV = null;
        this.bMW = r.g.icon_frs_reload;
        e(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.bMW = i;
        com.baidu.tbadk.core.util.ap.c(this.bMU, this.bMW);
    }

    public void e(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.n.EntelechyPullUpRefreshView);
                this.bMW = obtainStyledAttributes.getResourceId(0, r.g.icon_frs_reload);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            com.baidu.tbadk.core.util.ap.j(this, r.g.bg_pull_up_refresh_selector);
            this.bMT = new View(context);
            this.bMT.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(r.f.ds1)));
            com.baidu.tbadk.core.util.ap.j(this.bMT, r.e.common_color_10208);
            addView(this.bMT);
            this.bMU = new TbImageView(context);
            int e = com.baidu.adp.lib.util.k.e(getContext(), r.f.ds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e, e);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.e(getContext(), r.f.ds20);
            this.bMU.setLayoutParams(layoutParams);
            com.baidu.tbadk.core.util.ap.c(this.bMU, this.bMW);
            addView(this.bMU);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.j(this.bMT, r.e.common_color_10208);
            com.baidu.tbadk.core.util.ap.c(this.bMU, this.bMW);
            com.baidu.tbadk.core.util.ap.j(this, r.g.bg_pull_up_refresh_selector);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.bMV == null) {
            this.bMV = AnimationUtils.loadAnimation(getContext(), r.a.refresh_rotate);
            this.bMV.setInterpolator(new LinearInterpolator());
            this.bMV.setFillAfter(true);
        }
        return this.bMV;
    }

    public void aay() {
        this.bMU.startAnimation(getClickRotateAnimation());
    }

    public void aaz() {
        this.bMU.clearAnimation();
    }
}
