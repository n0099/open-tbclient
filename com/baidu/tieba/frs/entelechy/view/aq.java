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
public class aq extends LinearLayout {
    Animation bGv;
    View bMu;
    TbImageView bMv;
    private int mSkinType;

    public aq(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bGv = null;
        ar(context);
    }

    public void ar(Context context) {
        if (context != null) {
            setOrientation(1);
            setGravity(1);
            av.k(this, u.f.bg_pull_up_refresh_selector);
            this.bMu = new View(context);
            this.bMu.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(u.e.ds1)));
            av.k(this.bMu, u.d.common_color_10208);
            addView(this.bMu);
            this.bMv = new TbImageView(context);
            int c = com.baidu.adp.lib.util.k.c(getContext(), u.e.ds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c, c);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.c(getContext(), u.e.ds20);
            this.bMv.setLayoutParams(layoutParams);
            av.c(this.bMv, u.f.icon_frs_reload);
            addView(this.bMv);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            av.k(this.bMu, u.d.common_color_10208);
            av.c(this.bMv, u.f.icon_frs_reload);
            av.k(this, u.f.bg_pull_up_refresh_selector);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.bGv == null) {
            this.bGv = AnimationUtils.loadAnimation(getContext(), u.a.refresh_rotate);
            this.bGv.setInterpolator(new LinearInterpolator());
            this.bGv.setFillAfter(true);
        }
        return this.bGv;
    }

    public void YH() {
        this.bMv.startAnimation(getClickRotateAnimation());
    }

    public void YI() {
        this.bMv.clearAnimation();
    }
}
