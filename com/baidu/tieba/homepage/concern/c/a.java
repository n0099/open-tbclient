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
/* loaded from: classes7.dex */
public class a {
    private final c gWo = new c();

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
                    bVar.mw(builder.thread_info.size() > 1);
                    linkedList.add(bVar);
                    i3++;
                }
            } else {
                bj bjVar = new bj();
                bjVar.fx(true);
                bjVar.a(concernData.thread_list);
                if ((k.Z(bjVar) || l.Z(bjVar)) && bjVar.getType() != bj.cNz) {
                    int[] imageWidthAndHeight = bjVar.getImageWidthAndHeight();
                    k aw = d.aw(bjVar);
                    if (aw != null) {
                        aw.tid = bjVar.getTid();
                        aw.position = i3;
                        d.a(aw);
                    }
                    if (k.Z(bjVar)) {
                        aw.zF("1");
                    } else if (l.Z(bjVar)) {
                        aw.zF("2");
                    }
                    if (aw != null && aw.isValid()) {
                        linkedList.add(aw);
                    }
                    com.baidu.tieba.card.data.c av = d.av(bjVar);
                    if (av != null) {
                        av.tid = bjVar.getTid();
                        av.position = i3;
                        if (av instanceof k) {
                            if (bjVar.aBT()) {
                                d.d(av);
                            } else if (bjVar.aBb() == 1) {
                                d.b(av);
                                av.cNc = imageWidthAndHeight[0];
                                av.cNd = imageWidthAndHeight[1];
                            } else if (bjVar.aBb() >= 2) {
                                d.c(av);
                            } else {
                                d.e(av);
                            }
                        } else if (av instanceof l) {
                            d.f(av);
                        }
                    }
                    if (k.Z(bjVar)) {
                        av.zF("1");
                    } else if (l.Z(bjVar)) {
                        av.zF("2");
                    }
                    if (av != null && av.isValid()) {
                        linkedList.add(av);
                    }
                    k aw2 = d.aw(bjVar);
                    if (aw2 != null) {
                        aw2.tid = bjVar.getTid();
                        aw2.position = i3;
                        d.g(aw2);
                    }
                    if (k.Z(bjVar)) {
                        aw2.zF("1");
                    } else if (l.Z(bjVar)) {
                        aw2.zF("2");
                    }
                    if (aw2 != null && !StringUtils.isNull(bjVar.aAc())) {
                        linkedList.add(aw2);
                    }
                    if (concernData.thread_list != null && concernData.thread_list.top_agree_post != null) {
                        k aw3 = d.aw(bjVar);
                        if (aw3 != null) {
                            aw3.tid = bjVar.getTid();
                            aw3.position = i3;
                            d.i(aw3);
                        }
                        if (k.Z(bjVar)) {
                            aw3.zF("1");
                        } else if (l.Z(bjVar)) {
                            aw3.zF("2");
                        }
                        if (aw3 != null && aw3.isValid()) {
                            linkedList.add(aw3);
                        }
                    }
                    k aw4 = d.aw(bjVar);
                    if (aw4 != null) {
                        aw4.tid = bjVar.getTid();
                        aw4.position = i3;
                        d.j(aw4);
                    }
                    if (bjVar.getType() == bj.cNf) {
                        aw4.zF("1");
                    } else if (l.Z(bjVar)) {
                        aw4.zF("2");
                    }
                    if (aw4 != null && aw4.isValid()) {
                        linkedList.add(aw4);
                    }
                } else if (bjVar.isShareThread) {
                    k kVar = new k();
                    kVar.cNb = bjVar;
                    kVar.position = i3;
                    linkedList.add(kVar);
                } else if (l.Z(bjVar)) {
                    l lVar = new l(bjVar);
                    lVar.tid = bjVar.getTid();
                    lVar.rn(concernData.source.intValue());
                    if (lVar.isValid()) {
                        linkedList.add(lVar);
                    }
                } else if (j.Z(bjVar)) {
                    j jVar = new j(bjVar);
                    if (jVar != null) {
                        jVar.tid = bjVar.getTid();
                        jVar.zF("3");
                    }
                    if (jVar != null && jVar.isValid()) {
                        linkedList.add(jVar);
                    }
                } else if (e.Z(bjVar) && bjVar.ayL()) {
                    e eVar = new e(bjVar);
                    eVar.position = i3;
                    linkedList.add(eVar);
                } else {
                    k kVar2 = new k();
                    kVar2.cNb = bjVar;
                    kVar2.zF(kVar2.cNb.isLinkThread() ? "4" : "1");
                    kVar2.position = i3;
                    kVar2.isLinkThread = false;
                    kVar2.rn(concernData.source.intValue());
                    if (kVar2.cNb != null && kVar2.isValid() && !StringUtils.isNull(kVar2.cNb.getId()) && !"0".equals(kVar2.cNb.getTid())) {
                        linkedList.add(kVar2);
                    }
                }
                i2 = i3 + 1;
            }
            i3 = i2;
        }
        this.gWo.dOX = linkedList;
        return this.gWo;
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
            this.gWo.hdb = v.getCount(list) - count;
        }
    }

    public static void b(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
