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
    private View dJd;
    private TbImageView dJe;
    private boolean dJf;
    private Animation dvc;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dvc = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dJf = false;
        d(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dvc = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dJf = false;
        d(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dvc = null;
        this.mIconId = d.f.icon_frs_reload;
        this.dJf = false;
        d(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        aj.c(this.dJe, this.mIconId);
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(d.l.EntelechyPullUpRefreshView_tb_pull_up_icon, d.f.icon_frs_reload);
                this.dJf = obtainStyledAttributes.getBoolean(d.l.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            aj.s(this, d.C0107d.cp_bg_line_d_alpha98);
            if (this.dJf) {
                this.dJd = new View(context);
                this.dJd.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(d.e.ds1)));
                aj.s(this.dJd, d.C0107d.cp_bg_line_b);
                addView(this.dJd);
            }
            this.dJe = new TbImageView(context);
            int s = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(s, s);
            layoutParams.topMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds20);
            this.dJe.setLayoutParams(layoutParams);
            aj.c(this.dJe, this.mIconId);
            addView(this.dJe);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.s(this.dJd, d.C0107d.cp_bg_line_b);
            aj.c(this.dJe, this.mIconId);
            aj.s(this, d.C0107d.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.dvc == null) {
            this.dvc = AnimationUtils.loadAnimation(getContext(), d.a.refresh_rotate);
            this.dvc.setInterpolator(new LinearInterpolator());
            this.dvc.setFillAfter(true);
        }
        return this.dvc;
    }

    public void asn() {
        this.dJe.startAnimation(getClickRotateAnimation());
    }

    public void aso() {
        this.dJe.clearAnimation();
    }
}
