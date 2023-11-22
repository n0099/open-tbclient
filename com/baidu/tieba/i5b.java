package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.view.bubbleView.ArrowDirection;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i5b extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RectF a;
    public Path b;
    public Paint c;
    public Path d;
    public Paint e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-764283466, "Lcom/baidu/tieba/i5b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-764283466, "Lcom/baidu/tieba/i5b$a;");
                    return;
                }
            }
            int[] iArr = new int[ArrowDirection.values().length];
            a = iArr;
            try {
                iArr[ArrowDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ArrowDirection.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ArrowDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ArrowDirection.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public i5b(RectF rectF, float f, float f2, float f3, float f4, float f5, int i, int i2, ArrowDirection arrowDirection) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rectF, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Integer.valueOf(i), Integer.valueOf(i2), arrowDirection};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new Path();
        Paint paint = new Paint(1);
        this.c = paint;
        this.a = rectF;
        this.f = f;
        this.g = f2;
        this.h = f3;
        this.i = f4;
        this.j = f5;
        paint.setColor(i2);
        if (f5 > 0.0f) {
            Paint paint2 = new Paint(1);
            this.e = paint2;
            paint2.setColor(i);
            this.d = new Path();
            e(arrowDirection, this.b, f5);
            e(arrowDirection, this.d, 0.0f);
            return;
        }
        e(arrowDirection, this.b, 0.0f);
    }

    public final void a(RectF rectF, Path path, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{rectF, path, Float.valueOf(f)}) == null) {
            path.moveTo(rectF.left + this.g + f, rectF.top + f);
            path.lineTo((rectF.width() - this.g) - f, rectF.top + f);
            float f2 = rectF.right;
            float f3 = this.g;
            float f4 = rectF.top;
            path.arcTo(new RectF(f2 - f3, f4 + f, f2 - f, f3 + f4), 270.0f, 90.0f);
            path.lineTo(rectF.right - f, ((rectF.bottom - this.h) - this.g) - f);
            float f5 = rectF.right;
            float f6 = this.g;
            float f7 = rectF.bottom;
            float f8 = this.h;
            path.arcTo(new RectF(f5 - f6, (f7 - f6) - f8, f5 - f, (f7 - f8) - f), 0.0f, 90.0f);
            float f9 = f / 2.0f;
            path.lineTo(((rectF.left + this.f) + this.i) - f9, (rectF.bottom - this.h) - f);
            path.lineTo(rectF.left + this.i + (this.f / 2.0f), (rectF.bottom - f) - f);
            path.lineTo(rectF.left + this.i + f9, (rectF.bottom - this.h) - f);
            path.lineTo(rectF.left + Math.min(this.g, this.i) + f, (rectF.bottom - this.h) - f);
            float f10 = rectF.left;
            float f11 = rectF.bottom;
            float f12 = this.g;
            float f13 = this.h;
            path.arcTo(new RectF(f10 + f, (f11 - f12) - f13, f12 + f10, (f11 - f13) - f), 90.0f, 90.0f);
            path.lineTo(rectF.left + f, rectF.top + this.g + f);
            float f14 = rectF.left;
            float f15 = rectF.top;
            float f16 = this.g;
            path.arcTo(new RectF(f14 + f, f + f15, f14 + f16, f16 + f15), 180.0f, 90.0f);
            path.close();
        }
    }

    public final void c(RectF rectF, Path path, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{rectF, path, Float.valueOf(f)}) == null) {
            path.moveTo(this.f + rectF.left + this.g + f, rectF.top + f);
            path.lineTo((rectF.width() - this.g) - f, rectF.top + f);
            float f2 = rectF.right;
            float f3 = this.g;
            float f4 = rectF.top;
            path.arcTo(new RectF(f2 - f3, f4 + f, f2 - f, f3 + f4), 270.0f, 90.0f);
            path.lineTo(rectF.right - f, (rectF.bottom - this.g) - f);
            float f5 = rectF.right;
            float f6 = this.g;
            float f7 = rectF.bottom;
            path.arcTo(new RectF(f5 - f6, f7 - f6, f5 - f, f7 - f), 0.0f, 90.0f);
            path.lineTo(rectF.left + this.f + this.g + f, rectF.bottom - f);
            float f8 = rectF.left;
            float f9 = this.f;
            float f10 = rectF.bottom;
            float f11 = this.g;
            path.arcTo(new RectF(f8 + f9 + f, f10 - f11, f11 + f8 + f9, f10 - f), 90.0f, 90.0f);
            float f12 = f / 2.0f;
            path.lineTo(rectF.left + this.f + f, (this.h + this.i) - f12);
            path.lineTo(rectF.left + f + f, this.i + (this.h / 2.0f));
            path.lineTo(rectF.left + this.f + f, this.i + f12);
            path.lineTo(rectF.left + this.f + f, rectF.top + this.g + f);
            float f13 = rectF.left;
            float f14 = this.f;
            float f15 = rectF.top;
            float f16 = this.g;
            path.arcTo(new RectF(f13 + f14 + f, f + f15, f13 + f16 + f14, f16 + f15), 180.0f, 90.0f);
            path.close();
        }
    }

    public final void f(RectF rectF, Path path, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{rectF, path, Float.valueOf(f)}) == null) {
            path.moveTo(rectF.left + this.g + f, rectF.top + f);
            path.lineTo(((rectF.width() - this.g) - this.f) - f, rectF.top + f);
            float f2 = rectF.right;
            float f3 = this.g;
            float f4 = this.f;
            float f5 = rectF.top;
            path.arcTo(new RectF((f2 - f3) - f4, f5 + f, (f2 - f4) - f, f3 + f5), 270.0f, 90.0f);
            float f6 = f / 2.0f;
            path.lineTo((rectF.right - this.f) - f, this.i + f6);
            path.lineTo((rectF.right - f) - f, this.i + (this.h / 2.0f));
            path.lineTo((rectF.right - this.f) - f, (this.i + this.h) - f6);
            path.lineTo((rectF.right - this.f) - f, (rectF.bottom - this.g) - f);
            float f7 = rectF.right;
            float f8 = this.g;
            float f9 = this.f;
            float f10 = rectF.bottom;
            path.arcTo(new RectF((f7 - f8) - f9, f10 - f8, (f7 - f9) - f, f10 - f), 0.0f, 90.0f);
            path.lineTo(rectF.left + this.f + f, rectF.bottom - f);
            float f11 = rectF.left;
            float f12 = rectF.bottom;
            float f13 = this.g;
            path.arcTo(new RectF(f11 + f, f12 - f13, f13 + f11, f12 - f), 90.0f, 90.0f);
            float f14 = rectF.left;
            float f15 = rectF.top;
            float f16 = this.g;
            path.arcTo(new RectF(f14 + f, f + f15, f14 + f16, f16 + f15), 180.0f, 90.0f);
            path.close();
        }
    }

    public final void h(RectF rectF, Path path, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{rectF, path, Float.valueOf(f)}) == null) {
            path.moveTo(rectF.left + Math.min(this.i, this.g) + f, rectF.top + this.h + f);
            float f2 = f / 2.0f;
            path.lineTo(rectF.left + this.i + f2, rectF.top + this.h + f);
            path.lineTo(rectF.left + (this.f / 2.0f) + this.i, rectF.top + f + f);
            path.lineTo(((rectF.left + this.f) + this.i) - f2, rectF.top + this.h + f);
            path.lineTo((rectF.right - this.g) - f, rectF.top + this.h + f);
            float f3 = rectF.right;
            float f4 = this.g;
            float f5 = rectF.top;
            float f6 = this.h;
            path.arcTo(new RectF(f3 - f4, f5 + f6 + f, f3 - f, f4 + f5 + f6), 270.0f, 90.0f);
            path.lineTo(rectF.right - f, (rectF.bottom - this.g) - f);
            float f7 = rectF.right;
            float f8 = this.g;
            float f9 = rectF.bottom;
            path.arcTo(new RectF(f7 - f8, f9 - f8, f7 - f, f9 - f), 0.0f, 90.0f);
            path.lineTo(rectF.left + this.g + f, rectF.bottom - f);
            float f10 = rectF.left;
            float f11 = rectF.bottom;
            float f12 = this.g;
            path.arcTo(new RectF(f10 + f, f11 - f12, f12 + f10, f11 - f), 90.0f, 90.0f);
            path.lineTo(rectF.left + f, rectF.top + this.h + this.g + f);
            float f13 = rectF.left;
            float f14 = f13 + f;
            float f15 = rectF.top;
            float f16 = this.h;
            float f17 = f15 + f16 + f;
            float f18 = this.g;
            path.arcTo(new RectF(f14, f17, f13 + f18, f18 + f15 + f16), 180.0f, 90.0f);
            path.close();
        }
    }

    public final void b(RectF rectF, Path path, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{rectF, path, Float.valueOf(f)}) == null) {
            path.moveTo(rectF.left + f, rectF.top + f);
            path.lineTo(rectF.right - f, rectF.top + f);
            path.lineTo(rectF.right - f, (rectF.bottom - this.h) - f);
            float f2 = f / 2.0f;
            path.lineTo(((rectF.left + this.f) + this.i) - f2, (rectF.bottom - this.h) - f);
            path.lineTo(rectF.left + this.i + (this.f / 2.0f), (rectF.bottom - f) - f);
            path.lineTo(rectF.left + this.i + f2, (rectF.bottom - this.h) - f);
            path.lineTo(rectF.left + this.i + f, (rectF.bottom - this.h) - f);
            path.lineTo(rectF.left + f, (rectF.bottom - this.h) - f);
            path.lineTo(rectF.left + f, rectF.top + f);
            path.close();
        }
    }

    public final void e(ArrowDirection arrowDirection, Path path, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{arrowDirection, path, Float.valueOf(f)}) == null) {
            int i = a.a[arrowDirection.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            float f2 = this.g;
                            if (f2 <= 0.0f) {
                                b(this.a, path, f);
                                return;
                            } else if (f > 0.0f && f > f2) {
                                b(this.a, path, f);
                                return;
                            } else {
                                a(this.a, path, f);
                                return;
                            }
                        }
                        return;
                    }
                    float f3 = this.g;
                    if (f3 <= 0.0f) {
                        g(this.a, path, f);
                        return;
                    } else if (f > 0.0f && f > f3) {
                        g(this.a, path, f);
                        return;
                    } else {
                        f(this.a, path, f);
                        return;
                    }
                }
                float f4 = this.g;
                if (f4 <= 0.0f) {
                    i(this.a, path, f);
                    return;
                } else if (f > 0.0f && f > f4) {
                    i(this.a, path, f);
                    return;
                } else {
                    h(this.a, path, f);
                    return;
                }
            }
            float f5 = this.g;
            if (f5 <= 0.0f) {
                d(this.a, path, f);
            } else if (f > 0.0f && f > f5) {
                d(this.a, path, f);
            } else {
                c(this.a, path, f);
            }
        }
    }

    public final void i(RectF rectF, Path path, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{rectF, path, Float.valueOf(f)}) == null) {
            path.moveTo(rectF.left + this.i + f, rectF.top + this.h + f);
            float f2 = f / 2.0f;
            path.lineTo(rectF.left + this.i + f2, rectF.top + this.h + f);
            path.lineTo(rectF.left + (this.f / 2.0f) + this.i, rectF.top + f + f);
            path.lineTo(((rectF.left + this.f) + this.i) - f2, rectF.top + this.h + f);
            path.lineTo(rectF.right - f, rectF.top + this.h + f);
            path.lineTo(rectF.right - f, rectF.bottom - f);
            path.lineTo(rectF.left + f, rectF.bottom - f);
            path.lineTo(rectF.left + f, rectF.top + this.h + f);
            path.lineTo(rectF.left + this.i + f, rectF.top + this.h + f);
            path.close();
        }
    }

    public final void d(RectF rectF, Path path, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{rectF, path, Float.valueOf(f)}) == null) {
            path.moveTo(this.f + rectF.left + f, rectF.top + f);
            path.lineTo(rectF.width() - f, rectF.top + f);
            path.lineTo(rectF.right - f, rectF.bottom - f);
            path.lineTo(rectF.left + this.f + f, rectF.bottom - f);
            float f2 = f / 2.0f;
            path.lineTo(rectF.left + this.f + f, (this.h + this.i) - f2);
            path.lineTo(rectF.left + f + f, this.i + (this.h / 2.0f));
            path.lineTo(rectF.left + this.f + f, this.i + f2);
            path.lineTo(rectF.left + this.f + f, rectF.top + f);
            path.close();
        }
    }

    public final void g(RectF rectF, Path path, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{rectF, path, Float.valueOf(f)}) == null) {
            path.moveTo(rectF.left + f, rectF.top + f);
            path.lineTo((rectF.width() - this.f) - f, rectF.top + f);
            float f2 = f / 2.0f;
            path.lineTo((rectF.right - this.f) - f, this.i + f2);
            path.lineTo((rectF.right - f) - f, this.i + (this.h / 2.0f));
            path.lineTo((rectF.right - this.f) - f, (this.i + this.h) - f2);
            path.lineTo((rectF.right - this.f) - f, rectF.bottom - f);
            path.lineTo(rectF.left + f, rectF.bottom - f);
            path.lineTo(rectF.left + f, rectF.top + f);
            path.close();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            if (this.j > 0.0f) {
                canvas.drawPath(this.d, this.e);
            }
            canvas.drawPath(this.b, this.c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, rect) == null) {
            super.onBoundsChange(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.c.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, colorFilter) == null) {
            this.c.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return (int) this.a.height();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (int) this.a.width();
        }
        return invokeV.intValue;
    }
}
