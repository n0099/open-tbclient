package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.TogetherHi;
/* loaded from: classes5.dex */
public class f5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TogetherHi togetherHi) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, togetherHi)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "album_name", togetherHi.album_name);
            poc.a(jSONObject, GroupInfoData.SHARE_KEY_ALBUM_ID, togetherHi.album_id);
            poc.a(jSONObject, "start_time", togetherHi.start_time);
            poc.a(jSONObject, "end_time", togetherHi.end_time);
            poc.a(jSONObject, "location", togetherHi.location);
            poc.a(jSONObject, "num_signup", togetherHi.num_signup);
            if (togetherHi.potraits != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : togetherHi.potraits) {
                    jSONArray.put(str);
                }
                poc.a(jSONObject, "potraits", jSONArray);
            }
            poc.a(jSONObject, "num_join", togetherHi.num_join);
            if (togetherHi.pic_urls != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str2 : togetherHi.pic_urls) {
                    jSONArray2.put(str2);
                }
                poc.a(jSONObject, "pic_urls", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
