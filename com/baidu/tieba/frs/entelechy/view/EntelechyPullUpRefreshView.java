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
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class EntelechyPullUpRefreshView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f16234e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f16235f;

    /* renamed from: g  reason: collision with root package name */
    public int f16236g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f16237h;
    public int i;
    public boolean j;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.f16236g = 3;
        this.f16237h = null;
        this.i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, null);
    }

    private Animation getClickRotateAnimation() {
        if (this.f16237h == null) {
            this.f16237h = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.f16237h.setInterpolator(new LinearInterpolator());
            this.f16237h.setFillAfter(true);
        }
        return this.f16237h;
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
            this.f16234e = new View(context);
            this.f16234e.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
            SkinManager.setBackgroundResource(this.f16234e, R.color.CAM_X0204);
            addView(this.f16234e);
        }
        this.f16235f = new TbImageView(context);
        int g2 = l.g(getContext(), R.dimen.ds48);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
        layoutParams.topMargin = l.g(getContext(), R.dimen.ds20);
        this.f16235f.setLayoutParams(layoutParams);
        SkinManager.setImageResource(this.f16235f, this.i);
        addView(this.f16235f);
    }

    public void b(int i) {
        if (this.f16236g != i) {
            SkinManager.setBackgroundResource(this.f16234e, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f16235f, this.i);
            SkinManager.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            this.f16236g = i;
        }
    }

    public void setIconResource(int i) {
        this.i = i;
        SkinManager.setImageResource(this.f16235f, i);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16236g = 3;
        this.f16237h = null;
        this.i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16236g = 3;
        this.f16237h = null;
        this.i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, attributeSet);
    }
}
