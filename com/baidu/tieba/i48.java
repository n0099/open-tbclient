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
/* loaded from: classes6.dex */
public class i48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<ym> list) {
        kn6 kn6Var;
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
                ym ymVar = (ym) ListUtils.getItem(list, i);
                if ((ymVar instanceof kn6) && (threadData = (kn6Var = (kn6) ymVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(JavaTypesHelper.toLong(threadData.getTid(), 0L))) != null) {
                    kn6Var.C(threadPersonalized.source);
                    kn6Var.F(threadPersonalized.weight);
                    kn6Var.x(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        kn6Var.z(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        kn6Var.feedBackReasonMap = sparseArray;
                        kn6Var.y(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List<ym> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, list) != null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            ym ymVar = (ym) ListUtils.getItem(list, i);
            boolean z = ymVar instanceof yn6;
            if (z) {
                ((yn6) ymVar).j(true);
            }
            i++;
            ym ymVar2 = (ym) ListUtils.getItem(list, i);
            if (z && (ymVar2 instanceof yn6)) {
                yn6 yn6Var = (yn6) ymVar;
                yn6 yn6Var2 = (yn6) ymVar2;
                if (yn6Var.s()) {
                    yn6Var2.j(false);
                    if (yn6Var2 instanceof p48) {
                        yn6Var.J(false);
                    }
                }
            }
            if (ymVar instanceof p48) {
                ((p48) ymVar).J(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<ym> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
