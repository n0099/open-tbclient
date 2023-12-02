package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.VipCloseAd;
/* loaded from: classes5.dex */
public class ebd extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VipCloseAd vipCloseAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, vipCloseAd)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "is_open", vipCloseAd.is_open);
            ktc.a(jSONObject, "vip_close", vipCloseAd.vip_close);
            if (vipCloseAd.forum_close != null) {
                JSONArray jSONArray = new JSONArray();
                for (Integer num : vipCloseAd.forum_close) {
                    jSONArray.put(num.intValue());
                }
                ktc.a(jSONObject, "forum_close", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
