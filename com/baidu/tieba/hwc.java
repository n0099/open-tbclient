package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.DealAuthInfo;
/* loaded from: classes6.dex */
public class hwc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DealAuthInfo dealAuthInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dealAuthInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "item_name", dealAuthInfo.item_name);
            ltc.a(jSONObject, "item_content", dealAuthInfo.item_content);
            ltc.a(jSONObject, "item_url", dealAuthInfo.item_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
