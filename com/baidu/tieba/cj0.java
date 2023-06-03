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
public class cj0 extends uj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.uj0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "loadCache" : (String) invokeV.objValue;
    }

    public cj0() {
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

    @Override // com.baidu.tieba.uj0
    public boolean b(@NonNull Context context, @NonNull yj0 yj0Var, @Nullable Map<String, Object> map, @Nullable ck0 ck0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, yj0Var, map, ck0Var)) == null) {
            super.b(context, yj0Var, map, ck0Var);
            HashMap<String, String> d = yj0Var.d();
            String str = d.get("key");
            String str2 = d.get(WebChromeClient.KEY_ARG_CALLBACK);
            String str3 = d.get("ext");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String b = dj0.a().b(str);
                JSONObject jSONObject = new JSONObject();
                y21.f(jSONObject, "key", str);
                y21.f(jSONObject, "message", b);
                y21.f(jSONObject, "ext", str3);
                d(ck0Var, yj0Var, jSONObject.toString(), 0, true);
                return true;
            }
            c(ck0Var, yj0Var, 202, false);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
