package com.baidu.tieba.homepage.concern.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.homepage.personalize.model.c;
import java.util.LinkedList;
import java.util.List;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class a {
    private final c egP = new c();
    private final int ccI = b.getInstance().getInt("home_page_max_thread_count", 300);

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
        c(builder);
        c(builder2);
        b(z, builder, builder2, i);
        LinkedList linkedList = new LinkedList();
        for (ConcernData concernData : builder.thread_info) {
            if (concernData != null) {
                bd bdVar = new bd();
                bdVar.a(concernData.thread_list);
                if (bdVar.isShareThread) {
                    k kVar = new k();
                    kVar.threadData = bdVar;
                    linkedList.add(kVar);
                } else if (m.M(bdVar)) {
                    m mVar = new m(bdVar);
                    if (mVar != null) {
                        mVar.tid = bdVar.getTid();
                    }
                    if (mVar != null && mVar.isValid()) {
                        linkedList.add(mVar);
                    }
                } else if (j.M(bdVar)) {
                    j jVar = new j(bdVar);
                    if (jVar != null) {
                        jVar.tid = bdVar.getTid();
                        jVar.kw("3");
                    }
                    if (jVar != null && jVar.isValid()) {
                        linkedList.add(jVar);
                    }
                } else {
                    k kVar2 = new k();
                    if (kVar2 != null) {
                        kVar2.threadData = bdVar;
                        kVar2.kw(kVar2.threadData.isLinkThread() ? "4" : "1");
                        kVar2.isLinkThread = false;
                    }
                    if (kVar2.threadData != null && kVar2.isValid() && !StringUtils.isNull(kVar2.threadData.getId()) && !"0".equals(kVar2.threadData.getTid())) {
                        linkedList.add(kVar2);
                    }
                }
            }
        }
        this.egP.bNQ = linkedList;
        return this.egP;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder.thread_info != null && builder2.thread_info != null) {
            a(z, builder.thread_info, builder2.thread_info, i);
        }
    }

    private void a(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        if (list != null && list2 != null) {
            int D = v.D(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (concernData != null && concernData.thread_list.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                list.clear();
                for (int D2 = v.D(list2) - 1; D2 >= 0; D2--) {
                    ConcernData concernData2 = (ConcernData) v.f(list2, D2);
                    if (concernData2 != null && concernData2.thread_list.tid != null) {
                        list.add(0, concernData2);
                    }
                }
            }
            this.egP.ekJ = v.D(list) - D;
        }
    }

    public static void c(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
