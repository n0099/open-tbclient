package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int kdg;
    public List<String> kdh;
    public long kdi;
    public String kdj;
    public int mThreadCount;

    public boolean cPC() {
        return this.kdg > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.kdg = dataRes.user_count.intValue();
            this.kdh = dataRes.portrait_list;
            this.kdi = dataRes.hide_unix.longValue() * 1000;
            this.kdj = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
