package com.baidu.tieba.homepage.concern.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.homepage.personalize.model.c;
import java.util.LinkedList;
import java.util.List;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes.dex */
public class a {
    private final c doM = new c();
    private final int bmR = b.getInstance().getInt("home_page_max_thread_count", 300);

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
                    l lVar = new l();
                    lVar.threadData = bdVar;
                    linkedList.add(lVar);
                } else if (n.F(bdVar)) {
                    n nVar = new n(bdVar);
                    if (nVar != null) {
                        nVar.tid = bdVar.getTid();
                    }
                    if (nVar != null && nVar.isValid()) {
                        linkedList.add(nVar);
                    }
                } else if (k.F(bdVar)) {
                    k kVar = new k(bdVar);
                    if (kVar != null) {
                        kVar.tid = bdVar.getTid();
                        kVar.jT("3");
                    }
                    if (kVar != null && kVar.isValid()) {
                        linkedList.add(kVar);
                    }
                } else {
                    l lVar2 = new l();
                    if (lVar2 != null) {
                        lVar2.threadData = bdVar;
                        lVar2.jT(lVar2.threadData.isLinkThread() ? "4" : "1");
                        lVar2.isLinkThread = false;
                    }
                    if (lVar2.threadData != null && lVar2.isValid() && !StringUtils.isNull(lVar2.threadData.getId()) && !"0".equals(lVar2.threadData.getTid())) {
                        linkedList.add(lVar2);
                    }
                }
            }
        }
        this.doM.aXE = linkedList;
        return this.doM;
    }

    private void b(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder.thread_info != null && builder2.thread_info != null) {
            a(z, builder.thread_info, builder2.thread_info, i);
        }
    }

    private void a(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        if (list != null && list2 != null) {
            int v = v.v(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (concernData != null && concernData.thread_list.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                list.clear();
                for (int v2 = v.v(list2) - 1; v2 >= 0; v2--) {
                    ConcernData concernData2 = (ConcernData) v.c(list2, v2);
                    if (concernData2 != null && concernData2.thread_list.tid != null) {
                        list.add(0, concernData2);
                    }
                }
            }
            this.doM.dsB = v.v(list) - v;
        }
    }

    public static void c(DataRes.Builder builder) {
        if (builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }
}
