package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.User;
import tbclient.VoiceRoom;
/* loaded from: classes6.dex */
public class g6d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VoiceRoom voiceRoom) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, voiceRoom)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "room_id", voiceRoom.room_id);
            User user = voiceRoom.author;
            if (user != null) {
                qoc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, n5d.b(user));
            }
            if (voiceRoom.talker != null) {
                JSONArray jSONArray = new JSONArray();
                for (User user2 : voiceRoom.talker) {
                    jSONArray.put(n5d.b(user2));
                }
                qoc.a(jSONObject, "talker", jSONArray);
            }
            qoc.a(jSONObject, "joined_num", voiceRoom.joined_num);
            qoc.a(jSONObject, "talker_num", voiceRoom.talker_num);
            qoc.a(jSONObject, "status", voiceRoom.status);
            qoc.a(jSONObject, DpStatConstants.KEY_ROOM_NAME, voiceRoom.room_name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
