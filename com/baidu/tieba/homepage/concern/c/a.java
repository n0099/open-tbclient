package com.baidu.tieba.homepage.concern.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.homepage.personalize.c.d;
import com.baidu.tieba.homepage.personalize.model.c;
import java.util.LinkedList;
import java.util.List;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes.dex */
public class a {
    private d cZe = new d();
    private final c cZd = new c();
    private final int beU = b.getInstance().getInt("home_page_max_thread_count", 300);

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
                bj bjVar = new bj();
                bjVar.a(concernData.thread_list);
                if (n.F(bjVar)) {
                    n nVar = new n(bjVar);
                    if (nVar != null) {
                        nVar.Xe = bjVar.getTid();
                    }
                    if (nVar != null && nVar.isValid()) {
                        linkedList.add(nVar);
                    }
                } else if (k.F(bjVar)) {
                    k kVar = new k(bjVar);
                    if (kVar != null) {
                        kVar.Xe = bjVar.getTid();
                        kVar.jx(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                    }
                    if (kVar != null && kVar.isValid()) {
                        linkedList.add(kVar);
                    }
                } else {
                    l lVar = new l();
                    if (lVar != null) {
                        lVar.threadData = bjVar;
                        lVar.jx(lVar.threadData.isLinkThread() ? "4" : "1");
                        lVar.isLinkThread = false;
                    }
                    if (lVar.threadData != null && lVar.isValid() && !StringUtils.isNull(lVar.threadData.getId()) && !"0".equals(lVar.threadData.getTid())) {
                        linkedList.add(lVar);
                    }
                }
            }
        }
        this.cZd.aTF = linkedList;
        return this.cZd;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder.thread_info != null && builder2.thread_info != null) {
            a(z, builder.thread_info, builder2.thread_info, i);
        }
    }

    private void a(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        if (list != null && list2 != null) {
            int u = v.u(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (concernData != null && concernData.thread_list.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                list.clear();
                for (int u2 = v.u(list2) - 1; u2 >= 0; u2--) {
                    ConcernData concernData2 = (ConcernData) v.c(list2, u2);
                    if (concernData2 != null && concernData2.thread_list.tid != null) {
                        list.add(0, concernData2);
                    }
                }
            }
            this.cZd.ddt = v.u(list) - u;
        }
    }

    public static void c(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
