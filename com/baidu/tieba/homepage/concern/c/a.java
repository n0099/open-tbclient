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
    private final c gfi = new c();

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
                bhVar.ef(true);
                bhVar.a(concernData.thread_list);
                if ((k.V(bhVar) || l.V(bhVar)) && bhVar.getType() != bh.cbM) {
                    int[] imageWidthAndHeight = bhVar.getImageWidthAndHeight();
                    k ap = d.ap(bhVar);
                    if (ap != null) {
                        ap.tid = bhVar.getTid();
                        ap.position = i3;
                        d.a(ap);
                    }
                    if (k.V(bhVar)) {
                        ap.uC("1");
                    } else if (l.V(bhVar)) {
                        ap.uC("2");
                    }
                    if (ap != null && ap.isValid()) {
                        linkedList.add(ap);
                    }
                    com.baidu.tieba.card.data.c ao = d.ao(bhVar);
                    if (ao != null) {
                        ao.tid = bhVar.getTid();
                        ao.position = i3;
                        if (ao instanceof k) {
                            if (bhVar.ajE() == 1) {
                                d.b(ao);
                                ao.cbr = imageWidthAndHeight[0];
                                ao.cbs = imageWidthAndHeight[1];
                            } else if (bhVar.ajE() >= 2) {
                                d.c(ao);
                            } else {
                                d.d(ao);
                            }
                        } else if (ao instanceof l) {
                            d.e(ao);
                        }
                    }
                    if (k.V(bhVar)) {
                        ao.uC("1");
                    } else if (l.V(bhVar)) {
                        ao.uC("2");
                    }
                    if (ao != null && ao.isValid()) {
                        linkedList.add(ao);
                    }
                    k ap2 = d.ap(bhVar);
                    if (ap2 != null) {
                        ap2.tid = bhVar.getTid();
                        ap2.position = i3;
                        d.f(ap2);
                    }
                    if (k.V(bhVar)) {
                        ap2.uC("1");
                    } else if (l.V(bhVar)) {
                        ap2.uC("2");
                    }
                    if (ap2 != null && ap2.isValid()) {
                        linkedList.add(ap2);
                    }
                    if (concernData.thread_list.top_agree_post != null) {
                        k ap3 = d.ap(bhVar);
                        if (ap3 != null) {
                            ap3.tid = bhVar.getTid();
                            ap3.position = i3;
                            d.g(ap3);
                        }
                        if (k.V(bhVar)) {
                            ap3.uC("1");
                        } else if (l.V(bhVar)) {
                            ap3.uC("2");
                        }
                        if (ap3 != null && ap3.isValid()) {
                            linkedList.add(ap3);
                        }
                    }
                    k ap4 = d.ap(bhVar);
                    if (ap4 != null) {
                        ap4.tid = bhVar.getTid();
                        ap4.position = i3;
                        d.h(ap4);
                    }
                    if (bhVar.getType() == bh.cbu) {
                        ap4.uC("1");
                    } else if (l.V(bhVar)) {
                        ap4.uC("2");
                    }
                    if (ap4 != null && ap4.isValid()) {
                        linkedList.add(ap4);
                    }
                } else if (bhVar.isShareThread) {
                    k kVar = new k();
                    kVar.cbq = bhVar;
                    linkedList.add(kVar);
                } else if (l.V(bhVar)) {
                    l lVar = new l(bhVar);
                    lVar.tid = bhVar.getTid();
                    lVar.oQ(concernData.source.intValue());
                    if (lVar.isValid()) {
                        linkedList.add(lVar);
                    }
                } else if (j.V(bhVar)) {
                    j jVar = new j(bhVar);
                    if (jVar != null) {
                        jVar.tid = bhVar.getTid();
                        jVar.uC("3");
                    }
                    if (jVar != null && jVar.isValid()) {
                        linkedList.add(jVar);
                    }
                } else {
                    k kVar2 = new k();
                    kVar2.cbq = bhVar;
                    kVar2.uC(kVar2.cbq.isLinkThread() ? "4" : "1");
                    kVar2.isLinkThread = false;
                    kVar2.oQ(concernData.source.intValue());
                    if (kVar2.cbq != null && kVar2.isValid() && !StringUtils.isNull(kVar2.cbq.getId()) && !"0".equals(kVar2.cbq.getTid())) {
                        linkedList.add(kVar2);
                    }
                }
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            i3 = i2;
        }
        this.gfi.dbM = linkedList;
        return this.gfi;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder.thread_info != null && builder2.thread_info != null) {
            a(z, builder.thread_info, builder2.thread_info, i);
        }
    }

    private void a(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        if (list != null && list2 != null) {
            int count = v.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (concernData != null && concernData.thread_list.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                list.clear();
                for (int count2 = v.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) v.getItem(list2, count2);
                    if (concernData2 != null && concernData2.thread_list.tid != null) {
                        list.add(0, concernData2);
                    }
                }
            }
            this.gfi.gmR = v.getCount(list) - count;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
