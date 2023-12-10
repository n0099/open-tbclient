package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PbPresentList;
/* loaded from: classes5.dex */
public class f6d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PbPresentList pbPresentList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pbPresentList)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "gift_id", pbPresentList.gift_id);
            ltc.a(jSONObject, "gift_name", pbPresentList.gift_name);
            ltc.a(jSONObject, "thumbnail_url", pbPresentList.thumbnail_url);
            ltc.a(jSONObject, "num", pbPresentList.num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
