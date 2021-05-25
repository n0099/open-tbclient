package com.baidu.tbadk.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class RightFloatLayerView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f13002e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f13003f;

    /* renamed from: g  reason: collision with root package name */
    public AlphaAnimation f13004g;

    /* renamed from: h  reason: collision with root package name */
    public AlphaAnimation f13005h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f13006i;
    public ValueAnimator j;
    public ValueAnimator k;
    public ValueAnimator l;
    public ValueAnimator m;
    public ValueAnimator n;
    public ValueAnimator o;
    public ValueAnimator p;
    public AnimatorSet q;
    public AnimatorSet r;
    public boolean s;
    public boolean t;
    public Runnable u;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RightFloatLayerView.this.f13003f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RightFloatLayerView.this.f13002e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RightFloatLayerView.this.f13003f.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RightFloatLayerView.this.i();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RightFloatLayerView.this.f13003f.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RightFloatLayerView.this.f13003f.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes3.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        public g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RightFloatLayerView.this.f13002e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes3.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RightFloatLayerView.this.f13003f.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes3.dex */
    public class i extends AnimatorListenerAdapter {
        public i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            RightFloatLayerView.this.s = true;
        }
    }

    /* loaded from: classes3.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {
        public j() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RightFloatLayerView.this.f13003f.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes3.dex */
    public class k extends AnimatorListenerAdapter {
        public k() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            RightFloatLayerView.this.s = false;
            if (RightFloatLayerView.this.t) {
                RightFloatLayerView.this.h();
                RightFloatLayerView.this.t = false;
            }
        }
    }

    public RightFloatLayerView(Context context) {
        this(context, null, 0);
    }

    public void f() {
        if (getVisibility() != 0) {
            return;
        }
        AlphaAnimation alphaAnimation = this.f13004g;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        this.f13004g = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.f13004g.setFillAfter(true);
        startAnimation(this.f13004g);
        setClickable(false);
        setVisibility(8);
    }

    public void g() {
        if (getVisibility() == 0) {
            return;
        }
        AlphaAnimation alphaAnimation = this.f13005h;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        this.f13005h = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.f13005h.setFillAfter(true);
        startAnimation(this.f13005h);
        setClickable(true);
        setVisibility(0);
    }

    public void h() {
        if (getVisibility() != 0 || this.s) {
            return;
        }
        if (this.f13006i == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, -45.0f);
            this.f13006i = ofFloat;
            ofFloat.setDuration(400L);
            this.f13006i.addUpdateListener(new e());
        }
        if (this.j == null) {
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.5f);
            this.j = ofFloat2;
            ofFloat2.setDuration(450L);
            this.j.addUpdateListener(new f());
        }
        if (this.k == null) {
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.k = ofFloat3;
            ofFloat3.setDuration(450L);
            this.k.addUpdateListener(new g());
        }
        if (this.l == null) {
            ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 101.0f);
            this.l = ofFloat4;
            ofFloat4.setDuration(400L);
            this.l.addUpdateListener(new h());
            this.l.addListener(new i());
        }
        if (this.q == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.q = animatorSet;
            animatorSet.play(this.f13006i).with(this.j).with(this.k).before(this.l);
        }
        this.q.start();
        setClickable(false);
    }

    public void i() {
        if (getVisibility() == 0 && this.s) {
            if (this.m == null) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(-45.0f, 6.0f, -4.0f, 0.0f);
                this.m = ofFloat;
                ofFloat.setDuration(700L);
                this.m.addUpdateListener(new j());
                this.m.addListener(new k());
            }
            if (this.n == null) {
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.5f, 1.0f);
                this.n = ofFloat2;
                ofFloat2.setDuration(450L);
                this.n.addUpdateListener(new a());
            }
            if (this.o == null) {
                ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.o = ofFloat3;
                ofFloat3.setDuration(450L);
                this.o.addUpdateListener(new b());
            }
            if (this.p == null) {
                ValueAnimator ofFloat4 = ValueAnimator.ofFloat(101.0f, 0.0f);
                this.p = ofFloat4;
                ofFloat4.setDuration(400L);
                this.p.addUpdateListener(new c());
            }
            if (this.r == null) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.r = animatorSet;
                animatorSet.play(this.m).after(this.p).with(this.o).with(this.n);
            }
            this.r.start();
            setClickable(false);
        }
    }

    public void j() {
        d.a.m0.r.d0.b.j().w("key_tab_right_float_layer_view", System.currentTimeMillis());
    }

    public void k() {
        d.a.m0.r.d0.b.j().w("key_pb_right_float_layer_view", System.currentTimeMillis());
    }

    public final void l(Context context) {
        LayoutInflater.from(context).inflate(R.layout.new_float_view, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.float_layer_feedback_picture);
        this.f13002e = imageView;
        SkinManager.setImageResource(imageView, R.drawable.ic_icon_popup_close_n);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.float_layer_logo_picture);
        this.f13003f = tbImageView;
        tbImageView.setAutoChangeStyle(true);
    }

    public boolean m() {
        return !StringHelper.isTaday(d.a.m0.r.d0.b.j().l("key_tab_right_float_layer_view", 0L)) && TbSingleton.getInstance().isShowRightFloatView(0);
    }

    public boolean n() {
        return !StringHelper.isTaday(d.a.m0.r.d0.b.j().l("key_pb_right_float_layer_view", 0L)) && TbSingleton.getInstance().isShowRightFloatView(1);
    }

    public void o() {
        this.f13003f.invalidate();
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f13002e, R.drawable.ic_icon_popup_close_n, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void p() {
        this.t = true;
        h();
        removeCallbacks(this.u);
    }

    public void q() {
        this.t = false;
        postDelayed(this.u, 1600L);
    }

    public void r() {
        this.s = true;
        removeCallbacks(this.u);
    }

    @Override // android.view.View
    public void setAlpha(float f2) {
    }

    public void setData(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        this.f13003f.V(str, 45, false);
    }

    public void setFeedBackListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f13002e;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setLogoListener(View.OnClickListener onClickListener) {
        TbImageView tbImageView = this.f13003f;
        if (tbImageView != null) {
            tbImageView.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    public void setRotation(float f2) {
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
    }

    public RightFloatLayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RightFloatLayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13004g = null;
        this.f13005h = null;
        this.s = false;
        this.t = false;
        this.u = new d();
        l(context);
    }
}
