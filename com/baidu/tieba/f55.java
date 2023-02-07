package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f55 extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public RectF b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final float j;
    public final int k;
    public int l;
    public int m;
    public float n;
    public boolean o;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public float h;
        public int i;
        public int j;
        public int k;
        public float l;
        public boolean m;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = R.dimen.T_X10;
            this.b = SkinManager.getColor(R.color.CAM_X0101);
            this.e = SkinManager.getColor(R.color.CAM_X0302);
            this.k = 0;
            this.m = false;
        }

        public b A(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                this.b = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b o(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.e = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public void p(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
                this.l = f;
            }
        }

        public void q(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                this.k = i;
            }
        }

        public void r(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                this.j = i;
            }
        }

        public b s(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.i = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b t(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                this.g = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b u(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.c = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b v(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048585, this, f)) == null) {
                this.h = f;
                return this;
            }
            return (b) invokeF.objValue;
        }

        public b w(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                this.f = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b x(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
                this.d = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b y(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                this.a = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public void z(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
                this.m = z;
            }
        }

        public f55 n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new f55(this, null);
            }
            return (f55) invokeV.objValue;
        }
    }

    public f55(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = bVar.a;
        this.d = bVar.b;
        this.g = bVar.e;
        this.e = bVar.c;
        this.f = bVar.d;
        this.i = bVar.g;
        this.h = bVar.f;
        this.j = bVar.h;
        this.k = bVar.i;
        this.l = bVar.j;
        this.m = bVar.k;
        this.n = bVar.l;
        this.o = bVar.m;
    }

    public /* synthetic */ f55(b bVar, a aVar) {
        this(bVar);
    }

    public final void a(Canvas canvas, CharSequence charSequence, int i, int i2, float f, float f2, Paint paint) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), paint}) == null) {
            if (this.m != 0) {
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(this.m);
                paint.setStrokeWidth(this.l);
                paint.setAlpha((int) (this.n * 255.0f));
            } else {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(this.g);
            }
            paint.setAntiAlias(true);
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (r15.b(charSequence.subSequence(i, i2))) {
                r15.a(fontMetricsInt, (int) paint.getTextSize());
            }
            RectF rectF = new RectF(this.i + f, fontMetricsInt.ascent + f2, (this.a + f) - this.h, (fontMetricsInt.descent + f2) - this.k);
            this.b = rectF;
            float f3 = this.j;
            canvas.drawRoundRect(rectF, f3, f3, paint);
            paint.setAlpha(255);
            if (this.m != 0 && (i3 = this.g) != 0) {
                paint.setColor(i3);
                paint.setStyle(Paint.Style.FILL);
                int i4 = this.l;
                RectF rectF2 = new RectF(i4 + f + this.i, fontMetricsInt.ascent + f2 + i4, ((f + this.a) - this.h) - i4, ((f2 + fontMetricsInt.descent) - this.k) - i4);
                float f4 = this.j;
                canvas.drawRoundRect(rectF2, f4, f4, paint);
            }
        }
    }

    public final void b(Canvas canvas, CharSequence charSequence, int i, int i2, float f, float f2, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), paint}) == null) {
            paint.setColor(this.d);
            paint.setStyle(Paint.Style.FILL);
            paint.setTextSize(ej.g(TbadkApplication.getInst(), this.c));
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float centerY = this.b.centerY();
            float f3 = fontMetrics.descent;
            float f4 = (centerY + ((f3 - fontMetrics.ascent) / 2.0f)) - f3;
            float f5 = f + this.e;
            if (this.o) {
                paint.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                paint.setTypeface(Typeface.defaultFromStyle(0));
            }
            canvas.drawText(charSequence.subSequence(i, i2).toString(), f5, f4, paint);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
            float f2 = i4;
            a(canvas, charSequence, i, i2, f, f2, paint);
            b(canvas, charSequence, i, i2, f, f2, paint);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) {
            float textSize = paint.getTextSize();
            paint.setTextSize(ej.g(TbadkApplication.getInst(), this.c));
            this.a = ((int) paint.measureText(charSequence, i, i2)) + this.e + this.f + this.h + this.i;
            paint.setTextSize(textSize);
            return this.a;
        }
        return invokeCommon.intValue;
    }
}
