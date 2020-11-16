package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes21.dex */
public class e {
    public int jGW;
    public List<String> jGX;
    public long jGY;
    public String jGZ;
    public int mThreadCount;

    public boolean cKY() {
        return this.jGW > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jGW = dataRes.user_count.intValue();
            this.jGX = dataRes.portrait_list;
            this.jGY = dataRes.hide_unix.longValue() * 1000;
            this.jGZ = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
