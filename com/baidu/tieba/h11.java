package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class h11 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h11 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, e11> a;

    public h11() {
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
        this.a = new ConcurrentHashMap<>();
    }

    public static h11 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (h11.class) {
                    if (b == null) {
                        b = new h11();
                    }
                }
            }
            return b;
        }
        return (h11) invokeV.objValue;
    }

    @NonNull
    public e11 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            e11 e11Var = (e11) w01.b(this.a, str);
            if (e11Var == null) {
                synchronized (h11.class) {
                    e11Var = (e11) w01.b(this.a, str);
                    if (e11Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            e11Var = g11.a().a();
                        } else {
                            e11Var = g11.a().b(str);
                        }
                        w01.e(this.a, str, e11Var);
                    }
                }
            }
            return e11Var;
        }
        return (e11) invokeL.objValue;
    }
}
