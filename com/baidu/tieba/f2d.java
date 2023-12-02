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
public class f2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarRank starRank) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starRank)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "rank_name", starRank.rank_name);
            ktc.a(jSONObject, "rank_ranking", starRank.rank_ranking);
            if (starRank.contri_record_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (StarContriRecord starContriRecord : starRank.contri_record_list) {
                    jSONArray.put(c2d.b(starContriRecord));
                }
                ktc.a(jSONObject, "contri_record_list", jSONArray);
            }
            ktc.a(jSONObject, "user_contri_score", starRank.user_contri_score);
            ktc.a(jSONObject, "user_task_notice", starRank.user_task_notice);
            if (starRank.user_task_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (StarTaskInfo starTaskInfo : starRank.user_task_info) {
                    jSONArray2.put(h2d.b(starTaskInfo));
                }
                ktc.a(jSONObject, "user_task_info", jSONArray2);
            }
            ktc.a(jSONObject, "user_current_score_notice", starRank.user_current_score_notice);
            ktc.a(jSONObject, "url", starRank.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
