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
import com.baidu.tieba.c;
/* loaded from: classes4.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private View fEC;
    private TbImageView fED;
    private boolean fEE;
    private Animation fjI;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fjI = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fEE = false;
        i(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fjI = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fEE = false;
        i(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fjI = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fEE = false;
        i(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        am.c(this.fED, this.mIconId);
    }

    public void i(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(0, R.drawable.icon_frs_reload);
                this.fEE = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            am.k(this, R.color.cp_bg_line_d_alpha98);
            if (this.fEE) {
                this.fEC = new View(context);
                this.fEC.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
                am.k(this.fEC, R.color.cp_bg_line_b);
                addView(this.fEC);
            }
            this.fED = new TbImageView(context);
            int g = l.g(getContext(), R.dimen.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            layoutParams.topMargin = l.g(getContext(), R.dimen.ds20);
            this.fED.setLayoutParams(layoutParams);
            am.c(this.fED, this.mIconId);
            addView(this.fED);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.k(this.fEC, R.color.cp_bg_line_b);
            am.c(this.fED, this.mIconId);
            am.k(this, R.color.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.fjI == null) {
            this.fjI = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.fjI.setInterpolator(new LinearInterpolator());
            this.fjI.setFillAfter(true);
        }
        return this.fjI;
    }

    public void bjf() {
        this.fED.startAnimation(getClickRotateAnimation());
    }

    public void bjg() {
        this.fED.clearAnimation();
    }
}
