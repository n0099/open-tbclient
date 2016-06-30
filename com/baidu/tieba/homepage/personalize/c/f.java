package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class f {
    private final long byU = TbConfig.APP_OVERDUR_DRAFT_BOX;
    private String csY;

    public void bs(List<v> list) {
        com.baidu.tieba.card.a.c cVar;
        int i = 0;
        if (TbadkCoreApplication.isLogin()) {
            if (this.csY == null) {
                this.csY = com.baidu.tbadk.core.sharedPref.b.sO().getString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            if (!StringUtils.isNull(this.csY)) {
                String[] split = this.csY.split(",");
                if (split.length == 2) {
                    String str = split[0];
                    long c = com.baidu.adp.lib.h.b.c(split[1], 0L);
                    if (c == 0 || StringUtils.isNull(str) || y.t(list)) {
                        return;
                    }
                    while (true) {
                        int i2 = i;
                        if (i2 < list.size()) {
                            if (!(list.get(i2) instanceof com.baidu.tieba.card.a.c) || (cVar = (com.baidu.tieba.card.a.c) list.get(i2)) == null || StringUtils.isNull(cVar.tid) || !cVar.tid.equals(str)) {
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
        if (TbadkCoreApplication.isLogin() && !y.t(list) && i == y.s(list2) - 1 && z && (threadInfo = (ThreadInfo) y.c(list2, i)) != null && threadInfo.tid != null && threadInfo.tid.longValue() != 0) {
            System.currentTimeMillis();
            this.csY = null;
            com.baidu.tbadk.core.sharedPref.b.sO().putString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
        }
    }
}
