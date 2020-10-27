package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.homepage.concern.a.d;
import com.baidu.tieba.homepage.personalize.model.c;
import java.util.LinkedList;
import java.util.List;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes22.dex */
public class a {
    private final c jrp = new c();

    public c a(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        int i2;
        l aB;
        l aB2;
        l aB3;
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
        int i3 = 0;
        for (ConcernData concernData : builder.thread_info) {
            if (concernData != null) {
                if (d.a(builder.hot_recomforum, i3)) {
                    d dVar = new d();
                    if (dVar.du(builder.hot_recomforum.tab_list)) {
                        dVar.position = i3;
                        linkedList.add(dVar);
                        i3++;
                    }
                }
                if (com.baidu.tieba.homepage.concern.a.b.a(concernData)) {
                    com.baidu.tieba.homepage.concern.a.b bVar = new com.baidu.tieba.homepage.concern.a.b();
                    if (concernData.recom_user_list.size() >= 4) {
                        bVar.bd(concernData.recom_user_list);
                        bVar.position = i3;
                        bVar.iC(builder.thread_info.size() > 1);
                        linkedList.add(bVar);
                        i3++;
                    }
                } else {
                    bw bwVar = new bw();
                    bwVar.iK(true);
                    com.baidu.tbadk.a.a.a.a(bwVar);
                    bwVar.a(concernData.thread_list);
                    if ((l.ab(bwVar) || m.ab(bwVar)) && bwVar.getType() != bw.eyl) {
                        int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
                        l aB4 = com.baidu.tieba.homepage.personalize.model.d.aB(bwVar);
                        if (aB4 != null) {
                            if (com.baidu.tbadk.a.d.bfD() && aB4.bhz() != null && aB4.bhz().bka() != null) {
                                boolean hadConcerned2 = aB4.bhz().bka().hadConcerned();
                                if (hadConcerned2 || (!hadConcerned2 && ay.x(bwVar))) {
                                    com.baidu.tieba.homepage.personalize.model.d.a(aB4);
                                } else {
                                    com.baidu.tieba.homepage.personalize.model.d.h(aB4);
                                    com.baidu.tieba.homepage.personalize.model.d.az(bwVar);
                                }
                            } else {
                                com.baidu.tieba.homepage.personalize.model.d.a(aB4);
                            }
                            aB4.tid = bwVar.getTid();
                            aB4.position = i3;
                            if (l.ab(bwVar)) {
                                aB4.IL("1");
                            } else if (m.ab(bwVar)) {
                                aB4.IL("2");
                            }
                            if (aB4.isValid()) {
                                linkedList.add(aB4);
                            }
                        }
                        com.baidu.tieba.card.data.c aA = com.baidu.tieba.homepage.personalize.model.d.aA(bwVar);
                        if (aA != null) {
                            aA.tid = bwVar.getTid();
                            aA.position = i3;
                            aA.erH.bjC();
                            if (aA instanceof l) {
                                if (bwVar.blV()) {
                                    com.baidu.tieba.homepage.personalize.model.d.d(aA);
                                } else if (bwVar.blg() == 1) {
                                    com.baidu.tieba.homepage.personalize.model.d.b(aA);
                                    aA.exG = imageWidthAndHeight[0];
                                    aA.exH = imageWidthAndHeight[1];
                                } else if (bwVar.blg() >= 2) {
                                    com.baidu.tieba.homepage.personalize.model.d.c(aA);
                                } else {
                                    com.baidu.tieba.homepage.personalize.model.d.e(aA);
                                }
                            } else if (aA instanceof m) {
                                com.baidu.tieba.homepage.personalize.model.d.f(aA);
                            }
                            if (l.ab(bwVar)) {
                                aA.IL("1");
                            } else if (m.ab(bwVar)) {
                                aA.IL("2");
                            }
                            if (aA.isValid()) {
                                linkedList.add(aA);
                            }
                        }
                        if (bwVar.bmd() != null && (aB3 = com.baidu.tieba.homepage.personalize.model.d.aB(bwVar)) != null) {
                            aB3.tid = bwVar.getTid();
                            aB3.position = i3;
                            com.baidu.tieba.homepage.personalize.model.d.k(aB3);
                            if (l.ab(bwVar)) {
                                aB3.IL("1");
                            } else if (m.ab(bwVar)) {
                                aB3.IL("2");
                            }
                            linkedList.add(aB3);
                        }
                        if ((!y.isEmpty(bwVar.bmg()) || !y.isEmpty(bwVar.bmh())) && (aB = com.baidu.tieba.homepage.personalize.model.d.aB(bwVar)) != null) {
                            aB.tid = bwVar.getTid();
                            aB.position = i3;
                            if (y.getCount(bwVar.bmg()) + y.getCount(bwVar.bmh()) == 1) {
                                com.baidu.tieba.homepage.personalize.model.d.l(aB);
                            } else {
                                com.baidu.tieba.homepage.personalize.model.d.m(aB);
                            }
                            linkedList.add(aB);
                        }
                        l aB5 = com.baidu.tieba.homepage.personalize.model.d.aB(bwVar);
                        if (aB5 != null) {
                            aB5.tid = bwVar.getTid();
                            aB5.position = i3;
                            com.baidu.tieba.homepage.personalize.model.d.g(aB5);
                            if (l.ab(bwVar)) {
                                aB5.IL("1");
                            } else if (m.ab(bwVar)) {
                                aB5.IL("2");
                            }
                            if (!StringUtils.isNull(bwVar.bke())) {
                                linkedList.add(aB5);
                            }
                        }
                        if (concernData.thread_list != null && concernData.thread_list.top_agree_post != null && (aB2 = com.baidu.tieba.homepage.personalize.model.d.aB(bwVar)) != null) {
                            aB2.tid = bwVar.getTid();
                            aB2.position = i3;
                            com.baidu.tieba.homepage.personalize.model.d.i(aB2);
                            if (l.ab(bwVar)) {
                                aB2.IL("1");
                            } else if (m.ab(bwVar)) {
                                aB2.IL("2");
                            }
                            if (aB2.isValid()) {
                                linkedList.add(aB2);
                            }
                        }
                        l aB6 = com.baidu.tieba.homepage.personalize.model.d.aB(bwVar);
                        if (aB6 != null) {
                            aB6.tid = bwVar.getTid();
                            aB6.position = i3;
                            com.baidu.tieba.homepage.personalize.model.d.j(aB6);
                            if (bwVar.getType() == bw.exJ) {
                                aB6.IL("1");
                            } else if (m.ab(bwVar)) {
                                aB6.IL("2");
                            }
                            if (aB6.isValid()) {
                                linkedList.add(aB6);
                            }
                        }
                    } else {
                        if (com.baidu.tbadk.a.d.bfD() && bwVar.bhz() != null && bwVar.bhz().bka() != null && !(hadConcerned = bwVar.bhz().bka().hadConcerned()) && (hadConcerned || !ay.x(bwVar))) {
                            com.baidu.tieba.homepage.personalize.model.d.az(bwVar);
                        }
                        if (bwVar.isShareThread) {
                            l lVar = new l();
                            lVar.erH = bwVar;
                            lVar.position = i3;
                            linkedList.add(lVar);
                        } else if (m.ab(bwVar)) {
                            m mVar = new m(bwVar);
                            mVar.tid = bwVar.getTid();
                            mVar.wX(concernData.source.intValue());
                            if (mVar.isValid()) {
                                linkedList.add(mVar);
                            }
                        } else if (k.ab(bwVar)) {
                            k kVar = new k(bwVar);
                            kVar.tid = bwVar.getTid();
                            kVar.IL("3");
                            if (kVar.isValid()) {
                                linkedList.add(kVar);
                            }
                        } else if (f.ab(bwVar) && bwVar.biI()) {
                            f fVar = new f(bwVar);
                            fVar.position = i3;
                            linkedList.add(fVar);
                        } else {
                            l lVar2 = new l();
                            lVar2.erH = bwVar;
                            lVar2.IL(lVar2.erH.isLinkThread() ? "4" : "1");
                            lVar2.position = i3;
                            lVar2.isLinkThread = false;
                            lVar2.wX(concernData.source.intValue());
                            if (lVar2.erH != null && lVar2.isValid() && !StringUtils.isNull(lVar2.erH.getId()) && !"0".equals(lVar2.erH.getTid())) {
                                linkedList.add(lVar2);
                            }
                        }
                    }
                    i2 = i3 + 1;
                }
            } else {
                i2 = i3;
            }
            i3 = i2;
        }
        com.baidu.tbadk.a.a.a.aX(linkedList);
        this.jrp.fIa = linkedList;
        return this.jrp;
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
                    if (com.baidu.tieba.homepage.concern.a.b.a(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && concernData.thread_list != null && concernData.thread_list.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!com.baidu.tieba.homepage.concern.d.cGo()) {
                    list.clear();
                }
                for (int count2 = y.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) y.getItem(list2, count2);
                    if (concernData2 != null && com.baidu.tieba.homepage.concern.a.b.a(concernData2)) {
                        list.add(0, concernData2);
                    } else if (concernData2 != null && concernData2.thread_list != null && concernData2.thread_list.tid != null) {
                        list.add(0, concernData2);
                    }
                }
            }
            this.jrp.jAu = y.getCount(list) - count;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
