package com.baidu.tbadk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.au9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TbCornersImageView extends AppCompatImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public float o;
    public float[] p;
    public float[] q;
    public RectF r;
    public RectF s;
    public Paint t;
    public Path u;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbCornersImageView(Context context) {
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

    public final void q(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            if (this.a) {
                int i = this.c;
                if (i > 0) {
                    r(canvas, i, this.d, this.o - (i / 2.0f));
                }
                int i2 = this.e;
                if (i2 > 0) {
                    r(canvas, i2, this.f, (this.o - this.c) - (i2 / 2.0f));
                    return;
                }
                return;
            }
            int i3 = this.c;
            if (i3 > 0) {
                s(canvas, i3, this.d, this.s, this.p);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbCornersImageView(Context context, @Nullable AttributeSet attributeSet) {
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
    public TbCornersImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.d = -1;
        this.f = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, au9.CornersImageView, 0, 0);
        for (int i4 = 0; i4 < obtainStyledAttributes.getIndexCount(); i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            if (index == 10) {
                this.b = obtainStyledAttributes.getBoolean(index, this.b);
            } else if (index == 9) {
                this.a = obtainStyledAttributes.getBoolean(index, this.a);
            } else if (index == 1) {
                this.c = obtainStyledAttributes.getDimensionPixelSize(index, this.c);
            } else if (index == 0) {
                this.d = obtainStyledAttributes.getColor(index, this.d);
            } else if (index == 8) {
                this.e = obtainStyledAttributes.getDimensionPixelSize(index, this.e);
            } else if (index == 7) {
                this.f = obtainStyledAttributes.getColor(index, this.f);
            } else if (index == 4) {
                this.g = obtainStyledAttributes.getDimensionPixelSize(index, this.g);
            } else if (index == 5) {
                this.h = obtainStyledAttributes.getDimensionPixelSize(index, this.h);
            } else if (index == 6) {
                this.i = obtainStyledAttributes.getDimensionPixelSize(index, this.i);
            } else if (index == 2) {
                this.j = obtainStyledAttributes.getDimensionPixelSize(index, this.j);
            } else if (index == 3) {
                this.k = obtainStyledAttributes.getDimensionPixelSize(index, this.k);
            } else if (index == 11) {
                this.l = obtainStyledAttributes.getColor(index, this.l);
            }
        }
        obtainStyledAttributes.recycle();
        this.p = new float[8];
        this.q = new float[8];
        this.s = new RectF();
        this.r = new RectF();
        this.t = new Paint();
        this.u = new Path();
        n();
        p();
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a) {
            return;
        }
        int i = 0;
        if (this.g <= 0) {
            float[] fArr = this.p;
            int i2 = this.h;
            float f = i2;
            fArr[1] = f;
            fArr[0] = f;
            int i3 = this.i;
            float f2 = i3;
            fArr[3] = f2;
            fArr[2] = f2;
            int i4 = this.k;
            float f3 = i4;
            fArr[5] = f3;
            fArr[4] = f3;
            int i5 = this.j;
            float f4 = i5;
            fArr[7] = f4;
            fArr[6] = f4;
            float[] fArr2 = this.q;
            int i6 = this.c;
            float f5 = i2 - (i6 / 2.0f);
            fArr2[1] = f5;
            fArr2[0] = f5;
            float f6 = i3 - (i6 / 2.0f);
            fArr2[3] = f6;
            fArr2[2] = f6;
            float f7 = i4 - (i6 / 2.0f);
            fArr2[5] = f7;
            fArr2[4] = f7;
            float f8 = i5 - (i6 / 2.0f);
            fArr2[7] = f8;
            fArr2[6] = f8;
            return;
        }
        while (true) {
            float[] fArr3 = this.p;
            if (i < fArr3.length) {
                int i7 = this.g;
                fArr3[i] = i7;
                this.q[i] = i7 - (this.c / 2.0f);
                i++;
            } else {
                return;
            }
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.g = 0;
            }
            n();
            u();
            invalidate();
        }
    }

    public void setBorderColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.d = i;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.c = i;
            o(false);
        }
    }

    public void setCornerBottomLeftRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.j = i;
            o(true);
        }
    }

    public void setCornerBottomRightRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.k = i;
            o(true);
        }
    }

    public void setCornerRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.g = i;
            o(false);
        }
    }

    public void setCornerTopLeftRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.h = i;
            o(true);
        }
    }

    public void setCornerTopRightRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.i = i;
            o(true);
        }
    }

    public void setInnerBorderColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.f = i;
            invalidate();
        }
    }

    public void setInnerBorderWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.e = i;
            p();
            invalidate();
        }
    }

    public void setMaskColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.l = i;
            invalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            canvas.saveLayer(this.r, null, 31);
            if (!this.b) {
                int i = this.m;
                int i2 = this.c;
                int i3 = this.e;
                int i4 = this.n;
                canvas.scale((((i - (i2 * 2)) - (i3 * 2)) * 1.0f) / i, (((i4 - (i2 * 2)) - (i3 * 2)) * 1.0f) / i4, i / 2.0f, i4 / 2.0f);
            }
            super.onDraw(canvas);
            this.t.reset();
            this.u.reset();
            if (this.a) {
                this.u.addCircle(this.m / 2.0f, this.n / 2.0f, this.o, Path.Direction.CCW);
            } else {
                this.u.addRoundRect(this.r, this.q, Path.Direction.CCW);
            }
            this.t.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.t.setAntiAlias(true);
            this.t.setStyle(Paint.Style.FILL);
            canvas.drawPath(this.u, this.t);
            if (Build.VERSION.SDK_INT <= 27) {
                this.t.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                canvas.drawPath(this.u, this.t);
            } else {
                this.t.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
                Path path = new Path();
                path.addRect(this.r, Path.Direction.CW);
                path.op(this.u, Path.Op.DIFFERENCE);
                canvas.drawPath(path, this.t);
            }
            this.t.setXfermode(null);
            int i5 = this.l;
            if (i5 != 0) {
                this.t.setColor(i5);
                canvas.drawPath(this.u, this.t);
            }
            canvas.restore();
            q(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.m = i;
            this.n = i2;
            u();
            x();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !this.a) {
            this.e = 0;
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && !this.a) {
            RectF rectF = this.s;
            int i = this.c;
            rectF.set(i / 2.0f, i / 2.0f, this.m - (i / 2.0f), this.n - (i / 2.0f));
        }
    }

    public final void r(Canvas canvas, int i, int i2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{canvas, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)}) == null) {
            t(i, i2);
            this.u.addCircle(this.m / 2.0f, this.n / 2.0f, f, Path.Direction.CCW);
            canvas.drawPath(this.u, this.t);
        }
    }

    public final void s(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{canvas, Integer.valueOf(i), Integer.valueOf(i2), rectF, fArr}) == null) {
            t(i, i2);
            this.u.addRoundRect(rectF, fArr, Path.Direction.CCW);
            canvas.drawPath(this.u, this.t);
        }
    }

    public final void t(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i, i2) == null) {
            this.u.reset();
            this.t.setStrokeWidth(i);
            this.t.setColor(i2);
            this.t.setStyle(Paint.Style.STROKE);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.a) {
                float min = Math.min(this.m, this.n) / 2.0f;
                this.o = min;
                RectF rectF = this.r;
                int i = this.m;
                int i2 = this.n;
                rectF.set((i / 2.0f) - min, (i2 / 2.0f) - min, (i / 2.0f) + min, (i2 / 2.0f) + min);
                return;
            }
            this.r.set(0.0f, 0.0f, this.m, this.n);
            if (this.b) {
                this.r = this.s;
            }
        }
    }
}
