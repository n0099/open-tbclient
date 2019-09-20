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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private View fGr;
    private TbImageView fGs;
    private boolean fGt;
    private Animation flv;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.flv = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fGt = false;
        i(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.flv = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fGt = false;
        i(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.flv = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fGt = false;
        i(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        am.c(this.fGs, this.mIconId);
    }

    public void i(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(0, R.drawable.icon_frs_reload);
                this.fGt = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            am.k(this, R.color.cp_bg_line_d_alpha98);
            if (this.fGt) {
                this.fGr = new View(context);
                this.fGr.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
                am.k(this.fGr, R.color.cp_bg_line_c);
                addView(this.fGr);
            }
            this.fGs = new TbImageView(context);
            int g = l.g(getContext(), R.dimen.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            layoutParams.topMargin = l.g(getContext(), R.dimen.ds20);
            this.fGs.setLayoutParams(layoutParams);
            am.c(this.fGs, this.mIconId);
            addView(this.fGs);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.k(this.fGr, R.color.cp_bg_line_c);
            am.c(this.fGs, this.mIconId);
            am.k(this, R.color.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.flv == null) {
            this.flv = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.flv.setInterpolator(new LinearInterpolator());
            this.flv.setFillAfter(true);
        }
        return this.flv;
    }

    public void bjQ() {
        this.fGs.startAnimation(getClickRotateAnimation());
    }

    public void bjR() {
        this.fGs.clearAnimation();
    }
}
