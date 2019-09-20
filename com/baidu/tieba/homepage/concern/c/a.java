package com.baidu.tieba.homepage.concern.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.homepage.personalize.model.c;
import com.baidu.tieba.homepage.personalize.model.d;
import java.util.LinkedList;
import java.util.List;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class a {
    private final c gfL = new c();

    public c a(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        int i2;
        if (i != 0 && i != 1) {
            return null;
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        if (builder2 == null) {
            builder2 = new DataRes.Builder();
        }
        b(builder);
        b(builder2);
        b(z, builder, builder2, i);
        LinkedList linkedList = new LinkedList();
        int i3 = 0;
        for (ConcernData concernData : builder.thread_info) {
            if (concernData != null) {
                bh bhVar = new bh();
                bhVar.dP(true);
                bhVar.a(concernData.thread_list);
                if ((k.X(bhVar) || l.X(bhVar)) && bhVar.getType() != bh.bKe) {
                    int[] agv = bhVar.agv();
                    k ar = d.ar(bhVar);
                    if (ar != null) {
                        ar.tid = bhVar.getTid();
                        ar.position = i3;
                        d.a(ar);
                    }
                    if (k.X(bhVar)) {
                        ar.vZ("1");
                    } else if (l.X(bhVar)) {
                        ar.vZ("2");
                    }
                    if (ar != null && ar.isValid()) {
                        linkedList.add(ar);
                    }
                    com.baidu.tieba.card.data.c aq = d.aq(bhVar);
                    if (aq != null) {
                        aq.tid = bhVar.getTid();
                        aq.position = i3;
                        if (aq instanceof k) {
                            if (bhVar.afA() == 1) {
                                d.b(aq);
                                aq.bJJ = agv[0];
                                aq.bJK = agv[1];
                            } else if (bhVar.afA() >= 2) {
                                d.c(aq);
                            } else {
                                d.d(aq);
                            }
                        } else if (aq instanceof l) {
                            d.e(aq);
                        }
                    }
                    if (k.X(bhVar)) {
                        aq.vZ("1");
                    } else if (l.X(bhVar)) {
                        aq.vZ("2");
                    }
                    if (aq != null && aq.isValid()) {
                        linkedList.add(aq);
                    }
                    k ar2 = d.ar(bhVar);
                    if (ar2 != null) {
                        ar2.tid = bhVar.getTid();
                        ar2.position = i3;
                        d.f(ar2);
                    }
                    if (k.X(bhVar)) {
                        ar2.vZ("1");
                    } else if (l.X(bhVar)) {
                        ar2.vZ("2");
                    }
                    if (ar2 != null && ar2.isValid()) {
                        linkedList.add(ar2);
                    }
                    if (concernData.thread_list.top_agree_post != null) {
                        k ar3 = d.ar(bhVar);
                        if (ar3 != null) {
                            ar3.tid = bhVar.getTid();
                            ar3.position = i3;
                            d.g(ar3);
                        }
                        if (k.X(bhVar)) {
                            ar3.vZ("1");
                        } else if (l.X(bhVar)) {
                            ar3.vZ("2");
                        }
                        if (ar3 != null && ar3.isValid()) {
                            linkedList.add(ar3);
                        }
                    }
                    k ar4 = d.ar(bhVar);
                    if (ar4 != null) {
                        ar4.tid = bhVar.getTid();
                        ar4.position = i3;
                        d.h(ar4);
                    }
                    if (bhVar.getType() == bh.bJM) {
                        ar4.vZ("1");
                    } else if (l.X(bhVar)) {
                        ar4.vZ("2");
                    }
                    if (ar4 != null && ar4.isValid()) {
                        linkedList.add(ar4);
                    }
                } else if (bhVar.isShareThread) {
                    k kVar = new k();
                    kVar.threadData = bhVar;
                    linkedList.add(kVar);
                } else if (l.X(bhVar)) {
                    l lVar = new l(bhVar);
                    lVar.tid = bhVar.getTid();
                    lVar.pO(concernData.source.intValue());
                    if (lVar.isValid()) {
                        linkedList.add(lVar);
                    }
                } else if (j.X(bhVar)) {
                    j jVar = new j(bhVar);
                    if (jVar != null) {
                        jVar.tid = bhVar.getTid();
                        jVar.vZ("3");
                    }
                    if (jVar != null && jVar.isValid()) {
                        linkedList.add(jVar);
                    }
                } else {
                    k kVar2 = new k();
                    kVar2.threadData = bhVar;
                    kVar2.vZ(kVar2.threadData.isLinkThread() ? "4" : "1");
                    kVar2.isLinkThread = false;
                    kVar2.pO(concernData.source.intValue());
                    if (kVar2.threadData != null && kVar2.isValid() && !StringUtils.isNull(kVar2.threadData.getId()) && !"0".equals(kVar2.threadData.getTid())) {
                        linkedList.add(kVar2);
                    }
                }
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            i3 = i2;
        }
        this.gfL.cSs = linkedList;
        return this.gfL;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder.thread_info != null && builder2.thread_info != null) {
            a(z, builder.thread_info, builder2.thread_info, i);
        }
    }

    private void a(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        if (list != null && list2 != null) {
            int Z = v.Z(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (concernData != null && concernData.thread_list.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                list.clear();
                for (int Z2 = v.Z(list2) - 1; Z2 >= 0; Z2--) {
                    ConcernData concernData2 = (ConcernData) v.c(list2, Z2);
                    if (concernData2 != null && concernData2.thread_list.tid != null) {
                        list.add(0, concernData2);
                    }
                }
            }
            this.gfL.gns = v.Z(list) - Z;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
