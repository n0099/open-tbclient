package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SkinInfo;
/* loaded from: classes6.dex */
public class i3d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SkinInfo skinInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, skinInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "skin", skinInfo.skin);
            poc.a(jSONObject, "skin_size", skinInfo.skin_size);
            poc.a(jSONObject, "url", skinInfo.url);
            poc.a(jSONObject, "obj_id", skinInfo.obj_id);
            poc.a(jSONObject, "monitor_id", skinInfo.monitor_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
