package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes22.dex */
public class e {
    public int jUB;
    public List<String> jUC;
    public long jUD;
    public String jUE;
    public int mThreadCount;

    public boolean cQn() {
        return this.jUB > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jUB = dataRes.user_count.intValue();
            this.jUC = dataRes.portrait_list;
            this.jUD = dataRes.hide_unix.longValue() * 1000;
            this.jUE = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
