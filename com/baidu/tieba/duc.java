package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.AgreeBanner;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class duc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AgreeBanner agreeBanner) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, agreeBanner)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "text", agreeBanner.text);
            qoc.a(jSONObject, "icon_url", agreeBanner.icon_url);
            qoc.a(jSONObject, "url", agreeBanner.url);
            if (agreeBanner.top_agree_user != null) {
                JSONArray jSONArray = new JSONArray();
                for (SimpleUser simpleUser : agreeBanner.top_agree_user) {
                    jSONArray.put(i3d.b(simpleUser));
                }
                qoc.a(jSONObject, "top_agree_user", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
