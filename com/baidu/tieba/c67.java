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
/* loaded from: classes3.dex */
public class c67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(List<ThreadPersonalized> list, List<Cdo> list2) {
        p26 p26Var;
        ThreadData threadData;
        ThreadPersonalized threadPersonalized;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, list, list2) == null) || list == null || list2 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (ThreadPersonalized threadPersonalized2 : list) {
            if (threadPersonalized2 != null) {
                hashMap.put(String.valueOf(threadPersonalized2.tid), threadPersonalized2);
            }
        }
        int count = ListUtils.getCount(list2);
        for (int i = 0; i < count; i++) {
            Cdo cdo = (Cdo) ListUtils.getItem(list2, i);
            if ((cdo instanceof p26) && (threadData = (p26Var = (p26) cdo).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(threadData.getTid())) != null) {
                p26Var.J(threadPersonalized.source);
                p26Var.M(threadPersonalized.weight);
                p26Var.F(threadPersonalized.abtest_tag);
                threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                threadData.mRecomSource = threadPersonalized.source;
                threadData.mRecomWeight = threadPersonalized.weight;
                if (threadData.getThreadVideoInfo() != null) {
                    p26Var.H(threadData.getThreadVideoInfo().is_vertical);
                }
                List<DislikeReason> list3 = threadPersonalized.dislike_resource;
                if (list3 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list3) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    p26Var.feedBackReasonMap = sparseArray;
                    p26Var.G(threadPersonalized.extra);
                }
            }
        }
    }

    public static void b(List<ThreadPersonalized> list, List<Cdo> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, list, list2) == null) {
            a(list, list2);
        }
    }
}
