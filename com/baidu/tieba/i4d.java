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
public class i4d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TaskInfo taskInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, taskInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "task_id", taskInfo.task_id);
            qoc.a(jSONObject, "thread_id", taskInfo.thread_id);
            qoc.a(jSONObject, "bgimg", taskInfo.bgimg);
            qoc.a(jSONObject, "thread_img", taskInfo.thread_img);
            qoc.a(jSONObject, "start_time", taskInfo.start_time);
            qoc.a(jSONObject, "end_time", taskInfo.end_time);
            qoc.a(jSONObject, "thread_img_size", taskInfo.thread_img_size);
            qoc.a(jSONObject, "forum_id", taskInfo.forum_id);
            qoc.a(jSONObject, "forum_name", taskInfo.forum_name);
            qoc.a(jSONObject, "obj_id", taskInfo.obj_id);
            VoteSchema voteSchema = taskInfo.vote_schema;
            if (voteSchema != null) {
                qoc.a(jSONObject, "vote_schema", h6d.b(voteSchema));
            }
            RewardCard rewardCard = taskInfo.reward_card;
            if (rewardCard != null) {
                qoc.a(jSONObject, "reward_card", p2d.b(rewardCard));
            }
            qoc.a(jSONObject, "is_god_reply", taskInfo.is_god_reply);
            qoc.a(jSONObject, "floor_god_reply", taskInfo.floor_god_reply);
            qoc.a(jSONObject, "card_type", taskInfo.card_type);
            qoc.a(jSONObject, "wh_rate", taskInfo.wh_rate);
            qoc.a(jSONObject, "webview_url", taskInfo.webview_url);
            qoc.a(jSONObject, "top_background_img", taskInfo.top_background_img);
            qoc.a(jSONObject, "theme_color", taskInfo.theme_color);
            qoc.a(jSONObject, "webview_data", taskInfo.webview_data);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
