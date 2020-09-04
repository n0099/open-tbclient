package com.baidu.tieba.homepage.concern.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.homepage.concern.b.b;
import com.baidu.tieba.homepage.personalize.model.c;
import com.baidu.tieba.homepage.personalize.model.d;
import java.util.LinkedList;
import java.util.List;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes16.dex */
public class a {
    private final c iHY = new c();

    public c a(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        int i2;
        l aA;
        l aA2;
        l aA3;
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
                    bVar.aM(concernData.recom_user_list);
                    bVar.position = i3;
                    bVar.hW(builder.thread_info.size() > 1);
                    linkedList.add(bVar);
                    i3++;
                }
            } else {
                bw bwVar = new bw();
                bwVar.ie(true);
                com.baidu.tbadk.a.a.a.a(bwVar);
                bwVar.a(concernData.thread_list);
                if ((l.aa(bwVar) || m.aa(bwVar)) && bwVar.getType() != bw.ebw) {
                    int[] imageWidthAndHeight = bwVar.getImageWidthAndHeight();
                    l aA4 = d.aA(bwVar);
                    if (aA4 != null) {
                        aA4.tid = bwVar.getTid();
                        aA4.position = i3;
                        d.a(aA4);
                        if (l.aa(bwVar)) {
                            aA4.Hc("1");
                        } else if (m.aa(bwVar)) {
                            aA4.Hc("2");
                        }
                        if (aA4.isValid()) {
                            linkedList.add(aA4);
                        }
                    }
                    com.baidu.tieba.card.data.c az = d.az(bwVar);
                    if (az != null) {
                        az.tid = bwVar.getTid();
                        az.position = i3;
                        az.dUW.beg();
                        if (az instanceof l) {
                            if (bwVar.bgz()) {
                                d.d(az);
                            } else if (bwVar.bfK() == 1) {
                                d.b(az);
                                az.eaT = imageWidthAndHeight[0];
                                az.eaU = imageWidthAndHeight[1];
                            } else if (bwVar.bfK() >= 2) {
                                d.c(az);
                            } else {
                                d.e(az);
                            }
                        } else if (az instanceof m) {
                            d.f(az);
                        }
                        if (l.aa(bwVar)) {
                            az.Hc("1");
                        } else if (m.aa(bwVar)) {
                            az.Hc("2");
                        }
                        if (az.isValid()) {
                            linkedList.add(az);
                        }
                    }
                    if (bwVar.bgH() != null && (aA3 = d.aA(bwVar)) != null) {
                        aA3.tid = bwVar.getTid();
                        aA3.position = i3;
                        d.k(aA3);
                        if (l.aa(bwVar)) {
                            aA3.Hc("1");
                        } else if (m.aa(bwVar)) {
                            aA3.Hc("2");
                        }
                        linkedList.add(aA3);
                    }
                    if ((!y.isEmpty(bwVar.bgK()) || !y.isEmpty(bwVar.bgL())) && (aA = d.aA(bwVar)) != null) {
                        aA.tid = bwVar.getTid();
                        aA.position = i3;
                        if (y.getCount(bwVar.bgK()) + y.getCount(bwVar.bgL()) == 1) {
                            d.l(aA);
                        } else {
                            d.m(aA);
                        }
                        linkedList.add(aA);
                    }
                    l aA5 = d.aA(bwVar);
                    if (aA5 != null) {
                        aA5.tid = bwVar.getTid();
                        aA5.position = i3;
                        d.g(aA5);
                        if (l.aa(bwVar)) {
                            aA5.Hc("1");
                        } else if (m.aa(bwVar)) {
                            aA5.Hc("2");
                        }
                        if (!StringUtils.isNull(bwVar.beI())) {
                            linkedList.add(aA5);
                        }
                    }
                    if (concernData.thread_list != null && concernData.thread_list.top_agree_post != null && (aA2 = d.aA(bwVar)) != null) {
                        aA2.tid = bwVar.getTid();
                        aA2.position = i3;
                        d.i(aA2);
                        if (l.aa(bwVar)) {
                            aA2.Hc("1");
                        } else if (m.aa(bwVar)) {
                            aA2.Hc("2");
                        }
                        if (aA2.isValid()) {
                            linkedList.add(aA2);
                        }
                    }
                    l aA6 = d.aA(bwVar);
                    if (aA6 != null) {
                        aA6.tid = bwVar.getTid();
                        aA6.position = i3;
                        d.j(aA6);
                        if (bwVar.getType() == bw.eaW) {
                            aA6.Hc("1");
                        } else if (m.aa(bwVar)) {
                            aA6.Hc("2");
                        }
                        if (aA6.isValid()) {
                            linkedList.add(aA6);
                        }
                    }
                } else if (bwVar.isShareThread) {
                    l lVar = new l();
                    lVar.dUW = bwVar;
                    lVar.position = i3;
                    linkedList.add(lVar);
                } else if (m.aa(bwVar)) {
                    m mVar = new m(bwVar);
                    mVar.tid = bwVar.getTid();
                    mVar.vz(concernData.source.intValue());
                    if (mVar.isValid()) {
                        linkedList.add(mVar);
                    }
                } else if (k.aa(bwVar)) {
                    k kVar = new k(bwVar);
                    kVar.tid = bwVar.getTid();
                    kVar.Hc("3");
                    if (kVar.isValid()) {
                        linkedList.add(kVar);
                    }
                } else if (f.aa(bwVar) && bwVar.bdm()) {
                    f fVar = new f(bwVar);
                    fVar.position = i3;
                    linkedList.add(fVar);
                } else {
                    l lVar2 = new l();
                    lVar2.dUW = bwVar;
                    lVar2.Hc(lVar2.dUW.isLinkThread() ? "4" : "1");
                    lVar2.position = i3;
                    lVar2.isLinkThread = false;
                    lVar2.vz(concernData.source.intValue());
                    if (lVar2.dUW != null && lVar2.isValid() && !StringUtils.isNull(lVar2.dUW.getId()) && !"0".equals(lVar2.dUW.getTid())) {
                        linkedList.add(lVar2);
                    }
                }
                i2 = i3 + 1;
            }
            i3 = i2;
        }
        com.baidu.tbadk.a.a.a.aG(linkedList);
        this.iHY.fky = linkedList;
        return this.iHY;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder.thread_info != null && builder2.thread_info != null) {
            a(z, builder.thread_info, builder2.thread_info, i);
        }
    }

    private void a(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        if (list != null && list2 != null) {
            int count = y.getCount(list);
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
                for (int count2 = y.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) y.getItem(list2, count2);
                    if (concernData2 != null && b.a(concernData2)) {
                        list.add(0, concernData2);
                    } else if (concernData2 != null && concernData2.thread_list != null && concernData2.thread_list.tid != null) {
                        list.add(0, concernData2);
                    }
                }
            }
            this.iHY.iQp = y.getCount(list) - count;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
