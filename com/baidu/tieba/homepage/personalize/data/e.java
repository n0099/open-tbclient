package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes.dex */
public class e {
    public int drn;
    public List<String> dro;
    public long drp;
    public String drq;
    public int drr;

    public boolean aum() {
        return this.drn > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.drn = dataRes.user_count.intValue();
            this.dro = dataRes.portrait_list;
            this.drp = dataRes.hide_unix.longValue() * 1000;
            this.drq = dataRes.show_tip;
            this.drr = dataRes.thread_count.intValue();
        }
    }
}
