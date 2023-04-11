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
/* loaded from: classes4.dex */
public class es7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<hn> list) {
        eh6 eh6Var;
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
                hn hnVar = (hn) ListUtils.getItem(list, i);
                if ((hnVar instanceof eh6) && (threadData = (eh6Var = (eh6) hnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(gg.g(threadData.getTid(), 0L))) != null) {
                    eh6Var.F(threadPersonalized.source);
                    eh6Var.I(threadPersonalized.weight);
                    eh6Var.y(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        eh6Var.D(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        eh6Var.feedBackReasonMap = sparseArray;
                        eh6Var.A(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List<hn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            hn hnVar = (hn) ListUtils.getItem(list, i);
            boolean z = hnVar instanceof sh6;
            if (z) {
                ((sh6) hnVar).g(true);
            }
            i++;
            hn hnVar2 = (hn) ListUtils.getItem(list, i);
            if (z && (hnVar2 instanceof sh6)) {
                sh6 sh6Var = (sh6) hnVar;
                sh6 sh6Var2 = (sh6) hnVar2;
                if (sh6Var.t()) {
                    sh6Var2.g(false);
                    if (sh6Var2 instanceof ks7) {
                        sh6Var.J(false);
                    }
                }
            }
            if (hnVar instanceof ks7) {
                ((ks7) hnVar).J(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<hn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
