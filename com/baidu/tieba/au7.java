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
public class au7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<in> list) {
        qi6 qi6Var;
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
                in inVar = (in) ListUtils.getItem(list, i);
                if ((inVar instanceof qi6) && (threadData = (qi6Var = (qi6) inVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(gg.g(threadData.getTid(), 0L))) != null) {
                    qi6Var.C(threadPersonalized.source);
                    qi6Var.G(threadPersonalized.weight);
                    qi6Var.y(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        qi6Var.A(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        qi6Var.feedBackReasonMap = sparseArray;
                        qi6Var.z(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List<in> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            in inVar = (in) ListUtils.getItem(list, i);
            boolean z = inVar instanceof ej6;
            if (z) {
                ((ej6) inVar).i(true);
            }
            i++;
            in inVar2 = (in) ListUtils.getItem(list, i);
            if (z && (inVar2 instanceof ej6)) {
                ej6 ej6Var = (ej6) inVar;
                ej6 ej6Var2 = (ej6) inVar2;
                if (ej6Var.w()) {
                    ej6Var2.i(false);
                    if (ej6Var2 instanceof gu7) {
                        ej6Var.O(false);
                    }
                }
            }
            if (inVar instanceof gu7) {
                ((gu7) inVar).O(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<in> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
