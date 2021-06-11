package com.baidu.tieba.frs.vc;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.r0.r2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsFoldingView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f15783e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15784f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout.LayoutParams f15785g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f15786h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f15787i;
    public FrameLayout j;
    public ImageView k;
    public View l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFoldingView.this.f15784f) {
                FrsFoldingView.this.n();
                FrsFoldingView.this.f15784f = false;
                return;
            }
            FrsFoldingView.this.m();
            FrsFoldingView.this.f15784f = true;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f15789e;

        public b(ValueAnimator valueAnimator) {
            this.f15789e = valueAnimator;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) this.f15789e.getAnimatedValue()).floatValue();
            FrsFoldingView.this.f15785g.height = (int) (FrsFoldingView.this.f15783e * floatValue);
            FrsFoldingView.this.j.setLayoutParams(FrsFoldingView.this.f15785g);
            FrsFoldingView.this.j.setAlpha(floatValue);
            FrsFoldingView.this.k.setRotation((-floatValue) * 180.0f);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f15791e;

        public c(ValueAnimator valueAnimator) {
            this.f15791e = valueAnimator;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) this.f15791e.getAnimatedValue()).floatValue();
            FrsFoldingView.this.f15785g.height = (int) (FrsFoldingView.this.f15783e * floatValue);
            FrsFoldingView.this.j.setLayoutParams(FrsFoldingView.this.f15785g);
            FrsFoldingView.this.j.setAlpha(floatValue);
            FrsFoldingView.this.k.setRotation((-floatValue) * 180.0f);
        }
    }

    public FrsFoldingView(Context context) {
        this(context, null);
    }

    public final void i() {
        j();
        l();
    }

    public final void j() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.folding_view_layout, (ViewGroup) this, true);
        this.l = inflate;
        this.f15786h = (LinearLayout) inflate.findViewById(R.id.folding_root_layout);
        this.f15787i = (FrameLayout) this.l.findViewById(R.id.permanent_layout);
        this.j = (FrameLayout) this.l.findViewById(R.id.collapsible_layout);
        this.k = (ImageView) this.l.findViewById(R.id.folding_arrow);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void k() {
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public final void l() {
        this.l.findViewById(R.id.folding_arrow).setOnClickListener(new a());
    }

    public final void m() {
        this.f15785g = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new c(ofFloat));
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public final void n() {
        this.f15785g = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b(ofFloat));
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<e> list2) {
        this.f15787i.removeAllViews();
        this.f15787i.addView(list.get(0));
        if (list.size() > 1) {
            this.k.setVisibility(0);
            this.j.removeAllViews();
            this.j.addView(list.get(1));
            this.f15783e = list2.get(1).getCount() * l.g(getContext().getApplicationContext(), R.dimen.tbds93);
            return;
        }
        this.k.setVisibility(8);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f15783e = 0;
        this.f15784f = true;
        i();
    }
}
