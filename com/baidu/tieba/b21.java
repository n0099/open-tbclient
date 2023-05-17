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
public class b21 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b21 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, y11> a;

    public b21() {
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

    public static b21 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (b21.class) {
                    if (b == null) {
                        b = new b21();
                    }
                }
            }
            return b;
        }
        return (b21) invokeV.objValue;
    }

    @NonNull
    public y11 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            y11 y11Var = (y11) q11.b(this.a, str);
            if (y11Var == null) {
                synchronized (b21.class) {
                    y11Var = (y11) q11.b(this.a, str);
                    if (y11Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            y11Var = a21.a().a();
                        } else {
                            y11Var = a21.a().b(str);
                        }
                        q11.e(this.a, str, y11Var);
                    }
                }
            }
            return y11Var;
        }
        return (y11) invokeL.objValue;
    }
}
