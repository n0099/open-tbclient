package com.baidu.tbadk.widget.horizonalScrollListView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import c.a.e.e.p.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class FlexibleHorizontalScrollView extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f48682e;

    /* renamed from: f  reason: collision with root package name */
    public int f48683f;

    /* renamed from: g  reason: collision with root package name */
    public float f48684g;

    /* renamed from: h  reason: collision with root package name */
    public float f48685h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f48686i;

    /* renamed from: j  reason: collision with root package name */
    public float f48687j;
    public int k;

    /* loaded from: classes6.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FlexibleHorizontalScrollView f48688e;

        public a(FlexibleHorizontalScrollView flexibleHorizontalScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flexibleHorizontalScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48688e = flexibleHorizontalScrollView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f48688e.setX(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48682e = 150;
        this.f48685h = 0.0f;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f48686i == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f48686i = valueAnimator;
                valueAnimator.setDuration(200L);
                this.f48686i.setInterpolator(new DecelerateInterpolator());
                this.f48686i.addUpdateListener(new a(this));
            }
            if (this.k == 0) {
                setOverScrollMode(2);
                int a2 = e.a(getContext());
                this.k = a2;
                this.f48687j = (this.f48682e * 1.0f) / a2;
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
            if (scrollX > 0 && scrollX < this.f48683f && x == 0.0f) {
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction() & 255;
            int i2 = this.f48682e;
            a();
            if (action != 0) {
                int i3 = 0;
                if (action != 1) {
                    if (action == 2) {
                        float rawX = motionEvent.getRawX() - this.f48684g;
                        if (Math.abs(rawX) > 50.0f && x == 0.0f) {
                            this.f48684g = motionEvent.getRawX();
                            return true;
                        }
                        float f2 = this.f48685h;
                        if (f2 * rawX < 0.0f) {
                            this.f48685h = f2 + rawX;
                        } else {
                            this.f48685h = f2 + (rawX * this.f48687j);
                        }
                        this.f48684g = motionEvent.getRawX();
                        if (scrollX == 0) {
                            i3 = 1;
                        } else if (scrollX == this.f48683f) {
                            i3 = -1;
                        }
                        if (i3 != 0) {
                            float f3 = i3;
                            float f4 = this.f48685h;
                            if (f3 * f4 > i2) {
                                this.f48685h = i3 * i2;
                                this.f48684g = motionEvent.getRawX();
                            } else if (f3 * f4 < 0.0f) {
                                this.f48685h = 0.0f;
                                this.f48684g = motionEvent.getRawX();
                                setX(0.0f);
                                return super.onTouchEvent(motionEvent);
                            }
                            setX(this.f48685h);
                            return true;
                        }
                    }
                }
                if (x != 0.0f) {
                    this.f48685h = 0.0f;
                    this.f48684g = 0.0f;
                    this.f48686i.setFloatValues(x, 0.0f);
                    this.f48686i.start();
                    return true;
                }
            } else {
                if (this.f48686i.isRunning()) {
                    this.f48686i.cancel();
                }
                this.f48684g = motionEvent.getRawX();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Boolean.valueOf(z)})) == null) {
            this.f48683f = i6;
            return super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z);
        }
        return invokeCommon.booleanValue;
    }

    public void setMaxOverScrollDistance(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f48682e = i2;
        this.f48687j = (i2 * 1.0f) / this.k;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48682e = 150;
        this.f48685h = 0.0f;
    }
}
