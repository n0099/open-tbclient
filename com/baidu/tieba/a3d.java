package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.WorldCupLottery;
/* loaded from: classes5.dex */
public class a3d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WorldCupLottery worldCupLottery) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, worldCupLottery)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "url", worldCupLottery.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
