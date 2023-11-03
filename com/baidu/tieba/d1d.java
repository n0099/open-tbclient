package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Pendant;
/* loaded from: classes5.dex */
public class d1d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Pendant pendant) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pendant)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "props_id", pendant.props_id);
            poc.a(jSONObject, BigdayActivityConfig.IMG_URL, pendant.img_url);
            poc.a(jSONObject, "dynamic_url", pendant.dynamic_url);
            poc.a(jSONObject, BigdayActivityConfig.JUMP_URL, pendant.jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
