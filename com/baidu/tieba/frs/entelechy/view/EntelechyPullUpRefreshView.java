package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private View cpY;
    private TbImageView cpZ;
    private Animation cqa;
    private int cqb;
    private boolean cqc;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cqa = null;
        this.cqb = d.g.icon_frs_reload;
        this.cqc = false;
        e(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cqa = null;
        this.cqb = d.g.icon_frs_reload;
        this.cqc = false;
        e(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cqa = null;
        this.cqb = d.g.icon_frs_reload;
        this.cqc = false;
        e(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.cqb = i;
        ai.c(this.cpZ, this.cqb);
    }

    public void e(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.EntelechyPullUpRefreshView);
                this.cqb = obtainStyledAttributes.getResourceId(d.n.EntelechyPullUpRefreshView_tb_pull_up_icon, d.g.icon_frs_reload);
                this.cqc = obtainStyledAttributes.getBoolean(d.n.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            ai.j(this, d.g.bg_pull_up_refresh_selector);
            if (this.cqc) {
                this.cpY = new View(context);
                this.cpY.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.f.ds1)));
                ai.j(this.cpY, d.e.common_color_10208);
                addView(this.cpY);
            }
            this.cpZ = new TbImageView(context);
            int g = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds20);
            this.cpZ.setLayoutParams(layoutParams);
            ai.c(this.cpZ, this.cqb);
            addView(this.cpZ);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.j(this.cpY, d.e.common_color_10208);
            ai.c(this.cpZ, this.cqb);
            ai.j(this, d.g.bg_pull_up_refresh_selector);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.cqa == null) {
            this.cqa = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.cqa.setInterpolator(new LinearInterpolator());
            this.cqa.setFillAfter(true);
        }
        return this.cqa;
    }

    public void ahB() {
        this.cpZ.startAnimation(getClickRotateAnimation());
    }

    public void ahC() {
        this.cpZ.clearAnimation();
    }
}
