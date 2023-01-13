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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.bh;
import com.baidu.tieba.j97;
import com.baidu.tieba.lz4;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BigdaySwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] I;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public int C;
    public Animation.AnimationListener D;
    public final Animation E;
    public final Animation F;
    public final Animation G;
    public Runnable H;
    public int a;
    public View b;
    public boolean c;
    public int d;
    public float e;
    public float f;
    public final NestedScrollingParentHelper g;
    public final NestedScrollingChildHelper h;
    public final int[] i;
    public final int[] j;
    public boolean k;
    public int l;
    public float m;
    public float n;
    public boolean o;
    public int p;
    public boolean q;
    public final DecelerateInterpolator r;
    public k s;
    public int t;
    public int u;
    public int v;
    public int w;
    public Animation x;
    public int y;
    public boolean z;

    /* loaded from: classes4.dex */
    public interface k extends BdSwipeRefreshLayout.i {
        void h();

        void i();

        int j();

        void l();
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BigdaySwipeRefreshLayout a;

        public a(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bigdaySwipeRefreshLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.B) {
                    BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
                    bigdaySwipeRefreshLayout.v = -bigdaySwipeRefreshLayout.y;
                }
                this.a.B = false;
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.a;
                bigdaySwipeRefreshLayout2.j(bigdaySwipeRefreshLayout2.l, bigdaySwipeRefreshLayout2.D, 200);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BigdaySwipeRefreshLayout a;

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

        public b(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        @SuppressLint({"NewApi"})
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
                if (!bigdaySwipeRefreshLayout.c) {
                    bigdaySwipeRefreshLayout.C();
                    return;
                }
                bigdaySwipeRefreshLayout.A();
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.a;
                bigdaySwipeRefreshLayout2.l = bigdaySwipeRefreshLayout2.s.getView().getTop();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements lz4.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;
        public final /* synthetic */ BigdaySwipeRefreshLayout b;

        public c(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bigdaySwipeRefreshLayout;
            this.a = kVar;
        }

        @Override // com.baidu.tieba.lz4.j
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.b.C = i;
            this.b.B = true;
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.b;
            bigdaySwipeRefreshLayout.l = (bigdaySwipeRefreshLayout.l - bigdaySwipeRefreshLayout.v) - bigdaySwipeRefreshLayout.C;
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.b;
            bigdaySwipeRefreshLayout2.v = -bigdaySwipeRefreshLayout2.C;
            if (this.a.getView() != null) {
                this.a.getView().clearAnimation();
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout3 = this.b;
            bigdaySwipeRefreshLayout3.G(bigdaySwipeRefreshLayout3.v - bigdaySwipeRefreshLayout3.l, false);
        }

        @Override // com.baidu.tieba.lz4.j
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.setRefreshing(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BigdaySwipeRefreshLayout a;

        public d(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), transformation}) == null) {
                this.a.setAnimationProgress(1.0f - f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BigdaySwipeRefreshLayout a;

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

        public e(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.s.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BigdaySwipeRefreshLayout a;

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

        public f(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.I(null);
                this.a.o();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BigdaySwipeRefreshLayout a;

        public g(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), transformation}) == null) {
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
                if (bigdaySwipeRefreshLayout.s == null) {
                    return;
                }
                if (!bigdaySwipeRefreshLayout.z) {
                    i = bigdaySwipeRefreshLayout.w - Math.abs(bigdaySwipeRefreshLayout.v);
                } else {
                    i = bigdaySwipeRefreshLayout.w;
                }
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.a;
                int i2 = bigdaySwipeRefreshLayout2.u;
                this.a.G((i2 + ((int) ((i - i2) * f))) - bigdaySwipeRefreshLayout2.s.getView().getTop(), false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BigdaySwipeRefreshLayout a;

        public h(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
            k kVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), transformation}) != null) || (kVar = (bigdaySwipeRefreshLayout = this.a).s) == null) {
                return;
            }
            int i = bigdaySwipeRefreshLayout.u;
            this.a.G((i + ((int) ((-i) * f))) - kVar.getView().getTop(), false);
        }
    }

    /* loaded from: classes4.dex */
    public class i extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BigdaySwipeRefreshLayout a;

        public i(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), transformation}) == null) {
                this.a.w(f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BigdaySwipeRefreshLayout a;

        public j(BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bigdaySwipeRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bigdaySwipeRefreshLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.B) {
                return;
            }
            this.a.B = false;
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
            bigdaySwipeRefreshLayout.v = -bigdaySwipeRefreshLayout.y;
            this.a.requestLayout();
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.a;
            bigdaySwipeRefreshLayout2.j(bigdaySwipeRefreshLayout2.l, bigdaySwipeRefreshLayout2.D, 200);
        }
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
        I = new int[]{16842766};
    }

    public final void A() {
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (kVar = this.s) != null) {
            this.a = 2;
            kVar.e();
        }
    }

    public final void B() {
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (kVar = this.s) != null) {
            this.a = 1;
            kVar.b();
        }
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g.getNestedScrollAxes();
        }
        return invokeV.intValue;
    }

    public k getProgressView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.s;
        }
        return (k) invokeV.objValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.h.hasNestedScrollingParent();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.h.isNestedScrollingEnabled();
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return ViewCompat.canScrollVertically(this.b, -1);
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onDetachedFromWindow();
            C();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            n();
            this.c = false;
            w(1.0f);
            C();
        }
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (Build.VERSION.SDK_INT < 11) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.h.stopNestedScroll();
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            k kVar = this.s;
            if (kVar == null || !(kVar instanceof lz4)) {
                return false;
            }
            return ((lz4) kVar).O();
        }
        return invokeV.booleanValue;
    }

    public final void y() {
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && (kVar = this.s) != null) {
            this.a = 0;
            kVar.a();
        }
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
        if ((interceptable == null || interceptable.invokeI(65546, this, i2) == null) && (kVar = this.s) != null && kVar.getView() != null && this.s.getView().getBackground() != null) {
            this.s.getView().getBackground().setAlpha(i2);
        }
    }

    public void I(Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, animationListener) == null) {
            d dVar = new d(this);
            this.x = dVar;
            dVar.setDuration(150L);
            this.x.setAnimationListener(animationListener);
            k kVar = this.s;
            if (kVar != null) {
                kVar.getView().clearAnimation();
                this.s.getView().startAnimation(this.x);
            }
        }
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048615, this, z) != null) || !z || this.s == null) {
            return;
        }
        if (this.B) {
            this.v = -this.y;
        }
        this.B = false;
        if (u()) {
            k kVar = this.s;
            if (kVar instanceof lz4) {
                ((lz4) kVar).I();
            }
        }
    }

    public void setAnimationProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f2) == null) {
            if (s()) {
                setColorViewAlpha((int) (f2 * 255.0f));
                return;
            }
            k kVar = this.s;
            if (kVar != null) {
                ViewCompat.setScaleX(kVar.getView(), f2);
                ViewCompat.setScaleY(this.s.getView(), f2);
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
        this.a = 4;
        this.c = false;
        this.e = -1.0f;
        this.i = new int[2];
        this.j = new int[2];
        this.p = -1;
        this.t = -1;
        this.B = false;
        this.D = new b(this);
        this.E = new g(this);
        this.F = new h(this);
        this.G = new i(this);
        this.H = new j(this);
        this.d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.r = new DecelerateInterpolator(2.0f);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.g = new NestedScrollingParentHelper(this);
        this.h = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        this.A = 0;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048605, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (this.b == null) {
                n();
            }
            View view2 = this.b;
            if (view2 == null) {
                return;
            }
            view2.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            k kVar = this.s;
            if (kVar != null) {
                if (this.B) {
                    kVar.getView().measure(View.MeasureSpec.makeMeasureSpec(zi.l(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(this.C, 1073741824));
                    this.v = -this.C;
                } else {
                    kVar.getView().measure(View.MeasureSpec.makeMeasureSpec(zi.l(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(this.y, 1073741824));
                    this.v = -this.y;
                }
                this.t = -1;
                for (int i4 = 0; i4 < getChildCount(); i4++) {
                    if (getChildAt(i4) == this.s.getView()) {
                        this.t = i4;
                        return;
                    }
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void H(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            float f3 = this.n;
            int i2 = this.d;
            if (f2 - f3 > i2 && !this.o) {
                this.m = f3 + i2;
                this.o = true;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, view2) == null) {
            this.g.onStopNestedScroll(view2);
            this.k = false;
            float f2 = this.f;
            if (f2 > 0.0f) {
                p(f2);
                this.f = 0.0f;
            }
            stopNestedScroll();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 21 || !(this.b instanceof AbsListView)) {
                View view2 = this.b;
                if (view2 == null || ViewCompat.isNestedScrollingEnabled(view2)) {
                    super.requestDisallowInterceptTouchEvent(z);
                }
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            super.setEnabled(z);
            if (!z) {
                C();
            }
        }
    }

    public void setExecuteMsgAnimation(boolean z) {
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048622, this, z) == null) && (kVar = this.s) != null && (kVar instanceof lz4)) {
            ((lz4) kVar).Q(z);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.h.setNestedScrollingEnabled(z);
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i2)) == null) {
            return this.h.startNestedScroll(i2);
        }
        return invokeI.booleanValue;
    }

    public void w(float f2) {
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048631, this, f2) != null) || (kVar = this.s) == null) {
            return;
        }
        int i2 = this.u;
        G((i2 + ((int) ((this.v - i2) * f2))) - kVar.getView().getTop(), false);
    }

    public final void x(MotionEvent motionEvent) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (motionEvent.getPointerId(actionIndex) == this.p) {
                if (actionIndex == 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                this.p = motionEvent.getPointerId(i2);
            }
        }
    }

    public void z(lz4.i iVar) {
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

    public final void E(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            F(z, z2, null);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            return this.h.dispatchNestedPreFling(f2, f3);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i2, i3)) == null) {
            int i4 = this.t;
            if (i4 < 0) {
                return i3;
            }
            if (i3 == i2 - 1) {
                return i4;
            }
            if (i3 >= i4) {
                return i3 + 1;
            }
            return i3;
        }
        return invokeII.intValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            o();
            if (getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = this.A;
            }
            k kVar = this.s;
            if (kVar != null) {
                kVar.getView().setVisibility(8);
                k kVar2 = this.s;
                if (kVar2 instanceof lz4) {
                    ((lz4) kVar2).I();
                }
                setColorViewAlpha(255);
                G(this.v - this.l, true);
                this.l = -this.y;
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a == 6) {
            if (getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = this.A;
            }
            j(this.l, null, 400);
            this.c = false;
            this.a = 4;
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.c = false;
            j(this.l, new f(this), 200);
            if ((getLayoutParams() instanceof FrameLayout.LayoutParams) && ((FrameLayout.LayoutParams) getLayoutParams()).topMargin == 0) {
                ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = this.A;
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.b == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                k kVar = this.s;
                if (kVar == null || !childAt.equals(kVar.getView())) {
                    this.b = childAt;
                    return;
                }
            }
        }
    }

    public void o() {
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (kVar = this.s) != null) {
            this.a = 4;
            this.c = false;
            kVar.getView().clearAnimation();
            this.s.onFinish();
            if (this.B) {
                int i2 = this.y;
                this.v = -i2;
                this.l = (this.l - i2) + this.C;
            }
            this.B = false;
            requestLayout();
        }
    }

    public final void F(boolean z, boolean z2, lz4.i iVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), iVar}) == null) && this.c != z) {
            q(z);
            n();
            this.c = z;
            if (z) {
                h(this.l, this.D);
            } else {
                m(iVar);
            }
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
            return this.h.dispatchNestedFling(f2, f3, z);
        }
        return invokeCommon.booleanValue;
    }

    public void G(int i2, boolean z) {
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) != null) || (kVar = this.s) == null) {
            return;
        }
        kVar.getView().bringToFront();
        ViewCompat.offsetTopAndBottom(this.s.getView(), i2);
        View view2 = this.b;
        if (view2 != null) {
            ViewCompat.offsetTopAndBottom(view2, i2);
        }
        this.l = this.s.getView().getTop();
        if (z && Build.VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    public final void h(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048592, this, i2, animationListener) != null) || this.s == null) {
            return;
        }
        this.u = i2;
        this.E.reset();
        this.E.setDuration(200L);
        this.E.setInterpolator(this.r);
        if (animationListener != null) {
            this.E.setAnimationListener(animationListener);
        }
        if (this.s.getView().getVisibility() != 0) {
            this.s.getView().setVisibility(0);
        }
        this.s.getView().clearAnimation();
        this.s.getView().startAnimation(this.E);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) {
            return this.h.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) {
            return this.h.dispatchNestedScroll(i2, i3, i4, i5, iArr);
        }
        return invokeCommon.booleanValue;
    }

    public final void i(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048594, this, i2, animationListener) != null) || this.s == null) {
            return;
        }
        this.u = i2;
        this.F.reset();
        this.F.setDuration(500L);
        this.F.setInterpolator(this.r);
        if (animationListener != null) {
            this.F.setAnimationListener(animationListener);
        }
        this.s.getView().clearAnimation();
        this.s.getView().startAnimation(this.F);
    }

    public void j(int i2, Animation.AnimationListener animationListener, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), animationListener, Integer.valueOf(i3)}) != null) || this.s == null) {
            return;
        }
        this.u = i2;
        this.G.reset();
        this.G.setDuration(i3);
        this.G.setInterpolator(this.r);
        if (animationListener != null) {
            this.G.setAnimationListener(animationListener);
        }
        this.s.getView().clearAnimation();
        this.s.getView().startAnimation(this.G);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view2, float f2, float f3) {
        InterceptResult invokeCommon;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{view2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            int i2 = this.a;
            if (i2 != 3 && i2 != 2 && (kVar = this.s) != null && kVar.getView() != null && this.s.getView().getBottom() > 0) {
                return true;
            }
            return dispatchNestedPreFling(f2, f3);
        }
        return invokeCommon.booleanValue;
    }

    public final void m(lz4.i iVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, iVar) == null) && this.s != null) {
            this.a = 3;
            if (iVar != null && u()) {
                k kVar = this.s;
                if (kVar instanceof lz4) {
                    ((lz4) kVar).S(iVar);
                    setExecuteMsgAnimation(true);
                    this.s.d();
                    bh.a().removeCallbacks(this.H);
                    bh.a().postDelayed(this.H, 3000L);
                    return;
                }
            }
            setExecuteMsgAnimation(false);
            this.s.d();
            postDelayed(new a(this), this.s.getCompleteAnimTime());
        }
    }

    public final void p(float f2) {
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048614, this, f2) != null) || (kVar = this.s) == null) {
            return;
        }
        if (kVar.j() > 0 && this.l - this.v > this.s.j()) {
            this.a = 6;
            this.s.l();
            ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = 0;
            this.c = false;
            i(this.l, new e(this));
        } else if (this.l - this.v > this.w) {
            E(true, true);
        } else {
            l();
        }
    }

    public void setProgressView(k kVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, kVar) == null) && kVar != null && kVar.getView() != null && kVar != this.s) {
            int i2 = this.a;
            if (i2 != 4 && i2 != 6) {
                return;
            }
            k kVar2 = this.s;
            if (kVar2 != null) {
                removeView(kVar2.getView());
            }
            this.s = kVar;
            kVar.getView().setVisibility(8);
            addView(this.s.getView(), 0);
            if (kVar instanceof j97) {
                ((j97) kVar).U(new c(this, kVar));
            }
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
            if (this.q && actionMasked == 0) {
                this.q = false;
            }
            if (!isEnabled() || this.q || k() || this.k) {
                return false;
            }
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked == 6) {
                                x(motionEvent);
                            }
                        }
                    } else {
                        int i2 = this.p;
                        if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) < 0) {
                            return false;
                        }
                        H(motionEvent.getY(findPointerIndex));
                    }
                }
                this.o = false;
                this.p = -1;
            } else {
                int pointerId = motionEvent.getPointerId(0);
                this.p = pointerId;
                this.o = false;
                int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
                if (findPointerIndex2 < 0) {
                    return false;
                }
                this.n = motionEvent.getY(findPointerIndex2);
            }
            return this.o;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingTop;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            boolean z2 = TbSingleton.getInstance().mIsForceLayoutMaintab;
            TbSingleton.getInstance().mIsForceLayoutMaintab = false;
            if (!(getContext() instanceof TbadkCoreApplication) && getContext() != TbadkApplication.getInst().getCurrentActivity() && TbadkApplication.getInst().getCurrentActivity() != null && !z2) {
                return;
            }
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (getChildCount() == 0) {
                return;
            }
            if (this.b == null) {
                n();
            }
            View view2 = this.b;
            if (view2 == null) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            if (this.B) {
                paddingTop = getPaddingTop() + this.C;
            } else {
                paddingTop = (getPaddingTop() + this.l) - this.v;
            }
            view2.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
            k kVar = this.s;
            if (kVar != null) {
                int measuredWidth2 = kVar.getView().getMeasuredWidth();
                int measuredHeight2 = this.s.getView().getMeasuredHeight();
                k kVar2 = this.s;
                if (kVar2 != null) {
                    if (this.B) {
                        kVar2.getView().layout(paddingLeft, 0, measuredWidth2 + paddingLeft, measuredHeight2);
                        return;
                    }
                    View view3 = kVar2.getView();
                    int i6 = this.l;
                    view3.layout(paddingLeft, i6, measuredWidth2 + paddingLeft, measuredHeight2 + i6);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view2, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{view2, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
            int i3 = this.a;
            if ((i3 == 3 || i3 == 2) && f3 > 0.0f && (i2 = this.l) > this.v) {
                j(i2, null, 200);
            }
            return dispatchNestedFling(f2, f3, z);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view2, int i2, int i3, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) {
            if (i3 > 0) {
                float f2 = this.f;
                if (f2 > 0.0f) {
                    float f3 = i3;
                    if (f3 > f2) {
                        iArr[1] = i3 - ((int) f2);
                        this.f = 0.0f;
                    } else {
                        this.f = f2 - f3;
                        iArr[1] = i3;
                    }
                    v(this.f);
                }
            }
            if (this.s != null && this.z && i3 > 0 && this.f == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
                this.s.getView().setVisibility(8);
            }
            int[] iArr2 = this.i;
            if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
                iArr[0] = iArr[0] + iArr2[0];
                iArr[1] = iArr[1] + iArr2[1];
            }
            int i4 = i3 - iArr[1];
            if ((t() || this.a == 3) && Math.abs(i4) > 0) {
                if ((i4 > 0 && this.l > this.v) || (i4 < 0 && this.l < this.v + this.w && !k())) {
                    v(Math.max(Math.min(this.w, (this.l - this.v) - i4), 0.0f));
                    iArr[1] = iArr[1] + i4;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view2, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            dispatchNestedScroll(i2, i3, i4, i5, this.j);
            int i6 = i5 + this.j[1];
            if (i6 < 0 && !k() && !this.c) {
                float abs = this.f + Math.abs(i6);
                this.f = abs;
                v(abs);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view2, View view3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048610, this, view2, view3, i2) == null) {
            this.g.onNestedScrollAccepted(view2, view3, i2);
            startNestedScroll(i2 & 2);
            this.f = 0.0f;
            this.k = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view2, View view3, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048611, this, view2, view3, i2)) == null) {
            if (isEnabled() && !this.q && (i2 & 2) != 0) {
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public void setCustomDistances(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048620, this, i2, i3, i4) == null) {
            this.e = i3;
            this.w = i2;
            this.y = i4;
            int i5 = -i4;
            this.l = i5;
            this.v = i5;
            w(1.0f);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, motionEvent)) == null) {
            if (this.s.getView().getAnimation() != null && !this.s.getView().getAnimation().hasEnded()) {
                return super.onTouchEvent(motionEvent);
            }
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (this.q && actionMasked == 0) {
                this.q = false;
            }
            if (!isEnabled() || this.q || k() || this.c || this.k) {
                return false;
            }
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked == 3) {
                            return false;
                        }
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                x(motionEvent);
                            }
                        } else {
                            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                            if (actionIndex < 0) {
                                return false;
                            }
                            this.p = motionEvent.getPointerId(actionIndex);
                        }
                    } else {
                        int findPointerIndex = motionEvent.findPointerIndex(this.p);
                        if (findPointerIndex < 0) {
                            return false;
                        }
                        float y = motionEvent.getY(findPointerIndex);
                        H(y);
                        if (this.o) {
                            float f2 = (y - this.m) * 0.5f;
                            if (f2 <= 0.0f) {
                                return false;
                            }
                            v(f2);
                        }
                    }
                } else {
                    int findPointerIndex2 = motionEvent.findPointerIndex(this.p);
                    if (findPointerIndex2 < 0) {
                        return false;
                    }
                    if (this.o) {
                        this.o = false;
                        p((motionEvent.getY(findPointerIndex2) - this.m) * 0.5f);
                    }
                    this.p = -1;
                    return false;
                }
            } else {
                this.p = motionEvent.getPointerId(0);
                this.o = false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public final void v(float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048630, this, f2) != null) || this.s == null) {
            return;
        }
        float min = Math.min(1.0f, Math.abs(f2 / this.e));
        Math.max(min - 0.4d, 0.0d);
        float abs = Math.abs(f2) - this.e;
        int i3 = this.w;
        if (this.s.j() > 0) {
            i3 = this.s.j();
        }
        if (this.z) {
            i3 -= this.v;
        }
        float f3 = i3;
        double max = Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f;
        float pow = ((float) (max - Math.pow(max, 2.0d))) * 2.0f;
        int i4 = this.v + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
        if (this.s.getView().getVisibility() != 0) {
            this.s.getView().setVisibility(0);
        }
        ViewCompat.setScaleX(this.s.getView(), 1.0f);
        ViewCompat.setScaleY(this.s.getView(), 1.0f);
        if (!this.c && (i2 = this.a) != 3 && i2 != 6) {
            int i5 = this.v;
            int i6 = this.l;
            if (i5 < i6) {
                if (i6 - i5 < this.w) {
                    if (i2 != 0) {
                        y();
                    }
                } else if (this.s.j() > 0 && this.l - this.v > this.s.j()) {
                    this.a = 5;
                    this.s.h();
                } else if (this.a != 1) {
                    B();
                }
            }
            this.s.c((this.l - this.v) / this.w, pow);
        }
        G(i4 - this.l, true);
    }
}
