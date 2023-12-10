package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Pendant;
/* loaded from: classes6.dex */
public class h6d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Pendant pendant) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pendant)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "props_id", pendant.props_id);
            ltc.a(jSONObject, BigdayActivityConfig.IMG_URL, pendant.img_url);
            ltc.a(jSONObject, "dynamic_url", pendant.dynamic_url);
            ltc.a(jSONObject, BigdayActivityConfig.JUMP_URL, pendant.jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
