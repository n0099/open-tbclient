package com.baidu.tieba.homepage.personalize.model;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.card.data.p;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes4.dex */
public class b {
    public static void a(DataRes.Builder builder, List<m> list) {
        cy(list);
        b(builder, list);
    }

    public static void cy(List<m> list) {
        if (list != null) {
            int S = v.S(list);
            for (int i = 0; i < S; i++) {
                m mVar = (m) v.c(list, i);
                if (mVar instanceof p) {
                    ((p) mVar).hT(true);
                }
                m mVar2 = (m) v.c(list, i + 1);
                if ((mVar instanceof p) && (mVar2 instanceof p)) {
                    p pVar = (p) mVar;
                    p pVar2 = (p) mVar2;
                    if (pVar.aQT()) {
                        pVar2.hT(false);
                        if (pVar2 instanceof com.baidu.tieba.homepage.personalize.b.c) {
                            pVar.hU(false);
                        }
                    }
                }
                if (mVar instanceof com.baidu.tieba.homepage.personalize.b.c) {
                    if ((mVar2 instanceof p) || (mVar2 instanceof h)) {
                        ((com.baidu.tieba.homepage.personalize.b.c) mVar).hU(true);
                    } else {
                        ((com.baidu.tieba.homepage.personalize.b.c) mVar).hU(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<m> list) {
        com.baidu.tieba.card.data.c cVar;
        bg WO;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
                }
            }
            int S = v.S(list);
            for (int i = 0; i < S; i++) {
                m mVar = (m) v.c(list, i);
                if ((mVar instanceof com.baidu.tieba.card.data.c) && (WO = (cVar = (com.baidu.tieba.card.data.c) mVar).WO()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.g.b.d(WO.getTid(), 0L))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.tB(threadPersonalized.abtest_tag);
                    WO.mRecomAbTag = threadPersonalized.abtest_tag;
                    WO.mRecomSource = threadPersonalized.source;
                    WO.mRecomWeight = threadPersonalized.weight;
                    if (WO.Zf() != null) {
                        cVar.d(WO.Zf().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            sparseArray.put(dislikeReason.dislike_id.intValue(), dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        cVar.bzx = sparseArray;
                        cVar.tD(threadPersonalized.extra);
                    }
                }
            }
        }
    }
}
