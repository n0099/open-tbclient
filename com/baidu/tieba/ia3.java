package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.Log;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.RoundedDrawable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ia3 extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RectF a;
    public final RectF b;
    public final RectF c;
    public final BitmapShader d;
    public final Paint e;
    public final int f;
    public final int g;
    public final RectF h;
    public final Paint i;
    public final Matrix j;
    public float k;
    public int l;
    public int m;
    public ImageView.ScaleType n;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-725048719, "Lcom/baidu/tieba/ia3$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-725048719, "Lcom/baidu/tieba/ia3$a;");
                    return;
                }
            }
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public ia3(Bitmap bitmap, float f, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new RectF();
        this.b = new RectF();
        this.c = new RectF();
        this.h = new RectF();
        this.j = new Matrix();
        this.n = ImageView.ScaleType.FIT_XY;
        this.l = i;
        this.m = i2;
        this.f = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.g = height;
        this.c.set(0.0f, 0.0f, this.f, height);
        this.k = f;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.d = bitmapShader;
        bitmapShader.setLocalMatrix(this.j);
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setShader(this.d);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setAntiAlias(true);
        this.i.setColor(this.m);
        this.i.setStrokeWidth(i);
    }

    public static Bitmap a(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, drawable)) == null) {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return createBitmap;
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    @SuppressLint({"SwanDebugLog"})
    public static Drawable b(Drawable drawable, ImageView.ScaleType scaleType, float f, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{drawable, scaleType, Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (drawable != null) {
                if (drawable instanceof TransitionDrawable) {
                    TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
                    int numberOfLayers = transitionDrawable.getNumberOfLayers();
                    Drawable[] drawableArr = new Drawable[numberOfLayers];
                    for (int i3 = 0; i3 < numberOfLayers; i3++) {
                        Drawable drawable2 = transitionDrawable.getDrawable(i3);
                        if (drawable2 instanceof ColorDrawable) {
                            drawableArr[i3] = drawable2;
                        } else if (drawable2 instanceof ia3) {
                            drawableArr[i3] = drawable2;
                        } else {
                            drawableArr[i3] = new ia3(a(drawable2), f, i, i2);
                            if (scaleType != null) {
                                ((ia3) drawableArr[i3]).h(scaleType);
                            }
                        }
                    }
                    return new TransitionDrawable(drawableArr);
                }
                Bitmap a2 = a(drawable);
                if (a2 != null) {
                    ia3 ia3Var = new ia3(a2, f, i, i2);
                    if (scaleType != null) {
                        ia3Var.h(scaleType);
                    }
                    return ia3Var;
                }
                Log.w(RoundedDrawable.TAG, "Failed to create bitmap from drawable!");
            }
            return drawable;
        }
        return (Drawable) invokeCommon.objValue;
    }

    public ImageView.ScaleType c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.n;
        }
        return (ImageView.ScaleType) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.m = i;
            this.i.setColor(i);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.l = i;
            this.i.setStrokeWidth(i);
        }
    }

    public void f(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            this.k = f;
        }
    }

    public void h(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, scaleType) == null) {
            if (scaleType == null) {
                scaleType = ImageView.ScaleType.FIT_XY;
            }
            if (this.n != scaleType) {
                this.n = scaleType;
                g();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rect) == null) {
            super.onBoundsChange(rect);
            this.a.set(rect);
            g();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.e.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, colorFilter) == null) {
            this.e.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (this.l > 0) {
                RectF rectF = this.h;
                float f = this.k;
                canvas.drawRoundRect(rectF, f, f, this.i);
                canvas.drawRoundRect(this.b, Math.max(this.k - this.l, 0.0f), Math.max(this.k - this.l, 0.0f), this.e);
                return;
            }
            RectF rectF2 = this.b;
            float f2 = this.k;
            canvas.drawRoundRect(rectF2, f2, f2, this.e);
        }
    }

    public final void g() {
        float width;
        float height;
        float min;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.h.set(this.a);
            RectF rectF = this.b;
            int i = this.l;
            rectF.set(i + 0, i + 0, this.h.width() - this.l, this.h.height() - this.l);
            switch (a.a[this.n.ordinal()]) {
                case 1:
                    this.h.set(this.a);
                    RectF rectF2 = this.b;
                    int i2 = this.l;
                    rectF2.set(i2 + 0, i2 + 0, this.h.width() - this.l, this.h.height() - this.l);
                    this.j.set(null);
                    this.j.setTranslate((int) (((this.b.width() - this.f) * 0.5f) + 0.5f), (int) (((this.b.height() - this.g) * 0.5f) + 0.5f));
                    break;
                case 2:
                    this.h.set(this.a);
                    RectF rectF3 = this.b;
                    int i3 = this.l;
                    rectF3.set(i3 + 0, i3 + 0, this.h.width() - this.l, this.h.height() - this.l);
                    this.j.set(null);
                    float f = 0.0f;
                    if (this.f * this.b.height() > this.b.width() * this.g) {
                        width = this.b.height() / this.g;
                        f = (this.b.width() - (this.f * width)) * 0.5f;
                        height = 0.0f;
                    } else {
                        width = this.b.width() / this.f;
                        height = (this.b.height() - (this.g * width)) * 0.5f;
                    }
                    this.j.setScale(width, width);
                    Matrix matrix = this.j;
                    int i4 = this.l;
                    matrix.postTranslate(((int) (f + 0.5f)) + i4, ((int) (height + 0.5f)) + i4);
                    break;
                case 3:
                    this.j.set(null);
                    if (this.f <= this.a.width() && this.g <= this.a.height()) {
                        min = 1.0f;
                    } else {
                        min = Math.min(this.a.width() / this.f, this.a.height() / this.g);
                    }
                    this.j.setScale(min, min);
                    this.j.postTranslate((int) (((this.a.width() - (this.f * min)) * 0.5f) + 0.5f), (int) (((this.a.height() - (this.g * min)) * 0.5f) + 0.5f));
                    this.h.set(this.c);
                    this.j.mapRect(this.h);
                    RectF rectF4 = this.b;
                    RectF rectF5 = this.h;
                    float f2 = rectF5.left;
                    int i5 = this.l;
                    rectF4.set(f2 + i5, rectF5.top + i5, rectF5.right - i5, rectF5.bottom - i5);
                    this.j.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
                    break;
                case 4:
                    this.h.set(this.c);
                    this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.CENTER);
                    this.j.mapRect(this.h);
                    RectF rectF6 = this.b;
                    RectF rectF7 = this.h;
                    float f3 = rectF7.left;
                    int i6 = this.l;
                    rectF6.set(f3 + i6, rectF7.top + i6, rectF7.right - i6, rectF7.bottom - i6);
                    this.j.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
                    break;
                case 5:
                    this.h.set(this.c);
                    this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.END);
                    this.j.mapRect(this.h);
                    RectF rectF8 = this.b;
                    RectF rectF9 = this.h;
                    float f4 = rectF9.left;
                    int i7 = this.l;
                    rectF8.set(f4 + i7, rectF9.top + i7, rectF9.right - i7, rectF9.bottom - i7);
                    this.j.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
                    break;
                case 6:
                    this.h.set(this.c);
                    this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.START);
                    this.j.mapRect(this.h);
                    RectF rectF10 = this.b;
                    RectF rectF11 = this.h;
                    float f5 = rectF11.left;
                    int i8 = this.l;
                    rectF10.set(f5 + i8, rectF11.top + i8, rectF11.right - i8, rectF11.bottom - i8);
                    this.j.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
                    break;
                default:
                    this.h.set(this.a);
                    RectF rectF12 = this.b;
                    int i9 = this.l;
                    rectF12.set(i9 + 0, i9 + 0, this.h.width() - this.l, this.h.height() - this.l);
                    this.j.set(null);
                    this.j.setRectToRect(this.c, this.b, Matrix.ScaleToFit.FILL);
                    break;
            }
            this.d.setLocalMatrix(this.j);
        }
    }
}
