package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ChatroomSignInfo;
import tbclient.FrsPage.SignForum;
import tbclient.FrsPage.SignInfo;
import tbclient.FrsPage.SignUser;
/* loaded from: classes5.dex */
public class a2d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SignInfo signInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            SignUser signUser = signInfo.user_info;
            if (signUser != null) {
                ltc.a(jSONObject, SourceConstant.SOURCE_USER_INFO, b2d.b(signUser));
            }
            SignForum signForum = signInfo.forum_info;
            if (signForum != null) {
                ltc.a(jSONObject, "forum_info", z1d.b(signForum));
            }
            ltc.a(jSONObject, "has_chatroom_sign", signInfo.has_chatroom_sign);
            ChatroomSignInfo chatroomSignInfo = signInfo.chatroom_sign_info;
            if (chatroomSignInfo != null) {
                ltc.a(jSONObject, "chatroom_sign_info", zvc.b(chatroomSignInfo));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
