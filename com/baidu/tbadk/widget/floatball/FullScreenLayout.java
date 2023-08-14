package com.baidu.tbadk.widget.floatball;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.iy5;
import com.baidu.tieba.jy5;
import com.baidu.tieba.my5;
import com.baidu.tieba.ny5;
import com.baidu.tieba.oy5;
import com.baidu.tieba.ry5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FullScreenLayout extends FrameLayout implements oy5 {
    public static /* synthetic */ Interceptable $ic;
    public static final int G;
    public transient /* synthetic */ FieldHolder $fh;
    public ValueAnimator A;
    public ObjectAnimator B;
    public jy5 C;
    public ny5 D;
    public my5 E;
    public ViewTreeObserver.OnGlobalLayoutListener F;
    public iy5 a;
    public ImageView b;
    public FrameLayout.LayoutParams c;
    public ImageView d;
    public FrameLayout.LayoutParams e;
    public FloatWebLayout f;
    public final RectF g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public int r;
    public ry5 s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public final int C(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? (int) (((i2 * 1.0f) / 800.0f) * 250.0f) : invokeI.intValue;
    }

    /* loaded from: classes5.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FullScreenLayout a;

        public a(FullScreenLayout fullScreenLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fullScreenLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fullScreenLayout;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.d.setAlpha(0.0f);
                this.a.d.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                this.a.j = true;
                this.a.l = true;
                this.a.c.leftMargin = this.a.e.leftMargin + ((int) (((this.a.w - this.a.u) * 1.0f) / 2.0f));
                this.a.b.setAlpha(0.0f);
                this.a.b.setVisibility(0);
                this.a.b.requestLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements jy5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FullScreenLayout a;

        public b(FullScreenLayout fullScreenLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fullScreenLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fullScreenLayout;
        }

        @Override // com.baidu.tieba.jy5.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.J() && this.a.isAttachedToWindow()) {
                this.a.z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FullScreenLayout a;

        public c(FullScreenLayout fullScreenLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fullScreenLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fullScreenLayout;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            boolean H;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) != null) || this.a.m == (H = this.a.H())) {
                return;
            }
            this.a.S(H);
            this.a.m = H;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Rect a;
        public final /* synthetic */ View b;
        public final /* synthetic */ FullScreenLayout c;

        public d(FullScreenLayout fullScreenLayout, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fullScreenLayout, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fullScreenLayout;
            this.b = view2;
            this.a = new Rect();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.getWindowVisibleDisplayFrame(this.a);
                if (this.c.getHeight() - this.a.bottom > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (this.c.n == z) {
                    return;
                }
                this.c.P(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FullScreenLayout a;

        public e(FullScreenLayout fullScreenLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fullScreenLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fullScreenLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f = (0.2f * floatValue) + 0.8f;
                this.a.b.setAlpha(floatValue);
                this.a.b.setScaleX(f);
                this.a.b.setScaleY(f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FullScreenLayout a;

        public f(FullScreenLayout fullScreenLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fullScreenLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fullScreenLayout;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.W();
                this.a.y();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                this.a.b.setScaleX(0.8f);
                this.a.b.setScaleY(0.8f);
                this.a.b.setAlpha(0.0f);
                this.a.b.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FullScreenLayout a;

        public g(FullScreenLayout fullScreenLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fullScreenLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fullScreenLayout;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                FullScreenLayout fullScreenLayout = this.a;
                fullScreenLayout.x(fullScreenLayout.a.b());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FullScreenLayout a;

        public h(FullScreenLayout fullScreenLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fullScreenLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fullScreenLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.a.d.setAlpha(floatValue);
                float f = 1.0f - floatValue;
                this.a.b.setAlpha(f);
                if (this.a.k) {
                    this.a.c.leftMargin = (int) (this.a.a.i() - ((this.a.u + this.a.a.i()) * floatValue));
                    this.a.e.leftMargin = (int) ((-this.a.w) + (floatValue * (this.a.w + this.a.a.e())));
                } else {
                    this.a.c.leftMargin = (int) (this.a.getWidth() - (f * (this.a.u + this.a.a.i())));
                    this.a.e.leftMargin = (int) (this.a.getWidth() - (floatValue * (this.a.w + this.a.a.e())));
                }
                this.a.requestLayout();
                this.a.W();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FullScreenLayout a;

        public i(FullScreenLayout fullScreenLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fullScreenLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fullScreenLayout;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.j = false;
                this.a.b.setAlpha(0.0f);
                this.a.b.setVisibility(4);
                this.a.W();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (this.a.x < this.a.v) {
                    this.a.e.topMargin = (int) (this.a.y + (((this.a.v - this.a.x) * 1.0f) / 2.0f));
                }
                if (this.a.k) {
                    this.a.e.leftMargin = -this.a.w;
                } else {
                    this.a.e.leftMargin = this.a.getWidth();
                }
                this.a.d.setAlpha(0.0f);
                this.a.d.setVisibility(0);
                this.a.d.requestLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FullScreenLayout a;

        public j(FullScreenLayout fullScreenLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fullScreenLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fullScreenLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.a.b.setAlpha(floatValue);
                this.a.d.setAlpha(1.0f - floatValue);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-949156454, "Lcom/baidu/tbadk/widget/floatball/FullScreenLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-949156454, "Lcom/baidu/tbadk/widget/floatball/FullScreenLayout;");
                return;
            }
        }
        G = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds45);
    }

    public final boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.b.getVisibility() != 0 && this.d.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            FloatWebLayout floatWebLayout = this.f;
            if (floatWebLayout == null) {
                return false;
            }
            return floatWebLayout.i();
        }
        return invokeV.booleanValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (K()) {
                FloatWebLayout floatWebLayout = this.f;
                if (floatWebLayout != null) {
                    floatWebLayout.b();
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.l = false;
            if (this.i) {
                O();
            } else {
                L();
            }
        }
    }

    @Override // com.baidu.tieba.oy5
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            x(this.a.l());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onAttachedToWindow();
            jy5 jy5Var = this.C;
            if (jy5Var != null) {
                jy5Var.e();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDetachedFromWindow();
            R();
            B();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FullScreenLayout(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.h = ViewConfiguration.get(context).getScaledTouchSlop();
            this.s = new ry5(this);
            G(context);
            E(context);
            W();
            addOnLayoutChangeListener(new c(this));
            F(context);
        }
    }

    public final void F(@NonNull Context context) {
        View decorView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, context) != null) || !(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        if (activity.getWindow() != null && (decorView = activity.getWindow().getDecorView()) != null && decorView.getViewTreeObserver() != null) {
            this.F = new d(this, decorView);
            decorView.getViewTreeObserver().addOnGlobalLayoutListener(this.F);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r0 != 3) goto L11;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        U(rawX, rawY);
                    }
                }
                V();
            } else {
                T(rawX, rawY);
            }
            return this.t;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FullScreenLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public final void U(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) {
            int i4 = i2 - this.o;
            int i5 = i3 - this.p;
            int i6 = i2 - this.q;
            int i7 = i3 - this.r;
            if (Math.abs(i4) > this.h || Math.abs(i5) > this.h) {
                this.i = false;
            }
            this.q = i2;
            this.r = i3;
            if (!this.i) {
                if (!this.l && !this.j && Math.abs(i4) >= G) {
                    A();
                }
                Q(i6, i7);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = iy5.a();
        this.g = new RectF();
        this.j = true;
        this.k = true;
        this.m = false;
        this.n = false;
        this.u = this.a.k();
        this.v = this.a.j();
        this.w = this.a.g();
        this.x = this.a.f();
        this.y = this.a.o();
        this.z = this.a.c();
        D(context);
    }

    public final void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            S(z);
            this.n = z;
        }
    }

    public void setClickListener(my5 my5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, my5Var) == null) {
            this.E = my5Var;
        }
    }

    public void setFloatData(ny5 ny5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, ny5Var) == null) {
            if (this.C == null) {
                jy5 jy5Var = new jy5(this.b, this.d);
                this.C = jy5Var;
                jy5Var.f(new b(this));
            }
            this.C.g(ny5Var);
            this.D = ny5Var;
        }
    }

    public final boolean I(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) {
            float f2 = i2;
            RectF rectF = this.g;
            if (f2 >= rectF.left && f2 <= rectF.right) {
                float f3 = i3;
                if (f3 >= rectF.top && f3 <= rectF.bottom) {
                    return true;
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public final void Q(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) {
            FrameLayout.LayoutParams layoutParams = this.c;
            layoutParams.leftMargin += i2;
            layoutParams.topMargin += i3;
            FrameLayout.LayoutParams layoutParams2 = this.e;
            layoutParams2.leftMargin += i2;
            layoutParams2.topMargin += i3;
            requestLayout();
            W();
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.l) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.A = ofFloat;
        ofFloat.setDuration(this.a.h());
        this.A.setInterpolator(new LinearInterpolator());
        this.A.addUpdateListener(new j(this));
        this.A.addListener(new a(this));
        this.A.start();
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ValueAnimator valueAnimator = this.A;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.A.removeAllUpdateListeners();
                this.A.cancel();
            }
            ObjectAnimator objectAnimator = this.B;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
                this.B.removeAllUpdateListeners();
                this.B.cancel();
                this.b.setRotation(0.0f);
            }
            ry5 ry5Var = this.s;
            if (ry5Var != null && ry5Var.a()) {
                this.s.d();
            }
            this.d.setAlpha(1.0f);
            this.b.setAlpha(1.0f);
            this.b.setScaleX(1.0f);
            this.b.setScaleY(1.0f);
        }
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!(getContext() instanceof Activity)) {
                return false;
            }
            if (((Activity) getContext()).getRequestedOrientation() != 0 && ((Activity) getContext()).getRequestedOrientation() != 8 && ((Activity) getContext()).getRequestedOrientation() != 6 && ((Activity) getContext()).getRequestedOrientation() != 11) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void L() {
        int e2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int width = getWidth() / 2;
            RectF rectF = this.g;
            float f2 = rectF.left;
            if (((int) (f2 + ((rectF.right - f2) / 2.0f))) < width) {
                if (this.j) {
                    i2 = this.a.i();
                } else {
                    i2 = this.a.e();
                }
                this.k = true;
            } else {
                RectF rectF2 = this.g;
                int width2 = (int) (getWidth() - (rectF2.right - rectF2.left));
                if (this.j) {
                    e2 = this.a.i();
                } else {
                    e2 = this.a.e();
                }
                i2 = width2 - e2;
                this.k = false;
            }
            M(i2);
        }
    }

    public final void O() {
        ny5 ny5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (ny5Var = this.D) != null && !StringUtils.isNull(ny5Var.c())) {
            if (this.f == null) {
                FloatWebLayout floatWebLayout = new FloatWebLayout(getContext(), this.D.c());
                this.f = floatWebLayout;
                addView(floatWebLayout, new FrameLayout.LayoutParams(-1, -1));
            }
            this.f.j(this.D.c());
            x(this.a.l());
            my5 my5Var = this.E;
            if (my5Var != null) {
                my5Var.a(this.j);
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.j) {
                RectF rectF = this.g;
                FrameLayout.LayoutParams layoutParams = this.c;
                float f2 = layoutParams.leftMargin;
                rectF.left = f2;
                float f3 = layoutParams.topMargin;
                rectF.top = f3;
                rectF.right = f2 + this.u;
                rectF.bottom = f3 + this.v;
                return;
            }
            RectF rectF2 = this.g;
            FrameLayout.LayoutParams layoutParams2 = this.e;
            float f4 = layoutParams2.leftMargin;
            rectF2.left = f4;
            float f5 = layoutParams2.topMargin;
            rectF2.top = f5;
            int i2 = this.w;
            float f6 = i2 + f4;
            rectF2.right = f6;
            rectF2.bottom = f5 + this.x;
            if (this.k) {
                rectF2.right = f6 + i2;
            } else {
                rectF2.left = f4 - i2;
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && !this.n && !this.m) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.A = ofFloat;
            ofFloat.setDuration(this.a.n());
            this.A.setInterpolator(new LinearInterpolator());
            this.A.addUpdateListener(new e(this));
            this.A.addListener(new f(this));
            this.A.start();
        }
    }

    public final void E(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            ImageView imageView = new ImageView(context);
            this.d = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            int i2 = this.y;
            int i3 = this.v;
            int i4 = this.x;
            if (i3 > i4) {
                i2 = (int) (i2 + (((i3 - i4) * 1.0f) / 2.0f));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.w, this.x);
            this.e = layoutParams;
            layoutParams.setMargins(0, i2, 0, 0);
            addView(this.d, this.e);
            this.d.setVisibility(4);
        }
    }

    public final void G(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            ImageView imageView = new ImageView(context);
            this.b = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            int i2 = this.y;
            int i3 = this.v;
            int i4 = this.x;
            if (i3 < i4) {
                i2 = (int) (i2 + (((i4 - i3) * 1.0f) / 2.0f));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.u, this.v);
            this.c = layoutParams;
            layoutParams.setMargins(this.a.i(), i2, 0, 0);
            addView(this.b, this.c);
            this.b.setVisibility(4);
        }
    }

    public final void M(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            RectF rectF = this.g;
            float f2 = rectF.top;
            int i4 = this.y;
            if (f2 < i4) {
                i3 = i4 - this.c.topMargin;
            } else if (rectF.bottom > getHeight() - this.z) {
                i3 = (int) ((getHeight() - this.z) - this.g.bottom);
            } else {
                i3 = 0;
            }
            int i5 = (int) (i2 - this.g.left);
            this.s.b(i5, i3, C(Math.abs(i5)));
        }
    }

    public void x(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048606, this, j2) == null) && this.j && !this.n && !this.m) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.A = ofFloat;
            ofFloat.setDuration(this.a.d());
            this.A.setInterpolator(new LinearInterpolator());
            this.A.addUpdateListener(new h(this));
            this.A.addListener(new i(this));
            this.A.setStartDelay(j2);
            this.A.start();
        }
    }

    public final void R() {
        View decorView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || this.F == null || !(getContext() instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) getContext();
        if (activity.getWindow() != null && (decorView = activity.getWindow().getDecorView()) != null && decorView.getViewTreeObserver() != null) {
            decorView.getViewTreeObserver().removeOnGlobalLayoutListener(this.F);
        }
    }

    public final void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                B();
                this.b.setVisibility(4);
                this.d.setVisibility(4);
                if (this.k) {
                    this.c.leftMargin = -this.u;
                    this.e.leftMargin = this.a.e();
                } else {
                    this.c.leftMargin = BdUtilHelper.getEquipmentWidth(getContext()) - (this.u + this.a.i());
                    this.e.leftMargin = BdUtilHelper.getEquipmentWidth(getContext()) - (this.w + this.a.e());
                }
                this.j = false;
                requestLayout();
                W();
                return;
            }
            this.d.setVisibility(0);
            this.b.setVisibility(4);
        }
    }

    public final void T(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i2, i3) == null) {
            ValueAnimator valueAnimator = this.A;
            if ((valueAnimator != null && valueAnimator.isRunning()) || this.s.a()) {
                this.t = false;
                return;
            }
            this.o = i2;
            this.p = i3;
            this.q = i2;
            this.r = i3;
            this.i = true;
            if (I(i2, i3)) {
                B();
                this.t = true;
                return;
            }
            this.t = false;
        }
    }

    @Override // com.baidu.tieba.oy5
    public void b(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048600, this, i2, i3, i4, i5) == null) {
            Q(i4 - i2, i5 - i3);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.b, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.167f, 15.0f), Keyframe.ofFloat(0.334f, -15.0f), Keyframe.ofFloat(0.5f, 15.0f), Keyframe.ofFloat(0.667f, -15.0f), Keyframe.ofFloat(0.834f, 15.0f), Keyframe.ofFloat(1.0f, 0.0f)));
            this.B = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(this.a.m());
            this.B.addListener(new g(this));
            this.B.setStartDelay(160L);
            this.B.start();
        }
    }
}
