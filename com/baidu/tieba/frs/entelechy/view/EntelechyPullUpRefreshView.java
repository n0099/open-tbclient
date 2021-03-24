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
    public View f16233e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f16234f;

    /* renamed from: g  reason: collision with root package name */
    public int f16235g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f16236h;
    public int i;
    public boolean j;

    public EntelechyPullUpRefreshView(Context context) {
        super(context);
        this.f16235g = 3;
        this.f16236h = null;
        this.i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, null);
    }

    private Animation getClickRotateAnimation() {
        if (this.f16236h == null) {
            this.f16236h = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
            this.f16236h.setInterpolator(new LinearInterpolator());
            this.f16236h.setFillAfter(true);
        }
        return this.f16236h;
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
            this.f16233e = new View(context);
            this.f16233e.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) context.getResources().getDimension(R.dimen.ds1)));
            SkinManager.setBackgroundResource(this.f16233e, R.color.CAM_X0204);
            addView(this.f16233e);
        }
        this.f16234f = new TbImageView(context);
        int g2 = l.g(getContext(), R.dimen.ds48);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
        layoutParams.topMargin = l.g(getContext(), R.dimen.ds20);
        this.f16234f.setLayoutParams(layoutParams);
        SkinManager.setImageResource(this.f16234f, this.i);
        addView(this.f16234f);
    }

    public void b(int i) {
        if (this.f16235g != i) {
            SkinManager.setBackgroundResource(this.f16233e, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f16234f, this.i);
            SkinManager.setBackgroundResource(this, R.color.cp_bg_line_d_alpha98);
            this.f16235g = i;
        }
    }

    public void setIconResource(int i) {
        this.i = i;
        SkinManager.setImageResource(this.f16234f, i);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16235g = 3;
        this.f16236h = null;
        this.i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, attributeSet);
    }

    public EntelechyPullUpRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16235g = 3;
        this.f16236h = null;
        this.i = R.drawable.icon_frs_reload;
        this.j = false;
        a(context, attributeSet);
    }
}
