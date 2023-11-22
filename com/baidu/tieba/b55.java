package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.style.ReplacementSpan;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class b55 extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public float[] b;
    public int c;
    public RectF d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public Paint j;
    public String k;
    public int l;
    public int m;
    public boolean n;
    public int o;
    public boolean p;
    public int q;
    public a r;
    public a s;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (SkinManager.getCurrentSkinType() == 0) {
                    return this.a;
                }
                return this.b;
            }
            return invokeV.intValue;
        }
    }

    public b55(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new float[8];
        this.d = new RectF();
        this.o = 255;
        this.p = false;
        this.q = 0;
        this.r = null;
        this.s = null;
        this.a = i;
        if (i2 > 0) {
            c(i2);
        }
        this.c = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.i = i7;
        Paint paint = new Paint();
        this.j = paint;
        paint.setAntiAlias(true);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setTextSize(this.e);
    }

    public b55(int i, int i2, @NonNull a aVar, int i3, @NonNull a aVar2, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), aVar, Integer.valueOf(i3), aVar2, Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new float[8];
        this.d = new RectF();
        this.o = 255;
        this.p = false;
        this.q = 0;
        this.r = null;
        this.s = null;
        this.a = i;
        if (i2 > 0) {
            c(i2);
        }
        this.s = aVar;
        this.r = aVar2;
        this.e = i3;
        this.g = i4;
        this.i = i5;
        Paint paint = new Paint();
        this.j = paint;
        paint.setAntiAlias(true);
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setTextSize(this.e);
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
            this.o = (int) (f * 255.0f);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            Arrays.fill(this.b, i);
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            float[] B = r25.B(i);
            if (!Arrays.equals(this.b, B)) {
                this.b = B;
            }
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.q = i;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.k = str;
        }
    }

    public void f(boolean z) {
        Paint paint;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048582, this, z) != null) || (paint = this.j) == null) {
            return;
        }
        this.n = z;
        if (z) {
            paint.setStyle(Paint.Style.FILL);
        } else {
            paint.setStyle(Paint.Style.STROKE);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.p = z;
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.l = i;
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.m = i;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        int i6;
        int color;
        int color2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
            a aVar = this.s;
            if (aVar != null) {
                this.j.setColor(aVar.a());
            } else {
                int i7 = this.c;
                if (i7 != 0) {
                    this.j.setColor(SkinManager.getColor(i7));
                } else {
                    this.j.setColor(SelectorHelper.getResources().getColor(R.color.CAM_X0201));
                }
            }
            this.j.setAlpha(this.o);
            if (this.n) {
                this.j.setStyle(Paint.Style.FILL);
            } else {
                this.j.setStyle(Paint.Style.STROKE);
                this.j.setStrokeWidth(this.a);
            }
            if (this.p) {
                RectF rectF = this.d;
                int i8 = this.l;
                rectF.left = f + i8;
                int i9 = this.q;
                rectF.top = (i4 - this.i) + i9;
                rectF.right = f + this.h + i8;
                rectF.bottom = i4 + i9;
            } else {
                Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                if (u25.b(charSequence)) {
                    u25.a(fontMetricsInt, (int) paint.getTextSize());
                    i6 = 0 - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
                } else {
                    i6 = (((fontMetricsInt.descent - fontMetricsInt.ascent) - this.i) / 2) + 0;
                }
                int i10 = i6 + i4 + fontMetricsInt.ascent;
                RectF rectF2 = this.d;
                rectF2.left = f + this.l;
                rectF2.top = Math.max(i10, i4 + fontMetricsInt.top);
                RectF rectF3 = this.d;
                rectF3.right = f + this.h + this.l;
                rectF3.bottom = Math.min(i10 + this.i, i4 + fontMetricsInt.bottom);
            }
            String str = this.k;
            if (str != null) {
                if (" 吧主".equals(str)) {
                    color = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                    color2 = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                } else if (" 小吧主".equals(this.k)) {
                    color = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                    color2 = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                } else if (" 楼主".equals(this.k)) {
                    color = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                    color2 = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                } else {
                    color = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                    color2 = SelectorHelper.getResources().getColor(R.color.CAM_X0302);
                }
                int i11 = color;
                int i12 = color2;
                RectF rectF4 = this.d;
                this.j.setShader(new LinearGradient(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom, i11, i12, Shader.TileMode.CLAMP));
            }
            Path path = new Path();
            path.addRoundRect(this.d, this.b, Path.Direction.CW);
            canvas.drawPath(path, this.j);
            this.j.setShader(null);
            if (TbadkCoreApplication.getInst().getSkinType() == 4 && this.k != null) {
                this.j.setColor(SelectorHelper.getResources().getColor(R.color.obfuscated_res_0x7f0607d1));
                if (this.n) {
                    this.j.setStyle(Paint.Style.FILL);
                } else {
                    this.j.setStyle(Paint.Style.STROKE);
                }
                Path path2 = new Path();
                path2.addRoundRect(this.d, this.b, Path.Direction.CW);
                canvas.drawPath(path2, this.j);
            }
            Paint.FontMetricsInt fontMetricsInt2 = this.j.getFontMetricsInt();
            a aVar2 = this.r;
            if (aVar2 != null) {
                this.j.setColor(aVar2.a());
            } else {
                int i13 = this.f;
                if (i13 != 0) {
                    this.j.setColor(SkinManager.getColor(i13));
                } else {
                    this.j.setColor(SelectorHelper.getResources().getColor(R.color.CAM_X0201));
                }
            }
            this.j.setStyle(Paint.Style.FILL);
            float centerY = this.d.centerY();
            int i14 = fontMetricsInt2.bottom;
            canvas.drawText(charSequence, i, i2, f + this.g + this.l, (int) ((centerY + ((i14 - fontMetricsInt2.top) / 2)) - i14), this.j);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) {
            int measureText = ((int) this.j.measureText(charSequence, i, i2)) + (this.g * 2);
            this.h = measureText;
            return measureText + this.l + this.m;
        }
        return invokeCommon.intValue;
    }
}
