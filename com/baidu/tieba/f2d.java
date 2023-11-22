package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Ranking;
import tbclient.RankingParam;
/* loaded from: classes5.dex */
public class f2d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Ranking ranking) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ranking)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "name", ranking.name);
            qoc.a(jSONObject, "rank_num", ranking.rank_num);
            RankingParam rankingParam = ranking.ranking_param;
            if (rankingParam != null) {
                qoc.a(jSONObject, "ranking_param", g2d.b(rankingParam));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
