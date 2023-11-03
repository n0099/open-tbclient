package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hi4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hi4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public hi4() {
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

    public static hi4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (hi4.class) {
                    if (a == null) {
                        a = new hi4();
                    }
                }
            }
            return a;
        }
        return (hi4) invokeV.objValue;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        if (!TextUtils.isEmpty(optString) && (optJSONObject = jSONObject.optJSONObject("data")) != null && rd4.b() != null && rd4.b().i() != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray(AlbumActivityConfig.FROM_WEB_VIEW);
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("js");
            boolean z2 = true;
            if (optJSONArray != null) {
                z = rd4.b().o(false, optJSONArray);
            } else {
                z = true;
            }
            if (optJSONArray2 != null) {
                z2 = rd4.b().o(true, optJSONArray2);
            }
            if (z && z2) {
                rd4.b().i().putString("key_online_description_fix_version", optString);
            }
        }
    }
}
