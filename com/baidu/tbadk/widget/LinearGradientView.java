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
import c.a.p0.b2.o.k.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ThemeElement;
/* loaded from: classes5.dex */
public class LinearGradientView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f30684b;

    /* renamed from: c  reason: collision with root package name */
    public int f30685c;

    /* renamed from: d  reason: collision with root package name */
    public int f30686d;

    /* renamed from: e  reason: collision with root package name */
    public int f30687e;

    /* renamed from: f  reason: collision with root package name */
    public int f30688f;

    /* renamed from: g  reason: collision with root package name */
    public int f30689g;

    /* renamed from: h  reason: collision with root package name */
    public LinearGradient f30690h;
    public final Paint i;
    public Path j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinearGradientView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.i = new Paint();
        this.k = 0;
        this.o = 0;
        d();
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (this.a != i) {
                this.f30690h = c();
                invalidate();
            }
            this.a = i;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if ((getWidth() == this.l && getHeight() == this.m && this.n == this.k) || this.o == 0) {
                return;
            }
            this.l = getWidth();
            this.m = getHeight();
            this.n = this.k;
            this.j.reset();
            int i = this.o;
            if (i == 1) {
                Path path = this.j;
                RectF rectF = new RectF(0.0f, 0.0f, this.l, this.m);
                int i2 = this.k;
                path.addRoundRect(rectF, i2, i2, Path.Direction.CW);
            } else if (i == 2) {
                Path path2 = this.j;
                RectF rectF2 = new RectF(0.0f, 0.0f, this.l, this.m);
                int i3 = this.k;
                path2.addRoundRect(rectF2, new float[]{i3, i3, 0.0f, 0.0f, 0.0f, 0.0f, i3, i3}, Path.Direction.CW);
            } else if (i == 3) {
                Path path3 = this.j;
                RectF rectF3 = new RectF(0.0f, 0.0f, this.l, this.m);
                int i4 = this.k;
                path3.addRoundRect(rectF3, new float[]{i4, i4, i4, i4, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
            } else if (i == 4) {
                Path path4 = this.j;
                RectF rectF4 = new RectF(0.0f, 0.0f, this.l, this.m);
                int i5 = this.k;
                path4.addRoundRect(rectF4, new float[]{0.0f, 0.0f, i5, i5, i5, i5, 0.0f, 0.0f}, Path.Direction.CW);
            } else if (i != 5) {
            } else {
                Path path5 = this.j;
                RectF rectF5 = new RectF(0.0f, 0.0f, this.l, this.m);
                int i6 = this.k;
                path5.addRoundRect(rectF5, new float[]{0.0f, 0.0f, 0.0f, 0.0f, i6, i6, i6, i6}, Path.Direction.CW);
            }
        }
    }

    public final LinearGradient c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            int i = this.f30684b;
            int i2 = this.f30685c;
            if (skinType == 4) {
                i = this.f30688f;
                i2 = this.f30689g;
            } else if (skinType == 1) {
                i = this.f30686d;
                i2 = this.f30687e;
            }
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
            this.f30690h = linearGradient;
            this.i.setShader(linearGradient);
            this.a = skinType;
            return this.f30690h;
        }
        return (LinearGradient) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j = new Path();
            e();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f30684b = b.b("#2BB8FF");
            this.f30685c = b.b("#2BB8FF");
            this.f30686d = b.b("#249BD6");
            this.f30687e = b.b("#246CD6");
            this.f30688f = b.b("#249BD6");
            this.f30689g = b.b("#246CD6");
            this.f30690h = c();
        }
    }

    public ArrayList<Integer> getGradientColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(Integer.valueOf(this.f30684b));
            arrayList.add(Integer.valueOf(this.f30685c));
            arrayList.add(Integer.valueOf(this.f30686d));
            arrayList.add(Integer.valueOf(this.f30687e));
            arrayList.add(Integer.valueOf(this.f30688f));
            arrayList.add(Integer.valueOf(this.f30689g));
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
            if (this.o == 0) {
                canvas.drawRect(0.0f, 0.0f, width, height, this.i);
            } else {
                canvas.drawPath(this.j, this.i);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (i <= 0 || i2 <= 0) {
                return;
            }
            this.f30690h = c();
        }
    }

    public void setCornerRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.k = i;
        }
    }

    public void setDefaultGradientColor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            e();
            invalidate();
        }
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            this.f30684b = i;
            this.f30685c = i2;
            this.f30686d = i3;
            this.f30687e = i4;
            this.f30688f = i5;
            this.f30689g = i6;
            this.f30690h = c();
            invalidate();
        }
    }

    public void setRoundMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.o = i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.i = new Paint();
        this.k = 0;
        this.o = 0;
        d();
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                if (this.f30684b == b.b(str) && this.f30685c == b.b(str2) && this.f30686d == b.b(str3) && this.f30687e == b.b(str4) && this.f30688f == b.b(str5) && this.f30689g == b.b(str6)) {
                    return;
                }
                this.f30684b = b.b(str);
                this.f30685c = b.b(str2);
                this.f30686d = b.b(str3);
                this.f30687e = b.b(str4);
                this.f30688f = b.b(str5);
                this.f30689g = b.b(str6);
                this.f30690h = c();
                invalidate();
                return;
            }
            setDefaultGradientColor();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinearGradientView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 3;
        this.i = new Paint();
        this.k = 0;
        this.o = 0;
        d();
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int b2;
        int b3;
        int b4;
        int i;
        int b5;
        int i2;
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
                i = b.b("#249BD6");
                b4 = b.b("#246CD6");
            } else {
                int b6 = b.b(themeElement2.common_color);
                b4 = b.b(themeElement2.common_color);
                i = b6;
            }
            if (themeElement3 == null) {
                i2 = b.b("#249BD6");
                b5 = b.b("#246CD6");
            } else {
                int b7 = b.b(themeElement3.common_color);
                b5 = b.b(themeElement3.common_color);
                i2 = b7;
            }
            this.f30684b = b2;
            this.f30685c = b3;
            this.f30686d = i;
            this.f30687e = b4;
            this.f30688f = i2;
            this.f30689g = b5;
            this.f30690h = c();
            invalidate();
        }
    }
}
