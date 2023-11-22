package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes6.dex */
public class hvc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumHeadlineImgInfo forumHeadlineImgInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumHeadlineImgInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "thread_id", forumHeadlineImgInfo.thread_id);
            qoc.a(jSONObject, "thread_user_name", forumHeadlineImgInfo.thread_user_name);
            qoc.a(jSONObject, "img_user_name", forumHeadlineImgInfo.img_user_name);
            qoc.a(jSONObject, BigdayActivityConfig.IMG_URL, forumHeadlineImgInfo.img_url);
            qoc.a(jSONObject, "thread_user_id", forumHeadlineImgInfo.thread_user_id);
            qoc.a(jSONObject, "img_user_id", forumHeadlineImgInfo.img_user_id);
            qoc.a(jSONObject, "headline_url", forumHeadlineImgInfo.headline_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
