package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Ranking;
import tbclient.RankingParam;
/* loaded from: classes5.dex */
public class e2d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Ranking ranking) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ranking)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "name", ranking.name);
            poc.a(jSONObject, "rank_num", ranking.rank_num);
            RankingParam rankingParam = ranking.ranking_param;
            if (rankingParam != null) {
                poc.a(jSONObject, "ranking_param", f2d.b(rankingParam));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
