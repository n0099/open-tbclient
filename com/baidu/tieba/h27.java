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
public class h27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<Cdo> list) {
        c26 c26Var;
        ThreadData threadData;
        ThreadPersonalized threadPersonalized;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, builder, list) == null) || builder == null || list == null) {
            return;
        }
        LongSparseArray longSparseArray = new LongSparseArray();
        for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
            if (threadPersonalized2 != null) {
                longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
            }
        }
        int count = ListUtils.getCount(list);
        for (int i = 0; i < count; i++) {
            Cdo cdo = (Cdo) ListUtils.getItem(list, i);
            if ((cdo instanceof c26) && (threadData = (c26Var = (c26) cdo).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(dh.g(threadData.getTid(), 0L))) != null) {
                c26Var.J(threadPersonalized.source);
                c26Var.M(threadPersonalized.weight);
                c26Var.F(threadPersonalized.abtest_tag);
                threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                threadData.mRecomSource = threadPersonalized.source;
                threadData.mRecomWeight = threadPersonalized.weight;
                if (threadData.getThreadVideoInfo() != null) {
                    c26Var.H(threadData.getThreadVideoInfo().is_vertical);
                }
                List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                if (list2 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list2) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    c26Var.feedBackReasonMap = sparseArray;
                    c26Var.G(threadPersonalized.extra);
                }
            }
        }
    }

    public static void b(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            Cdo cdo = (Cdo) ListUtils.getItem(list, i);
            boolean z = cdo instanceof q26;
            if (z) {
                ((q26) cdo).d(true);
            }
            i++;
            Cdo cdo2 = (Cdo) ListUtils.getItem(list, i);
            if (z && (cdo2 instanceof q26)) {
                q26 q26Var = (q26) cdo;
                q26 q26Var2 = (q26) cdo2;
                if (q26Var.m()) {
                    q26Var2.d(false);
                    if (q26Var2 instanceof n27) {
                        q26Var.u(false);
                    }
                }
            }
            if (cdo instanceof n27) {
                ((n27) cdo).u(false);
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
