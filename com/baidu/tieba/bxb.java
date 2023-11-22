package com.baidu.tieba;

import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.FunAdSdk;
import java.io.ObjectInput;
/* loaded from: classes5.dex */
public class bxb {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public static final SharedPreferences b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947661757, "Lcom/baidu/tieba/bxb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947661757, "Lcom/baidu/tieba/bxb;");
                return;
            }
        }
        a = new Object();
        b = FunAdSdk.getAppContext().getSharedPreferences("fun_ad_sdk", 0);
    }

    public static lwb b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? (lwb) pwb.b(b.getString("key_adcfg", null), new gxb() { // from class: com.baidu.tieba.svb
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.gxb
            public final Object a(ObjectInput objectInput) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, objectInput)) == null) ? bxb.c(objectInput) : invokeL.objValue;
            }
        }) : (lwb) invokeV.objValue;
    }

    public static /* synthetic */ lwb c(ObjectInput objectInput) {
        return new lwb(objectInput.readInt(), objectInput);
    }

    public static void d(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Double.valueOf(d)}) == null) {
            b.edit().putLong("key_price_total", Double.doubleToRawLongBits(d)).apply();
        }
    }

    public static void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, null, i) == null) {
            g("key_rpt_fai_c", h() + i);
        }
    }

    public static void f(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65542, null, i, i2, i3) == null) {
            synchronized (a) {
                int k = k();
                int l = l();
                int j = j();
                b.edit().putInt("key_rpt_req_c", ((k - i) - i2) - i3).putInt("key_rpt_fai_c", h() - i).putInt("key_rpt_suc_c", l - i2).putInt("key_rpt_mis_c", j - i3).apply();
            }
        }
    }

    public static void g(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, str, i) == null) {
            b.edit().putInt(str, i).apply();
        }
    }

    public static /* synthetic */ uwb i(ObjectInput objectInput) {
        return new uwb(objectInput.readInt(), objectInput);
    }

    public static uwb m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? (uwb) pwb.b(b.getString("key_rptcfg", null), new gxb() { // from class: com.baidu.tieba.wvb
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.gxb
            public final Object a(ObjectInput objectInput) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, objectInput)) == null) ? bxb.i(objectInput) : invokeL.objValue;
            }
        }) : (uwb) invokeV.objValue;
    }

    public static double n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? Double.longBitsToDouble(b.getLong("key_price_total", 0L)) : invokeV.doubleValue;
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            synchronized (a) {
                g("key_rpt_req_c", k() + 1);
            }
        }
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return b.getInt("key_sid_c_pre_" + str, 0);
        }
        return invokeL.intValue;
    }

    public static int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return b.getInt("key_rpt_fai_c", 0);
        }
        return invokeV.intValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return b.getInt("key_rpt_mis_c", 0);
        }
        return invokeV.intValue;
    }

    public static int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return b.getInt("key_rpt_req_c", 0);
        }
        return invokeV.intValue;
    }

    public static int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return b.getInt("key_rpt_suc_c", 0);
        }
        return invokeV.intValue;
    }
}
