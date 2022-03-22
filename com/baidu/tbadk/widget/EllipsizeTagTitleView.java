package com.baidu.tbadk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.l.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class EllipsizeTagTitleView extends View implements q {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: A */
    public static final int CAM_X0301 = 2131099742;
    public static final int B;
    public static final int C;
    public static final int D;
    public static final int E;
    public static final int F;
    public static final int G;
    public static final int H;

    /* renamed from: z */
    public static final int CAM_X0105 = 2131099660;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f30667b;

    /* renamed from: c  reason: collision with root package name */
    public int f30668c;

    /* renamed from: d  reason: collision with root package name */
    public int f30669d;

    /* renamed from: e  reason: collision with root package name */
    public int f30670e;

    /* renamed from: f  reason: collision with root package name */
    public int f30671f;

    /* renamed from: g  reason: collision with root package name */
    public int f30672g;

    /* renamed from: h  reason: collision with root package name */
    public int f30673h;
    public int i;
    public int j;
    public int k;
    public String l;
    public final float[] m;
    public float n;
    public float o;
    public float p;
    public float q;
    public int r;
    public int s;
    public String t;
    public String u;
    public TextPaint v;
    public TextPaint w;
    public Paint.FontMetrics x;
    public RectF y;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1119591187, "Lcom/baidu/tbadk/widget/EllipsizeTagTitleView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1119591187, "Lcom/baidu/tbadk/widget/EllipsizeTagTitleView;");
                return;
            }
        }
        B = n.f(TbadkCoreApplication.getInst(), R.dimen.T_X06);
        C = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds16);
        D = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
        E = n.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
        F = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds12);
        G = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        H = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EllipsizeTagTitleView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private float getSingleOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.o - this.v.getFontMetrics().descent : invokeV.floatValue;
    }

    public final int a(int i, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)})) == null) {
            TextPaint textPaint = this.v;
            String str = this.t;
            return textPaint.breakText(str, i, str.length(), true, f2, this.m);
        }
        return invokeCommon.intValue;
    }

    public final int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            int length = this.t.length();
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int a = a(i2, i3 == this.f30670e + (-1) ? i - this.r : i);
                i3++;
                int i4 = this.f30670e;
                if (i3 >= i4) {
                    return i4;
                }
                int i5 = a + i2;
                if (i5 == length) {
                    return ((int) (((float) i) - this.v.measureText(this.t, i2, length))) < this.r ? i3 + 1 : i3;
                }
                i2 = i5;
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(this.u)) {
                return 0;
            }
            return (int) (0 + this.p + (this.f30672g * 2) + this.i);
        }
        return invokeV.intValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.u)) {
                return 0;
            }
            return this.i + ((int) this.w.measureText(this.u)) + 0 + (this.f30673h * 2) + this.f30671f;
        }
        return invokeV.intValue;
    }

    public final void e(Canvas canvas, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{canvas, Float.valueOf(f2), Float.valueOf(f3)}) == null) || canvas == null) {
            return;
        }
        String str = this.l;
        canvas.drawText(str, 0, str.length(), f2, f3, (Paint) this.v);
    }

    public final void f(Canvas canvas, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048581, this, canvas, f2) == null) || canvas == null) {
            return;
        }
        this.w.setStyle(Paint.Style.FILL);
        canvas.drawText(this.u, this.y.left + this.f30673h, (f2 + (this.p / 2.0f)) - this.q, this.w);
    }

    public final void g(Canvas canvas, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{canvas, Float.valueOf(f2), Float.valueOf(f3)}) == null) || canvas == null) {
            return;
        }
        RectF rectF = this.y;
        int i = this.i;
        float f4 = f3 + ((i * 1.0f) / 2.0f);
        rectF.left = f4;
        int i2 = this.s;
        rectF.top = f2 - ((i2 * 1.0f) / 2.0f);
        rectF.right = ((f4 + this.r) - this.f30671f) + ((i * 1.0f) / 2.0f);
        rectF.bottom = f2 + ((i2 * 1.0f) / 2.0f);
        this.w.setStyle(Paint.Style.STROKE);
        this.w.setStrokeWidth(this.i);
        RectF rectF2 = this.y;
        int i3 = this.j;
        canvas.drawRoundRect(rectF2, i3, i3, this.w);
    }

    public final void h(Canvas canvas, int i, int i2, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{canvas, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)}) == null) || canvas == null) {
            return;
        }
        canvas.drawText(this.t, i, i2, f2, f3, (Paint) this.v);
    }

    public final void i(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            int length = this.t.length();
            float singleOffset = getSingleOffset();
            int i = 0;
            int i2 = 0;
            while (i < length) {
                Paint.FontMetrics fontMetrics = this.x;
                float f2 = ((fontMetrics.ascent + singleOffset) + (fontMetrics.descent + singleOffset)) / 2.0f;
                if (i2 == this.f30670e - 1) {
                    float width = getWidth() - this.r;
                    int a = i + a(i, width);
                    if (a == length && this.m[0] < width) {
                        h(canvas, i, a, 0.0f, singleOffset);
                        g(canvas, f2, this.m[0] + this.f30671f);
                        f(canvas, f2);
                        return;
                    }
                    h(canvas, i, i + a(i, (int) (width - this.n)), 0.0f, singleOffset);
                    e(canvas, this.m[0], singleOffset);
                    g(canvas, f2, this.m[0] + this.n + this.f30671f);
                    f(canvas, f2);
                    return;
                }
                float width2 = getWidth();
                int a2 = i + a(i, width2);
                h(canvas, i, a2, 0.0f, singleOffset);
                if (a2 == length) {
                    float[] fArr = this.m;
                    if (fArr[0] + this.r < width2) {
                        g(canvas, f2, fArr[0] + this.f30671f);
                        f(canvas, f2);
                        return;
                    }
                    float singleOffset2 = singleOffset + getSingleOffset() + this.f30669d;
                    Paint.FontMetrics fontMetrics2 = this.x;
                    float f3 = ((fontMetrics2.ascent + singleOffset2) + (singleOffset2 + fontMetrics2.descent)) / 2.0f;
                    g(canvas, f3, 0.0f);
                    f(canvas, f3);
                    return;
                }
                singleOffset += getSingleOffset() + this.f30669d;
                i2++;
                i = a2;
            }
        }
    }

    public final void j(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            int length = this.t.length();
            float singleOffset = getSingleOffset();
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                int width = getWidth();
                if (i == this.f30670e - 1) {
                    float f2 = width;
                    int breakText = i2 + this.v.breakText(this.t, i2, length, true, f2, this.m);
                    if (breakText == length && this.m[0] < f2) {
                        h(canvas, i2, breakText, 0.0f, singleOffset);
                        return;
                    }
                    h(canvas, i2, i2 + a(i2, (int) (getWidth() - this.n)), 0.0f, singleOffset);
                    e(canvas, this.m[0], singleOffset);
                    return;
                }
                int a = i2 + a(i2, width);
                h(canvas, i2, a, 0.0f, singleOffset);
                singleOffset += getSingleOffset() + this.f30669d;
                i++;
                i2 = a;
            }
        }
    }

    public final void k(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0405c7, R.attr.obfuscated_res_0x7f0405c8, R.attr.obfuscated_res_0x7f0405c9, R.attr.obfuscated_res_0x7f0405ca, R.attr.obfuscated_res_0x7f0405cb, R.attr.obfuscated_res_0x7f0405cc, R.attr.obfuscated_res_0x7f0405cd, R.attr.obfuscated_res_0x7f0405ce, R.attr.obfuscated_res_0x7f0405cf, R.attr.obfuscated_res_0x7f0405d0, R.attr.obfuscated_res_0x7f0405d1, R.attr.obfuscated_res_0x7f0405d2});
            this.f30668c = obtainStyledAttributes.getInt(9, CAM_X0105);
            this.f30667b = obtainStyledAttributes.getInt(11, 0);
            this.a = obtainStyledAttributes.getDimensionPixelSize(10, B);
            this.f30669d = obtainStyledAttributes.getDimensionPixelSize(1, C);
            this.f30670e = obtainStyledAttributes.getInt(2, 2);
            this.l = obtainStyledAttributes.getString(0);
            this.f30671f = obtainStyledAttributes.getInt(5, D);
            this.f30672g = obtainStyledAttributes.getInt(7, G);
            this.f30673h = obtainStyledAttributes.getInt(6, H);
            this.i = obtainStyledAttributes.getInt(8, E);
            this.j = obtainStyledAttributes.getInt(4, F);
            this.k = obtainStyledAttributes.getInt(9, CAM_X0301);
            obtainStyledAttributes.recycle();
            TextPaint textPaint = new TextPaint(1);
            this.v = textPaint;
            textPaint.setTextSize(this.a);
            if (this.f30667b == 1) {
                this.v.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                this.v.setTypeface(Typeface.DEFAULT);
            }
            this.v.setColor(SkinManager.getColor(this.f30668c));
            this.v.getFontMetrics(this.x);
            if (TextUtils.isEmpty(this.l)) {
                this.l = "...#";
            }
            this.n = this.v.measureText(this.l);
            TextPaint textPaint2 = new TextPaint(1);
            this.w = textPaint2;
            textPaint2.setColor(SkinManager.getColor(this.k));
            this.w.setTextSize(n.f(TbadkCoreApplication.getInst(), R.dimen.T_X10));
            if (this.w.getFontMetrics() != null) {
                this.p = this.w.getFontMetrics().descent - this.w.getFontMetrics().ascent;
                this.q = this.w.getFontMetrics().descent;
            }
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, tbPageContext, i) == null) {
            this.v.setColor(SkinManager.getColor(this.f30668c));
            this.w.setColor(SkinManager.getColor(this.k));
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, canvas) == null) {
            super.onDraw(canvas);
            if (TextUtils.isEmpty(this.t)) {
                return;
            }
            if (TextUtils.isEmpty(this.u)) {
                j(canvas);
            } else {
                i(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode != 1073741824) {
                size = ((int) this.v.measureText(this.t)) + this.r;
            }
            if (mode2 != 1073741824) {
                if (this.v.getFontMetrics() != null) {
                    float f2 = this.v.getFontMetrics().descent - this.v.getFontMetrics().ascent;
                    this.o = f2;
                    int i3 = this.s;
                    if (f2 < i3) {
                        this.o = i3;
                    }
                }
                int b2 = b(size);
                size2 = (int) (0 + (this.o * b2) + (this.f30669d * (b2 - 1)));
            }
            setMeasuredDimension(size, size2);
        }
    }

    public void setTitleAndTag(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            this.t = str;
            this.u = str2;
            this.r = d();
            this.s = c();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EllipsizeTagTitleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EllipsizeTagTitleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = B;
        this.f30667b = 1;
        this.f30668c = CAM_X0105;
        this.f30669d = C;
        this.f30670e = 2;
        this.f30671f = D;
        this.f30672g = G;
        this.f30673h = H;
        this.i = E;
        this.j = F;
        this.k = CAM_X0301;
        this.l = "...#";
        this.m = new float[1];
        this.t = "";
        this.x = new Paint.FontMetrics();
        this.y = new RectF();
        k(context, attributeSet);
    }
}
