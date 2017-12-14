package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes.dex */
public class e {
    public int dss;
    public List<String> dst;
    public long dsu;
    public String dsv;
    public int dsw;

    public boolean auv() {
        return this.dss > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dss = dataRes.user_count.intValue();
            this.dst = dataRes.portrait_list;
            this.dsu = dataRes.hide_unix.longValue() * 1000;
            this.dsv = dataRes.show_tip;
            this.dsw = dataRes.thread_count.intValue();
        }
    }
}
