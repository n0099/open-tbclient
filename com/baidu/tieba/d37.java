package com.baidu.tieba;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes3.dex */
public class d37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List list) {
        w26 w26Var;
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
                eo eoVar = (eo) ListUtils.getItem(list, i);
                if ((eoVar instanceof w26) && (threadData = (w26Var = (w26) eoVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(eh.g(threadData.getTid(), 0L))) != null) {
                    w26Var.J(threadPersonalized.source);
                    w26Var.M(threadPersonalized.weight);
                    w26Var.F(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        w26Var.H(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        w26Var.feedBackReasonMap = sparseArray;
                        w26Var.G(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            eo eoVar = (eo) ListUtils.getItem(list, i);
            boolean z = eoVar instanceof k36;
            if (z) {
                ((k36) eoVar).d(true);
            }
            i++;
            eo eoVar2 = (eo) ListUtils.getItem(list, i);
            if (z && (eoVar2 instanceof k36)) {
                k36 k36Var = (k36) eoVar;
                k36 k36Var2 = (k36) eoVar2;
                if (k36Var.m()) {
                    k36Var2.d(false);
                    if (k36Var2 instanceof j37) {
                        k36Var.u(false);
                    }
                }
            }
            if (eoVar instanceof j37) {
                ((j37) eoVar).u(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
