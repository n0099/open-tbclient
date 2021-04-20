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
import d.b.c.e.p.l;
import d.b.i0.q0.r2.e;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsFoldingView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f16277e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16278f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout.LayoutParams f16279g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16280h;
    public FrameLayout i;
    public FrameLayout j;
    public ImageView k;
    public View l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FrsFoldingView.this.f16278f) {
                FrsFoldingView.this.n();
                FrsFoldingView.this.f16278f = false;
                return;
            }
            FrsFoldingView.this.m();
            FrsFoldingView.this.f16278f = true;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f16282e;

        public b(ValueAnimator valueAnimator) {
            this.f16282e = valueAnimator;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) this.f16282e.getAnimatedValue()).floatValue();
            FrsFoldingView.this.f16279g.height = (int) (FrsFoldingView.this.f16277e * floatValue);
            FrsFoldingView.this.j.setLayoutParams(FrsFoldingView.this.f16279g);
            FrsFoldingView.this.j.setAlpha(floatValue);
            FrsFoldingView.this.k.setRotation((-floatValue) * 180.0f);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f16284e;

        public c(ValueAnimator valueAnimator) {
            this.f16284e = valueAnimator;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) this.f16284e.getAnimatedValue()).floatValue();
            FrsFoldingView.this.f16279g.height = (int) (FrsFoldingView.this.f16277e * floatValue);
            FrsFoldingView.this.j.setLayoutParams(FrsFoldingView.this.f16279g);
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
        this.f16280h = (LinearLayout) inflate.findViewById(R.id.folding_root_layout);
        this.i = (FrameLayout) this.l.findViewById(R.id.permanent_layout);
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
        this.f16279g = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new c(ofFloat));
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public final void n() {
        this.f16279g = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b(ofFloat));
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public void setViews(List<View> list, List<e> list2) {
        this.i.removeAllViews();
        this.i.addView(list.get(0));
        if (list.size() > 1) {
            this.k.setVisibility(0);
            this.j.removeAllViews();
            this.j.addView(list.get(1));
            this.f16277e = list2.get(1).getCount() * l.g(getContext().getApplicationContext(), R.dimen.tbds93);
            return;
        }
        this.k.setVisibility(8);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsFoldingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16277e = 0;
        this.f16278f = true;
        i();
    }
}
