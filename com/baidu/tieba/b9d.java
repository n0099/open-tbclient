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
public class b9d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SubPostList subPostList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, subPostList)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "id", subPostList.id);
            if (subPostList.content != null) {
                JSONArray jSONArray = new JSONArray();
                for (PbContent pbContent : subPostList.content) {
                    jSONArray.put(z5d.b(pbContent));
                }
                ktc.a(jSONObject, "content", jSONArray);
            }
            ktc.a(jSONObject, "time", subPostList.time);
            ktc.a(jSONObject, "author_id", subPostList.author_id);
            ktc.a(jSONObject, "title", subPostList.title);
            ktc.a(jSONObject, "floor", subPostList.floor);
            User user = subPostList.author;
            if (user != null) {
                ktc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, pad.b(user));
            }
            ktc.a(jSONObject, "is_giftpost", subPostList.is_giftpost);
            Agree agree = subPostList.agree;
            if (agree != null) {
                ktc.a(jSONObject, "agree", buc.b(agree));
            }
            Lbs lbs = subPostList.location;
            if (lbs != null) {
                ktc.a(jSONObject, "location", o4d.b(lbs));
            }
            ktc.a(jSONObject, "is_fake_top", subPostList.is_fake_top);
            ktc.a(jSONObject, "is_author_view", subPostList.is_author_view);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
