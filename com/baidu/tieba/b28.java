package com.baidu.tieba;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes5.dex */
public class b28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<yh> list) {
        jk6 jk6Var;
        ThreadData threadData;
        ThreadPersonalized threadPersonalized;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, builder, list) == null) && builder != null && list != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
                }
            }
            int count = ListUtils.getCount(list);
            for (int i = 0; i < count; i++) {
                yh yhVar = (yh) ListUtils.getItem(list, i);
                if ((yhVar instanceof jk6) && (threadData = (jk6Var = (jk6) yhVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(JavaTypesHelper.toLong(threadData.getTid(), 0L))) != null) {
                    jk6Var.C(threadPersonalized.source);
                    jk6Var.F(threadPersonalized.weight);
                    jk6Var.x(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        jk6Var.z(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        jk6Var.feedBackReasonMap = sparseArray;
                        jk6Var.y(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List<yh> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            yh yhVar = (yh) ListUtils.getItem(list, i);
            boolean z = yhVar instanceof yk6;
            if (z) {
                ((yk6) yhVar).j(true);
            }
            i++;
            yh yhVar2 = (yh) ListUtils.getItem(list, i);
            if (z && (yhVar2 instanceof yk6)) {
                yk6 yk6Var = (yk6) yhVar;
                yk6 yk6Var2 = (yk6) yhVar2;
                if (yk6Var.s()) {
                    yk6Var2.j(false);
                    if (yk6Var2 instanceof i28) {
                        yk6Var.J(false);
                    }
                }
            }
            if (yhVar instanceof i28) {
                ((i28) yhVar).J(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<yh> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
