package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.x0.c0;
import b.a.r0.x0.c1;
import b.a.r0.x0.i1;
import b.a.r0.x0.j1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class FrsTabSortSwitchButton extends View implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public boolean B;
    public boolean C;
    public boolean D;
    public List<c0> E;
    public List<Float> F;
    public GestureDetector G;
    public GestureDetector.SimpleOnGestureListener H;
    public e I;
    public ValueAnimator J;
    public float K;
    public float L;
    public boolean M;

    /* renamed from: e  reason: collision with root package name */
    public float f49324e;

    /* renamed from: f  reason: collision with root package name */
    public float f49325f;

    /* renamed from: g  reason: collision with root package name */
    public float f49326g;

    /* renamed from: h  reason: collision with root package name */
    public int f49327h;

    /* renamed from: i  reason: collision with root package name */
    public int f49328i;
    public int j;
    public int k;
    public float l;
    public float m;
    public float n;
    public int o;
    public String p;
    public String q;
    public Paint r;
    public Paint s;
    public Paint t;
    public RectF u;
    public Path v;
    public RectF w;
    public Path x;
    public int y;
    public float z;

    /* loaded from: classes9.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabSortSwitchButton f49329e;

        public a(FrsTabSortSwitchButton frsTabSortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabSortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49329e = frsTabSortSwitchButton;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (!this.f49329e.C && motionEvent.getX() <= this.f49329e.f49324e && motionEvent.getY() <= this.f49329e.f49325f) {
                    if (this.f49329e.getParent() != null) {
                        this.f49329e.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (this.f49329e.B) {
                    this.f49329e.z -= f2;
                    if (this.f49329e.z < 0.0f) {
                        this.f49329e.z = 0.0f;
                    }
                    Float f4 = (Float) ListUtils.getItem(this.f49329e.F, this.f49329e.F.size() - 1);
                    float floatValue = f4 != null ? f4.floatValue() : 0.0f;
                    if (this.f49329e.z > floatValue) {
                        this.f49329e.z = floatValue;
                    }
                    this.f49329e.invalidate();
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                int i2 = this.f49329e.y;
                this.f49329e.z = motionEvent.getX();
                FrsTabSortSwitchButton frsTabSortSwitchButton = this.f49329e;
                frsTabSortSwitchButton.y = frsTabSortSwitchButton.r();
                this.f49329e.C = true;
                if (this.f49329e.y != i2) {
                    this.f49329e.A(i2);
                    if (this.f49329e.J != null) {
                        this.f49329e.J.start();
                    }
                    this.f49329e.u(i2);
                }
                this.f49329e.C = false;
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabSortSwitchButton f49330e;

        public b(FrsTabSortSwitchButton frsTabSortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabSortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49330e = frsTabSortSwitchButton;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * this.f49330e.K;
                if (this.f49330e.M) {
                    FrsTabSortSwitchButton frsTabSortSwitchButton = this.f49330e;
                    frsTabSortSwitchButton.z = frsTabSortSwitchButton.L - floatValue;
                } else {
                    FrsTabSortSwitchButton frsTabSortSwitchButton2 = this.f49330e;
                    frsTabSortSwitchButton2.z = frsTabSortSwitchButton2.L + floatValue;
                }
                this.f49330e.invalidate();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabSortSwitchButton f49331e;

        public c(FrsTabSortSwitchButton frsTabSortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabSortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49331e = frsTabSortSwitchButton;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                Float f2 = (Float) ListUtils.getItem(this.f49331e.F, this.f49331e.y);
                if (f2 != null) {
                    this.f49331e.z = f2.floatValue();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Comparator<FrsTabInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsTabSortSwitchButton f49332e;

        public d(FrsTabSortSwitchButton frsTabSortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabSortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49332e = frsTabSortSwitchButton;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(FrsTabInfo frsTabInfo, FrsTabInfo frsTabInfo2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, frsTabInfo, frsTabInfo2)) == null) ? frsTabInfo.tab_id.intValue() - frsTabInfo2.tab_id.intValue() : invokeLL.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
        boolean a(int i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.L = this.F.get(i2).floatValue();
            this.K = Math.abs(this.F.get(this.y).floatValue() - this.L);
            this.M = this.y < i2;
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.y = 0;
            this.z = 0.0f;
            this.C = false;
            this.E.clear();
            this.F.clear();
            this.D = true;
        }
    }

    public void changeState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            for (int i3 = 0; i3 < this.E.size(); i3++) {
                if (this.E.get(i3).f27113b == i2) {
                    this.y = i3;
                    if (i3 < this.F.size()) {
                        this.z = this.F.get(i3).floatValue();
                    }
                    invalidate();
                    return;
                }
            }
        }
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.y : invokeV.intValue;
    }

    public int getSwitchMenuId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            c0 c0Var = (c0) ListUtils.getItem(this.E, i2);
            if (c0Var == null) {
                return -1;
            }
            return c0Var.f27113b;
        }
        return invokeI.intValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.r.setColor(SkinManager.getColor(this.f49327h));
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            canvas.clipPath(this.v);
            super.onDraw(canvas);
            canvas.drawPath(this.v, this.r);
            s(canvas);
            int i2 = 0;
            while (i2 < this.E.size()) {
                t(canvas, this.E.get(i2).f27112a, this.F.get(i2).floatValue() + this.m, this.A, this.y == i2);
                i2++;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            float size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            float size2 = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            int count = ListUtils.getCount(this.E);
            float f2 = 0.0f;
            if (mode == Integer.MIN_VALUE) {
                this.f49324e = 0.0f;
                for (int i4 = 0; i4 < count; i4++) {
                    c0 c0Var = (c0) ListUtils.getItem(this.E, i4);
                    if (c0Var != null) {
                        Paint paint = this.t;
                        String str = c0Var.f27112a;
                        if (str == null) {
                            str = "";
                        }
                        float measureText = paint.measureText(str) + (this.m * 2.0f);
                        if (this.D) {
                            this.F.add(Float.valueOf(this.f49324e));
                        }
                        this.f49324e += measureText;
                    }
                }
            } else {
                this.f49324e = size;
                if (count > 0) {
                    size /= count;
                }
                for (int i5 = 0; i5 < count; i5++) {
                    if (this.D) {
                        this.F.add(Float.valueOf(f2));
                    }
                    f2 += size;
                }
            }
            if (mode2 == Integer.MIN_VALUE) {
                this.f49325f = this.f49326g;
            } else {
                this.f49325f = size2;
                this.f49326g = size2;
            }
            this.D = false;
            y();
            setMeasuredDimension((int) this.f49324e, (int) this.f49325f);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, motionEvent)) == null) {
            if (this.G.onTouchEvent(motionEvent)) {
                return true;
            }
            if (this.B && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
                int i2 = this.y;
                int r = r();
                if (Math.abs(r - i2) >= 2 || r > i2) {
                    this.y = r;
                } else if (r < i2) {
                    float floatValue = this.F.get(r).floatValue();
                    int i3 = r + 1;
                    float floatValue2 = i3 < this.F.size() ? this.F.get(i3).floatValue() : floatValue;
                    float f2 = this.z;
                    if (f2 >= floatValue && f2 <= floatValue + ((floatValue2 - floatValue) / 2.0f)) {
                        this.y = r;
                    }
                } else {
                    float floatValue3 = this.F.get(r).floatValue();
                    int i4 = r + 1;
                    if (this.z >= floatValue3 + (((i4 < this.F.size() ? this.F.get(i4).floatValue() : floatValue3) - floatValue3) / 2.0f) && i4 < this.F.size()) {
                        this.y = i4;
                    }
                }
                this.C = true;
                this.L = this.z;
                float floatValue4 = this.F.get(this.y).floatValue();
                this.K = Math.abs(this.L - floatValue4);
                int i5 = this.y;
                if (i5 < i2) {
                    this.M = true;
                } else if (i5 > i2) {
                    this.M = false;
                } else {
                    this.M = this.L > floatValue4;
                }
                ValueAnimator valueAnimator = this.J;
                if (valueAnimator != null) {
                    valueAnimator.start();
                }
                if (this.y != i2) {
                    u(i2);
                }
                this.C = false;
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final int r() {
        InterceptResult invokeV;
        float floatValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.y;
            int i3 = 0;
            while (i3 < this.F.size()) {
                float floatValue2 = ((Float) ListUtils.getItem(this.F, i3)).floatValue();
                int i4 = i3 + 1;
                if (i4 == this.F.size()) {
                    floatValue = this.f49324e;
                } else {
                    floatValue = ((Float) ListUtils.getItem(this.F, i4)).floatValue();
                }
                float f2 = this.z;
                if (f2 <= floatValue2 || f2 >= floatValue) {
                    float f3 = this.z;
                    if (f3 == floatValue2) {
                        if (i2 - 1 >= 0) {
                            return i2 - 1;
                        }
                    } else if (f3 == floatValue && (i3 = i2 + 1) < ListUtils.getCount(this.F)) {
                    }
                    i3 = i4;
                }
                return i3;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final void s(Canvas canvas) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            if (this.z < 0.0f) {
                this.z = 0.0f;
            }
            float floatValue = !ListUtils.isEmpty(this.F) ? ((Float) ListUtils.getItem(this.F, this.y)).floatValue() : 0.0f;
            if (this.y + 1 < this.F.size()) {
                f2 = this.F.get(this.y + 1).floatValue();
            } else {
                f2 = this.y + 1 == this.F.size() ? this.f49324e : 0.0f;
            }
            float f3 = this.z + (f2 - floatValue);
            float f4 = this.f49324e;
            if (f3 > f4) {
                f3 = f4;
            }
            this.w.set(this.z, 0.0f, f3, this.f49325f);
            this.x.reset();
            Path path = this.x;
            RectF rectF = this.w;
            float f5 = this.f49326g;
            path.addRoundRect(rectF, f5 / 2.0f, f5 / 2.0f, Path.Direction.CW);
            this.s.reset();
            this.s.setAntiAlias(true);
            this.s.setColor(SkinManager.getColor(this.f49328i));
            canvas.drawPath(this.x, this.s);
            this.s.reset();
            this.s.setAntiAlias(true);
            this.s.setColor(SkinManager.getColor(this.o));
            this.s.setStyle(Paint.Style.STROKE);
            this.s.setStrokeWidth(this.n);
            RectF rectF2 = this.w;
            float f6 = this.z;
            float f7 = this.n;
            rectF2.set(f6 + (f7 / 2.0f), f7 / 2.0f, f3 - (f7 / 2.0f), this.f49326g - (f7 / 2.0f));
            float f8 = (this.f49326g - this.n) / 2.0f;
            canvas.drawRoundRect(this.w, f8, f8, this.s);
        }
    }

    public void setCanScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.B = z;
        }
    }

    public void setData(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, list) == null) && z(list)) {
            B();
            if (ListUtils.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            for (int i2 = 0; i2 < list.size(); i2++) {
                c0 c0Var = new c0();
                c0Var.f27113b = list.get(i2).tab_id.intValue();
                if (list.get(i2).tab_id.intValue() == 2) {
                    if (list.get(i2).tab_type.intValue() == 16) {
                        c0Var.f27112a = "最热";
                    } else {
                        c0Var.f27112a = this.p;
                    }
                } else if (list.get(i2).tab_id.intValue() == 3) {
                    if (list.get(i2).tab_type.intValue() == 16) {
                        c0Var.f27112a = "最新";
                    } else {
                        c0Var.f27112a = this.q;
                    }
                } else {
                    String str = list.get(i2).tab_name;
                    c0Var.f27112a = str;
                    if (str == null) {
                        c0Var.f27112a = "";
                    } else if (str.length() > 5) {
                        c0Var.f27112a = c0Var.f27112a.substring(0, 5);
                    }
                }
                this.E.add(c0Var);
            }
            requestLayout();
        }
    }

    public void setOnSwitchChangeListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.I = eVar;
        }
    }

    public final void t(Canvas canvas, String str, float f2, float f3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{canvas, str, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)}) == null) {
            if (z) {
                this.t.setColor(SkinManager.getColor(this.k));
            } else {
                this.t.setColor(SkinManager.getColor(this.j));
            }
            canvas.drawText(str, f2, f3, this.t);
        }
    }

    public final void u(int i2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (eVar = this.I) == null || eVar.a(this.y)) {
            return;
        }
        ValueAnimator valueAnimator = this.J;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.y = i2;
        this.z = this.F.get(i2).floatValue();
        invalidate();
    }

    public final void v(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, context) == null) {
            this.u = new RectF();
            this.v = new Path();
            this.w = new RectF();
            this.x = new Path();
            Paint paint = new Paint(1);
            this.r = paint;
            paint.setColor(SkinManager.getColor(this.f49327h));
            this.s = new Paint(1);
            Paint paint2 = new Paint(1);
            this.t = paint2;
            paint2.setTextSize(this.l);
            this.E = new ArrayList();
            this.F = new ArrayList();
            this.y = 0;
            this.G = new GestureDetector(context, this.H);
            this.p = getResources().getString(i1.reply_post_frs);
            this.q = getResources().getString(i1.send_post);
            w();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
            this.J = duration;
            duration.addUpdateListener(new b(this));
            this.J.addListener(new c(this));
        }
    }

    public final void x(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j1.FrsTabSortSwitchButton);
            this.f49327h = obtainStyledAttributes.getResourceId(j1.FrsTabSortSwitchButton_background_color, c1.CAM_X0107);
            this.f49328i = obtainStyledAttributes.getResourceId(j1.FrsTabSortSwitchButton_slide_color, c1.CAM_X0101);
            this.j = obtainStyledAttributes.getResourceId(j1.FrsTabSortSwitchButton_un_selected_text_color, c1.CAM_X0105);
            this.k = obtainStyledAttributes.getResourceId(j1.FrsTabSortSwitchButton_selected_text_color, c1.CAM_X0105);
            this.l = obtainStyledAttributes.getDimension(j1.FrsTabSortSwitchButton_text_size, 5.0f);
            this.m = obtainStyledAttributes.getDimension(j1.FrsTabSortSwitchButton_text_horizontal_padding, 0.0f);
            this.f49326g = obtainStyledAttributes.getDimension(j1.FrsTabSortSwitchButton_slide_height, 0.0f);
            this.n = obtainStyledAttributes.getDimension(j1.FrsTabSortSwitchButton_slide_border_width, 0.0f);
            this.o = obtainStyledAttributes.getResourceId(j1.FrsTabSortSwitchButton_slide_border_color, c1.CAM_X0105);
            obtainStyledAttributes.recycle();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.u.set(0.0f, 0.0f, this.f49324e, this.f49325f);
            this.v.reset();
            Path path = this.v;
            RectF rectF = this.u;
            float f2 = this.f49325f;
            path.addRoundRect(rectF, f2 / 2.0f, f2 / 2.0f, Path.Direction.CW);
            Float f3 = (Float) ListUtils.getItem(this.F, this.y);
            this.z = f3 != null ? f3.floatValue() : 0.0f;
            Paint.FontMetrics fontMetrics = this.t.getFontMetrics();
            this.A = (this.f49325f / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f);
        }
    }

    public final boolean z(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return true;
            }
            Collections.sort(list, new d(this));
            int size = list.size();
            if (size != this.E.size()) {
                return true;
            }
            for (int i2 = 0; i2 < size; i2++) {
                c0 c0Var = this.E.get(i2);
                FrsTabInfo frsTabInfo = list.get(i2);
                if (frsTabInfo.tab_id.intValue() != c0Var.f27113b) {
                    return true;
                }
                if (frsTabInfo.tab_id.intValue() == 2 && !c0Var.f27112a.equals(this.p)) {
                    return true;
                }
                if (frsTabInfo.tab_id.intValue() == 3 && !c0Var.f27112a.equals(this.q)) {
                    return true;
                }
                if (frsTabInfo.tab_id.intValue() != 2 && frsTabInfo.tab_id.intValue() != 3) {
                    String str = frsTabInfo.tab_name;
                    if (str != null && str.length() > 5) {
                        if (!c0Var.f27112a.equals(frsTabInfo.tab_name.substring(0, 5))) {
                            return true;
                        }
                    } else if (!c0Var.f27112a.equals(frsTabInfo.tab_name)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.B = false;
        this.C = false;
        this.D = true;
        this.H = new a(this);
        x(context, attributeSet);
        v(context);
        setOnTouchListener(this);
    }
}
