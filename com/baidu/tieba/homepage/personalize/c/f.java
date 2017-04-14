package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.t;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class f {
    public static long czy;
    private String czx;

    public void bf(List<v> list) {
        com.baidu.tieba.card.data.c cVar;
        int i = 0;
        if (TbadkCoreApplication.isLogin()) {
            if (this.czx == null) {
                this.czx = com.baidu.tbadk.core.sharedPref.b.uL().getString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            if (!StringUtils.isNull(this.czx)) {
                String[] split = this.czx.split(",");
                if (split.length == 2) {
                    String str = split[0];
                    long c = com.baidu.adp.lib.g.b.c(split[1], 0L);
                    if (c == 0 || StringUtils.isNull(str) || x.q(list)) {
                        return;
                    }
                    while (true) {
                        int i2 = i;
                        if (i2 < list.size()) {
                            if (!(list.get(i2) instanceof com.baidu.tieba.card.data.c) || (cVar = (com.baidu.tieba.card.data.c) list.get(i2)) == null || StringUtils.isNull(cVar.WS) || !cVar.WS.equals(str)) {
                                i = i2 + 1;
                            } else {
                                e eVar = new e();
                                eVar.mTimeStamp = c;
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
        if (TbadkCoreApplication.isLogin() && !x.q(list) && i == x.p(list2) - 1 && z && (threadInfo = (ThreadInfo) x.c(list2, i)) != null && threadInfo.tid != null && threadInfo.tid.longValue() != 0) {
            System.currentTimeMillis();
            this.czx = null;
            czy = threadInfo.tid.longValue();
            com.baidu.tbadk.core.sharedPref.b.uL().putString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
        }
    }

    public static void a(long j, int i, List<ThreadInfo> list, List<v> list2) {
        if (j == czy && !x.q(list) && !x.q(list2)) {
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
                    czy = threadInfo.tid.longValue();
                    t.a(new g(threadInfo), null);
                }
            }
        }
    }
}
