package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f16091e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f16092f;

    /* renamed from: g  reason: collision with root package name */
    public int f16093g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f16094h;

    /* renamed from: i  reason: collision with root package name */
    public int f16095i;
    public boolean j;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.f16093g = 3;
        this.f16094h = null;
        this.f16095i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, null);
    }

    private Animation getClickRotateAnimation() {
        if (this.f16094h == null) {
            this.f16094h = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.f16094h.setInterpolator(new LinearInterpolator());
            this.f16094h.setFillAfter(true);
        }
        return this.f16094h;
    }

    public void a(Context context, AttributeSet attributeSet) {
        if (context == null) {
            return;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.EntelechyPullUpRefreshView);
            this.f16095i = obtainStyledAttributes.getResourceId(R$styleable.EntelechyPullUpRefreshView_tb_pull_up_icon, R.drawable.icon_frs_reload);
            this.j = obtainStyledAttributes.getBoolean(R$styleable.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
            obtainStyledAttributes.recycle();
        }
        setOrientation(1);
        setGravity(1);
        SkinManager.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
        if (this.j) {
            this.f16091e = new View(context);
            this.f16091e.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
            SkinManager.setBackgroundResource(this.f16091e, R.color.CAM_X0204);
            addView(this.f16091e);
        }
        this.f16092f = new TbImageView(context);
        int g2 = l.g(getContext(), R.dimen.ds48);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
        layoutParams.topMargin = l.g(getContext(), R.dimen.ds20);
        this.f16092f.setLayoutParams(layoutParams);
        SkinManager.setImageResource(this.f16092f, this.f16095i);
        addView(this.f16092f);
    }

    public void b(int i2) {
        if (this.f16093g != i2) {
            SkinManager.setBackgroundResource(this.f16091e, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f16092f, this.f16095i);
            SkinManager.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            this.f16093g = i2;
        }
    }

    public void setIconResource(int i2) {
        this.f16095i = i2;
        SkinManager.setImageResource(this.f16092f, i2);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16093g = 3;
        this.f16094h = null;
        this.f16095i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16093g = 3;
        this.f16094h = null;
        this.f16095i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, attributeSet);
    }
}
