package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class gy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gy0 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, dy0> a;

    public gy0() {
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

    public static gy0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (gy0.class) {
                    if (b == null) {
                        b = new gy0();
                    }
                }
            }
            return b;
        }
        return (gy0) invokeV.objValue;
    }

    @NonNull
    public dy0 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            dy0 dy0Var = (dy0) vx0.b(this.a, str);
            if (dy0Var == null) {
                synchronized (gy0.class) {
                    dy0Var = (dy0) vx0.b(this.a, str);
                    if (dy0Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            dy0Var = fy0.a().a();
                        } else {
                            dy0Var = fy0.a().b(str);
                        }
                        vx0.e(this.a, str, dy0Var);
                    }
                }
            }
            return dy0Var;
        }
        return (dy0) invokeL.objValue;
    }
}
