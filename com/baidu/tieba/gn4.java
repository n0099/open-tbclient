package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gn4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gn4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public gn4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static gn4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (gn4.class) {
                    if (a == null) {
                        a = new gn4();
                    }
                }
            }
            return a;
        }
        return (gn4) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (si4.b() == null) {
                return "0";
            }
            return si4.b().i().getString("local_debug_version", "0");
        }
        return (String) invokeV.objValue;
    }

    public void c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        if (!TextUtils.isEmpty(optString) && (optJSONObject = jSONObject.optJSONObject("data")) != null && si4.b() != null) {
            si4.b().i().putString("local_debug_version", optString);
            si4.b().i().putString("enable_local_debug_switch", optJSONObject.optString("enable_local_debug_switch"));
            si4.b().i().putString("error_url", optJSONObject.optString("error_url"));
            si4.b().i().putString("auth_white_list", optJSONObject.optString("auth_white_list"));
        }
    }
}
