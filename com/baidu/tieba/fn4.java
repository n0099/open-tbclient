package com.baidu.tieba;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class fn4 {
    public static /* synthetic */ Interceptable $ic;
    public static fn4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public String b;
    public String c;

    /* loaded from: classes5.dex */
    public static class a extends rr4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super("updatecore_node_tipmsgs");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public fn4() {
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
        this.a = new a();
        this.b = AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f14fc);
        this.c = AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f14fd);
    }

    public static fn4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d == null) {
                synchronized (fn4.class) {
                    if (d == null) {
                        d = new fn4();
                    }
                }
            }
            return d;
        }
        return (fn4) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a.getString("tips_config_version", "0");
        }
        return (String) invokeV.objValue;
    }

    public String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            return this.a.getString(String.format("%04d", Long.valueOf(j)), this.b);
        }
        return (String) invokeJ.objValue;
    }

    public String c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            return this.a.getString(String.format("%04d", Long.valueOf(j)), this.c);
        }
        return (String) invokeJ.objValue;
    }

    public void e(JSONObject jSONObject) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONArray = jSONObject.optJSONArray("data")) == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            hashMap.put(optJSONObject.optString("tipno"), optJSONObject.optString("tipmsg"));
        }
        f(hashMap, optString);
    }

    public void f(HashMap<String, String> hashMap, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, hashMap, str) == null) && hashMap != null && !hashMap.isEmpty() && !TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = this.a.edit();
            edit.clear();
            edit.putString("tips_config_version", str);
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                edit.putString(entry.getKey(), entry.getValue());
            }
            edit.apply();
        }
    }
}
