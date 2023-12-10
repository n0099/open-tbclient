package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ForumHeadIcon;
/* loaded from: classes6.dex */
public class g0d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumHeadIcon forumHeadIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumHeadIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "grade", forumHeadIcon.grade);
            ltc.a(jSONObject, "url", forumHeadIcon.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
