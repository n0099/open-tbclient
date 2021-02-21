package com.baidu.tieba.homepage.concern.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.data.cb;
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
/* loaded from: classes2.dex */
public class a {
    private final c kcf = new c();

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
                    if (cVar.dS(builder.hot_recomforum.tab_list)) {
                        cVar.position = i2;
                        linkedList.add(cVar);
                        i2++;
                    }
                }
                if (com.baidu.tieba.homepage.concern.a.a.a(concernData)) {
                    com.baidu.tieba.homepage.concern.a.a aVar = new com.baidu.tieba.homepage.concern.a.a();
                    if (concernData.recom_user_list.size() >= 4) {
                        aVar.bp(concernData.recom_user_list);
                        aVar.position = i2;
                        aVar.jv(builder.thread_info.size() > 1);
                        linkedList.add(aVar);
                        i2++;
                    }
                } else {
                    cb cbVar = new cb();
                    cbVar.jD(true);
                    com.baidu.tbadk.a.a.a.a(cbVar);
                    cbVar.a(concernData.thread_list);
                    JSONObject f = com.baidu.tieba.recapp.report.b.f(concernData.thread_list);
                    if (f != null) {
                        arrayList.add(f);
                    }
                    linkedList.addAll(a(cbVar, i2, concernData));
                    i2++;
                }
            }
        }
        com.baidu.tbadk.a.a.a.bj(linkedList);
        com.baidu.tieba.recapp.report.b.dEt().q("CONCERN", arrayList);
        this.kcf.gcy = linkedList;
        return this.kcf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.tieba.card.data.l] */
    public List<n> a(cb cbVar, int i, ConcernData concernData) {
        k kVar;
        boolean hadConcerned;
        ArrayList arrayList = new ArrayList();
        if ((k.ae(cbVar) || l.ae(cbVar)) && cbVar.getType() != cb.eQP) {
            if (l.ae(cbVar)) {
                kVar = new l(cbVar);
            } else {
                k kVar2 = new k();
                kVar2.isLinkThread = cbVar.isLinkThread();
                kVar2.eQc = cbVar.boU();
                if (!cbVar.isLinkThread() && !cbVar.boU()) {
                    kVar2.iBj = cbVar.bnT();
                }
                kVar2.eJQ = cbVar;
                kVar2.iBk = true;
                kVar = kVar2;
            }
            kVar.tid = cbVar.getTid();
            if (k.ae(cbVar)) {
                kVar.IR("1");
            } else if (l.ae(cbVar)) {
                kVar.IR("2");
            }
            kVar.iAA = true;
            if (d.bjg() && kVar.bln() != null && kVar.bln().bnQ() != null) {
                if (kVar.bln().bnQ().hadConcerned() || az.x(cbVar)) {
                    com.baidu.tieba.homepage.personalize.model.d.a(kVar);
                } else {
                    com.baidu.tieba.homepage.personalize.model.d.h(kVar);
                    com.baidu.tieba.homepage.personalize.model.d.aD(cbVar);
                }
            } else {
                com.baidu.tieba.homepage.personalize.model.d.a(kVar);
            }
            kVar.eJQ.bns();
            if (kVar instanceof k) {
                if (cbVar.bpN()) {
                    com.baidu.tieba.homepage.personalize.model.d.d(kVar);
                } else if (cbVar.boX() == 1) {
                    com.baidu.tieba.homepage.personalize.model.d.b(kVar);
                    int[] imageWidthAndHeight = cbVar.getImageWidthAndHeight();
                    kVar.eQj = imageWidthAndHeight[0];
                    kVar.eQk = imageWidthAndHeight[1];
                } else if (cbVar.boX() >= 2) {
                    com.baidu.tieba.homepage.personalize.model.d.c(kVar);
                } else {
                    com.baidu.tieba.homepage.personalize.model.d.e(kVar);
                }
            } else if (kVar instanceof l) {
                com.baidu.tieba.homepage.personalize.model.d.f(kVar);
            }
            if (cbVar.bpW() != null) {
                com.baidu.tieba.homepage.personalize.model.d.k(kVar);
            }
            if (!y.isEmpty(cbVar.bpZ()) || !y.isEmpty(cbVar.bqa())) {
                if (y.getCount(cbVar.bpZ()) + y.getCount(cbVar.bqa()) == 1) {
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
            if (d.bjg() && cbVar.bln() != null && cbVar.bln().bnQ() != null && !(hadConcerned = cbVar.bln().bnQ().hadConcerned()) && (hadConcerned || !az.x(cbVar))) {
                com.baidu.tieba.homepage.personalize.model.d.aD(cbVar);
            }
            if (cbVar.isShareThread) {
                k kVar3 = new k();
                kVar3.eJQ = cbVar;
                kVar3.position = i;
                arrayList.add(kVar3);
            } else if (l.ae(cbVar)) {
                l lVar = new l(cbVar);
                lVar.tid = cbVar.getTid();
                if (concernData != null) {
                    lVar.xe(concernData.source.intValue());
                }
                if (lVar.isValid()) {
                    arrayList.add(lVar);
                }
            } else if (j.ae(cbVar)) {
                j jVar = new j(cbVar);
                jVar.tid = cbVar.getTid();
                jVar.IR("3");
                if (jVar.isValid()) {
                    arrayList.add(jVar);
                }
            } else if (e.ae(cbVar) && cbVar.bmx()) {
                e eVar = new e(cbVar);
                eVar.position = i;
                arrayList.add(eVar);
            } else {
                k kVar4 = new k();
                kVar4.eJQ = cbVar;
                kVar4.IR(kVar4.eJQ.isLinkThread() ? "4" : "1");
                kVar4.position = i;
                kVar4.isLinkThread = false;
                if (concernData != null) {
                    kVar4.xe(concernData.source.intValue());
                }
                if (kVar4.eJQ != null && kVar4.isValid() && !StringUtils.isNull(kVar4.eJQ.getId()) && !"0".equals(kVar4.eJQ.getTid())) {
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
                if (!com.baidu.tieba.homepage.concern.d.cPc()) {
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
            this.kcf.klY = y.getCount(list) - count;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
