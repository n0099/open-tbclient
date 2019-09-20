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
        cH(list);
        b(builder, list);
    }

    public static void cH(List<m> list) {
        if (list != null) {
            int Z = v.Z(list);
            for (int i = 0; i < Z; i++) {
                m mVar = (m) v.c(list, i);
                if (mVar instanceof p) {
                    ((p) mVar).iK(true);
                }
                m mVar2 = (m) v.c(list, i + 1);
                if ((mVar instanceof p) && (mVar2 instanceof p)) {
                    p pVar = (p) mVar;
                    p pVar2 = (p) mVar2;
                    if (pVar.baK()) {
                        pVar2.iK(false);
                        if (pVar2 instanceof com.baidu.tieba.homepage.personalize.b.c) {
                            pVar.iL(false);
                        }
                    }
                }
                if (mVar instanceof com.baidu.tieba.homepage.personalize.b.c) {
                    if ((mVar2 instanceof p) || (mVar2 instanceof h)) {
                        ((com.baidu.tieba.homepage.personalize.b.c) mVar).iL(true);
                    } else {
                        ((com.baidu.tieba.homepage.personalize.b.c) mVar).iL(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<m> list) {
        com.baidu.tieba.card.data.c cVar;
        bh acC;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            LongSparseArray longSparseArray = new LongSparseArray();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
                }
            }
            int Z = v.Z(list);
            for (int i = 0; i < Z; i++) {
                m mVar = (m) v.c(list, i);
                if ((mVar instanceof com.baidu.tieba.card.data.c) && (acC = (cVar = (com.baidu.tieba.card.data.c) mVar).acC()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(com.baidu.adp.lib.g.b.e(acC.getTid(), 0L))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.vY(threadPersonalized.abtest_tag);
                    acC.mRecomAbTag = threadPersonalized.abtest_tag;
                    acC.mRecomSource = threadPersonalized.source;
                    acC.mRecomWeight = threadPersonalized.weight;
                    if (acC.aeT() != null) {
                        cVar.d(acC.aeT().is_vertical);
                    }
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            sparseArray.put(dislikeReason.dislike_id.intValue(), dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                        }
                        cVar.bIk = sparseArray;
                        cVar.wa(threadPersonalized.extra);
                    }
                }
            }
        }
    }
}
