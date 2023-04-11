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
public class i11 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i11 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, f11> a;

    public i11() {
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

    public static i11 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (i11.class) {
                    if (b == null) {
                        b = new i11();
                    }
                }
            }
            return b;
        }
        return (i11) invokeV.objValue;
    }

    @NonNull
    public f11 b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            f11 f11Var = (f11) x01.b(this.a, str);
            if (f11Var == null) {
                synchronized (i11.class) {
                    f11Var = (f11) x01.b(this.a, str);
                    if (f11Var == null) {
                        if (TextUtils.isEmpty(str)) {
                            f11Var = h11.a().a();
                        } else {
                            f11Var = h11.a().b(str);
                        }
                        x01.e(this.a, str, f11Var);
                    }
                }
            }
            return f11Var;
        }
        return (f11) invokeL.objValue;
    }
}
