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
public class cyc extends ktc {
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
                ktc.a(jSONObject, "agree", buc.b(agree));
            }
            ktc.a(jSONObject, "comment_num", feedSocialComponent.comment_num);
            ktc.a(jSONObject, "share_num", feedSocialComponent.share_num);
            ktc.a(jSONObject, "tid", feedSocialComponent.tid);
            ktc.a(jSONObject, "fid", feedSocialComponent.fid);
            if (feedSocialComponent.manage_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (LayoutManageInfo layoutManageInfo : feedSocialComponent.manage_list) {
                    jSONArray.put(n4d.b(layoutManageInfo));
                }
                ktc.a(jSONObject, "manage_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
