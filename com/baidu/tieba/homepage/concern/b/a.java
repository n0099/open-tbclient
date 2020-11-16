package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.e;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.homepage.personalize.model.c;
import java.util.LinkedList;
import java.util.List;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes21.dex */
public class a {
    private final c jyd = new c();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [com.baidu.tieba.card.data.l] */
    public c a(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        k kVar;
        boolean hadConcerned;
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
        int i2 = 0;
        for (ConcernData concernData : builder.thread_info) {
            if (concernData != null) {
                if (com.baidu.tieba.homepage.concern.a.c.a(builder.hot_recomforum, i2)) {
                    com.baidu.tieba.homepage.concern.a.c cVar = new com.baidu.tieba.homepage.concern.a.c();
                    if (cVar.dC(builder.hot_recomforum.tab_list)) {
                        cVar.position = i2;
                        linkedList.add(cVar);
                        i2++;
                    }
                }
                if (com.baidu.tieba.homepage.concern.a.a.a(concernData)) {
                    com.baidu.tieba.homepage.concern.a.a aVar = new com.baidu.tieba.homepage.concern.a.a();
                    if (concernData.recom_user_list.size() >= 4) {
                        aVar.bk(concernData.recom_user_list);
                        aVar.position = i2;
                        aVar.iM(builder.thread_info.size() > 1);
                        linkedList.add(aVar);
                        i2++;
                    }
                } else {
                    bx bxVar = new bx();
                    bxVar.iU(true);
                    com.baidu.tbadk.a.a.a.a(bxVar);
                    bxVar.a(concernData.thread_list);
                    if ((k.ad(bxVar) || l.ad(bxVar)) && bxVar.getType() != bx.eCt) {
                        if (l.ad(bxVar)) {
                            kVar = new l(bxVar);
                        } else {
                            k kVar2 = new k();
                            kVar2.isLinkThread = bxVar.isLinkThread();
                            kVar2.eBH = bxVar.bmH();
                            if (!bxVar.isLinkThread() && !bxVar.bmH()) {
                                kVar2.icy = bxVar.blF();
                            }
                            kVar2.evQ = bxVar;
                            kVar2.icz = true;
                            kVar = kVar2;
                        }
                        kVar.tid = bxVar.getTid();
                        if (k.ad(bxVar)) {
                            kVar.ID("1");
                        } else if (l.ad(bxVar)) {
                            kVar.ID("2");
                        }
                        kVar.ibP = true;
                        if (d.bhv() && kVar.bjd() != null && kVar.bjd().blC() != null) {
                            if (kVar.bjd().blC().hadConcerned() || az.x(bxVar)) {
                                com.baidu.tieba.homepage.personalize.model.d.a(kVar);
                            } else {
                                com.baidu.tieba.homepage.personalize.model.d.h(kVar);
                                com.baidu.tieba.homepage.personalize.model.d.aB(bxVar);
                            }
                        } else {
                            com.baidu.tieba.homepage.personalize.model.d.a(kVar);
                        }
                        kVar.evQ.ble();
                        if (kVar instanceof k) {
                            if (bxVar.bnz()) {
                                com.baidu.tieba.homepage.personalize.model.d.d(kVar);
                            } else if (bxVar.bmK() == 1) {
                                com.baidu.tieba.homepage.personalize.model.d.b(kVar);
                                int[] imageWidthAndHeight = bxVar.getImageWidthAndHeight();
                                kVar.eBO = imageWidthAndHeight[0];
                                kVar.eBP = imageWidthAndHeight[1];
                            } else if (bxVar.bmK() >= 2) {
                                com.baidu.tieba.homepage.personalize.model.d.c(kVar);
                            } else {
                                com.baidu.tieba.homepage.personalize.model.d.e(kVar);
                            }
                        } else if (kVar instanceof l) {
                            com.baidu.tieba.homepage.personalize.model.d.f(kVar);
                        }
                        if (bxVar.bnH() != null) {
                            com.baidu.tieba.homepage.personalize.model.d.k(kVar);
                        }
                        if (!y.isEmpty(bxVar.bnK()) || !y.isEmpty(bxVar.bnL())) {
                            if (y.getCount(bxVar.bnL()) + y.getCount(bxVar.bnK()) == 1) {
                                com.baidu.tieba.homepage.personalize.model.d.l(kVar);
                            } else {
                                com.baidu.tieba.homepage.personalize.model.d.m(kVar);
                            }
                        }
                        com.baidu.tieba.homepage.personalize.model.d.g(kVar);
                        if (concernData.thread_list != null && concernData.thread_list.top_agree_post != null) {
                            com.baidu.tieba.homepage.personalize.model.d.i(kVar);
                        }
                        com.baidu.tieba.homepage.personalize.model.d.j(kVar);
                        kVar.setSupportType(BaseCardInfo.SupportType.TOP);
                        kVar.position = i2;
                        linkedList.add(kVar);
                    } else {
                        if (d.bhv() && bxVar.bjd() != null && bxVar.bjd().blC() != null && !(hadConcerned = bxVar.bjd().blC().hadConcerned()) && (hadConcerned || !az.x(bxVar))) {
                            com.baidu.tieba.homepage.personalize.model.d.aB(bxVar);
                        }
                        if (bxVar.isShareThread) {
                            k kVar3 = new k();
                            kVar3.evQ = bxVar;
                            kVar3.position = i2;
                            linkedList.add(kVar3);
                        } else if (l.ad(bxVar)) {
                            l lVar = new l(bxVar);
                            lVar.tid = bxVar.getTid();
                            lVar.xI(concernData.source.intValue());
                            if (lVar.isValid()) {
                                linkedList.add(lVar);
                            }
                        } else if (j.ad(bxVar)) {
                            j jVar = new j(bxVar);
                            jVar.tid = bxVar.getTid();
                            jVar.ID("3");
                            if (jVar.isValid()) {
                                linkedList.add(jVar);
                            }
                        } else if (e.ad(bxVar) && bxVar.bkk()) {
                            e eVar = new e(bxVar);
                            eVar.position = i2;
                            linkedList.add(eVar);
                        } else {
                            k kVar4 = new k();
                            kVar4.evQ = bxVar;
                            kVar4.ID(kVar4.evQ.isLinkThread() ? "4" : "1");
                            kVar4.position = i2;
                            kVar4.isLinkThread = false;
                            kVar4.xI(concernData.source.intValue());
                            if (kVar4.evQ != null && kVar4.isValid() && !StringUtils.isNull(kVar4.evQ.getId()) && !"0".equals(kVar4.evQ.getTid())) {
                                linkedList.add(kVar4);
                            }
                        }
                    }
                    i2++;
                }
            }
        }
        com.baidu.tbadk.a.a.a.be(linkedList);
        this.jyd.fNt = linkedList;
        return this.jyd;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder.thread_info != null && builder2.thread_info != null) {
            a(z, builder.thread_info, builder2.thread_info, i);
            builder.hot_recomforum = builder2.hot_recomforum;
        }
    }

    private void a(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        if (list != null && list2 != null) {
            int count = y.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (com.baidu.tieba.homepage.concern.a.a.a(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && concernData.thread_list != null && concernData.thread_list.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!com.baidu.tieba.homepage.concern.d.cIu()) {
                    list.clear();
                }
                for (int count2 = y.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) y.getItem(list2, count2);
                    if (concernData2 != null && com.baidu.tieba.homepage.concern.a.a.a(concernData2)) {
                        list.add(0, concernData2);
                    } else if (concernData2 != null && concernData2.thread_list != null && concernData2.thread_list.tid != null) {
                        list.add(0, concernData2);
                    }
                }
            }
            this.jyd.jHq = y.getCount(list) - count;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
