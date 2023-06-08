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
/* loaded from: classes5.dex */
public class c18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<vn> list) {
        oo6 oo6Var;
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
                vn vnVar = (vn) ListUtils.getItem(list, i);
                if ((vnVar instanceof oo6) && (threadData = (oo6Var = (oo6) vnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(tg.g(threadData.getTid(), 0L))) != null) {
                    oo6Var.D(threadPersonalized.source);
                    oo6Var.I(threadPersonalized.weight);
                    oo6Var.y(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        oo6Var.A(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        oo6Var.feedBackReasonMap = sparseArray;
                        oo6Var.z(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List<vn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            vn vnVar = (vn) ListUtils.getItem(list, i);
            boolean z = vnVar instanceof cp6;
            if (z) {
                ((cp6) vnVar).g(true);
            }
            i++;
            vn vnVar2 = (vn) ListUtils.getItem(list, i);
            if (z && (vnVar2 instanceof cp6)) {
                cp6 cp6Var = (cp6) vnVar;
                cp6 cp6Var2 = (cp6) vnVar2;
                if (cp6Var.v()) {
                    cp6Var2.g(false);
                    if (cp6Var2 instanceof j18) {
                        cp6Var.N(false);
                    }
                }
            }
            if (vnVar instanceof j18) {
                ((j18) vnVar).N(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<vn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
