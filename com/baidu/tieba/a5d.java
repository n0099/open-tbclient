package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TiebaPlusAd;
/* loaded from: classes5.dex */
public class a5d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TiebaPlusAd tiebaPlusAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tiebaPlusAd)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "cost_url", tiebaPlusAd.cost_url);
            qoc.a(jSONObject, "show_url", tiebaPlusAd.show_url);
            qoc.a(jSONObject, "ad_source", tiebaPlusAd.ad_source);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
