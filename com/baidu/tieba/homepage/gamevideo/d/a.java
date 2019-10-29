package com.baidu.tieba.homepage.gamevideo.d;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.c;
import java.util.List;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.DislikeReason;
import tbclient.RecomVertical.ThreadPersonalized;
/* loaded from: classes4.dex */
public class a {
    public static void a(DataRes dataRes, List<m> list) {
        b(dataRes, list);
    }

    private static void b(DataRes dataRes, List<m> list) {
        c cVar;
        bh agI;
        ThreadPersonalized threadPersonalized;
        if (dataRes != null && list != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            for (ThreadPersonalized threadPersonalized2 : dataRes.thread_personalized) {
                if (threadPersonalized2 != null) {
                    longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
                }
            }
            int count = v.getCount(list);
            for (int i = 0; i < count; i++) {
                m mVar = (m) v.getItem(list, i);
                if ((mVar instanceof c) && (agI = (cVar = (c) mVar).agI()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.g.b.toLong(agI.getTid(), 0L))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.uB(threadPersonalized.abtest_tag);
                    agI.mRecomAbTag = threadPersonalized.abtest_tag;
                    agI.mRecomSource = threadPersonalized.source;
                    agI.mRecomWeight = threadPersonalized.weight;
                    if (agI.aiX() != null) {
                        cVar.d(agI.aiX().is_vertical);
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
