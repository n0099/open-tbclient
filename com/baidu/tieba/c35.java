package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public class c35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, String> a;

    public c35() {
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
        this.a = new ArrayMap();
    }

    @NonNull
    public static c35 b(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            c35 c35Var = new c35();
            if (!str2.startsWith("http") && !str2.startsWith("https")) {
                if (str2.startsWith("dialoginternal://")) {
                    Uri parse = Uri.parse(str2);
                    for (String str3 : parse.getQueryParameterNames()) {
                        String queryParameter = parse.getQueryParameter(str3);
                        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(queryParameter)) {
                            c35Var.a.put(str3, queryParameter);
                        }
                    }
                    c35Var.a.put("yun_dialogClass", parse.getAuthority());
                    c35Var.a.put("yun_dialogName", str);
                    c35Var.a.put("yun_dialogUrl", str2);
                }
            } else {
                c35Var.a.put("yun_dialogClass", "WebViewYunDialog");
                c35Var.a.put("yun_dialogName", str);
                c35Var.a.put("yun_dialogUrl", str2);
            }
            return c35Var;
        }
        return (c35) invokeLL.objValue;
    }

    public String a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return this.a.get(str);
        }
        return (String) invokeL.objValue;
    }
}
