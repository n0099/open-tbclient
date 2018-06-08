package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private Animation dbe;
    private View dpm;
    private TbImageView dpn;
    private boolean dpo;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dbe = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dpo = false;
        g(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dbe = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dpo = false;
        g(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dbe = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dpo = false;
        g(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        al.c(this.dpn, this.mIconId);
    }

    public void g(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(d.m.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.dpo = obtainStyledAttributes.getBoolean(d.m.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            al.i(this, d.C0141d.cp_bg_line_d_alpha98);
            if (this.dpo) {
                this.dpm = new View(context);
                this.dpm.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                al.i(this.dpm, d.C0141d.cp_bg_line_b);
                addView(this.dpm);
            }
            this.dpn = new TbImageView(context);
            int e = l.e(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(e, e);
            layoutParams.topMargin = l.e(getContext(), d.e.ds20);
            this.dpn.setLayoutParams(layoutParams);
            al.c(this.dpn, this.mIconId);
            addView(this.dpn);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this.dpm, d.C0141d.cp_bg_line_b);
            al.c(this.dpn, this.mIconId);
            al.i(this, d.C0141d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.dbe == null) {
            this.dbe = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.dbe.setInterpolator(new LinearInterpolator());
            this.dbe.setFillAfter(true);
        }
        return this.dbe;
    }

    public void arB() {
        this.dpn.startAnimation(getClickRotateAnimation());
    }

    public void arC() {
        this.dpn.clearAnimation();
    }
}
