package com.baidu.tieba.homepage.personalize.c;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.s;
import java.util.HashMap;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes.dex */
public class c {
    public static void a(DataRes.Builder builder, List<v> list) {
        bx(list);
        b(builder, list);
    }

    public static void bx(List<v> list) {
        if (list != null) {
            int s = y.s(list);
            for (int i = 0; i < s; i++) {
                v vVar = (v) y.c(list, i);
                if (vVar instanceof s) {
                    ((s) vVar).ct(true);
                }
            }
            for (int i2 = 0; i2 < s; i2++) {
                v vVar2 = (v) y.c(list, i2);
                v vVar3 = (v) y.c(list, i2 + 1);
                if ((vVar2 instanceof s) && (vVar3 instanceof s)) {
                    s sVar = (s) vVar2;
                    s sVar2 = (s) vVar3;
                    if (sVar.Op()) {
                        sVar2.ct(false);
                        if (sVar2 instanceof com.baidu.tieba.homepage.personalize.d.e) {
                            sVar.cu(false);
                        }
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<v> list) {
        com.baidu.tieba.card.data.c cVar;
        bi Jv;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    hashMap.put(threadPersonalized2.tid, threadPersonalized2);
                }
            }
            int s = y.s(list);
            for (int i = 0; i < s; i++) {
                v vVar = (v) y.c(list, i);
                if ((vVar instanceof com.baidu.tieba.card.data.c) && (Jv = (cVar = (com.baidu.tieba.card.data.c) vVar).Jv()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(Long.valueOf(com.baidu.adp.lib.h.b.c(Jv.getTid(), 0L)))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.hR(threadPersonalized.abtest_tag);
                    List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                    if (list2 != null) {
                        SparseArray<String> sparseArray = new SparseArray<>();
                        for (DislikeReason dislikeReason : list2) {
                            sparseArray.put(dislikeReason.dislike_id.intValue(), dislikeReason.dislike_reason);
                        }
                        cVar.bbR = sparseArray;
                    }
                }
            }
        }
    }
}
