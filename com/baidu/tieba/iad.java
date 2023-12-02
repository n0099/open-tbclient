package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.TogetherHi;
/* loaded from: classes6.dex */
public class iad extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TogetherHi togetherHi) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, togetherHi)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "album_name", togetherHi.album_name);
            ktc.a(jSONObject, GroupInfoData.SHARE_KEY_ALBUM_ID, togetherHi.album_id);
            ktc.a(jSONObject, "start_time", togetherHi.start_time);
            ktc.a(jSONObject, "end_time", togetherHi.end_time);
            ktc.a(jSONObject, "location", togetherHi.location);
            ktc.a(jSONObject, "num_signup", togetherHi.num_signup);
            if (togetherHi.potraits != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : togetherHi.potraits) {
                    jSONArray.put(str);
                }
                ktc.a(jSONObject, "potraits", jSONArray);
            }
            ktc.a(jSONObject, "num_join", togetherHi.num_join);
            if (togetherHi.pic_urls != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str2 : togetherHi.pic_urls) {
                    jSONArray2.put(str2);
                }
                ktc.a(jSONObject, "pic_urls", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
