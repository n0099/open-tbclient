package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class h67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final g67 a(Map<String, String> businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            try {
                String str = businessInfo.get("forum_id");
                vc7.b(str, null, 1, null);
                String str2 = businessInfo.get("forum_name");
                vc7.b(str2, null, 1, null);
                String str3 = businessInfo.get("thread_id");
                vc7.b(str3, null, 1, null);
                String str4 = businessInfo.get("mgr_user_id");
                vc7.b(str4, null, 1, null);
                String str5 = businessInfo.get("user_name");
                if (str5 == null) {
                    str5 = "";
                }
                String str6 = businessInfo.get("portrait");
                vc7.b(str6, null, 1, null);
                String str7 = businessInfo.get("user_name_show");
                vc7.b(str7, null, 1, null);
                return new g67(str, str2, str3, str4, str5, str6, str7);
            } catch (Exception unused) {
                return null;
            }
        }
        return (g67) invokeL.objValue;
    }
}
