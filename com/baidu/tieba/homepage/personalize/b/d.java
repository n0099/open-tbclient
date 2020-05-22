package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.homepage.personalize.data.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class d {
    public static long ifE;
    private String ifD;

    public void cP(List<o> list) {
        com.baidu.tieba.card.data.c cVar;
        if (TbadkCoreApplication.isLogin()) {
            if (this.ifD == null) {
                this.ifD = com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.READ_PROGRESS_PREFIX + TbadkCoreApplication.getCurrentAccount(), "");
            }
            if (!StringUtils.isNull(this.ifD)) {
                String[] split = this.ifD.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length == 2) {
                    String str = split[0];
                    long j = com.baidu.adp.lib.f.b.toLong(split[1], 0L);
                    if (j != 0 && !StringUtils.isNull(str) && !v.isEmpty(list)) {
                        for (int i = 0; i < list.size(); i++) {
                            if ((list.get(i) instanceof com.baidu.tieba.card.data.c) && (cVar = (com.baidu.tieba.card.data.c) list.get(i)) != null && !StringUtils.isNull(cVar.tid) && cVar.tid.equals(str)) {
                                c cVar2 = new c();
                                cVar2.mTimeStamp = j;
                                cVar2.ifC = false;
                                list.add(i, cVar2);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public void e(boolean z, List<ThreadInfo> list) {
        ThreadInfo threadInfo;
        if (TbadkCoreApplication.isLogin() && !v.isEmpty(list) && z && (threadInfo = (ThreadInfo) v.getItem(list, 0)) != null && threadInfo.tid != null && threadInfo.tid.longValue() != 0) {
            this.ifD = null;
            ifE = threadInfo.tid.longValue();
            com.baidu.tbadk.core.sharedPref.b.aTX().putString(SharedPrefConfig.READ_PROGRESS_PREFIX + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + Constants.ACCEPT_TIME_SEPARATOR_SP + System.currentTimeMillis());
        }
    }

    public void b(ThreadInfo threadInfo) {
        if (h.ifa && threadInfo != null && threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() != 0) {
            this.ifD = null;
            ifE = threadInfo.tid.longValue();
            com.baidu.tbadk.core.sharedPref.b.aTX().putString(SharedPrefConfig.READ_PROGRESS_PREFIX + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + Constants.ACCEPT_TIME_SEPARATOR_SP + System.currentTimeMillis());
        }
    }

    public static void a(long j, int i, List<ThreadInfo> list, List<o> list2) {
        final ThreadInfo threadInfo;
        if (j == ifE && !v.isEmpty(list) && !v.isEmpty(list2)) {
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
            } else if (v.getCount(list) > i + 1 && (threadInfo = list.get(i + 1)) != null && threadInfo.tid.longValue() != 0) {
                ifE = threadInfo.tid.longValue();
                ad.a(new ac<Object>() { // from class: com.baidu.tieba.homepage.personalize.b.d.1
                    @Override // com.baidu.tbadk.util.ac
                    public Object doInBackground() {
                        String[] split = com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.READ_PROGRESS_PREFIX + TbadkCoreApplication.getCurrentAccount(), "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        if (split.length == 2) {
                            String str = split[0];
                            long j2 = com.baidu.adp.lib.f.b.toLong(split[1], 0L);
                            if (j2 != 0 && !StringUtils.isNull(str)) {
                                com.baidu.tbadk.core.sharedPref.b.aTX().putString(SharedPrefConfig.READ_PROGRESS_PREFIX + TbadkCoreApplication.getCurrentAccount(), ThreadInfo.this.tid + Constants.ACCEPT_TIME_SEPARATOR_SP + j2);
                            }
                        }
                        return null;
                    }
                }, null);
            }
        }
    }
}
