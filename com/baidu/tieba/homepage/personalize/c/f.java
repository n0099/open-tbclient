package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.t;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class f {
    public static long czD;
    private String czC;

    public void bz(List<v> list) {
        com.baidu.tieba.card.data.c cVar;
        int i = 0;
        if (TbadkCoreApplication.isLogin()) {
            if (this.czC == null) {
                this.czC = com.baidu.tbadk.core.sharedPref.b.tQ().getString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            if (!StringUtils.isNull(this.czC)) {
                String[] split = this.czC.split(",");
                if (split.length == 2) {
                    String str = split[0];
                    long c = com.baidu.adp.lib.g.b.c(split[1], 0L);
                    if (c == 0 || StringUtils.isNull(str) || w.s(list)) {
                        return;
                    }
                    while (true) {
                        int i2 = i;
                        if (i2 < list.size()) {
                            if (!(list.get(i2) instanceof com.baidu.tieba.card.data.c) || (cVar = (com.baidu.tieba.card.data.c) list.get(i2)) == null || StringUtils.isNull(cVar.SK) || !cVar.SK.equals(str)) {
                                i = i2 + 1;
                            } else {
                                e eVar = new e();
                                eVar.czB = c;
                                if (i2 + 1 < list.size()) {
                                    list.add(i2 + 1, eVar);
                                    return;
                                }
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public void a(boolean z, int i, List<ThreadInfo> list, List<ThreadInfo> list2) {
        ThreadInfo threadInfo;
        if (TbadkCoreApplication.isLogin() && !w.s(list) && i == w.r(list2) - 1 && z && (threadInfo = (ThreadInfo) w.c(list2, i)) != null && threadInfo.tid != null && threadInfo.tid.longValue() != 0) {
            System.currentTimeMillis();
            this.czC = null;
            czD = threadInfo.tid.longValue();
            com.baidu.tbadk.core.sharedPref.b.tQ().putString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
        }
    }

    public static void a(long j, int i, List<ThreadInfo> list, List<v> list2) {
        if (j == czD && !w.s(list) && !w.s(list2)) {
            if (i == 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < list2.size()) {
                        if (!(list2.get(i3) instanceof e)) {
                            i2 = i3 + 1;
                        } else {
                            list2.remove(i3);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } else {
                ThreadInfo threadInfo = list.get(i - 1);
                if (threadInfo != null && threadInfo.tid.longValue() != 0) {
                    czD = threadInfo.tid.longValue();
                    t.a(new g(threadInfo), null);
                }
            }
        }
    }
}
