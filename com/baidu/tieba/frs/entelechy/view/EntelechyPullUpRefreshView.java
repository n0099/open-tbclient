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
    public View f15406e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f15407f;

    /* renamed from: g  reason: collision with root package name */
    public int f15408g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f15409h;

    /* renamed from: i  reason: collision with root package name */
    public int f15410i;
    public boolean j;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.f15408g = 3;
        this.f15409h = null;
        this.f15410i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, null);
    }

    private Animation getClickRotateAnimation() {
        if (this.f15409h == null) {
            this.f15409h = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.f15409h.setInterpolator(new LinearInterpolator());
            this.f15409h.setFillAfter(true);
        }
        return this.f15409h;
    }

    public void a(Context context, AttributeSet attributeSet) {
        if (context == null) {
            return;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.EntelechyPullUpRefreshView);
            this.f15410i = obtainStyledAttributes.getResourceId(R$styleable.EntelechyPullUpRefreshView_tb_pull_up_icon, R.drawable.icon_frs_reload);
            this.j = obtainStyledAttributes.getBoolean(R$styleable.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
            obtainStyledAttributes.recycle();
        }
        setOrientation(1);
        setGravity(1);
        SkinManager.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
        if (this.j) {
            this.f15406e = new View(context);
            this.f15406e.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
            SkinManager.setBackgroundResource(this.f15406e, R.color.CAM_X0204);
            addView(this.f15406e);
        }
        this.f15407f = new TbImageView(context);
        int g2 = l.g(getContext(), R.dimen.ds48);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
        layoutParams.topMargin = l.g(getContext(), R.dimen.ds20);
        this.f15407f.setLayoutParams(layoutParams);
        SkinManager.setImageResource(this.f15407f, this.f15410i);
        addView(this.f15407f);
    }

    public void b(int i2) {
        if (this.f15408g != i2) {
            SkinManager.setBackgroundResource(this.f15406e, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f15407f, this.f15410i);
            SkinManager.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            this.f15408g = i2;
        }
    }

    public void setIconResource(int i2) {
        this.f15410i = i2;
        SkinManager.setImageResource(this.f15407f, i2);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15408g = 3;
        this.f15409h = null;
        this.f15410i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15408g = 3;
        this.f15409h = null;
        this.f15410i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, attributeSet);
    }
}
