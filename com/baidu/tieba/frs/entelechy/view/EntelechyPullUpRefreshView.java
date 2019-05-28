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
    private Animation feg;
    private View fyS;
    private TbImageView fyT;
    private boolean fyU;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.feg = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fyU = false;
        i(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.feg = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fyU = false;
        i(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.feg = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.fyU = false;
        i(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        al.c(this.fyT, this.mIconId);
    }

    public void i(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(0, R.drawable.icon_frs_reload);
                this.fyU = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            al.k(this, R.color.cp_bg_line_d_alpha98);
            if (this.fyU) {
                this.fyS = new View(context);
                this.fyS.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
                al.k(this.fyS, R.color.cp_bg_line_b);
                addView(this.fyS);
            }
            this.fyT = new TbImageView(context);
            int g = l.g(getContext(), R.dimen.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g, g);
            layoutParams.topMargin = l.g(getContext(), R.dimen.ds20);
            this.fyT.setLayoutParams(layoutParams);
            al.c(this.fyT, this.mIconId);
            addView(this.fyT);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.k(this.fyS, R.color.cp_bg_line_b);
            al.c(this.fyT, this.mIconId);
            al.k(this, R.color.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.feg == null) {
            this.feg = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.feg.setInterpolator(new LinearInterpolator());
            this.feg.setFillAfter(true);
        }
        return this.feg;
    }

    public void bgV() {
        this.fyT.startAnimation(getClickRotateAnimation());
    }

    public void bgW() {
        this.fyT.clearAnimation();
    }
}
