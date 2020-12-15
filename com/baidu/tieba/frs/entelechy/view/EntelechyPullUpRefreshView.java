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
    private Animation iLw;
    private View jfs;
    private TbImageView jft;
    private boolean jfu;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iLw = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.jfu = false;
        i(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iLw = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.jfu = false;
        i(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iLw = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.jfu = false;
        i(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        ap.setImageResource(this.jft, this.mIconId);
    }

    public void i(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(R.styleable.EntelechyPullUpRefreshView_tb_pull_up_icon, R.drawable.icon_frs_reload);
                this.jfu = obtainStyledAttributes.getBoolean(R.styleable.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            ap.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            if (this.jfu) {
                this.jfs = new View(context);
                this.jfs.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
                ap.setBackgroundResource(this.jfs, R.color.CAM_X0204);
                addView(this.jfs);
            }
            this.jft = new TbImageView(context);
            int dimens = l.getDimens(getContext(), R.dimen.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
            layoutParams.topMargin = l.getDimens(getContext(), R.dimen.ds20);
            this.jft.setLayoutParams(layoutParams);
            ap.setImageResource(this.jft, this.mIconId);
            addView(this.jft);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.jfs, R.color.CAM_X0204);
            ap.setImageResource(this.jft, this.mIconId);
            ap.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.iLw == null) {
            this.iLw = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.iLw.setInterpolator(new LinearInterpolator());
            this.iLw.setFillAfter(true);
        }
        return this.iLw;
    }
}
