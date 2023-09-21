package com.baidu.tieba;

import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThreadRecommendInfo;
/* loaded from: classes6.dex */
public final class ib7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(ThreadRecommendInfo threadRecommendInfo, List<yc7<? extends Object>> mutableList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, threadRecommendInfo, mutableList) == null) {
            Intrinsics.checkNotNullParameter(threadRecommendInfo, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            mutableList.add(new r77(b(threadRecommendInfo)));
        }
    }

    public static final ThreadRecommendInfoData b(ThreadRecommendInfo threadRecommendInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, threadRecommendInfo)) == null) {
            Intrinsics.checkNotNullParameter(threadRecommendInfo, "<this>");
            ThreadRecommendInfoData threadRecommendInfoData = new ThreadRecommendInfoData();
            threadRecommendInfoData.parseProto(threadRecommendInfo);
            return threadRecommendInfoData;
        }
        return (ThreadRecommendInfoData) invokeL.objValue;
    }
}
