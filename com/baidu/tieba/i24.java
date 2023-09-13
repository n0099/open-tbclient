package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i24 extends n34 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947801598, "Lcom/baidu/tieba/i24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947801598, "Lcom/baidu/tieba/i24;");
                return;
            }
        }
        boolean z = rr1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i24() {
        super("getDownloadConfig");
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

    @Override // com.baidu.tieba.n34
    public h32 a(JSONObject jSONObject, lo2 lo2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, lo2Var)) == null) {
            if (jSONObject == null) {
                lo2Var.onFail(202, "params may be error");
                return null;
            }
            if (jSONObject.has("wifiResumeDownloadFlag")) {
                r24.a().c(jSONObject.optBoolean("wifiResumeDownloadFlag", false));
            }
            if (jSONObject.has("install_guide_switch")) {
                w24.r(jSONObject.optBoolean("install_guide_switch"));
            }
            if (jSONObject.has("install_guide_count")) {
                w24.q(jSONObject.optInt("install_guide_count"));
            }
            if (jSONObject.has("get_install_result")) {
                w24.s(jSONObject.optBoolean("get_install_result"));
            }
            lo2Var.onSuccess(null);
            return null;
        }
        return (h32) invokeLL.objValue;
    }
}
