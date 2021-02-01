package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int klq;
    public List<String> klr;
    public long kls;
    public String klt;
    public int mThreadCount;

    public boolean cRB() {
        return this.klq > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.klq = dataRes.user_count.intValue();
            this.klr = dataRes.portrait_list;
            this.kls = dataRes.hide_unix.longValue() * 1000;
            this.klt = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
