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
/* loaded from: classes4.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private View fER;
    private TbImageView fES;
    private boolean fET;
    private Animation fnm;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fnm = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fET = false;
        i(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fnm = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fET = false;
        i(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fnm = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fET = false;
        i(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        am.setImageResource(this.fES, this.mIconId);
    }

    public void i(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(0, R.drawable.icon_frs_reload);
                this.fET = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            am.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            if (this.fET) {
                this.fER = new View(context);
                this.fER.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
                am.setBackgroundResource(this.fER, R.color.cp_bg_line_c);
                addView(this.fER);
            }
            this.fES = new TbImageView(context);
            int dimens = l.getDimens(getContext(), R.dimen.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
            layoutParams.topMargin = l.getDimens(getContext(), R.dimen.ds20);
            this.fES.setLayoutParams(layoutParams);
            am.setImageResource(this.fES, this.mIconId);
            addView(this.fES);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fER, R.color.cp_bg_line_c);
            am.setImageResource(this.fES, this.mIconId);
            am.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.fnm == null) {
            this.fnm = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.fnm.setInterpolator(new LinearInterpolator());
            this.fnm.setFillAfter(true);
        }
        return this.fnm;
    }

    public void bhH() {
        this.fES.startAnimation(getClickRotateAnimation());
    }

    public void bhI() {
        this.fES.clearAnimation();
    }
}
