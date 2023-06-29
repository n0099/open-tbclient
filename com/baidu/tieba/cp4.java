package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cp4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "unknown" : "swanplugin" : "swandynamiclib" : "swangameconsole" : SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan" : (String) invokeI.objValue;
    }

    public static void a(int i, String str, String str2, int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), jSONObject}) == null) {
            nj4.b().K(b(i), str, str2, i2, jSONObject, c(str, i2));
        }
    }

    public static boolean c(String str, int i) {
        InterceptResult invokeLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            boolean equals = TextUtils.equals(str, "cs_protocol");
            if (i != 2000) {
                z = true;
            } else {
                z = false;
            }
            if (equals && z) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }
}
