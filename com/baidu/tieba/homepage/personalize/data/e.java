package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes22.dex */
public class e {
    public List<String> jUA;
    public long jUB;
    public String jUC;
    public int jUz;
    public int mThreadCount;

    public boolean cQm() {
        return this.jUz > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jUz = dataRes.user_count.intValue();
            this.jUA = dataRes.portrait_list;
            this.jUB = dataRes.hide_unix.longValue() * 1000;
            this.jUC = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
