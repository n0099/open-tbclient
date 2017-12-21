package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes.dex */
public class e {
    public int dsA;
    public int dsw;
    public List<String> dsx;
    public long dsy;
    public String dsz;

    public boolean auv() {
        return this.dsw > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dsw = dataRes.user_count.intValue();
            this.dsx = dataRes.portrait_list;
            this.dsy = dataRes.hide_unix.longValue() * 1000;
            this.dsz = dataRes.show_tip;
            this.dsA = dataRes.thread_count.intValue();
        }
    }
}
