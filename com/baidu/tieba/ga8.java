package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
import tbclient.RecomVideo.DislikeReason;
import tbclient.RecomVideo.ThreadPersonalized;
/* loaded from: classes6.dex */
public class ga8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(List<ThreadPersonalized> list, List<yn> list2) {
        cq6 cq6Var;
        ThreadData threadData;
        ThreadPersonalized threadPersonalized;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, list, list2) == null) && list != null && list2 != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : list) {
                if (threadPersonalized2 != null) {
                    hashMap.put(String.valueOf(threadPersonalized2.tid), threadPersonalized2);
                }
            }
            int count = ListUtils.getCount(list2);
            for (int i = 0; i < count; i++) {
                yn ynVar = (yn) ListUtils.getItem(list2, i);
                if ((ynVar instanceof cq6) && (threadData = (cq6Var = (cq6) ynVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(threadData.getTid())) != null) {
                    cq6Var.C(threadPersonalized.source);
                    cq6Var.H(threadPersonalized.weight);
                    cq6Var.y(threadPersonalized.abtest_tag);
                    threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                    threadData.mRecomSource = threadPersonalized.source;
                    threadData.mRecomWeight = threadPersonalized.weight;
                    if (threadData.getThreadVideoInfo() != null) {
                        cq6Var.A(threadData.getThreadVideoInfo().is_vertical);
                    }
                    List<DislikeReason> list3 = threadPersonalized.dislike_resource;
                    if (list3 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list3) {
                            int intValue = dislikeReason.dislike_id.intValue();
                            sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        cq6Var.feedBackReasonMap = sparseArray;
                        cq6Var.z(threadPersonalized.extra);
                    }
                }
            }
        }
    }

    public static void b(List<ThreadPersonalized> list, List<yn> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, list, list2) == null) {
            a(list, list2);
        }
    }
}
