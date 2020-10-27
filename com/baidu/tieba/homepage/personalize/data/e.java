package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes22.dex */
public class e {
    public int jAa;
    public List<String> jAb;
    public long jAc;
    public String jAd;
    public int mThreadCount;

    public boolean cIR() {
        return this.jAa > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jAa = dataRes.user_count.intValue();
            this.jAb = dataRes.portrait_list;
            this.jAc = dataRes.hide_unix.longValue() * 1000;
            this.jAd = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
