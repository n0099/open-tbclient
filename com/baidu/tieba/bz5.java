package com.baidu.tieba;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
/* loaded from: classes5.dex */
public class bz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Paint a;
    public final Paint b;
    public final Paint c;
    public final View d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public float l;
    public final Paint m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public float[] u;
    public int v;

    public bz5(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Paint();
        this.b = new Paint();
        this.c = new Paint();
        this.e = 16;
        this.f = 16;
        this.g = -1;
        this.h = DebugControllerOverlayDrawable.TEXT_BACKGROUND_COLOR;
        this.i = 20;
        this.j = 20;
        this.k = 36;
        this.l = 0.0f;
        this.m = new Paint();
        this.n = 3;
        this.o = R.color.CAM_X0101;
        this.p = R.color.CAM_X0305;
        this.q = 20;
        this.r = 20;
        this.s = 36;
        this.t = 0;
        this.v = 0;
        this.d = view2;
        int color = getContext().getResources().getColor(R.color.black_alpha40);
        this.h = color;
        this.b.setColor(color);
        this.b.setAntiAlias(true);
        this.i = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        int color2 = getContext().getResources().getColor(R.color.CAM_X0101);
        this.g = color2;
        this.a.setColor(color2);
        this.a.setTextSize(this.i);
        this.a.setAntiAlias(true);
        this.a.setTypeface(q75.K(q75.H(R.string.F_X02)));
        this.e = xi.g(getContext(), R.dimen.tbds16);
        this.f = xi.g(getContext(), R.dimen.tbds16);
        this.j = xi.g(getContext(), R.dimen.tbds22);
        this.k = xi.g(getContext(), R.dimen.tbds40);
        this.l = q75.B(R.string.J_X01)[0];
        int dimension = (int) getContext().getResources().getDimension(R.dimen.tbfontsize26);
        this.q = dimension;
        this.c.setTextSize(dimension);
        this.a.setAntiAlias(true);
        this.m.setAntiAlias(true);
        this.r = xi.g(getContext(), R.dimen.tbds16);
        this.s = xi.g(getContext(), R.dimen.tbds22);
        this.t = xi.g(getContext(), R.dimen.tbds5);
        this.v = xi.g(getContext(), R.dimen.M_W_X006);
        xi.g(getContext(), R.dimen.M_H_X004);
        i(TbadkCoreApplication.getInst().getSkinType());
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            View view2 = this.d;
            if (view2 != null && view2.getContext() != null) {
                return this.d.getContext();
            }
            return TbadkCoreApplication.getInst().getContext();
        }
        return (Context) invokeV.objValue;
    }

    public final void e() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (view2 = this.d) != null) {
            view2.invalidate();
        }
    }

    public void a(Canvas canvas, String str, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048576, this, canvas, str, z) == null) && canvas != null && this.d != null && !TextUtils.isEmpty(str)) {
            int save = canvas.save();
            this.d.getPaddingLeft();
            int paddingRight = this.d.getPaddingRight();
            this.d.getPaddingTop();
            int paddingBottom = this.d.getPaddingBottom();
            int left = this.d.getLeft();
            int right = this.d.getRight();
            int top = this.d.getTop();
            int bottom = this.d.getBottom();
            float measureText = this.a.measureText(str);
            Paint.FontMetrics fontMetrics = this.a.getFontMetrics();
            if (z) {
                if (this.u == null) {
                    this.u = q75.E(R.array.S_O_X001);
                }
                float[] fArr = this.u;
                if (fArr != null && fArr.length >= 4) {
                    i = save;
                    this.a.setShadowLayer(fArr[1], fArr[2], fArr[3], (int) fArr[0]);
                } else {
                    i = save;
                }
                int i2 = this.v;
                canvas.drawText(str, (((right - left) - paddingRight) - i2) - measureText, (((bottom - top) - paddingBottom) - i2) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.a);
            } else {
                i = save;
                float f = this.k + measureText;
                float f2 = this.i + this.j;
                canvas.translate((((right - left) - paddingRight) - f) - this.f, (((bottom - top) - paddingBottom) - f2) - this.e);
                RectF rectF = new RectF(0.0f, 0.0f, f, f2);
                float f3 = this.l;
                if (f3 < 1.0f) {
                    this.l = f3 * f2;
                }
                float f4 = this.l;
                canvas.drawRoundRect(rectF, f4, f4, this.b);
                this.a.clearShadowLayer();
                canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.a);
            }
            int i3 = i;
            if (i3 >= 1 && i3 <= canvas.getSaveCount()) {
                canvas.restoreToCount(i3);
            }
        }
    }

    public void b(Canvas canvas, String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, str, i) == null) && canvas != null && this.d != null && !TextUtils.isEmpty(str)) {
            if (i != 0) {
                this.p = i;
                this.m.setColor(SkinManager.getColor(i));
            }
            int save = canvas.save();
            int paddingLeft = this.d.getPaddingLeft();
            this.d.getPaddingRight();
            int paddingTop = this.d.getPaddingTop();
            this.d.getPaddingBottom();
            float measureText = this.c.measureText(str);
            canvas.translate(paddingLeft, paddingTop);
            RectF rectF = new RectF(0.0f, 0.0f, this.s + measureText, this.q + this.r);
            int i2 = this.t;
            canvas.drawRoundRect(rectF, i2, i2, this.m);
            Paint.FontMetrics fontMetrics = this.c.getFontMetrics();
            canvas.drawText(str, (rectF.width() - measureText) / 2.0f, (rectF.height() / 2.0f) + ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.c);
            if (save >= 1 && save <= canvas.getSaveCount()) {
                canvas.restoreToCount(save);
            }
        }
    }

    public float c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return xi.G(this.a, str).height() + this.j;
        }
        return invokeL.floatValue;
    }

    public float d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return xi.H(this.a, str) + this.k;
        }
        return invokeL.floatValue;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.g = i;
            this.a.setColor(i);
            e();
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.i = i;
            this.a.setTextSize(i);
            e();
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || this.n == i) {
            return;
        }
        this.n = i;
        this.c.setColor(SkinManager.getColor(i, this.o));
        this.m.setColor(SkinManager.getColor(i, this.p));
    }

    public void f(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            this.f = i;
            this.e = i2;
            e();
        }
    }
}
