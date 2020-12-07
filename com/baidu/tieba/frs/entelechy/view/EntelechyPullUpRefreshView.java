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
    private Animation iLu;
    private View jfq;
    private TbImageView jfr;
    private boolean jfs;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iLu = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.jfs = false;
        i(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iLu = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.jfs = false;
        i(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iLu = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.jfs = false;
        i(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        ap.setImageResource(this.jfr, this.mIconId);
    }

    public void i(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(R.styleable.EntelechyPullUpRefreshView_tb_pull_up_icon, R.drawable.icon_frs_reload);
                this.jfs = obtainStyledAttributes.getBoolean(R.styleable.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            ap.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            if (this.jfs) {
                this.jfq = new View(context);
                this.jfq.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
                ap.setBackgroundResource(this.jfq, R.color.CAM_X0204);
                addView(this.jfq);
            }
            this.jfr = new TbImageView(context);
            int dimens = l.getDimens(getContext(), R.dimen.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
            layoutParams.topMargin = l.getDimens(getContext(), R.dimen.ds20);
            this.jfr.setLayoutParams(layoutParams);
            ap.setImageResource(this.jfr, this.mIconId);
            addView(this.jfr);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.jfq, R.color.CAM_X0204);
            ap.setImageResource(this.jfr, this.mIconId);
            ap.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.iLu == null) {
            this.iLu = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.iLu.setInterpolator(new LinearInterpolator());
            this.iLu.setFillAfter(true);
        }
        return this.iLu;
    }
}
