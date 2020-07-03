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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {
    private View hLe;
    private TbImageView hLf;
    private boolean hLg;
    private Animation hsl;
    private int mIconId;
    private int mSkinType;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hsl = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.hLg = false;
        i(context, null);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hsl = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.hLg = false;
        i(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hsl = null;
        this.mIconId = R.drawable.icon_frs_reload;
        this.hLg = false;
        i(context, attributeSet);
    }

    public void setIconResource(int i) {
        this.mIconId = i;
        an.setImageResource(this.hLf, this.mIconId);
    }

    public void i(Context context, AttributeSet attributeSet) {
        if (context != null) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EntelechyPullUpRefreshView);
                this.mIconId = obtainStyledAttributes.getResourceId(0, R.drawable.icon_frs_reload);
                this.hLg = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
            }
            setOrientation(1);
            setGravity(1);
            an.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            if (this.hLg) {
                this.hLe = new View(context);
                this.hLe.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
                an.setBackgroundResource(this.hLe, R.color.cp_bg_line_c);
                addView(this.hLe);
            }
            this.hLf = new TbImageView(context);
            int dimens = l.getDimens(getContext(), R.dimen.ds48);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
            layoutParams.topMargin = l.getDimens(getContext(), R.dimen.ds20);
            this.hLf.setLayoutParams(layoutParams);
            an.setImageResource(this.hLf, this.mIconId);
            addView(this.hLf);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(this.hLe, R.color.cp_bg_line_c);
            an.setImageResource(this.hLf, this.mIconId);
            an.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            this.mSkinType = i;
        }
    }

    private Animation getClickRotateAnimation() {
        if (this.hsl == null) {
            this.hsl = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.hsl.setInterpolator(new LinearInterpolator());
            this.hsl.setFillAfter(true);
        }
        return this.hsl;
    }
}
