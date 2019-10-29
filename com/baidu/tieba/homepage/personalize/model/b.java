package com.baidu.tieba.homepage.personalize.model;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bh;
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
        cU(list);
        b(builder, list);
    }

    public static void cU(List<m> list) {
        if (list != null) {
            int count = v.getCount(list);
            for (int i = 0; i < count; i++) {
                m mVar = (m) v.getItem(list, i);
                if (mVar instanceof p) {
                    ((p) mVar).iN(true);
                }
                m mVar2 = (m) v.getItem(list, i + 1);
                if ((mVar instanceof p) && (mVar2 instanceof p)) {
                    p pVar = (p) mVar;
                    p pVar2 = (p) mVar2;
                    if (pVar.baM()) {
                        pVar2.iN(false);
                        if (pVar2 instanceof com.baidu.tieba.homepage.personalize.b.c) {
                            pVar.iO(false);
                        }
                    }
                }
                if (mVar instanceof com.baidu.tieba.homepage.personalize.b.c) {
                    if ((mVar2 instanceof p) || (mVar2 instanceof h)) {
                        ((com.baidu.tieba.homepage.personalize.b.c) mVar).iO(true);
                    } else {
                        ((com.baidu.tieba.homepage.personalize.b.c) mVar).iO(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<m> list) {
        com.baidu.tieba.card.data.c cVar;
        bh agI;
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
                if ((mVar instanceof com.baidu.tieba.card.data.c) && (agI = (cVar = (com.baidu.tieba.card.data.c) mVar).agI()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.g.b.toLong(agI.getTid(), 0L))) != null) {
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
