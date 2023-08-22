package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes5.dex */
public class e9b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
        }
    }

    public static void a(p9b p9bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, p9bVar) == null) && p9bVar != null && !p9bVar.y()) {
            JSONArray n = p9bVar.n();
            int length = n.length();
            boolean B = p9bVar.B();
            for (int i = 0; i < length; i++) {
                try {
                    if (B != k8b.o().e(n.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + B + "  content " + p9bVar.u().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
