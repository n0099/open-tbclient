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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.c;
/* loaded from: classes4.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private Animation fef;
    private View fyR;
    private TbImageView fyS;
    private boolean fyT;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fef = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fyT = false;
        i(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fef = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fyT = false;
        i(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fef = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fyT = false;
        i(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        al.c(this.fyS, this.mIconId);
    }

    public void i(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(0, R.drawable.icon_frs_reload);
                this.fyT = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            al.k(this, R.color.cp_bg_line_d_alpha98);
            if (this.fyT) {
                this.fyR = new View(context);
                this.fyR.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
                al.k(this.fyR, R.color.cp_bg_line_b);
                addView(this.fyR);
            }
            this.fyS = new TbImageView(context);
            int g = l.g(getContext(), R.dimen.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            layoutParams.topMargin = l.g(getContext(), R.dimen.ds20);
            this.fyS.setLayoutParams(layoutParams);
            al.c(this.fyS, this.mIconId);
            addView(this.fyS);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.k(this.fyR, R.color.cp_bg_line_b);
            al.c(this.fyS, this.mIconId);
            al.k(this, R.color.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.fef == null) {
            this.fef = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.fef.setInterpolator(new LinearInterpolator());
            this.fef.setFillAfter(true);
        }
        return this.fef;
    }

    public void bgS() {
        this.fyS.startAnimation(getClickRotateAnimation());
    }

    public void bgT() {
        this.fyS.clearAnimation();
    }
}
