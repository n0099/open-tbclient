package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ak1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947617954, "Lcom/baidu/tieba/ak1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947617954, "Lcom/baidu/tieba/ak1;");
                return;
            }
        }
        ek1 e = ek1.e();
        fk1 fk1Var = new fk1();
        e.f("splash_ad", fk1Var);
        e.g(fk1Var);
    }

    public static boolean a(Context context, String str, xj1 xj1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, xj1Var)) == null) {
            if (gk1.g(str)) {
                return c(context, Uri.parse(str), xj1Var);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(Context context, Uri uri, xj1 xj1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, uri, xj1Var)) == null) {
            return b(context, uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE, xj1Var);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(Context context, Uri uri, String str, xj1 xj1Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, uri, str, xj1Var)) == null) {
            if (context == null) {
                context = zj1.a();
            }
            ek1 e = ek1.e();
            dk1 dk1Var = new dk1(uri, str);
            dk1Var.g(false);
            return e.b(context, dk1Var, xj1Var);
        }
        return invokeLLLL.booleanValue;
    }
}
