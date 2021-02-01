package com.baidu.tieba.homepage.personalize.readProgressBar;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.homepage.personalize.data.i;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class c {
    public static long kmc;
    private String kmb;

    public void eg(List<n> list) {
        com.baidu.tieba.card.data.b bVar;
        if (TbadkCoreApplication.isLogin()) {
            if (this.kmb == null) {
                this.kmb = com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.READ_PROGRESS_PREFIX + TbadkCoreApplication.getCurrentAccount(), "");
            }
            if (!StringUtils.isNull(this.kmb)) {
                String[] split = this.kmb.split(",");
                if (split.length == 2) {
                    String str = split[0];
                    long j = com.baidu.adp.lib.f.b.toLong(split[1], 0L);
                    if (j != 0 && !StringUtils.isNull(str) && !y.isEmpty(list)) {
                        for (int i = 0; i < list.size(); i++) {
                            if ((list.get(i) instanceof com.baidu.tieba.card.data.b) && (bVar = (com.baidu.tieba.card.data.b) list.get(i)) != null && !StringUtils.isNull(bVar.tid) && bVar.tid.equals(str)) {
                                b bVar2 = new b();
                                bVar2.mTimeStamp = j;
                                bVar2.kma = false;
                                list.add(i, bVar2);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public void g(boolean z, List<ThreadInfo> list) {
        ThreadInfo threadInfo;
        if (TbadkCoreApplication.isLogin() && !y.isEmpty(list) && z && (threadInfo = (ThreadInfo) y.getItem(list, 0)) != null && threadInfo.tid != null && threadInfo.tid.longValue() != 0) {
            this.kmb = null;
            kmc = threadInfo.tid.longValue();
            com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.READ_PROGRESS_PREFIX + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
        }
    }

    public void b(ThreadInfo threadInfo) {
        if (i.klx && threadInfo != null && threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() != 0) {
            this.kmb = null;
            kmc = threadInfo.tid.longValue();
            com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.READ_PROGRESS_PREFIX + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
        }
    }

    public static void a(long j, int i, List<ThreadInfo> list, List<n> list2) {
        final ThreadInfo threadInfo;
        if (j == kmc && !y.isEmpty(list) && !y.isEmpty(list2)) {
            if (i == 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < list2.size()) {
                        if (!(list2.get(i3) instanceof b)) {
                            i2 = i3 + 1;
                        } else {
                            list2.remove(i3);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } else if (y.getCount(list) > i + 1 && (threadInfo = list.get(i + 1)) != null && threadInfo.tid.longValue() != 0) {
                kmc = threadInfo.tid.longValue();
                af.a(new ae<Object>() { // from class: com.baidu.tieba.homepage.personalize.readProgressBar.c.1
                    @Override // com.baidu.tbadk.util.ae
                    public Object doInBackground() {
                        String[] split = com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.READ_PROGRESS_PREFIX + TbadkCoreApplication.getCurrentAccount(), "").split(",");
                        if (split.length == 2) {
                            String str = split[0];
                            long j2 = com.baidu.adp.lib.f.b.toLong(split[1], 0L);
                            if (j2 != 0 && !StringUtils.isNull(str)) {
                                com.baidu.tbadk.core.sharedPref.b.brQ().putString(SharedPrefConfig.READ_PROGRESS_PREFIX + TbadkCoreApplication.getCurrentAccount(), ThreadInfo.this.tid + "," + j2);
                            }
                        }
                        return null;
                    }
                }, null);
            }
        }
    }
}
