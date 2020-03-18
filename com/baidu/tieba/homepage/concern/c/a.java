package com.baidu.tieba.homepage.concern.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.e;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.homepage.concern.b.b;
import com.baidu.tieba.homepage.personalize.model.c;
import com.baidu.tieba.homepage.personalize.model.d;
import java.util.LinkedList;
import java.util.List;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes9.dex */
public class a {
    private final c gZK = new c();

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
            if (concernData == null) {
                i2 = i3;
            } else if (b.a(concernData)) {
                b bVar = new b();
                if (concernData.recom_user_list.size() >= 4) {
                    bVar.bK(concernData.recom_user_list);
                    bVar.position = i3;
                    bVar.mE(builder.thread_info.size() > 1);
                    linkedList.add(bVar);
                    i3++;
                }
            } else {
                bj bjVar = new bj();
                bjVar.fF(true);
                bjVar.a(concernData.thread_list);
                if ((k.ab(bjVar) || l.ab(bjVar)) && bjVar.getType() != bj.cRR) {
                    int[] imageWidthAndHeight = bjVar.getImageWidthAndHeight();
                    k aB = d.aB(bjVar);
                    if (aB != null) {
                        aB.tid = bjVar.getTid();
                        aB.position = i3;
                        d.a(aB);
                    }
                    if (k.ab(bjVar)) {
                        aB.zX("1");
                    } else if (l.ab(bjVar)) {
                        aB.zX("2");
                    }
                    if (aB != null && aB.isValid()) {
                        linkedList.add(aB);
                    }
                    com.baidu.tieba.card.data.c aA = d.aA(bjVar);
                    if (aA != null) {
                        aA.tid = bjVar.getTid();
                        aA.position = i3;
                        if (aA instanceof k) {
                            if (bjVar.aEk()) {
                                d.d(aA);
                            } else if (bjVar.aDu() == 1) {
                                d.b(aA);
                                aA.cRu = imageWidthAndHeight[0];
                                aA.cRv = imageWidthAndHeight[1];
                            } else if (bjVar.aDu() >= 2) {
                                d.c(aA);
                            } else {
                                d.e(aA);
                            }
                        } else if (aA instanceof l) {
                            d.f(aA);
                        }
                    }
                    if (k.ab(bjVar)) {
                        aA.zX("1");
                    } else if (l.ab(bjVar)) {
                        aA.zX("2");
                    }
                    if (aA != null && aA.isValid()) {
                        linkedList.add(aA);
                    }
                    k aB2 = d.aB(bjVar);
                    if (aB2 != null) {
                        aB2.tid = bjVar.getTid();
                        aB2.position = i3;
                        d.g(aB2);
                    }
                    if (k.ab(bjVar)) {
                        aB2.zX("1");
                    } else if (l.ab(bjVar)) {
                        aB2.zX("2");
                    }
                    if (aB2 != null && !StringUtils.isNull(bjVar.aCw())) {
                        linkedList.add(aB2);
                    }
                    if (concernData.thread_list != null && concernData.thread_list.top_agree_post != null) {
                        k aB3 = d.aB(bjVar);
                        if (aB3 != null) {
                            aB3.tid = bjVar.getTid();
                            aB3.position = i3;
                            d.i(aB3);
                        }
                        if (k.ab(bjVar)) {
                            aB3.zX("1");
                        } else if (l.ab(bjVar)) {
                            aB3.zX("2");
                        }
                        if (aB3 != null && aB3.isValid()) {
                            linkedList.add(aB3);
                        }
                    }
                    k aB4 = d.aB(bjVar);
                    if (aB4 != null) {
                        aB4.tid = bjVar.getTid();
                        aB4.position = i3;
                        d.j(aB4);
                    }
                    if (bjVar.getType() == bj.cRx) {
                        aB4.zX("1");
                    } else if (l.ab(bjVar)) {
                        aB4.zX("2");
                    }
                    if (aB4 != null && aB4.isValid()) {
                        linkedList.add(aB4);
                    }
                } else if (bjVar.isShareThread) {
                    k kVar = new k();
                    kVar.cRt = bjVar;
                    kVar.position = i3;
                    linkedList.add(kVar);
                } else if (l.ab(bjVar)) {
                    l lVar = new l(bjVar);
                    lVar.tid = bjVar.getTid();
                    lVar.rw(concernData.source.intValue());
                    if (lVar.isValid()) {
                        linkedList.add(lVar);
                    }
                } else if (j.ab(bjVar)) {
                    j jVar = new j(bjVar);
                    if (jVar != null) {
                        jVar.tid = bjVar.getTid();
                        jVar.zX("3");
                    }
                    if (jVar != null && jVar.isValid()) {
                        linkedList.add(jVar);
                    }
                } else if (e.ab(bjVar) && bjVar.aBg()) {
                    e eVar = new e(bjVar);
                    eVar.position = i3;
                    linkedList.add(eVar);
                } else {
                    k kVar2 = new k();
                    kVar2.cRt = bjVar;
                    kVar2.zX(kVar2.cRt.isLinkThread() ? "4" : "1");
                    kVar2.position = i3;
                    kVar2.isLinkThread = false;
                    kVar2.rw(concernData.source.intValue());
                    if (kVar2.cRt != null && kVar2.isValid() && !StringUtils.isNull(kVar2.cRt.getId()) && !"0".equals(kVar2.cRt.getTid())) {
                        linkedList.add(kVar2);
                    }
                }
                i2 = i3 + 1;
            }
            i3 = i2;
        }
        this.gZK.dTH = linkedList;
        return this.gZK;
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
                    if (concernData != null && b.a(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && concernData.thread_list != null && concernData.thread_list.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                list.clear();
                for (int count2 = v.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) v.getItem(list2, count2);
                    if (concernData2 != null && b.a(concernData2)) {
                        list.add(0, concernData2);
                    } else if (concernData2 != null && concernData2.thread_list != null && concernData2.thread_list.tid != null) {
                        list.add(0, concernData2);
                    }
                }
            }
            this.gZK.hgM = v.getCount(list) - count;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
