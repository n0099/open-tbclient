package com.baidu.tieba.homepage.personalize.model;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.card.data.r;
import java.util.HashMap;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes2.dex */
public class b {
    public static void a(DataRes.Builder builder, List<i> list) {
        bT(list);
        b(builder, list);
    }

    public static void bT(List<i> list) {
        if (list != null) {
            int F = v.F(list);
            for (int i = 0; i < F; i++) {
                i iVar = (i) v.f(list, i);
                if (iVar instanceof r) {
                    ((r) iVar).eD(true);
                }
                i iVar2 = (i) v.f(list, i + 1);
                if ((iVar instanceof r) && (iVar2 instanceof r)) {
                    r rVar = (r) iVar;
                    r rVar2 = (r) iVar2;
                    if (rVar.ajP()) {
                        rVar2.eD(false);
                        if (rVar2 instanceof com.baidu.tieba.homepage.personalize.b.c) {
                            rVar.eE(false);
                        }
                    }
                }
                if (iVar instanceof com.baidu.tieba.homepage.personalize.b.c) {
                    if ((iVar2 instanceof r) || (iVar2 instanceof h)) {
                        ((com.baidu.tieba.homepage.personalize.b.c) iVar).eE(true);
                    } else {
                        ((com.baidu.tieba.homepage.personalize.b.c) iVar).eE(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<i> list) {
        com.baidu.tieba.card.data.c cVar;
        be VW;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    hashMap.put(threadPersonalized2.tid, threadPersonalized2);
                }
            }
            int F = v.F(list);
            for (int i = 0; i < F; i++) {
                i iVar = (i) v.f(list, i);
                if ((iVar instanceof com.baidu.tieba.card.data.c) && (VW = (cVar = (com.baidu.tieba.card.data.c) iVar).VW()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(Long.valueOf(com.baidu.adp.lib.g.b.c(VW.getTid(), 0L)))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.jX(threadPersonalized.abtest_tag);
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            sparseArray.put(dislikeReason.dislike_id.intValue(), dislikeReason.dislike_reason);
                        }
                        cVar.aLZ = sparseArray;
                        cVar.jZ(threadPersonalized.extra);
                    }
                }
            }
        }
    }
}
