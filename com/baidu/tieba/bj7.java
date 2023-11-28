package com.baidu.tieba;

import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumInfo;
/* loaded from: classes5.dex */
public final class bj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final JSONObject a(ki7 ki7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ki7Var)) == null) {
            Intrinsics.checkNotNullParameter(ki7Var, "<this>");
            JSONObject jSONObject = new JSONObject();
            DataRes c = ki7Var.c();
            if (c != null) {
                DataRes.Builder builder = new DataRes.Builder(c);
                ForumInfo.Builder builder2 = new ForumInfo.Builder(builder.forum);
                builder2.banner_list = null;
                builder.forum = builder2.build(true);
                builder.thread_list = null;
                builder.page_data = null;
                builder.user_list = null;
                builder.nav_tab_info = null;
                try {
                    JSONObject b = xzc.b(builder.build(true));
                    Intrinsics.checkNotNullExpressionValue(b, "toJSON(data)");
                    return b;
                } catch (Exception e) {
                    TbLog hybridLog = HybridLog.getInstance();
                    hybridLog.e("BottomData", "frs接口数据转换失败：" + e);
                    return jSONObject;
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
