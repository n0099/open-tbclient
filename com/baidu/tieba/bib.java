package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bib {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = true;
    public static long e = 300000;
    public static int f = 10;
    public static long g = 604800000;
    public static long h = 104857600;
    public static int i = 100;
    public static int j = 5;
    public static int k = 10;
    public static long l = 104857600;
    public static int m = 0;
    public static int n = 1;
    public static int o = 1;
    public static int p = 0;
    public static int q = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947647342, "Lcom/baidu/tieba/bib;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947647342, "Lcom/baidu/tieba/bib;");
        }
    }
}
