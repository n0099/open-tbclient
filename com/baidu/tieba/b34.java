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
public class b34 extends b44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947594022, "Lcom/baidu/tieba/b34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947594022, "Lcom/baidu/tieba/b34;");
                return;
            }
        }
        c = fs1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b34() {
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

    @Override // com.baidu.tieba.b44
    public v32 a(@NonNull JSONObject jSONObject, @NonNull zo2 zo2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, zo2Var)) == null) {
            if (c) {
                Log.d("GameCenterOpenAppAction", "handle: " + jSONObject);
            }
            String optString = jSONObject.optString("packageName");
            if (TextUtils.isEmpty(optString)) {
                zo2Var.onFail(31010, "package name is empty");
                return null;
            }
            w34.a(optString, "openApp", null, null, null);
            if (!k34.h(AppRuntime.getAppContext(), optString)) {
                zo2Var.onFail(31011, "app is not installed");
                w34.a(optString, "openApp", "fail", String.valueOf(31011), null);
                return null;
            }
            if (k34.l(AppRuntime.getAppContext(), optString)) {
                zo2Var.onSuccess(null);
                w34.a(optString, "openApp", "success", null, null);
            } else {
                zo2Var.onFail(31019, "open app fail");
                w34.a(optString, "openApp", "fail", String.valueOf(31019), null);
            }
            return null;
        }
        return (v32) invokeLL.objValue;
    }
}
