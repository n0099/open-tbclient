package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class at extends LinearLayout {
    Animation bRw;
    View bXI;
    TbImageView bXJ;
    private int mSkinType;

    public at(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bRw = null;
        aC(context);
    }

    public void aC(Context context) {
        if (context != null) {
            setOrientation(1);
            setGravity(1);
            av.k(this, r.f.bg_pull_up_refresh_selector);
            this.bXI = new View(context);
            this.bXI.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(r.e.ds1)));
            av.k(this.bXI, r.d.common_color_10208);
            addView(this.bXI);
            this.bXJ = new TbImageView(context);
            int e = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e, e);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.e(getContext(), r.e.ds20);
            this.bXJ.setLayoutParams(layoutParams);
            av.c(this.bXJ, r.f.icon_frs_reload);
            addView(this.bXJ);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            av.k(this.bXI, r.d.common_color_10208);
            av.c(this.bXJ, r.f.icon_frs_reload);
            av.k(this, r.f.bg_pull_up_refresh_selector);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.bRw == null) {
            this.bRw = AnimationUtils.loadAnimation(getContext(), r.a.refresh_rotate);
            this.bRw.setInterpolator(new LinearInterpolator());
            this.bRw.setFillAfter(true);
        }
        return this.bRw;
    }

    public void adH() {
        this.bXJ.startAnimation(getClickRotateAnimation());
    }

    public void adI() {
        this.bXJ.clearAnimation();
    }
}
