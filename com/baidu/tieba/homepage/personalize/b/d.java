package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class d {
    public static long exk;
    private String exj;

    public void cp(List<h> list) {
        com.baidu.tieba.card.data.c cVar;
        int i = 0;
        if (TbadkCoreApplication.isLogin()) {
            if (this.exj == null) {
                this.exj = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            if (!StringUtils.isNull(this.exj)) {
                String[] split = this.exj.split(",");
                if (split.length == 2) {
                    String str = split[0];
                    long d = com.baidu.adp.lib.g.b.d(split[1], 0L);
                    if (d == 0 || StringUtils.isNull(str) || v.I(list)) {
                        return;
                    }
                    while (true) {
                        int i2 = i;
                        if (i2 < list.size()) {
                            if (!(list.get(i2) instanceof com.baidu.tieba.card.data.c) || (cVar = (com.baidu.tieba.card.data.c) list.get(i2)) == null || StringUtils.isNull(cVar.tid) || !cVar.tid.equals(str)) {
                                i = i2 + 1;
                            } else {
                                c cVar2 = new c();
                                cVar2.mTimeStamp = d;
                                if (i2 + 1 < list.size()) {
                                    list.add(i2 + 1, cVar2);
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
        if (TbadkCoreApplication.isLogin() && !v.I(list) && i == v.H(list2) - 1 && z && (threadInfo = (ThreadInfo) v.d(list2, i)) != null && threadInfo.tid != null && threadInfo.tid.longValue() != 0) {
            System.currentTimeMillis();
            this.exj = null;
            exk = threadInfo.tid.longValue();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
        }
    }

    public static void a(long j, int i, List<ThreadInfo> list, List<h> list2) {
        if (j == exk && !v.I(list) && !v.I(list2)) {
            if (i == 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < list2.size()) {
                        if (!(list2.get(i3) instanceof c)) {
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
                final ThreadInfo threadInfo = list.get(i - 1);
                if (threadInfo != null && threadInfo.tid.longValue() != 0) {
                    exk = threadInfo.tid.longValue();
                    x.a(new w<Object>() { // from class: com.baidu.tieba.homepage.personalize.b.d.1
                        @Override // com.baidu.tbadk.util.w
                        public Object doInBackground() {
                            String[] split = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "").split(",");
                            if (split.length == 2) {
                                String str = split[0];
                                long d = com.baidu.adp.lib.g.b.d(split[1], 0L);
                                if (d != 0 && !StringUtils.isNull(str)) {
                                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), ThreadInfo.this.tid + "," + d);
                                }
                            }
                            return null;
                        }
                    }, null);
                }
            }
        }
    }
}
