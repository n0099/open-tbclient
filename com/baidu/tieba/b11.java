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
public class b11 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b11 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, y01> a;

    public b11() {
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

    public static b11 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (b11.class) {
                    if (b == null) {
                        b = new b11();
                    }
                }
            }
            return b;
        }
        return (b11) invokeV.objValue;
    }

    @NonNull
    public y01 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            y01 y01Var = (y01) v01.b(this.a, str);
            if (y01Var == null) {
                synchronized (b11.class) {
                    y01Var = (y01) v01.b(this.a, str);
                    if (y01Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            y01Var = a11.a().a();
                        } else {
                            y01Var = a11.a().b(str);
                        }
                        v01.e(this.a, str, y01Var);
                    }
                }
            }
            return y01Var;
        }
        return (y01) invokeL.objValue;
    }
}
