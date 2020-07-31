package com.baidu.tieba.homepage.concern.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes16.dex */
public class a {
    private final c itB = new c();

    public c a(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        int i2;
        k az;
        k az2;
        k az3;
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
                    bVar.hz(builder.thread_info.size() > 1);
                    linkedList.add(bVar);
                    i3++;
                }
            } else {
                bv bvVar = new bv();
                bvVar.hH(true);
                com.baidu.tbadk.a.a.a.a(bvVar);
                bvVar.a(concernData.thread_list);
                if ((k.aa(bvVar) || l.aa(bvVar)) && bvVar.getType() != bv.dRW) {
                    int[] imageWidthAndHeight = bvVar.getImageWidthAndHeight();
                    k az4 = d.az(bvVar);
                    if (az4 != null) {
                        az4.tid = bvVar.getTid();
                        az4.position = i3;
                        d.a(az4);
                        if (k.aa(bvVar)) {
                            az4.EC("1");
                        } else if (l.aa(bvVar)) {
                            az4.EC("2");
                        }
                        if (az4.isValid()) {
                            linkedList.add(az4);
                        }
                    }
                    com.baidu.tieba.card.data.c ay = d.ay(bvVar);
                    if (ay != null) {
                        ay.tid = bvVar.getTid();
                        ay.position = i3;
                        ay.dLK.aVN();
                        if (ay instanceof k) {
                            if (bvVar.aYg()) {
                                d.d(ay);
                            } else if (bvVar.aXr() == 1) {
                                d.b(ay);
                                ay.dRu = imageWidthAndHeight[0];
                                ay.dRv = imageWidthAndHeight[1];
                            } else if (bvVar.aXr() >= 2) {
                                d.c(ay);
                            } else {
                                d.e(ay);
                            }
                        } else if (ay instanceof l) {
                            d.f(ay);
                        }
                        if (k.aa(bvVar)) {
                            ay.EC("1");
                        } else if (l.aa(bvVar)) {
                            ay.EC("2");
                        }
                        if (ay.isValid()) {
                            linkedList.add(ay);
                        }
                    }
                    if (bvVar.aYo() != null && (az3 = d.az(bvVar)) != null) {
                        az3.tid = bvVar.getTid();
                        az3.position = i3;
                        d.k(az3);
                        if (k.aa(bvVar)) {
                            az3.EC("1");
                        } else if (l.aa(bvVar)) {
                            az3.EC("2");
                        }
                        linkedList.add(az3);
                    }
                    if (!x.isEmpty(bvVar.aYr()) && (az2 = d.az(bvVar)) != null) {
                        az2.tid = bvVar.getTid();
                        az2.position = i3;
                        if (x.getCount(bvVar.aYr()) == 1) {
                            d.l(az2);
                        } else {
                            d.m(az2);
                        }
                        linkedList.add(az2);
                    }
                    k az5 = d.az(bvVar);
                    if (az5 != null) {
                        az5.tid = bvVar.getTid();
                        az5.position = i3;
                        d.g(az5);
                        if (k.aa(bvVar)) {
                            az5.EC("1");
                        } else if (l.aa(bvVar)) {
                            az5.EC("2");
                        }
                        if (!StringUtils.isNull(bvVar.aWp())) {
                            linkedList.add(az5);
                        }
                    }
                    if (concernData.thread_list != null && concernData.thread_list.top_agree_post != null && (az = d.az(bvVar)) != null) {
                        az.tid = bvVar.getTid();
                        az.position = i3;
                        d.i(az);
                        if (k.aa(bvVar)) {
                            az.EC("1");
                        } else if (l.aa(bvVar)) {
                            az.EC("2");
                        }
                        if (az.isValid()) {
                            linkedList.add(az);
                        }
                    }
                    k az6 = d.az(bvVar);
                    if (az6 != null) {
                        az6.tid = bvVar.getTid();
                        az6.position = i3;
                        d.j(az6);
                        if (bvVar.getType() == bv.dRx) {
                            az6.EC("1");
                        } else if (l.aa(bvVar)) {
                            az6.EC("2");
                        }
                        if (az6.isValid()) {
                            linkedList.add(az6);
                        }
                    }
                } else if (bvVar.isShareThread) {
                    k kVar = new k();
                    kVar.dLK = bvVar;
                    kVar.position = i3;
                    linkedList.add(kVar);
                } else if (l.aa(bvVar)) {
                    l lVar = new l(bvVar);
                    lVar.tid = bvVar.getTid();
                    lVar.tk(concernData.source.intValue());
                    if (lVar.isValid()) {
                        linkedList.add(lVar);
                    }
                } else if (j.aa(bvVar)) {
                    j jVar = new j(bvVar);
                    jVar.tid = bvVar.getTid();
                    jVar.EC("3");
                    if (jVar.isValid()) {
                        linkedList.add(jVar);
                    }
                } else if (e.aa(bvVar) && bvVar.aUT()) {
                    e eVar = new e(bvVar);
                    eVar.position = i3;
                    linkedList.add(eVar);
                } else {
                    k kVar2 = new k();
                    kVar2.dLK = bvVar;
                    kVar2.EC(kVar2.dLK.isLinkThread() ? "4" : "1");
                    kVar2.position = i3;
                    kVar2.isLinkThread = false;
                    kVar2.tk(concernData.source.intValue());
                    if (kVar2.dLK != null && kVar2.isValid() && !StringUtils.isNull(kVar2.dLK.getId()) && !"0".equals(kVar2.dLK.getTid())) {
                        linkedList.add(kVar2);
                    }
                }
                i2 = i3 + 1;
            }
            i3 = i2;
        }
        com.baidu.tbadk.a.a.a.aG(linkedList);
        this.itB.eZc = linkedList;
        return this.itB;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder.thread_info != null && builder2.thread_info != null) {
            a(z, builder.thread_info, builder2.thread_info, i);
        }
    }

    private void a(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        if (list != null && list2 != null) {
            int count = x.getCount(list);
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
                for (int count2 = x.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) x.getItem(list2, count2);
                    if (concernData2 != null && b.a(concernData2)) {
                        list.add(0, concernData2);
                    } else if (concernData2 != null && concernData2.thread_list != null && concernData2.thread_list.tid != null) {
                        list.add(0, concernData2);
                    }
                }
            }
            this.itB.iBp = x.getCount(list) - count;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
