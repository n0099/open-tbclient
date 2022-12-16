package com.baidu.tieba;

import androidx.core.app.NotificationCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class dy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dy0() {
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

    public static dy0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject != null) {
                dy0 dy0Var = new dy0();
                jSONObject.optString("type_text");
                jSONObject.optString("text");
                jSONObject.optString(NotificationCompat.CarExtender.KEY_AUTHOR);
                jSONObject.optString("cmd");
                return dy0Var;
            }
            return null;
        }
        return (dy0) invokeL.objValue;
    }

    public static List<dy0> b(JSONArray jSONArray) {
        InterceptResult invokeL;
        dy0 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null && jSONArray.length() != 0) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null && (a = a(optJSONObject)) != null) {
                        arrayList.add(a);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }
}
