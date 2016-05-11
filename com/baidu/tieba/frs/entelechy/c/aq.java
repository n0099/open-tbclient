package com.baidu.tieba.frs.entelechy.c;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class aq extends LinearLayout {
    Animation bjU;
    View bpZ;
    TbImageView bqa;
    private int mSkinType;

    public aq(Context context) {
        super(context);
        this.mSkinType = 3;
        this.bjU = null;
        ar(context);
    }

    public void ar(Context context) {
        if (context != null) {
            setOrientation(1);
            setGravity(1);
            com.baidu.tbadk.core.util.at.k(this, t.f.bg_pull_up_refresh_selector);
            this.bpZ = new View(context);
            this.bpZ.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(t.e.ds1)));
            com.baidu.tbadk.core.util.at.k(this.bpZ, t.d.cp_bg_line_e_alpha95);
            addView(this.bpZ);
            this.bqa = new TbImageView(context);
            int c = com.baidu.adp.lib.util.k.c(getContext(), t.e.ds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c, c);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.c(getContext(), t.e.ds20);
            this.bqa.setLayoutParams(layoutParams);
            com.baidu.tbadk.core.util.at.c(this.bqa, t.f.icon_frs_reload);
            addView(this.bqa);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(this.bpZ, t.d.cp_bg_line_e_alpha95);
            com.baidu.tbadk.core.util.at.c(this.bqa, t.f.icon_frs_reload);
            com.baidu.tbadk.core.util.at.k(this, t.f.bg_pull_up_refresh_selector);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.bjU == null) {
            this.bjU = AnimationUtils.loadAnimation(getContext(), t.a.refresh_rotate);
            this.bjU.setInterpolator(new LinearInterpolator());
            this.bjU.setFillAfter(true);
        }
        return this.bjU;
    }

    public void SN() {
        this.bqa.startAnimation(getClickRotateAnimation());
    }

    public void SO() {
        this.bqa.clearAnimation();
    }
}
