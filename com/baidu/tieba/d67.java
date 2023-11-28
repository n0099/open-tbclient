package com.baidu.tieba;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class d67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final c67 a(List<e67> reasonList, Map<String, String> businessInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, reasonList, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(reasonList, "reasonList");
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            try {
                String str = businessInfo.get("forum_id");
                jd7.b(str, null, 1, null);
                String str2 = businessInfo.get("forum_name");
                jd7.b(str2, null, 1, null);
                String str3 = businessInfo.get("thread_id");
                jd7.b(str3, null, 1, null);
                String str4 = businessInfo.get("uid");
                jd7.b(str4, null, 1, null);
                String str5 = businessInfo.get("is_grays_cale_forum");
                jd7.b(str5, null, 1, null);
                int parseInt = Integer.parseInt(str5);
                String str6 = businessInfo.get("is_boomgrow");
                jd7.b(str6, null, 1, null);
                int parseInt2 = Integer.parseInt(str6);
                String str7 = businessInfo.get("has_forum_rule");
                jd7.b(str7, null, 1, null);
                int parseInt3 = Integer.parseInt(str7);
                String str8 = businessInfo.get("forum_head_url");
                if (str8 == null) {
                    str8 = "";
                }
                String str9 = businessInfo.get(IntentConfig.USER_LEVEL);
                jd7.b(str9, null, 1, null);
                int parseInt4 = Integer.parseInt(str9);
                String str10 = businessInfo.get("is_manager");
                jd7.b(str10, null, 1, null);
                int parseInt5 = Integer.parseInt(str10);
                String str11 = businessInfo.get("mask_delete");
                jd7.b(str11, null, 1, null);
                return new c67(str, str2, str3, str4, reasonList, parseInt, parseInt2, parseInt3, str8, parseInt4, parseInt5, str11);
            } catch (Exception unused) {
                return null;
            }
        }
        return (c67) invokeLL.objValue;
    }
}
