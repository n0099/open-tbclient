package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.f24;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes5.dex */
public class d44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile d44 c;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, v34> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947654565, "Lcom/baidu/tieba/d44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947654565, "Lcom/baidu/tieba/d44;");
                return;
            }
        }
        b = am1.a;
    }

    public d44() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
    }

    public static d44 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (d44.class) {
                    if (c == null) {
                        c = new d44();
                    }
                }
            }
            return c;
        }
        return (d44) invokeV.objValue;
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a.clear();
            }
        }
    }

    public static void a(zc2 zc2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, zc2Var, str) == null) && zc2Var != null && zc2Var.w() != null && !TextUtils.isEmpty(str)) {
            zc2Var.w().b(str);
        }
    }

    public void f(zc2 zc2Var, f24.c cVar) {
        j54 j54Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, zc2Var, cVar) == null) && zc2Var != null && cVar != null && (j54Var = cVar.c) != null && j54Var.g != null) {
            e();
            wo2.g0().getSwitch("swan_game_resource_preload", 0);
        }
    }

    public final String c(String str, int i) {
        InterceptResult invokeLI;
        HttpUrl parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
                return null;
            }
            return parse.url().toString() + i;
        }
        return (String) invokeLI.objValue;
    }

    public synchronized v34 d(zc2 zc2Var, xx1 xx1Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zc2Var, xx1Var, i)) == null) {
            synchronized (this) {
                if (xx1Var == null) {
                    return null;
                }
                String C = xx1Var.C("url");
                String c2 = c(C, i);
                if (TextUtils.isEmpty(c2)) {
                    return null;
                }
                v34 remove = this.a.remove(c2);
                if (remove != null) {
                    a(zc2Var, "preload used, url = " + C);
                }
                if (b) {
                    Log.d("SwanGamePreloadManager", "obtainRequestTask requestType:" + i + ";url:" + C + ";task:" + remove);
                }
                return remove;
            }
        }
        return (v34) invokeLLI.objValue;
    }
}
