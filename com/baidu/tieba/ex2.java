package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ex2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public String c;
    public String d;
    public int e;

    public ex2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.b = true;
        this.d = "back";
        this.e = 60;
    }

    public static ex2 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            ex2 ex2Var = new ex2();
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    int i = 0;
                    for (int i2 = 0; i2 < length; i2++) {
                        String optString = optJSONArray.optString(i2);
                        char c = 65535;
                        int hashCode = optString.hashCode();
                        if (hashCode != -1367751899) {
                            if (hashCode == 92896879 && optString.equals("album")) {
                                c = 0;
                            }
                        } else if (optString.equals("camera")) {
                            c = 1;
                        }
                        if (c != 0) {
                            if (c == 1) {
                                i |= 2;
                            }
                        } else {
                            i |= 1;
                        }
                    }
                    ex2Var.a = i;
                }
                ex2Var.b = jSONObject.optBoolean("compressed", true);
                int i3 = 60;
                int optInt = jSONObject.optInt("maxDuration", 60);
                if (optInt <= 60) {
                    i3 = optInt;
                }
                ex2Var.e = i3;
                ex2Var.d = jSONObject.optString("camera");
                ex2Var.c = jSONObject.optString("cb");
            }
            return ex2Var;
        }
        return (ex2) invokeL.objValue;
    }
}
