package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes9.dex */
public class e {
    public int ieT;
    public List<String> ieU;
    public long ieV;
    public String ieW;
    public int mThreadCount;

    public boolean cgp() {
        return this.ieT > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ieT = dataRes.user_count.intValue();
            this.ieU = dataRes.portrait_list;
            this.ieV = dataRes.hide_unix.longValue() * 1000;
            this.ieW = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
