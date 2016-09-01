package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class at extends LinearLayout {
    Animation bRD;
    View bXN;
    TbImageView bXO;
    private int mSkinType;

    public at(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bRD = null;
        aE(context);
    }

    public void aE(Context context) {
        if (context != null) {
            setOrientation(1);
            setGravity(1);
            av.k(this, t.f.bg_pull_up_refresh_selector);
            this.bXN = new View(context);
            this.bXN.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(t.e.ds1)));
            av.k(this.bXN, t.d.common_color_10208);
            addView(this.bXN);
            this.bXO = new TbImageView(context);
            int e = com.baidu.adp.lib.util.k.e(getContext(), t.e.ds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e, e);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.e(getContext(), t.e.ds20);
            this.bXO.setLayoutParams(layoutParams);
            av.c(this.bXO, t.f.icon_frs_reload);
            addView(this.bXO);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            av.k(this.bXN, t.d.common_color_10208);
            av.c(this.bXO, t.f.icon_frs_reload);
            av.k(this, t.f.bg_pull_up_refresh_selector);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.bRD == null) {
            this.bRD = AnimationUtils.loadAnimation(getContext(), t.a.refresh_rotate);
            this.bRD.setInterpolator(new LinearInterpolator());
            this.bRD.setFillAfter(true);
        }
        return this.bRD;
    }

    public void adt() {
        this.bXO.startAnimation(getClickRotateAnimation());
    }

    public void adu() {
        this.bXO.clearAnimation();
    }
}
