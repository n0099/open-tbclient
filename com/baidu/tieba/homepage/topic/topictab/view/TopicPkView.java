package com.baidu.tieba.homepage.topic.topictab.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.message.RequestBlessMessage;
import d.a.c.e.p.l;
import d.a.n0.b1.j.b.c.b;
/* loaded from: classes4.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public Paint L;
    public int M;
    public ValueAnimator N;
    public View O;
    public e P;
    public ValueAnimator Q;
    public double R;
    public double S;
    public float T;
    public float U;
    public RelativeLayout.LayoutParams V;
    public RelativeLayout.LayoutParams W;
    public Runnable a0;
    public f b0;
    public ValueAnimator.AnimatorUpdateListener c0;

    /* renamed from: e  reason: collision with root package name */
    public int f16632e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.b1.j.b.c.b f16633f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16634g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16635h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f16636i;
    public FrameLayout j;
    public TbImageView k;
    public TbImageView l;
    public TbImageView m;
    public TbImageView n;
    public TextView o;
    public TextView p;
    public ImageView q;
    public TextView r;
    public TextView s;
    public ImageView t;
    public ImageView u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TopicPkView.this.requestLayout();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TopicPkView.this.O.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            TopicPkView.this.O.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue < 1.0f) {
                float f2 = 1.0f - floatValue;
                double d2 = f2;
                float f3 = 2.0f * floatValue * f2;
                double pow = (Math.pow(d2, 2.0d) * TopicPkView.this.R) + ((TopicPkView.this.x - 45) * f3);
                double d3 = floatValue;
                double pow2 = (Math.pow(d2, 2.0d) * TopicPkView.this.S) + (f3 * 70.0f) + (Math.pow(d3, 2.0d) * 60.0d);
                TopicPkView.this.t.setX((float) (pow + (Math.pow(d3, 2.0d) * (TopicPkView.this.f16636i.getX() + (TopicPkView.this.x / 2)))));
                TopicPkView.this.t.setY((float) pow2);
            } else {
                floatValue -= 1.0f;
                float f4 = 1.0f - floatValue;
                double d4 = f4;
                float f5 = 2.0f * floatValue * f4;
                double pow3 = (Math.pow(d4, 2.0d) * (TopicPkView.this.f16636i.getX() + (TopicPkView.this.x / 2))) + (45.0f * f5);
                double d5 = floatValue;
                double pow4 = (Math.pow(d4, 2.0d) * 60.0d) + (f5 * 50.0f) + (Math.pow(d5, 2.0d) * 40.0d);
                TopicPkView.this.t.setX((float) (pow3 + (Math.pow(d5, 2.0d) * (TopicPkView.this.f16636i.getX() + (TopicPkView.this.x / 2)))));
                TopicPkView.this.t.setY((float) pow4);
            }
            if (floatValue == 1.0f) {
                TopicPkView.this.t.setVisibility(4);
                TopicPkView.this.t.setX(TopicPkView.this.T);
                TopicPkView.this.t.setY(TopicPkView.this.U);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue < 1.0f) {
                float f2 = 1.0f - floatValue;
                double d2 = f2;
                float f3 = 2.0f * floatValue * f2;
                double pow = (Math.pow(d2, 2.0d) * TopicPkView.this.R) + (((TopicPkView.this.v - TopicPkView.this.x) + 45) * f3);
                double d3 = floatValue;
                double pow2 = (Math.pow(d2, 2.0d) * TopicPkView.this.S) + (f3 * 70.0f) + (Math.pow(d3, 2.0d) * 60.0d);
                TopicPkView.this.u.setX((float) (pow + (Math.pow(d3, 2.0d) * (TopicPkView.this.v - (TopicPkView.this.x / 2)))));
                TopicPkView.this.u.setY((float) pow2);
            } else {
                floatValue -= 1.0f;
                float f4 = 1.0f - floatValue;
                double d4 = f4;
                float f5 = 2.0f * floatValue * f4;
                double pow3 = (Math.pow(d4, 2.0d) * (TopicPkView.this.v - (TopicPkView.this.x / 2))) + ((TopicPkView.this.v - 45) * f5);
                double d5 = floatValue;
                double pow4 = (Math.pow(d4, 2.0d) * 60.0d) + (f5 * 50.0f) + (Math.pow(d5, 2.0d) * 40.0d);
                TopicPkView.this.u.setX((float) (pow3 + (Math.pow(d5, 2.0d) * (TopicPkView.this.v - 120))));
                TopicPkView.this.u.setY((float) pow4);
            }
            if (floatValue == 1.0f) {
                TopicPkView.this.u.setVisibility(4);
                TopicPkView.this.u.setX(TopicPkView.this.T);
                TopicPkView.this.u.setY(TopicPkView.this.U);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public View f16641e;

        /* renamed from: f  reason: collision with root package name */
        public View f16642f;

        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = this.f16642f;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view = this.f16641e;
            if (view != null) {
                view.setVisibility(0);
            }
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(int i2);
    }

    public TopicPkView(Context context) {
        super(context);
        this.f16632e = 3;
        this.M = R.color.CAM_X0101;
        this.a0 = new a();
        this.c0 = new c();
        p(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f16633f == null) {
            return;
        }
        m(canvas);
        super.dispatchDraw(canvas);
    }

    public final void k(boolean z) {
        if (z) {
            this.f16634g.setVisibility(0);
            this.f16634g.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.f16633f.f51987d.f51992c = TbadkCoreApplication.getCurrentAccountNameShow();
            b.a aVar = this.f16633f.f51987d;
            aVar.f51994e = true;
            TextView textView = this.o;
            long j = aVar.f51990a + 1;
            aVar.f51990a = j;
            textView.setText(String.valueOf(j));
            this.t.setVisibility(0);
            TbImageView tbImageView = this.m;
            this.O = tbImageView;
            this.P.f16641e = tbImageView;
            this.P.f16642f = this.k;
            this.t.setVisibility(0);
            this.N.start();
            this.R = this.t.getX();
            this.S = this.t.getY();
            this.T = this.t.getX();
            this.U = this.t.getY();
            this.Q.removeAllUpdateListeners();
            this.Q.addUpdateListener(this.c0);
            this.Q.setFloatValues(0.0f, 2.0f);
            this.Q.start();
            return;
        }
        if (StringHelper.equals(this.f16633f.f51987d.f51992c, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.f16634g.setVisibility(4);
        }
        b.a aVar2 = this.f16633f.f51987d;
        if (aVar2.f51994e) {
            aVar2.f51994e = false;
            TextView textView2 = this.o;
            long j2 = aVar2.f51990a - 1;
            aVar2.f51990a = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.k.setVisibility(0);
        this.m.setVisibility(4);
    }

    public final void l(boolean z) {
        if (z) {
            this.f16635h.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.f16635h.setVisibility(0);
            this.f16633f.f51988e.f51992c = TbadkCoreApplication.getCurrentAccountNameShow();
            this.u.setVisibility(0);
            b.a aVar = this.f16633f.f51988e;
            aVar.f51994e = true;
            TextView textView = this.p;
            long j = aVar.f51990a + 1;
            aVar.f51990a = j;
            textView.setText(String.valueOf(j));
            this.R = this.u.getX() - (this.K / 2.0f);
            TbImageView tbImageView = this.n;
            this.O = tbImageView;
            this.P.f16641e = tbImageView;
            this.P.f16642f = this.l;
            this.t.setVisibility(0);
            this.N.start();
            this.R = this.u.getX() - (this.K / 2);
            this.S = this.u.getY();
            this.T = this.u.getX();
            this.U = this.u.getY();
            this.Q.removeAllUpdateListeners();
            this.Q.addUpdateListener(new d());
            this.Q.setFloatValues(0.0f, 2.0f);
            this.Q.start();
            return;
        }
        if (StringHelper.equals(this.f16633f.f51988e.f51992c, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.f16635h.setVisibility(4);
        }
        b.a aVar2 = this.f16633f.f51988e;
        if (aVar2.f51994e) {
            aVar2.f51994e = false;
            TextView textView2 = this.p;
            long j2 = aVar2.f51990a - 1;
            aVar2.f51990a = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.u.setVisibility(4);
        this.l.setVisibility(0);
        this.n.setVisibility(4);
    }

    public final void m(Canvas canvas) {
        float y = this.f16636i.getY() + ((this.y - this.I) / 2);
        this.L.setShader(new LinearGradient(this.x / 2, y, this.J, y, SkinManager.getColor(R.color.topic_pk_agree_bar_start_color), SkinManager.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.x / 2, y, this.J, y + this.I, this.L);
        this.L.setShader(new LinearGradient(this.J, y, this.v - (this.x / 2), y, SkinManager.getColor(R.color.topic_pk_disagree_bar_start_color), SkinManager.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.J, y, this.v - (this.x / 2), y + this.I, this.L);
    }

    public final boolean n() {
        b.a aVar;
        d.a.n0.b1.j.b.c.b bVar = this.f16633f;
        return (bVar == null || (aVar = bVar.f51987d) == null || !aVar.f51994e) ? false : true;
    }

    public final boolean o() {
        b.a aVar;
        d.a.n0.b1.j.b.c.b bVar = this.f16633f;
        return (bVar == null || (aVar = bVar.f51988e) == null || !aVar.f51994e) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.f16633f.f51989f != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
            return;
        }
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator valueAnimator2 = this.Q;
            if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
                int i3 = 2;
                if (this.Q == null) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.Q = ofFloat;
                    ofFloat.setDuration(800L);
                    this.Q.setInterpolator(new AccelerateInterpolator());
                }
                if (this.N == null) {
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.N = ofFloat2;
                    ofFloat2.setDuration(800L);
                    this.N.setInterpolator(new AccelerateInterpolator());
                    e eVar = new e(null);
                    this.P = eVar;
                    this.N.addListener(eVar);
                    this.N.addUpdateListener(new b());
                }
                if (n()) {
                    i2 = 1;
                } else {
                    i2 = o() ? 2 : 0;
                }
                if (view == this.f16636i) {
                    k(1 != i2);
                    l(false);
                    i3 = 1;
                } else if (view == this.j) {
                    l(2 != i2);
                    k(false);
                } else {
                    i3 = 0;
                }
                TiebaStatic.log(new StatisticItem("c13352").param("obj_type", i3).param("topic_id", this.f16633f.f51984a).param("obj_source", this.f16633f.f51989f));
                f fVar = this.b0;
                if (fVar != null) {
                    fVar.a(i3 == i2 ? 0 : i3);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.f16633f.f51985b));
                requestBlessMessage.setTopicId(Long.valueOf(this.f16633f.f51984a));
                requestBlessMessage.setPkIndex(i3);
                requestBlessMessage.setClickType(i2 == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.f16633f.f51986c);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.Q;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        removeCallbacks(this.a0);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f16633f == null) {
            return;
        }
        this.x = this.f16636i.getWidth();
        this.y = this.f16636i.getHeight();
        this.z = this.k.getWidth();
        this.A = this.o.getWidth();
        this.B = this.p.getWidth();
        this.E = this.o.getHeight();
        this.C = this.r.getWidth();
        this.D = this.s.getWidth();
        this.F = this.q.getWidth();
        this.G = this.q.getHeight();
        this.H = ((this.v - (this.x * 2)) - this.A) - this.B;
        this.K = this.t.getWidth();
        d.a.n0.b1.j.b.c.b bVar = this.f16633f;
        if (bVar.f51987d.f51990a == 0 && bVar.f51988e.f51990a == 0) {
            this.J = (int) ((this.H * 0.5d) + this.A + this.x);
        } else {
            d.a.n0.b1.j.b.c.b bVar2 = this.f16633f;
            long j = bVar2.f51987d.f51990a;
            this.J = (int) (((((float) j) / ((float) (j + bVar2.f51988e.f51990a))) * this.H) + this.A + this.x);
        }
        float y = this.f16636i.getY() - ((this.G - this.y) / 2);
        if (this.J + (this.F / 2) >= this.p.getLeft()) {
            this.J = (this.p.getLeft() - 10) - (this.F / 2);
            int i6 = (int) y;
            this.q.layout((this.p.getLeft() - 10) - this.F, i6, this.p.getLeft() - 10, this.G + i6);
        } else if (this.J - (this.F / 2) <= this.o.getRight()) {
            this.J = this.o.getRight() + 10 + (this.F / 2);
            int i7 = (int) y;
            this.q.layout(this.o.getRight() + 10, i7, this.o.getRight() + 10 + this.F, this.G + i7);
        } else {
            ImageView imageView = this.q;
            int i8 = this.J;
            int i9 = this.F;
            int i10 = (int) y;
            imageView.layout(i8 - (i9 / 2), i10, i8 + (i9 / 2), this.G + i10);
        }
        int x = (this.v / 2) - ((int) this.k.getX());
        int i11 = this.C;
        if (i11 < this.z) {
            int i12 = (this.x - i11) / 2;
            TextView textView = this.r;
            textView.layout(i12, (int) textView.getY(), this.C + i12, ((int) this.r.getY()) + this.E);
        } else if (i11 <= x) {
            this.r.layout((int) this.k.getX(), (int) this.r.getY(), ((int) this.k.getX()) + this.C, ((int) this.r.getY()) + this.E);
        } else {
            ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
            layoutParams.width = x;
            this.r.setLayoutParams(layoutParams);
            postDelayed(this.a0, 300L);
        }
        int i13 = this.D;
        if (i13 < this.z) {
            int x2 = ((int) this.j.getX()) + ((this.x - this.D) / 2);
            TextView textView2 = this.s;
            textView2.layout(x2, (int) textView2.getY(), this.D + x2, ((int) this.s.getY()) + this.E);
        } else if (i13 <= x) {
            this.s.layout((this.v - ((int) this.l.getX())) - this.D, (int) this.s.getY(), this.v - ((int) this.l.getX()), ((int) this.s.getY()) + this.E);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.s.getLayoutParams();
            layoutParams2.width = x;
            this.s.setLayoutParams(layoutParams2);
            postDelayed(this.a0, 300L);
        }
        int i14 = (this.x - this.K) / 2;
        this.t.layout(((int) this.f16636i.getX()) + i14, ((int) this.f16636i.getY()) + i14, ((int) this.f16636i.getX()) + i14 + this.K, ((int) this.f16636i.getY()) + i14 + this.K);
        this.u.layout(((int) this.j.getX()) + i14, ((int) this.j.getY()) + i14, ((int) this.j.getX()) + i14 + this.K, ((int) this.j.getY()) + i14 + this.K);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        this.v = size;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(this.w, 1073741824));
    }

    public final void p(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.f16634g = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.f16635h = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.f16636i = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.j = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.k = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.l = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.m = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.n = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.o = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.p = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.q = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.r = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.s = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.t = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.u = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.k.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.l.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.m.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.n.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.f16636i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.w = l.g(context, R.dimen.tbds340);
        this.I = l.g(context, R.dimen.tbds62);
        Paint paint = new Paint();
        this.L = paint;
        paint.setAntiAlias(true);
        this.L.setDither(true);
        this.L.setFilterBitmap(true);
        q();
    }

    public void q() {
        SkinManager.setViewTextColor(this.f16634g, this.M);
        SkinManager.setViewTextColor(this.f16635h, this.M);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f16632e) {
            return;
        }
        this.f16632e = skinType;
        this.k.setIsNight(skinType == 1);
        this.l.setIsNight(this.f16632e == 1);
        this.m.setIsNight(this.f16632e == 1);
        this.n.setIsNight(this.f16632e == 1);
        SkinManager.setBackgroundResource(this.f16636i, R.drawable.btn_topic_agree_bg_red);
        SkinManager.setBackgroundResource(this.j, R.drawable.btn_topic_disagree_bg_blue);
        SkinManager.setImageResource(this.t, R.drawable.pic_topic_addone);
        SkinManager.setImageResource(this.u, R.drawable.pic_topic_addone);
        SkinManager.setImageResource(this.q, R.drawable.pic_topic_vs_bginone);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.r, R.color.topic_agree_des_color);
        SkinManager.setViewTextColor(this.s, R.color.topic_disagree_des_color);
    }

    public void setData(d.a.n0.b1.j.b.c.b bVar) {
        if (bVar != null && bVar.f51987d != null && bVar.f51988e != null) {
            setVisibility(0);
            this.f16633f = bVar;
            this.o.setText(String.valueOf(bVar.f51987d.f51990a));
            this.p.setText(String.valueOf(bVar.f51988e.f51990a));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            this.V = layoutParams;
            layoutParams.addRule(12);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            this.W = layoutParams2;
            layoutParams2.addRule(12);
            this.W.addRule(11);
            this.r.setLayoutParams(this.V);
            this.s.setLayoutParams(this.W);
            if (bVar.f51989f == 3) {
                this.r.setText(StringUtils.isNull(bVar.f51987d.f51991b) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.f51987d.f51991b);
                this.s.setText(StringUtils.isNull(bVar.f51988e.f51991b) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.f51988e.f51991b);
                if (StringUtils.isNull(bVar.f51987d.f51992c)) {
                    this.f16634g.setVisibility(4);
                } else {
                    this.f16634g.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.f51987d.f51992c));
                }
                if (StringUtils.isNull(bVar.f51988e.f51992c)) {
                    this.f16635h.setVisibility(4);
                } else {
                    this.f16635h.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.f51988e.f51992c));
                }
            } else {
                this.r.setText(bVar.f51987d.f51991b);
                this.s.setText(bVar.f51988e.f51991b);
                this.f16634g.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.f51987d.f51992c));
                this.f16635h.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.f51988e.f51992c));
            }
            this.k.V(bVar.f51987d.f51993d, 10, false);
            this.l.V(bVar.f51988e.f51993d, 10, false);
            this.m.V(bVar.f51987d.f51996g, 10, false);
            this.n.V(bVar.f51988e.f51996g, 10, false);
            if (bVar.f51987d.f51994e) {
                this.k.setVisibility(4);
                this.m.setVisibility(0);
            } else {
                this.k.setVisibility(0);
                this.m.setVisibility(4);
            }
            if (bVar.f51988e.f51994e) {
                this.l.setVisibility(4);
                this.n.setVisibility(0);
            } else {
                this.l.setVisibility(0);
                this.n.setVisibility(4);
            }
            invalidate();
            return;
        }
        setVisibility(8);
    }

    public void setPkClickListener(f fVar) {
        if (fVar != null) {
            this.b0 = fVar;
        }
    }

    public void setUserColor(int i2) {
        this.M = i2;
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16632e = 3;
        this.M = R.color.CAM_X0101;
        this.a0 = new a();
        this.c0 = new c();
        p(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16632e = 3;
        this.M = R.color.CAM_X0101;
        this.a0 = new a();
        this.c0 = new c();
        p(context);
    }
}
