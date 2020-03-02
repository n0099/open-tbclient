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
    private final c gYr = new c();

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
                    bVar.my(builder.thread_info.size() > 1);
                    linkedList.add(bVar);
                    i3++;
                }
            } else {
                bj bjVar = new bj();
                bjVar.fE(true);
                bjVar.a(concernData.thread_list);
                if ((k.aa(bjVar) || l.aa(bjVar)) && bjVar.getType() != bj.cRD) {
                    int[] imageWidthAndHeight = bjVar.getImageWidthAndHeight();
                    k aA = d.aA(bjVar);
                    if (aA != null) {
                        aA.tid = bjVar.getTid();
                        aA.position = i3;
                        d.a(aA);
                    }
                    if (k.aa(bjVar)) {
                        aA.zV("1");
                    } else if (l.aa(bjVar)) {
                        aA.zV("2");
                    }
                    if (aA != null && aA.isValid()) {
                        linkedList.add(aA);
                    }
                    com.baidu.tieba.card.data.c az = d.az(bjVar);
                    if (az != null) {
                        az.tid = bjVar.getTid();
                        az.position = i3;
                        if (az instanceof k) {
                            if (bjVar.aEg()) {
                                d.d(az);
                            } else if (bjVar.aDq() == 1) {
                                d.b(az);
                                az.cRg = imageWidthAndHeight[0];
                                az.cRh = imageWidthAndHeight[1];
                            } else if (bjVar.aDq() >= 2) {
                                d.c(az);
                            } else {
                                d.e(az);
                            }
                        } else if (az instanceof l) {
                            d.f(az);
                        }
                    }
                    if (k.aa(bjVar)) {
                        az.zV("1");
                    } else if (l.aa(bjVar)) {
                        az.zV("2");
                    }
                    if (az != null && az.isValid()) {
                        linkedList.add(az);
                    }
                    k aA2 = d.aA(bjVar);
                    if (aA2 != null) {
                        aA2.tid = bjVar.getTid();
                        aA2.position = i3;
                        d.g(aA2);
                    }
                    if (k.aa(bjVar)) {
                        aA2.zV("1");
                    } else if (l.aa(bjVar)) {
                        aA2.zV("2");
                    }
                    if (aA2 != null && !StringUtils.isNull(bjVar.aCt())) {
                        linkedList.add(aA2);
                    }
                    if (concernData.thread_list != null && concernData.thread_list.top_agree_post != null) {
                        k aA3 = d.aA(bjVar);
                        if (aA3 != null) {
                            aA3.tid = bjVar.getTid();
                            aA3.position = i3;
                            d.i(aA3);
                        }
                        if (k.aa(bjVar)) {
                            aA3.zV("1");
                        } else if (l.aa(bjVar)) {
                            aA3.zV("2");
                        }
                        if (aA3 != null && aA3.isValid()) {
                            linkedList.add(aA3);
                        }
                    }
                    k aA4 = d.aA(bjVar);
                    if (aA4 != null) {
                        aA4.tid = bjVar.getTid();
                        aA4.position = i3;
                        d.j(aA4);
                    }
                    if (bjVar.getType() == bj.cRj) {
                        aA4.zV("1");
                    } else if (l.aa(bjVar)) {
                        aA4.zV("2");
                    }
                    if (aA4 != null && aA4.isValid()) {
                        linkedList.add(aA4);
                    }
                } else if (bjVar.isShareThread) {
                    k kVar = new k();
                    kVar.cRf = bjVar;
                    kVar.position = i3;
                    linkedList.add(kVar);
                } else if (l.aa(bjVar)) {
                    l lVar = new l(bjVar);
                    lVar.tid = bjVar.getTid();
                    lVar.ru(concernData.source.intValue());
                    if (lVar.isValid()) {
                        linkedList.add(lVar);
                    }
                } else if (j.aa(bjVar)) {
                    j jVar = new j(bjVar);
                    if (jVar != null) {
                        jVar.tid = bjVar.getTid();
                        jVar.zV("3");
                    }
                    if (jVar != null && jVar.isValid()) {
                        linkedList.add(jVar);
                    }
                } else if (e.aa(bjVar) && bjVar.aBd()) {
                    e eVar = new e(bjVar);
                    eVar.position = i3;
                    linkedList.add(eVar);
                } else {
                    k kVar2 = new k();
                    kVar2.cRf = bjVar;
                    kVar2.zV(kVar2.cRf.isLinkThread() ? "4" : "1");
                    kVar2.position = i3;
                    kVar2.isLinkThread = false;
                    kVar2.ru(concernData.source.intValue());
                    if (kVar2.cRf != null && kVar2.isValid() && !StringUtils.isNull(kVar2.cRf.getId()) && !"0".equals(kVar2.cRf.getTid())) {
                        linkedList.add(kVar2);
                    }
                }
                i2 = i3 + 1;
            }
            i3 = i2;
        }
        this.gYr.dTe = linkedList;
        return this.gYr;
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
            this.gYr.hfd = v.getCount(list) - count;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
