package com.baidu.tieba.homepage.personalize.model;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes22.dex */
public class b {
    public static void a(DataRes.Builder builder, List<q> list) {
        dx(list);
        b(builder, list);
    }

    public static void dx(List<q> list) {
        if (list != null) {
            int count = y.getCount(list);
            for (int i = 0; i < count; i++) {
                q qVar = (q) y.getItem(list, i);
                if (qVar instanceof com.baidu.tieba.card.data.q) {
                    ((com.baidu.tieba.card.data.q) qVar).oa(true);
                }
                q qVar2 = (q) y.getItem(list, i + 1);
                if ((qVar instanceof com.baidu.tieba.card.data.q) && (qVar2 instanceof com.baidu.tieba.card.data.q)) {
                    com.baidu.tieba.card.data.q qVar3 = (com.baidu.tieba.card.data.q) qVar;
                    com.baidu.tieba.card.data.q qVar4 = (com.baidu.tieba.card.data.q) qVar2;
                    if (qVar3.cjc()) {
                        qVar4.oa(false);
                        if (qVar4 instanceof com.baidu.tieba.homepage.personalize.b.c) {
                            qVar3.ob(false);
                        }
                    }
                }
                if (qVar instanceof com.baidu.tieba.homepage.personalize.b.c) {
                    ((com.baidu.tieba.homepage.personalize.b.c) qVar).ob(false);
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<q> list) {
        com.baidu.tieba.card.data.c cVar;
        bw bfG;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
                }
            }
            int count = y.getCount(list);
            for (int i = 0; i < count; i++) {
                q qVar = (q) y.getItem(list, i);
                if ((qVar instanceof com.baidu.tieba.card.data.c) && (bfG = (cVar = (com.baidu.tieba.card.data.c) qVar).bfG()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.f.b.toLong(bfG.getTid(), 0L))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.Il(threadPersonalized.abtest_tag);
                    bfG.mRecomAbTag = threadPersonalized.abtest_tag;
                    bfG.mRecomSource = threadPersonalized.source;
                    bfG.mRecomWeight = threadPersonalized.weight;
                    if (bfG.biz() != null) {
                        cVar.n(bfG.biz().is_vertical);
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
