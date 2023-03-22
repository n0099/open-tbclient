package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public final class d83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, i83> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947658378, "Lcom/baidu/tieba/d83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947658378, "Lcom/baidu/tieba/d83;");
                return;
            }
        }
        b = do1.a;
    }

    public d83() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            File d = a33.d(str2);
            if (d == null || !d.exists()) {
                if (str.endsWith(File.separator)) {
                    d = new File(str + str2 + ".json");
                } else {
                    d = new File(str + File.separator + str2 + ".json");
                }
            }
            if (b) {
                Log.d("PageConfigData", "parseConfigFile baseUrl : " + str + " ,page: " + str2 + " file exist:" + d.exists());
            }
            if (!d.exists()) {
                return null;
            }
            return pq2.m(d);
        }
        return (String) invokeLL.objValue;
    }

    public i83 a(String str, @NonNull String str2, @NonNull i83 i83Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, i83Var)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                i83 d = d(str, str2, i83Var);
                this.a.put(str2, d);
                return d;
            }
            return i83Var;
        }
        return (i83) invokeLLL.objValue;
    }

    public final i83 d(String str, String str2, @NonNull i83 i83Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, i83Var)) == null) {
            String c = c(str, str2);
            if (TextUtils.isEmpty(c)) {
                return i83Var;
            }
            return i83.b(c, i83Var);
        }
        return (i83) invokeLLL.objValue;
    }

    public i83 b(String str, String str2, @NonNull i83 i83Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i83Var)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (this.a == null) {
                    this.a = new TreeMap();
                }
                i83 i83Var2 = this.a.get(str2);
                if (i83Var2 != null) {
                    return i83Var2;
                }
                i83 d = d(str, str2, i83Var);
                this.a.put(str2, d);
                return d;
            }
            return i83Var;
        }
        return (i83) invokeLLL.objValue;
    }
}
