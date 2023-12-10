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
/* loaded from: classes6.dex */
public class g6d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PeiwanInfo peiwanInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, peiwanInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "room_status", peiwanInfo.room_status);
            ltc.a(jSONObject, "room_status_text", peiwanInfo.room_status_text);
            Voice voice = peiwanInfo.voice;
            if (voice != null) {
                ltc.a(jSONObject, "voice", jbd.b(voice));
            }
            if (peiwanInfo.tag_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadRecommendTag threadRecommendTag : peiwanInfo.tag_list) {
                    jSONArray.put(bad.b(threadRecommendTag));
                }
                ltc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_LIST, jSONArray);
            }
            ltc.a(jSONObject, "scheme", peiwanInfo.scheme);
            ltc.a(jSONObject, "extension_info", peiwanInfo.extension_info);
            ltc.a(jSONObject, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, peiwanInfo.cover);
            ltc.a(jSONObject, "room_id", peiwanInfo.room_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
