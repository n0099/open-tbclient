package com.baidu.tieba.homepage.personalize.model;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.p;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes9.dex */
public class b {
    public static void a(DataRes.Builder builder, List<m> list) {
        cQ(list);
        b(builder, list);
    }

    public static void cQ(List<m> list) {
        if (list != null) {
            int count = v.getCount(list);
            for (int i = 0; i < count; i++) {
                m mVar = (m) v.getItem(list, i);
                if (mVar instanceof p) {
                    ((p) mVar).lA(true);
                }
                m mVar2 = (m) v.getItem(list, i + 1);
                if ((mVar instanceof p) && (mVar2 instanceof p)) {
                    p pVar = (p) mVar;
                    p pVar2 = (p) mVar2;
                    if (pVar.bFm()) {
                        pVar2.lA(false);
                        if (pVar2 instanceof com.baidu.tieba.homepage.personalize.b.c) {
                            pVar.lB(false);
                        }
                    }
                }
                if (mVar instanceof com.baidu.tieba.homepage.personalize.b.c) {
                    ((com.baidu.tieba.homepage.personalize.b.c) mVar).lB(false);
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<m> list) {
        com.baidu.tieba.card.data.c cVar;
        bj aIu;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
                }
            }
            int count = v.getCount(list);
            for (int i = 0; i < count; i++) {
                m mVar = (m) v.getItem(list, i);
                if ((mVar instanceof com.baidu.tieba.card.data.c) && (aIu = (cVar = (com.baidu.tieba.card.data.c) mVar).aIu()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.f.b.toLong(aIu.getTid(), 0L))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.BG(threadPersonalized.abtest_tag);
                    aIu.mRecomAbTag = threadPersonalized.abtest_tag;
                    aIu.mRecomSource = threadPersonalized.source;
                    aIu.mRecomWeight = threadPersonalized.weight;
                    if (aIu.aKT() != null) {
                        cVar.j(aIu.aKT().is_vertical);
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
