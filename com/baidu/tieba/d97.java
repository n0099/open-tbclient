package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.Map;
@Autowired
/* loaded from: classes5.dex */
public class d97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947659463, "Lcom/baidu/tieba/d97;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947659463, "Lcom/baidu/tieba/d97;");
                return;
            }
        }
        GlobalBuildConfig.isDebug();
    }

    public d97() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Inject
    public static y87 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return qp6.a();
        }
        return (y87) invokeV.objValue;
    }

    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str.trim());
                try {
                    sb.append("&");
                    sb.append(URLEncoder.encode(str2, "UTF-8"));
                    sb.append("=");
                    sb.append(URLEncoder.encode(str3, "UTF-8"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return sb.toString();
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    public static String b(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, map)) == null) {
            if (!TextUtils.isEmpty(str) && map != null && !map.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append(str.trim());
                try {
                    for (String str2 : map.keySet()) {
                        sb.append("&");
                        sb.append(URLEncoder.encode(str2, "UTF-8"));
                        sb.append("=");
                        sb.append(URLEncoder.encode(map.get(str2), "UTF-8"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return sb.toString();
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) {
            d().a(context, str);
        }
    }
}
