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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TbCornersImageView extends AppCompatImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30735b;

    /* renamed from: c  reason: collision with root package name */
    public int f30736c;

    /* renamed from: d  reason: collision with root package name */
    public int f30737d;

    /* renamed from: e  reason: collision with root package name */
    public int f30738e;

    /* renamed from: f  reason: collision with root package name */
    public int f30739f;

    /* renamed from: g  reason: collision with root package name */
    public int f30740g;

    /* renamed from: h  reason: collision with root package name */
    public int f30741h;
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

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a) {
            return;
        }
        int i = 0;
        if (this.f30740g <= 0) {
            float[] fArr = this.p;
            int i2 = this.f30741h;
            float f2 = i2;
            fArr[1] = f2;
            fArr[0] = f2;
            int i3 = this.i;
            float f3 = i3;
            fArr[3] = f3;
            fArr[2] = f3;
            int i4 = this.k;
            float f4 = i4;
            fArr[5] = f4;
            fArr[4] = f4;
            int i5 = this.j;
            float f5 = i5;
            fArr[7] = f5;
            fArr[6] = f5;
            float[] fArr2 = this.q;
            int i6 = this.f30736c;
            float f6 = i2 - (i6 / 2.0f);
            fArr2[1] = f6;
            fArr2[0] = f6;
            float f7 = i3 - (i6 / 2.0f);
            fArr2[3] = f7;
            fArr2[2] = f7;
            float f8 = i4 - (i6 / 2.0f);
            fArr2[5] = f8;
            fArr2[4] = f8;
            float f9 = i5 - (i6 / 2.0f);
            fArr2[7] = f9;
            fArr2[6] = f9;
            return;
        }
        while (true) {
            float[] fArr3 = this.p;
            if (i >= fArr3.length) {
                return;
            }
            int i7 = this.f30740g;
            fArr3[i] = i7;
            this.q[i] = i7 - (this.f30736c / 2.0f);
            i++;
        }
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.f30740g = 0;
            }
            f();
            q();
            invalidate();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a) {
            return;
        }
        this.f30738e = 0;
    }

    public final void m(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (this.a) {
                int i = this.f30736c;
                if (i > 0) {
                    n(canvas, i, this.f30737d, this.o - (i / 2.0f));
                }
                int i2 = this.f30738e;
                if (i2 > 0) {
                    n(canvas, i2, this.f30739f, (this.o - this.f30736c) - (i2 / 2.0f));
                    return;
                }
                return;
            }
            int i3 = this.f30736c;
            if (i3 > 0) {
                o(canvas, i3, this.f30737d, this.s, this.p);
            }
        }
    }

    public final void n(Canvas canvas, int i, int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{canvas, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            p(i, i2);
            this.u.addCircle(this.m / 2.0f, this.n / 2.0f, f2, Path.Direction.CCW);
            canvas.drawPath(this.u, this.t);
        }
    }

    public final void o(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{canvas, Integer.valueOf(i), Integer.valueOf(i2), rectF, fArr}) == null) {
            p(i, i2);
            this.u.addRoundRect(rectF, fArr, Path.Direction.CCW);
            canvas.drawPath(this.u, this.t);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            canvas.saveLayer(this.r, null, 31);
            if (!this.f30735b) {
                int i = this.m;
                int i2 = this.f30736c;
                int i3 = this.f30738e;
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
            m(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.m = i;
            this.n = i2;
            q();
            r();
        }
    }

    public final void p(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            this.u.reset();
            this.t.setStrokeWidth(i);
            this.t.setColor(i2);
            this.t.setStyle(Paint.Style.STROKE);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.a) {
            return;
        }
        RectF rectF = this.s;
        int i = this.f30736c;
        rectF.set(i / 2.0f, i / 2.0f, this.m - (i / 2.0f), this.n - (i / 2.0f));
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
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
            if (this.f30735b) {
                this.r = this.s;
            }
        }
    }

    public void setBorderColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f30737d = i;
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f30736c = i;
            g(false);
        }
    }

    public void setCornerBottomLeftRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.j = i;
            g(true);
        }
    }

    public void setCornerBottomRightRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.k = i;
            g(true);
        }
    }

    public void setCornerRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.f30740g = i;
            g(false);
        }
    }

    public void setCornerTopLeftRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.f30741h = i;
            g(true);
        }
    }

    public void setCornerTopRightRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.i = i;
            g(true);
        }
    }

    public void setInnerBorderColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.f30739f = i;
            invalidate();
        }
    }

    public void setInnerBorderWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.f30738e = i;
            k();
            invalidate();
        }
    }

    public void setMaskColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.l = i;
            invalidate();
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
        this.f30737d = -1;
        this.f30739f = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0400e1, R.attr.obfuscated_res_0x7f0400e2, R.attr.obfuscated_res_0x7f040191, R.attr.obfuscated_res_0x7f040192, R.attr.obfuscated_res_0x7f040193, R.attr.obfuscated_res_0x7f040194, R.attr.obfuscated_res_0x7f040195, R.attr.obfuscated_res_0x7f0402bf, R.attr.obfuscated_res_0x7f0402c0, R.attr.obfuscated_res_0x7f0402d0, R.attr.obfuscated_res_0x7f0402d4, R.attr.obfuscated_res_0x7f040401}, 0, 0);
        for (int i4 = 0; i4 < obtainStyledAttributes.getIndexCount(); i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            if (index == 10) {
                this.f30735b = obtainStyledAttributes.getBoolean(index, this.f30735b);
            } else if (index == 9) {
                this.a = obtainStyledAttributes.getBoolean(index, this.a);
            } else if (index == 1) {
                this.f30736c = obtainStyledAttributes.getDimensionPixelSize(index, this.f30736c);
            } else if (index == 0) {
                this.f30737d = obtainStyledAttributes.getColor(index, this.f30737d);
            } else if (index == 8) {
                this.f30738e = obtainStyledAttributes.getDimensionPixelSize(index, this.f30738e);
            } else if (index == 7) {
                this.f30739f = obtainStyledAttributes.getColor(index, this.f30739f);
            } else if (index == 4) {
                this.f30740g = obtainStyledAttributes.getDimensionPixelSize(index, this.f30740g);
            } else if (index == 5) {
                this.f30741h = obtainStyledAttributes.getDimensionPixelSize(index, this.f30741h);
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
        f();
        k();
    }
}
