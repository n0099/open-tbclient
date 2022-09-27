package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class e01 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e01 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, b01> a;

    public e01() {
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

    public static e01 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (e01.class) {
                    if (b == null) {
                        b = new e01();
                    }
                }
            }
            return b;
        }
        return (e01) invokeV.objValue;
    }

    @NonNull
    public b01 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            b01 b01Var = (b01) yz0.b(this.a, str);
            if (b01Var == null) {
                synchronized (e01.class) {
                    b01Var = (b01) yz0.b(this.a, str);
                    if (b01Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            b01Var = d01.a().a();
                        } else {
                            b01Var = d01.a().b(str);
                        }
                        yz0.e(this.a, str, b01Var);
                    }
                }
            }
            return b01Var;
        }
        return (b01) invokeL.objValue;
    }
}
