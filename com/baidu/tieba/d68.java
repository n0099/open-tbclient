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
public class d68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<bn> list) {
        ro6 ro6Var;
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
                bn bnVar = (bn) ListUtils.getItem(list, i);
                if ((bnVar instanceof ro6) && (threadData = (ro6Var = (ro6) bnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(JavaTypesHelper.toLong(threadData.getTid(), 0L))) != null) {
                    ro6Var.C(threadPersonalized.source);
                    ro6Var.F(threadPersonalized.weight);
                    ro6Var.x(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        ro6Var.z(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        ro6Var.feedBackReasonMap = sparseArray;
                        ro6Var.y(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List<bn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            bn bnVar = (bn) ListUtils.getItem(list, i);
            boolean z = bnVar instanceof fp6;
            if (z) {
                ((fp6) bnVar).j(true);
            }
            i++;
            bn bnVar2 = (bn) ListUtils.getItem(list, i);
            if (z && (bnVar2 instanceof fp6)) {
                fp6 fp6Var = (fp6) bnVar;
                fp6 fp6Var2 = (fp6) bnVar2;
                if (fp6Var.s()) {
                    fp6Var2.j(false);
                    if (fp6Var2 instanceof k68) {
                        fp6Var.J(false);
                    }
                }
            }
            if (bnVar instanceof k68) {
                ((k68) bnVar).J(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
