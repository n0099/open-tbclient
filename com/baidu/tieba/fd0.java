package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
@Service
/* loaded from: classes5.dex */
public class fd0 extends zd0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.zd0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "loadCache" : (String) invokeV.objValue;
    }

    public fd0() {
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

    @Override // com.baidu.tieba.zd0
    public boolean b(@NonNull Context context, @NonNull de0 de0Var, @Nullable Map<String, Object> map, @Nullable he0 he0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, de0Var, map, he0Var)) == null) {
            super.b(context, de0Var, map, he0Var);
            HashMap<String, String> d = de0Var.d();
            String str = d.get("key");
            String str2 = d.get(WebChromeClient.KEY_ARG_CALLBACK);
            String str3 = d.get("ext");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String b = gd0.a().b(str);
                JSONObject jSONObject = new JSONObject();
                ux0.f(jSONObject, "key", str);
                ux0.f(jSONObject, "message", b);
                ux0.f(jSONObject, "ext", str3);
                d(he0Var, de0Var, jSONObject.toString(), 0, true);
                return true;
            }
            c(he0Var, de0Var, 202, false);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
