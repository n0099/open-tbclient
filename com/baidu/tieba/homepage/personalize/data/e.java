package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int egm;
    public List<String> egn;
    public long ego;
    public String egp;
    public int egq;

    public boolean aBJ() {
        return this.egm > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.egm = dataRes.user_count.intValue();
            this.egn = dataRes.portrait_list;
            this.ego = dataRes.hide_unix.longValue() * 1000;
            this.egp = dataRes.show_tip;
            this.egq = dataRes.thread_count.intValue();
        }
    }
}
