package com.baidu.tieba.homepage.gamevideo.d;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.c;
import java.util.List;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.DislikeReason;
import tbclient.RecomVertical.ThreadPersonalized;
/* loaded from: classes16.dex */
public class a {
    public static void a(DataRes dataRes, List<q> list) {
        b(dataRes, list);
    }

    private static void b(DataRes dataRes, List<q> list) {
        c cVar;
        bv aTN;
        ThreadPersonalized threadPersonalized;
        if (dataRes != null && list != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            for (ThreadPersonalized threadPersonalized2 : dataRes.thread_personalized) {
                if (threadPersonalized2 != null) {
                    longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
                }
            }
            int count = x.getCount(list);
            for (int i = 0; i < count; i++) {
                q qVar = (q) x.getItem(list, i);
                if ((qVar instanceof c) && (aTN = (cVar = (c) qVar).aTN()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.f.b.toLong(aTN.getTid(), 0L))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.EB(threadPersonalized.abtest_tag);
                    aTN.mRecomAbTag = threadPersonalized.abtest_tag;
                    aTN.mRecomSource = threadPersonalized.source;
                    aTN.mRecomWeight = threadPersonalized.weight;
                    if (aTN.aWD() != null) {
                        cVar.k(aTN.aWD().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            sparseArray.put(dislikeReason.dislike_id.intValue(), dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        cVar.feedBackReasonMap = sparseArray;
                        cVar.setExtra(threadPersonalized.extra);
                    }
                }
            }
        }
    }
}
