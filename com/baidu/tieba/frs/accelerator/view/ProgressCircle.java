package com.baidu.tieba.frs.accelerator.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lf7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ProgressCircle extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public float g;
    public int h;
    public int i;
    public RectF j;
    public Paint k;
    public Paint l;
    public Paint m;
    public Paint n;
    public Paint o;
    public float p;
    public long q;

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = progressCircle;
            setColor(this.a.c);
            setStrokeWidth(this.a.b);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = progressCircle;
            setColor(this.a.d);
            setStrokeWidth(this.a.b);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = progressCircle;
            setColor(this.a.d);
            setStrokeWidth(this.a.b);
            setStyle(Paint.Style.FILL);
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = progressCircle;
            setColor(this.a.d);
            setStrokeWidth(this.a.b);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = progressCircle;
            setColor(this.a.e);
            setStrokeWidth(this.a.b);
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
            }
        }
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
    public ProgressCircle(Context context, AttributeSet attributeSet, int i) {
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
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, lf7.ProgressCircle, 0, 0);
        try {
            this.a = obtainStyledAttributes.getBoolean(0, false);
            this.b = obtainStyledAttributes.getDimensionPixelSize(6, 5);
            this.c = obtainStyledAttributes.getColor(5, 0);
            this.d = obtainStyledAttributes.getColor(4, -1);
            this.e = obtainStyledAttributes.getColor(3, -1);
            this.f = obtainStyledAttributes.getInteger(2, 2000);
            this.g = obtainStyledAttributes.getFloat(1, 0.2f);
            obtainStyledAttributes.recycle();
            this.k = new a(this);
            this.l = new b(this);
            this.o = new c(this);
            d dVar = new d(this);
            this.m = dVar;
            dVar.setMaskFilter(new BlurMaskFilter(20.0f, BlurMaskFilter.Blur.NORMAL));
            this.n = new e(this);
            setProgress(0.5f);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setIndeterminate(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && this.a != z) {
            this.a = z;
            invalidate();
        }
    }

    public void setProgress(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            this.p = f;
            invalidate();
        }
    }

    public final void e(Canvas canvas, float f, float f2, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, Float.valueOf(f), Float.valueOf(f2), paint}) == null) {
            float f3 = f2 * 360.0f;
            canvas.drawArc(this.j, (f * 360.0f) - 90.0f, f3, false, paint);
            if (!this.a) {
                h(canvas, this.o);
                g(canvas, f3, this.o);
            }
        }
    }

    public final void f(Canvas canvas, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, paint) == null) {
            e(canvas, 0.0f, 1.0f, paint);
        }
    }

    public void h(Canvas canvas, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, canvas, paint) == null) {
            int i = this.b;
            canvas.drawCircle(this.h / 2, i, i / 2, paint);
        }
    }

    public void g(Canvas canvas, float f, Paint paint) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, Float.valueOf(f), paint}) == null) {
            float f2 = (this.h / 2) - this.b;
            double radians = Math.toRadians(f) + 3.141592653589793d;
            canvas.drawCircle((i / 2) - (((float) Math.sin(radians)) * f2), (this.i / 2) + (((float) Math.cos(radians)) * f2), this.b / 2, paint);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.onDraw(canvas);
            long currentTimeMillis = System.currentTimeMillis();
            f(canvas, this.k);
            if (this.a) {
                long j = currentTimeMillis - this.q;
                if (j > this.f) {
                    this.q = currentTimeMillis;
                    j = 0;
                }
                e(canvas, ((float) j) / this.f, this.g, this.n);
                invalidate();
                return;
            }
            e(canvas, 0.0f, this.p, this.m);
            e(canvas, 0.0f, this.p, this.l);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.h = i;
            this.i = i2;
            int i5 = this.b;
            this.j = new RectF(i5, i5, this.h - i5, this.i - i5);
        }
    }
}
