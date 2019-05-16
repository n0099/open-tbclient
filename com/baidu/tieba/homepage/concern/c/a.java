package com.baidu.tieba.homepage.concern.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bg;
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
    private final c fYd = new c();

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
                bg bgVar = new bg();
                bgVar.dL(true);
                bgVar.a(concernData.thread_list);
                if ((k.V(bgVar) || l.V(bgVar)) && bgVar.getType() != bg.bIA) {
                    int[] afo = bgVar.afo();
                    k ap = d.ap(bgVar);
                    if (ap != null) {
                        ap.tid = bgVar.getTid();
                        ap.position = i3;
                        d.a(ap);
                    }
                    if (k.V(bgVar)) {
                        ap.uV("1");
                    } else if (l.V(bgVar)) {
                        ap.uV("2");
                    }
                    if (ap != null && ap.isValid()) {
                        linkedList.add(ap);
                    }
                    com.baidu.tieba.card.data.c ao = d.ao(bgVar);
                    if (ao != null) {
                        ao.tid = bgVar.getTid();
                        ao.position = i3;
                        if (ao instanceof k) {
                            if (bgVar.aet() == 1) {
                                d.b(ao);
                                ao.bIf = afo[0];
                                ao.bIg = afo[1];
                            } else if (bgVar.aet() >= 2) {
                                d.c(ao);
                            } else {
                                d.d(ao);
                            }
                        } else if (ao instanceof l) {
                            d.e(ao);
                        }
                    }
                    if (k.V(bgVar)) {
                        ao.uV("1");
                    } else if (l.V(bgVar)) {
                        ao.uV("2");
                    }
                    if (ao != null && ao.isValid()) {
                        linkedList.add(ao);
                    }
                    k ap2 = d.ap(bgVar);
                    if (ap2 != null) {
                        ap2.tid = bgVar.getTid();
                        ap2.position = i3;
                        d.f(ap2);
                    }
                    if (k.V(bgVar)) {
                        ap2.uV("1");
                    } else if (l.V(bgVar)) {
                        ap2.uV("2");
                    }
                    if (ap2 != null && ap2.isValid()) {
                        linkedList.add(ap2);
                    }
                    if (concernData.thread_list.top_agree_post != null) {
                        k ap3 = d.ap(bgVar);
                        if (ap3 != null) {
                            ap3.tid = bgVar.getTid();
                            ap3.position = i3;
                            d.g(ap3);
                        }
                        if (k.V(bgVar)) {
                            ap3.uV("1");
                        } else if (l.V(bgVar)) {
                            ap3.uV("2");
                        }
                        if (ap3 != null && ap3.isValid()) {
                            linkedList.add(ap3);
                        }
                    }
                    k ap4 = d.ap(bgVar);
                    if (ap4 != null) {
                        ap4.tid = bgVar.getTid();
                        ap4.position = i3;
                        d.h(ap4);
                    }
                    if (bgVar.getType() == bg.bIi) {
                        ap4.uV("1");
                    } else if (l.V(bgVar)) {
                        ap4.uV("2");
                    }
                    if (ap4 != null && ap4.isValid()) {
                        linkedList.add(ap4);
                    }
                } else if (bgVar.isShareThread) {
                    k kVar = new k();
                    kVar.threadData = bgVar;
                    linkedList.add(kVar);
                } else if (l.V(bgVar)) {
                    l lVar = new l(bgVar);
                    lVar.tid = bgVar.getTid();
                    lVar.pt(concernData.source.intValue());
                    if (lVar.isValid()) {
                        linkedList.add(lVar);
                    }
                } else if (j.V(bgVar)) {
                    j jVar = new j(bgVar);
                    if (jVar != null) {
                        jVar.tid = bgVar.getTid();
                        jVar.uV("3");
                    }
                    if (jVar != null && jVar.isValid()) {
                        linkedList.add(jVar);
                    }
                } else {
                    k kVar2 = new k();
                    kVar2.threadData = bgVar;
                    kVar2.uV(kVar2.threadData.isLinkThread() ? "4" : "1");
                    kVar2.isLinkThread = false;
                    kVar2.pt(concernData.source.intValue());
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
        this.fYd.cPV = linkedList;
        return this.fYd;
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
            this.fYd.gew = v.Z(list) - Z;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
