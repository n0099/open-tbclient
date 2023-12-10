package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedRoomComponent;
import tbclient.ThreadRecommendTag;
import tbclient.Voice;
/* loaded from: classes5.dex */
public class cyc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedRoomComponent feedRoomComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedRoomComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "top_label", feedRoomComponent.top_label);
            ltc.a(jSONObject, "status", feedRoomComponent.status);
            Voice voice = feedRoomComponent.voice;
            if (voice != null) {
                ltc.a(jSONObject, "voice", jbd.b(voice));
            }
            if (feedRoomComponent.bottom_labels != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadRecommendTag threadRecommendTag : feedRoomComponent.bottom_labels) {
                    jSONArray.put(bad.b(threadRecommendTag));
                }
                ltc.a(jSONObject, "bottom_labels", jSONArray);
            }
            ltc.a(jSONObject, "scheme", feedRoomComponent.scheme);
            ltc.a(jSONObject, NetDiskFileMsg.NetDiskFile.JSON_KEY_COVER_URL, feedRoomComponent.cover_url);
            ltc.a(jSONObject, "room_id", feedRoomComponent.room_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
