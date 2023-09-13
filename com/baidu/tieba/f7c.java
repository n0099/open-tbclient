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
/* loaded from: classes5.dex */
public class f7c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String[] a;
    public String[] b;
    public int c;
    public String d;
    public boolean e;

    public f7c() {
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

    public static f7c a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            f7c f7cVar = new f7c();
            if (str != null && !str.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONArray optJSONArray = jSONObject.optJSONArray("ipsV4");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        f7cVar.a = new String[optJSONArray.length()];
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            f7cVar.a[i] = optJSONArray.getString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("ipsV6");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        f7cVar.b = new String[optJSONArray2.length()];
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            f7cVar.b[i2] = optJSONArray2.getString(i2);
                        }
                    }
                    f7cVar.c = jSONObject.optInt("dnsResolveType");
                    f7cVar.d = jSONObject.optString(StatConstants.KEY_EXT_ERR_MSG);
                    f7cVar.e = jSONObject.optBoolean("success");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return f7cVar;
        }
        return (f7c) invokeL.objValue;
    }

    public static String b(f7c f7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, f7cVar)) == null) {
            if (f7cVar == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < f7cVar.a.length; i++) {
                    jSONArray.put(f7cVar.a[i]);
                }
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < f7cVar.b.length; i2++) {
                    jSONArray2.put(f7cVar.b[i2]);
                }
                jSONObject.put("ipsV4", jSONArray);
                jSONObject.put("ipsV6", jSONArray2);
                jSONObject.put("dnsResolveType", f7cVar.c);
                jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, f7cVar.d);
                jSONObject.put("success", f7cVar.e);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
