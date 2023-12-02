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
/* loaded from: classes5.dex */
public class cvc extends ktc {
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
                    jSONArray.put(tad.b(userStory));
                }
                ktc.a(jSONObject, "user_story", jSONArray);
            }
            ktc.a(jSONObject, "switch", bannerUserStory._switch);
            if (bannerUserStory.ala_live_list != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (AlaLiveInfo alaLiveInfo : bannerUserStory.ala_live_list) {
                    jSONArray2.put(huc.b(alaLiveInfo));
                }
                ktc.a(jSONObject, "ala_live_list", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
