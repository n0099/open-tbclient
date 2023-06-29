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
/* loaded from: classes6.dex */
public class i34 extends i44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947802559, "Lcom/baidu/tieba/i34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947802559, "Lcom/baidu/tieba/i34;");
                return;
            }
        }
        c = ms1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i34() {
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

    @Override // com.baidu.tieba.i44
    public c42 a(@NonNull JSONObject jSONObject, @NonNull gp2 gp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, gp2Var)) == null) {
            if (c) {
                Log.d("GameCenterOpenAppAction", "handle: " + jSONObject);
            }
            String optString = jSONObject.optString("packageName");
            if (TextUtils.isEmpty(optString)) {
                gp2Var.onFail(31010, "package name is empty");
                return null;
            }
            d44.a(optString, "openApp", null, null, null);
            if (!r34.h(AppRuntime.getAppContext(), optString)) {
                gp2Var.onFail(31011, "app is not installed");
                d44.a(optString, "openApp", "fail", String.valueOf(31011), null);
                return null;
            }
            if (r34.l(AppRuntime.getAppContext(), optString)) {
                gp2Var.onSuccess(null);
                d44.a(optString, "openApp", "success", null, null);
            } else {
                gp2Var.onFail(31019, "open app fail");
                d44.a(optString, "openApp", "fail", String.valueOf(31019), null);
            }
            return null;
        }
        return (c42) invokeLL.objValue;
    }
}
