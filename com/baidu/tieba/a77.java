package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class a77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final x67 a(List<z67> tabList, Map<String, String> businessInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tabList, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(tabList, "tabList");
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            try {
                String str = businessInfo.get("forum_id");
                vc7.b(str, null, 1, null);
                String str2 = businessInfo.get("thread_id");
                vc7.b(str2, null, 1, null);
                String str3 = businessInfo.get("from_tab_id");
                vc7.b(str3, null, 1, null);
                int parseInt = Integer.parseInt(str3);
                String str4 = businessInfo.get("from_tab_name");
                vc7.b(str4, null, 1, null);
                return new x67(str, str2, parseInt, str4, tabList);
            } catch (Exception unused) {
                return null;
            }
        }
        return (x67) invokeLL.objValue;
    }
}
