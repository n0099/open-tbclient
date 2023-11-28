package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Agree;
import tbclient.Lbs;
import tbclient.PbContent;
import tbclient.SubPostList;
import tbclient.User;
/* loaded from: classes5.dex */
public class c9d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SubPostList subPostList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, subPostList)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "id", subPostList.id);
            if (subPostList.content != null) {
                JSONArray jSONArray = new JSONArray();
                for (PbContent pbContent : subPostList.content) {
                    jSONArray.put(a6d.b(pbContent));
                }
                ltc.a(jSONObject, "content", jSONArray);
            }
            ltc.a(jSONObject, "time", subPostList.time);
            ltc.a(jSONObject, "author_id", subPostList.author_id);
            ltc.a(jSONObject, "title", subPostList.title);
            ltc.a(jSONObject, "floor", subPostList.floor);
            User user = subPostList.author;
            if (user != null) {
                ltc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, qad.b(user));
            }
            ltc.a(jSONObject, "is_giftpost", subPostList.is_giftpost);
            Agree agree = subPostList.agree;
            if (agree != null) {
                ltc.a(jSONObject, "agree", cuc.b(agree));
            }
            Lbs lbs = subPostList.location;
            if (lbs != null) {
                ltc.a(jSONObject, "location", p4d.b(lbs));
            }
            ltc.a(jSONObject, "is_fake_top", subPostList.is_fake_top);
            ltc.a(jSONObject, "is_author_view", subPostList.is_author_view);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
