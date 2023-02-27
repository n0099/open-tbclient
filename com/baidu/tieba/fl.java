package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.baidu.adp.newwidget.ImageView.DrawerArgs;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.widget.BdThumbSeekBarView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class fl {
    public static /* synthetic */ Interceptable $ic;
    public static final Matrix.ScaleToFit[] q;
    public static final PorterDuffColorFilter r;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public ColorFilter b;
    public Paint c;
    public Paint d;
    public Paint e;
    public Matrix f;
    public RectF g;
    public RectF h;
    public RectF i;
    public RectF j;
    public RectF k;
    public DrawerArgs l;
    public float[] m;
    public PointF n;
    public RectF o;
    public boolean p;

    /* loaded from: classes4.dex */
    public interface b {
        boolean a(Canvas canvas, Drawable drawable);
    }

    public abstract void a(il ilVar, ImageView imageView);

    public abstract void f(Canvas canvas, ImageView imageView);

    public abstract void h(Canvas canvas, il ilVar, ImageView imageView);

    public abstract void i(Canvas canvas, ImageView imageView);

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(251250570, "Lcom/baidu/tieba/fl$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(251250570, "Lcom/baidu/tieba/fl$a;");
                    return;
                }
            }
            int[] iArr = new int[DrawerArgs.SkinType.values().length];
            a = iArr;
            try {
                iArr[DrawerArgs.SkinType.NIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DrawerArgs.SkinType.DAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DrawerArgs.SkinType.DARK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448304551, "Lcom/baidu/tieba/fl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448304551, "Lcom/baidu/tieba/fl;");
                return;
            }
        }
        q = new Matrix.ScaleToFit[]{Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
        r = new PorterDuffColorFilter(BdThumbSeekBarView.UI_TRACE_COLOR, PorterDuff.Mode.SRC_ATOP);
    }

    public fl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new Paint(6);
        this.d = new Paint();
        this.e = new Paint();
        this.f = new Matrix();
        this.g = new RectF();
        this.h = new RectF();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new RectF();
        this.l = new DrawerArgs();
        this.m = new float[9];
        this.n = new PointF();
        this.o = new RectF();
        this.p = true;
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setAntiAlias(true);
        this.c.setAntiAlias(true);
        this.e.setAntiAlias(true);
        this.e.setStyle(Paint.Style.FILL);
    }

    public static Matrix.ScaleToFit m(ImageView.ScaleType scaleType) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, scaleType)) == null) {
            if (scaleType != ImageView.ScaleType.FIT_XY) {
                if (scaleType == ImageView.ScaleType.FIT_START) {
                    i = 2;
                } else if (scaleType == ImageView.ScaleType.FIT_CENTER) {
                    i = 3;
                } else if (scaleType == ImageView.ScaleType.FIT_END) {
                    i = 4;
                }
                return q[i - 1];
            }
            i = 1;
            return q[i - 1];
        }
        return (Matrix.ScaleToFit) invokeL.objValue;
    }

    public PointF b(float f, float f2, Matrix matrix) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), matrix})) == null) {
            matrix.getValues(this.m);
            float[] fArr = this.m;
            this.n.set((int) ((fArr[0] * f) + (fArr[1] * f2) + fArr[2]), (int) ((f * fArr[3]) + (f2 * fArr[4]) + fArr[5]));
            return this.n;
        }
        return (PointF) invokeCommon.objValue;
    }

    public void c(il ilVar, ImageView imageView, ImageView.ScaleType scaleType) {
        boolean z;
        float min;
        float f;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, ilVar, imageView, scaleType) == null) && imageView.getWidth() != 0 && imageView.getHeight() != 0) {
            int b2 = ilVar.b();
            int a2 = ilVar.a();
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            if (scaleType == ImageView.ScaleType.MATRIX) {
                this.g.set(0.0f, 0.0f, b2, a2);
                a(ilVar, imageView);
                return;
            }
            if ((b2 > 0 && width != b2) || (a2 > 0 && height != a2)) {
                z = false;
            } else {
                z = true;
            }
            this.f.reset();
            if (ImageView.ScaleType.FIT_XY != scaleType && !z) {
                float f4 = b2;
                float f5 = a2;
                this.g.set(0.0f, 0.0f, f4, f5);
                if (ImageView.ScaleType.CENTER == scaleType) {
                    this.f.setTranslate((width - b2) * 0.5f, (height - a2) * 0.5f);
                } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                    if (b2 * height > a2 * width) {
                        f = height / f5;
                        f3 = (width - (f4 * f)) * 0.5f;
                        f2 = 0.0f;
                    } else {
                        f = width / f4;
                        f2 = (height - (f5 * f)) * 0.5f;
                        f3 = 0.0f;
                    }
                    this.f.setScale(f, f);
                    this.f.postTranslate(f3, f2);
                } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                    if (b2 <= width && a2 <= height) {
                        min = 1.0f;
                    } else {
                        min = Math.min(width / f4, height / f5);
                    }
                    this.f.setScale(min, min);
                    this.f.postTranslate((width - (f4 * min)) * 0.5f, (height - (f5 * min)) * 0.5f);
                } else {
                    this.i.set(0.0f, 0.0f, f4, f5);
                    this.j.set(0.0f, 0.0f, width, height);
                    this.f.setRectToRect(this.i, this.j, m(scaleType));
                }
            } else {
                this.g.set(0.0f, 0.0f, width, height);
            }
            int length = this.l.a.length;
            for (int i = 0; i < length; i++) {
                float[] fArr = this.l.a;
                if (fArr[i] > 0.0f && fArr[i] < 1.0f) {
                    fArr[i] = fArr[i] * this.g.height();
                }
            }
            a(ilVar, imageView);
        }
    }

    public void g(Canvas canvas, il ilVar, ImageView imageView) {
        Matrix matrix;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, canvas, ilVar, imageView) == null) {
            s();
            int save = canvas.save();
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            int paddingLeft = imageView.getPaddingLeft();
            int paddingRight = imageView.getPaddingRight();
            int paddingTop = imageView.getPaddingTop();
            int paddingBottom = imageView.getPaddingBottom();
            canvas.clipRect(scrollX + paddingLeft, scrollY + paddingTop, ((scrollX + imageView.getRight()) - imageView.getLeft()) - paddingRight, ((scrollY + imageView.getBottom()) - imageView.getTop()) - paddingBottom);
            canvas.translate(paddingLeft, paddingTop);
            int save2 = canvas.save();
            Matrix matrix2 = this.l.l;
            if (matrix2 != null) {
                canvas.concat(matrix2);
            }
            on onVar = ilVar.b;
            if (onVar != null && onVar.v()) {
                if ((ilVar.b.p().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || ilVar.b.p().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && (matrix = this.f) != null) {
                    canvas.concat(matrix);
                }
                this.k.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                ilVar.b.i(canvas, this.k);
            } else {
                h(canvas, ilVar, imageView);
            }
            if (save2 >= 1 && save2 <= canvas.getSaveCount()) {
                canvas.restoreToCount(save2);
            }
            f(canvas, imageView);
            if (save >= 1 && save <= canvas.getSaveCount()) {
                canvas.restoreToCount(save);
            }
        }
    }

    public void d(Canvas canvas, ImageView imageView, Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048579, this, canvas, imageView, drawable) == null) && drawable != null) {
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            drawable.setBounds(0, 0, imageView.getWidth(), imageView.getHeight());
            if ((scrollX | scrollY) == 0) {
                e(canvas, drawable);
                return;
            }
            canvas.translate(scrollX, scrollY);
            e(canvas, drawable);
            canvas.translate(-scrollX, -scrollY);
        }
    }

    public void e(Canvas canvas, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, canvas, drawable) == null) {
            b bVar = this.a;
            if (bVar != null && bVar.a(canvas, drawable)) {
                return;
            }
            drawable.draw(canvas);
        }
    }

    public Path l(RectF rectF, float[] fArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, rectF, fArr)) == null) {
            Path path = new Path();
            path.addRoundRect(rectF, fArr, Path.Direction.CCW);
            return path;
        }
        return (Path) invokeLL.objValue;
    }

    public RectF j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.g;
        }
        return (RectF) invokeV.objValue;
    }

    public Matrix k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f;
        }
        return (Matrix) invokeV.objValue;
    }

    public void n(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, colorFilter) == null) {
            this.b = colorFilter;
        }
    }

    public void o(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, matrix) == null) {
            this.f = matrix;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.p = z;
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.a = bVar;
        }
    }

    public void r(DrawerArgs drawerArgs) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, drawerArgs) == null) {
            this.l = drawerArgs;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.c.setAlpha((int) (this.l.k * 255.0f));
            ColorFilter colorFilter = this.b;
            if (colorFilter != null) {
                this.c.setColorFilter(colorFilter);
            } else if (a.a[this.l.f.ordinal()] != 1) {
                this.c.setColorFilter(null);
            } else if (this.p) {
                this.c.setColorFilter(r);
            }
            this.d.setColor(this.l.e);
            this.d.setStrokeWidth(this.l.d);
        }
    }
}
