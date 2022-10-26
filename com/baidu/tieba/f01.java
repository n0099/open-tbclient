package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class f01 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f01 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap a;

    public f01() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap();
    }

    public static f01 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (f01.class) {
                    if (b == null) {
                        b = new f01();
                    }
                }
            }
            return b;
        }
        return (f01) invokeV.objValue;
    }

    public c01 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            c01 c01Var = (c01) zz0.b(this.a, str);
            if (c01Var == null) {
                synchronized (f01.class) {
                    c01Var = (c01) zz0.b(this.a, str);
                    if (c01Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            c01Var = e01.a().a();
                        } else {
                            c01Var = e01.a().b(str);
                        }
                        zz0.e(this.a, str, c01Var);
                    }
                }
            }
            return c01Var;
        }
        return (c01) invokeL.objValue;
    }
}
