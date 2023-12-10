package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes6.dex */
public class h0d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumHeadlineImgInfo forumHeadlineImgInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumHeadlineImgInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "thread_id", forumHeadlineImgInfo.thread_id);
            ltc.a(jSONObject, "thread_user_name", forumHeadlineImgInfo.thread_user_name);
            ltc.a(jSONObject, "img_user_name", forumHeadlineImgInfo.img_user_name);
            ltc.a(jSONObject, BigdayActivityConfig.IMG_URL, forumHeadlineImgInfo.img_url);
            ltc.a(jSONObject, "thread_user_id", forumHeadlineImgInfo.thread_user_id);
            ltc.a(jSONObject, "img_user_id", forumHeadlineImgInfo.img_user_id);
            ltc.a(jSONObject, "headline_url", forumHeadlineImgInfo.headline_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
