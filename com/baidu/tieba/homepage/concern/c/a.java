package com.baidu.tieba.homepage.concern.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
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
    private final c inz = new c();

    public c a(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        int i2;
        k aC;
        k aC2;
        k aC3;
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
        e aOa = com.baidu.tbadk.a.a.c.aOa();
        int i3 = 0;
        for (ConcernData concernData : builder.thread_info) {
            if (concernData == null) {
                i2 = i3;
            } else if (b.a(concernData)) {
                b bVar = new b();
                if (concernData.recom_user_list.size() >= 4) {
                    bVar.aF(concernData.recom_user_list);
                    bVar.position = i3;
                    bVar.gV(builder.thread_info.size() > 1);
                    linkedList.add(bVar);
                    i3++;
                }
            } else {
                bu buVar = new bu();
                buVar.hd(true);
                com.baidu.tbadk.a.a.c.a(aOa, buVar);
                buVar.a(concernData.thread_list);
                if ((k.ad(buVar) || l.ad(buVar)) && buVar.getType() != bu.dLL) {
                    int[] imageWidthAndHeight = buVar.getImageWidthAndHeight();
                    k aC4 = d.aC(buVar);
                    if (aC4 != null) {
                        aC4.tid = buVar.getTid();
                        aC4.position = i3;
                        d.a(aC4);
                        if (k.ad(buVar)) {
                            aC4.DR("1");
                        } else if (l.ad(buVar)) {
                            aC4.DR("2");
                        }
                        if (aC4.isValid()) {
                            linkedList.add(aC4);
                        }
                    }
                    com.baidu.tieba.card.data.c aB = d.aB(buVar);
                    if (aB != null) {
                        aB.tid = buVar.getTid();
                        aB.position = i3;
                        aB.dLi.aRR();
                        if (aB instanceof k) {
                            if (buVar.aUl()) {
                                d.d(aB);
                            } else if (buVar.aTv() == 1) {
                                d.b(aB);
                                aB.dLj = imageWidthAndHeight[0];
                                aB.dLk = imageWidthAndHeight[1];
                            } else if (buVar.aTv() >= 2) {
                                d.c(aB);
                            } else {
                                d.e(aB);
                            }
                        } else if (aB instanceof l) {
                            d.f(aB);
                        }
                        if (k.ad(buVar)) {
                            aB.DR("1");
                        } else if (l.ad(buVar)) {
                            aB.DR("2");
                        }
                        if (aB.isValid()) {
                            linkedList.add(aB);
                        }
                    }
                    if (buVar.aUu() != null && (aC3 = d.aC(buVar)) != null) {
                        aC3.tid = buVar.getTid();
                        aC3.position = i3;
                        d.k(aC3);
                        if (k.ad(buVar)) {
                            aC3.DR("1");
                        } else if (l.ad(buVar)) {
                            aC3.DR("2");
                        }
                        linkedList.add(aC3);
                    }
                    if (!w.isEmpty(buVar.aUx()) && (aC2 = d.aC(buVar)) != null) {
                        aC2.tid = buVar.getTid();
                        aC2.position = i3;
                        if (w.getCount(buVar.aUx()) == 1) {
                            d.l(aC2);
                        } else {
                            d.m(aC2);
                        }
                        linkedList.add(aC2);
                    }
                    k aC5 = d.aC(buVar);
                    if (aC5 != null) {
                        aC5.tid = buVar.getTid();
                        aC5.position = i3;
                        d.g(aC5);
                        if (k.ad(buVar)) {
                            aC5.DR("1");
                        } else if (l.ad(buVar)) {
                            aC5.DR("2");
                        }
                        if (buVar.aPY() && !StringUtils.isNull(buVar.aSt())) {
                            linkedList.add(aC5);
                        } else if (buVar.aQa() && !StringUtils.isNull(buVar.aUr())) {
                            linkedList.add(aC5);
                        } else if (!StringUtils.isNull(buVar.aSt())) {
                            linkedList.add(aC5);
                        }
                    }
                    if (concernData.thread_list != null && concernData.thread_list.top_agree_post != null && (aC = d.aC(buVar)) != null) {
                        aC.tid = buVar.getTid();
                        aC.position = i3;
                        d.i(aC);
                        if (k.ad(buVar)) {
                            aC.DR("1");
                        } else if (l.ad(buVar)) {
                            aC.DR("2");
                        }
                        if (aC.isValid()) {
                            linkedList.add(aC);
                        }
                    }
                    k aC6 = d.aC(buVar);
                    if (aC6 != null) {
                        aC6.tid = buVar.getTid();
                        aC6.position = i3;
                        d.j(aC6);
                        if (buVar.getType() == bu.dLm) {
                            aC6.DR("1");
                        } else if (l.ad(buVar)) {
                            aC6.DR("2");
                        }
                        if (aC6.isValid()) {
                            linkedList.add(aC6);
                        }
                    }
                } else if (buVar.isShareThread) {
                    k kVar = new k();
                    kVar.dLi = buVar;
                    kVar.position = i3;
                    linkedList.add(kVar);
                } else if (l.ad(buVar)) {
                    l lVar = new l(buVar);
                    lVar.tid = buVar.getTid();
                    lVar.sS(concernData.source.intValue());
                    if (lVar.isValid()) {
                        linkedList.add(lVar);
                    }
                } else if (j.ad(buVar)) {
                    j jVar = new j(buVar);
                    jVar.tid = buVar.getTid();
                    jVar.DR("3");
                    if (jVar.isValid()) {
                        linkedList.add(jVar);
                    }
                } else if (com.baidu.tieba.card.data.e.ad(buVar) && buVar.aQX()) {
                    com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e(buVar);
                    eVar.position = i3;
                    linkedList.add(eVar);
                } else {
                    k kVar2 = new k();
                    kVar2.dLi = buVar;
                    kVar2.DR(kVar2.dLi.isLinkThread() ? "4" : "1");
                    kVar2.position = i3;
                    kVar2.isLinkThread = false;
                    kVar2.sS(concernData.source.intValue());
                    if (kVar2.dLi != null && kVar2.isValid() && !StringUtils.isNull(kVar2.dLi.getId()) && !"0".equals(kVar2.dLi.getTid())) {
                        linkedList.add(kVar2);
                    }
                }
                i2 = i3 + 1;
            }
            i3 = i2;
        }
        com.baidu.tbadk.a.a.c.a(aOa, linkedList);
        this.inz.eSH = linkedList;
        return this.inz;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder.thread_info != null && builder2.thread_info != null) {
            a(z, builder.thread_info, builder2.thread_info, i);
        }
    }

    private void a(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        if (list != null && list2 != null) {
            int count = w.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (b.a(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && concernData.thread_list != null && concernData.thread_list.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                list.clear();
                for (int count2 = w.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) w.getItem(list2, count2);
                    if (concernData2 != null && b.a(concernData2)) {
                        list.add(0, concernData2);
                    } else if (concernData2 != null && concernData2.thread_list != null && concernData2.thread_list.tid != null) {
                        list.add(0, concernData2);
                    }
                }
            }
            this.inz.ivl = w.getCount(list) - count;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
