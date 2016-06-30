package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ao extends LinearLayout {
    Animation bFh;
    View bKK;
    TbImageView bKL;
    private int mSkinType;

    public ao(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bFh = null;
        ar(context);
    }

    public void ar(Context context) {
        if (context != null) {
            setOrientation(1);
            setGravity(1);
            av.k(this, u.f.bg_pull_up_refresh_selector);
            this.bKK = new View(context);
            this.bKK.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(u.e.ds1)));
            av.k(this.bKK, u.d.common_color_10208);
            addView(this.bKK);
            this.bKL = new TbImageView(context);
            int c = com.baidu.adp.lib.util.k.c(getContext(), u.e.ds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c, c);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.c(getContext(), u.e.ds20);
            this.bKL.setLayoutParams(layoutParams);
            av.c(this.bKL, u.f.icon_frs_reload);
            addView(this.bKL);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            av.k(this.bKK, u.d.common_color_10208);
            av.c(this.bKL, u.f.icon_frs_reload);
            av.k(this, u.f.bg_pull_up_refresh_selector);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.bFh == null) {
            this.bFh = AnimationUtils.loadAnimation(getContext(), u.a.refresh_rotate);
            this.bFh.setInterpolator(new LinearInterpolator());
            this.bFh.setFillAfter(true);
        }
        return this.bFh;
    }

    public void Yn() {
        this.bKL.startAnimation(getClickRotateAnimation());
    }

    public void Yo() {
        this.bKL.clearAnimation();
    }
}
