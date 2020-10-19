package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes22.dex */
public class e {
    public int jnA;
    public List<String> jnB;
    public long jnC;
    public String jnD;
    public int mThreadCount;

    public boolean cFK() {
        return this.jnA > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jnA = dataRes.user_count.intValue();
            this.jnB = dataRes.portrait_list;
            this.jnC = dataRes.hide_unix.longValue() * 1000;
            this.jnD = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
