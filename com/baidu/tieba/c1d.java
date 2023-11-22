package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PbPresentList;
/* loaded from: classes5.dex */
public class c1d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PbPresentList pbPresentList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pbPresentList)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "gift_id", pbPresentList.gift_id);
            qoc.a(jSONObject, "gift_name", pbPresentList.gift_name);
            qoc.a(jSONObject, "thumbnail_url", pbPresentList.thumbnail_url);
            qoc.a(jSONObject, "num", pbPresentList.num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
