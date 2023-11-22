package com.baidu.tieba;

import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThreadRecommendInfo;
/* loaded from: classes6.dex */
public final class g97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(ThreadRecommendInfo threadRecommendInfo, List<ab7<? extends Object>> mutableList, a67 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, threadRecommendInfo, mutableList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(threadRecommendInfo, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            mutableList.add(new bb7(new e47(b(threadRecommendInfo), feedExtraData.a().a(), feedExtraData.c().a(), null, 8, null), "recommend_info"));
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
