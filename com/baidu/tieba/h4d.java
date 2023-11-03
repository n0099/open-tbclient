package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.RewardCard;
import tbclient.TaskInfo;
import tbclient.VoteSchema;
/* loaded from: classes6.dex */
public class h4d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TaskInfo taskInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, taskInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "task_id", taskInfo.task_id);
            poc.a(jSONObject, "thread_id", taskInfo.thread_id);
            poc.a(jSONObject, "bgimg", taskInfo.bgimg);
            poc.a(jSONObject, "thread_img", taskInfo.thread_img);
            poc.a(jSONObject, "start_time", taskInfo.start_time);
            poc.a(jSONObject, "end_time", taskInfo.end_time);
            poc.a(jSONObject, "thread_img_size", taskInfo.thread_img_size);
            poc.a(jSONObject, "forum_id", taskInfo.forum_id);
            poc.a(jSONObject, "forum_name", taskInfo.forum_name);
            poc.a(jSONObject, "obj_id", taskInfo.obj_id);
            VoteSchema voteSchema = taskInfo.vote_schema;
            if (voteSchema != null) {
                poc.a(jSONObject, "vote_schema", g6d.b(voteSchema));
            }
            RewardCard rewardCard = taskInfo.reward_card;
            if (rewardCard != null) {
                poc.a(jSONObject, "reward_card", o2d.b(rewardCard));
            }
            poc.a(jSONObject, "is_god_reply", taskInfo.is_god_reply);
            poc.a(jSONObject, "floor_god_reply", taskInfo.floor_god_reply);
            poc.a(jSONObject, "card_type", taskInfo.card_type);
            poc.a(jSONObject, "wh_rate", taskInfo.wh_rate);
            poc.a(jSONObject, "webview_url", taskInfo.webview_url);
            poc.a(jSONObject, "top_background_img", taskInfo.top_background_img);
            poc.a(jSONObject, "theme_color", taskInfo.theme_color);
            poc.a(jSONObject, "webview_data", taskInfo.webview_data);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
