package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e95 {
    public static /* synthetic */ Interceptable $ic;
    public static final LinkedList<String> a;
    public static final LinkedList<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947689192, "Lcom/baidu/tieba/e95;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947689192, "Lcom/baidu/tieba/e95;");
                return;
            }
        }
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    public static JSONObject a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            b(jSONObject, "uid", TbadkCoreApplication.getCurrentAccount());
            b(jSONObject, "latest_related_tid", TbadkCoreApplication.getInst().getLatestRelatedTid());
            b(jSONObject, "latest_related_fid", TbadkCoreApplication.getInst().getLatestRelatedFid());
            b(jSONObject, "continuous_crash_times", String.valueOf(k95.q().o()));
            b(jSONObject, "trigger_safe_mode_status", String.valueOf(k95.q().s()));
            b(jSONObject, "fid_info", String.valueOf(a));
            b(jSONObject, "tid_info", String.valueOf(b));
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject b(JSONObject jSONObject, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, jSONObject, str, str2)) == null) {
            if (jSONObject == null) {
                return null;
            }
            if (str != null && str2 != null) {
                try {
                    jSONObject.put(str, str2);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            a.offer(str);
            if (a.size() > 10) {
                a.poll();
            }
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            b.offer(str);
            if (b.size() > 10) {
                b.poll();
            }
        }
    }
}
