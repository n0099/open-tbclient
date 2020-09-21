package com.baidu.tieba.homepage.gamevideo.d;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.c;
import java.util.List;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.DislikeReason;
import tbclient.RecomVertical.ThreadPersonalized;
/* loaded from: classes21.dex */
public class a {
    public static void a(DataRes dataRes, List<q> list) {
        b(dataRes, list);
    }

    private static void b(DataRes dataRes, List<q> list) {
        c cVar;
        bw bcY;
        ThreadPersonalized threadPersonalized;
        if (dataRes != null && list != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            for (ThreadPersonalized threadPersonalized2 : dataRes.thread_personalized) {
                if (threadPersonalized2 != null) {
                    longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
                }
            }
            int count = y.getCount(list);
            for (int i = 0; i < count; i++) {
                q qVar = (q) y.getItem(list, i);
                if ((qVar instanceof c) && (bcY = (cVar = (c) qVar).bcY()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.f.b.toLong(bcY.getTid(), 0L))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.Hy(threadPersonalized.abtest_tag);
                    bcY.mRecomAbTag = threadPersonalized.abtest_tag;
                    bcY.mRecomSource = threadPersonalized.source;
                    bcY.mRecomWeight = threadPersonalized.weight;
                    if (bcY.bfQ() != null) {
                        cVar.l(bcY.bfQ().is_vertical);
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
