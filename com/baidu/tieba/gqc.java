package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AlaLiveInfo;
import tbclient.BannerUserStory;
import tbclient.UserStory;
/* loaded from: classes6.dex */
public class gqc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BannerUserStory bannerUserStory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bannerUserStory)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (bannerUserStory.user_story != null) {
                JSONArray jSONArray = new JSONArray();
                for (UserStory userStory : bannerUserStory.user_story) {
                    jSONArray.put(r5d.b(userStory));
                }
                qoc.a(jSONObject, "user_story", jSONArray);
            }
            qoc.a(jSONObject, "switch", bannerUserStory._switch);
            if (bannerUserStory.ala_live_list != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (AlaLiveInfo alaLiveInfo : bannerUserStory.ala_live_list) {
                    jSONArray2.put(lpc.b(alaLiveInfo));
                }
                qoc.a(jSONObject, "ala_live_list", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
