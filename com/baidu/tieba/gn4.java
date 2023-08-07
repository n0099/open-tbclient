package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gn4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gn4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public gn4() {
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

    public static gn4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (gn4.class) {
                    if (a == null) {
                        a = new gn4();
                    }
                }
            }
            return a;
        }
        return (gn4) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return ji4.b().i().getString("web_mode_version", "0");
        }
        return (String) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (ji4.b().i().getInt("web_mode_switch", 1) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ArrayList<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String string = ji4.b().i().getString("web_mode_degrade_list", "");
            JSONArray jSONArray = null;
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                jSONArray = new JSONArray(string);
            } catch (JSONException unused) {
            }
            ArrayList<String> arrayList = new ArrayList<>();
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final String e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("errno_list");
            if (optJSONArray != null) {
                return optJSONArray.toString();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null || !optJSONObject.has("host_use_weburl_degrade")) {
            return;
        }
        int optInt = optJSONObject.optInt("host_use_weburl_degrade", 0);
        String e = e(optJSONObject);
        hi4 b = ji4.b();
        if (b == null) {
            return;
        }
        ar4 i = b.i();
        i.putInt("web_mode_switch", optInt);
        i.putString("web_mode_degrade_list", e);
        i.putString("web_mode_version", optString);
    }
}
