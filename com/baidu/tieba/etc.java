package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Agree;
import tbclient.FeedSocialComponent;
import tbclient.LayoutManageInfo;
/* loaded from: classes5.dex */
public class etc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedSocialComponent feedSocialComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedSocialComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            Agree agree = feedSocialComponent.agree;
            if (agree != null) {
                poc.a(jSONObject, "agree", gpc.b(agree));
            }
            poc.a(jSONObject, "comment_num", feedSocialComponent.comment_num);
            poc.a(jSONObject, "share_num", feedSocialComponent.share_num);
            poc.a(jSONObject, "tid", feedSocialComponent.tid);
            poc.a(jSONObject, "fid", feedSocialComponent.fid);
            if (feedSocialComponent.manage_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (LayoutManageInfo layoutManageInfo : feedSocialComponent.manage_list) {
                    jSONArray.put(kzc.b(layoutManageInfo));
                }
                poc.a(jSONObject, "manage_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
