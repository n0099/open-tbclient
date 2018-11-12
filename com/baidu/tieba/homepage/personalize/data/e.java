package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes6.dex */
public class e {
    public int epS;
    public List<String> epT;
    public long epU;
    public String epV;
    public int epW;

    public boolean aJG() {
        return this.epS > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.epS = dataRes.user_count.intValue();
            this.epT = dataRes.portrait_list;
            this.epU = dataRes.hide_unix.longValue() * 1000;
            this.epV = dataRes.show_tip;
            this.epW = dataRes.thread_count.intValue();
        }
    }
}
