package com.baidu.tieba;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gy3 extends vx3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947810216, "Lcom/baidu/tieba/gy3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947810216, "Lcom/baidu/tieba/gy3;");
                return;
            }
        }
        c = am1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gy3() {
        super("StartAppUsagePage");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.vx3
    public qx1 a(@NonNull JSONObject jSONObject, @NonNull ti2 ti2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, ti2Var)) == null) {
            p53 c0 = p53.c0();
            if (c0 != null && c0.w() != null) {
                try {
                    c0.w().startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
                } catch (Exception e) {
                    if (c) {
                        e.printStackTrace();
                    }
                    ti3.f(c0.w());
                }
                ti2Var.onSuccess(null);
            } else {
                ti2Var.onFail(100, "swan or activity is null");
                if (c) {
                    Log.d("StartAppUsagePage", "swan or activity is null");
                }
            }
            return null;
        }
        return (qx1) invokeLL.objValue;
    }
}
