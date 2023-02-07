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
public class ge7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<Cdo> list) {
        sd6 sd6Var;
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
                Cdo cdo = (Cdo) ListUtils.getItem(list, i);
                if ((cdo instanceof sd6) && (threadData = (sd6Var = (sd6) cdo).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(dh.g(threadData.getTid(), 0L))) != null) {
                    sd6Var.J(threadPersonalized.source);
                    sd6Var.M(threadPersonalized.weight);
                    sd6Var.D(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        sd6Var.H(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        sd6Var.feedBackReasonMap = sparseArray;
                        sd6Var.G(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            Cdo cdo = (Cdo) ListUtils.getItem(list, i);
            boolean z = cdo instanceof ge6;
            if (z) {
                ((ge6) cdo).d(true);
            }
            i++;
            Cdo cdo2 = (Cdo) ListUtils.getItem(list, i);
            if (z && (cdo2 instanceof ge6)) {
                ge6 ge6Var = (ge6) cdo;
                ge6 ge6Var2 = (ge6) cdo2;
                if (ge6Var.n()) {
                    ge6Var2.d(false);
                    if (ge6Var2 instanceof me7) {
                        ge6Var.A(false);
                    }
                }
            }
            if (cdo instanceof me7) {
                ((me7) cdo).A(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
