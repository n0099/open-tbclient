package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e24 extends e34 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947682434, "Lcom/baidu/tieba/e24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947682434, "Lcom/baidu/tieba/e24;");
                return;
            }
        }
        c = ir1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e24() {
        super("openApp");
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

    @Override // com.baidu.tieba.e34
    public y22 a(@NonNull JSONObject jSONObject, @NonNull co2 co2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, co2Var)) == null) {
            if (c) {
                Log.d("GameCenterOpenAppAction", "handle: " + jSONObject);
            }
            String optString = jSONObject.optString("packageName");
            if (TextUtils.isEmpty(optString)) {
                co2Var.onFail(31010, "package name is empty");
                return null;
            }
            z24.a(optString, "openApp", null, null, null);
            if (!n24.h(AppRuntime.getAppContext(), optString)) {
                co2Var.onFail(31011, "app is not installed");
                z24.a(optString, "openApp", "fail", String.valueOf(31011), null);
                return null;
            }
            if (n24.l(AppRuntime.getAppContext(), optString)) {
                co2Var.onSuccess(null);
                z24.a(optString, "openApp", "success", null, null);
            } else {
                co2Var.onFail(31019, "open app fail");
                z24.a(optString, "openApp", "fail", String.valueOf(31019), null);
            }
            return null;
        }
        return (y22) invokeLL.objValue;
    }
}
