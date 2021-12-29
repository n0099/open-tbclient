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
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class TbCornersImageView extends AppCompatImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42745e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42746f;

    /* renamed from: g  reason: collision with root package name */
    public int f42747g;

    /* renamed from: h  reason: collision with root package name */
    public int f42748h;

    /* renamed from: i  reason: collision with root package name */
    public int f42749i;

    /* renamed from: j  reason: collision with root package name */
    public int f42750j;

    /* renamed from: k  reason: collision with root package name */
    public int f42751k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public float s;
    public float[] t;
    public float[] u;
    public RectF v;
    public RectF w;
    public Paint x;
    public Path y;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbCornersImageView(Context context) {
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f42745e) {
            return;
        }
        int i2 = 0;
        if (this.f42751k <= 0) {
            float[] fArr = this.t;
            int i3 = this.l;
            float f2 = i3;
            fArr[1] = f2;
            fArr[0] = f2;
            int i4 = this.m;
            float f3 = i4;
            fArr[3] = f3;
            fArr[2] = f3;
            int i5 = this.o;
            float f4 = i5;
            fArr[5] = f4;
            fArr[4] = f4;
            int i6 = this.n;
            float f5 = i6;
            fArr[7] = f5;
            fArr[6] = f5;
            float[] fArr2 = this.u;
            int i7 = this.f42747g;
            float f6 = i3 - (i7 / 2.0f);
            fArr2[1] = f6;
            fArr2[0] = f6;
            float f7 = i4 - (i7 / 2.0f);
            fArr2[3] = f7;
            fArr2[2] = f7;
            float f8 = i5 - (i7 / 2.0f);
            fArr2[5] = f8;
            fArr2[4] = f8;
            float f9 = i6 - (i7 / 2.0f);
            fArr2[7] = f9;
            fArr2[6] = f9;
            return;
        }
        while (true) {
            float[] fArr3 = this.t;
            if (i2 >= fArr3.length) {
                return;
            }
            int i8 = this.f42751k;
            fArr3[i2] = i8;
            this.u[i2] = i8 - (this.f42747g / 2.0f);
            i2++;
        }
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.f42751k = 0;
            }
            a();
            l();
            invalidate();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f42745e) {
            return;
        }
        this.f42749i = 0;
    }

    public final void h(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (this.f42745e) {
                int i2 = this.f42747g;
                if (i2 > 0) {
                    i(canvas, i2, this.f42748h, this.s - (i2 / 2.0f));
                }
                int i3 = this.f42749i;
                if (i3 > 0) {
                    i(canvas, i3, this.f42750j, (this.s - this.f42747g) - (i3 / 2.0f));
                    return;
                }
                return;
            }
            int i4 = this.f42747g;
            if (i4 > 0) {
                j(canvas, i4, this.f42748h, this.w, this.t);
            }
        }
    }

    public final void i(Canvas canvas, int i2, int i3, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{canvas, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)}) == null) {
            k(i2, i3);
            this.y.addCircle(this.q / 2.0f, this.r / 2.0f, f2, Path.Direction.CCW);
            canvas.drawPath(this.y, this.x);
        }
    }

    public void isCircle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f42745e = z;
            f();
            m();
            invalidate();
        }
    }

    public void isCoverSrc(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f42746f = z;
            m();
            invalidate();
        }
    }

    public final void j(Canvas canvas, int i2, int i3, RectF rectF, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{canvas, Integer.valueOf(i2), Integer.valueOf(i3), rectF, fArr}) == null) {
            k(i2, i3);
            this.y.addRoundRect(rectF, fArr, Path.Direction.CCW);
            canvas.drawPath(this.y, this.x);
        }
    }

    public final void k(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            this.y.reset();
            this.x.setStrokeWidth(i2);
            this.x.setColor(i3);
            this.x.setStyle(Paint.Style.STROKE);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f42745e) {
            return;
        }
        RectF rectF = this.w;
        int i2 = this.f42747g;
        rectF.set(i2 / 2.0f, i2 / 2.0f, this.q - (i2 / 2.0f), this.r - (i2 / 2.0f));
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f42745e) {
                float min = Math.min(this.q, this.r) / 2.0f;
                this.s = min;
                RectF rectF = this.v;
                int i2 = this.q;
                int i3 = this.r;
                rectF.set((i2 / 2.0f) - min, (i3 / 2.0f) - min, (i2 / 2.0f) + min, (i3 / 2.0f) + min);
                return;
            }
            this.v.set(0.0f, 0.0f, this.q, this.r);
            if (this.f42746f) {
                this.v = this.w;
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) {
            canvas.saveLayer(this.v, null, 31);
            if (!this.f42746f) {
                int i2 = this.q;
                int i3 = this.f42747g;
                int i4 = this.f42749i;
                int i5 = this.r;
                canvas.scale((((i2 - (i3 * 2)) - (i4 * 2)) * 1.0f) / i2, (((i5 - (i3 * 2)) - (i4 * 2)) * 1.0f) / i5, i2 / 2.0f, i5 / 2.0f);
            }
            super.onDraw(canvas);
            this.x.reset();
            this.y.reset();
            if (this.f42745e) {
                this.y.addCircle(this.q / 2.0f, this.r / 2.0f, this.s, Path.Direction.CCW);
            } else {
                this.y.addRoundRect(this.v, this.u, Path.Direction.CCW);
            }
            this.x.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.x.setAntiAlias(true);
            this.x.setStyle(Paint.Style.FILL);
            canvas.drawPath(this.y, this.x);
            if (Build.VERSION.SDK_INT <= 27) {
                this.x.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                canvas.drawPath(this.y, this.x);
            } else {
                this.x.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
                Path path = new Path();
                path.addRect(this.v, Path.Direction.CW);
                path.op(this.y, Path.Op.DIFFERENCE);
                canvas.drawPath(path, this.x);
            }
            this.x.setXfermode(null);
            int i6 = this.p;
            if (i6 != 0) {
                this.x.setColor(i6);
                canvas.drawPath(this.y, this.x);
            }
            canvas.restore();
            h(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.q = i2;
            this.r = i3;
            l();
            m();
        }
    }

    public void setBorderColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f42748h = i2;
            invalidate();
        }
    }

    public void setBorderWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f42747g = i2;
            b(false);
        }
    }

    public void setCornerBottomLeftRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.n = i2;
            b(true);
        }
    }

    public void setCornerBottomRightRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.o = i2;
            b(true);
        }
    }

    public void setCornerRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f42751k = i2;
            b(false);
        }
    }

    public void setCornerTopLeftRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.l = i2;
            b(true);
        }
    }

    public void setCornerTopRightRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.m = i2;
            b(true);
        }
    }

    public void setInnerBorderColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f42750j = i2;
            invalidate();
        }
    }

    public void setInnerBorderWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.f42749i = i2;
            f();
            invalidate();
        }
    }

    public void setMaskColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.p = i2;
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
    public TbCornersImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f42748h = -1;
        this.f42750j = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CornersImageView, 0, 0);
        for (int i5 = 0; i5 < obtainStyledAttributes.getIndexCount(); i5++) {
            int index = obtainStyledAttributes.getIndex(i5);
            if (index == R$styleable.CornersImageView_is_cover_src) {
                this.f42746f = obtainStyledAttributes.getBoolean(index, this.f42746f);
            } else if (index == R$styleable.CornersImageView_is_circle) {
                this.f42745e = obtainStyledAttributes.getBoolean(index, this.f42745e);
            } else if (index == R$styleable.CornersImageView_border_width) {
                this.f42747g = obtainStyledAttributes.getDimensionPixelSize(index, this.f42747g);
            } else if (index == R$styleable.CornersImageView_border_color) {
                this.f42748h = obtainStyledAttributes.getColor(index, this.f42748h);
            } else if (index == R$styleable.CornersImageView_inner_border_width) {
                this.f42749i = obtainStyledAttributes.getDimensionPixelSize(index, this.f42749i);
            } else if (index == R$styleable.CornersImageView_inner_border_color) {
                this.f42750j = obtainStyledAttributes.getColor(index, this.f42750j);
            } else if (index == R$styleable.CornersImageView_corner_radius) {
                this.f42751k = obtainStyledAttributes.getDimensionPixelSize(index, this.f42751k);
            } else if (index == R$styleable.CornersImageView_corner_top_left_radius) {
                this.l = obtainStyledAttributes.getDimensionPixelSize(index, this.l);
            } else if (index == R$styleable.CornersImageView_corner_top_right_radius) {
                this.m = obtainStyledAttributes.getDimensionPixelSize(index, this.m);
            } else if (index == R$styleable.CornersImageView_corner_bottom_left_radius) {
                this.n = obtainStyledAttributes.getDimensionPixelSize(index, this.n);
            } else if (index == R$styleable.CornersImageView_corner_bottom_right_radius) {
                this.o = obtainStyledAttributes.getDimensionPixelSize(index, this.o);
            } else if (index == R$styleable.CornersImageView_mask_color) {
                this.p = obtainStyledAttributes.getColor(index, this.p);
            }
        }
        obtainStyledAttributes.recycle();
        this.t = new float[8];
        this.u = new float[8];
        this.w = new RectF();
        this.v = new RectF();
        this.x = new Paint();
        this.y = new Path();
        a();
        f();
    }
}
