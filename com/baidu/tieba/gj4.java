package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.pms.node.Node;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(@Nullable dj4<JSONArray> dj4Var, @Nullable dj4<JSONObject> dj4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dj4Var, dj4Var2)) == null) {
            return b(Node.values(), dj4Var, dj4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static JSONObject b(Node[] nodeArr, @Nullable dj4<JSONArray> dj4Var, @Nullable dj4<JSONObject> dj4Var2) {
        InterceptResult invokeLLL;
        fj4 provider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, nodeArr, dj4Var, dj4Var2)) == null) {
            if (nodeArr == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                for (Node node : nodeArr) {
                    if (node != null && (provider = Node.getProvider(node)) != null) {
                        if (node.isDataArray()) {
                            jSONObject.put(node.getName(), provider.b(dj4Var));
                        } else {
                            jSONObject.put(node.getName(), provider.a(dj4Var2));
                        }
                    }
                }
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static void c(JSONObject jSONObject, of4 of4Var, @Nullable of4 of4Var2, @Nullable of4 of4Var3) {
        cf4 b;
        ej4 a;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65538, null, jSONObject, of4Var, of4Var2, of4Var3) != null) || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Node nodeByConfigName = Node.getNodeByConfigName(next);
            if (nodeByConfigName != null && (a = hj4.a(nodeByConfigName)) != null) {
                if (nodeByConfigName.isDataArray()) {
                    a.a(jSONObject.optJSONArray(next), of4Var, of4Var2, of4Var3);
                } else {
                    a.b(jSONObject.optJSONObject(next), of4Var, of4Var2, of4Var3);
                }
            }
        }
        if (zj4.a && (b = ef4.b()) != null) {
            b.C();
        }
    }
}
