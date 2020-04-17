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
    private final c hJA = new c();

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
                    bVar.bT(concernData.recom_user_list);
                    bVar.position = i3;
                    bVar.nI(builder.thread_info.size() > 1);
                    linkedList.add(bVar);
                    i3++;
                }
            } else {
                bj bjVar = new bj();
                bjVar.gC(true);
                bjVar.a(concernData.thread_list);
                if ((k.ab(bjVar) || l.ab(bjVar)) && bjVar.getType() != bj.dqZ) {
                    int[] imageWidthAndHeight = bjVar.getImageWidthAndHeight();
                    k aC = d.aC(bjVar);
                    if (aC != null) {
                        aC.tid = bjVar.getTid();
                        aC.position = i3;
                        d.a(aC);
                    }
                    if (k.ab(bjVar)) {
                        aC.BE("1");
                    } else if (l.ab(bjVar)) {
                        aC.BE("2");
                    }
                    if (aC != null && aC.isValid()) {
                        linkedList.add(aC);
                    }
                    com.baidu.tieba.card.data.c aB = d.aB(bjVar);
                    if (aB != null) {
                        aB.tid = bjVar.getTid();
                        aB.position = i3;
                        if (aB instanceof k) {
                            if (bjVar.aMy()) {
                                d.d(aB);
                            } else if (bjVar.aLH() == 1) {
                                d.b(aB);
                                aB.dqB = imageWidthAndHeight[0];
                                aB.dqC = imageWidthAndHeight[1];
                            } else if (bjVar.aLH() >= 2) {
                                d.c(aB);
                            } else {
                                d.e(aB);
                            }
                        } else if (aB instanceof l) {
                            d.f(aB);
                        }
                    }
                    if (k.ab(bjVar)) {
                        aB.BE("1");
                    } else if (l.ab(bjVar)) {
                        aB.BE("2");
                    }
                    if (aB != null && aB.isValid()) {
                        linkedList.add(aB);
                    }
                    k aC2 = d.aC(bjVar);
                    if (aC2 != null) {
                        aC2.tid = bjVar.getTid();
                        aC2.position = i3;
                        d.g(aC2);
                    }
                    if (k.ab(bjVar)) {
                        aC2.BE("1");
                    } else if (l.ab(bjVar)) {
                        aC2.BE("2");
                    }
                    if (aC2 != null && !StringUtils.isNull(bjVar.aKJ())) {
                        linkedList.add(aC2);
                    }
                    if (concernData.thread_list != null && concernData.thread_list.top_agree_post != null) {
                        k aC3 = d.aC(bjVar);
                        if (aC3 != null) {
                            aC3.tid = bjVar.getTid();
                            aC3.position = i3;
                            d.i(aC3);
                        }
                        if (k.ab(bjVar)) {
                            aC3.BE("1");
                        } else if (l.ab(bjVar)) {
                            aC3.BE("2");
                        }
                        if (aC3 != null && aC3.isValid()) {
                            linkedList.add(aC3);
                        }
                    }
                    k aC4 = d.aC(bjVar);
                    if (aC4 != null) {
                        aC4.tid = bjVar.getTid();
                        aC4.position = i3;
                        d.j(aC4);
                    }
                    if (bjVar.getType() == bj.dqE) {
                        aC4.BE("1");
                    } else if (l.ab(bjVar)) {
                        aC4.BE("2");
                    }
                    if (aC4 != null && aC4.isValid()) {
                        linkedList.add(aC4);
                    }
                } else if (bjVar.isShareThread) {
                    k kVar = new k();
                    kVar.dqA = bjVar;
                    kVar.position = i3;
                    linkedList.add(kVar);
                } else if (l.ab(bjVar)) {
                    l lVar = new l(bjVar);
                    lVar.tid = bjVar.getTid();
                    lVar.rO(concernData.source.intValue());
                    if (lVar.isValid()) {
                        linkedList.add(lVar);
                    }
                } else if (j.ab(bjVar)) {
                    j jVar = new j(bjVar);
                    if (jVar != null) {
                        jVar.tid = bjVar.getTid();
                        jVar.BE("3");
                    }
                    if (jVar != null && jVar.isValid()) {
                        linkedList.add(jVar);
                    }
                } else if (e.ab(bjVar) && bjVar.aJt()) {
                    e eVar = new e(bjVar);
                    eVar.position = i3;
                    linkedList.add(eVar);
                } else {
                    k kVar2 = new k();
                    kVar2.dqA = bjVar;
                    kVar2.BE(kVar2.dqA.isLinkThread() ? "4" : "1");
                    kVar2.position = i3;
                    kVar2.isLinkThread = false;
                    kVar2.rO(concernData.source.intValue());
                    if (kVar2.dqA != null && kVar2.isValid() && !StringUtils.isNull(kVar2.dqA.getId()) && !"0".equals(kVar2.dqA.getTid())) {
                        linkedList.add(kVar2);
                    }
                }
                i2 = i3 + 1;
            }
            i3 = i2;
        }
        this.hJA.etG = linkedList;
        return this.hJA;
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
            this.hJA.hQw = v.getCount(list) - count;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
