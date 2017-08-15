package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.util.t;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class d {
    public static long cXa;
    private String cWZ;

    public void bB(List<f> list) {
        com.baidu.tieba.card.data.c cVar;
        int i = 0;
        if (TbadkCoreApplication.isLogin()) {
            if (this.cWZ == null) {
                this.cWZ = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            if (!StringUtils.isNull(this.cWZ)) {
                String[] split = this.cWZ.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length == 2) {
                    String str = split[0];
                    long d = com.baidu.adp.lib.g.b.d(split[1], 0L);
                    if (d == 0 || StringUtils.isNull(str) || u.v(list)) {
                        return;
                    }
                    while (true) {
                        int i2 = i;
                        if (i2 < list.size()) {
                            if (!(list.get(i2) instanceof com.baidu.tieba.card.data.c) || (cVar = (com.baidu.tieba.card.data.c) list.get(i2)) == null || StringUtils.isNull(cVar.XU) || !cVar.XU.equals(str)) {
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
        if (TbadkCoreApplication.isLogin() && !u.v(list) && i == u.u(list2) - 1 && z && (threadInfo = (ThreadInfo) u.c(list2, i)) != null && threadInfo.tid != null && threadInfo.tid.longValue() != 0) {
            System.currentTimeMillis();
            this.cWZ = null;
            cXa = threadInfo.tid.longValue();
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + Constants.ACCEPT_TIME_SEPARATOR_SP + System.currentTimeMillis());
        }
    }

    public static void a(long j, int i, List<ThreadInfo> list, List<f> list2) {
        if (j == cXa && !u.v(list) && !u.v(list2)) {
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
                    cXa = threadInfo.tid.longValue();
                    com.baidu.tbadk.util.u.a(new t<Object>() { // from class: com.baidu.tieba.homepage.personalize.c.d.1
                        @Override // com.baidu.tbadk.util.t
                        public Object doInBackground() {
                            String[] split = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            if (split.length == 2) {
                                String str = split[0];
                                long d = com.baidu.adp.lib.g.b.d(split[1], 0L);
                                if (d != 0 && !StringUtils.isNull(str)) {
                                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("read_progress_" + TbadkCoreApplication.getCurrentAccount(), ThreadInfo.this.tid + Constants.ACCEPT_TIME_SEPARATOR_SP + d);
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
