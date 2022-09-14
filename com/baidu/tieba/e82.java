package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ul2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes3.dex */
public class e82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947688138, "Lcom/baidu/tieba/e82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947688138, "Lcom/baidu/tieba/e82;");
                return;
            }
        }
        a = ij1.a;
    }

    public static d82 a(PMSAppInfo pMSAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pMSAppInfo, str)) == null) {
            if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || pMSAppInfo.appCategory != 0) {
                return null;
            }
            File i = ul2.e.i(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode));
            if (!i.exists()) {
                if (a) {
                    Log.w("PrefetchUtils", "aiapp dir not exist ");
                }
                return null;
            }
            d82 d82Var = new d82();
            if (new File(i, "app.json").exists()) {
                if (a) {
                    Log.d("PrefetchUtils", "find main pkg's app config file");
                }
                d82Var.a = i;
                return d82Var;
            } else if (TextUtils.isEmpty(str)) {
                return null;
            } else {
                String g = qg3.g(str);
                int lastIndexOf = g.lastIndexOf(File.separator);
                if (lastIndexOf >= 0) {
                    g = g.substring(0, lastIndexOf);
                }
                if (new File(i, g).exists()) {
                    int lastIndexOf2 = g.lastIndexOf(File.separator);
                    while (lastIndexOf2 >= 0) {
                        g = g.substring(0, lastIndexOf2);
                        if (new File(i, g + File.separator + "app.json").exists()) {
                            if (a) {
                                Log.d("PrefetchUtils", "isInDependentPkg=true, pagePath=" + g);
                            }
                            d82Var.b = true;
                            d82Var.c = g;
                            d82Var.a = new File(i, g);
                            return d82Var;
                        }
                        lastIndexOf2 = g.lastIndexOf(File.separator);
                    }
                    return null;
                }
                return null;
            }
        }
        return (d82) invokeLL.objValue;
    }
}
