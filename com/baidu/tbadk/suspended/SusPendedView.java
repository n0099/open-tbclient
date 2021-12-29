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
import c.a.s0.y0.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class SusPendedView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f42586e;

    /* renamed from: f  reason: collision with root package name */
    public TranView f42587f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f42588g;

    /* renamed from: h  reason: collision with root package name */
    public b f42589h;

    /* renamed from: i  reason: collision with root package name */
    public float f42590i;

    /* renamed from: j  reason: collision with root package name */
    public float f42591j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f42592k;
    public boolean l;
    public ValueAnimator m;
    public int n;
    public int o;
    public float p;
    public boolean q;

    /* loaded from: classes11.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SusPendedView f42593e;

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
            this.f42593e = susPendedView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f42593e.n = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SusPendedView susPendedView = this.f42593e;
                susPendedView.p = 1.0f - (susPendedView.n / n.i(this.f42593e.getContext()));
                if (this.f42593e.n == 0) {
                    this.f42593e.p = 1.0f;
                } else if (this.f42593e.n == n.i(this.f42593e.getContext())) {
                    this.f42593e.p = 0.0f;
                    if (this.f42593e.l && (this.f42593e.getContext() instanceof Activity)) {
                        ((Activity) this.f42593e.getContext()).finish();
                    }
                }
                this.f42593e.requestLayout();
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
        if (this.f42587f != null && this.q) {
            if (this.m.isRunning()) {
                this.m.end();
                return true;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        this.f42591j = motionEvent.getRawY();
                        if (this.f42590i == 0.0f && isOnViewTop()) {
                            this.f42590i = motionEvent.getRawY();
                        }
                        this.p = 1.0f - ((this.f42591j - this.f42590i) / n.i(getContext()));
                    }
                }
                z = this.f42591j > this.f42590i && isOnViewTop();
                boolean z2 = this.f42591j - this.f42590i > ((float) this.o) && isOnViewTop();
                this.l = z2;
                if (z2) {
                    this.m.setIntValues((int) (this.f42591j - this.f42590i), n.i(getContext()));
                    this.m.start();
                } else {
                    this.p = 1.0f;
                    this.f42590i = 0.0f;
                    this.f42591j = 0.0f;
                    requestLayout();
                }
                if (this.f42591j <= this.f42590i && isOnViewTop()) {
                    this.f42592k = true;
                    requestLayout();
                    return true;
                } else if (!z) {
                    this.f42592k = true;
                    return true;
                } else {
                    this.f42592k = false;
                    return super.dispatchTouchEvent(motionEvent);
                }
            }
            this.f42591j = motionEvent.getRawY();
            if (isOnViewTop()) {
                this.f42590i = motionEvent.getRawY();
            } else {
                this.f42590i = 0.0f;
            }
            z = false;
            if (this.f42591j <= this.f42590i) {
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
            b bVar = this.f42589h;
            if (bVar == null) {
                return false;
            }
            return bVar.isOnViewTop();
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
                if (f2 >= 0.0f && this.f42587f != null) {
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
            this.m.setIntValues(0, n.i(getContext()));
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
                float f2 = this.f42591j;
                float f3 = this.f42590i;
                if (f2 <= f3 || !this.f42592k) {
                    return;
                }
                b bVar = this.f42589h;
                if (bVar instanceof c.a.s0.y0.a) {
                    ((c.a.s0.y0.a) bVar).b(f2 - f3);
                }
                LinearLayout linearLayout = this.f42586e;
                float f4 = this.f42591j;
                float f5 = this.f42590i;
                linearLayout.layout(i2, (int) (f4 - f5), i4, ((int) (f4 - f5)) + linearLayout.getHeight());
                this.f42588g.layout(i2, ((int) (this.f42591j - this.f42590i)) + this.f42586e.getHeight(), i4, i5);
                return;
            }
            LinearLayout linearLayout2 = this.f42586e;
            linearLayout2.layout(i2, i6, i4, linearLayout2.getMeasuredHeight() + i6);
            this.f42588g.layout(i2, this.n + this.f42586e.getMeasuredHeight(), i4, i5);
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
            this.f42588g = linearLayout;
        }
    }

    public void setContentViewTop(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f42589h = bVar;
        }
    }

    public void setNavigationBar(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, linearLayout) == null) {
            this.f42586e = linearLayout;
        }
    }

    public void setTranView(TranView tranView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, tranView) == null) {
            this.f42587f = tranView;
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
        this.o = (n.i(context) / 3) - n.f(TbadkCoreApplication.getInst(), R.dimen.tbds153);
        this.n = n.i(context);
        ValueAnimator ofInt = ValueAnimator.ofInt(n.i(context), 0);
        this.m = ofInt;
        ofInt.setDuration(300L);
        this.m.setInterpolator(new LinearInterpolator());
        this.m.addUpdateListener(new a(this));
    }
}
