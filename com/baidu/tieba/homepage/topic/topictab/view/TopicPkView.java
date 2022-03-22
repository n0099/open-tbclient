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
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.q1.l.c.c.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public Paint H;
    public int I;
    public ValueAnimator J;
    public View K;
    public e L;
    public ValueAnimator M;
    public double N;
    public double O;
    public float P;
    public float Q;
    public RelativeLayout.LayoutParams R;
    public RelativeLayout.LayoutParams S;
    public Runnable T;
    public f U;
    public ValueAnimator.AnimatorUpdateListener V;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.q1.l.c.c.b f33573b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33574c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33575d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f33576e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f33577f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f33578g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f33579h;
    public TbImageView i;
    public TbImageView j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public TextView n;
    public TextView o;
    public ImageView p;
    public ImageView q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicPkView a;

        public a(TopicPkView topicPkView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicPkView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicPkView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicPkView a;

        public b(TopicPkView topicPkView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicPkView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicPkView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.K.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.K.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicPkView a;

        public c(TopicPkView topicPkView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicPkView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicPkView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    float f2 = 1.0f - floatValue;
                    double d2 = f2;
                    float f3 = 2.0f * floatValue * f2;
                    double pow = (Math.pow(d2, 2.0d) * this.a.N) + ((this.a.t - 45) * f3);
                    double d3 = floatValue;
                    double pow2 = (Math.pow(d2, 2.0d) * this.a.O) + (f3 * 70.0f) + (Math.pow(d3, 2.0d) * 60.0d);
                    this.a.p.setX((float) (pow + (Math.pow(d3, 2.0d) * (this.a.f33576e.getX() + (this.a.t / 2)))));
                    this.a.p.setY((float) pow2);
                } else {
                    floatValue -= 1.0f;
                    float f4 = 1.0f - floatValue;
                    double d4 = f4;
                    float f5 = 2.0f * floatValue * f4;
                    double pow3 = (Math.pow(d4, 2.0d) * (this.a.f33576e.getX() + (this.a.t / 2))) + (45.0f * f5);
                    double d5 = floatValue;
                    double pow4 = (Math.pow(d4, 2.0d) * 60.0d) + (f5 * 50.0f) + (Math.pow(d5, 2.0d) * 40.0d);
                    this.a.p.setX((float) (pow3 + (Math.pow(d5, 2.0d) * (this.a.f33576e.getX() + (this.a.t / 2)))));
                    this.a.p.setY((float) pow4);
                }
                if (floatValue == 1.0f) {
                    this.a.p.setVisibility(4);
                    this.a.p.setX(this.a.P);
                    this.a.p.setY(this.a.Q);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicPkView a;

        public d(TopicPkView topicPkView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicPkView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicPkView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    float f2 = 1.0f - floatValue;
                    double d2 = f2;
                    float f3 = 2.0f * floatValue * f2;
                    double pow = (Math.pow(d2, 2.0d) * this.a.N) + (((this.a.r - this.a.t) + 45) * f3);
                    double d3 = floatValue;
                    double pow2 = (Math.pow(d2, 2.0d) * this.a.O) + (f3 * 70.0f) + (Math.pow(d3, 2.0d) * 60.0d);
                    this.a.q.setX((float) (pow + (Math.pow(d3, 2.0d) * (this.a.r - (this.a.t / 2)))));
                    this.a.q.setY((float) pow2);
                } else {
                    floatValue -= 1.0f;
                    float f4 = 1.0f - floatValue;
                    double d4 = f4;
                    float f5 = 2.0f * floatValue * f4;
                    double pow3 = (Math.pow(d4, 2.0d) * (this.a.r - (this.a.t / 2))) + ((this.a.r - 45) * f5);
                    double d5 = floatValue;
                    double pow4 = (Math.pow(d4, 2.0d) * 60.0d) + (f5 * 50.0f) + (Math.pow(d5, 2.0d) * 40.0d);
                    this.a.q.setX((float) (pow3 + (Math.pow(d5, 2.0d) * (this.a.r - 120))));
                    this.a.q.setY((float) pow4);
                }
                if (floatValue == 1.0f) {
                    this.a.q.setVisibility(4);
                    this.a.q.setX(this.a.P);
                    this.a.q.setY(this.a.Q);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public View f33580b;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || (view = this.f33580b) == null) {
                return;
            }
            view.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || (view = this.a) == null) {
                return;
            }
            view.setVisibility(0);
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicPkView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.I = R.color.CAM_X0101;
        this.T = new a(this);
        this.V = new c(this);
        p(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || this.f33573b == null) {
            return;
        }
        m(canvas);
        super.dispatchDraw(canvas);
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.f33574c.setVisibility(0);
                this.f33574c.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f140a), TbadkCoreApplication.getCurrentAccountNameShow()));
                this.f33573b.f17591d.f17595c = TbadkCoreApplication.getCurrentAccountNameShow();
                b.a aVar = this.f33573b.f17591d;
                aVar.f17597e = true;
                TextView textView = this.k;
                long j = aVar.a + 1;
                aVar.a = j;
                textView.setText(String.valueOf(j));
                this.p.setVisibility(0);
                TbImageView tbImageView = this.i;
                this.K = tbImageView;
                this.L.a = tbImageView;
                this.L.f33580b = this.f33578g;
                this.p.setVisibility(0);
                this.J.start();
                this.N = this.p.getX();
                this.O = this.p.getY();
                this.P = this.p.getX();
                this.Q = this.p.getY();
                this.M.removeAllUpdateListeners();
                this.M.addUpdateListener(this.V);
                this.M.setFloatValues(0.0f, 2.0f);
                this.M.start();
                return;
            }
            if (StringHelper.equals(this.f33573b.f17591d.f17595c, TbadkCoreApplication.getCurrentAccountNameShow())) {
                this.f33574c.setVisibility(4);
            }
            b.a aVar2 = this.f33573b.f17591d;
            if (aVar2.f17597e) {
                aVar2.f17597e = false;
                TextView textView2 = this.k;
                long j2 = aVar2.a - 1;
                aVar2.a = j2;
                textView2.setText(String.valueOf(j2));
            }
            this.f33578g.setVisibility(0);
            this.i.setVisibility(4);
        }
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.f33575d.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f140a), TbadkCoreApplication.getCurrentAccountNameShow()));
                this.f33575d.setVisibility(0);
                this.f33573b.f17592e.f17595c = TbadkCoreApplication.getCurrentAccountNameShow();
                this.q.setVisibility(0);
                b.a aVar = this.f33573b.f17592e;
                aVar.f17597e = true;
                TextView textView = this.l;
                long j = aVar.a + 1;
                aVar.a = j;
                textView.setText(String.valueOf(j));
                this.N = this.q.getX() - (this.G / 2.0f);
                TbImageView tbImageView = this.j;
                this.K = tbImageView;
                this.L.a = tbImageView;
                this.L.f33580b = this.f33579h;
                this.p.setVisibility(0);
                this.J.start();
                this.N = this.q.getX() - (this.G / 2);
                this.O = this.q.getY();
                this.P = this.q.getX();
                this.Q = this.q.getY();
                this.M.removeAllUpdateListeners();
                this.M.addUpdateListener(new d(this));
                this.M.setFloatValues(0.0f, 2.0f);
                this.M.start();
                return;
            }
            if (StringHelper.equals(this.f33573b.f17592e.f17595c, TbadkCoreApplication.getCurrentAccountNameShow())) {
                this.f33575d.setVisibility(4);
            }
            b.a aVar2 = this.f33573b.f17592e;
            if (aVar2.f17597e) {
                aVar2.f17597e = false;
                TextView textView2 = this.l;
                long j2 = aVar2.a - 1;
                aVar2.a = j2;
                textView2.setText(String.valueOf(j2));
            }
            this.q.setVisibility(4);
            this.f33579h.setVisibility(0);
            this.j.setVisibility(4);
        }
    }

    public final void m(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            float y = this.f33576e.getY() + ((this.u - this.E) / 2);
            this.H.setShader(new LinearGradient(this.t / 2, y, this.F, y, SkinManager.getColor(R.color.topic_pk_agree_bar_start_color), SkinManager.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
            canvas.drawRect(this.t / 2, y, this.F, y + this.E, this.H);
            this.H.setShader(new LinearGradient(this.F, y, this.r - (this.t / 2), y, SkinManager.getColor(R.color.topic_pk_disagree_bar_start_color), SkinManager.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
            canvas.drawRect(this.F, y, this.r - (this.t / 2), y + this.E, this.H);
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.p0.q1.l.c.c.b bVar = this.f33573b;
            return (bVar == null || (aVar = bVar.f17591d) == null || !aVar.f17597e) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.p0.q1.l.c.c.b bVar = this.f33573b;
            return (bVar == null || (aVar = bVar.f17592e) == null || !aVar.f17597e) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
                loginActivityConfig.getIntent().putExtra("locate_type", this.f33573b.f17593f != 3 ? 16 : 0);
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
                return;
            }
            ValueAnimator valueAnimator = this.J;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.M;
                if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
                    int i2 = 2;
                    if (this.M == null) {
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 2.0f);
                        this.M = ofFloat;
                        ofFloat.setDuration(800L);
                        this.M.setInterpolator(new AccelerateInterpolator());
                    }
                    if (this.J == null) {
                        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                        this.J = ofFloat2;
                        ofFloat2.setDuration(800L);
                        this.J.setInterpolator(new AccelerateInterpolator());
                        e eVar = new e(null);
                        this.L = eVar;
                        this.J.addListener(eVar);
                        this.J.addUpdateListener(new b(this));
                    }
                    if (n()) {
                        i = 1;
                    } else {
                        i = o() ? 2 : 0;
                    }
                    if (view == this.f33576e) {
                        k(1 != i);
                        l(false);
                        i2 = 1;
                    } else if (view == this.f33577f) {
                        l(2 != i);
                        k(false);
                    } else {
                        i2 = 0;
                    }
                    TiebaStatic.log(new StatisticItem("c13352").param("obj_type", i2).param("topic_id", this.f33573b.a).param("obj_source", this.f33573b.f17593f));
                    f fVar = this.U;
                    if (fVar != null) {
                        fVar.a(i2 == i ? 0 : i2);
                    }
                    RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                    requestBlessMessage.setPkId(Long.valueOf(this.f33573b.f17589b));
                    requestBlessMessage.setTopicId(Long.valueOf(this.f33573b.a));
                    requestBlessMessage.setPkIndex(i2);
                    requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                    requestBlessMessage.setPkType(0);
                    requestBlessMessage.setUserPkId(this.f33573b.f17590c);
                    MessageManager.getInstance().sendMessage(requestBlessMessage);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ValueAnimator valueAnimator = this.J;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimator2 = this.M;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            removeCallbacks(this.T);
            super.onDetachedFromWindow();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f33573b == null) {
                return;
            }
            this.t = this.f33576e.getWidth();
            this.u = this.f33576e.getHeight();
            this.v = this.f33578g.getWidth();
            this.w = this.k.getWidth();
            this.x = this.l.getWidth();
            this.A = this.k.getHeight();
            this.y = this.n.getWidth();
            this.z = this.o.getWidth();
            this.B = this.m.getWidth();
            this.C = this.m.getHeight();
            this.D = ((this.r - (this.t * 2)) - this.w) - this.x;
            this.G = this.p.getWidth();
            c.a.p0.q1.l.c.c.b bVar = this.f33573b;
            if (bVar.f17591d.a == 0 && bVar.f17592e.a == 0) {
                this.F = (int) ((this.D * 0.5d) + this.w + this.t);
            } else {
                c.a.p0.q1.l.c.c.b bVar2 = this.f33573b;
                long j = bVar2.f17591d.a;
                this.F = (int) (((((float) j) / ((float) (j + bVar2.f17592e.a))) * this.D) + this.w + this.t);
            }
            float y = this.f33576e.getY() - ((this.C - this.u) / 2);
            if (this.F + (this.B / 2) >= this.l.getLeft()) {
                this.F = (this.l.getLeft() - 10) - (this.B / 2);
                int i5 = (int) y;
                this.m.layout((this.l.getLeft() - 10) - this.B, i5, this.l.getLeft() - 10, this.C + i5);
            } else if (this.F - (this.B / 2) <= this.k.getRight()) {
                this.F = this.k.getRight() + 10 + (this.B / 2);
                int i6 = (int) y;
                this.m.layout(this.k.getRight() + 10, i6, this.k.getRight() + 10 + this.B, this.C + i6);
            } else {
                ImageView imageView = this.m;
                int i7 = this.F;
                int i8 = this.B;
                int i9 = (int) y;
                imageView.layout(i7 - (i8 / 2), i9, i7 + (i8 / 2), this.C + i9);
            }
            int x = (this.r / 2) - ((int) this.f33578g.getX());
            int i10 = this.y;
            if (i10 < this.v) {
                int i11 = (this.t - i10) / 2;
                TextView textView = this.n;
                textView.layout(i11, (int) textView.getY(), this.y + i11, ((int) this.n.getY()) + this.A);
            } else if (i10 <= x) {
                this.n.layout((int) this.f33578g.getX(), (int) this.n.getY(), ((int) this.f33578g.getX()) + this.y, ((int) this.n.getY()) + this.A);
            } else {
                ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
                layoutParams.width = x;
                this.n.setLayoutParams(layoutParams);
                postDelayed(this.T, 300L);
            }
            int i12 = this.z;
            if (i12 < this.v) {
                int x2 = ((int) this.f33577f.getX()) + ((this.t - this.z) / 2);
                TextView textView2 = this.o;
                textView2.layout(x2, (int) textView2.getY(), this.z + x2, ((int) this.o.getY()) + this.A);
            } else if (i12 <= x) {
                this.o.layout((this.r - ((int) this.f33579h.getX())) - this.z, (int) this.o.getY(), this.r - ((int) this.f33579h.getX()), ((int) this.o.getY()) + this.A);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                layoutParams2.width = x;
                this.o.setLayoutParams(layoutParams2);
                postDelayed(this.T, 300L);
            }
            int i13 = (this.t - this.G) / 2;
            this.p.layout(((int) this.f33576e.getX()) + i13, ((int) this.f33576e.getY()) + i13, ((int) this.f33576e.getX()) + i13 + this.G, ((int) this.f33576e.getY()) + i13 + this.G);
            this.q.layout(((int) this.f33577f.getX()) + i13, ((int) this.f33577f.getY()) + i13, ((int) this.f33577f.getX()) + i13 + this.G, ((int) this.f33577f.getY()) + i13 + this.G);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            int size = View.MeasureSpec.getSize(i);
            this.r = size;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(this.s, 1073741824));
        }
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0846, (ViewGroup) this, true);
            this.f33574c = (TextView) findViewById(R.id.obfuscated_res_0x7f092105);
            this.f33575d = (TextView) findViewById(R.id.obfuscated_res_0x7f09210d);
            this.f33576e = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f092100);
            this.f33577f = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f092108);
            this.f33578g = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092102);
            this.f33579h = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09210a);
            this.i = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092104);
            this.j = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09210c);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f092103);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f09210b);
            this.m = (ImageView) findViewById(R.id.obfuscated_res_0x7f092106);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f092101);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f092109);
            this.p = (ImageView) findViewById(R.id.obfuscated_res_0x7f0920ff);
            this.q = (ImageView) findViewById(R.id.obfuscated_res_0x7f092107);
            this.f33578g.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080414);
            this.f33579h.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080417);
            this.i.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080413);
            this.j.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080416);
            this.f33576e.setOnClickListener(this);
            this.f33577f.setOnClickListener(this);
            this.s = n.f(context, R.dimen.tbds340);
            this.E = n.f(context, R.dimen.tbds62);
            Paint paint = new Paint();
            this.H = paint;
            paint.setAntiAlias(true);
            this.H.setDither(true);
            this.H.setFilterBitmap(true);
            q();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            SkinManager.setViewTextColor(this.f33574c, this.I);
            SkinManager.setViewTextColor(this.f33575d, this.I);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == this.a) {
                return;
            }
            this.a = skinType;
            this.f33578g.setSkinType(skinType);
            this.f33579h.setSkinType(this.a);
            this.i.setSkinType(this.a);
            this.j.setSkinType(this.a);
            SkinManager.setBackgroundResource(this.f33576e, R.drawable.btn_topic_agree_bg_red);
            SkinManager.setBackgroundResource(this.f33577f, R.drawable.btn_topic_disagree_bg_blue);
            SkinManager.setImageResource(this.p, R.drawable.pic_topic_addone);
            SkinManager.setImageResource(this.q, R.drawable.pic_topic_addone);
            SkinManager.setImageResource(this.m, R.drawable.pic_topic_vs_bginone);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.n, (int) R.color.topic_agree_des_color);
            SkinManager.setViewTextColor(this.o, (int) R.color.topic_disagree_des_color);
        }
    }

    public void setData(c.a.p0.q1.l.c.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            if (bVar != null && bVar.f17591d != null && bVar.f17592e != null) {
                setVisibility(0);
                this.f33573b = bVar;
                this.k.setText(String.valueOf(bVar.f17591d.a));
                this.l.setText(String.valueOf(bVar.f17592e.a));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                this.R = layoutParams;
                layoutParams.addRule(12);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                this.S = layoutParams2;
                layoutParams2.addRule(12);
                this.S.addRule(11);
                this.n.setLayoutParams(this.R);
                this.o.setLayoutParams(this.S);
                if (bVar.f17593f == 3) {
                    this.n.setText(StringUtils.isNull(bVar.f17591d.f17594b) ? getResources().getString(R.string.obfuscated_res_0x7f0f1408) : bVar.f17591d.f17594b);
                    this.o.setText(StringUtils.isNull(bVar.f17592e.f17594b) ? getResources().getString(R.string.obfuscated_res_0x7f0f1409) : bVar.f17592e.f17594b);
                    if (StringUtils.isNull(bVar.f17591d.f17595c)) {
                        this.f33574c.setVisibility(4);
                    } else {
                        this.f33574c.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f140a), bVar.f17591d.f17595c));
                    }
                    if (StringUtils.isNull(bVar.f17592e.f17595c)) {
                        this.f33575d.setVisibility(4);
                    } else {
                        this.f33575d.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f140a), bVar.f17592e.f17595c));
                    }
                } else {
                    this.n.setText(bVar.f17591d.f17594b);
                    this.o.setText(bVar.f17592e.f17594b);
                    this.f33574c.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f140a), bVar.f17591d.f17595c));
                    this.f33575d.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f140a), bVar.f17592e.f17595c));
                }
                this.f33578g.J(bVar.f17591d.f17596d, 10, false);
                this.f33579h.J(bVar.f17592e.f17596d, 10, false);
                this.i.J(bVar.f17591d.f17599g, 10, false);
                this.j.J(bVar.f17592e.f17599g, 10, false);
                if (bVar.f17591d.f17597e) {
                    this.f33578g.setVisibility(4);
                    this.i.setVisibility(0);
                } else {
                    this.f33578g.setVisibility(0);
                    this.i.setVisibility(4);
                }
                if (bVar.f17592e.f17597e) {
                    this.f33579h.setVisibility(4);
                    this.j.setVisibility(0);
                } else {
                    this.f33579h.setVisibility(0);
                    this.j.setVisibility(4);
                }
                invalidate();
                return;
            }
            setVisibility(8);
        }
    }

    public void setPkClickListener(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) || fVar == null) {
            return;
        }
        this.U = fVar;
    }

    public void setUserColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.I = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.I = R.color.CAM_X0101;
        this.T = new a(this);
        this.V = new c(this);
        p(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.I = R.color.CAM_X0101;
        this.T = new a(this);
        this.V = new c(this);
        p(context);
    }
}
