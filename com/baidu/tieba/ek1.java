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
public class ek1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947737118, "Lcom/baidu/tieba/ek1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947737118, "Lcom/baidu/tieba/ek1;");
                return;
            }
        }
        ik1 e = ik1.e();
        jk1 jk1Var = new jk1();
        e.f("splash_ad", jk1Var);
        e.g(jk1Var);
    }

    public static boolean a(Context context, String str, bk1 bk1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, bk1Var)) == null) {
            if (kk1.g(str)) {
                return c(context, Uri.parse(str), bk1Var);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(Context context, Uri uri, bk1 bk1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, uri, bk1Var)) == null) {
            return b(context, uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE, bk1Var);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(Context context, Uri uri, String str, bk1 bk1Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, uri, str, bk1Var)) == null) {
            if (context == null) {
                context = dk1.a();
            }
            ik1 e = ik1.e();
            hk1 hk1Var = new hk1(uri, str);
            hk1Var.g(false);
            return e.b(context, hk1Var, bk1Var);
        }
        return invokeLLLL.booleanValue;
    }
}
