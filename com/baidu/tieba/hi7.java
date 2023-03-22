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
public class hi7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<gn> list) {
        sf6 sf6Var;
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
                gn gnVar = (gn) ListUtils.getItem(list, i);
                if ((gnVar instanceof sf6) && (threadData = (sf6Var = (sf6) gnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(gg.g(threadData.getTid(), 0L))) != null) {
                    sf6Var.F(threadPersonalized.source);
                    sf6Var.K(threadPersonalized.weight);
                    sf6Var.z(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        sf6Var.D(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        sf6Var.feedBackReasonMap = sparseArray;
                        sf6Var.C(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List<gn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            gn gnVar = (gn) ListUtils.getItem(list, i);
            boolean z = gnVar instanceof gg6;
            if (z) {
                ((gg6) gnVar).d(true);
            }
            i++;
            gn gnVar2 = (gn) ListUtils.getItem(list, i);
            if (z && (gnVar2 instanceof gg6)) {
                gg6 gg6Var = (gg6) gnVar;
                gg6 gg6Var2 = (gg6) gnVar2;
                if (gg6Var.q()) {
                    gg6Var2.d(false);
                    if (gg6Var2 instanceof ni7) {
                        gg6Var.H(false);
                    }
                }
            }
            if (gnVar instanceof ni7) {
                ((ni7) gnVar).H(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<gn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
