package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hq3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947832319, "Lcom/baidu/tieba/hq3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947832319, "Lcom/baidu/tieba/hq3;");
                return;
            }
        }
        a = is1.a;
    }

    public static List<JSONObject> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String schemesDes = SchemeCollecter.getSchemesDes(str, 0);
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(schemesDes);
                arrayList.add(jSONObject);
                int i = jSONObject.getInt("totalSlices");
                for (int i2 = 1; i2 < i; i2++) {
                    arrayList.add(new JSONObject(SchemeCollecter.getSchemesDes(str, i2)));
                }
                return arrayList;
            } catch (JSONException e) {
                if (a) {
                    Log.e("SwanAppCompat", "getDescriptions", e);
                    return null;
                }
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public static List<JSONObject> b(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            List<JSONObject> a2 = a(str);
            if (a2 != null && !a2.isEmpty()) {
                for (JSONObject jSONObject : a2) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("descriptions");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                Iterator<nw2> it = mw2.b().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        nw2 next = it.next();
                                        String optString = optJSONObject.optString("name");
                                        if (next.a(str, optString)) {
                                            try {
                                                optJSONArray.put(i, next.c(optString, optJSONObject));
                                                break;
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return a2;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }
}
