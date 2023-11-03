package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.RankingParam;
/* loaded from: classes5.dex */
public class f2d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RankingParam rankingParam) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, rankingParam)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "rank_type", rankingParam.rank_type);
            poc.a(jSONObject, "rank_code", rankingParam.rank_code);
            poc.a(jSONObject, "sort_type", rankingParam.sort_type);
            poc.a(jSONObject, "tab_id", rankingParam.tab_id);
            poc.a(jSONObject, "pn", rankingParam.pn);
            poc.a(jSONObject, "rn", rankingParam.rn);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
