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
import c.a.d.f.p.n;
import c.a.q0.r.l0.f;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BigdaySwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FINISH = 4;
    public static final int[] K;
    public static final int LOADING_BIGDAY = 6;
    public static final int MSG_ANIMATION_DELAY_TIME = 3000;
    public static final int PULL_TO_REFRESH = 0;
    public static final int REFRESHED = 3;
    public static final int REFRESHING = 2;
    public static final int RELEASE_TO_BIGDAY = 5;
    public static final int RELEASE_TO_REFRESH = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public int C;
    public boolean D;
    public int E;
    public Animation.AnimationListener F;
    public final Animation G;
    public final Animation H;
    public final Animation I;
    public Runnable J;

    /* renamed from: e  reason: collision with root package name */
    public int f43019e;

    /* renamed from: f  reason: collision with root package name */
    public View f43020f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43021g;

    /* renamed from: h  reason: collision with root package name */
    public int f43022h;

    /* renamed from: i  reason: collision with root package name */
    public float f43023i;

    /* renamed from: j  reason: collision with root package name */
    public float f43024j;
    public final NestedScrollingParentHelper k;
    public final NestedScrollingChildHelper l;
    public final int[] m;
    public int mFrom;
    public int mOriginalOffsetTop;
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
    public Animation z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BigdaySwipeRefreshLayout f43025e;

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
            this.f43025e = bigdaySwipeRefreshLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f43025e.D) {
                    BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f43025e;
                    bigdaySwipeRefreshLayout.mOriginalOffsetTop = -bigdaySwipeRefreshLayout.A;
                }
                this.f43025e.D = false;
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.f43025e;
                bigdaySwipeRefreshLayout2.animateOffsetToStartPosition(bigdaySwipeRefreshLayout2.p, bigdaySwipeRefreshLayout2.F, 200);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BigdaySwipeRefreshLayout a;

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
            this.a = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        @SuppressLint({"NewApi"})
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
                if (bigdaySwipeRefreshLayout.f43021g) {
                    bigdaySwipeRefreshLayout.t();
                    BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.a;
                    bigdaySwipeRefreshLayout2.p = bigdaySwipeRefreshLayout2.w.getView().getTop();
                    return;
                }
                bigdaySwipeRefreshLayout.v();
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
        public final /* synthetic */ BigdaySwipeRefreshLayout a;

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
            this.a = bigdaySwipeRefreshLayout;
        }

        @Override // c.a.q0.r.l0.f.j
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.E = i2;
                this.a.D = true;
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.a;
                bigdaySwipeRefreshLayout.p = (bigdaySwipeRefreshLayout.p - bigdaySwipeRefreshLayout.mOriginalOffsetTop) - bigdaySwipeRefreshLayout.E;
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.a;
                bigdaySwipeRefreshLayout2.mOriginalOffsetTop = -bigdaySwipeRefreshLayout2.E;
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout3 = this.a;
                bigdaySwipeRefreshLayout3.y(bigdaySwipeRefreshLayout3.mOriginalOffsetTop - bigdaySwipeRefreshLayout3.p, false);
            }
        }

        @Override // c.a.q0.r.l0.f.j
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.setRefreshing(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BigdaySwipeRefreshLayout f43026e;

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
            this.f43026e = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                this.f43026e.setAnimationProgress(1.0f - f2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BigdaySwipeRefreshLayout a;

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
            this.a = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.w.d();
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
        public final /* synthetic */ BigdaySwipeRefreshLayout a;

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
            this.a = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.A(null);
                this.a.finish();
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
        public final /* synthetic */ BigdaySwipeRefreshLayout f43027e;

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
            this.f43027e = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f43027e;
                if (bigdaySwipeRefreshLayout.w == null) {
                    return;
                }
                if (!bigdaySwipeRefreshLayout.B) {
                    i2 = bigdaySwipeRefreshLayout.y - Math.abs(bigdaySwipeRefreshLayout.mOriginalOffsetTop);
                } else {
                    i2 = bigdaySwipeRefreshLayout.y;
                }
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.f43027e;
                int i3 = bigdaySwipeRefreshLayout2.mFrom;
                this.f43027e.y((i3 + ((int) ((i2 - i3) * f2))) - bigdaySwipeRefreshLayout2.w.getView().getTop(), false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BigdaySwipeRefreshLayout f43028e;

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
            this.f43028e = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
            k kVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) || (kVar = (bigdaySwipeRefreshLayout = this.f43028e).w) == null) {
                return;
            }
            int i2 = bigdaySwipeRefreshLayout.mFrom;
            this.f43028e.y((i2 + ((int) ((-i2) * f2))) - kVar.getView().getTop(), false);
        }
    }

    /* loaded from: classes5.dex */
    public class i extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BigdaySwipeRefreshLayout f43029e;

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
            this.f43029e = bigdaySwipeRefreshLayout;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                this.f43029e.q(f2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BigdaySwipeRefreshLayout f43030e;

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
            this.f43030e = bigdaySwipeRefreshLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f43030e.D) {
                this.f43030e.D = false;
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.f43030e;
                bigdaySwipeRefreshLayout.mOriginalOffsetTop = -bigdaySwipeRefreshLayout.A;
                this.f43030e.requestLayout();
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.f43030e;
                bigdaySwipeRefreshLayout2.animateOffsetToStartPosition(bigdaySwipeRefreshLayout2.p, bigdaySwipeRefreshLayout2.F, 200);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface k extends BdSwipeRefreshLayout.i {
        void c();

        void d();

        int e();

        void g();
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
        K = new int[]{16842766};
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

    public void A(Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animationListener) == null) {
            d dVar = new d(this);
            this.z = dVar;
            dVar.setDuration(150L);
            this.z.setAnimationListener(animationListener);
            k kVar = this.w;
            if (kVar != null) {
                kVar.getView().clearAnimation();
                this.w.getView().startAnimation(this.z);
            }
        }
    }

    public void animateOffsetToStartPosition(int i2, Animation.AnimationListener animationListener, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), animationListener, Integer.valueOf(i3)}) == null) || this.w == null) {
            return;
        }
        this.mFrom = i2;
        this.I.reset();
        this.I.setDuration(i3);
        this.I.setInterpolator(this.v);
        if (animationListener != null) {
            this.I.setAnimationListener(animationListener);
        }
        this.w.getView().clearAnimation();
        this.w.getView().startAnimation(this.I);
    }

    public boolean canChildScrollUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ViewCompat.canScrollVertically(this.f43020f, -1) : invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? this.l.dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.l.dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? this.l.dispatchNestedPreScroll(i2, i3, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? this.l.dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    public void finish() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (kVar = this.w) == null) {
            return;
        }
        this.f43019e = 4;
        this.f43021g = false;
        kVar.getView().clearAnimation();
        this.w.onFinish();
        if (this.D) {
            int i2 = this.A;
            this.mOriginalOffsetTop = -i2;
            this.p = (this.p - i2) + this.E;
        }
        this.D = false;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) {
            int i4 = this.x;
            return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
        }
        return invokeII.intValue;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k.getNestedScrollAxes() : invokeV.intValue;
    }

    public k getProgressView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.w : (k) invokeV.objValue;
    }

    public final void h(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048587, this, i2, animationListener) == null) || this.w == null) {
            return;
        }
        this.mFrom = i2;
        this.G.reset();
        this.G.setDuration(200L);
        this.G.setInterpolator(this.v);
        if (animationListener != null) {
            this.G.setAnimationListener(animationListener);
        }
        if (this.w.getView().getVisibility() != 0) {
            this.w.getView().setVisibility(0);
        }
        this.w.getView().clearAnimation();
        this.w.getView().startAnimation(this.G);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    public final void i(int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048589, this, i2, animationListener) == null) || this.w == null) {
            return;
        }
        this.mFrom = i2;
        this.H.reset();
        this.H.setDuration(500L);
        this.H.setInterpolator(this.v);
        if (animationListener != null) {
            this.H.setAnimationListener(animationListener);
        }
        this.w.getView().clearAnimation();
        this.w.getView().startAnimation(this.H);
    }

    public void interruptRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            l();
            this.f43021g = false;
            q(1.0f);
            v();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.l.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    public boolean isRefreshing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f43021g : invokeV.booleanValue;
    }

    public boolean isSupportMsgRemind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            k kVar = this.w;
            if (kVar != null && (kVar instanceof c.a.q0.r.l0.f)) {
                return ((c.a.q0.r.l0.f) kVar).I();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f43021g = false;
            animateOffsetToStartPosition(this.p, new f(this), 200);
            if ((getLayoutParams() instanceof FrameLayout.LayoutParams) && ((FrameLayout.LayoutParams) getLayoutParams()).topMargin == 0) {
                ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = this.C;
            }
        }
    }

    public final void k(f.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, iVar) == null) || this.w == null) {
            return;
        }
        this.f43019e = 3;
        if (iVar != null && isSupportMsgRemind()) {
            k kVar = this.w;
            if (kVar instanceof c.a.q0.r.l0.f) {
                ((c.a.q0.r.l0.f) kVar).M(iVar);
                setExecuteMsgAnimation(true);
                this.w.onCompleteRefresh();
                c.a.d.f.m.e.a().removeCallbacks(this.J);
                c.a.d.f.m.e.a().postDelayed(this.J, 3000L);
                return;
            }
        }
        setExecuteMsgAnimation(false);
        this.w.onCompleteRefresh();
        postDelayed(new a(this), this.w.getCompleteAnimTime());
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.f43020f == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                k kVar = this.w;
                if (kVar == null || !childAt.equals(kVar.getView())) {
                    this.f43020f = childAt;
                    return;
                }
            }
        }
    }

    public final void m(float f2) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048597, this, f2) == null) || (kVar = this.w) == null) {
            return;
        }
        if (kVar.e() > 0 && this.p - this.mOriginalOffsetTop > this.w.e()) {
            this.f43019e = 6;
            this.w.g();
            ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = 0;
            this.f43021g = false;
            i(this.p, new e(this));
        } else if (this.p - this.mOriginalOffsetTop > this.y) {
            w(true, true);
        } else {
            j();
        }
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048598, this, z) == null) && z && this.w != null) {
            if (this.D) {
                this.mOriginalOffsetTop = -this.A;
            }
            this.D = false;
            if (isSupportMsgRemind()) {
                k kVar = this.w;
                if (kVar instanceof c.a.q0.r.l0.f) {
                    ((c.a.q0.r.l0.f) kVar).D();
                }
            }
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? Build.VERSION.SDK_INT < 11 : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onDetachedFromWindow();
            v();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int findPointerIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, motionEvent)) == null) {
            l();
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (this.u && actionMasked == 0) {
                this.u = false;
            }
            if (!isEnabled() || this.u || canChildScrollUp() || this.o) {
                return false;
            }
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int i2 = this.t;
                        if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) < 0) {
                            return false;
                        }
                        z(motionEvent.getY(findPointerIndex));
                    } else if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            r(motionEvent);
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
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if ((getContext() instanceof TbadkCoreApplication) || getContext() == TbadkApplication.getInst().getCurrentActivity()) {
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                if (getChildCount() == 0) {
                    return;
                }
                if (this.f43020f == null) {
                    l();
                }
                View view = this.f43020f;
                if (view == null) {
                    return;
                }
                int paddingLeft = getPaddingLeft();
                if (this.D) {
                    paddingTop = getPaddingTop() + this.E;
                } else {
                    paddingTop = (getPaddingTop() + this.p) - this.mOriginalOffsetTop;
                }
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                k kVar = this.w;
                if (kVar != null) {
                    int measuredWidth2 = kVar.getView().getMeasuredWidth();
                    int measuredHeight2 = this.w.getView().getMeasuredHeight();
                    k kVar2 = this.w;
                    if (kVar2 != null) {
                        if (this.D) {
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
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048603, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (this.f43020f == null) {
                l();
            }
            View view = this.f43020f;
            if (view == null) {
                return;
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            k kVar = this.w;
            if (kVar != null) {
                if (this.D) {
                    kVar.getView().measure(View.MeasureSpec.makeMeasureSpec(n.k(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(this.E, 1073741824));
                    this.mOriginalOffsetTop = -this.E;
                } else {
                    kVar.getView().measure(View.MeasureSpec.makeMeasureSpec(n.k(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(this.A, 1073741824));
                    this.mOriginalOffsetTop = -this.A;
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
            int i3 = this.f43019e;
            if ((i3 == 3 || i3 == 2) && f3 > 0.0f && (i2 = this.p) > this.mOriginalOffsetTop) {
                animateOffsetToStartPosition(i2, null, 200);
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            int i2 = this.f43019e;
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
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) {
            if (i3 > 0) {
                float f2 = this.f43024j;
                if (f2 > 0.0f) {
                    float f3 = i3;
                    if (f3 > f2) {
                        iArr[1] = i3 - ((int) f2);
                        this.f43024j = 0.0f;
                    } else {
                        this.f43024j = f2 - f3;
                        iArr[1] = i3;
                    }
                    p(this.f43024j);
                }
            }
            if (this.w != null && this.B && i3 > 0 && this.f43024j == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
                this.w.getView().setVisibility(8);
            }
            int[] iArr2 = this.m;
            if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
                iArr[0] = iArr[0] + iArr2[0];
                iArr[1] = iArr[1] + iArr2[1];
            }
            int i4 = i3 - iArr[1];
            if ((isRefreshing() || this.f43019e == 3) && Math.abs(i4) > 0) {
                if ((i4 <= 0 || this.p <= this.mOriginalOffsetTop) && (i4 >= 0 || this.p >= this.mOriginalOffsetTop + this.y || canChildScrollUp())) {
                    return;
                }
                p(Math.max(Math.min(this.y, (this.p - this.mOriginalOffsetTop) - i4), 0.0f));
                iArr[1] = iArr[1] + i4;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            dispatchNestedScroll(i2, i3, i4, i5, this.n);
            int i6 = i5 + this.n[1];
            if (i6 >= 0 || canChildScrollUp() || this.f43021g) {
                return;
            }
            float abs = this.f43024j + Math.abs(i6);
            this.f43024j = abs;
            p(abs);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048608, this, view, view2, i2) == null) {
            this.k.onNestedScrollAccepted(view, view2, i2);
            startNestedScroll(i2 & 2);
            this.f43024j = 0.0f;
            this.o = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048609, this, view, view2, i2)) == null) ? (!isEnabled() || this.u || (i2 & 2) == 0) ? false : true : invokeLLI.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, view) == null) {
            this.k.onStopNestedScroll(view);
            this.o = false;
            float f2 = this.f43024j;
            if (f2 > 0.0f) {
                m(f2);
                this.f43024j = 0.0f;
            }
            stopNestedScroll();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, motionEvent)) == null) {
            if (this.w.getView().getAnimation() != null && !this.w.getView().getAnimation().hasEnded()) {
                return super.onTouchEvent(motionEvent);
            }
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (this.u && actionMasked == 0) {
                this.u = false;
            }
            if (!isEnabled() || this.u || canChildScrollUp() || this.f43021g || this.o) {
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
                    m((motionEvent.getY(findPointerIndex) - this.q) * 0.5f);
                }
                this.t = -1;
                return false;
            } else if (actionMasked == 2) {
                int findPointerIndex2 = motionEvent.findPointerIndex(this.t);
                if (findPointerIndex2 < 0) {
                    return false;
                }
                float y = motionEvent.getY(findPointerIndex2);
                z(y);
                if (this.s) {
                    float f2 = (y - this.q) * 0.5f;
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    p(f2);
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
                    r(motionEvent);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public final void p(float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048612, this, f2) == null) || this.w == null) {
            return;
        }
        float min = Math.min(1.0f, Math.abs(f2 / this.f43023i));
        Math.max(min - 0.4d, 0.0d);
        float abs = Math.abs(f2) - this.f43023i;
        int i3 = this.y;
        if (this.w.e() > 0) {
            i3 = this.w.e();
        }
        if (this.B) {
            i3 -= this.mOriginalOffsetTop;
        }
        float f3 = i3;
        double max = Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f;
        float pow = ((float) (max - Math.pow(max, 2.0d))) * 2.0f;
        int i4 = this.mOriginalOffsetTop + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
        if (this.w.getView().getVisibility() != 0) {
            this.w.getView().setVisibility(0);
        }
        ViewCompat.setScaleX(this.w.getView(), 1.0f);
        ViewCompat.setScaleY(this.w.getView(), 1.0f);
        if (!this.f43021g && (i2 = this.f43019e) != 3 && i2 != 6) {
            int i5 = this.mOriginalOffsetTop;
            int i6 = this.p;
            if (i5 < i6) {
                if (i6 - i5 < this.y) {
                    if (i2 != 0) {
                        s();
                    }
                } else if (this.w.e() > 0 && this.p - this.mOriginalOffsetTop > this.w.e()) {
                    this.f43019e = 5;
                    this.w.c();
                } else if (this.f43019e != 1) {
                    u();
                }
            }
            this.w.onPullPercentChange((this.p - this.mOriginalOffsetTop) / this.y, pow);
        }
        y(i4 - this.p, true);
    }

    public void q(float f2) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048613, this, f2) == null) || (kVar = this.w) == null) {
            return;
        }
        int i2 = this.mFrom;
        y((i2 + ((int) ((this.mOriginalOffsetTop - i2) * f2))) - kVar.getView().getTop(), false);
    }

    public final void r(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (motionEvent.getPointerId(actionIndex) == this.t) {
                this.t = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
            }
        }
    }

    public void refreshFinishWithMsgRemind(f.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, iVar) == null) {
            if (iVar == null) {
                setRefreshing(false);
            } else if (!isSupportMsgRemind()) {
                setRefreshing(false);
            } else {
                x(false, false, iVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 21 || !(this.f43020f instanceof AbsListView)) {
                View view = this.f43020f;
                if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                    super.requestDisallowInterceptTouchEvent(z);
                }
            }
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && this.f43019e == 6) {
            if (getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = this.C;
            }
            animateOffsetToStartPosition(this.p, null, 400);
            this.f43021g = false;
            this.f43019e = 4;
        }
    }

    public final void s() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (kVar = this.w) == null) {
            return;
        }
        this.f43019e = 0;
        kVar.onPullToRefresh();
    }

    public void setAnimationProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f2) == null) {
            if (o()) {
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
            this.f43023i = i3;
            this.y = i2;
            this.A = i4;
            int i5 = -i4;
            this.p = i5;
            this.mOriginalOffsetTop = i5;
            q(1.0f);
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
            v();
        }
    }

    public void setExecuteMsgAnimation(boolean z) {
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048622, this, z) == null) && (kVar = this.w) != null && (kVar instanceof c.a.q0.r.l0.f)) {
            ((c.a.q0.r.l0.f) kVar).K(z);
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
        int i2 = this.f43019e;
        if (i2 == 4 || i2 == 6) {
            k kVar2 = this.w;
            if (kVar2 != null) {
                removeView(kVar2.getView());
            }
            this.w = kVar;
            kVar.getView().setVisibility(8);
            addView(this.w.getView(), 0);
            if (kVar instanceof c.a.r0.o1.i.i.a) {
                ((c.a.r0.o1.i.i.a) kVar).O(new c(this));
            }
        }
    }

    public void setRefreshing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            w(z, false);
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

    public final void t() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (kVar = this.w) == null) {
            return;
        }
        this.f43019e = 2;
        kVar.onRefreshing();
    }

    public final void u() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048629, this) == null) || (kVar = this.w) == null) {
            return;
        }
        this.f43019e = 1;
        kVar.onReleaseToRefresh();
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            finish();
            if (getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) getLayoutParams()).topMargin = this.C;
            }
            k kVar = this.w;
            if (kVar != null) {
                kVar.getView().setVisibility(8);
                k kVar2 = this.w;
                if (kVar2 instanceof c.a.q0.r.l0.f) {
                    ((c.a.q0.r.l0.f) kVar2).D();
                }
                setColorViewAlpha(255);
                y(this.mOriginalOffsetTop - this.p, true);
                this.p = -this.A;
            }
        }
    }

    public final void w(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            x(z, z2, null);
        }
    }

    public final void x(boolean z, boolean z2, f.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), iVar}) == null) || this.f43021g == z) {
            return;
        }
        n(z);
        l();
        this.f43021g = z;
        if (z) {
            h(this.p, this.F);
        } else {
            k(iVar);
        }
    }

    public void y(int i2, boolean z) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (kVar = this.w) == null) {
            return;
        }
        kVar.getView().bringToFront();
        ViewCompat.offsetTopAndBottom(this.w.getView(), i2);
        View view = this.f43020f;
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
    public final void z(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048634, this, f2) == null) {
            float f3 = this.r;
            int i2 = this.f43022h;
            if (f2 - f3 <= i2 || this.s) {
                return;
            }
            this.q = f3 + i2;
            this.s = true;
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
        this.f43019e = 4;
        this.f43021g = false;
        this.f43023i = -1.0f;
        this.m = new int[2];
        this.n = new int[2];
        this.t = -1;
        this.x = -1;
        this.D = false;
        this.F = new b(this);
        this.G = new g(this);
        this.H = new h(this);
        this.I = new i(this);
        this.J = new j(this);
        this.f43022h = ViewConfiguration.get(context).getScaledTouchSlop();
        this.v = new DecelerateInterpolator(2.0f);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.k = new NestedScrollingParentHelper(this);
        this.l = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, K);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        this.C = 0;
    }
}
