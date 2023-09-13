package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.GeneratedTexture;
/* loaded from: classes5.dex */
public class e3 {
    public static /* synthetic */ Interceptable $ic;
    public static final e3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public float c;
    public float d;

    public static int b(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? (((int) (f * 255.0f)) << 24) | (((int) (f2 * 255.0f)) << 16) | (((int) (f3 * 255.0f)) << 8) | ((int) (f4 * 255.0f)) : invokeCommon.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448301823, "Lcom/baidu/tieba/e3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448301823, "Lcom/baidu/tieba/e3;");
                return;
            }
        }
        e = new e3(1.0f, 1.0f, 1.0f, 1.0f);
        new e3(-1077952513);
        new e3(2139062271);
        new e3(1061109759);
        new e3(0.0f, 0.0f, 0.0f, 1.0f);
        e.f();
        new e3(0.0f, 0.0f, 0.0f, 0.0f);
        new e3(0.0f, 0.0f, 1.0f, 1.0f);
        new e3(0.0f, 0.0f, 0.5f, 1.0f);
        new e3(1097458175);
        new e3(1887473919);
        new e3(-2016482305);
        new e3(0.0f, 1.0f, 1.0f, 1.0f);
        new e3(0.0f, 0.5f, 0.5f, 1.0f);
        new e3((int) GeneratedTexture.MAGENTA);
        new e3(2147418367);
        new e3(852308735);
        new e3(579543807);
        new e3(1804477439);
        new e3(-65281);
        new e3(-2686721);
        new e3(-626712321);
        new e3(-5963521);
        new e3(-1958407169);
        new e3(-759919361);
        new e3(-1306385665);
        new e3((int) BaseAnimatedElement.DEBUG_PAINT_COLOR);
        new e3(-13361921);
        new e3(-8433409);
        new e3(-92245249);
        new e3(-9849601);
        new e3(1.0f, 0.0f, 1.0f, 1.0f);
        new e3(-1608453889);
        new e3(-293409025);
        new e3(-1339006721);
    }

    public e3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (((int) (this.d * 255.0f)) << 24) | (((int) (this.c * 255.0f)) << 16) | (((int) (this.b * 255.0f)) << 8) | ((int) (this.a * 255.0f));
        }
        return invokeV.intValue;
    }

    public e3(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        a();
    }

    public e3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        c(this, i);
    }

    public e3(e3 e3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e3Var};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        e(e3Var);
    }

    public static e3 h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            e3 e3Var = new e3();
            i(str, e3Var);
            return e3Var;
        }
        return (e3) invokeL.objValue;
    }

    public e3 e(e3 e3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e3Var)) == null) {
            this.a = e3Var.a;
            this.b = e3Var.b;
            this.c = e3Var.c;
            this.d = e3Var.d;
            return this;
        }
        return (e3) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && e3.class == obj.getClass() && g() == ((e3) obj).g()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void c(e3 e3Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, e3Var, i) == null) {
            e3Var.a = (((-16777216) & i) >>> 24) / 255.0f;
            e3Var.b = ((16711680 & i) >>> 16) / 255.0f;
            e3Var.c = ((65280 & i) >>> 8) / 255.0f;
            e3Var.d = (i & 255) / 255.0f;
        }
    }

    public static e3 i(String str, e3 e3Var) {
        InterceptResult invokeLL;
        float parseInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, e3Var)) == null) {
            if (str.charAt(0) == '#') {
                str = str.substring(1);
            }
            e3Var.a = Integer.parseInt(str.substring(0, 2), 16) / 255.0f;
            e3Var.b = Integer.parseInt(str.substring(2, 4), 16) / 255.0f;
            e3Var.c = Integer.parseInt(str.substring(4, 6), 16) / 255.0f;
            if (str.length() != 8) {
                parseInt = 1.0f;
            } else {
                parseInt = Integer.parseInt(str.substring(6, 8), 16) / 255.0f;
            }
            e3Var.d = parseInt;
            return e3Var;
        }
        return (e3) invokeLL.objValue;
    }

    public e3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float f = this.a;
            if (f < 0.0f) {
                this.a = 0.0f;
            } else if (f > 1.0f) {
                this.a = 1.0f;
            }
            float f2 = this.b;
            if (f2 < 0.0f) {
                this.b = 0.0f;
            } else if (f2 > 1.0f) {
                this.b = 1.0f;
            }
            float f3 = this.c;
            if (f3 < 0.0f) {
                this.c = 0.0f;
            } else if (f3 > 1.0f) {
                this.c = 1.0f;
            }
            float f4 = this.d;
            if (f4 < 0.0f) {
                this.d = 0.0f;
            } else if (f4 > 1.0f) {
                this.d = 1.0f;
            }
            return this;
        }
        return (e3) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float f = this.a;
            int i4 = 0;
            if (f != 0.0f) {
                i = n7.a(f);
            } else {
                i = 0;
            }
            int i5 = i * 31;
            float f2 = this.b;
            if (f2 != 0.0f) {
                i2 = n7.a(f2);
            } else {
                i2 = 0;
            }
            int i6 = (i5 + i2) * 31;
            float f3 = this.c;
            if (f3 != 0.0f) {
                i3 = n7.a(f3);
            } else {
                i3 = 0;
            }
            int i7 = (i6 + i3) * 31;
            float f4 = this.d;
            if (f4 != 0.0f) {
                i4 = n7.a(f4);
            }
            return i7 + i4;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String hexString = Integer.toHexString((((int) (this.a * 255.0f)) << 24) | (((int) (this.b * 255.0f)) << 16) | (((int) (this.c * 255.0f)) << 8) | ((int) (this.d * 255.0f)));
            while (hexString.length() < 8) {
                hexString = "0" + hexString;
            }
            return hexString;
        }
        return (String) invokeV.objValue;
    }

    public e3 d(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
            a();
            return this;
        }
        return (e3) invokeCommon.objValue;
    }

    public float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return n7.c((((int) (this.d * 255.0f)) << 24) | (((int) (this.c * 255.0f)) << 16) | (((int) (this.b * 255.0f)) << 8) | ((int) (this.a * 255.0f)));
        }
        return invokeV.floatValue;
    }
}
