package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes21.dex */
public class e {
    public int iYB;
    public List<String> iYC;
    public long iYD;
    public String iYE;
    public int mThreadCount;

    public boolean cCb() {
        return this.iYB > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iYB = dataRes.user_count.intValue();
            this.iYC = dataRes.portrait_list;
            this.iYD = dataRes.hide_unix.longValue() * 1000;
            this.iYE = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
