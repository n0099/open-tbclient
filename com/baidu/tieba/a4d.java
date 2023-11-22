package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ActBtn;
import tbclient.DetailInfo;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class a4d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TPointPost tPointPost) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tPointPost)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "is_tuiguang", tPointPost.is_tuiguang);
            qoc.a(jSONObject, CriusAttrConstants.POSITION, tPointPost.position);
            qoc.a(jSONObject, "template_id", tPointPost.template_id);
            qoc.a(jSONObject, "template_type", tPointPost.template_type);
            if (tPointPost.act_btn != null) {
                JSONArray jSONArray = new JSONArray();
                for (ActBtn actBtn : tPointPost.act_btn) {
                    jSONArray.put(uoc.b(actBtn));
                }
                qoc.a(jSONObject, "act_btn", jSONArray);
            }
            if (tPointPost.t_imgs != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Timgs timgs : tPointPost.t_imgs) {
                    jSONArray2.put(c5d.b(timgs));
                }
                qoc.a(jSONObject, "t_imgs", jSONArray2);
            }
            DetailInfo detailInfo = tPointPost.detail_info;
            if (detailInfo != null) {
                qoc.a(jSONObject, "detail_info", prc.b(detailInfo));
            }
            qoc.a(jSONObject, "monitor_id", tPointPost.monitor_id);
            qoc.a(jSONObject, "hidden_day", tPointPost.hidden_day);
            VideoInfo videoInfo = tPointPost.t_video;
            if (videoInfo != null) {
                qoc.a(jSONObject, "t_video", z5d.b(videoInfo));
            }
            qoc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_NAME, tPointPost.tag_name);
            qoc.a(jSONObject, "tag_name_url", tPointPost.tag_name_url);
            qoc.a(jSONObject, "tag_name_wh", tPointPost.tag_name_wh);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
