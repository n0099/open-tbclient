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
/* loaded from: classes2.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private Animation iYV;
    private View jtf;
    private TbImageView jtg;
    private boolean jth;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iYV = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.jth = false;
        k(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iYV = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.jth = false;
        k(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iYV = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.jth = false;
        k(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        ap.setImageResource(this.jtg, this.mIconId);
    }

    public void k(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(R.styleable.EntelechyPullUpRefreshView_tb_pull_up_icon, R.drawable.icon_frs_reload);
                this.jth = obtainStyledAttributes.getBoolean(R.styleable.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            ap.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            if (this.jth) {
                this.jtf = new View(context);
                this.jtf.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
                ap.setBackgroundResource(this.jtf, R.color.CAM_X0204);
                addView(this.jtf);
            }
            this.jtg = new TbImageView(context);
            int dimens = l.getDimens(getContext(), R.dimen.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
            layoutParams.topMargin = l.getDimens(getContext(), R.dimen.ds20);
            this.jtg.setLayoutParams(layoutParams);
            ap.setImageResource(this.jtg, this.mIconId);
            addView(this.jtg);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.jtf, R.color.CAM_X0204);
            ap.setImageResource(this.jtg, this.mIconId);
            ap.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.iYV == null) {
            this.iYV = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.iYV.setInterpolator(new LinearInterpolator());
            this.iYV.setFillAfter(true);
        }
        return this.iYV;
    }
}
