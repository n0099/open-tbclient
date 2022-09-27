package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a12 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public JSONArray b;
    public String c;
    public String d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947562247, "Lcom/baidu/tieba/a12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947562247, "Lcom/baidu/tieba/a12;");
                return;
            }
        }
        e = vj1.a;
    }

    public a12() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a12 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            a12 a12Var = new a12();
            try {
                a12Var.b = jSONObject.getJSONArray("host");
                a12Var.a = jSONObject.getString("appKey");
                jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                a12Var.c = jSONObject.getString(ClientCookie.PORT_ATTR);
                a12Var.d = Uri.decode(jSONObject.optString("url"));
                return a12Var;
            } catch (JSONException unused) {
                if (e) {
                    Log.e("RemoteDebugModel", "DebuggerLaunchAction params is invalid");
                    return null;
                }
                return null;
            }
        }
        return (a12) invokeL.objValue;
    }

    public String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            JSONArray jSONArray = this.b;
            if (jSONArray == null) {
                return "";
            }
            String optString = jSONArray.optString(i);
            if (TextUtils.isEmpty(optString)) {
                return "";
            }
            return "http://" + optString + ":" + this.c;
        }
        return (String) invokeI.objValue;
    }
}
