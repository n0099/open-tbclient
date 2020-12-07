package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.e;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.homepage.personalize.model.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes22.dex */
public class a {
    private final c jLF = new c();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13, types: [com.baidu.tieba.card.data.l] */
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
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (ConcernData concernData : builder.thread_info) {
            if (concernData != null) {
                if (com.baidu.tieba.homepage.concern.a.c.a(builder.hot_recomforum, i2)) {
                    com.baidu.tieba.homepage.concern.a.c cVar = new com.baidu.tieba.homepage.concern.a.c();
                    if (cVar.dN(builder.hot_recomforum.tab_list)) {
                        cVar.position = i2;
                        linkedList.add(cVar);
                        i2++;
                    }
                }
                if (com.baidu.tieba.homepage.concern.a.a.a(concernData)) {
                    com.baidu.tieba.homepage.concern.a.a aVar = new com.baidu.tieba.homepage.concern.a.a();
                    if (concernData.recom_user_list.size() >= 4) {
                        aVar.bn(concernData.recom_user_list);
                        aVar.position = i2;
                        aVar.jb(builder.thread_info.size() > 1);
                        linkedList.add(aVar);
                        i2++;
                    }
                } else {
                    by byVar = new by();
                    byVar.jj(true);
                    com.baidu.tbadk.a.a.a.a(byVar);
                    byVar.a(concernData.thread_list);
                    JSONObject f = com.baidu.tieba.recapp.report.b.f(concernData.thread_list);
                    if (f != null) {
                        arrayList.add(f);
                    }
                    if ((k.ad(byVar) || l.ad(byVar)) && byVar.getType() != by.eJv) {
                        if (l.ad(byVar)) {
                            kVar = new l(byVar);
                        } else {
                            k kVar2 = new k();
                            kVar2.isLinkThread = byVar.isLinkThread();
                            kVar2.eII = byVar.bpU();
                            if (!byVar.isLinkThread() && !byVar.bpU()) {
                                kVar2.inw = byVar.boS();
                            }
                            kVar2.eCR = byVar;
                            kVar2.inx = true;
                            kVar = kVar2;
                        }
                        kVar.tid = byVar.getTid();
                        if (k.ad(byVar)) {
                            kVar.Jt("1");
                        } else if (l.ad(byVar)) {
                            kVar.Jt("2");
                        }
                        kVar.imM = true;
                        if (d.bkz() && kVar.bmn() != null && kVar.bmn().boP() != null) {
                            if (kVar.bmn().boP().hadConcerned() || az.x(byVar)) {
                                com.baidu.tieba.homepage.personalize.model.d.a(kVar);
                            } else {
                                com.baidu.tieba.homepage.personalize.model.d.h(kVar);
                                com.baidu.tieba.homepage.personalize.model.d.aB(byVar);
                            }
                        } else {
                            com.baidu.tieba.homepage.personalize.model.d.a(kVar);
                        }
                        kVar.eCR.bor();
                        if (kVar instanceof k) {
                            if (byVar.bqM()) {
                                com.baidu.tieba.homepage.personalize.model.d.d(kVar);
                            } else if (byVar.bpX() == 1) {
                                com.baidu.tieba.homepage.personalize.model.d.b(kVar);
                                int[] imageWidthAndHeight = byVar.getImageWidthAndHeight();
                                kVar.eIP = imageWidthAndHeight[0];
                                kVar.eIQ = imageWidthAndHeight[1];
                            } else if (byVar.bpX() >= 2) {
                                com.baidu.tieba.homepage.personalize.model.d.c(kVar);
                            } else {
                                com.baidu.tieba.homepage.personalize.model.d.e(kVar);
                            }
                        } else if (kVar instanceof l) {
                            com.baidu.tieba.homepage.personalize.model.d.f(kVar);
                        }
                        if (byVar.bqV() != null) {
                            com.baidu.tieba.homepage.personalize.model.d.k(kVar);
                        }
                        if (!y.isEmpty(byVar.bqY()) || !y.isEmpty(byVar.bqZ())) {
                            if (y.getCount(byVar.bqZ()) + y.getCount(byVar.bqY()) == 1) {
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
                        if (d.bkz() && byVar.bmn() != null && byVar.bmn().boP() != null && !(hadConcerned = byVar.bmn().boP().hadConcerned()) && (hadConcerned || !az.x(byVar))) {
                            com.baidu.tieba.homepage.personalize.model.d.aB(byVar);
                        }
                        if (byVar.isShareThread) {
                            k kVar3 = new k();
                            kVar3.eCR = byVar;
                            kVar3.position = i2;
                            linkedList.add(kVar3);
                        } else if (l.ad(byVar)) {
                            l lVar = new l(byVar);
                            lVar.tid = byVar.getTid();
                            lVar.yn(concernData.source.intValue());
                            if (lVar.isValid()) {
                                linkedList.add(lVar);
                            }
                        } else if (j.ad(byVar)) {
                            j jVar = new j(byVar);
                            jVar.tid = byVar.getTid();
                            jVar.Jt("3");
                            if (jVar.isValid()) {
                                linkedList.add(jVar);
                            }
                        } else if (e.ad(byVar) && byVar.bnx()) {
                            e eVar = new e(byVar);
                            eVar.position = i2;
                            linkedList.add(eVar);
                        } else {
                            k kVar4 = new k();
                            kVar4.eCR = byVar;
                            kVar4.Jt(kVar4.eCR.isLinkThread() ? "4" : "1");
                            kVar4.position = i2;
                            kVar4.isLinkThread = false;
                            kVar4.yn(concernData.source.intValue());
                            if (kVar4.eCR != null && kVar4.isValid() && !StringUtils.isNull(kVar4.eCR.getId()) && !"0".equals(kVar4.eCR.getTid())) {
                                linkedList.add(kVar4);
                            }
                        }
                    }
                    i2++;
                }
            }
        }
        com.baidu.tbadk.a.a.a.bh(linkedList);
        com.baidu.tieba.recapp.report.b.dGe().q("tag_home_concern_tab", arrayList);
        this.jLF.fVe = linkedList;
        return this.jLF;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder.thread_info != null && builder2.thread_info != null) {
            b(z, builder.thread_info, builder2.thread_info, i);
            builder.hot_recomforum = builder2.hot_recomforum;
        }
    }

    private void b(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
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
                if (!com.baidu.tieba.homepage.concern.d.cNJ()) {
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
            this.jLF.jUT = y.getCount(list) - count;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
