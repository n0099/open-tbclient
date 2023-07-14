package com.baidu.tieba;

import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hyb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String[] a;
    public String[] b;
    public int c;
    public String d;
    public boolean e;

    public hyb() {
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
        this.a = new String[0];
        this.b = new String[0];
        this.c = 0;
        this.d = "";
        this.e = false;
    }

    public static hyb a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            hyb hybVar = new hyb();
            if (str != null && !str.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONArray optJSONArray = jSONObject.optJSONArray("ipsV4");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        hybVar.a = new String[optJSONArray.length()];
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            hybVar.a[i] = optJSONArray.getString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("ipsV6");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        hybVar.b = new String[optJSONArray2.length()];
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            hybVar.b[i2] = optJSONArray2.getString(i2);
                        }
                    }
                    hybVar.c = jSONObject.optInt("dnsResolveType");
                    hybVar.d = jSONObject.optString(StatConstants.KEY_EXT_ERR_MSG);
                    hybVar.e = jSONObject.optBoolean("success");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return hybVar;
        }
        return (hyb) invokeL.objValue;
    }

    public static String b(hyb hybVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hybVar)) == null) {
            if (hybVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < hybVar.a.length; i++) {
                    jSONArray.put(hybVar.a[i]);
                }
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < hybVar.b.length; i2++) {
                    jSONArray2.put(hybVar.b[i2]);
                }
                jSONObject.put("ipsV4", jSONArray);
                jSONObject.put("ipsV6", jSONArray2);
                jSONObject.put("dnsResolveType", hybVar.c);
                jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, hybVar.d);
                jSONObject.put("success", hybVar.e);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
