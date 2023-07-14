package com.baidu.tbadk.suspended;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.vu5;
import com.baidu.tieba.wu5;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SusPendedView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public TranView b;
    public LinearLayout c;
    public wu5 d;
    public float e;
    public float f;
    public boolean g;
    public boolean h;
    public ValueAnimator i;
    public int j;
    public int k;
    public float l;
    public boolean m;

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SusPendedView a;

        public a(SusPendedView susPendedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {susPendedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = susPendedView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.j = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SusPendedView susPendedView = this.a;
                susPendedView.l = 1.0f - (susPendedView.j / yi.j(this.a.getContext()));
                if (this.a.j != 0) {
                    if (this.a.j == yi.j(this.a.getContext())) {
                        this.a.l = 0.0f;
                        this.a.f();
                    }
                } else {
                    this.a.l = 1.0f;
                }
                this.a.requestLayout();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SusPendedView(Context context) {
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

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) {
            if (d()) {
                float f = this.l;
                if (f >= 0.0f && this.b != null) {
                    canvas.drawColor(Color.argb((int) (f * 168.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                }
            }
            super.onDraw(canvas);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SusPendedView(Context context, @Nullable AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SusPendedView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.l = 0.0f;
        this.m = true;
        this.k = (yi.j(context) / 3) - yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.j = yi.j(context);
        ValueAnimator ofInt = ValueAnimator.ofInt(yi.j(context), 0);
        this.i = ofInt;
        ofInt.setDuration(300L);
        this.i.setInterpolator(new LinearInterpolator());
        this.i.addUpdateListener(new a(this));
    }

    public void setCanDragClose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.m = z;
        }
    }

    public void setContentView(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, linearLayout) == null) {
            this.c = linearLayout;
        }
    }

    public void setContentViewTop(wu5 wu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, wu5Var) == null) {
            this.d = wu5Var;
        }
    }

    public void setIsFinish(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.h = z;
        }
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, linearLayout) == null) {
            this.a = linearLayout;
        }
    }

    public void setRatio(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f) == null) {
            this.l = f;
        }
    }

    public void setTranView(TranView tranView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, tranView) == null) {
            this.b = tranView;
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            wu5 wu5Var = this.d;
            if (wu5Var == null) {
                return false;
            }
            return wu5Var.A();
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.h && (getContext() instanceof Activity)) {
            ((Activity) getContext()).finish();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.i.cancel();
            this.i.removeAllUpdateListeners();
            clearAnimation();
        }
    }

    public boolean getIsFinish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.l;
        }
        return invokeV.floatValue;
    }

    public ValueAnimator getTranAnim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.i;
        }
        return (ValueAnimator) invokeV.objValue;
    }

    public TranView getTranView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (TranView) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.h = true;
            this.i.setIntValues(0, yi.j(getContext()));
            this.i.start();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.l == 0.0f) {
            this.i.start();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
        if (r0 != 3) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00de  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (this.b != null && this.m) {
                if (this.i.isRunning()) {
                    this.i.end();
                    return true;
                }
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            this.f = motionEvent.getRawY();
                            if (this.e == 0.0f && d()) {
                                this.e = motionEvent.getRawY();
                            }
                            this.l = 1.0f - ((this.f - this.e) / yi.j(getContext()));
                        }
                    }
                    if (this.f > this.e && d()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.f - this.e > this.k && d()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.h = z2;
                    if (z2) {
                        this.i.setIntValues((int) (this.f - this.e), yi.j(getContext()));
                        this.i.start();
                    } else {
                        this.l = 1.0f;
                        this.e = 0.0f;
                        this.f = 0.0f;
                        requestLayout();
                    }
                    if (this.f <= this.e && d()) {
                        this.g = true;
                        requestLayout();
                        return true;
                    } else if (!z) {
                        this.g = true;
                        return true;
                    } else {
                        this.g = false;
                        return super.dispatchTouchEvent(motionEvent);
                    }
                }
                this.f = motionEvent.getRawY();
                if (d()) {
                    this.e = motionEvent.getRawY();
                } else {
                    this.e = 0.0f;
                }
                z = false;
                if (this.f <= this.e) {
                }
                if (!z) {
                }
            } else {
                return super.dispatchTouchEvent(motionEvent);
            }
        } else {
            return invokeL.booleanValue;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (this.i == null) {
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            int i5 = this.j;
            if (i5 == 0) {
                super.onLayout(z, i, i2, i3, i4);
                float f = this.f;
                float f2 = this.e;
                if (f > f2 && this.g) {
                    wu5 wu5Var = this.d;
                    if (wu5Var instanceof vu5) {
                        ((vu5) wu5Var).P(f - f2);
                    }
                    LinearLayout linearLayout = this.a;
                    float f3 = this.f;
                    float f4 = this.e;
                    linearLayout.layout(i, (int) (f3 - f4), i3, ((int) (f3 - f4)) + linearLayout.getHeight());
                    this.c.layout(i, ((int) (this.f - this.e)) + this.a.getHeight(), i3, i4);
                    return;
                }
                return;
            }
            LinearLayout linearLayout2 = this.a;
            linearLayout2.layout(i, i5, i3, linearLayout2.getMeasuredHeight() + i5);
            this.c.layout(i, this.j + this.a.getMeasuredHeight(), i3, i4);
        }
    }
}
