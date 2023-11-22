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
public class fxc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarRank starRank) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starRank)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "rank_name", starRank.rank_name);
            qoc.a(jSONObject, "rank_ranking", starRank.rank_ranking);
            if (starRank.contri_record_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (StarContriRecord starContriRecord : starRank.contri_record_list) {
                    jSONArray.put(cxc.b(starContriRecord));
                }
                qoc.a(jSONObject, "contri_record_list", jSONArray);
            }
            qoc.a(jSONObject, "user_contri_score", starRank.user_contri_score);
            qoc.a(jSONObject, "user_task_notice", starRank.user_task_notice);
            if (starRank.user_task_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (StarTaskInfo starTaskInfo : starRank.user_task_info) {
                    jSONArray2.put(hxc.b(starTaskInfo));
                }
                qoc.a(jSONObject, "user_task_info", jSONArray2);
            }
            qoc.a(jSONObject, "user_current_score_notice", starRank.user_current_score_notice);
            qoc.a(jSONObject, "url", starRank.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
