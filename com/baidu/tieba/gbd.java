package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.VipShowInfo;
/* loaded from: classes6.dex */
public class gbd extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VipShowInfo vipShowInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, vipShowInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "vip_icon", vipShowInfo.vip_icon);
            ltc.a(jSONObject, "content", vipShowInfo.content);
            ltc.a(jSONObject, "link", vipShowInfo.link);
            ltc.a(jSONObject, "title", vipShowInfo.title);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
