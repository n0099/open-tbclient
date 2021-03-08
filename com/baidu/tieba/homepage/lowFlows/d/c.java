package com.baidu.tieba.homepage.lowFlows.d;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.MoreTreasureTrove.MoreTreasureTroveResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class c {
    public static List<n> a(MoreTreasureTroveResIdl moreTreasureTroveResIdl) {
        if (moreTreasureTroveResIdl == null || moreTreasureTroveResIdl.data == null || y.isEmpty(moreTreasureTroveResIdl.data.hot_thread_info)) {
            return null;
        }
        return ea(moreTreasureTroveResIdl.data.hot_thread_info);
    }

    private static List<n> ea(List<ThreadInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ThreadInfo threadInfo : list) {
            cb cbVar = new cb();
            cbVar.a(threadInfo);
            cbVar.eVl = true;
            arrayList.add(cbVar);
        }
        return com.baidu.tieba.homepage.hotTopic.tab.c.dX(arrayList);
    }
}
