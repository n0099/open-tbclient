package com.baidu.tieba.frs.accelerator.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import c.a.t0.d1.j1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class ProgressCircle extends View {
    public static /* synthetic */ Interceptable $ic;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43187e;

    /* renamed from: f  reason: collision with root package name */
    public int f43188f;

    /* renamed from: g  reason: collision with root package name */
    public int f43189g;

    /* renamed from: h  reason: collision with root package name */
    public int f43190h;

    /* renamed from: i  reason: collision with root package name */
    public int f43191i;

    /* renamed from: j  reason: collision with root package name */
    public int f43192j;
    public float k;
    public int l;
    public int m;
    public RectF n;
    public Paint o;
    public Paint p;
    public Paint q;
    public Paint r;
    public Paint s;
    public float t;
    public long u;

    /* loaded from: classes12.dex */
    public class a extends Paint {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ProgressCircle a;

        public a(ProgressCircle progressCircle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {progressCircle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = progressCircle;
            setColor(this.a.f43189g);
            setStrokeWidth(this.a.f43188f);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* loaded from: classes12.dex */
    public class b extends Paint {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ProgressCircle a;

        public b(ProgressCircle progressCircle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {progressCircle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = progressCircle;
            setColor(this.a.f43190h);
            setStrokeWidth(this.a.f43188f);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* loaded from: classes12.dex */
    public class c extends Paint {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ProgressCircle a;

        public c(ProgressCircle progressCircle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {progressCircle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = progressCircle;
            setColor(this.a.f43190h);
            setStrokeWidth(this.a.f43188f);
            setStyle(Paint.Style.FILL);
        }
    }

    /* loaded from: classes12.dex */
    public class d extends Paint {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ProgressCircle a;

        public d(ProgressCircle progressCircle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {progressCircle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = progressCircle;
            setColor(this.a.f43190h);
            setStrokeWidth(this.a.f43188f);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* loaded from: classes12.dex */
    public class e extends Paint {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ProgressCircle a;

        public e(ProgressCircle progressCircle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {progressCircle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = progressCircle;
            setColor(this.a.f43191i);
            setStrokeWidth(this.a.f43188f);
            setStyle(Paint.Style.STROKE);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-975182130, "Lcom/baidu/tieba/frs/accelerator/view/ProgressCircle;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-975182130, "Lcom/baidu/tieba/frs/accelerator/view/ProgressCircle;");
                return;
            }
        }
        TAG = ProgressCircle.class.getSimpleName();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressCircle(Context context, AttributeSet attributeSet) {
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

    public final void e(Canvas canvas, float f2, float f3, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, Float.valueOf(f2), Float.valueOf(f3), paint}) == null) {
            float f4 = f3 * 360.0f;
            canvas.drawArc(this.n, (f2 * 360.0f) - 90.0f, f4, false, paint);
            if (this.f43187e) {
                return;
            }
            h(canvas, this.s);
            g(canvas, f4, this.s);
        }
    }

    public final void f(Canvas canvas, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, paint) == null) {
            e(canvas, 0.0f, 1.0f, paint);
        }
    }

    public void g(Canvas canvas, float f2, Paint paint) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, Float.valueOf(f2), paint}) == null) {
            float f3 = (this.l / 2) - this.f43188f;
            double radians = Math.toRadians(f2) + 3.141592653589793d;
            canvas.drawCircle((i2 / 2) - (((float) Math.sin(radians)) * f3), (this.m / 2) + (((float) Math.cos(radians)) * f3), this.f43188f / 2, paint);
        }
    }

    public void h(Canvas canvas, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, canvas, paint) == null) {
            int i2 = this.f43188f;
            canvas.drawCircle(this.l / 2, i2, i2 / 2, paint);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.onDraw(canvas);
            long currentTimeMillis = System.currentTimeMillis();
            f(canvas, this.o);
            if (this.f43187e) {
                long j2 = currentTimeMillis - this.u;
                if (j2 > this.f43192j) {
                    this.u = currentTimeMillis;
                    j2 = 0;
                }
                e(canvas, ((float) j2) / this.f43192j, this.k, this.r);
                invalidate();
                return;
            }
            e(canvas, 0.0f, this.t, this.q);
            e(canvas, 0.0f, this.t, this.p);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.l = i2;
            this.m = i3;
            int i6 = this.f43188f;
            this.n = new RectF(i6, i6, this.l - i6, this.m - i6);
        }
    }

    public void setIndeterminate(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || this.f43187e == z) {
            return;
        }
        this.f43187e = z;
        invalidate();
    }

    public void setProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            this.t = f2;
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressCircle(Context context, AttributeSet attributeSet, int i2) {
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
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, j1.ProgressCircle, 0, 0);
        try {
            this.f43187e = obtainStyledAttributes.getBoolean(j1.ProgressCircle_indeterminate, false);
            this.f43188f = obtainStyledAttributes.getDimensionPixelSize(j1.ProgressCircle_progressStrokeWidth, 5);
            this.f43189g = obtainStyledAttributes.getColor(j1.ProgressCircle_progressBackgroundColor, 0);
            this.f43190h = obtainStyledAttributes.getColor(j1.ProgressCircle_progressAccentColor, -1);
            this.f43191i = obtainStyledAttributes.getColor(j1.ProgressCircle_indeterminateProgressAccentColor, -1);
            this.f43192j = obtainStyledAttributes.getInteger(j1.ProgressCircle_indeterminatePeriod, 2000);
            this.k = obtainStyledAttributes.getFloat(j1.ProgressCircle_indeterminateArcSize, 0.2f);
            obtainStyledAttributes.recycle();
            this.o = new a(this);
            this.p = new b(this);
            this.s = new c(this);
            d dVar = new d(this);
            this.q = dVar;
            dVar.setMaskFilter(new BlurMaskFilter(20.0f, BlurMaskFilter.Blur.NORMAL));
            this.r = new e(this);
            setProgress(0.5f);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
