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
import c.a.d.f.p.m;
import c.a.s0.o1.k.b.c.b;
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
/* loaded from: classes12.dex */
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
    public int f46041e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.s0.o1.k.b.c.b f46042f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46043g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46044h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f46045i;

    /* renamed from: j  reason: collision with root package name */
    public FrameLayout f46046j;

    /* renamed from: k  reason: collision with root package name */
    public TbImageView f46047k;
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

    /* loaded from: classes12.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicPkView f46048e;

        public a(TopicPkView topicPkView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicPkView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46048e = topicPkView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46048e.requestLayout();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicPkView f46049e;

        public b(TopicPkView topicPkView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicPkView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46049e = topicPkView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f46049e.O.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f46049e.O.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicPkView f46050e;

        public c(TopicPkView topicPkView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicPkView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46050e = topicPkView;
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
                    double pow = (Math.pow(d2, 2.0d) * this.f46050e.R) + ((this.f46050e.x - 45) * f3);
                    double d3 = floatValue;
                    double pow2 = (Math.pow(d2, 2.0d) * this.f46050e.S) + (f3 * 70.0f) + (Math.pow(d3, 2.0d) * 60.0d);
                    this.f46050e.t.setX((float) (pow + (Math.pow(d3, 2.0d) * (this.f46050e.f46045i.getX() + (this.f46050e.x / 2)))));
                    this.f46050e.t.setY((float) pow2);
                } else {
                    floatValue -= 1.0f;
                    float f4 = 1.0f - floatValue;
                    double d4 = f4;
                    float f5 = 2.0f * floatValue * f4;
                    double pow3 = (Math.pow(d4, 2.0d) * (this.f46050e.f46045i.getX() + (this.f46050e.x / 2))) + (45.0f * f5);
                    double d5 = floatValue;
                    double pow4 = (Math.pow(d4, 2.0d) * 60.0d) + (f5 * 50.0f) + (Math.pow(d5, 2.0d) * 40.0d);
                    this.f46050e.t.setX((float) (pow3 + (Math.pow(d5, 2.0d) * (this.f46050e.f46045i.getX() + (this.f46050e.x / 2)))));
                    this.f46050e.t.setY((float) pow4);
                }
                if (floatValue == 1.0f) {
                    this.f46050e.t.setVisibility(4);
                    this.f46050e.t.setX(this.f46050e.T);
                    this.f46050e.t.setY(this.f46050e.U);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicPkView f46051e;

        public d(TopicPkView topicPkView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicPkView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46051e = topicPkView;
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
                    double pow = (Math.pow(d2, 2.0d) * this.f46051e.R) + (((this.f46051e.v - this.f46051e.x) + 45) * f3);
                    double d3 = floatValue;
                    double pow2 = (Math.pow(d2, 2.0d) * this.f46051e.S) + (f3 * 70.0f) + (Math.pow(d3, 2.0d) * 60.0d);
                    this.f46051e.u.setX((float) (pow + (Math.pow(d3, 2.0d) * (this.f46051e.v - (this.f46051e.x / 2)))));
                    this.f46051e.u.setY((float) pow2);
                } else {
                    floatValue -= 1.0f;
                    float f4 = 1.0f - floatValue;
                    double d4 = f4;
                    float f5 = 2.0f * floatValue * f4;
                    double pow3 = (Math.pow(d4, 2.0d) * (this.f46051e.v - (this.f46051e.x / 2))) + ((this.f46051e.v - 45) * f5);
                    double d5 = floatValue;
                    double pow4 = (Math.pow(d4, 2.0d) * 60.0d) + (f5 * 50.0f) + (Math.pow(d5, 2.0d) * 40.0d);
                    this.f46051e.u.setX((float) (pow3 + (Math.pow(d5, 2.0d) * (this.f46051e.v - 120))));
                    this.f46051e.u.setY((float) pow4);
                }
                if (floatValue == 1.0f) {
                    this.f46051e.u.setVisibility(4);
                    this.f46051e.u.setX(this.f46051e.T);
                    this.f46051e.u.setY(this.f46051e.U);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public View f46052e;

        /* renamed from: f  reason: collision with root package name */
        public View f46053f;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || (view = this.f46053f) == null) {
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
            if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || (view = this.f46052e) == null) {
                return;
            }
            view.setVisibility(0);
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes12.dex */
    public interface f {
        void a(int i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46041e = 3;
        this.M = R.color.CAM_X0101;
        this.a0 = new a(this);
        this.c0 = new c(this);
        p(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || this.f46042f == null) {
            return;
        }
        m(canvas);
        super.dispatchDraw(canvas);
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.f46043g.setVisibility(0);
                this.f46043g.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
                this.f46042f.f21227d.f21231c = TbadkCoreApplication.getCurrentAccountNameShow();
                b.a aVar = this.f46042f.f21227d;
                aVar.f21233e = true;
                TextView textView = this.o;
                long j2 = aVar.a + 1;
                aVar.a = j2;
                textView.setText(String.valueOf(j2));
                this.t.setVisibility(0);
                TbImageView tbImageView = this.m;
                this.O = tbImageView;
                this.P.f46052e = tbImageView;
                this.P.f46053f = this.f46047k;
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
            if (StringHelper.equals(this.f46042f.f21227d.f21231c, TbadkCoreApplication.getCurrentAccountNameShow())) {
                this.f46043g.setVisibility(4);
            }
            b.a aVar2 = this.f46042f.f21227d;
            if (aVar2.f21233e) {
                aVar2.f21233e = false;
                TextView textView2 = this.o;
                long j3 = aVar2.a - 1;
                aVar2.a = j3;
                textView2.setText(String.valueOf(j3));
            }
            this.f46047k.setVisibility(0);
            this.m.setVisibility(4);
        }
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.f46044h.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
                this.f46044h.setVisibility(0);
                this.f46042f.f21228e.f21231c = TbadkCoreApplication.getCurrentAccountNameShow();
                this.u.setVisibility(0);
                b.a aVar = this.f46042f.f21228e;
                aVar.f21233e = true;
                TextView textView = this.p;
                long j2 = aVar.a + 1;
                aVar.a = j2;
                textView.setText(String.valueOf(j2));
                this.R = this.u.getX() - (this.K / 2.0f);
                TbImageView tbImageView = this.n;
                this.O = tbImageView;
                this.P.f46052e = tbImageView;
                this.P.f46053f = this.l;
                this.t.setVisibility(0);
                this.N.start();
                this.R = this.u.getX() - (this.K / 2);
                this.S = this.u.getY();
                this.T = this.u.getX();
                this.U = this.u.getY();
                this.Q.removeAllUpdateListeners();
                this.Q.addUpdateListener(new d(this));
                this.Q.setFloatValues(0.0f, 2.0f);
                this.Q.start();
                return;
            }
            if (StringHelper.equals(this.f46042f.f21228e.f21231c, TbadkCoreApplication.getCurrentAccountNameShow())) {
                this.f46044h.setVisibility(4);
            }
            b.a aVar2 = this.f46042f.f21228e;
            if (aVar2.f21233e) {
                aVar2.f21233e = false;
                TextView textView2 = this.p;
                long j3 = aVar2.a - 1;
                aVar2.a = j3;
                textView2.setText(String.valueOf(j3));
            }
            this.u.setVisibility(4);
            this.l.setVisibility(0);
            this.n.setVisibility(4);
        }
    }

    public final void m(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            float y = this.f46045i.getY() + ((this.y - this.I) / 2);
            this.L.setShader(new LinearGradient(this.x / 2, y, this.J, y, SkinManager.getColor(R.color.topic_pk_agree_bar_start_color), SkinManager.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
            canvas.drawRect(this.x / 2, y, this.J, y + this.I, this.L);
            this.L.setShader(new LinearGradient(this.J, y, this.v - (this.x / 2), y, SkinManager.getColor(R.color.topic_pk_disagree_bar_start_color), SkinManager.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
            canvas.drawRect(this.J, y, this.v - (this.x / 2), y + this.I, this.L);
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.s0.o1.k.b.c.b bVar = this.f46042f;
            return (bVar == null || (aVar = bVar.f21227d) == null || !aVar.f21233e) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.s0.o1.k.b.c.b bVar = this.f46042f;
            return (bVar == null || (aVar = bVar.f21228e) == null || !aVar.f21233e) ? false : true;
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

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SkinManager.setViewTextColor(this.f46043g, this.M);
            SkinManager.setViewTextColor(this.f46044h, this.M);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == this.f46041e) {
                return;
            }
            this.f46041e = skinType;
            this.f46047k.setSkinType(skinType);
            this.l.setSkinType(this.f46041e);
            this.m.setSkinType(this.f46041e);
            this.n.setSkinType(this.f46041e);
            SkinManager.setBackgroundResource(this.f46045i, R.drawable.btn_topic_agree_bg_red);
            SkinManager.setBackgroundResource(this.f46046j, R.drawable.btn_topic_disagree_bg_blue);
            SkinManager.setImageResource(this.t, R.drawable.pic_topic_addone);
            SkinManager.setImageResource(this.u, R.drawable.pic_topic_addone);
            SkinManager.setImageResource(this.q, R.drawable.pic_topic_vs_bginone);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.r, R.color.topic_agree_des_color);
            SkinManager.setViewTextColor(this.s, R.color.topic_disagree_des_color);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
                loginActivityConfig.getIntent().putExtra("locate_type", this.f46042f.f21229f != 3 ? 16 : 0);
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
                        this.N.addUpdateListener(new b(this));
                    }
                    if (n()) {
                        i2 = 1;
                    } else {
                        i2 = o() ? 2 : 0;
                    }
                    if (view == this.f46045i) {
                        k(1 != i2);
                        l(false);
                        i3 = 1;
                    } else if (view == this.f46046j) {
                        l(2 != i2);
                        k(false);
                    } else {
                        i3 = 0;
                    }
                    TiebaStatic.log(new StatisticItem("c13352").param("obj_type", i3).param("topic_id", this.f46042f.a).param("obj_source", this.f46042f.f21229f));
                    f fVar = this.b0;
                    if (fVar != null) {
                        fVar.a(i3 == i2 ? 0 : i3);
                    }
                    RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                    requestBlessMessage.setPkId(Long.valueOf(this.f46042f.f21225b));
                    requestBlessMessage.setTopicId(Long.valueOf(this.f46042f.a));
                    requestBlessMessage.setPkIndex(i3);
                    requestBlessMessage.setClickType(i2 == 0 ? 0 : 1);
                    requestBlessMessage.setPkType(0);
                    requestBlessMessage.setUserPkId(this.f46042f.f21226c);
                    MessageManager.getInstance().sendMessage(requestBlessMessage);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (this.f46042f == null) {
                return;
            }
            this.x = this.f46045i.getWidth();
            this.y = this.f46045i.getHeight();
            this.z = this.f46047k.getWidth();
            this.A = this.o.getWidth();
            this.B = this.p.getWidth();
            this.E = this.o.getHeight();
            this.C = this.r.getWidth();
            this.D = this.s.getWidth();
            this.F = this.q.getWidth();
            this.G = this.q.getHeight();
            this.H = ((this.v - (this.x * 2)) - this.A) - this.B;
            this.K = this.t.getWidth();
            c.a.s0.o1.k.b.c.b bVar = this.f46042f;
            if (bVar.f21227d.a == 0 && bVar.f21228e.a == 0) {
                this.J = (int) ((this.H * 0.5d) + this.A + this.x);
            } else {
                c.a.s0.o1.k.b.c.b bVar2 = this.f46042f;
                long j2 = bVar2.f21227d.a;
                this.J = (int) (((((float) j2) / ((float) (j2 + bVar2.f21228e.a))) * this.H) + this.A + this.x);
            }
            float y = this.f46045i.getY() - ((this.G - this.y) / 2);
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
            int x = (this.v / 2) - ((int) this.f46047k.getX());
            int i11 = this.C;
            if (i11 < this.z) {
                int i12 = (this.x - i11) / 2;
                TextView textView = this.r;
                textView.layout(i12, (int) textView.getY(), this.C + i12, ((int) this.r.getY()) + this.E);
            } else if (i11 <= x) {
                this.r.layout((int) this.f46047k.getX(), (int) this.r.getY(), ((int) this.f46047k.getX()) + this.C, ((int) this.r.getY()) + this.E);
            } else {
                ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
                layoutParams.width = x;
                this.r.setLayoutParams(layoutParams);
                postDelayed(this.a0, 300L);
            }
            int i13 = this.D;
            if (i13 < this.z) {
                int x2 = ((int) this.f46046j.getX()) + ((this.x - this.D) / 2);
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
            this.t.layout(((int) this.f46045i.getX()) + i14, ((int) this.f46045i.getY()) + i14, ((int) this.f46045i.getX()) + i14 + this.K, ((int) this.f46045i.getY()) + i14 + this.K);
            this.u.layout(((int) this.f46046j.getX()) + i14, ((int) this.f46046j.getY()) + i14, ((int) this.f46046j.getX()) + i14 + this.K, ((int) this.f46046j.getY()) + i14 + this.K);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i2);
            this.v = size;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(this.w, 1073741824));
        }
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
            this.f46043g = (TextView) findViewById(R.id.topic_pk_view_agree_user);
            this.f46044h = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
            this.f46045i = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
            this.f46046j = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
            this.f46047k = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
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
            this.f46047k.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
            this.l.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
            this.m.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
            this.n.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
            this.f46045i.setOnClickListener(this);
            this.f46046j.setOnClickListener(this);
            this.w = m.f(context, R.dimen.tbds340);
            this.I = m.f(context, R.dimen.tbds62);
            Paint paint = new Paint();
            this.L = paint;
            paint.setAntiAlias(true);
            this.L.setDither(true);
            this.L.setFilterBitmap(true);
            onChangeSkinType();
        }
    }

    public void setData(c.a.s0.o1.k.b.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            if (bVar != null && bVar.f21227d != null && bVar.f21228e != null) {
                setVisibility(0);
                this.f46042f = bVar;
                this.o.setText(String.valueOf(bVar.f21227d.a));
                this.p.setText(String.valueOf(bVar.f21228e.a));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                this.V = layoutParams;
                layoutParams.addRule(12);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                this.W = layoutParams2;
                layoutParams2.addRule(12);
                this.W.addRule(11);
                this.r.setLayoutParams(this.V);
                this.s.setLayoutParams(this.W);
                if (bVar.f21229f == 3) {
                    this.r.setText(StringUtils.isNull(bVar.f21227d.f21230b) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.f21227d.f21230b);
                    this.s.setText(StringUtils.isNull(bVar.f21228e.f21230b) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.f21228e.f21230b);
                    if (StringUtils.isNull(bVar.f21227d.f21231c)) {
                        this.f46043g.setVisibility(4);
                    } else {
                        this.f46043g.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.f21227d.f21231c));
                    }
                    if (StringUtils.isNull(bVar.f21228e.f21231c)) {
                        this.f46044h.setVisibility(4);
                    } else {
                        this.f46044h.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.f21228e.f21231c));
                    }
                } else {
                    this.r.setText(bVar.f21227d.f21230b);
                    this.s.setText(bVar.f21228e.f21230b);
                    this.f46043g.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.f21227d.f21231c));
                    this.f46044h.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.f21228e.f21231c));
                }
                this.f46047k.startLoad(bVar.f21227d.f21232d, 10, false);
                this.l.startLoad(bVar.f21228e.f21232d, 10, false);
                this.m.startLoad(bVar.f21227d.f21235g, 10, false);
                this.n.startLoad(bVar.f21228e.f21235g, 10, false);
                if (bVar.f21227d.f21233e) {
                    this.f46047k.setVisibility(4);
                    this.m.setVisibility(0);
                } else {
                    this.f46047k.setVisibility(0);
                    this.m.setVisibility(4);
                }
                if (bVar.f21228e.f21233e) {
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
    }

    public void setPkClickListener(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) || fVar == null) {
            return;
        }
        this.b0 = fVar;
    }

    public void setUserColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.M = i2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46041e = 3;
        this.M = R.color.CAM_X0101;
        this.a0 = new a(this);
        this.c0 = new c(this);
        p(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicPkView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f46041e = 3;
        this.M = R.color.CAM_X0101;
        this.a0 = new a(this);
        this.c0 = new c(this);
        p(context);
    }
}
