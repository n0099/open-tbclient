package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.VipShowInfo;
/* loaded from: classes5.dex */
public class c6d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VipShowInfo vipShowInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, vipShowInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "vip_icon", vipShowInfo.vip_icon);
            qoc.a(jSONObject, "content", vipShowInfo.content);
            qoc.a(jSONObject, "link", vipShowInfo.link);
            qoc.a(jSONObject, "title", vipShowInfo.title);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
