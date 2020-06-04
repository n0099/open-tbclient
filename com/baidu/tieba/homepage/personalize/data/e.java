package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes9.dex */
public class e {
    public int ifG;
    public List<String> ifH;
    public long ifI;
    public String ifJ;
    public int mThreadCount;

    public boolean cgy() {
        return this.ifG > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ifG = dataRes.user_count.intValue();
            this.ifH = dataRes.portrait_list;
            this.ifI = dataRes.hide_unix.longValue() * 1000;
            this.ifJ = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
