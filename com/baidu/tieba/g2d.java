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
/* loaded from: classes6.dex */
public class g2d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarRank starRank) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starRank)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "rank_name", starRank.rank_name);
            ltc.a(jSONObject, "rank_ranking", starRank.rank_ranking);
            if (starRank.contri_record_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (StarContriRecord starContriRecord : starRank.contri_record_list) {
                    jSONArray.put(d2d.b(starContriRecord));
                }
                ltc.a(jSONObject, "contri_record_list", jSONArray);
            }
            ltc.a(jSONObject, "user_contri_score", starRank.user_contri_score);
            ltc.a(jSONObject, "user_task_notice", starRank.user_task_notice);
            if (starRank.user_task_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (StarTaskInfo starTaskInfo : starRank.user_task_info) {
                    jSONArray2.put(i2d.b(starTaskInfo));
                }
                ltc.a(jSONObject, "user_task_info", jSONArray2);
            }
            ltc.a(jSONObject, "user_current_score_notice", starRank.user_current_score_notice);
            ltc.a(jSONObject, "url", starRank.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
