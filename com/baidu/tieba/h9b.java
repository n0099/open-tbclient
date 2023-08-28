package com.baidu.tieba;

import android.content.Context;
import android.os.IBinder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h9b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        w9b c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65536, null) == null) && (c = cab.c()) != null) {
            c.b();
        }
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            u9b a = cab.a();
            if (a != null) {
                return a.getAppContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            u9b a = cab.a();
            if (a != null) {
                return a.d();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static w8b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return cab.e();
        }
        return (w8b) invokeV.objValue;
    }

    public static a9b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return cab.f();
        }
        return (a9b) invokeV.objValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            v9b b = cab.b();
            if (b != null) {
                return b.isAgreePrivacy();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            u9b a = cab.a();
            if (a != null) {
                return a.isDebug();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            u9b a = cab.a();
            if (a != null) {
                return a.c(str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static IBinder e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            w9b c = cab.c();
            if (c != null) {
                return c.a(str);
            }
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            u9b a = cab.a();
            if (a != null) {
                return a.e(str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65546, null, z)) == null) {
            u9b a = cab.a();
            if (a != null) {
                return a.b(z);
            }
            return "";
        }
        return (String) invokeZ.objValue;
    }

    public static void q(int i) {
        u9b a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65552, null, i) == null) && (a = cab.a()) != null) {
            a.a(i);
        }
    }

    public static int f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, str, i)) == null) {
            u9b a = cab.a();
            if (a != null) {
                return a.getInt(str, i);
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public static long g(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, str, j)) == null) {
            u9b a = cab.a();
            if (a != null) {
                return a.getLong(str, j);
            }
            return j;
        }
        return invokeLJ.longValue;
    }

    public static void n(String str, int i) {
        u9b a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65549, null, str, i) == null) && (a = cab.a()) != null) {
            a.putInt(str, i);
        }
    }

    public static void o(String str, long j) {
        u9b a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(65550, null, str, j) == null) && (a = cab.a()) != null) {
            a.putLong(str, j);
        }
    }

    public static void p(String str, String str2) {
        u9b a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65551, null, str, str2) == null) && (a = cab.a()) != null) {
            a.putString(str, str2);
        }
    }
}
