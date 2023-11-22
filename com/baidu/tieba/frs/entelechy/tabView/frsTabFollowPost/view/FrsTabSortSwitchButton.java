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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.jq7;
import com.baidu.tieba.lr7;
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
/* loaded from: classes6.dex */
public class FrsTabSortSwitchButton extends View implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<jq7> A;
    public List<Float> B;
    public GestureDetector C;
    public GestureDetector.SimpleOnGestureListener D;
    public e E;
    public ValueAnimator F;
    public float G;
    public float H;
    public boolean I;
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
    public String l;
    public String m;
    public Paint n;
    public Paint o;
    public Paint p;
    public RectF q;
    public Path r;
    public RectF s;
    public Path t;
    public int u;
    public float v;
    public float w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes6.dex */
    public interface e {
        boolean a(int i);
    }

    /* loaded from: classes6.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabSortSwitchButton a;

        public a(FrsTabSortSwitchButton frsTabSortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabSortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabSortSwitchButton;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (this.a.y || motionEvent.getX() > this.a.a || motionEvent.getY() > this.a.b) {
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
            int i = this.a.u;
            this.a.v = motionEvent.getX();
            FrsTabSortSwitchButton frsTabSortSwitchButton = this.a;
            frsTabSortSwitchButton.u = frsTabSortSwitchButton.s();
            this.a.y = true;
            if (this.a.u != i) {
                this.a.E(i);
                if (this.a.F != null) {
                    this.a.F.start();
                }
                this.a.x(i);
            }
            this.a.y = false;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (!this.a.x) {
                    return false;
                }
                FrsTabSortSwitchButton.m(this.a, f);
                float f3 = 0.0f;
                if (this.a.v < 0.0f) {
                    this.a.v = 0.0f;
                }
                Float f4 = (Float) ListUtils.getItem(this.a.B, this.a.B.size() - 1);
                if (f4 != null) {
                    f3 = f4.floatValue();
                }
                if (this.a.v > f3) {
                    this.a.v = f3;
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
        public final /* synthetic */ FrsTabSortSwitchButton a;

        public b(FrsTabSortSwitchButton frsTabSortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabSortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabSortSwitchButton;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * this.a.G;
                if (this.a.I) {
                    FrsTabSortSwitchButton frsTabSortSwitchButton = this.a;
                    frsTabSortSwitchButton.v = frsTabSortSwitchButton.H - floatValue;
                } else {
                    FrsTabSortSwitchButton frsTabSortSwitchButton2 = this.a;
                    frsTabSortSwitchButton2.v = frsTabSortSwitchButton2.H + floatValue;
                }
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabSortSwitchButton a;

        public c(FrsTabSortSwitchButton frsTabSortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabSortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabSortSwitchButton;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                Float f = (Float) ListUtils.getItem(this.a.B, this.a.u);
                if (f != null) {
                    this.a.v = f.floatValue();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Comparator<FrsTabInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsTabSortSwitchButton a;

        public d(FrsTabSortSwitchButton frsTabSortSwitchButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabSortSwitchButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsTabSortSwitchButton;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(FrsTabInfo frsTabInfo, FrsTabInfo frsTabInfo2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, frsTabInfo, frsTabInfo2)) == null) {
                return frsTabInfo.tab_id.intValue() - frsTabInfo2.tab_id.intValue();
            }
            return invokeLL.intValue;
        }
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

    public final void E(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.H = this.B.get(i).floatValue();
            this.G = Math.abs(this.B.get(this.u).floatValue() - this.H);
            if (this.u < i) {
                z = true;
            } else {
                z = false;
            }
            this.I = z;
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            for (int i2 = 0; i2 < this.A.size(); i2++) {
                if (this.A.get(i2).b == i) {
                    this.u = i2;
                    if (i2 < this.B.size()) {
                        this.v = this.B.get(i2).floatValue();
                    }
                    invalidate();
                    return;
                }
            }
        }
    }

    public final void x(int i) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i) == null) && (eVar = this.E) != null && !eVar.a(this.u)) {
            ValueAnimator valueAnimator = this.F;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.u = i;
            this.v = this.B.get(i).floatValue();
            invalidate();
        }
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

    public final void A(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, lr7.FrsTabSortSwitchButton);
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
    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.x = false;
        this.y = false;
        this.z = true;
        this.D = new a(this);
        A(context, attributeSet);
        y(context);
        setOnTouchListener(this);
    }

    public void setCanScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.x = z;
        }
    }

    public void setOnSwitchChangeListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.E = eVar;
        }
    }

    public int w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            jq7 jq7Var = (jq7) ListUtils.getItem(this.A, i);
            if (jq7Var == null) {
                return -1;
            }
            return jq7Var.b;
        }
        return invokeI.intValue;
    }

    public static /* synthetic */ float m(FrsTabSortSwitchButton frsTabSortSwitchButton, float f) {
        float f2 = frsTabSortSwitchButton.v - f;
        frsTabSortSwitchButton.v = f2;
        return f2;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            float f = 0.0f;
            this.q.set(0.0f, 0.0f, this.a, this.b);
            this.r.reset();
            Path path = this.r;
            RectF rectF = this.q;
            float f2 = this.b;
            path.addRoundRect(rectF, f2 / 2.0f, f2 / 2.0f, Path.Direction.CW);
            Float f3 = (Float) ListUtils.getItem(this.B, this.u);
            if (f3 != null) {
                f = f3.floatValue();
            }
            this.v = f;
            Paint.FontMetrics fontMetrics = this.p.getFontMetrics();
            this.w = (this.b / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f);
        }
    }

    public final boolean C(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return true;
            }
            Collections.sort(list, new d(this));
            int size = list.size();
            if (size != this.A.size()) {
                return true;
            }
            for (int i = 0; i < size; i++) {
                jq7 jq7Var = this.A.get(i);
                FrsTabInfo frsTabInfo = list.get(i);
                if (frsTabInfo.tab_id.intValue() != jq7Var.b) {
                    return true;
                }
                if (frsTabInfo.tab_id.intValue() == 2 && !jq7Var.a.equals(this.l)) {
                    return true;
                }
                if (frsTabInfo.tab_id.intValue() == 3 && !jq7Var.a.equals(this.m)) {
                    return true;
                }
                if (frsTabInfo.tab_id.intValue() != 2 && frsTabInfo.tab_id.intValue() != 3) {
                    String str = frsTabInfo.tab_name;
                    if (str != null && str.length() > 5) {
                        if (!jq7Var.a.equals(frsTabInfo.tab_name.substring(0, 5))) {
                            return true;
                        }
                    } else if (!jq7Var.a.equals(frsTabInfo.tab_name)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setData(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, list) != null) || !C(list)) {
            return;
        }
        F();
        if (ListUtils.isEmpty(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        for (int i = 0; i < list.size(); i++) {
            jq7 jq7Var = new jq7();
            jq7Var.b = list.get(i).tab_id.intValue();
            if (list.get(i).tab_id.intValue() == 2) {
                if (list.get(i).tab_type.intValue() == 16) {
                    jq7Var.a = "最热";
                } else {
                    jq7Var.a = this.l;
                }
            } else if (list.get(i).tab_id.intValue() == 3) {
                if (list.get(i).tab_type.intValue() == 16) {
                    jq7Var.a = "最新";
                } else {
                    jq7Var.a = this.m;
                }
            } else {
                String str = list.get(i).tab_name;
                jq7Var.a = str;
                if (str == null) {
                    jq7Var.a = "";
                } else if (str.length() > 5) {
                    jq7Var.a = jq7Var.a.substring(0, 5);
                }
            }
            this.A.add(jq7Var);
        }
        requestLayout();
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.n.setColor(SkinManager.getColor(this.d));
            invalidate();
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.u = 0;
            this.v = 0.0f;
            this.y = false;
            this.A.clear();
            this.B.clear();
            this.z = true;
        }
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.u;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            canvas.clipPath(this.r);
            super.onDraw(canvas);
            canvas.drawPath(this.r, this.n);
            u(canvas);
            for (int i = 0; i < this.A.size(); i++) {
                String str = this.A.get(i).a;
                float floatValue = this.B.get(i).floatValue() + this.i;
                float f = this.w;
                if (this.u == i) {
                    z = true;
                } else {
                    z = false;
                }
                v(canvas, str, floatValue, f, z);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            super.onMeasure(i, i2);
            float size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            float size2 = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            int count = ListUtils.getCount(this.A);
            float f = 0.0f;
            if (mode == Integer.MIN_VALUE) {
                this.a = 0.0f;
                for (int i3 = 0; i3 < count; i3++) {
                    jq7 jq7Var = (jq7) ListUtils.getItem(this.A, i3);
                    if (jq7Var != null) {
                        Paint paint = this.p;
                        String str = jq7Var.a;
                        if (str == null) {
                            str = "";
                        }
                        float measureText = paint.measureText(str) + (this.i * 2.0f);
                        if (this.z) {
                            this.B.add(Float.valueOf(this.a));
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
                    if (this.z) {
                        this.B.add(Float.valueOf(f));
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
            this.z = false;
            B();
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, view2, motionEvent)) == null) {
            if (this.C.onTouchEvent(motionEvent)) {
                return true;
            }
            if (!this.x || (motionEvent.getAction() != 1 && motionEvent.getAction() != 3)) {
                return false;
            }
            int i = this.u;
            int s = s();
            if (Math.abs(s - i) < 2 && s <= i) {
                if (s < i) {
                    float floatValue = this.B.get(s).floatValue();
                    int i2 = s + 1;
                    if (i2 < this.B.size()) {
                        f2 = this.B.get(i2).floatValue();
                    } else {
                        f2 = floatValue;
                    }
                    float f3 = this.v;
                    if (f3 >= floatValue && f3 <= floatValue + ((f2 - floatValue) / 2.0f)) {
                        this.u = s;
                    }
                } else {
                    float floatValue2 = this.B.get(s).floatValue();
                    int i3 = s + 1;
                    if (i3 < this.B.size()) {
                        f = this.B.get(i3).floatValue();
                    } else {
                        f = floatValue2;
                    }
                    if (this.v >= floatValue2 + ((f - floatValue2) / 2.0f) && i3 < this.B.size()) {
                        this.u = i3;
                    }
                }
            } else {
                this.u = s;
            }
            this.y = true;
            this.H = this.v;
            float floatValue3 = this.B.get(this.u).floatValue();
            this.G = Math.abs(this.H - floatValue3);
            int i4 = this.u;
            if (i4 < i) {
                this.I = true;
            } else if (i4 > i) {
                this.I = false;
            } else {
                if (this.H > floatValue3) {
                    z = true;
                } else {
                    z = false;
                }
                this.I = z;
            }
            ValueAnimator valueAnimator = this.F;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
            if (this.u != i) {
                x(i);
            }
            this.y = false;
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final int s() {
        InterceptResult invokeV;
        float floatValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.u;
            int i2 = 0;
            while (i2 < this.B.size()) {
                float floatValue2 = ((Float) ListUtils.getItem(this.B, i2)).floatValue();
                int i3 = i2 + 1;
                if (i3 == this.B.size()) {
                    floatValue = this.a;
                } else {
                    floatValue = ((Float) ListUtils.getItem(this.B, i3)).floatValue();
                }
                float f = this.v;
                if (f <= floatValue2 || f >= floatValue) {
                    float f2 = this.v;
                    if (f2 == floatValue2) {
                        if (i - 1 >= 0) {
                            return i - 1;
                        }
                    } else if (f2 == floatValue && (i2 = i + 1) < ListUtils.getCount(this.B)) {
                    }
                    i2 = i3;
                }
                return i2;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final void u(Canvas canvas) {
        float f;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, canvas) == null) {
            if (this.v < 0.0f) {
                this.v = 0.0f;
            }
            if (!ListUtils.isEmpty(this.B)) {
                f = ((Float) ListUtils.getItem(this.B, this.u)).floatValue();
            } else {
                f = 0.0f;
            }
            if (this.u + 1 < this.B.size()) {
                f2 = this.B.get(this.u + 1).floatValue();
            } else if (this.u + 1 == this.B.size()) {
                f2 = this.a;
            } else {
                f2 = 0.0f;
            }
            float f3 = this.v + (f2 - f);
            float f4 = this.a;
            if (f3 > f4) {
                f3 = f4;
            }
            this.s.set(this.v, 0.0f, f3, this.b);
            this.t.reset();
            Path path = this.t;
            RectF rectF = this.s;
            float f5 = this.c;
            path.addRoundRect(rectF, f5 / 2.0f, f5 / 2.0f, Path.Direction.CW);
            this.o.reset();
            this.o.setAntiAlias(true);
            this.o.setColor(SkinManager.getColor(this.e));
            canvas.drawPath(this.t, this.o);
            this.o.reset();
            this.o.setAntiAlias(true);
            this.o.setColor(SkinManager.getColor(this.k));
            this.o.setStyle(Paint.Style.STROKE);
            this.o.setStrokeWidth(this.j);
            RectF rectF2 = this.s;
            float f6 = this.v;
            float f7 = this.j;
            rectF2.set(f6 + (f7 / 2.0f), f7 / 2.0f, f3 - (f7 / 2.0f), this.c - (f7 / 2.0f));
            float f8 = (this.c - this.j) / 2.0f;
            canvas.drawRoundRect(this.s, f8, f8, this.o);
        }
    }

    public final void v(Canvas canvas, String str, float f, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{canvas, str, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            if (z) {
                this.p.setColor(SkinManager.getColor(this.g));
            } else {
                this.p.setColor(SkinManager.getColor(this.f));
            }
            canvas.drawText(str, f, f2, this.p);
        }
    }

    public final void y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, context) == null) {
            this.q = new RectF();
            this.r = new Path();
            this.s = new RectF();
            this.t = new Path();
            Paint paint = new Paint(1);
            this.n = paint;
            paint.setColor(SkinManager.getColor(this.d));
            this.o = new Paint(1);
            Paint paint2 = new Paint(1);
            this.p = paint2;
            paint2.setTextSize(this.h);
            this.A = new ArrayList();
            this.B = new ArrayList();
            this.u = 0;
            this.C = new GestureDetector(context, this.D);
            this.l = getResources().getString(R.string.reply_post_frs);
            this.m = getResources().getString(R.string.send_post);
            z();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
            this.F = duration;
            duration.addUpdateListener(new b(this));
            this.F.addListener(new c(this));
        }
    }
}
