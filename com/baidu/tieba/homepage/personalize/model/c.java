package com.baidu.tieba.homepage.personalize.model;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.card.data.r;
import java.util.HashMap;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes.dex */
public class c {
    public static void a(DataRes.Builder builder, List<v> list) {
        bi(list);
        b(builder, list);
    }

    public static void bi(List<v> list) {
        if (list != null) {
            int s = z.s(list);
            for (int i = 0; i < s; i++) {
                v vVar = (v) z.c(list, i);
                if (vVar instanceof r) {
                    ((r) vVar).dw(true);
                }
                v vVar2 = (v) z.c(list, i + 1);
                if ((vVar instanceof r) && (vVar2 instanceof r)) {
                    r rVar = (r) vVar;
                    r rVar2 = (r) vVar2;
                    if (rVar.VX()) {
                        rVar2.dw(false);
                        if (rVar2 instanceof com.baidu.tieba.homepage.personalize.c.e) {
                            rVar.dx(false);
                        }
                    }
                }
                if (vVar instanceof com.baidu.tieba.homepage.personalize.c.e) {
                    if ((vVar2 instanceof r) || (vVar2 instanceof h)) {
                        ((com.baidu.tieba.homepage.personalize.c.e) vVar).dx(true);
                    } else {
                        ((com.baidu.tieba.homepage.personalize.c.e) vVar).dx(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<v> list) {
        com.baidu.tieba.card.data.c cVar;
        bm Mv;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    hashMap.put(threadPersonalized2.tid, threadPersonalized2);
                }
            }
            int s = z.s(list);
            for (int i = 0; i < s; i++) {
                v vVar = (v) z.c(list, i);
                if ((vVar instanceof com.baidu.tieba.card.data.c) && (Mv = (cVar = (com.baidu.tieba.card.data.c) vVar).Mv()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(Long.valueOf(com.baidu.adp.lib.g.b.c(Mv.getTid(), 0L)))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.iN(threadPersonalized.abtest_tag);
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            sparseArray.put(dislikeReason.dislike_id.intValue(), dislikeReason.dislike_reason);
                        }
                        cVar.Wh = sparseArray;
                    }
                }
            }
        }
    }
}
