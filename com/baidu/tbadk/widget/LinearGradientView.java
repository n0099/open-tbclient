package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.n1.o.k.b;
import java.util.ArrayList;
import tbclient.ThemeElement;
/* loaded from: classes3.dex */
public class LinearGradientView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f13284e;

    /* renamed from: f  reason: collision with root package name */
    public int f13285f;

    /* renamed from: g  reason: collision with root package name */
    public int f13286g;

    /* renamed from: h  reason: collision with root package name */
    public int f13287h;

    /* renamed from: i  reason: collision with root package name */
    public int f13288i;
    public int j;
    public int k;
    public LinearGradient l;
    public final Paint m;
    public Path n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinearGradientView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13284e = 3;
        this.m = new Paint();
        this.o = 0;
        this.s = 0;
        d();
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (this.f13284e != i2) {
                this.l = c();
                invalidate();
            }
            this.f13284e = i2;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if ((getWidth() == this.p && getHeight() == this.q && this.r == this.o) || this.s == 0) {
                return;
            }
            this.p = getWidth();
            this.q = getHeight();
            this.r = this.o;
            this.n.reset();
            int i2 = this.s;
            if (i2 == 1) {
                Path path = this.n;
                RectF rectF = new RectF(0.0f, 0.0f, this.p, this.q);
                int i3 = this.o;
                path.addRoundRect(rectF, i3, i3, Path.Direction.CW);
            } else if (i2 == 2) {
                Path path2 = this.n;
                RectF rectF2 = new RectF(0.0f, 0.0f, this.p, this.q);
                int i4 = this.o;
                path2.addRoundRect(rectF2, new float[]{i4, i4, 0.0f, 0.0f, 0.0f, 0.0f, i4, i4}, Path.Direction.CW);
            } else if (i2 == 3) {
                Path path3 = this.n;
                RectF rectF3 = new RectF(0.0f, 0.0f, this.p, this.q);
                int i5 = this.o;
                path3.addRoundRect(rectF3, new float[]{i5, i5, i5, i5, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
            } else if (i2 == 4) {
                Path path4 = this.n;
                RectF rectF4 = new RectF(0.0f, 0.0f, this.p, this.q);
                int i6 = this.o;
                path4.addRoundRect(rectF4, new float[]{0.0f, 0.0f, i6, i6, i6, i6, 0.0f, 0.0f}, Path.Direction.CW);
            } else if (i2 != 5) {
            } else {
                Path path5 = this.n;
                RectF rectF5 = new RectF(0.0f, 0.0f, this.p, this.q);
                int i7 = this.o;
                path5.addRoundRect(rectF5, new float[]{0.0f, 0.0f, 0.0f, 0.0f, i7, i7, i7, i7}, Path.Direction.CW);
            }
        }
    }

    public final LinearGradient c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            int i2 = this.f13285f;
            int i3 = this.f13286g;
            if (skinType == 4) {
                i2 = this.j;
                i3 = this.k;
            } else if (skinType == 1) {
                i2 = this.f13287h;
                i3 = this.f13288i;
            }
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i2, i3}, (float[]) null, Shader.TileMode.CLAMP);
            this.l = linearGradient;
            this.m.setShader(linearGradient);
            this.f13284e = skinType;
            return this.l;
        }
        return (LinearGradient) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.n = new Path();
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f13285f = b.b("#2BB8FF");
            this.f13286g = b.b("#2BB8FF");
            this.f13287h = b.b("#249BD6");
            this.f13288i = b.b("#246CD6");
            this.j = b.b("#249BD6");
            this.k = b.b("#246CD6");
            this.l = c();
        }
    }

    public ArrayList<Integer> getGradientColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(Integer.valueOf(this.f13285f));
            arrayList.add(Integer.valueOf(this.f13286g));
            arrayList.add(Integer.valueOf(this.f13287h));
            arrayList.add(Integer.valueOf(this.f13288i));
            arrayList.add(Integer.valueOf(this.j));
            arrayList.add(Integer.valueOf(this.k));
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            super.onDraw(canvas);
            int width = getWidth();
            int height = getHeight();
            b();
            if (this.s == 0) {
                canvas.drawRect(0.0f, 0.0f, width, height, this.m);
            } else {
                canvas.drawPath(this.n, this.m);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (i2 <= 0 || i3 <= 0) {
                return;
            }
            this.l = c();
        }
    }

    public void setCornerRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.o = i2;
        }
    }

    public void setDefaultGradientColor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            e();
            invalidate();
        }
    }

    public void setGradientColor(int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            this.f13285f = i2;
            this.f13286g = i3;
            this.f13287h = i4;
            this.f13288i = i5;
            this.j = i6;
            this.k = i7;
            this.l = c();
            invalidate();
        }
    }

    public void setRoundMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.s = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinearGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13284e = 3;
        this.m = new Paint();
        this.o = 0;
        this.s = 0;
        d();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                if (this.f13285f == b.b(str) && this.f13286g == b.b(str2) && this.f13287h == b.b(str3) && this.f13288i == b.b(str4) && this.j == b.b(str5) && this.k == b.b(str6)) {
                    return;
                }
                this.f13285f = b.b(str);
                this.f13286g = b.b(str2);
                this.f13287h = b.b(str3);
                this.f13288i = b.b(str4);
                this.j = b.b(str5);
                this.k = b.b(str6);
                this.l = c();
                invalidate();
                return;
            }
            setDefaultGradientColor();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinearGradientView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f13284e = 3;
        this.m = new Paint();
        this.o = 0;
        this.s = 0;
        d();
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int b2;
        int b3;
        int b4;
        int i2;
        int b5;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, themeElement, themeElement2, themeElement3) == null) {
            if (themeElement == null) {
                b2 = b.b("#2BB8FF");
                b3 = b.b("#2BB8FF");
            } else {
                b2 = b.b(themeElement.common_color);
                b3 = b.b(themeElement.common_color);
            }
            if (themeElement2 == null) {
                i2 = b.b("#249BD6");
                b4 = b.b("#246CD6");
            } else {
                int b6 = b.b(themeElement2.common_color);
                b4 = b.b(themeElement2.common_color);
                i2 = b6;
            }
            if (themeElement3 == null) {
                i3 = b.b("#249BD6");
                b5 = b.b("#246CD6");
            } else {
                int b7 = b.b(themeElement3.common_color);
                b5 = b.b(themeElement3.common_color);
                i3 = b7;
            }
            this.f13285f = b2;
            this.f13286g = b3;
            this.f13287h = i2;
            this.f13288i = b4;
            this.j = i3;
            this.k = b5;
            this.l = c();
            invalidate();
        }
    }
}
