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
    private final c gdT = new c();

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
                if ((k.W(bhVar) || l.W(bhVar)) && bhVar.getType() != bh.bJG) {
                    int[] agr = bhVar.agr();
                    k aq = d.aq(bhVar);
                    if (aq != null) {
                        aq.tid = bhVar.getTid();
                        aq.position = i3;
                        d.a(aq);
                    }
                    if (k.W(bhVar)) {
                        aq.vA("1");
                    } else if (l.W(bhVar)) {
                        aq.vA("2");
                    }
                    if (aq != null && aq.isValid()) {
                        linkedList.add(aq);
                    }
                    com.baidu.tieba.card.data.c ap = d.ap(bhVar);
                    if (ap != null) {
                        ap.tid = bhVar.getTid();
                        ap.position = i3;
                        if (ap instanceof k) {
                            if (bhVar.afw() == 1) {
                                d.b(ap);
                                ap.bJl = agr[0];
                                ap.bJm = agr[1];
                            } else if (bhVar.afw() >= 2) {
                                d.c(ap);
                            } else {
                                d.d(ap);
                            }
                        } else if (ap instanceof l) {
                            d.e(ap);
                        }
                    }
                    if (k.W(bhVar)) {
                        ap.vA("1");
                    } else if (l.W(bhVar)) {
                        ap.vA("2");
                    }
                    if (ap != null && ap.isValid()) {
                        linkedList.add(ap);
                    }
                    k aq2 = d.aq(bhVar);
                    if (aq2 != null) {
                        aq2.tid = bhVar.getTid();
                        aq2.position = i3;
                        d.f(aq2);
                    }
                    if (k.W(bhVar)) {
                        aq2.vA("1");
                    } else if (l.W(bhVar)) {
                        aq2.vA("2");
                    }
                    if (aq2 != null && aq2.isValid()) {
                        linkedList.add(aq2);
                    }
                    if (concernData.thread_list.top_agree_post != null) {
                        k aq3 = d.aq(bhVar);
                        if (aq3 != null) {
                            aq3.tid = bhVar.getTid();
                            aq3.position = i3;
                            d.g(aq3);
                        }
                        if (k.W(bhVar)) {
                            aq3.vA("1");
                        } else if (l.W(bhVar)) {
                            aq3.vA("2");
                        }
                        if (aq3 != null && aq3.isValid()) {
                            linkedList.add(aq3);
                        }
                    }
                    k aq4 = d.aq(bhVar);
                    if (aq4 != null) {
                        aq4.tid = bhVar.getTid();
                        aq4.position = i3;
                        d.h(aq4);
                    }
                    if (bhVar.getType() == bh.bJo) {
                        aq4.vA("1");
                    } else if (l.W(bhVar)) {
                        aq4.vA("2");
                    }
                    if (aq4 != null && aq4.isValid()) {
                        linkedList.add(aq4);
                    }
                } else if (bhVar.isShareThread) {
                    k kVar = new k();
                    kVar.threadData = bhVar;
                    linkedList.add(kVar);
                } else if (l.W(bhVar)) {
                    l lVar = new l(bhVar);
                    lVar.tid = bhVar.getTid();
                    lVar.pK(concernData.source.intValue());
                    if (lVar.isValid()) {
                        linkedList.add(lVar);
                    }
                } else if (j.W(bhVar)) {
                    j jVar = new j(bhVar);
                    if (jVar != null) {
                        jVar.tid = bhVar.getTid();
                        jVar.vA("3");
                    }
                    if (jVar != null && jVar.isValid()) {
                        linkedList.add(jVar);
                    }
                } else {
                    k kVar2 = new k();
                    kVar2.threadData = bhVar;
                    kVar2.vA(kVar2.threadData.isLinkThread() ? "4" : "1");
                    kVar2.isLinkThread = false;
                    kVar2.pK(concernData.source.intValue());
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
        this.gdT.cRz = linkedList;
        return this.gdT;
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
            this.gdT.glA = v.Z(list) - Z;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
