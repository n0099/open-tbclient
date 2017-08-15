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
    private View cpX;
    private TbImageView cpY;
    private Animation cpZ;
    private int cqa;
    private boolean cqb;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cpZ = null;
        this.cqa = d.g.icon_frs_reload;
        this.cqb = false;
        e(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cpZ = null;
        this.cqa = d.g.icon_frs_reload;
        this.cqb = false;
        e(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cpZ = null;
        this.cqa = d.g.icon_frs_reload;
        this.cqb = false;
        e(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.cqa = i;
        ai.c(this.cpY, this.cqa);
    }

    public void e(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.EntelechyPullUpRefreshView);
                this.cqa = obtainStyledAttributes.getResourceId(d.n.EntelechyPullUpRefreshView_tb_pull_up_icon, d.g.icon_frs_reload);
                this.cqb = obtainStyledAttributes.getBoolean(d.n.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            ai.j(this, d.g.bg_pull_up_refresh_selector);
            if (this.cqb) {
                this.cpX = new View(context);
                this.cpX.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.f.ds1)));
                ai.j(this.cpX, d.e.common_color_10208);
                addView(this.cpX);
            }
            this.cpY = new TbImageView(context);
            int g = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds40);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            layoutParams.topMargin = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds20);
            this.cpY.setLayoutParams(layoutParams);
            ai.c(this.cpY, this.cqa);
            addView(this.cpY);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.j(this.cpX, d.e.common_color_10208);
            ai.c(this.cpY, this.cqa);
            ai.j(this, d.g.bg_pull_up_refresh_selector);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.cpZ == null) {
            this.cpZ = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.cpZ.setInterpolator(new LinearInterpolator());
            this.cpZ.setFillAfter(true);
        }
        return this.cpZ;
    }

    public void ahH() {
        this.cpY.startAnimation(getClickRotateAnimation());
    }

    public void ahI() {
        this.cpY.clearAnimation();
    }
}
