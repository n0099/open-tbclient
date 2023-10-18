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
/* loaded from: classes5.dex */
public class ch4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(@Nullable zg4<JSONArray> zg4Var, @Nullable zg4<JSONObject> zg4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, zg4Var, zg4Var2)) == null) {
            return b(Node.values(), zg4Var, zg4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static JSONObject b(Node[] nodeArr, @Nullable zg4<JSONArray> zg4Var, @Nullable zg4<JSONObject> zg4Var2) {
        InterceptResult invokeLLL;
        bh4 provider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, nodeArr, zg4Var, zg4Var2)) == null) {
            if (nodeArr == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                for (Node node : nodeArr) {
                    if (node != null && (provider = Node.getProvider(node)) != null) {
                        if (node.isDataArray()) {
                            jSONObject.put(node.getName(), provider.b(zg4Var));
                        } else {
                            jSONObject.put(node.getName(), provider.a(zg4Var2));
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

    public static void c(JSONObject jSONObject, kd4 kd4Var, @Nullable kd4 kd4Var2, @Nullable kd4 kd4Var3) {
        yc4 b;
        ah4 a;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65538, null, jSONObject, kd4Var, kd4Var2, kd4Var3) != null) || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Node nodeByConfigName = Node.getNodeByConfigName(next);
            if (nodeByConfigName != null && (a = dh4.a(nodeByConfigName)) != null) {
                if (nodeByConfigName.isDataArray()) {
                    a.a(jSONObject.optJSONArray(next), kd4Var, kd4Var2, kd4Var3);
                } else {
                    a.b(jSONObject.optJSONObject(next), kd4Var, kd4Var2, kd4Var3);
                }
            }
        }
        if (vh4.a && (b = ad4.b()) != null) {
            b.C();
        }
    }
}
