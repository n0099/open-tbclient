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
/* loaded from: classes9.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private Animation ghj;
    private View gyI;
    private TbImageView gyJ;
    private boolean gyK;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ghj = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.gyK = false;
        i(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ghj = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.gyK = false;
        i(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ghj = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.gyK = false;
        i(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        am.setImageResource(this.gyJ, this.mIconId);
    }

    public void i(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(0, R.drawable.icon_frs_reload);
                this.gyK = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            am.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            if (this.gyK) {
                this.gyI = new View(context);
                this.gyI.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
                am.setBackgroundResource(this.gyI, R.color.cp_bg_line_c);
                addView(this.gyI);
            }
            this.gyJ = new TbImageView(context);
            int dimens = l.getDimens(getContext(), R.dimen.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
            layoutParams.topMargin = l.getDimens(getContext(), R.dimen.ds20);
            this.gyJ.setLayoutParams(layoutParams);
            am.setImageResource(this.gyJ, this.mIconId);
            addView(this.gyJ);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.gyI, R.color.cp_bg_line_c);
            am.setImageResource(this.gyJ, this.mIconId);
            am.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.ghj == null) {
            this.ghj = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.ghj.setInterpolator(new LinearInterpolator());
            this.ghj.setFillAfter(true);
        }
        return this.ghj;
    }

    public void bBJ() {
        this.gyJ.startAnimation(getClickRotateAnimation());
    }

    public void bBK() {
        this.gyJ.clearAnimation();
    }
}
