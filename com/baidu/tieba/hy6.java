package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedKV;
/* loaded from: classes4.dex */
public final class hy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a(List<FeedKV> list, String key) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, list, key)) == null) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            for (FeedKV feedKV : list) {
                if (Intrinsics.areEqual(feedKV.key, key)) {
                    return feedKV.value;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}
