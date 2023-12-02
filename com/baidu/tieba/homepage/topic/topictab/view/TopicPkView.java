package com.baidu.tieba.homepage.topic.topictab.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.mainentrance.MainEntrance;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.tieba.pk8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.chromium.net.NetError;
/* loaded from: classes6.dex */
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

    /* renamed from: T  reason: collision with root package name */
    public Runnable f1105T;
    public f U;
    public ValueAnimator.AnimatorUpdateListener V;
    public int a;
    public pk8 b;
    public TextView c;
    public TextView d;
    public FrameLayout e;
    public FrameLayout f;
    public TbImageView g;
    public TbImageView h;
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

    /* loaded from: classes6.dex */
    public interface f {
        void a(int i);
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
                    float f = 1.0f - floatValue;
                    double d = f;
                    float f2 = 2.0f * floatValue * f;
                    double pow = (Math.pow(d, 2.0d) * this.a.N) + ((this.a.t - 45) * f2);
                    double d2 = floatValue;
                    double pow2 = (Math.pow(d, 2.0d) * this.a.O) + (f2 * 70.0f) + (Math.pow(d2, 2.0d) * 60.0d);
                    this.a.p.setX((float) (pow + (Math.pow(d2, 2.0d) * (this.a.e.getX() + (this.a.t / 2)))));
                    this.a.p.setY((float) pow2);
                } else {
                    floatValue -= 1.0f;
                    float f3 = 1.0f - floatValue;
                    double d3 = f3;
                    float f4 = 2.0f * floatValue * f3;
                    double pow3 = (Math.pow(d3, 2.0d) * (this.a.e.getX() + (this.a.t / 2))) + (45.0f * f4);
                    double d4 = floatValue;
                    double pow4 = (Math.pow(d3, 2.0d) * 60.0d) + (f4 * 50.0f) + (Math.pow(d4, 2.0d) * 40.0d);
                    this.a.p.setX((float) (pow3 + (Math.pow(d4, 2.0d) * (this.a.e.getX() + (this.a.t / 2)))));
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

    /* loaded from: classes6.dex */
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
                    float f = 1.0f - floatValue;
                    double d = f;
                    float f2 = 2.0f * floatValue * f;
                    double pow = (Math.pow(d, 2.0d) * this.a.N) + (((this.a.r - this.a.t) + 45) * f2);
                    double d2 = floatValue;
                    double pow2 = (Math.pow(d, 2.0d) * this.a.O) + (f2 * 70.0f) + (Math.pow(d2, 2.0d) * 60.0d);
                    this.a.q.setX((float) (pow + (Math.pow(d2, 2.0d) * (this.a.r - (this.a.t / 2)))));
                    this.a.q.setY((float) pow2);
                } else {
                    floatValue -= 1.0f;
                    float f3 = 1.0f - floatValue;
                    double d3 = f3;
                    float f4 = 2.0f * floatValue * f3;
                    double pow3 = (Math.pow(d3, 2.0d) * (this.a.r - (this.a.t / 2))) + ((this.a.r - 45) * f4);
                    double d4 = floatValue;
                    double pow4 = (Math.pow(d3, 2.0d) * 60.0d) + (f4 * 50.0f) + (Math.pow(d4, 2.0d) * 40.0d);
                    this.a.q.setX((float) (pow3 + (Math.pow(d4, 2.0d) * (this.a.r + NetError.ERR_SOCKS_CONNECTION_FAILED))));
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

    /* loaded from: classes6.dex */
    public static class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public View b;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

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

        public /* synthetic */ e(a aVar) {
            this();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) && (view2 = this.b) != null) {
                view2.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, animator) == null) && (view2 = this.a) != null) {
                view2.setVisibility(0);
            }
        }
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
        this.f1105T = new a(this);
        this.V = new c(this);
        q(context);
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
        this.f1105T = new a(this);
        this.V = new c(this);
        q(context);
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
        this.f1105T = new a(this);
        this.V = new c(this);
        q(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, canvas) != null) || this.b == null) {
            return;
        }
        n(canvas);
        super.dispatchDraw(canvas);
    }

    public void setPkClickListener(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) && fVar != null) {
            this.U = fVar;
        }
    }

    public void setUserColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.I = i;
        }
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.c.setVisibility(0);
                this.c.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f1727), TbadkCoreApplication.getCurrentAccountNameShow()));
                this.b.d.c = TbadkCoreApplication.getCurrentAccountNameShow();
                pk8.a aVar = this.b.d;
                aVar.e = true;
                TextView textView = this.k;
                long j = aVar.a + 1;
                aVar.a = j;
                textView.setText(String.valueOf(j));
                this.p.setVisibility(0);
                TbImageView tbImageView = this.i;
                this.K = tbImageView;
                this.L.a = tbImageView;
                this.L.b = this.g;
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
            if (StringHelper.equals(this.b.d.c, TbadkCoreApplication.getCurrentAccountNameShow())) {
                this.c.setVisibility(4);
            }
            pk8.a aVar2 = this.b.d;
            if (aVar2.e) {
                aVar2.e = false;
                TextView textView2 = this.k;
                long j2 = aVar2.a - 1;
                aVar2.a = j2;
                textView2.setText(String.valueOf(j2));
            }
            this.g.setVisibility(0);
            this.i.setVisibility(4);
        }
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.d.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f1727), TbadkCoreApplication.getCurrentAccountNameShow()));
                this.d.setVisibility(0);
                this.b.e.c = TbadkCoreApplication.getCurrentAccountNameShow();
                this.q.setVisibility(0);
                pk8.a aVar = this.b.e;
                aVar.e = true;
                TextView textView = this.l;
                long j = aVar.a + 1;
                aVar.a = j;
                textView.setText(String.valueOf(j));
                this.N = this.q.getX() - (this.G / 2.0f);
                TbImageView tbImageView = this.j;
                this.K = tbImageView;
                this.L.a = tbImageView;
                this.L.b = this.h;
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
            if (StringHelper.equals(this.b.e.c, TbadkCoreApplication.getCurrentAccountNameShow())) {
                this.d.setVisibility(4);
            }
            pk8.a aVar2 = this.b.e;
            if (aVar2.e) {
                aVar2.e = false;
                TextView textView2 = this.l;
                long j2 = aVar2.a - 1;
                aVar2.a = j2;
                textView2.setText(String.valueOf(j2));
            }
            this.q.setVisibility(4);
            this.h.setVisibility(0);
            this.j.setVisibility(4);
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d09da, (ViewGroup) this, true);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f09276b);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f092773);
            this.e = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f092766);
            this.f = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09276e);
            this.g = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092768);
            this.h = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092770);
            this.i = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09276a);
            this.j = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092772);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f092769);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f092771);
            this.m = (ImageView) findViewById(R.id.obfuscated_res_0x7f09276c);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f092767);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f09276f);
            this.p = (ImageView) findViewById(R.id.obfuscated_res_0x7f092765);
            this.q = (ImageView) findViewById(R.id.obfuscated_res_0x7f09276d);
            this.g.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080495);
            this.h.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080498);
            this.i.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080494);
            this.j.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080497);
            this.e.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.s = BdUtilHelper.getDimens(context, R.dimen.tbds340);
            this.E = BdUtilHelper.getDimens(context, R.dimen.tbds62);
            Paint paint = new Paint();
            this.H = paint;
            paint.setAntiAlias(true);
            this.H.setDither(true);
            this.H.setFilterBitmap(true);
            r();
        }
    }

    public final void n(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            float y = this.e.getY() + ((this.u - this.E) / 2);
            this.H.setShader(new LinearGradient(this.t / 2, y, this.F, y, SkinManager.getColor(R.color.topic_pk_agree_bar_start_color), SkinManager.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
            canvas.drawRect(this.t / 2, y, this.F, y + this.E, this.H);
            this.H.setShader(new LinearGradient(this.F, y, this.r - (this.t / 2), y, SkinManager.getColor(R.color.topic_pk_disagree_bar_start_color), SkinManager.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
            canvas.drawRect(this.F, y, this.r - (this.t / 2), y + this.E, this.H);
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        pk8.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            pk8 pk8Var = this.b;
            if (pk8Var != null && (aVar = pk8Var.d) != null && aVar.e) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ValueAnimator valueAnimator = this.J;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimator2 = this.M;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            removeCallbacks(this.f1105T);
            super.onDetachedFromWindow();
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        pk8.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            pk8 pk8Var = this.b;
            if (pk8Var != null && (aVar = pk8Var.e) != null && aVar.e) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        boolean z;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            int i3 = 0;
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
                Intent intent = loginActivityConfig.getIntent();
                if (this.b.f != 3) {
                    i3 = 16;
                }
                intent.putExtra(MainEntrance.GOTO_TYPE, i3);
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
                return;
            }
            ValueAnimator valueAnimator = this.J;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                return;
            }
            ValueAnimator valueAnimator2 = this.M;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                return;
            }
            int i4 = 2;
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
            int i5 = 1;
            if (o()) {
                i = 1;
            } else if (p()) {
                i = 2;
            } else {
                i = 0;
            }
            if (view2 == this.e) {
                if (1 != i) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                k(z2);
                l(false);
                i4 = 1;
            } else if (view2 == this.f) {
                if (2 != i) {
                    z = true;
                } else {
                    z = false;
                }
                l(z);
                k(false);
            } else {
                i4 = 0;
            }
            TiebaStatic.log(new StatisticItem("c13352").param("obj_type", i4).param("topic_id", this.b.a).param("obj_source", this.b.f));
            f fVar = this.U;
            if (fVar != null) {
                if (i4 == i) {
                    i2 = 0;
                } else {
                    i2 = i4;
                }
                fVar.a(i2);
            }
            RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
            requestBlessMessage.setPkId(Long.valueOf(this.b.b));
            requestBlessMessage.setTopicId(Long.valueOf(this.b.a));
            requestBlessMessage.setPkIndex(i4);
            if (i == 0) {
                i5 = 0;
            }
            requestBlessMessage.setClickType(i5);
            requestBlessMessage.setPkType(0);
            requestBlessMessage.setUserPkId(this.b.c);
            MessageManager.getInstance().sendMessage(requestBlessMessage);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.b == null) {
                return;
            }
            this.t = this.e.getWidth();
            this.u = this.e.getHeight();
            this.v = this.g.getWidth();
            this.w = this.k.getWidth();
            this.x = this.l.getWidth();
            this.A = this.k.getHeight();
            this.y = this.n.getWidth();
            this.z = this.o.getWidth();
            this.B = this.m.getWidth();
            this.C = this.m.getHeight();
            this.D = ((this.r - (this.t * 2)) - this.w) - this.x;
            this.G = this.p.getWidth();
            pk8 pk8Var = this.b;
            if (pk8Var.d.a == 0 && pk8Var.e.a == 0) {
                this.F = (int) ((this.D * 0.5d) + this.w + this.t);
            } else {
                pk8 pk8Var2 = this.b;
                long j = pk8Var2.d.a;
                this.F = (int) (((((float) j) / ((float) (j + pk8Var2.e.a))) * this.D) + this.w + this.t);
            }
            float y = this.e.getY() - ((this.C - this.u) / 2);
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
            int x = (this.r / 2) - ((int) this.g.getX());
            int i10 = this.y;
            if (i10 < this.v) {
                int i11 = (this.t - i10) / 2;
                TextView textView = this.n;
                textView.layout(i11, (int) textView.getY(), this.y + i11, ((int) this.n.getY()) + this.A);
            } else if (i10 <= x) {
                this.n.layout((int) this.g.getX(), (int) this.n.getY(), ((int) this.g.getX()) + this.y, ((int) this.n.getY()) + this.A);
            } else {
                ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
                layoutParams.width = x;
                this.n.setLayoutParams(layoutParams);
                postDelayed(this.f1105T, 300L);
            }
            int i12 = this.z;
            if (i12 < this.v) {
                int x2 = ((int) this.f.getX()) + ((this.t - this.z) / 2);
                TextView textView2 = this.o;
                textView2.layout(x2, (int) textView2.getY(), this.z + x2, ((int) this.o.getY()) + this.A);
            } else if (i12 <= x) {
                this.o.layout((this.r - ((int) this.h.getX())) - this.z, (int) this.o.getY(), this.r - ((int) this.h.getX()), ((int) this.o.getY()) + this.A);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                layoutParams2.width = x;
                this.o.setLayoutParams(layoutParams2);
                postDelayed(this.f1105T, 300L);
            }
            int i13 = (this.t - this.G) / 2;
            this.p.layout(((int) this.e.getX()) + i13, ((int) this.e.getY()) + i13, ((int) this.e.getX()) + i13 + this.G, ((int) this.e.getY()) + i13 + this.G);
            this.q.layout(((int) this.f.getX()) + i13, ((int) this.f.getY()) + i13, ((int) this.f.getX()) + i13 + this.G, ((int) this.f.getY()) + i13 + this.G);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            int size = View.MeasureSpec.getSize(i);
            this.r = size;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(this.s, 1073741824));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            SkinManager.setViewTextColor(this.c, this.I);
            SkinManager.setViewTextColor(this.d, this.I);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == this.a) {
                return;
            }
            this.a = skinType;
            this.g.setSkinType(skinType);
            this.h.setSkinType(this.a);
            this.i.setSkinType(this.a);
            this.j.setSkinType(this.a);
            SkinManager.setBackgroundResource(this.e, R.drawable.btn_topic_agree_bg_red);
            SkinManager.setBackgroundResource(this.f, R.drawable.btn_topic_disagree_bg_blue);
            SkinManager.setImageResource(this.p, R.drawable.pic_topic_addone);
            SkinManager.setImageResource(this.q, R.drawable.pic_topic_addone);
            SkinManager.setImageResource(this.m, R.drawable.pic_topic_vs_bginone);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.n, (int) R.color.topic_agree_des_color);
            SkinManager.setViewTextColor(this.o, (int) R.color.topic_disagree_des_color);
        }
    }

    public void setData(pk8 pk8Var) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pk8Var) == null) {
            if (pk8Var != null && pk8Var.d != null && pk8Var.e != null) {
                setVisibility(0);
                this.b = pk8Var;
                this.k.setText(String.valueOf(pk8Var.d.a));
                this.l.setText(String.valueOf(pk8Var.e.a));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                this.R = layoutParams;
                layoutParams.addRule(12);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                this.S = layoutParams2;
                layoutParams2.addRule(12);
                this.S.addRule(11);
                this.n.setLayoutParams(this.R);
                this.o.setLayoutParams(this.S);
                if (pk8Var.f == 3) {
                    if (StringUtils.isNull(pk8Var.d.b)) {
                        str = getResources().getString(R.string.obfuscated_res_0x7f0f1725);
                    } else {
                        str = pk8Var.d.b;
                    }
                    this.n.setText(str);
                    if (StringUtils.isNull(pk8Var.e.b)) {
                        str2 = getResources().getString(R.string.obfuscated_res_0x7f0f1726);
                    } else {
                        str2 = pk8Var.e.b;
                    }
                    this.o.setText(str2);
                    if (StringUtils.isNull(pk8Var.d.c)) {
                        this.c.setVisibility(4);
                    } else {
                        this.c.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f1727), pk8Var.d.c));
                    }
                    if (StringUtils.isNull(pk8Var.e.c)) {
                        this.d.setVisibility(4);
                    } else {
                        this.d.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f1727), pk8Var.e.c));
                    }
                } else {
                    this.n.setText(pk8Var.d.b);
                    this.o.setText(pk8Var.e.b);
                    this.c.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f1727), pk8Var.d.c));
                    this.d.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f1727), pk8Var.e.c));
                }
                this.g.startLoad(pk8Var.d.d, 10, false);
                this.h.startLoad(pk8Var.e.d, 10, false);
                this.i.startLoad(pk8Var.d.g, 10, false);
                this.j.startLoad(pk8Var.e.g, 10, false);
                if (pk8Var.d.e) {
                    this.g.setVisibility(4);
                    this.i.setVisibility(0);
                } else {
                    this.g.setVisibility(0);
                    this.i.setVisibility(4);
                }
                if (pk8Var.e.e) {
                    this.h.setVisibility(4);
                    this.j.setVisibility(0);
                } else {
                    this.h.setVisibility(0);
                    this.j.setVisibility(4);
                }
                invalidate();
                return;
            }
            setVisibility(8);
        }
    }
}
