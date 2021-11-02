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
import b.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SusPendedView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f46033e;

    /* renamed from: f  reason: collision with root package name */
    public TranView f46034f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f46035g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.q0.x0.a f46036h;

    /* renamed from: i  reason: collision with root package name */
    public float f46037i;
    public float j;
    public boolean k;
    public boolean l;
    public ValueAnimator m;
    public int n;
    public int o;
    public float p;
    public boolean q;

    /* loaded from: classes8.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SusPendedView f46038e;

        public a(SusPendedView susPendedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {susPendedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46038e = susPendedView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f46038e.n = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SusPendedView susPendedView = this.f46038e;
                susPendedView.p = 1.0f - (susPendedView.n / l.i(this.f46038e.getContext()));
                if (this.f46038e.n == 0) {
                    this.f46038e.p = 1.0f;
                } else if (this.f46038e.n == l.i(this.f46038e.getContext())) {
                    this.f46038e.p = 0.0f;
                    if (this.f46038e.l && (this.f46038e.getContext() instanceof Activity)) {
                        ((Activity) this.f46038e.getContext()).finish();
                    }
                }
                this.f46038e.requestLayout();
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
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, motionEvent)) != null) {
            return invokeL.booleanValue;
        }
        if (this.f46034f != null && this.q) {
            if (this.m.isRunning()) {
                this.m.end();
                return true;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        this.j = motionEvent.getRawY();
                        if (this.f46037i == 0.0f && isOnViewTop()) {
                            this.f46037i = motionEvent.getRawY();
                        }
                        this.p = 1.0f - ((this.j - this.f46037i) / l.i(getContext()));
                    }
                }
                z = this.j > this.f46037i && isOnViewTop();
                boolean z2 = this.j - this.f46037i > ((float) this.o) && isOnViewTop();
                this.l = z2;
                if (z2) {
                    this.m.setIntValues((int) (this.j - this.f46037i), l.i(getContext()));
                    this.m.start();
                } else {
                    this.p = 1.0f;
                    this.f46037i = 0.0f;
                    this.j = 0.0f;
                    requestLayout();
                }
                if (this.j <= this.f46037i && isOnViewTop()) {
                    this.k = true;
                    requestLayout();
                    return true;
                } else if (!z) {
                    this.k = true;
                    return true;
                } else {
                    this.k = false;
                    return super.dispatchTouchEvent(motionEvent);
                }
            }
            this.j = motionEvent.getRawY();
            if (isOnViewTop()) {
                this.f46037i = motionEvent.getRawY();
            } else {
                this.f46037i = 0.0f;
            }
            z = false;
            if (this.j <= this.f46037i) {
            }
            if (!z) {
            }
        } else {
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public boolean getIsFinish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b.a.q0.x0.a aVar = this.f46036h;
            if (aVar == null) {
                return false;
            }
            return aVar.isOnViewTop();
        }
        return invokeV.booleanValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.m.cancel();
            this.m.removeAllUpdateListeners();
            clearAnimation();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            if (isOnViewTop()) {
                float f2 = this.p;
                if (f2 >= 0.0f && this.f46034f != null) {
                    canvas.drawColor(Color.argb((int) (f2 * 168.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                }
            }
            super.onDraw(canvas);
        }
    }

    public void onFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = true;
            this.m.setIntValues(0, l.i(getContext()));
            this.m.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (this.m == null) {
                super.onLayout(z, i2, i3, i4, i5);
                return;
            }
            int i6 = this.n;
            if (i6 == 0) {
                super.onLayout(z, i2, i3, i4, i5);
                float f2 = this.j;
                float f3 = this.f46037i;
                if (f2 <= f3 || !this.k) {
                    return;
                }
                LinearLayout linearLayout = this.f46033e;
                linearLayout.layout(i2, (int) (f2 - f3), i4, ((int) (f2 - f3)) + linearLayout.getHeight());
                this.f46035g.layout(i2, ((int) (this.j - this.f46037i)) + this.f46033e.getHeight(), i4, i5);
                return;
            }
            LinearLayout linearLayout2 = this.f46033e;
            linearLayout2.layout(i2, i6, i4, linearLayout2.getMeasuredHeight() + i6);
            this.f46035g.layout(i2, this.n + this.f46033e.getMeasuredHeight(), i4, i5);
        }
    }

    public void setCanDragClose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.q = z;
        }
    }

    public void setContentView(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, linearLayout) == null) {
            this.f46035g = linearLayout;
        }
    }

    public void setContentViewTop(b.a.q0.x0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f46036h = aVar;
        }
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, linearLayout) == null) {
            this.f46033e = linearLayout;
        }
    }

    public void setTranView(TranView tranView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, tranView) == null) {
            this.f46034f = tranView;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.p == 0.0f) {
            this.m.start();
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
    public SusPendedView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.p = 0.0f;
        this.q = true;
        this.o = (l.i(context) / 3) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.n = l.i(context);
        ValueAnimator ofInt = ValueAnimator.ofInt(l.i(context), 0);
        this.m = ofInt;
        ofInt.setDuration(300L);
        this.m.setInterpolator(new LinearInterpolator());
        this.m.addUpdateListener(new a(this));
    }
}
