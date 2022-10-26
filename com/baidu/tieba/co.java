package com.baidu.tieba;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class co {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zn a;
    public Cdo b;
    public RecyclerView c;
    public VelocityTracker d;
    public float e;
    public float f;
    public int g;
    public int h;
    public int i;
    public be5 j;
    public RecyclerView.OnChildAttachStateChangeListener k;
    public RecyclerView.OnScrollListener l;
    public RecyclerView.OnItemTouchListener m;

    /* loaded from: classes3.dex */
    public class a implements RecyclerView.OnChildAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ co a;

        public a(co coVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.r(view2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) != null) {
                return;
            }
            this.a.s(view2);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ co a;

        public b(co coVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                this.a.u(i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) != null) {
                return;
            }
            this.a.t(i, i2);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements RecyclerView.OnItemTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ co a;

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, recyclerView, motionEvent) == null) {
            }
        }

        public c(co coVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            float f;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, recyclerView, motionEvent)) == null) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    this.a.c.stopScroll();
                    this.a.e = motionEvent.getX();
                    this.a.f = motionEvent.getY();
                    co coVar = this.a;
                    View x = coVar.x(coVar.e, this.a.f);
                    co coVar2 = this.a;
                    coVar2.g = coVar2.c.getChildAdapterPosition(x);
                    if (this.a.d == null) {
                        this.a.d = VelocityTracker.obtain();
                    }
                    this.a.d.addMovement(motionEvent);
                    return false;
                }
                int i = 1;
                if (actionMasked == 2) {
                    float x2 = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (this.a.i == 2) {
                        f = y - this.a.f;
                    } else {
                        f = x2 - this.a.e;
                    }
                    if (f >= 0.0f) {
                        i = 2;
                    }
                    if (i != this.a.h) {
                        this.a.h = i;
                        this.a.d.clear();
                    }
                    this.a.d.addMovement(motionEvent);
                    this.a.d.computeCurrentVelocity(50);
                    co coVar3 = this.a;
                    coVar3.v(coVar3.d.getXVelocity(), this.a.d.getYVelocity());
                    this.a.e = x2;
                    this.a.f = y;
                    return false;
                } else if (actionMasked == 3 || actionMasked == 1) {
                    this.a.e = 0.0f;
                    this.a.f = 0.0f;
                    this.a.d.clear();
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    public co(ao aoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aoVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.l = new b(this);
        this.m = new c(this);
        this.a = new zn(aoVar);
        this.b = new Cdo(aoVar);
    }

    public final void t(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            if (this.c instanceof BdTypeRecyclerView) {
                this.b.p(i, i2, this.g);
            }
            this.a.l(i, i2, this.g);
        }
    }

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            if (this.c instanceof BdTypeRecyclerView) {
                this.b.k(view2);
            } else {
                this.a.g(view2);
            }
        }
    }

    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (this.c instanceof BdTypeRecyclerView) {
                this.b.l(view2);
            } else {
                this.a.h(view2);
            }
        }
    }

    public void q(RecyclerView recyclerView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048576, this, recyclerView, i) != null) || recyclerView == null) {
            return;
        }
        RecyclerView recyclerView2 = this.c;
        if (recyclerView2 != null) {
            recyclerView2.removeOnItemTouchListener(this.m);
            this.c.removeOnScrollListener(this.l);
            this.c.removeOnChildAttachStateChangeListener(this.k);
        }
        this.c = recyclerView;
        this.i = i;
        if (recyclerView instanceof BdTypeRecyclerView) {
            this.b.e((BdTypeRecyclerView) recyclerView, i);
        } else {
            this.a.e(recyclerView, i);
        }
        this.c.addOnItemTouchListener(this.m);
        this.c.addOnScrollListener(this.l);
        this.c.addOnChildAttachStateChangeListener(this.k);
    }

    public final void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i == 1) {
                if (TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                    if (this.j == null) {
                        this.j = new be5("anim_switch_slide");
                    }
                    this.j.b();
                }
            } else if (i == 0 && this.j != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_slide")) {
                this.j.c();
            }
            if (this.c instanceof BdTypeRecyclerView) {
                this.b.q(i);
            }
            this.a.m(i);
        }
    }

    public final void v(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            if (this.c instanceof BdTypeRecyclerView) {
                this.b.t(f, f2, this.g);
            }
            this.a.o(f, f2, this.g);
        }
    }

    public void w() {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (recyclerView = this.c) != null) {
            recyclerView.removeOnItemTouchListener(this.m);
            this.c.removeOnScrollListener(this.l);
            this.c.removeOnChildAttachStateChangeListener(this.k);
        }
    }

    public View x(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            RecyclerView recyclerView = this.c;
            if (recyclerView == null) {
                return null;
            }
            for (int childCount = recyclerView.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = this.c.getChildAt(childCount);
                float translationX = childAt.getTranslationX();
                float translationY = childAt.getTranslationY();
                if (f >= childAt.getLeft() + translationX && f <= childAt.getRight() + translationX && f2 >= childAt.getTop() + translationY && f2 <= childAt.getBottom() + translationY) {
                    return childAt;
                }
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
