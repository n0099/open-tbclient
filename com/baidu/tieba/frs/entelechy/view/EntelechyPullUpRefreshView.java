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
/* loaded from: classes16.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private View hRd;
    private TbImageView hRe;
    private boolean hRf;
    private Animation hxX;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hxX = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.hRf = false;
        i(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hxX = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.hRf = false;
        i(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hxX = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.hRf = false;
        i(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        ao.setImageResource(this.hRe, this.mIconId);
    }

    public void i(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(R.styleable.EntelechyPullUpRefreshView_tb_pull_up_icon, R.drawable.icon_frs_reload);
                this.hRf = obtainStyledAttributes.getBoolean(R.styleable.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            ao.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            if (this.hRf) {
                this.hRd = new View(context);
                this.hRd.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
                ao.setBackgroundResource(this.hRd, R.color.cp_bg_line_c);
                addView(this.hRd);
            }
            this.hRe = new TbImageView(context);
            int dimens = l.getDimens(getContext(), R.dimen.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
            layoutParams.topMargin = l.getDimens(getContext(), R.dimen.ds20);
            this.hRe.setLayoutParams(layoutParams);
            ao.setImageResource(this.hRe, this.mIconId);
            addView(this.hRe);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.hRd, R.color.cp_bg_line_c);
            ao.setImageResource(this.hRe, this.mIconId);
            ao.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.hxX == null) {
            this.hxX = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.hxX.setInterpolator(new LinearInterpolator());
            this.hxX.setFillAfter(true);
        }
        return this.hxX;
    }
}
