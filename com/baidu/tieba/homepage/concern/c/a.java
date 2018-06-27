package com.baidu.tieba.homepage.concern.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.homepage.personalize.model.c;
import java.util.LinkedList;
import java.util.List;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class a {
    private final c dRb = new c();

    public c a(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (i != 0 && i != 1) {
            return null;
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        if (builder2 == null) {
            builder2 = new DataRes.Builder();
        }
        c(builder);
        c(builder2);
        b(z, builder, builder2, i);
        LinkedList linkedList = new LinkedList();
        for (ConcernData concernData : builder.thread_info) {
            if (concernData != null) {
                bc bcVar = new bc();
                bcVar.a(concernData.thread_list);
                if (bcVar.isShareThread) {
                    k kVar = new k();
                    kVar.threadData = bcVar;
                    linkedList.add(kVar);
                } else if (l.P(bcVar)) {
                    l lVar = new l(bcVar);
                    lVar.tid = bcVar.getTid();
                    lVar.iM(concernData.source.intValue());
                    if (lVar.isValid()) {
                        linkedList.add(lVar);
                    }
                } else if (j.P(bcVar)) {
                    j jVar = new j(bcVar);
                    if (jVar != null) {
                        jVar.tid = bcVar.getTid();
                        jVar.lc("3");
                    }
                    if (jVar != null && jVar.isValid()) {
                        linkedList.add(jVar);
                    }
                } else {
                    k kVar2 = new k();
                    kVar2.threadData = bcVar;
                    kVar2.lc(kVar2.threadData.isLinkThread() ? "4" : "1");
                    kVar2.isLinkThread = false;
                    kVar2.iM(concernData.source.intValue());
                    if (kVar2.threadData != null && kVar2.isValid() && !StringUtils.isNull(kVar2.threadData.getId()) && !"0".equals(kVar2.threadData.getTid())) {
                        linkedList.add(kVar2);
                    }
                }
            }
        }
        this.dRb.bha = linkedList;
        return this.dRb;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder.thread_info != null && builder2.thread_info != null) {
            a(z, builder.thread_info, builder2.thread_info, i);
        }
    }

    private void a(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        if (list != null && list2 != null) {
            int z2 = w.z(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (concernData != null && concernData.thread_list.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                list.clear();
                for (int z3 = w.z(list2) - 1; z3 >= 0; z3--) {
                    ConcernData concernData2 = (ConcernData) w.d(list2, z3);
                    if (concernData2 != null && concernData2.thread_list.tid != null) {
                        list.add(0, concernData2);
                    }
                }
            }
            this.dRb.dVE = w.z(list) - z2;
        }
    }

    public static void c(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
