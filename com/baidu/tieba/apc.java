package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ActionControl;
import tbclient.AdCloseInfo;
/* loaded from: classes5.dex */
public class apc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AdCloseInfo adCloseInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adCloseInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "support_close", adCloseInfo.support_close);
            poc.a(jSONObject, "title", adCloseInfo.title);
            if (adCloseInfo.reasons != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : adCloseInfo.reasons) {
                    jSONArray.put(str);
                }
                poc.a(jSONObject, "reasons", jSONArray);
            }
            poc.a(jSONObject, "confirm_title", adCloseInfo.confirm_title);
            ActionControl actionControl = adCloseInfo.action_control;
            if (actionControl != null) {
                poc.a(jSONObject, "action_control", xoc.b(actionControl));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
