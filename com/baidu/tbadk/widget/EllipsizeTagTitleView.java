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
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class EllipsizeTagTitleView extends View implements q {
    public static /* synthetic */ Interceptable $ic;
    public static final int D;
    public static final int E;
    public static final int F;
    public static final int G;
    public static final int H;
    public static final int I;
    public static final int J;
    public static final int K;
    public static final int L;
    public transient /* synthetic */ FieldHolder $fh;
    public TextPaint A;
    public Paint.FontMetrics B;
    public RectF C;

    /* renamed from: e  reason: collision with root package name */
    public int f41406e;

    /* renamed from: f  reason: collision with root package name */
    public int f41407f;

    /* renamed from: g  reason: collision with root package name */
    public int f41408g;

    /* renamed from: h  reason: collision with root package name */
    public int f41409h;

    /* renamed from: i  reason: collision with root package name */
    public int f41410i;

    /* renamed from: j  reason: collision with root package name */
    public int f41411j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public String p;
    public final float[] q;
    public float r;
    public float s;
    public float t;
    public float u;
    public int v;
    public int w;
    public String x;
    public String y;
    public TextPaint z;

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
        D = R.color.CAM_X0105;
        E = R.color.CAM_X0301;
        F = n.f(TbadkCoreApplication.getInst(), R.dimen.T_X06);
        G = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds16);
        H = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
        I = n.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
        J = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds12);
        K = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        L = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.s - this.z.getFontMetrics().descent : invokeV.floatValue;
    }

    public final int a(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            TextPaint textPaint = this.z;
            String str = this.x;
            return textPaint.breakText(str, i2, str.length(), true, f2, this.q);
        }
        return invokeCommon.intValue;
    }

    public final int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int length = this.x.length();
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                int a = a(i3, i4 == this.f41410i + (-1) ? i2 - this.v : i2);
                i4++;
                int i5 = this.f41410i;
                if (i4 >= i5) {
                    return i5;
                }
                int i6 = a + i3;
                if (i6 == length) {
                    return ((int) (((float) i2) - this.z.measureText(this.x, i3, length))) < this.v ? i4 + 1 : i4;
                }
                i3 = i6;
            }
            return i4;
        }
        return invokeI.intValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(this.y)) {
                return 0;
            }
            return (int) (0 + this.t + (this.k * 2) + this.m);
        }
        return invokeV.intValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.y)) {
                return 0;
            }
            return this.m + ((int) this.A.measureText(this.y)) + 0 + (this.l * 2) + this.f41411j;
        }
        return invokeV.intValue;
    }

    public final void e(Canvas canvas, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{canvas, Float.valueOf(f2), Float.valueOf(f3)}) == null) || canvas == null) {
            return;
        }
        String str = this.p;
        canvas.drawText(str, 0, str.length(), f2, f3, (Paint) this.z);
    }

    public final void f(Canvas canvas, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048581, this, canvas, f2) == null) || canvas == null) {
            return;
        }
        this.A.setStyle(Paint.Style.FILL);
        canvas.drawText(this.y, this.C.left + this.l, (f2 + (this.t / 2.0f)) - this.u, this.A);
    }

    public final void g(Canvas canvas, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{canvas, Float.valueOf(f2), Float.valueOf(f3)}) == null) || canvas == null) {
            return;
        }
        RectF rectF = this.C;
        int i2 = this.m;
        float f4 = f3 + ((i2 * 1.0f) / 2.0f);
        rectF.left = f4;
        int i3 = this.w;
        rectF.top = f2 - ((i3 * 1.0f) / 2.0f);
        rectF.right = ((f4 + this.v) - this.f41411j) + ((i2 * 1.0f) / 2.0f);
        rectF.bottom = f2 + ((i3 * 1.0f) / 2.0f);
        this.A.setStyle(Paint.Style.STROKE);
        this.A.setStrokeWidth(this.m);
        RectF rectF2 = this.C;
        int i4 = this.n;
        canvas.drawRoundRect(rectF2, i4, i4, this.A);
    }

    public final void h(Canvas canvas, int i2, int i3, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{canvas, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3)}) == null) || canvas == null) {
            return;
        }
        canvas.drawText(this.x, i2, i3, f2, f3, (Paint) this.z);
    }

    public final void i(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            int length = this.x.length();
            float singleOffset = getSingleOffset();
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                Paint.FontMetrics fontMetrics = this.B;
                float f2 = ((fontMetrics.ascent + singleOffset) + (fontMetrics.descent + singleOffset)) / 2.0f;
                if (i3 == this.f41410i - 1) {
                    float width = getWidth() - this.v;
                    int a = i2 + a(i2, width);
                    if (a == length && this.q[0] < width) {
                        h(canvas, i2, a, 0.0f, singleOffset);
                        g(canvas, f2, this.q[0] + this.f41411j);
                        f(canvas, f2);
                        return;
                    }
                    h(canvas, i2, i2 + a(i2, (int) (width - this.r)), 0.0f, singleOffset);
                    e(canvas, this.q[0], singleOffset);
                    g(canvas, f2, this.q[0] + this.r + this.f41411j);
                    f(canvas, f2);
                    return;
                }
                float width2 = getWidth();
                int a2 = i2 + a(i2, width2);
                h(canvas, i2, a2, 0.0f, singleOffset);
                if (a2 == length) {
                    float[] fArr = this.q;
                    if (fArr[0] + this.v < width2) {
                        g(canvas, f2, fArr[0] + this.f41411j);
                        f(canvas, f2);
                        return;
                    }
                    float singleOffset2 = singleOffset + getSingleOffset() + this.f41409h;
                    Paint.FontMetrics fontMetrics2 = this.B;
                    float f3 = ((fontMetrics2.ascent + singleOffset2) + (singleOffset2 + fontMetrics2.descent)) / 2.0f;
                    g(canvas, f3, 0.0f);
                    f(canvas, f3);
                    return;
                }
                singleOffset += getSingleOffset() + this.f41409h;
                i3++;
                i2 = a2;
            }
        }
    }

    public final void j(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            int length = this.x.length();
            float singleOffset = getSingleOffset();
            int i2 = 0;
            int i3 = 0;
            while (i3 < length) {
                int width = getWidth();
                if (i2 == this.f41410i - 1) {
                    float f2 = width;
                    int breakText = i3 + this.z.breakText(this.x, i3, length, true, f2, this.q);
                    if (breakText == length && this.q[0] < f2) {
                        h(canvas, i3, breakText, 0.0f, singleOffset);
                        return;
                    }
                    h(canvas, i3, i3 + a(i3, (int) (getWidth() - this.r)), 0.0f, singleOffset);
                    e(canvas, this.q[0], singleOffset);
                    return;
                }
                int a = i3 + a(i3, width);
                h(canvas, i3, a, 0.0f, singleOffset);
                singleOffset += getSingleOffset() + this.f41409h;
                i2++;
                i3 = a;
            }
        }
    }

    public final void k(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.EllipsizeTagTitleView);
            this.f41408g = obtainStyledAttributes.getInt(R$styleable.EllipsizeTagTitleView_tag_title_text_color, D);
            this.f41407f = obtainStyledAttributes.getInt(R$styleable.EllipsizeTagTitleView_tag_title_text_style, 0);
            this.f41406e = obtainStyledAttributes.getDimensionPixelSize(R$styleable.EllipsizeTagTitleView_tag_title_text_size, F);
            this.f41409h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.EllipsizeTagTitleView_tag_title_line_space, G);
            this.f41410i = obtainStyledAttributes.getInt(R$styleable.EllipsizeTagTitleView_tag_title_max_line, 2);
            this.p = obtainStyledAttributes.getString(R$styleable.EllipsizeTagTitleView_tag_title_ellipsize_text);
            this.f41411j = obtainStyledAttributes.getInt(R$styleable.EllipsizeTagTitleView_tag_title_tag_margin, H);
            this.k = obtainStyledAttributes.getInt(R$styleable.EllipsizeTagTitleView_tag_title_tag_padding_vertical, K);
            this.l = obtainStyledAttributes.getInt(R$styleable.EllipsizeTagTitleView_tag_title_tag_padding_horizontal, L);
            this.m = obtainStyledAttributes.getInt(R$styleable.EllipsizeTagTitleView_tag_title_tag_stroke_width, I);
            this.n = obtainStyledAttributes.getInt(R$styleable.EllipsizeTagTitleView_tag_title_tag_corner_radius, J);
            this.o = obtainStyledAttributes.getInt(R$styleable.EllipsizeTagTitleView_tag_title_text_color, E);
            obtainStyledAttributes.recycle();
            TextPaint textPaint = new TextPaint(1);
            this.z = textPaint;
            textPaint.setTextSize(this.f41406e);
            if (this.f41407f == 1) {
                this.z.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                this.z.setTypeface(Typeface.DEFAULT);
            }
            this.z.setColor(SkinManager.getColor(this.f41408g));
            this.z.getFontMetrics(this.B);
            if (TextUtils.isEmpty(this.p)) {
                this.p = "...#";
            }
            this.r = this.z.measureText(this.p);
            TextPaint textPaint2 = new TextPaint(1);
            this.A = textPaint2;
            textPaint2.setColor(SkinManager.getColor(this.o));
            this.A.setTextSize(n.f(TbadkCoreApplication.getInst(), R.dimen.T_X10));
            if (this.A.getFontMetrics() != null) {
                this.t = this.A.getFontMetrics().descent - this.A.getFontMetrics().ascent;
                this.u = this.A.getFontMetrics().descent;
            }
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, tbPageContext, i2) == null) {
            this.z.setColor(SkinManager.getColor(this.f41408g));
            this.A.setColor(SkinManager.getColor(this.o));
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, canvas) == null) {
            super.onDraw(canvas);
            if (TextUtils.isEmpty(this.x)) {
                return;
            }
            if (TextUtils.isEmpty(this.y)) {
                j(canvas);
            } else {
                i(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode != 1073741824) {
                size = ((int) this.z.measureText(this.x)) + this.v;
            }
            if (mode2 != 1073741824) {
                if (this.z.getFontMetrics() != null) {
                    float f2 = this.z.getFontMetrics().descent - this.z.getFontMetrics().ascent;
                    this.s = f2;
                    int i4 = this.w;
                    if (f2 < i4) {
                        this.s = i4;
                    }
                }
                int b2 = b(size);
                size2 = (int) (0 + (this.s * b2) + (this.f41409h * (b2 - 1)));
            }
            setMeasuredDimension(size, size2);
        }
    }

    public void setTitleAndTag(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            this.x = str;
            this.y = str2;
            this.v = d();
            this.w = c();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EllipsizeTagTitleView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f41406e = F;
        this.f41407f = 1;
        this.f41408g = D;
        this.f41409h = G;
        this.f41410i = 2;
        this.f41411j = H;
        this.k = K;
        this.l = L;
        this.m = I;
        this.n = J;
        this.o = E;
        this.p = "...#";
        this.q = new float[1];
        this.x = "";
        this.B = new Paint.FontMetrics();
        this.C = new RectF();
        k(context, attributeSet);
    }
}
