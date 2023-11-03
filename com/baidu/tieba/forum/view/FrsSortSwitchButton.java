package com.baidu.tieba.forum.view;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.de7;
import com.baidu.tieba.iq7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class FrsSortSwitchButton extends View implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GestureDetector A;
    public GestureDetector.SimpleOnGestureListener B;
    public d C;
    public ValueAnimator D;
    public float E;
    public float F;
    public boolean G;
    public float a;
    public float b;
    public float c;
    public int d;
    public int e;
    public int f;
    public int g;
    public float h;
    public float i;
    public float j;
    public int k;
    public Paint l;
    public Paint m;
    public Paint n;
    public RectF o;
    public Path p;
    public RectF q;
    public Path r;
    public int s;
    public float t;
    public float u;
    public boolean v;
    public boolean w;
    public boolean x;
    public List<iq7> y;
    public List<Float> z;

    /* loaded from: classes6.dex */
    public interface d {
        boolean a(iq7 iq7Var);
    }

    /* loaded from: classes6.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsSortSwitchButton a;

        public a(FrsSortSwitchButton frsSortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsSortSwitchButton;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (this.a.w || motionEvent.getX() > this.a.a || motionEvent.getY() > this.a.b) {
                    return false;
                }
                if (this.a.getParent() != null) {
                    this.a.getParent().requestDisallowInterceptTouchEvent(true);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) != null) {
                return invokeL.booleanValue;
            }
            int i = this.a.s;
            this.a.t = motionEvent.getX();
            FrsSortSwitchButton frsSortSwitchButton = this.a;
            frsSortSwitchButton.s = frsSortSwitchButton.s();
            this.a.w = true;
            if (this.a.s != i) {
                this.a.B(i);
                if (this.a.D != null) {
                    this.a.D.start();
                }
                this.a.v(i);
            }
            this.a.w = false;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (!this.a.v) {
                    return false;
                }
                FrsSortSwitchButton.m(this.a, f);
                float f3 = 0.0f;
                if (this.a.t < 0.0f) {
                    this.a.t = 0.0f;
                }
                Float f4 = (Float) ListUtils.getItem(this.a.z, this.a.z.size() - 1);
                if (f4 != null) {
                    f3 = f4.floatValue();
                }
                if (this.a.t > f3) {
                    this.a.t = f3;
                }
                this.a.invalidate();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsSortSwitchButton a;

        public b(FrsSortSwitchButton frsSortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsSortSwitchButton;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * this.a.E;
                if (this.a.G) {
                    FrsSortSwitchButton frsSortSwitchButton = this.a;
                    frsSortSwitchButton.t = frsSortSwitchButton.F - floatValue;
                } else {
                    FrsSortSwitchButton frsSortSwitchButton2 = this.a;
                    frsSortSwitchButton2.t = frsSortSwitchButton2.F + floatValue;
                }
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsSortSwitchButton a;

        public c(FrsSortSwitchButton frsSortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsSortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsSortSwitchButton;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                Float f = (Float) ListUtils.getItem(this.a.z, this.a.s);
                if (f != null) {
                    this.a.t = f.floatValue();
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsSortSwitchButton(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void B(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.F = this.z.get(i).floatValue();
            this.E = Math.abs(this.z.get(this.s).floatValue() - this.F);
            if (this.s < i) {
                z = true;
            } else {
                z = false;
            }
            this.G = z;
        }
    }

    public final void v(int i) {
        d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (dVar = this.C) != null && !dVar.a((iq7) ListUtils.getItem(this.y, this.s))) {
            ValueAnimator valueAnimator = this.D;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.s = i;
            this.t = this.z.get(i).floatValue();
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void y(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, de7.FrsSortSwitchButton);
            this.d = obtainStyledAttributes.getResourceId(0, R.color.CAM_X0107);
            this.e = obtainStyledAttributes.getResourceId(4, R.color.CAM_X0101);
            this.f = obtainStyledAttributes.getResourceId(8, R.color.CAM_X0105);
            this.g = obtainStyledAttributes.getResourceId(1, R.color.CAM_X0105);
            this.h = obtainStyledAttributes.getDimension(7, 5.0f);
            this.i = obtainStyledAttributes.getDimension(6, 0.0f);
            this.c = obtainStyledAttributes.getDimension(5, 0.0f);
            this.j = obtainStyledAttributes.getDimension(3, 0.0f);
            this.k = obtainStyledAttributes.getResourceId(2, R.color.CAM_X0105);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.v = false;
        this.w = false;
        this.x = true;
        this.B = new a(this);
        y(context, attributeSet);
        w(context);
        setOnTouchListener(this);
    }

    public void setCanScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.v = z;
        }
    }

    public void setOnSwitchChangeListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            this.C = dVar;
        }
    }

    public static /* synthetic */ float m(FrsSortSwitchButton frsSortSwitchButton, float f) {
        float f2 = frsSortSwitchButton.t - f;
        frsSortSwitchButton.t = f2;
        return f2;
    }

    public void setData(List<iq7> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, i) == null) {
            C();
            this.s = i;
            if (ListUtils.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.y.addAll(list);
            requestLayout();
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l.setColor(SkinManager.getColor(this.d));
            invalidate();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.s = 0;
            this.t = 0.0f;
            this.w = false;
            this.y.clear();
            this.z.clear();
            this.x = true;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            canvas.clipPath(this.p);
            super.onDraw(canvas);
            canvas.drawPath(this.p, this.l);
            t(canvas);
            for (int i = 0; i < this.y.size(); i++) {
                String str = this.y.get(i).a;
                float floatValue = this.z.get(i).floatValue() + this.i;
                float f = this.u;
                if (this.s == i) {
                    z = true;
                } else {
                    z = false;
                }
                u(canvas, str, floatValue, f, z);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            super.onMeasure(i, i2);
            float size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            float size2 = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            int count = ListUtils.getCount(this.y);
            float f = 0.0f;
            if (mode == Integer.MIN_VALUE) {
                this.a = 0.0f;
                for (int i3 = 0; i3 < count; i3++) {
                    iq7 iq7Var = (iq7) ListUtils.getItem(this.y, i3);
                    if (iq7Var != null) {
                        Paint paint = this.n;
                        String str = iq7Var.a;
                        if (str == null) {
                            str = "";
                        }
                        float measureText = paint.measureText(str) + (this.i * 2.0f);
                        if (this.x) {
                            this.z.add(Float.valueOf(this.a));
                        }
                        this.a += measureText;
                    }
                }
            } else {
                this.a = size;
                if (count > 0) {
                    size /= count;
                }
                for (int i4 = 0; i4 < count; i4++) {
                    if (this.x) {
                        this.z.add(Float.valueOf(f));
                    }
                    f += size;
                }
            }
            if (mode2 == Integer.MIN_VALUE) {
                this.b = this.c;
            } else {
                this.b = size2;
                this.c = size2;
            }
            this.x = false;
            z();
            setMeasuredDimension((int) this.a, (int) this.b);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        boolean z;
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, motionEvent)) == null) {
            if (this.A.onTouchEvent(motionEvent)) {
                return true;
            }
            if (!this.v || (motionEvent.getAction() != 1 && motionEvent.getAction() != 3)) {
                return false;
            }
            int i = this.s;
            int s = s();
            if (Math.abs(s - i) < 2 && s <= i) {
                if (s < i) {
                    float floatValue = this.z.get(s).floatValue();
                    int i2 = s + 1;
                    if (i2 < this.z.size()) {
                        f2 = this.z.get(i2).floatValue();
                    } else {
                        f2 = floatValue;
                    }
                    float f3 = this.t;
                    if (f3 >= floatValue && f3 <= floatValue + ((f2 - floatValue) / 2.0f)) {
                        this.s = s;
                    }
                } else {
                    float floatValue2 = this.z.get(s).floatValue();
                    int i3 = s + 1;
                    if (i3 < this.z.size()) {
                        f = this.z.get(i3).floatValue();
                    } else {
                        f = floatValue2;
                    }
                    if (this.t >= floatValue2 + ((f - floatValue2) / 2.0f) && i3 < this.z.size()) {
                        this.s = i3;
                    }
                }
            } else {
                this.s = s;
            }
            this.w = true;
            this.F = this.t;
            float floatValue3 = this.z.get(this.s).floatValue();
            this.E = Math.abs(this.F - floatValue3);
            int i4 = this.s;
            if (i4 < i) {
                this.G = true;
            } else if (i4 > i) {
                this.G = false;
            } else {
                if (this.F > floatValue3) {
                    z = true;
                } else {
                    z = false;
                }
                this.G = z;
            }
            ValueAnimator valueAnimator = this.D;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
            if (this.s != i) {
                v(i);
            }
            this.w = false;
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final int s() {
        InterceptResult invokeV;
        float floatValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = this.s;
            int i2 = 0;
            while (i2 < this.z.size()) {
                float floatValue2 = ((Float) ListUtils.getItem(this.z, i2)).floatValue();
                int i3 = i2 + 1;
                if (i3 == this.z.size()) {
                    floatValue = this.a;
                } else {
                    floatValue = ((Float) ListUtils.getItem(this.z, i3)).floatValue();
                }
                float f = this.t;
                if (f <= floatValue2 || f >= floatValue) {
                    float f2 = this.t;
                    if (f2 == floatValue2) {
                        if (i - 1 >= 0) {
                            return i - 1;
                        }
                    } else if (f2 == floatValue && (i2 = i + 1) < ListUtils.getCount(this.z)) {
                    }
                    i2 = i3;
                }
                return i2;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final void t(Canvas canvas) {
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            if (this.t < 0.0f) {
                this.t = 0.0f;
            }
            if (!ListUtils.isEmpty(this.z)) {
                f = ((Float) ListUtils.getItem(this.z, this.s)).floatValue();
            } else {
                f = 0.0f;
            }
            if (this.s + 1 < this.z.size()) {
                f2 = this.z.get(this.s + 1).floatValue();
            } else if (this.s + 1 == this.z.size()) {
                f2 = this.a;
            } else {
                f2 = 0.0f;
            }
            float f3 = this.t + (f2 - f);
            float f4 = this.a;
            if (f3 > f4) {
                f3 = f4;
            }
            this.q.set(this.t, 0.0f, f3, this.b);
            this.r.reset();
            Path path = this.r;
            RectF rectF = this.q;
            float f5 = this.c;
            path.addRoundRect(rectF, f5 / 2.0f, f5 / 2.0f, Path.Direction.CW);
            this.m.reset();
            this.m.setAntiAlias(true);
            this.m.setColor(SkinManager.getColor(this.e));
            canvas.drawPath(this.r, this.m);
            this.m.reset();
            this.m.setAntiAlias(true);
            this.m.setColor(SkinManager.getColor(this.k));
            this.m.setStyle(Paint.Style.STROKE);
            this.m.setStrokeWidth(this.j);
            RectF rectF2 = this.q;
            float f6 = this.t;
            float f7 = this.j;
            rectF2.set(f6 + (f7 / 2.0f), f7 / 2.0f, f3 - (f7 / 2.0f), this.c - (f7 / 2.0f));
            float f8 = (this.c - this.j) / 2.0f;
            canvas.drawRoundRect(this.q, f8, f8, this.m);
        }
    }

    public final void u(Canvas canvas, String str, float f, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{canvas, str, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            if (z) {
                this.n.setColor(SkinManager.getColor(this.g));
            } else {
                this.n.setColor(SkinManager.getColor(this.f));
            }
            canvas.drawText(str, f, f2, this.n);
        }
    }

    public final void w(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            this.o = new RectF();
            this.p = new Path();
            this.q = new RectF();
            this.r = new Path();
            Paint paint = new Paint(1);
            this.l = paint;
            paint.setColor(SkinManager.getColor(this.d));
            this.m = new Paint(1);
            Paint paint2 = new Paint(1);
            this.n = paint2;
            paint2.setTextSize(this.h);
            this.y = new ArrayList();
            this.z = new ArrayList();
            this.s = 0;
            this.A = new GestureDetector(context, this.B);
            x();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
            this.D = duration;
            duration.addUpdateListener(new b(this));
            this.D.addListener(new c(this));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            float f = 0.0f;
            this.o.set(0.0f, 0.0f, this.a, this.b);
            this.p.reset();
            Path path = this.p;
            RectF rectF = this.o;
            float f2 = this.b;
            path.addRoundRect(rectF, f2 / 2.0f, f2 / 2.0f, Path.Direction.CW);
            Float f3 = (Float) ListUtils.getItem(this.z, this.s);
            if (f3 != null) {
                f = f3.floatValue();
            }
            this.t = f;
            Paint.FontMetrics fontMetrics = this.n.getFontMetrics();
            this.u = (this.b / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f);
        }
    }
}
