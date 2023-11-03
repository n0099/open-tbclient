package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.BannerThreadInfo;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class huc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BannerThreadInfo bannerThreadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bannerThreadInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ThreadInfo threadInfo = bannerThreadInfo.thread_info;
            if (threadInfo != null) {
                poc.a(jSONObject, "thread_info", u4d.b(threadInfo));
            }
            poc.a(jSONObject, "from", bannerThreadInfo.from);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
