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
public class f6d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PeiwanInfo peiwanInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, peiwanInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "room_status", peiwanInfo.room_status);
            ktc.a(jSONObject, "room_status_text", peiwanInfo.room_status_text);
            Voice voice = peiwanInfo.voice;
            if (voice != null) {
                ktc.a(jSONObject, "voice", ibd.b(voice));
            }
            if (peiwanInfo.tag_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadRecommendTag threadRecommendTag : peiwanInfo.tag_list) {
                    jSONArray.put(aad.b(threadRecommendTag));
                }
                ktc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_LIST, jSONArray);
            }
            ktc.a(jSONObject, "scheme", peiwanInfo.scheme);
            ktc.a(jSONObject, "extension_info", peiwanInfo.extension_info);
            ktc.a(jSONObject, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, peiwanInfo.cover);
            ktc.a(jSONObject, "room_id", peiwanInfo.room_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
