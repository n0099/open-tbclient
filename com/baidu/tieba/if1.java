package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class if1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947851477, "Lcom/baidu/tieba/if1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947851477, "Lcom/baidu/tieba/if1;");
                return;
            }
        }
        mf1 e = mf1.e();
        nf1 nf1Var = new nf1();
        e.f("splash_ad", nf1Var);
        e.g(nf1Var);
    }

    public static boolean a(Context context, String str, ff1 ff1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, ff1Var)) == null) {
            if (of1.g(str)) {
                return c(context, Uri.parse(str), ff1Var);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(Context context, Uri uri, ff1 ff1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, uri, ff1Var)) == null) {
            return b(context, uri, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE, ff1Var);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(Context context, Uri uri, String str, ff1 ff1Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, uri, str, ff1Var)) == null) {
            if (context == null) {
                context = hf1.a();
            }
            mf1 e = mf1.e();
            lf1 lf1Var = new lf1(uri, str);
            lf1Var.g(false);
            return e.b(context, lf1Var, ff1Var);
        }
        return invokeLLLL.booleanValue;
    }
}
