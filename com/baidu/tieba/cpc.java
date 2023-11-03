package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AdMixFloor;
/* loaded from: classes5.dex */
public class cpc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AdMixFloor adMixFloor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adMixFloor)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, TiebaStatic.Params.AD_TYPE, adMixFloor.ad_type);
            poc.a(jSONObject, "floor_num", adMixFloor.floor_num);
            poc.a(jSONObject, LegoListActivityConfig.AD_ID, adMixFloor.ad_id);
            poc.a(jSONObject, "advertise_id", adMixFloor.advertise_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
