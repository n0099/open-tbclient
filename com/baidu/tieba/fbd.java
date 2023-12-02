package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.VipShowInfo;
/* loaded from: classes5.dex */
public class fbd extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VipShowInfo vipShowInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, vipShowInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "vip_icon", vipShowInfo.vip_icon);
            ktc.a(jSONObject, "content", vipShowInfo.content);
            ktc.a(jSONObject, "link", vipShowInfo.link);
            ktc.a(jSONObject, "title", vipShowInfo.title);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
