package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class h11 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static boolean b;
    public static long c;
    public static int d;
    public static int e;
    public static int f;
    public static int g;
    public static int h;
    public static int i;
    public static double j;
    public static double k;
    public static double l;
    public static long m;
    public static long n;
    public static double o;
    public static double p;
    public static double q;
    public static double r;
    public static double[] s;
    public static AtomicBoolean t;
    public static final Object u;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947770753, "Lcom/baidu/tieba/h11;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947770753, "Lcom/baidu/tieba/h11;");
                return;
            }
        }
        a = new int[]{0, 1, 2, 3};
        b = true;
        c = 2000L;
        d = 2;
        e = 2;
        f = 6;
        g = 4;
        h = 6;
        i = 30;
        j = 10.0d;
        k = 30.0d;
        l = 2.0d;
        m = 500L;
        n = 3000L;
        o = 999.0d;
        p = 8.0d;
        q = 3.0d;
        r = 1.0d;
        s = new double[]{999.0d, 8.0d, 3.0d, 1.0d};
        t = new AtomicBoolean(false);
        u = new Object();
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? t.get() : invokeV.booleanValue;
    }

    public static Object b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? u : invokeV.objValue;
    }
}
