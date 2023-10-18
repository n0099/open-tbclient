package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public float c;
    public float d;
    public ValueAnimator e;
    public float f;
    public int g;

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FlexibleHorizontalScrollView a;

        public a(FlexibleHorizontalScrollView flexibleHorizontalScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flexibleHorizontalScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = flexibleHorizontalScrollView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlexibleHorizontalScrollView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 150;
        this.d = 0.0f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlexibleHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 150;
        this.d = 0.0f;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.e == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.e = valueAnimator;
                valueAnimator.setDuration(200L);
                this.e.setInterpolator(new DecelerateInterpolator());
                this.e.addUpdateListener(new a(this));
            }
            if (this.g == 0) {
                setOverScrollMode(2);
                int a2 = vc.a(getContext());
                this.g = a2;
                this.f = (this.a * 1.0f) / a2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
        if (r3 != 3) goto L19;
     */
    @Override // android.widget.HorizontalScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            int scrollX = getScrollX();
            float x = getX();
            if (scrollX > 0 && scrollX < this.b && x == 0.0f) {
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction() & 255;
            int i = this.a;
            c();
            if (action != 0) {
                int i2 = 0;
                if (action != 1) {
                    if (action == 2) {
                        float rawX = motionEvent.getRawX() - this.c;
                        if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                            this.c = motionEvent.getRawX();
                            return true;
                        }
                        float f = this.d;
                        if (f * rawX < 0.0f) {
                            this.d = f + rawX;
                        } else {
                            this.d = f + (rawX * this.f);
                        }
                        this.c = motionEvent.getRawX();
                        if (scrollX == 0) {
                            i2 = 1;
                        } else if (scrollX == this.b) {
                            i2 = -1;
                        }
                        if (i2 != 0) {
                            float f2 = i2;
                            float f3 = this.d;
                            if (f2 * f3 > i) {
                                this.d = i2 * i;
                                this.c = motionEvent.getRawX();
                            } else if (f2 * f3 < 0.0f) {
                                this.d = 0.0f;
                                this.c = motionEvent.getRawX();
                                setX(0.0f);
                                return super.onTouchEvent(motionEvent);
                            }
                            setX(this.d);
                            return true;
                        }
                    }
                }
                if (x != 0.0f) {
                    this.d = 0.0f;
                    this.c = 0.0f;
                    this.e.setFloatValues(x, 0.0f);
                    this.e.start();
                    return true;
                }
            } else {
                if (this.e.isRunning()) {
                    this.e.cancel();
                }
                this.c = motionEvent.getRawX();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z)})) == null) {
            this.b = i5;
            return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        }
        return invokeCommon.booleanValue;
    }

    public void setMaxOverScrollDistance(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || i <= 0) {
            return;
        }
        this.a = i;
        this.f = (i * 1.0f) / this.g;
    }
}
