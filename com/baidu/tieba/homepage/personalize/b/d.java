package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.homepage.personalize.data.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class d {
    public static long hQU;
    private String hQT;

    public void cS(List<m> list) {
        com.baidu.tieba.card.data.c cVar;
        if (TbadkCoreApplication.isLogin()) {
            if (this.hQT == null) {
                this.hQT = com.baidu.tbadk.core.sharedPref.b.aNT().getString(SharedPrefConfig.READ_PROGRESS_PREFIX + TbadkCoreApplication.getCurrentAccount(), "");
            }
            if (!StringUtils.isNull(this.hQT)) {
                String[] split = this.hQT.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length == 2) {
                    String str = split[0];
                    long j = com.baidu.adp.lib.f.b.toLong(split[1], 0L);
                    if (j != 0 && !StringUtils.isNull(str) && !v.isEmpty(list)) {
                        boolean z = false;
                        for (int i = 0; i < list.size(); i++) {
                            if ((list.get(i) instanceof com.baidu.tieba.card.data.c) && (cVar = (com.baidu.tieba.card.data.c) list.get(i)) != null) {
                                if (!StringUtils.isNull(cVar.tid) && cVar.tid.equals(str)) {
                                    z = true;
                                } else if (!StringUtils.isNull(cVar.tid) && !cVar.tid.equals(str) && z) {
                                    c cVar2 = new c();
                                    cVar2.mTimeStamp = j;
                                    cVar2.hQS = false;
                                    list.add(i, cVar2);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(boolean z, int i, List<ThreadInfo> list, List<ThreadInfo> list2) {
        ThreadInfo threadInfo;
        if (TbadkCoreApplication.isLogin() && !v.isEmpty(list) && i == v.getCount(list2) - 1 && z && (threadInfo = (ThreadInfo) v.getItem(list2, i)) != null && threadInfo.tid != null && threadInfo.tid.longValue() != 0) {
            System.currentTimeMillis();
            this.hQT = null;
            hQU = threadInfo.tid.longValue();
            com.baidu.tbadk.core.sharedPref.b.aNT().putString(SharedPrefConfig.READ_PROGRESS_PREFIX + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + Constants.ACCEPT_TIME_SEPARATOR_SP + System.currentTimeMillis());
        }
    }

    public void ak(List<ThreadInfo> list) {
        ThreadInfo threadInfo;
        if (h.hQv && !v.isEmpty(list) && (threadInfo = (ThreadInfo) v.getItem(list, list.size() - 1)) != null && threadInfo.tid != null && threadInfo.tid.longValue() != 0) {
            this.hQT = null;
            hQU = threadInfo.tid.longValue();
            com.baidu.tbadk.core.sharedPref.b.aNT().putString(SharedPrefConfig.READ_PROGRESS_PREFIX + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + Constants.ACCEPT_TIME_SEPARATOR_SP + System.currentTimeMillis());
        }
    }

    public static void a(long j, int i, List<ThreadInfo> list, List<m> list2) {
        if (j == hQU && !v.isEmpty(list) && !v.isEmpty(list2)) {
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
                    hQU = threadInfo.tid.longValue();
                    ac.a(new ab<Object>() { // from class: com.baidu.tieba.homepage.personalize.b.d.1
                        @Override // com.baidu.tbadk.util.ab
                        public Object doInBackground() {
                            String[] split = com.baidu.tbadk.core.sharedPref.b.aNT().getString(SharedPrefConfig.READ_PROGRESS_PREFIX + TbadkCoreApplication.getCurrentAccount(), "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            if (split.length == 2) {
                                String str = split[0];
                                long j2 = com.baidu.adp.lib.f.b.toLong(split[1], 0L);
                                if (j2 != 0 && !StringUtils.isNull(str)) {
                                    com.baidu.tbadk.core.sharedPref.b.aNT().putString(SharedPrefConfig.READ_PROGRESS_PREFIX + TbadkCoreApplication.getCurrentAccount(), ThreadInfo.this.tid + Constants.ACCEPT_TIME_SEPARATOR_SP + j2);
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
