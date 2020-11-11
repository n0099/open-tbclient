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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private View iTI;
    private TbImageView iTJ;
    private boolean iTK;
    private Animation izN;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.izN = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.iTK = false;
        i(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.izN = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.iTK = false;
        i(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.izN = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.iTK = false;
        i(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        ap.setImageResource(this.iTJ, this.mIconId);
    }

    public void i(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(R.styleable.EntelechyPullUpRefreshView_tb_pull_up_icon, R.drawable.icon_frs_reload);
                this.iTK = obtainStyledAttributes.getBoolean(R.styleable.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            ap.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            if (this.iTK) {
                this.iTI = new View(context);
                this.iTI.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
                ap.setBackgroundResource(this.iTI, R.color.cp_bg_line_c);
                addView(this.iTI);
            }
            this.iTJ = new TbImageView(context);
            int dimens = l.getDimens(getContext(), R.dimen.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
            layoutParams.topMargin = l.getDimens(getContext(), R.dimen.ds20);
            this.iTJ.setLayoutParams(layoutParams);
            ap.setImageResource(this.iTJ, this.mIconId);
            addView(this.iTJ);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.iTI, R.color.cp_bg_line_c);
            ap.setImageResource(this.iTJ, this.mIconId);
            ap.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.izN == null) {
            this.izN = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.izN.setInterpolator(new LinearInterpolator());
            this.izN.setFillAfter(true);
        }
        return this.izN;
    }
}
