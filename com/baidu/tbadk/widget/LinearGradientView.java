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
import com.baidu.tieba.ne8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ThemeElement;
/* loaded from: classes3.dex */
public class LinearGradientView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public LinearGradient h;
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

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (this.a != i) {
                this.h = c();
                invalidate();
            }
            this.a = i;
        }
    }

    public void setCornerRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.k = i;
        }
    }

    public void setRoundMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.o = i;
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
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                Path path = this.j;
                                RectF rectF = new RectF(0.0f, 0.0f, this.l, this.m);
                                int i2 = this.k;
                                path.addRoundRect(rectF, new float[]{0.0f, 0.0f, 0.0f, 0.0f, i2, i2, i2, i2}, Path.Direction.CW);
                                return;
                            }
                            return;
                        }
                        Path path2 = this.j;
                        RectF rectF2 = new RectF(0.0f, 0.0f, this.l, this.m);
                        int i3 = this.k;
                        path2.addRoundRect(rectF2, new float[]{0.0f, 0.0f, i3, i3, i3, i3, 0.0f, 0.0f}, Path.Direction.CW);
                        return;
                    }
                    Path path3 = this.j;
                    RectF rectF3 = new RectF(0.0f, 0.0f, this.l, this.m);
                    int i4 = this.k;
                    path3.addRoundRect(rectF3, new float[]{i4, i4, i4, i4, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
                    return;
                }
                Path path4 = this.j;
                RectF rectF4 = new RectF(0.0f, 0.0f, this.l, this.m);
                int i5 = this.k;
                path4.addRoundRect(rectF4, new float[]{i5, i5, 0.0f, 0.0f, 0.0f, 0.0f, i5, i5}, Path.Direction.CW);
                return;
            }
            Path path5 = this.j;
            RectF rectF5 = new RectF(0.0f, 0.0f, this.l, this.m);
            int i6 = this.k;
            path5.addRoundRect(rectF5, i6, i6, Path.Direction.CW);
        }
    }

    public final LinearGradient c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            int i = this.b;
            int i2 = this.c;
            if (skinType == 4) {
                i = this.f;
                i2 = this.g;
            }
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getHeight(), getHeight(), new int[]{i, i2}, (float[]) null, Shader.TileMode.CLAMP);
            this.h = linearGradient;
            this.i.setShader(linearGradient);
            this.a = skinType;
            return this.h;
        }
        return (LinearGradient) invokeV.objValue;
    }

    public ArrayList<Integer> getGradientColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(Integer.valueOf(this.b));
            arrayList.add(Integer.valueOf(this.c));
            arrayList.add(Integer.valueOf(this.d));
            arrayList.add(Integer.valueOf(this.e));
            arrayList.add(Integer.valueOf(this.f));
            arrayList.add(Integer.valueOf(this.g));
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j = new Path();
            e();
        }
    }

    public void setDefaultGradientColor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            e();
            invalidate();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b = ne8.b("#2BB8FF");
            this.c = ne8.b("#2BB8FF");
            this.d = ne8.b("#249BD6");
            this.e = ne8.b("#246CD6");
            this.f = ne8.b("#249BD6");
            this.g = ne8.b("#246CD6");
            this.h = c();
        }
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
            if (i > 0 && i2 > 0) {
                this.h = c();
            }
        }
    }

    public void setGradientColor(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            this.h = c();
            invalidate();
        }
    }

    public void setGradientColor(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                if (this.b == ne8.b(str) && this.c == ne8.b(str2) && this.d == ne8.b(str3) && this.e == ne8.b(str4) && this.f == ne8.b(str5) && this.g == ne8.b(str6)) {
                    return;
                }
                this.b = ne8.b(str);
                this.c = ne8.b(str2);
                this.d = ne8.b(str3);
                this.e = ne8.b(str4);
                this.f = ne8.b(str5);
                this.g = ne8.b(str6);
                this.h = c();
                invalidate();
                return;
            }
            setDefaultGradientColor();
        }
    }

    public void setGradientColor(ThemeElement themeElement, ThemeElement themeElement2, ThemeElement themeElement3) {
        int b;
        int b2;
        int b3;
        int i;
        int b4;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, themeElement, themeElement2, themeElement3) == null) {
            if (themeElement == null) {
                b = ne8.b("#2BB8FF");
                b2 = ne8.b("#2BB8FF");
            } else {
                b = ne8.b(themeElement.common_color);
                b2 = ne8.b(themeElement.common_color);
            }
            if (themeElement2 == null) {
                i = ne8.b("#249BD6");
                b3 = ne8.b("#246CD6");
            } else {
                int b5 = ne8.b(themeElement2.common_color);
                b3 = ne8.b(themeElement2.common_color);
                i = b5;
            }
            if (themeElement3 == null) {
                i2 = ne8.b("#249BD6");
                b4 = ne8.b("#246CD6");
            } else {
                int b6 = ne8.b(themeElement3.common_color);
                b4 = ne8.b(themeElement3.common_color);
                i2 = b6;
            }
            this.b = b;
            this.c = b2;
            this.d = i;
            this.e = b3;
            this.f = i2;
            this.g = b4;
            this.h = c();
            invalidate();
        }
    }
}
