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
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f15903e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f15904f;

    /* renamed from: g  reason: collision with root package name */
    public int f15905g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f15906h;
    public int i;
    public boolean j;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.f15905g = 3;
        this.f15906h = null;
        this.i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, null);
    }

    private Animation getClickRotateAnimation() {
        if (this.f15906h == null) {
            this.f15906h = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.f15906h.setInterpolator(new LinearInterpolator());
            this.f15906h.setFillAfter(true);
        }
        return this.f15906h;
    }

    public void a(Context context, AttributeSet attributeSet) {
        if (context == null) {
            return;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.EntelechyPullUpRefreshView);
            this.i = obtainStyledAttributes.getResourceId(R$styleable.EntelechyPullUpRefreshView_tb_pull_up_icon, R.drawable.icon_frs_reload);
            this.j = obtainStyledAttributes.getBoolean(R$styleable.EntelechyPullUpRefreshView_tb_pull_show_top_line, false);
            obtainStyledAttributes.recycle();
        }
        setOrientation(1);
        setGravity(1);
        SkinManager.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
        if (this.j) {
            this.f15903e = new View(context);
            this.f15903e.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
            SkinManager.setBackgroundResource(this.f15903e, R.color.CAM_X0204);
            addView(this.f15903e);
        }
        this.f15904f = new TbImageView(context);
        int g2 = l.g(getContext(), R.dimen.ds48);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
        layoutParams.topMargin = l.g(getContext(), R.dimen.ds20);
        this.f15904f.setLayoutParams(layoutParams);
        SkinManager.setImageResource(this.f15904f, this.i);
        addView(this.f15904f);
    }

    public void b(int i) {
        if (this.f15905g != i) {
            SkinManager.setBackgroundResource(this.f15903e, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f15904f, this.i);
            SkinManager.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            this.f15905g = i;
        }
    }

    public void setIconResource(int i) {
        this.i = i;
        SkinManager.setImageResource(this.f15904f, i);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15905g = 3;
        this.f15906h = null;
        this.i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15905g = 3;
        this.f15906h = null;
        this.i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, attributeSet);
    }
}
