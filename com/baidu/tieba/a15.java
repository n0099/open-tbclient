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
public class a15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, String> a;

    public a15() {
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
    public static a15 b(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            a15 a15Var = new a15();
            if (!str2.startsWith("http") && !str2.startsWith("https")) {
                if (str2.startsWith("dialoginternal://")) {
                    Uri parse = Uri.parse(str2);
                    for (String str3 : parse.getQueryParameterNames()) {
                        String queryParameter = parse.getQueryParameter(str3);
                        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(queryParameter)) {
                            a15Var.a.put(str3, queryParameter);
                        }
                    }
                    a15Var.a.put("yun_dialogClass", parse.getAuthority());
                    a15Var.a.put("yun_dialogName", str);
                    a15Var.a.put("yun_dialogUrl", str2);
                }
            } else {
                a15Var.a.put("yun_dialogClass", "WebViewYunDialog");
                a15Var.a.put("yun_dialogName", str);
                a15Var.a.put("yun_dialogUrl", str2);
            }
            return a15Var;
        }
        return (a15) invokeLL.objValue;
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
