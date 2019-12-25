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
/* loaded from: classes6.dex */
public class a {
    private final c gSU = new c();

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
                    bVar.bL(concernData.recom_user_list);
                    bVar.position = i3;
                    bVar.ml(builder.thread_info.size() > 1);
                    linkedList.add(bVar);
                    i3++;
                }
            } else {
                bj bjVar = new bj();
                bjVar.fs(true);
                bjVar.a(concernData.thread_list);
                if ((k.Y(bjVar) || l.Y(bjVar)) && bjVar.getType() != bj.cNp) {
                    int[] imageWidthAndHeight = bjVar.getImageWidthAndHeight();
                    k av = d.av(bjVar);
                    if (av != null) {
                        av.tid = bjVar.getTid();
                        av.position = i3;
                        d.a(av);
                    }
                    if (k.Y(bjVar)) {
                        av.zv("1");
                    } else if (l.Y(bjVar)) {
                        av.zv("2");
                    }
                    if (av != null && av.isValid()) {
                        linkedList.add(av);
                    }
                    com.baidu.tieba.card.data.c au = d.au(bjVar);
                    if (au != null) {
                        au.tid = bjVar.getTid();
                        au.position = i3;
                        if (au instanceof k) {
                            if (bjVar.aBA()) {
                                d.d(au);
                            } else if (bjVar.aAI() == 1) {
                                d.b(au);
                                au.cMS = imageWidthAndHeight[0];
                                au.cMT = imageWidthAndHeight[1];
                            } else if (bjVar.aAI() >= 2) {
                                d.c(au);
                            } else {
                                d.e(au);
                            }
                        } else if (au instanceof l) {
                            d.f(au);
                        }
                    }
                    if (k.Y(bjVar)) {
                        au.zv("1");
                    } else if (l.Y(bjVar)) {
                        au.zv("2");
                    }
                    if (au != null && au.isValid()) {
                        linkedList.add(au);
                    }
                    k av2 = d.av(bjVar);
                    if (av2 != null) {
                        av2.tid = bjVar.getTid();
                        av2.position = i3;
                        d.g(av2);
                    }
                    if (k.Y(bjVar)) {
                        av2.zv("1");
                    } else if (l.Y(bjVar)) {
                        av2.zv("2");
                    }
                    if (av2 != null && !StringUtils.isNull(bjVar.azJ())) {
                        linkedList.add(av2);
                    }
                    if (concernData.thread_list != null && concernData.thread_list.top_agree_post != null) {
                        k av3 = d.av(bjVar);
                        if (av3 != null) {
                            av3.tid = bjVar.getTid();
                            av3.position = i3;
                            d.i(av3);
                        }
                        if (k.Y(bjVar)) {
                            av3.zv("1");
                        } else if (l.Y(bjVar)) {
                            av3.zv("2");
                        }
                        if (av3 != null && av3.isValid()) {
                            linkedList.add(av3);
                        }
                    }
                    k av4 = d.av(bjVar);
                    if (av4 != null) {
                        av4.tid = bjVar.getTid();
                        av4.position = i3;
                        d.j(av4);
                    }
                    if (bjVar.getType() == bj.cMV) {
                        av4.zv("1");
                    } else if (l.Y(bjVar)) {
                        av4.zv("2");
                    }
                    if (av4 != null && av4.isValid()) {
                        linkedList.add(av4);
                    }
                } else if (bjVar.isShareThread) {
                    k kVar = new k();
                    kVar.cMR = bjVar;
                    kVar.position = i3;
                    linkedList.add(kVar);
                } else if (l.Y(bjVar)) {
                    l lVar = new l(bjVar);
                    lVar.tid = bjVar.getTid();
                    lVar.ri(concernData.source.intValue());
                    if (lVar.isValid()) {
                        linkedList.add(lVar);
                    }
                } else if (j.Y(bjVar)) {
                    j jVar = new j(bjVar);
                    if (jVar != null) {
                        jVar.tid = bjVar.getTid();
                        jVar.zv("3");
                    }
                    if (jVar != null && jVar.isValid()) {
                        linkedList.add(jVar);
                    }
                } else if (e.Y(bjVar) && bjVar.ays()) {
                    e eVar = new e(bjVar);
                    eVar.position = i3;
                    linkedList.add(eVar);
                } else {
                    k kVar2 = new k();
                    kVar2.cMR = bjVar;
                    kVar2.zv(kVar2.cMR.isLinkThread() ? "4" : "1");
                    kVar2.position = i3;
                    kVar2.isLinkThread = false;
                    kVar2.ri(concernData.source.intValue());
                    if (kVar2.cMR != null && kVar2.isValid() && !StringUtils.isNull(kVar2.cMR.getId()) && !"0".equals(kVar2.cMR.getTid())) {
                        linkedList.add(kVar2);
                    }
                }
                i2 = i3 + 1;
            }
            i3 = i2;
        }
        this.gSU.dOP = linkedList;
        return this.gSU;
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
            this.gSU.gZD = v.getCount(list) - count;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
