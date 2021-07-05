package com.baidu.tbadk.widget.horizontalpullview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PullLeftRefreshLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f13326e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.r0.b1.h.a f13327f;

    /* renamed from: g  reason: collision with root package name */
    public View f13328g;

    /* renamed from: h  reason: collision with root package name */
    public int f13329h;

    /* renamed from: i  reason: collision with root package name */
    public int f13330i;
    public int j;
    public int k;
    public float l;
    public ValueAnimator m;
    public ValueAnimator n;
    public int o;
    public int p;
    public int q;
    public float r;
    public f s;
    public boolean t;
    public RecyclerView.OnScrollListener u;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f13331a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f13332b;

        /* renamed from: c  reason: collision with root package name */
        public int f13333c;

        /* renamed from: d  reason: collision with root package name */
        public ValueAnimator f13334d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullLeftRefreshLayout f13335e;

        /* renamed from: com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0187a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f13336e;

            public C0187a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f13336e = aVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.f13336e.f13335e.setTranslationStatus(-((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f13337e;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f13337e = aVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    onAnimationEnd(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.f13337e.f13335e.f();
                }
            }
        }

        public a(PullLeftRefreshLayout pullLeftRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullLeftRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13335e = pullLeftRefreshLayout;
            this.f13332b = true;
            this.f13333c = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                this.f13331a = i2;
                if (this.f13335e.t && this.f13331a == 0 && !this.f13332b) {
                    ValueAnimator valueAnimator = this.f13334d;
                    if (valueAnimator != null) {
                        valueAnimator.cancel();
                    }
                    int i3 = (int) (this.f13335e.l - 1.0f);
                    if (this.f13333c > i3) {
                        this.f13333c = i3;
                    }
                    ValueAnimator ofInt = ValueAnimator.ofInt(this.f13333c, 0);
                    this.f13334d = ofInt;
                    ofInt.setDuration(100L);
                    this.f13334d.addUpdateListener(new C0187a(this));
                    this.f13334d.addListener(new b(this));
                    this.f13334d.start();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                this.f13333c = i2;
                if (!recyclerView.canScrollHorizontally(1) && i2 > 0) {
                    this.f13332b = false;
                } else {
                    this.f13332b = true;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullLeftRefreshLayout f13338e;

        public b(PullLeftRefreshLayout pullLeftRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullLeftRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13338e = pullLeftRefreshLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || valueAnimator == null) {
                return;
            }
            this.f13338e.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes4.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullLeftRefreshLayout f13339e;

        public c(PullLeftRefreshLayout pullLeftRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullLeftRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13339e = pullLeftRefreshLayout;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f13339e.f();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullLeftRefreshLayout f13340e;

        public d(PullLeftRefreshLayout pullLeftRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullLeftRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13340e = pullLeftRefreshLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || valueAnimator == null) {
                return;
            }
            this.f13340e.setTranslationStatus(-((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes4.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullLeftRefreshLayout f13341e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f13342e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f13342e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f13342e.f13341e.i();
                }
            }
        }

        public e(PullLeftRefreshLayout pullLeftRefreshLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullLeftRefreshLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13341e = pullLeftRefreshLayout;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f13341e.f();
                this.f13341e.postDelayed(new a(this), 50L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullLeftRefreshLayout(@NonNull Context context) {
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
        this.r = 0.0f;
        this.t = false;
        this.u = new a(this);
        g(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationStatus(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65543, this, f2) == null) {
            RecyclerView recyclerView = this.f13326e;
            if (recyclerView != null) {
                recyclerView.setTranslationX(f2);
            }
            View view = this.f13328g;
            if (view != null) {
                view.setTranslationX(this.f13330i + f2);
            }
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ViewCompat.canScrollHorizontally(this.f13326e, 1) : invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f13329h = 0;
            this.r = 0.0f;
            setTranslationStatus(0.0f);
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public void i() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (fVar = this.s) == null) {
            return;
        }
        fVar.a();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ValueAnimator valueAnimator = this.m;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(Math.abs(this.r), 0.0f);
            this.m = ofFloat;
            ofFloat.setDuration(150L);
            this.m.addUpdateListener(new b(this));
            this.m.addListener(new c(this));
            this.m.start();
            View view = this.f13328g;
            if (view != null) {
                this.f13327f.b(view);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ValueAnimator valueAnimator = this.n;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(Math.abs(this.r), 0.0f);
            this.n = ofFloat;
            ofFloat.setDuration(150L);
            this.n.addUpdateListener(new d(this));
            this.n.addListener(new e(this));
            this.n.start();
            View view = this.f13328g;
            if (view != null) {
                this.f13327f.b(view);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onAttachedToWindow();
            RecyclerView recyclerView = this.f13326e;
            if (recyclerView != null) {
                recyclerView.addOnScrollListener(this.u);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDetachedFromWindow();
            RecyclerView recyclerView = this.f13326e;
            if (recyclerView != null) {
                recyclerView.removeOnScrollListener(this.u);
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onFinishInflate();
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof RecyclerView) {
                    RecyclerView recyclerView = (RecyclerView) childAt;
                    this.f13326e = recyclerView;
                    if (recyclerView != null) {
                        recyclerView.addOnScrollListener(this.u);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r2 != 3) goto L11;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int i2 = x - this.o;
                        this.o = x;
                        this.q = x;
                        this.p = y;
                        if (Math.abs(i2) > Math.abs(y - this.p) && this.t && i2 < 0 && !e() && this.f13329h == 0) {
                            if (getParent() != null) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            this.f13329h = 2;
                            d.a.r0.b1.h.a aVar = this.f13327f;
                            if (aVar != null) {
                                aVar.b(this.f13328g);
                            }
                            return true;
                        }
                    }
                }
                this.o = 0;
                this.p = 0;
            } else {
                this.o = x;
                this.q = x;
                this.p = y;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (this.f13329h == 0) {
                this.f13328g.setTranslationX(this.f13330i);
            }
            super.onLayout(z, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            View view = this.f13328g;
            if (view != null) {
                int measuredWidth = view.getMeasuredWidth();
                this.f13330i = measuredWidth;
                int i4 = measuredWidth * 2;
                this.k = i4;
                this.j = i4 + measuredWidth;
                this.l = measuredWidth;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
        if (r1 != 3) goto L16;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            if (!this.t) {
                return super.onTouchEvent(motionEvent);
            }
            int x = (int) motionEvent.getX();
            motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int i2 = x - this.q;
                        this.q = x;
                        float abs = this.r + (i2 * (1.0f - Math.abs(this.r / this.j)));
                        this.r = abs;
                        if (abs >= 0.0f) {
                            this.r = 0.0f;
                            this.f13326e.setTranslationX(0.0f);
                            d.a.r0.b1.h.a aVar = this.f13327f;
                            if (aVar != null) {
                                aVar.b(this.f13328g);
                            }
                        } else {
                            int i3 = this.j;
                            if (abs <= (-i3)) {
                                float f2 = -i3;
                                this.r = f2;
                                this.f13326e.setTranslationX(f2);
                                d.a.r0.b1.h.a aVar2 = this.f13327f;
                                if (aVar2 != null) {
                                    aVar2.a(this.f13328g);
                                }
                            } else {
                                this.f13326e.setTranslationX(abs);
                                if (Math.abs(this.r) > this.l) {
                                    d.a.r0.b1.h.a aVar3 = this.f13327f;
                                    if (aVar3 != null) {
                                        aVar3.a(this.f13328g);
                                    }
                                } else {
                                    d.a.r0.b1.h.a aVar4 = this.f13327f;
                                    if (aVar4 != null) {
                                        aVar4.b(this.f13328g);
                                    }
                                }
                            }
                        }
                        View view = this.f13328g;
                        if (view != null) {
                            view.setTranslationX(this.f13330i + this.r);
                        }
                        return true;
                    }
                }
                this.o = 0;
                this.q = 0;
                this.p = 0;
                if (Math.abs(this.r) < this.l) {
                    j();
                } else {
                    k();
                }
                return true;
            }
            this.q = x;
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setCallback(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) {
            this.s = fVar;
        }
    }

    public void setEnablePull(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.t = z;
        }
    }

    public void setRefreshViewAndListener(d.a.r0.b1.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            this.f13327f = aVar;
            this.f13328g = aVar.getView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388613;
            this.f13328g.setLayoutParams(layoutParams);
            addView(this.f13328g, 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.r = 0.0f;
        this.t = false;
        this.u = new a(this);
        g(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullLeftRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.r = 0.0f;
        this.t = false;
        this.u = new a(this);
        g(context);
    }
}
