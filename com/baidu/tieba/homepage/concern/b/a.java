package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes2.dex */
public class a {
    private final c jUq = new c();

    public c a(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                    if (cVar.dV(builder.hot_recomforum.tab_list)) {
                        cVar.position = i2;
                        linkedList.add(cVar);
                        i2++;
                    }
                }
                if (com.baidu.tieba.homepage.concern.a.a.a(concernData)) {
                    com.baidu.tieba.homepage.concern.a.a aVar = new com.baidu.tieba.homepage.concern.a.a();
                    if (concernData.recom_user_list.size() >= 4) {
                        aVar.bu(concernData.recom_user_list);
                        aVar.position = i2;
                        aVar.jt(builder.thread_info.size() > 1);
                        linkedList.add(aVar);
                        i2++;
                    }
                } else {
                    bz bzVar = new bz();
                    bzVar.jB(true);
                    com.baidu.tbadk.a.a.a.a(bzVar);
                    bzVar.a(concernData.thread_list);
                    JSONObject f = com.baidu.tieba.recapp.report.b.f(concernData.thread_list);
                    if (f != null) {
                        arrayList.add(f);
                    }
                    linkedList.addAll(a(bzVar, i2, concernData));
                    i2++;
                }
            }
        }
        com.baidu.tbadk.a.a.a.bo(linkedList);
        com.baidu.tieba.recapp.report.b.dCd().q("CONCERN", arrayList);
        this.jUq.gaa = linkedList;
        return this.jUq;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.tieba.card.data.l] */
    public List<n> a(bz bzVar, int i, ConcernData concernData) {
        k kVar;
        boolean hadConcerned;
        ArrayList arrayList = new ArrayList();
        if ((k.ad(bzVar) || l.ad(bzVar)) && bzVar.getType() != bz.eOD) {
            if (l.ad(bzVar)) {
                kVar = new l(bzVar);
            } else {
                k kVar2 = new k();
                kVar2.isLinkThread = bzVar.isLinkThread();
                kVar2.eNQ = bzVar.boC();
                if (!bzVar.isLinkThread() && !bzVar.boC()) {
                    kVar2.ivl = bzVar.bnA();
                }
                kVar2.eHK = bzVar;
                kVar2.ivm = true;
                kVar = kVar2;
            }
            kVar.tid = bzVar.getTid();
            if (k.ad(bzVar)) {
                kVar.If("1");
            } else if (l.ad(bzVar)) {
                kVar.If("2");
            }
            kVar.iuC = true;
            if (d.biU() && kVar.bkV() != null && kVar.bkV().bnx() != null) {
                if (kVar.bkV().bnx().hadConcerned() || ay.x(bzVar)) {
                    com.baidu.tieba.homepage.personalize.model.d.a(kVar);
                } else {
                    com.baidu.tieba.homepage.personalize.model.d.h(kVar);
                    com.baidu.tieba.homepage.personalize.model.d.aC(bzVar);
                }
            } else {
                com.baidu.tieba.homepage.personalize.model.d.a(kVar);
            }
            kVar.eHK.bmZ();
            if (kVar instanceof k) {
                if (bzVar.bpv()) {
                    com.baidu.tieba.homepage.personalize.model.d.d(kVar);
                } else if (bzVar.boF() == 1) {
                    com.baidu.tieba.homepage.personalize.model.d.b(kVar);
                    int[] imageWidthAndHeight = bzVar.getImageWidthAndHeight();
                    kVar.eNX = imageWidthAndHeight[0];
                    kVar.eNY = imageWidthAndHeight[1];
                } else if (bzVar.boF() >= 2) {
                    com.baidu.tieba.homepage.personalize.model.d.c(kVar);
                } else {
                    com.baidu.tieba.homepage.personalize.model.d.e(kVar);
                }
            } else if (kVar instanceof l) {
                com.baidu.tieba.homepage.personalize.model.d.f(kVar);
            }
            if (bzVar.bpE() != null) {
                com.baidu.tieba.homepage.personalize.model.d.k(kVar);
            }
            if (!x.isEmpty(bzVar.bpH()) || !x.isEmpty(bzVar.bpI())) {
                if (x.getCount(bzVar.bpH()) + x.getCount(bzVar.bpI()) == 1) {
                    com.baidu.tieba.homepage.personalize.model.d.l(kVar);
                } else {
                    com.baidu.tieba.homepage.personalize.model.d.m(kVar);
                }
            }
            com.baidu.tieba.homepage.personalize.model.d.g(kVar);
            if (concernData != null && concernData.thread_list != null && concernData.thread_list.top_agree_post != null) {
                com.baidu.tieba.homepage.personalize.model.d.i(kVar);
            }
            com.baidu.tieba.homepage.personalize.model.d.j(kVar);
            kVar.setSupportType(BaseCardInfo.SupportType.TOP);
            kVar.position = i;
            arrayList.add(kVar);
        } else {
            if (d.biU() && bzVar.bkV() != null && bzVar.bkV().bnx() != null && !(hadConcerned = bzVar.bkV().bnx().hadConcerned()) && (hadConcerned || !ay.x(bzVar))) {
                com.baidu.tieba.homepage.personalize.model.d.aC(bzVar);
            }
            if (bzVar.isShareThread) {
                k kVar3 = new k();
                kVar3.eHK = bzVar;
                kVar3.position = i;
                arrayList.add(kVar3);
            } else if (l.ad(bzVar)) {
                l lVar = new l(bzVar);
                lVar.tid = bzVar.getTid();
                if (concernData != null) {
                    lVar.wU(concernData.source.intValue());
                }
                if (lVar.isValid()) {
                    arrayList.add(lVar);
                }
            } else if (j.ad(bzVar)) {
                j jVar = new j(bzVar);
                jVar.tid = bzVar.getTid();
                jVar.If("3");
                if (jVar.isValid()) {
                    arrayList.add(jVar);
                }
            } else if (e.ad(bzVar) && bzVar.bme()) {
                e eVar = new e(bzVar);
                eVar.position = i;
                arrayList.add(eVar);
            } else {
                k kVar4 = new k();
                kVar4.eHK = bzVar;
                kVar4.If(kVar4.eHK.isLinkThread() ? "4" : "1");
                kVar4.position = i;
                kVar4.isLinkThread = false;
                if (concernData != null) {
                    kVar4.wU(concernData.source.intValue());
                }
                if (kVar4.eHK != null && kVar4.isValid() && !StringUtils.isNull(kVar4.eHK.getId()) && !"0".equals(kVar4.eHK.getTid())) {
                    arrayList.add(kVar4);
                }
            }
        }
        return arrayList;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder.thread_info != null && builder2.thread_info != null) {
            b(z, builder.thread_info, builder2.thread_info, i);
            builder.hot_recomforum = builder2.hot_recomforum;
        }
    }

    private void b(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        if (list != null && list2 != null) {
            int count = x.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (com.baidu.tieba.homepage.concern.a.a.a(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && concernData.thread_list != null && concernData.thread_list.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!com.baidu.tieba.homepage.concern.d.cMZ()) {
                    list.clear();
                }
                for (int count2 = x.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) x.getItem(list2, count2);
                    if (concernData2 != null && com.baidu.tieba.homepage.concern.a.a.a(concernData2)) {
                        list.add(0, concernData2);
                    } else if (concernData2 != null && concernData2.thread_list != null && concernData2.thread_list.tid != null) {
                        list.add(0, concernData2);
                    }
                }
            }
            this.jUq.kdA = x.getCount(list) - count;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
