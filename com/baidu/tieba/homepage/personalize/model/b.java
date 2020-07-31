package com.baidu.tieba.homepage.personalize.model;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.p;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes16.dex */
public class b {
    public static void a(DataRes.Builder builder, List<q> list) {
        df(list);
        b(builder, list);
    }

    public static void df(List<q> list) {
        if (list != null) {
            int count = x.getCount(list);
            for (int i = 0; i < count; i++) {
                q qVar = (q) x.getItem(list, i);
                if (qVar instanceof p) {
                    ((p) qVar).mK(true);
                }
                q qVar2 = (q) x.getItem(list, i + 1);
                if ((qVar instanceof p) && (qVar2 instanceof p)) {
                    p pVar = (p) qVar;
                    p pVar2 = (p) qVar2;
                    if (pVar.bSe()) {
                        pVar2.mK(false);
                        if (pVar2 instanceof com.baidu.tieba.homepage.personalize.b.c) {
                            pVar.mL(false);
                        }
                    }
                }
                if (qVar instanceof com.baidu.tieba.homepage.personalize.b.c) {
                    ((com.baidu.tieba.homepage.personalize.b.c) qVar).mL(false);
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<q> list) {
        com.baidu.tieba.card.data.c cVar;
        bv aTN;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
                }
            }
            int count = x.getCount(list);
            for (int i = 0; i < count; i++) {
                q qVar = (q) x.getItem(list, i);
                if ((qVar instanceof com.baidu.tieba.card.data.c) && (aTN = (cVar = (com.baidu.tieba.card.data.c) qVar).aTN()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.f.b.toLong(aTN.getTid(), 0L))) != null) {
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
