package com.baidu.tieba.homepage.personalize.bigday;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.f0.f;
/* loaded from: classes5.dex */
public class BigdaySwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] M;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public Animation B;
    public int C;
    public boolean D;
    public int E;
    public boolean F;
    public int G;
    public Animation.AnimationListener H;
    public final Animation I;
    public final Animation J;
    public final Animation K;
    public Runnable L;

    /* renamed from: e  reason: collision with root package name */
    public int f16721e;

    /* renamed from: f  reason: collision with root package name */
    public View f16722f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16723g;

    /* renamed from: h  reason: collision with root package name */
    public int f16724h;

    /* renamed from: i  reason: collision with root package name */
    public float f16725i;
    public float j;
    public final NestedScrollingParentHelper k;
    public final NestedScrollingChildHelper l;
    public final int[] m;
    public final int[] n;
    public boolean o;
    public int p;
    public float q;
    public float r;
    public boolean s;
    public int t;
    public boolean u;
    public final DecelerateInterpolator v;
    public k w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BigdaySwipeRefreshLayout f16726e;

        public a(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16726e = bigdaySwipeRefreshLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f16726e.F) {
                    BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f16726e;
                    bigdaySwipeRefreshLayout.z = -bigdaySwipeRefreshLayout.C;
                }
                this.f16726e.F = false;
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.f16726e;
                bigdaySwipeRefreshLayout2.j(bigdaySwipeRefreshLayout2.p, bigdaySwipeRefreshLayout2.H, 200);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BigdaySwipeRefreshLayout f16727a;

        public b(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16727a = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        @SuppressLint({"NewApi"})
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f16727a;
                if (bigdaySwipeRefreshLayout.f16723g) {
                    bigdaySwipeRefreshLayout.A();
                    BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.f16727a;
                    bigdaySwipeRefreshLayout2.p = bigdaySwipeRefreshLayout2.w.getView().getTop();
                    return;
                }
                bigdaySwipeRefreshLayout.C();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements f.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BigdaySwipeRefreshLayout f16728a;

        public c(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16728a = bigdaySwipeRefreshLayout;
        }

        @Override // d.a.r0.r.f0.f.j
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f16728a.G = i2;
                this.f16728a.F = true;
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f16728a;
                bigdaySwipeRefreshLayout.p = (bigdaySwipeRefreshLayout.p - bigdaySwipeRefreshLayout.z) - bigdaySwipeRefreshLayout.G;
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.f16728a;
                bigdaySwipeRefreshLayout2.z = -bigdaySwipeRefreshLayout2.G;
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout3 = this.f16728a;
                bigdaySwipeRefreshLayout3.G(bigdaySwipeRefreshLayout3.z - bigdaySwipeRefreshLayout3.p, false);
            }
        }

        @Override // d.a.r0.r.f0.f.j
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f16728a.setRefreshing(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BigdaySwipeRefreshLayout f16729e;

        public d(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16729e = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                this.f16729e.setAnimationProgress(1.0f - f2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BigdaySwipeRefreshLayout f16730a;

        public e(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16730a = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f16730a.w.h();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BigdaySwipeRefreshLayout f16731a;

        public f(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16731a = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f16731a.I(null);
                this.f16731a.o();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BigdaySwipeRefreshLayout f16732e;

        public g(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16732e = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f16732e;
                if (bigdaySwipeRefreshLayout.w == null) {
                    return;
                }
                if (!bigdaySwipeRefreshLayout.D) {
                    i2 = bigdaySwipeRefreshLayout.A - Math.abs(bigdaySwipeRefreshLayout.z);
                } else {
                    i2 = bigdaySwipeRefreshLayout.A;
                }
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.f16732e;
                int i3 = bigdaySwipeRefreshLayout2.y;
                this.f16732e.G((i3 + ((int) ((i2 - i3) * f2))) - bigdaySwipeRefreshLayout2.w.getView().getTop(), false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BigdaySwipeRefreshLayout f16733e;

        public h(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16733e = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
            k kVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) || (kVar = (bigdaySwipeRefreshLayout = this.f16733e).w) == null) {
                return;
            }
            int i2 = bigdaySwipeRefreshLayout.y;
            this.f16733e.G((i2 + ((int) ((-i2) * f2))) - kVar.getView().getTop(), false);
        }
    }

    /* loaded from: classes5.dex */
    public class i extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BigdaySwipeRefreshLayout f16734e;

        public i(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16734e = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                this.f16734e.w(f2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BigdaySwipeRefreshLayout f16735e;

        public j(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16735e = bigdaySwipeRefreshLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f16735e.F) {
                this.f16735e.F = false;
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f16735e;
                bigdaySwipeRefreshLayout.z = -bigdaySwipeRefreshLayout.C;
                this.f16735e.requestLayout();
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.f16735e;
                bigdaySwipeRefreshLayout2.j(bigdaySwipeRefreshLayout2.p, bigdaySwipeRefreshLayout2.H, 200);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface k extends BdSwipeRefreshLayout.i {
        void f();

        void h();

        int i();

        void j();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-711581233, "Lcom/baidu/tieba/homepage/personalize/bigday/BigdaySwipeRefreshLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-711581233, "Lcom/baidu/tieba/homepage/personalize/bigday/BigdaySwipeRefreshLayout;");
                return;
            }
        }
        M = new int[]{16842766};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BigdaySwipeRefreshLayout(Context context) {
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

    @SuppressLint({"NewApi"})
    private void setColorViewAlpha(int i2) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65546, this, i2) == null) || (kVar = this.w) == null || kVar.getView() == null || this.w.getView().getBackground() == null) {
            return;
        }
        this.w.getView().getBackground().setAlpha(i2);
    }

    public final void A() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (kVar = this.w) == null) {
            return;
        }
        this.f16721e = 2;
        kVar.m();
    }

    public final void B() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (kVar = this.w) == null) {
            return;
        }
        this.f16721e = 1;
        kVar.d();
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            o();
            if (getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = this.E;
            }
            k kVar = this.w;
            if (kVar != null) {
                kVar.getView().setVisibility(8);
                k kVar2 = this.w;
                if (kVar2 instanceof d.a.r0.r.f0.f) {
                    ((d.a.r0.r.f0.f) kVar2).J();
                }
                setColorViewAlpha(255);
                G(this.z - this.p, true);
                this.p = -this.C;
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f16721e == 6) {
            if (getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = this.E;
            }
            j(this.p, null, 400);
            this.f16723g = false;
            this.f16721e = 4;
        }
    }

    public final void E(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            F(z, z2, null);
        }
    }

    public final void F(boolean z, boolean z2, f.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), iVar}) == null) || this.f16723g == z) {
            return;
        }
        q(z);
        n();
        this.f16723g = z;
        if (z) {
            h(this.p, this.H);
        } else {
            m(iVar);
        }
    }

    public void G(int i2, boolean z) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (kVar = this.w) == null) {
            return;
        }
        kVar.getView().bringToFront();
        ViewCompat.offsetTopAndBottom(this.w.getView(), i2);
        View view = this.f16722f;
        if (view != null) {
            ViewCompat.offsetTopAndBottom(view, i2);
        }
        this.p = this.w.getView().getTop();
        if (!z || Build.VERSION.SDK_INT >= 11) {
            return;
        }
        invalidate();
    }

    @SuppressLint({"NewApi"})
    public final void H(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            float f3 = this.r;
            int i2 = this.f16724h;
            if (f2 - f3 <= i2 || this.s) {
                return;
            }
            this.q = f3 + i2;
            this.s = true;
        }
    }

    public void I(Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, animationListener) == null) {
            d dVar = new d(this);
            this.B = dVar;
            dVar.setDuration(150L);
            this.B.setAnimationListener(animationListener);
            k kVar = this.w;
            if (kVar != null) {
                kVar.getView().clearAnimation();
                this.w.getView().startAnimation(this.B);
            }
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? this.l.dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.l.dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? this.l.dispatchNestedPreScroll(i2, i3, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? this.l.dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i2, i3)) == null) {
            int i4 = this.x;
            return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
        }
        return invokeII.intValue;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.k.getNestedScrollAxes() : invokeV.intValue;
    }

    public k getProgressView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.w : (k) invokeV.objValue;
    }

    public final void h(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048592, this, i2, animationListener) == null) || this.w == null) {
            return;
        }
        this.y = i2;
        this.I.reset();
        this.I.setDuration(200L);
        this.I.setInterpolator(this.v);
        if (animationListener != null) {
            this.I.setAnimationListener(animationListener);
        }
        if (this.w.getView().getVisibility() != 0) {
            this.w.getView().setVisibility(0);
        }
        this.w.getView().clearAnimation();
        this.w.getView().startAnimation(this.I);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    public final void i(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048594, this, i2, animationListener) == null) || this.w == null) {
            return;
        }
        this.y = i2;
        this.J.reset();
        this.J.setDuration(500L);
        this.J.setInterpolator(this.v);
        if (animationListener != null) {
            this.J.setAnimationListener(animationListener);
        }
        this.w.getView().clearAnimation();
        this.w.getView().startAnimation(this.J);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.l.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    public void j(int i2, Animation.AnimationListener animationListener, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), animationListener, Integer.valueOf(i3)}) == null) || this.w == null) {
            return;
        }
        this.y = i2;
        this.K.reset();
        this.K.setDuration(i3);
        this.K.setInterpolator(this.v);
        if (animationListener != null) {
            this.K.setAnimationListener(animationListener);
        }
        this.w.getView().clearAnimation();
        this.w.getView().startAnimation(this.K);
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? ViewCompat.canScrollVertically(this.f16722f, -1) : invokeV.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f16723g = false;
            j(this.p, new f(this), 200);
            if ((getLayoutParams() instanceof FrameLayout.LayoutParams) && ((FrameLayout.LayoutParams) getLayoutParams()).topMargin == 0) {
                ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = this.E;
            }
        }
    }

    public final void m(f.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, iVar) == null) || this.w == null) {
            return;
        }
        this.f16721e = 3;
        if (iVar != null && u()) {
            k kVar = this.w;
            if (kVar instanceof d.a.r0.r.f0.f) {
                ((d.a.r0.r.f0.f) kVar).R(iVar);
                setExecuteMsgAnimation(true);
                this.w.k();
                d.a.c.e.m.e.a().removeCallbacks(this.L);
                d.a.c.e.m.e.a().postDelayed(this.L, 3000L);
                return;
            }
        }
        setExecuteMsgAnimation(false);
        this.w.k();
        postDelayed(new a(this), this.w.getCompleteAnimTime());
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.f16722f == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                k kVar = this.w;
                if (kVar == null || !childAt.equals(kVar.getView())) {
                    this.f16722f = childAt;
                    return;
                }
            }
        }
    }

    public void o() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (kVar = this.w) == null) {
            return;
        }
        this.f16721e = 4;
        this.f16723g = false;
        kVar.getView().clearAnimation();
        this.w.onFinish();
        if (this.F) {
            int i2 = this.C;
            this.z = -i2;
            this.p = (this.p - i2) + this.G;
        }
        this.F = false;
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDetachedFromWindow();
            C();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int findPointerIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, motionEvent)) == null) {
            n();
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (this.u && actionMasked == 0) {
                this.u = false;
            }
            if (!isEnabled() || this.u || k() || this.o) {
                return false;
            }
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int i2 = this.t;
                        if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) < 0) {
                            return false;
                        }
                        H(motionEvent.getY(findPointerIndex));
                    } else if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            x(motionEvent);
                        }
                    }
                }
                this.s = false;
                this.t = -1;
            } else {
                int pointerId = motionEvent.getPointerId(0);
                this.t = pointerId;
                this.s = false;
                int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
                if (findPointerIndex2 < 0) {
                    return false;
                }
                this.r = motionEvent.getY(findPointerIndex2);
            }
            return this.s;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingTop;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (getChildCount() == 0) {
                return;
            }
            if (this.f16722f == null) {
                n();
            }
            View view = this.f16722f;
            if (view == null) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            if (this.F) {
                paddingTop = getPaddingTop() + this.G;
            } else {
                paddingTop = (getPaddingTop() + this.p) - this.z;
            }
            view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
            k kVar = this.w;
            if (kVar != null) {
                int measuredWidth2 = kVar.getView().getMeasuredWidth();
                int measuredHeight2 = this.w.getView().getMeasuredHeight();
                k kVar2 = this.w;
                if (kVar2 != null) {
                    if (this.F) {
                        kVar2.getView().layout(paddingLeft, 0, measuredWidth2 + paddingLeft, measuredHeight2);
                        return;
                    }
                    View view2 = kVar2.getView();
                    int i6 = this.p;
                    view2.layout(paddingLeft, i6, measuredWidth2 + paddingLeft, measuredHeight2 + i6);
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048605, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (this.f16722f == null) {
                n();
            }
            View view = this.f16722f;
            if (view == null) {
                return;
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            k kVar = this.w;
            if (kVar != null) {
                if (this.F) {
                    kVar.getView().measure(View.MeasureSpec.makeMeasureSpec(l.k(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(this.G, 1073741824));
                    this.z = -this.G;
                } else {
                    kVar.getView().measure(View.MeasureSpec.makeMeasureSpec(l.k(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(this.C, 1073741824));
                    this.z = -this.C;
                }
                this.x = -1;
                for (int i4 = 0; i4 < getChildCount(); i4++) {
                    if (getChildAt(i4) == this.w.getView()) {
                        this.x = i4;
                        return;
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
            int i3 = this.f16721e;
            if ((i3 == 3 || i3 == 2) && f3 > 0.0f && (i2 = this.p) > this.z) {
                j(i2, null, 200);
            }
            return dispatchNestedFling(f2, f3, z);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            int i2 = this.f16721e;
            if (i2 == 3 || i2 == 2 || (kVar = this.w) == null || kVar.getView() == null || this.w.getView().getBottom() <= 0) {
                return dispatchNestedPreFling(f2, f3);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) {
            if (i3 > 0) {
                float f2 = this.j;
                if (f2 > 0.0f) {
                    float f3 = i3;
                    if (f3 > f2) {
                        iArr[1] = i3 - ((int) f2);
                        this.j = 0.0f;
                    } else {
                        this.j = f2 - f3;
                        iArr[1] = i3;
                    }
                    v(this.j);
                }
            }
            if (this.w != null && this.D && i3 > 0 && this.j == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
                this.w.getView().setVisibility(8);
            }
            int[] iArr2 = this.m;
            if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
                iArr[0] = iArr[0] + iArr2[0];
                iArr[1] = iArr[1] + iArr2[1];
            }
            int i4 = i3 - iArr[1];
            if ((t() || this.f16721e == 3) && Math.abs(i4) > 0) {
                if ((i4 <= 0 || this.p <= this.z) && (i4 >= 0 || this.p >= this.z + this.A || k())) {
                    return;
                }
                v(Math.max(Math.min(this.A, (this.p - this.z) - i4), 0.0f));
                iArr[1] = iArr[1] + i4;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            dispatchNestedScroll(i2, i3, i4, i5, this.n);
            int i6 = i5 + this.n[1];
            if (i6 >= 0 || k() || this.f16723g) {
                return;
            }
            float abs = this.j + Math.abs(i6);
            this.j = abs;
            v(abs);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048610, this, view, view2, i2) == null) {
            this.k.onNestedScrollAccepted(view, view2, i2);
            startNestedScroll(i2 & 2);
            this.j = 0.0f;
            this.o = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048611, this, view, view2, i2)) == null) ? (!isEnabled() || this.u || (i2 & 2) == 0) ? false : true : invokeLLI.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, view) == null) {
            this.k.onStopNestedScroll(view);
            this.o = false;
            float f2 = this.j;
            if (f2 > 0.0f) {
                p(f2);
                this.j = 0.0f;
            }
            stopNestedScroll();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, motionEvent)) == null) {
            if (this.w.getView().getAnimation() != null && !this.w.getView().getAnimation().hasEnded()) {
                return super.onTouchEvent(motionEvent);
            }
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (this.u && actionMasked == 0) {
                this.u = false;
            }
            if (!isEnabled() || this.u || k() || this.f16723g || this.o) {
                return false;
            }
            if (actionMasked == 0) {
                this.t = motionEvent.getPointerId(0);
                this.s = false;
            } else if (actionMasked == 1) {
                int findPointerIndex = motionEvent.findPointerIndex(this.t);
                if (findPointerIndex < 0) {
                    return false;
                }
                if (this.s) {
                    this.s = false;
                    p((motionEvent.getY(findPointerIndex) - this.q) * 0.5f);
                }
                this.t = -1;
                return false;
            } else if (actionMasked == 2) {
                int findPointerIndex2 = motionEvent.findPointerIndex(this.t);
                if (findPointerIndex2 < 0) {
                    return false;
                }
                float y = motionEvent.getY(findPointerIndex2);
                H(y);
                if (this.s) {
                    float f2 = (y - this.q) * 0.5f;
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    v(f2);
                }
            } else if (actionMasked == 3) {
                return false;
            } else {
                if (actionMasked == 5) {
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    if (actionIndex < 0) {
                        return false;
                    }
                    this.t = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    x(motionEvent);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void p(float f2) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048614, this, f2) == null) || (kVar = this.w) == null) {
            return;
        }
        if (kVar.i() > 0 && this.p - this.z > this.w.i()) {
            this.f16721e = 6;
            this.w.j();
            ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = 0;
            this.f16723g = false;
            i(this.p, new e(this));
        } else if (this.p - this.z > this.A) {
            E(true, true);
        } else {
            l();
        }
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z) == null) && z && this.w != null) {
            if (this.F) {
                this.z = -this.C;
            }
            this.F = false;
            if (u()) {
                k kVar = this.w;
                if (kVar instanceof d.a.r0.r.f0.f) {
                    ((d.a.r0.r.f0.f) kVar).J();
                }
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            n();
            this.f16723g = false;
            w(1.0f);
            C();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 21 || !(this.f16722f instanceof AbsListView)) {
                View view = this.f16722f;
                if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                    super.requestDisallowInterceptTouchEvent(z);
                }
            }
        }
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? Build.VERSION.SDK_INT < 11 : invokeV.booleanValue;
    }

    public void setAnimationProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f2) == null) {
            if (s()) {
                setColorViewAlpha((int) (f2 * 255.0f));
                return;
            }
            k kVar = this.w;
            if (kVar != null) {
                ViewCompat.setScaleX(kVar.getView(), f2);
                ViewCompat.setScaleY(this.w.getView(), f2);
            }
        }
    }

    public void setCustomDistances(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048620, this, i2, i3, i4) == null) {
            this.f16725i = i3;
            this.A = i2;
            this.C = i4;
            int i5 = -i4;
            this.p = i5;
            this.z = i5;
            w(1.0f);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            super.setEnabled(z);
            if (z) {
                return;
            }
            C();
        }
    }

    public void setExecuteMsgAnimation(boolean z) {
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048622, this, z) == null) && (kVar = this.w) != null && (kVar instanceof d.a.r0.r.f0.f)) {
            ((d.a.r0.r.f0.f) kVar).P(z);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.l.setNestedScrollingEnabled(z);
        }
    }

    public void setProgressView(k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, kVar) == null) || kVar == null || kVar.getView() == null || kVar == this.w) {
            return;
        }
        int i2 = this.f16721e;
        if (i2 == 4 || i2 == 6) {
            k kVar2 = this.w;
            if (kVar2 != null) {
                removeView(kVar2.getView());
            }
            this.w = kVar;
            kVar.getView().setVisibility(8);
            addView(this.w.getView(), 0);
            if (kVar instanceof d.a.s0.e1.h.i.a) {
                ((d.a.s0.e1.h.i.a) kVar).T(new c(this));
            }
        }
    }

    public void setRefreshing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            E(z, false);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i2)) == null) ? this.l.startNestedScroll(i2) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.l.stopNestedScroll();
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.f16723g : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            k kVar = this.w;
            if (kVar != null && (kVar instanceof d.a.r0.r.f0.f)) {
                return ((d.a.r0.r.f0.f) kVar).N();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public final void v(float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048630, this, f2) == null) || this.w == null) {
            return;
        }
        float min = Math.min(1.0f, Math.abs(f2 / this.f16725i));
        Math.max(min - 0.4d, 0.0d);
        float abs = Math.abs(f2) - this.f16725i;
        int i3 = this.A;
        if (this.w.i() > 0) {
            i3 = this.w.i();
        }
        if (this.D) {
            i3 -= this.z;
        }
        float f3 = i3;
        double max = Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f;
        float pow = ((float) (max - Math.pow(max, 2.0d))) * 2.0f;
        int i4 = this.z + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
        if (this.w.getView().getVisibility() != 0) {
            this.w.getView().setVisibility(0);
        }
        ViewCompat.setScaleX(this.w.getView(), 1.0f);
        ViewCompat.setScaleY(this.w.getView(), 1.0f);
        if (!this.f16723g && (i2 = this.f16721e) != 3 && i2 != 6) {
            int i5 = this.z;
            int i6 = this.p;
            if (i5 < i6) {
                if (i6 - i5 < this.A) {
                    if (i2 != 0) {
                        y();
                    }
                } else if (this.w.i() > 0 && this.p - this.z > this.w.i()) {
                    this.f16721e = 5;
                    this.w.f();
                } else if (this.f16721e != 1) {
                    B();
                }
            }
            this.w.e((this.p - this.z) / this.A, pow);
        }
        G(i4 - this.p, true);
    }

    public void w(float f2) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048631, this, f2) == null) || (kVar = this.w) == null) {
            return;
        }
        int i2 = this.y;
        G((i2 + ((int) ((this.z - i2) * f2))) - kVar.getView().getTop(), false);
    }

    public final void x(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (motionEvent.getPointerId(actionIndex) == this.t) {
                this.t = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
            }
        }
    }

    public final void y() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || (kVar = this.w) == null) {
            return;
        }
        this.f16721e = 0;
        kVar.c();
    }

    public void z(f.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, iVar) == null) {
            if (iVar == null) {
                setRefreshing(false);
            } else if (!u()) {
                setRefreshing(false);
            } else {
                F(false, false, iVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigdaySwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f16721e = 4;
        this.f16723g = false;
        this.f16725i = -1.0f;
        this.m = new int[2];
        this.n = new int[2];
        this.t = -1;
        this.x = -1;
        this.F = false;
        this.H = new b(this);
        this.I = new g(this);
        this.J = new h(this);
        this.K = new i(this);
        this.L = new j(this);
        this.f16724h = ViewConfiguration.get(context).getScaledTouchSlop();
        this.v = new DecelerateInterpolator(2.0f);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.k = new NestedScrollingParentHelper(this);
        this.l = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, M);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        this.E = 0;
    }
}
