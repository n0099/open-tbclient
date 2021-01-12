package com.baidu.tieba.homepage.gamevideo.d;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import java.util.List;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.DislikeReason;
import tbclient.RecomVertical.ThreadPersonalized;
/* loaded from: classes2.dex */
public class a {
    public static void a(DataRes dataRes, List<n> list) {
        b(dataRes, list);
    }

    private static void b(DataRes dataRes, List<n> list) {
        com.baidu.tieba.card.data.b bVar;
        bz bkV;
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
                n nVar = (n) x.getItem(list, i);
                if ((nVar instanceof com.baidu.tieba.card.data.b) && (bkV = (bVar = (com.baidu.tieba.card.data.b) nVar).bkV()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.f.b.toLong(bkV.getTid(), 0L))) != null) {
                    bVar.setSource(threadPersonalized.source);
                    bVar.setWeight(threadPersonalized.weight);
                    bVar.Ie(threadPersonalized.abtest_tag);
                    bkV.mRecomAbTag = threadPersonalized.abtest_tag;
                    bkV.mRecomSource = threadPersonalized.source;
                    bkV.mRecomWeight = threadPersonalized.weight;
                    if (bkV.bnO() != null) {
                        bVar.p(bkV.bnO().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            sparseArray.put(dislikeReason.dislike_id.intValue(), dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        bVar.feedBackReasonMap = sparseArray;
                        bVar.setExtra(threadPersonalized.extra);
                    }
                }
            }
        }
    }
}
