package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.StarContriRecord;
import tbclient.FrsPage.StarRank;
import tbclient.FrsPage.StarTaskInfo;
/* loaded from: classes5.dex */
public class exc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarRank starRank) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starRank)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "rank_name", starRank.rank_name);
            poc.a(jSONObject, "rank_ranking", starRank.rank_ranking);
            if (starRank.contri_record_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (StarContriRecord starContriRecord : starRank.contri_record_list) {
                    jSONArray.put(bxc.b(starContriRecord));
                }
                poc.a(jSONObject, "contri_record_list", jSONArray);
            }
            poc.a(jSONObject, "user_contri_score", starRank.user_contri_score);
            poc.a(jSONObject, "user_task_notice", starRank.user_task_notice);
            if (starRank.user_task_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (StarTaskInfo starTaskInfo : starRank.user_task_info) {
                    jSONArray2.put(gxc.b(starTaskInfo));
                }
                poc.a(jSONObject, "user_task_info", jSONArray2);
            }
            poc.a(jSONObject, "user_current_score_notice", starRank.user_current_score_notice);
            poc.a(jSONObject, "url", starRank.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
