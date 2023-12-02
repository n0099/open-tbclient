package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class az0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile az0 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, xy0> a;

    public az0() {
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

    public static az0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (az0.class) {
                    if (b == null) {
                        b = new az0();
                    }
                }
            }
            return b;
        }
        return (az0) invokeV.objValue;
    }

    @NonNull
    public xy0 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            xy0 xy0Var = (xy0) py0.b(this.a, str);
            if (xy0Var == null) {
                synchronized (az0.class) {
                    xy0Var = (xy0) py0.b(this.a, str);
                    if (xy0Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            xy0Var = zy0.a().a();
                        } else {
                            xy0Var = zy0.a().b(str);
                        }
                        py0.e(this.a, str, xy0Var);
                    }
                }
            }
            return xy0Var;
        }
        return (xy0) invokeL.objValue;
    }
}
