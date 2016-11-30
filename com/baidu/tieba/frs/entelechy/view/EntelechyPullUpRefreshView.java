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
    private View caX;
    private TbImageView caY;
    private Animation caZ;
    private int cba;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.caZ = null;
        this.cba = r.f.icon_frs_reload;
        e(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.caZ = null;
        this.cba = r.f.icon_frs_reload;
        e(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.caZ = null;
        this.cba = r.f.icon_frs_reload;
        e(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.cba = i;
        com.baidu.tbadk.core.util.at.c(this.caY, this.cba);
    }

    public void e(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.l.EntelechyPullUpRefreshView);
                this.cba = obtainStyledAttributes.getResourceId(0, r.f.icon_frs_reload);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            com.baidu.tbadk.core.util.at.k(this, r.f.bg_pull_up_refresh_selector);
            this.caX = new View(context);
            this.caX.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(r.e.ds1)));
            com.baidu.tbadk.core.util.at.k(this.caX, r.d.common_color_10208);
            addView(this.caX);
            this.caY = new TbImageView(context);
            int e = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e, e);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds20);
            this.caY.setLayoutParams(layoutParams);
            com.baidu.tbadk.core.util.at.c(this.caY, this.cba);
            addView(this.caY);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(this.caX, r.d.common_color_10208);
            com.baidu.tbadk.core.util.at.c(this.caY, this.cba);
            com.baidu.tbadk.core.util.at.k(this, r.f.bg_pull_up_refresh_selector);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.caZ == null) {
            this.caZ = AnimationUtils.loadAnimation(getContext(), r.a.refresh_rotate);
            this.caZ.setInterpolator(new LinearInterpolator());
            this.caZ.setFillAfter(true);
        }
        return this.caZ;
    }

    public void afa() {
        this.caY.startAnimation(getClickRotateAnimation());
    }

    public void afb() {
        this.caY.clearAnimation();
    }
}
