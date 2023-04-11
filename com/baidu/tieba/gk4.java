package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gk4 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, hk4> a;
    public static HashMap<String, hk4> b;
    public transient /* synthetic */ FieldHolder $fh;

    public gk4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return ff4.c().a("SwanDownloadApiStrategy").getString("version", "0");
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static hk4 a(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (a == null) {
                synchronized (gk4.class) {
                    if (a == null) {
                        HashMap<String, hk4> hashMap = new HashMap<>();
                        a = hashMap;
                        e(hashMap, "download_api_ctrl");
                    }
                }
            }
            return c(str, a);
        }
        return (hk4) invokeL.objValue;
    }

    @NonNull
    public static hk4 b(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (b == null) {
                synchronized (gk4.class) {
                    if (b == null) {
                        HashMap<String, hk4> hashMap = new HashMap<>();
                        b = hashMap;
                        e(hashMap, "preload_api_ctrl");
                    }
                }
            }
            return c(str, b);
        }
        return (hk4) invokeL.objValue;
    }

    public static void f(@Nullable JSONObject jSONObject) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, jSONObject) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        wn4 a2 = ff4.c().a("SwanDownloadApiStrategy");
        a2.putString("version", optString);
        if (optJSONObject != null) {
            str = optJSONObject.toString();
        } else {
            str = null;
        }
        a2.putString("data", str);
    }

    @NonNull
    public static hk4 c(@Nullable String str, @NonNull HashMap<String, hk4> hashMap) {
        InterceptResult invokeLL;
        hk4 hk4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, hashMap)) == null) {
            if (!TextUtils.isEmpty(str) && (hk4Var = hashMap.get(str)) != null) {
                return hk4Var;
            }
            hk4 hk4Var2 = hashMap.get("default");
            if (hk4Var2 != null) {
                return hk4Var2;
            }
            return hk4.a();
        }
        return (hk4) invokeLL.objValue;
    }

    public static void e(@NonNull HashMap<String, hk4> hashMap, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, hashMap, str) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(ff4.c().a("SwanDownloadApiStrategy").getString("data", StringUtil.EMPTY_ARRAY)).optJSONObject(str);
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            hashMap.put(next, hk4.b(optJSONObject.optJSONObject(next)));
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
