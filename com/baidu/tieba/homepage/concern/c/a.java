package com.baidu.tieba.homepage.concern.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
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
    private final c hYX = new c();

    public c a(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        int i2;
        k aC;
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
        e aMx = com.baidu.tbadk.a.a.c.aMx();
        int i3 = 0;
        for (ConcernData concernData : builder.thread_info) {
            if (concernData == null) {
                i2 = i3;
            } else if (b.a(concernData)) {
                b bVar = new b();
                if (concernData.recom_user_list.size() >= 4) {
                    bVar.bQ(concernData.recom_user_list);
                    bVar.position = i3;
                    bVar.oe(builder.thread_info.size() > 1);
                    linkedList.add(bVar);
                    i3++;
                }
            } else {
                bk bkVar = new bk();
                bkVar.gU(true);
                com.baidu.tbadk.a.a.c.a(aMx, bkVar);
                bkVar.a(concernData.thread_list);
                if ((k.ac(bkVar) || l.ac(bkVar)) && bkVar.getType() != bk.dEZ) {
                    int[] imageWidthAndHeight = bkVar.getImageWidthAndHeight();
                    k aC2 = d.aC(bkVar);
                    if (aC2 != null) {
                        aC2.tid = bkVar.getTid();
                        aC2.position = i3;
                        d.a(aC2);
                        if (k.ac(bkVar)) {
                            aC2.Dq("1");
                        } else if (l.ac(bkVar)) {
                            aC2.Dq("2");
                        }
                        if (aC2.isValid()) {
                            linkedList.add(aC2);
                        }
                    }
                    com.baidu.tieba.card.data.c aB = d.aB(bkVar);
                    if (aB != null) {
                        aB.tid = bkVar.getTid();
                        aB.position = i3;
                        if (aB instanceof k) {
                            if (bkVar.aSv()) {
                                d.d(aB);
                            } else if (bkVar.aRE() == 1) {
                                d.b(aB);
                                aB.dEB = imageWidthAndHeight[0];
                                aB.dEC = imageWidthAndHeight[1];
                            } else if (bkVar.aRE() >= 2) {
                                d.c(aB);
                            } else {
                                d.e(aB);
                            }
                        } else if (aB instanceof l) {
                            d.f(aB);
                        }
                        if (k.ac(bkVar)) {
                            aB.Dq("1");
                        } else if (l.ac(bkVar)) {
                            aB.Dq("2");
                        }
                        if (aB != null && aB.isValid()) {
                            linkedList.add(aB);
                        }
                    }
                    k aC3 = d.aC(bkVar);
                    if (aC3 != null) {
                        aC3.tid = bkVar.getTid();
                        aC3.position = i3;
                        d.g(aC3);
                        if (k.ac(bkVar)) {
                            aC3.Dq("1");
                        } else if (l.ac(bkVar)) {
                            aC3.Dq("2");
                        }
                        if (bkVar.aOo() && !StringUtils.isNull(bkVar.aQC())) {
                            linkedList.add(aC3);
                        } else if (bkVar.aOq() && !StringUtils.isNull(bkVar.aSC())) {
                            linkedList.add(aC3);
                        } else if (!StringUtils.isNull(bkVar.aQC())) {
                            linkedList.add(aC3);
                        }
                    }
                    if (concernData.thread_list != null && concernData.thread_list.top_agree_post != null && (aC = d.aC(bkVar)) != null) {
                        aC.tid = bkVar.getTid();
                        aC.position = i3;
                        d.i(aC);
                        if (k.ac(bkVar)) {
                            aC.Dq("1");
                        } else if (l.ac(bkVar)) {
                            aC.Dq("2");
                        }
                        if (aC.isValid()) {
                            linkedList.add(aC);
                        }
                    }
                    k aC4 = d.aC(bkVar);
                    if (aC4 != null) {
                        aC4.tid = bkVar.getTid();
                        aC4.position = i3;
                        d.j(aC4);
                        if (bkVar.getType() == bk.dEE) {
                            aC4.Dq("1");
                        } else if (l.ac(bkVar)) {
                            aC4.Dq("2");
                        }
                        if (aC4.isValid()) {
                            linkedList.add(aC4);
                        }
                    }
                } else if (bkVar.isShareThread) {
                    k kVar = new k();
                    kVar.dEA = bkVar;
                    kVar.position = i3;
                    linkedList.add(kVar);
                } else if (l.ac(bkVar)) {
                    l lVar = new l(bkVar);
                    lVar.tid = bkVar.getTid();
                    lVar.su(concernData.source.intValue());
                    if (lVar.isValid()) {
                        linkedList.add(lVar);
                    }
                } else if (j.ac(bkVar)) {
                    j jVar = new j(bkVar);
                    if (jVar != null) {
                        jVar.tid = bkVar.getTid();
                        jVar.Dq("3");
                    }
                    if (jVar != null && jVar.isValid()) {
                        linkedList.add(jVar);
                    }
                } else if (com.baidu.tieba.card.data.e.ac(bkVar) && bkVar.aPm()) {
                    com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e(bkVar);
                    eVar.position = i3;
                    linkedList.add(eVar);
                } else {
                    k kVar2 = new k();
                    kVar2.dEA = bkVar;
                    kVar2.Dq(kVar2.dEA.isLinkThread() ? "4" : "1");
                    kVar2.position = i3;
                    kVar2.isLinkThread = false;
                    kVar2.su(concernData.source.intValue());
                    if (kVar2.dEA != null && kVar2.isValid() && !StringUtils.isNull(kVar2.dEA.getId()) && !"0".equals(kVar2.dEA.getTid())) {
                        linkedList.add(kVar2);
                    }
                }
                i2 = i3 + 1;
            }
            i3 = i2;
        }
        com.baidu.tbadk.a.a.c.a(aMx, linkedList);
        this.hYX.eIv = linkedList;
        return this.hYX;
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
            this.hYX.ifZ = v.getCount(list) - count;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
