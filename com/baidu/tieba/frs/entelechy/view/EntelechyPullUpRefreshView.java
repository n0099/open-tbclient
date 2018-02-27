package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private View dMn;
    private TbImageView dMo;
    private boolean dMp;
    private Animation dyd;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dyd = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dMp = false;
        d(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dyd = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dMp = false;
        d(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dyd = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dMp = false;
        d(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        aj.c(this.dMo, this.mIconId);
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(d.l.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.dMp = obtainStyledAttributes.getBoolean(d.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            aj.s(this, d.C0141d.cp_bg_line_d_alpha98);
            if (this.dMp) {
                this.dMn = new View(context);
                this.dMn.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                aj.s(this.dMn, d.C0141d.cp_bg_line_b);
                addView(this.dMn);
            }
            this.dMo = new TbImageView(context);
            int t = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(t, t);
            layoutParams.topMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds20);
            this.dMo.setLayoutParams(layoutParams);
            aj.c(this.dMo, this.mIconId);
            addView(this.dMo);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.s(this.dMn, d.C0141d.cp_bg_line_b);
            aj.c(this.dMo, this.mIconId);
            aj.s(this, d.C0141d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.dyd == null) {
            this.dyd = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.dyd.setInterpolator(new LinearInterpolator());
            this.dyd.setFillAfter(true);
        }
        return this.dyd;
    }

    public void ath() {
        this.dMo.startAnimation(getClickRotateAnimation());
    }

    public void ati() {
        this.dMo.clearAnimation();
    }
}
