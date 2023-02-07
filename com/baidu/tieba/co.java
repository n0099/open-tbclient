package com.baidu.tieba;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class co {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public zn b;
    public int c;
    public SparseIntArray d;
    public int e;
    public float f;
    public float g;
    public boolean h;
    public SparseArray<ValueAnimator> i;
    public SparseIntArray j;
    public LinearLayoutManager k;
    public HashSet<Integer> l;
    public HashSet<Integer> m;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ co c;

        public a(co coVar, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coVar, view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = coVar;
            this.a = view2;
            this.b = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.c.r(this.a, this.b, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;
        public final /* synthetic */ co d;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public b(co coVar, int i, View view2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coVar, Integer.valueOf(i), view2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = coVar;
            this.a = i;
            this.b = view2;
            this.c = i2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.d.i.delete(this.a);
                this.d.j.delete(this.a);
                this.d.r(this.b, this.c, 0.0f);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.d.i.delete(this.a);
                this.d.j.delete(this.a);
                this.d.d.delete(this.a);
                this.d.r(this.b, this.c, 0.0f);
            }
        }
    }

    public co(zn znVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {znVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = false;
        this.l = new HashSet<>();
        this.m = new HashSet<>();
        this.b = znVar;
        this.d = new SparseIntArray();
        this.i = new SparseArray<>();
        this.j = new SparseIntArray();
    }

    public void l(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, view2) != null) || this.a == null) {
            return;
        }
        s(view2, 0.0f);
        int h = h(this.a.getChildAdapterPosition(view2));
        if (h >= 0 && g(h, 0, true) == -1) {
            this.d.delete(h);
            if (this.i.get(h) != null) {
                this.i.get(h).cancel();
            }
            this.i.delete(h);
            this.j.delete(h);
        }
    }

    public final float i(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            if (view2 == null) {
                return 0.0f;
            }
            if (this.c == 2) {
                return view2.getTranslationY();
            }
            return view2.getTranslationX();
        }
        return invokeL.floatValue;
    }

    public final boolean j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i > 0) {
                return tn5.p(this.a.E(i - this.a.getHeaderViewsCount()));
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void e(BdTypeRecyclerView bdTypeRecyclerView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, bdTypeRecyclerView, i) == null) {
            this.a = bdTypeRecyclerView;
            this.c = i;
            if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
                this.k = (LinearLayoutManager) bdTypeRecyclerView.getLayoutManager();
            }
        }
    }

    public final void s(View view2, float f) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLF(1048590, this, view2, f) != null) || view2 == null) {
            return;
        }
        if (this.c == 2) {
            view2.setTranslationY(f);
        } else {
            view2.setTranslationX(f);
        }
    }

    public final float f(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return i(this.a.getChildAt(g(i + 1, i2, true)));
            }
            return i(this.a.getChildAt(g(i - 1, i2, false)));
        }
        return invokeCommon.floatValue;
    }

    public final int g(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int i3 = 1;
            if (z) {
                int count = this.a.getCount() - i2;
                while (i3 < count) {
                    int i4 = i2 + i3;
                    if (i == h(i4)) {
                        return i4;
                    }
                    i3++;
                }
                return -1;
            }
            while (i3 < i2) {
                int i5 = i2 - i3;
                if (i == h(i5)) {
                    return i5;
                }
                i3++;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public final int h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i > 0) {
                Cdo E = this.a.E(i - this.a.getHeaderViewsCount());
                if (E instanceof BaseCardInfo) {
                    return ((BaseCardInfo) E).position;
                }
                if (E instanceof hy4) {
                    return ((hy4) E).j();
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i) != null) || this.a == null) {
            return;
        }
        this.e = i;
        if (i == 0) {
            this.d.clear();
            o();
        } else if (i == 2) {
            o();
        } else if (i == 1) {
            this.d.clear();
            o();
        }
    }

    public void k(View view2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        int childAdapterPosition;
        int h;
        BdTypeRecyclerView bdTypeRecyclerView2;
        float f;
        BdTypeRecyclerView bdTypeRecyclerView3;
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, view2) != null) || (bdTypeRecyclerView = this.a) == null || this.k == null || this.e == 0 || (h = h((childAdapterPosition = bdTypeRecyclerView.getChildAdapterPosition(view2)))) < 0) {
            return;
        }
        if (childAdapterPosition <= this.k.findFirstVisibleItemPosition()) {
            if (this.a.getChildAt(1) != null) {
                f2 = i(this.a.getChildAt(1));
            } else {
                f2 = 0.0f;
            }
            int h2 = h(childAdapterPosition + 1);
            if (h2 < 0) {
                return;
            }
            if (h2 == h) {
                if (!j(childAdapterPosition)) {
                    s(view2, f2);
                }
            } else {
                float f3 = -this.d.get(h, 0);
                if (f3 != 0.0f) {
                    this.f = f3;
                } else {
                    f3 = this.f;
                }
                if (!j(childAdapterPosition)) {
                    s(view2, f3 + f2);
                }
            }
        } else {
            if (this.a.getChildAt(bdTypeRecyclerView2.getChildCount() - 2) != null) {
                f = i(this.a.getChildAt(bdTypeRecyclerView3.getChildCount() - 2));
            } else {
                f = 0.0f;
            }
            int h3 = h(childAdapterPosition - 1);
            if (h3 < 0) {
                return;
            }
            if (h3 == h) {
                if (!j(childAdapterPosition)) {
                    s(view2, f);
                }
            } else {
                float f4 = -this.d.get(h, 0);
                if (f4 != 0.0f) {
                    this.g = f4;
                } else {
                    f4 = this.g;
                }
                if (!j(childAdapterPosition)) {
                    s(view2, f4 + f);
                }
            }
        }
        n(view2, childAdapterPosition);
    }

    public final void m(View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) != null) || view2 == null) {
            return;
        }
        if (i < 0) {
            if (i2 < i3) {
                float i5 = i(view2) + (i * this.b.l());
                if (i5 > (-this.d.get(i4)) + f(i4, i2, true)) {
                    r(view2, i2, i5);
                } else {
                    n(view2, i2);
                }
            } else if (i2 > i3) {
                float i6 = i(view2) + (i * this.b.e());
                if (i6 > (-this.d.get(i4)) + f(i4, i2, false)) {
                    r(view2, i2, i6);
                } else {
                    n(view2, i2);
                }
            }
        } else if (i2 > i3) {
            float i7 = i(view2) + (i * this.b.l());
            if (i7 < (-this.d.get(i4)) + f(i4, i2, false)) {
                r(view2, i2, i7);
            } else {
                n(view2, i2);
            }
        } else if (i2 < i3) {
            float i8 = i(view2) + (i * this.b.e());
            if (i8 < (-this.d.get(i4)) + f(i4, i2, true)) {
                r(view2, i2, i8);
            } else {
                n(view2, i2);
            }
        }
    }

    public final void n(View view2, int i) {
        int h;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048585, this, view2, i) != null) || view2 == null || (h = h(i)) < 0) {
            return;
        }
        ValueAnimator valueAnimator = this.i.get(h);
        if (valueAnimator == null) {
            if (Math.abs(i(view2)) < 0.1f) {
                r(view2, i, 0.0f);
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i(view2), 0.0f);
            ofFloat.setInterpolator(new ao(1.0f));
            ofFloat.setDuration(this.b.a());
            ofFloat.addUpdateListener(new a(this, view2, i));
            ofFloat.addListener(new b(this, h, view2, i));
            this.i.append(h, ofFloat);
            this.j.append(h, (int) i(view2));
            ofFloat.start();
            return;
        }
        if (!valueAnimator.isRunning()) {
            valueAnimator.start();
        }
        float i2 = i(view2);
        if (Math.abs(i2) > Math.abs(this.j.get(h)) + this.b.b()) {
            this.j.append(h, (int) i2);
            valueAnimator.setFloatValues(i2, 0.0f);
            valueAnimator.cancel();
            valueAnimator.start();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int childCount = this.a.getChildCount();
            this.m.clear();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.a.getChildAt(i);
                int childAdapterPosition = this.a.getChildAdapterPosition(childAt);
                int h = h(childAdapterPosition);
                if (h >= 0 && !this.m.contains(Integer.valueOf(h))) {
                    this.m.add(Integer.valueOf(h));
                    n(childAt, childAdapterPosition);
                }
            }
        }
    }

    public void p(int i, int i2, int i3) {
        LinearLayoutManager linearLayoutManager;
        int h;
        int h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048587, this, i, i2, i3) == null) && this.a != null && (linearLayoutManager = this.k) != null && this.e == 1 && !this.h) {
            int findFirstVisibleItemPosition = i3 - linearLayoutManager.findFirstVisibleItemPosition();
            int h3 = h(i3);
            if (h3 < 0) {
                return;
            }
            this.l.add(Integer.valueOf(h3));
            if (this.c == 2) {
                i = i2;
            }
            int childCount = this.a.getChildCount();
            for (int i4 = findFirstVisibleItemPosition - 1; i4 >= 0; i4--) {
                View childAt = this.a.getChildAt(i4);
                int childAdapterPosition = this.a.getChildAdapterPosition(childAt);
                if (childAdapterPosition != -1 && (h2 = h(childAdapterPosition)) >= 0 && !this.l.contains(Integer.valueOf(h2))) {
                    this.l.add(Integer.valueOf(h2));
                    m(childAt, i, childAdapterPosition, i3, h2);
                }
            }
            for (int i5 = findFirstVisibleItemPosition + 1; i5 <= childCount - 1; i5++) {
                View childAt2 = this.a.getChildAt(i5);
                int childAdapterPosition2 = this.a.getChildAdapterPosition(childAt2);
                if (childAdapterPosition2 != -1 && (h = h(childAdapterPosition2)) >= 0 && !this.l.contains(Integer.valueOf(h))) {
                    this.l.add(Integer.valueOf(h));
                    m(childAt2, i, childAdapterPosition2, i3, h);
                }
            }
        }
    }

    public final void r(View view2, int i, float f) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048589, this, new Object[]{view2, Integer.valueOf(i), Float.valueOf(f)}) != null) || view2 == null) {
            return;
        }
        if (this.c == 2) {
            CardLinkageManager.INSTANCE.translationY(this.a, i, f);
        } else {
            view2.setTranslationX(f);
        }
    }

    public void t(float f, float f2, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i)}) != null) || this.a == null) {
            return;
        }
        if (this.c == 2) {
            f = f2;
        }
        int i3 = 1;
        if (Math.abs(f) < this.b.i()) {
            this.h = true;
            o();
            return;
        }
        this.h = false;
        if (Math.abs(f) > this.b.h()) {
            if (f > 0.0f) {
                i2 = this.b.h();
            } else {
                i2 = -this.b.h();
            }
            f = i2;
        }
        this.d.clear();
        float f3 = this.b.f() * f;
        int h = h(i);
        if (h < 0) {
            return;
        }
        if (f < 0.0f) {
            float g = this.b.g();
            int i4 = 1;
            while (true) {
                int i5 = h - i4;
                float f4 = (i4 * g) + f3;
                g *= 1.2f;
                if (f4 > 0.0f) {
                    break;
                }
                float c = (f4 / this.b.c()) + this.d.get(i5);
                if (Math.abs(c) > this.b.d()) {
                    c = -this.b.d();
                }
                this.d.append(i5, (int) c);
                i4++;
            }
            float g2 = this.b.g();
            while (true) {
                int i6 = h + i3;
                float f5 = (i3 * g2) + f3;
                g2 *= 1.2f;
                if (f5 <= 0.0f) {
                    float j = (f5 / this.b.j()) + this.d.get(i6);
                    if (Math.abs(j) > this.b.k()) {
                        j = -this.b.k();
                    }
                    this.d.append(i6, (int) j);
                    i3++;
                } else {
                    return;
                }
            }
        } else {
            float g3 = this.b.g();
            int i7 = 1;
            while (true) {
                int i8 = h - i7;
                float f6 = f3 - (i7 * g3);
                g3 *= 1.2f;
                if (f6 < 0.0f) {
                    break;
                }
                float j2 = (f6 / this.b.j()) + this.d.get(i8);
                if (Math.abs(j2) > this.b.k()) {
                    j2 = this.b.k();
                }
                this.d.append(i8, (int) j2);
                i7++;
            }
            float g4 = this.b.g();
            while (true) {
                int i9 = h + i3;
                float f7 = f3 - (i3 * g4);
                g4 *= 1.2f;
                if (f7 < 0.0f) {
                    return;
                }
                float c2 = (f7 / this.b.c()) + this.d.get(i9);
                if (Math.abs(c2) > this.b.d()) {
                    c2 = this.b.d();
                }
                this.d.append(i9, (int) c2);
                i3++;
            }
        }
    }
}
