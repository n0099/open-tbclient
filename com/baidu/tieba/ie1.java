package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ie1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947850516, "Lcom/baidu/tieba/ie1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947850516, "Lcom/baidu/tieba/ie1;");
                return;
            }
        }
        me1 e = me1.e();
        ne1 ne1Var = new ne1();
        e.f("splash_ad", ne1Var);
        e.g(ne1Var);
    }

    public static boolean a(Context context, String str, fe1 fe1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, fe1Var)) == null) {
            if (oe1.g(str)) {
                return c(context, Uri.parse(str), fe1Var);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(Context context, Uri uri, String str, fe1 fe1Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, uri, str, fe1Var)) == null) {
            if (context == null) {
                context = he1.a();
            }
            me1 e = me1.e();
            le1 le1Var = new le1(uri, str);
            le1Var.g(false);
            return e.b(context, le1Var, fe1Var);
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean c(Context context, Uri uri, fe1 fe1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, uri, fe1Var)) == null) ? b(context, uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE, fe1Var) : invokeLLL.booleanValue;
    }
}
