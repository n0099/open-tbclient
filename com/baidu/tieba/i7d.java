package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Ranking;
import tbclient.RankingParam;
/* loaded from: classes6.dex */
public class i7d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Ranking ranking) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ranking)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "name", ranking.name);
            ltc.a(jSONObject, "rank_num", ranking.rank_num);
            RankingParam rankingParam = ranking.ranking_param;
            if (rankingParam != null) {
                ltc.a(jSONObject, "ranking_param", j7d.b(rankingParam));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
