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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private Animation iXH;
    private View jrR;
    private TbImageView jrS;
    private boolean jrT;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iXH = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.jrT = false;
        k(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iXH = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.jrT = false;
        k(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iXH = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.jrT = false;
        k(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        ao.setImageResource(this.jrS, this.mIconId);
    }

    public void k(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(R.styleable.EntelechyPullUpRefreshView_tb_pull_up_icon, R.drawable.icon_frs_reload);
                this.jrT = obtainStyledAttributes.getBoolean(R.styleable.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            ao.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            if (this.jrT) {
                this.jrR = new View(context);
                this.jrR.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
                ao.setBackgroundResource(this.jrR, R.color.CAM_X0204);
                addView(this.jrR);
            }
            this.jrS = new TbImageView(context);
            int dimens = l.getDimens(getContext(), R.dimen.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
            layoutParams.topMargin = l.getDimens(getContext(), R.dimen.ds20);
            this.jrS.setLayoutParams(layoutParams);
            ao.setImageResource(this.jrS, this.mIconId);
            addView(this.jrS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.jrR, R.color.CAM_X0204);
            ao.setImageResource(this.jrS, this.mIconId);
            ao.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.iXH == null) {
            this.iXH = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.iXH.setInterpolator(new LinearInterpolator());
            this.iXH.setFillAfter(true);
        }
        return this.iXH;
    }
}
