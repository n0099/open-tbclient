package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947642940, "Lcom/baidu/tieba/bf1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947642940, "Lcom/baidu/tieba/bf1;");
                return;
            }
        }
        ff1 e = ff1.e();
        gf1 gf1Var = new gf1();
        e.f("splash_ad", gf1Var);
        e.g(gf1Var);
    }

    public static boolean a(Context context, String str, ye1 ye1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, ye1Var)) == null) {
            if (hf1.g(str)) {
                return c(context, Uri.parse(str), ye1Var);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(Context context, Uri uri, ye1 ye1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, uri, ye1Var)) == null) {
            return b(context, uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE, ye1Var);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(Context context, Uri uri, String str, ye1 ye1Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, uri, str, ye1Var)) == null) {
            if (context == null) {
                context = af1.a();
            }
            ff1 e = ff1.e();
            ef1 ef1Var = new ef1(uri, str);
            ef1Var.g(false);
            return e.b(context, ef1Var, ye1Var);
        }
        return invokeLLLL.booleanValue;
    }
}
