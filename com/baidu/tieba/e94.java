package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tieba.w24;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes5.dex */
public class e94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947689161, "Lcom/baidu/tieba/e94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947689161, "Lcom/baidu/tieba/e94;");
                return;
            }
        }
        boolean z = rm1.a;
    }

    public static PathType a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return PathType.ERROR;
            }
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                return PathType.RELATIVE;
            }
            return PathType.NETWORK;
        }
        return (PathType) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        File h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            g63 q = f63.K().q();
            if (!q.I() || q.l0() == null || (h = w24.d.h(q.getAppId(), q.l0())) == null || !h.exists()) {
                return null;
            }
            return "file://" + h.getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }
}
