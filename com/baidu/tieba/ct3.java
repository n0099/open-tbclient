package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ct3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947686247, "Lcom/baidu/tieba/ct3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947686247, "Lcom/baidu/tieba/ct3;");
                return;
            }
        }
        a = nr1.a;
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, str4, str5) == null) {
            gi3 gi3Var = new gi3();
            gi3Var.a = "swan";
            gi3Var.b = str;
            gi3Var.g = str2;
            if (TextUtils.equals(str, "click")) {
                gi3Var.e = str3;
            }
            gi3Var.f = str5;
            gi3Var.a("source", str4);
            if (a) {
                Log.d("LoginAndGetMobileStatics", "staticLoginResult: event = " + gi3Var.f());
            }
            wh3.x("1372", gi3Var);
        }
    }
}
