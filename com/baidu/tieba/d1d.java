package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.PeiwanInfo;
import tbclient.ThreadRecommendTag;
import tbclient.Voice;
/* loaded from: classes5.dex */
public class d1d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PeiwanInfo peiwanInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, peiwanInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "room_status", peiwanInfo.room_status);
            qoc.a(jSONObject, "room_status_text", peiwanInfo.room_status_text);
            Voice voice = peiwanInfo.voice;
            if (voice != null) {
                qoc.a(jSONObject, "voice", f6d.b(voice));
            }
            if (peiwanInfo.tag_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadRecommendTag threadRecommendTag : peiwanInfo.tag_list) {
                    jSONArray.put(y4d.b(threadRecommendTag));
                }
                qoc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_LIST, jSONArray);
            }
            qoc.a(jSONObject, "scheme", peiwanInfo.scheme);
            qoc.a(jSONObject, "extension_info", peiwanInfo.extension_info);
            qoc.a(jSONObject, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, peiwanInfo.cover);
            qoc.a(jSONObject, "room_id", peiwanInfo.room_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
