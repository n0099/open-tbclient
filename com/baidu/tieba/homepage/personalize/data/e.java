package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes22.dex */
public class e {
    public int jFX;
    public List<String> jFY;
    public long jFZ;
    public String jGa;
    public int mThreadCount;

    public boolean cLs() {
        return this.jFX > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jFX = dataRes.user_count.intValue();
            this.jFY = dataRes.portrait_list;
            this.jFZ = dataRes.hide_unix.longValue() * 1000;
            this.jGa = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
