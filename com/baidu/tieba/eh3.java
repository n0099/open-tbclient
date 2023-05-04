package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class eh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947734297, "Lcom/baidu/tieba/eh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947734297, "Lcom/baidu/tieba/eh3;");
                return;
            }
        }
        a = ho1.a;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            File c = c();
            if (c.exists()) {
                bo4.j(c);
            }
        }
    }

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return lg3.a().getLong("aiapps_cur_debug_ver_key", 0L);
        }
        return invokeV.longValue;
    }

    public static File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new File(ps2.d().get(0).a, "/aiapps_debug_swan_core/");
        }
        return (File) invokeV.objValue;
    }

    public static File d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            File c = c();
            if (!c.exists()) {
                c.mkdirs();
            }
            return new File(c, "debugSwanCore.zip");
        }
        return (File) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            File file = new File(c().getPath(), "pkginfo.json");
            if (!file.exists()) {
                return false;
            }
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(bo4.E(file));
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            if (jSONObject == null) {
                return false;
            }
            String optString = jSONObject.optString("version_name");
            if (!TextUtils.isEmpty(optString)) {
                lg3.a().putLong("aiapps_cur_debug_ver_key", ml3.b(optString));
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
