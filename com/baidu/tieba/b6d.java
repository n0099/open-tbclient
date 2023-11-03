package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.VipShowInfo;
/* loaded from: classes5.dex */
public class b6d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VipShowInfo vipShowInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, vipShowInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "vip_icon", vipShowInfo.vip_icon);
            poc.a(jSONObject, "content", vipShowInfo.content);
            poc.a(jSONObject, "link", vipShowInfo.link);
            poc.a(jSONObject, "title", vipShowInfo.title);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
