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
    private View fDO;
    private TbImageView fDP;
    private boolean fDQ;
    private Animation fji;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fji = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fDQ = false;
        i(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fji = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fDQ = false;
        i(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fji = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fDQ = false;
        i(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        am.c(this.fDP, this.mIconId);
    }

    public void i(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(0, R.drawable.icon_frs_reload);
                this.fDQ = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            am.k(this, R.color.cp_bg_line_d_alpha98);
            if (this.fDQ) {
                this.fDO = new View(context);
                this.fDO.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
                am.k(this.fDO, R.color.cp_bg_line_b);
                addView(this.fDO);
            }
            this.fDP = new TbImageView(context);
            int g = l.g(getContext(), R.dimen.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            layoutParams.topMargin = l.g(getContext(), R.dimen.ds20);
            this.fDP.setLayoutParams(layoutParams);
            am.c(this.fDP, this.mIconId);
            addView(this.fDP);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.k(this.fDO, R.color.cp_bg_line_b);
            am.c(this.fDP, this.mIconId);
            am.k(this, R.color.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.fji == null) {
            this.fji = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.fji.setInterpolator(new LinearInterpolator());
            this.fji.setFillAfter(true);
        }
        return this.fji;
    }

    public void biY() {
        this.fDP.startAnimation(getClickRotateAnimation());
    }

    public void biZ() {
        this.fDP.clearAnimation();
    }
}
