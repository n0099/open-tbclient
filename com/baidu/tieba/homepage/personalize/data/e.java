package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes6.dex */
public class e {
    public int gZs;
    public List<String> gZt;
    public long gZu;
    public String gZv;
    public int mThreadCount;

    public boolean bMt() {
        return this.gZs > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gZs = dataRes.user_count.intValue();
            this.gZt = dataRes.portrait_list;
            this.gZu = dataRes.hide_unix.longValue() * 1000;
            this.gZv = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
