package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int knG;
    public List<String> knH;
    public long knI;
    public String knJ;
    public int mThreadCount;

    public boolean cRP() {
        return this.knG > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.knG = dataRes.user_count.intValue();
            this.knH = dataRes.portrait_list;
            this.knI = dataRes.hide_unix.longValue() * 1000;
            this.knJ = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
