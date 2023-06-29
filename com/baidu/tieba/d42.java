package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.security.SchemeCheckerHelperImpl;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final String[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947654503, "Lcom/baidu/tieba/d42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947654503, "Lcom/baidu/tieba/d42;");
                return;
            }
        }
        a = ms1.a;
        b = new String[]{"swan", "swanAPI", "utils"};
    }

    @NonNull
    public static Pair<Boolean, b42> a(c02 c02Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, c02Var, str)) == null) {
            c42 c42Var = new c42();
            boolean b2 = b(str, c02Var.a().e());
            if (b2) {
                c42Var.b = 402;
            }
            return new Pair<>(Boolean.valueOf(b2), c42Var);
        }
        return (Pair) invokeLL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean b(String str, CallbackHandler callbackHandler) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, callbackHandler)) == null) {
            if (!(callbackHandler instanceof ky1)) {
                if (a) {
                    Log.d("SwanApiSafe", "intercept: false, handler is null or not WebSafeHolder");
                }
                return false;
            } else if (TextUtils.isEmpty(str)) {
                if (!a) {
                    return false;
                }
                throw new RuntimeException("whitelistName is empty");
            } else {
                String Z = ((ky1) callbackHandler).Z();
                if (SchemeCheckerHelperImpl.FRAME_WHITE_LIST_SWAN_APP_WIDGET.equals(Z)) {
                    z = c(str);
                } else if ("ai_apps_ad_landing".equals(Z)) {
                    z = !tc3.a(str);
                } else {
                    if (!"swan_app_alliance_login_widget".equals(Z) && !"swan_app_alliance_choose_address_widget".equals(Z) && a) {
                        Log.d("SwanApiSafe", "intercept: false, source frame is not aiapps widget frame");
                    }
                    return false;
                }
                if (a) {
                    Log.d("SwanApiSafe", "intercept: result=" + z + ", path=" + str);
                }
                return z;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(@NonNull String str) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int indexOf = str.indexOf("/");
            if (indexOf < 0) {
                return true;
            }
            if (str.startsWith("swan")) {
                String substring = str.substring(indexOf + 1);
                for (String str2 : b) {
                    if (tc3.g(str2 + "/" + substring)) {
                        return false;
                    }
                }
                return true;
            }
            return !tc3.g(str);
        }
        return invokeL.booleanValue;
    }
}
