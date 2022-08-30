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
public class fy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fy0 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, cy0> a;

    public fy0() {
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

    public static fy0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (fy0.class) {
                    if (b == null) {
                        b = new fy0();
                    }
                }
            }
            return b;
        }
        return (fy0) invokeV.objValue;
    }

    @NonNull
    public cy0 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            cy0 cy0Var = (cy0) zx0.b(this.a, str);
            if (cy0Var == null) {
                synchronized (fy0.class) {
                    cy0Var = (cy0) zx0.b(this.a, str);
                    if (cy0Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            cy0Var = ey0.a().a();
                        } else {
                            cy0Var = ey0.a().b(str);
                        }
                        zx0.e(this.a, str, cy0Var);
                    }
                }
            }
            return cy0Var;
        }
        return (cy0) invokeL.objValue;
    }
}
