package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int klE;
    public List<String> klF;
    public long klG;
    public String klH;
    public int mThreadCount;

    public boolean cRI() {
        return this.klE > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.klE = dataRes.user_count.intValue();
            this.klF = dataRes.portrait_list;
            this.klG = dataRes.hide_unix.longValue() * 1000;
            this.klH = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
