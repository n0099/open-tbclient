package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class dd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Set<xc6> a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            HashSet hashSet = new HashSet();
            if (jSONObject == null) {
                return hashSet;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(PrefetchEvent.MODULE);
            if (optJSONObject == null) {
                return hashSet;
            }
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                if (optJSONObject2 != null) {
                    String str = com.kuaishou.weapon.p0.q1.e;
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("since");
                    if (optJSONObject3 != null) {
                        str = optJSONObject3.optString("android", com.kuaishou.weapon.p0.q1.e);
                    }
                    xc6 xc6Var = new xc6(next, optJSONObject2.optString("method", "GET"), str);
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("headers");
                    if (optJSONObject4 != null) {
                        Iterator<String> keys2 = optJSONObject4.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            if (!TextUtils.isEmpty(next2)) {
                                xc6Var.a(next2, optJSONObject4.optString(next2));
                            }
                        }
                    }
                    hashSet.add(xc6Var);
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static void b(String str) {
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            wc6.c().b();
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONArray = null;
            }
            if (vd6.c(jSONArray)) {
                return;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("url", "");
                    if (!TextUtils.isEmpty(optString)) {
                        Set<xc6> a = a(optJSONObject);
                        vc6 vc6Var = new vc6();
                        if (!vd6.a(a)) {
                            vc6Var.a = a;
                            vc6Var.d = optString;
                            wc6.c().a(optString, vc6Var);
                        } else {
                            wc6.c().a(optString, vc6Var);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
