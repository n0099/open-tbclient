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
import c.a.d.f.p.n;
import c.a.o0.x0.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SusPendedView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public TranView f30622b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f30623c;

    /* renamed from: d  reason: collision with root package name */
    public b f30624d;

    /* renamed from: e  reason: collision with root package name */
    public float f30625e;

    /* renamed from: f  reason: collision with root package name */
    public float f30626f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30627g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30628h;
    public ValueAnimator i;
    public int j;
    public int k;
    public float l;
    public boolean m;

    /* loaded from: classes5.dex */
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
                susPendedView.l = 1.0f - (susPendedView.j / n.i(this.a.getContext()));
                if (this.a.j == 0) {
                    this.a.l = 1.0f;
                } else if (this.a.j == n.i(this.a.getContext())) {
                    this.a.l = 0.0f;
                    if (this.a.f30628h && (this.a.getContext() instanceof Activity)) {
                        ((Activity) this.a.getContext()).finish();
                    }
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
        if (this.f30622b != null && this.m) {
            if (this.i.isRunning()) {
                this.i.end();
                return true;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        this.f30626f = motionEvent.getRawY();
                        if (this.f30625e == 0.0f && e()) {
                            this.f30625e = motionEvent.getRawY();
                        }
                        this.l = 1.0f - ((this.f30626f - this.f30625e) / n.i(getContext()));
                    }
                }
                z = this.f30626f > this.f30625e && e();
                boolean z2 = this.f30626f - this.f30625e > ((float) this.k) && e();
                this.f30628h = z2;
                if (z2) {
                    this.i.setIntValues((int) (this.f30626f - this.f30625e), n.i(getContext()));
                    this.i.start();
                } else {
                    this.l = 1.0f;
                    this.f30625e = 0.0f;
                    this.f30626f = 0.0f;
                    requestLayout();
                }
                if (this.f30626f <= this.f30625e && e()) {
                    this.f30627g = true;
                    requestLayout();
                    return true;
                } else if (!z) {
                    this.f30627g = true;
                    return true;
                } else {
                    this.f30627g = false;
                    return super.dispatchTouchEvent(motionEvent);
                }
            }
            this.f30626f = motionEvent.getRawY();
            if (e()) {
                this.f30625e = motionEvent.getRawY();
            } else {
                this.f30625e = 0.0f;
            }
            z = false;
            if (this.f30626f <= this.f30625e) {
            }
            if (!z) {
            }
        } else {
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = this.f30624d;
            if (bVar == null) {
                return false;
            }
            return bVar.isOnViewTop();
        }
        return invokeV.booleanValue;
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.i.cancel();
            this.i.removeAllUpdateListeners();
            clearAnimation();
        }
    }

    public boolean getIsFinish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30628h : invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f30628h = true;
            this.i.setIntValues(0, n.i(getContext()));
            this.i.start();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.l == 0.0f) {
            this.i.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            if (e()) {
                float f2 = this.l;
                if (f2 >= 0.0f && this.f30622b != null) {
                    canvas.drawColor(Color.argb((int) (f2 * 168.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                }
            }
            super.onDraw(canvas);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (this.i == null) {
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            int i5 = this.j;
            if (i5 == 0) {
                super.onLayout(z, i, i2, i3, i4);
                float f2 = this.f30626f;
                float f3 = this.f30625e;
                if (f2 <= f3 || !this.f30627g) {
                    return;
                }
                b bVar = this.f30624d;
                if (bVar instanceof c.a.o0.x0.a) {
                    ((c.a.o0.x0.a) bVar).v(f2 - f3);
                }
                LinearLayout linearLayout = this.a;
                float f4 = this.f30626f;
                float f5 = this.f30625e;
                linearLayout.layout(i, (int) (f4 - f5), i3, ((int) (f4 - f5)) + linearLayout.getHeight());
                this.f30623c.layout(i, ((int) (this.f30626f - this.f30625e)) + this.a.getHeight(), i3, i4);
                return;
            }
            LinearLayout linearLayout2 = this.a;
            linearLayout2.layout(i, i5, i3, linearLayout2.getMeasuredHeight() + i5);
            this.f30623c.layout(i, this.j + this.a.getMeasuredHeight(), i3, i4);
        }
    }

    public void setCanDragClose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.m = z;
        }
    }

    public void setContentView(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, linearLayout) == null) {
            this.f30623c = linearLayout;
        }
    }

    public void setContentViewTop(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f30624d = bVar;
        }
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, linearLayout) == null) {
            this.a = linearLayout;
        }
    }

    public void setTranView(TranView tranView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, tranView) == null) {
            this.f30622b = tranView;
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
        this.k = (n.i(context) / 3) - n.f(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.j = n.i(context);
        ValueAnimator ofInt = ValueAnimator.ofInt(n.i(context), 0);
        this.i = ofInt;
        ofInt.setDuration(300L);
        this.i.setInterpolator(new LinearInterpolator());
        this.i.addUpdateListener(new a(this));
    }
}
