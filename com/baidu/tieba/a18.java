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
public class a18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<vn> list) {
        mo6 mo6Var;
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
                if ((vnVar instanceof mo6) && (threadData = (mo6Var = (mo6) vnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(tg.g(threadData.getTid(), 0L))) != null) {
                    mo6Var.D(threadPersonalized.source);
                    mo6Var.I(threadPersonalized.weight);
                    mo6Var.y(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        mo6Var.A(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        mo6Var.feedBackReasonMap = sparseArray;
                        mo6Var.z(threadPersonalized.extra);
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
            boolean z = vnVar instanceof ap6;
            if (z) {
                ((ap6) vnVar).g(true);
            }
            i++;
            vn vnVar2 = (vn) ListUtils.getItem(list, i);
            if (z && (vnVar2 instanceof ap6)) {
                ap6 ap6Var = (ap6) vnVar;
                ap6 ap6Var2 = (ap6) vnVar2;
                if (ap6Var.v()) {
                    ap6Var2.g(false);
                    if (ap6Var2 instanceof h18) {
                        ap6Var.N(false);
                    }
                }
            }
            if (vnVar instanceof h18) {
                ((h18) vnVar).N(false);
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
