package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes6.dex */
public class e {
    public int eAp;
    public List<String> eAq;
    public long eAr;
    public String eAs;
    public int eAt;

    public boolean aML() {
        return this.eAp > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.eAp = dataRes.user_count.intValue();
            this.eAq = dataRes.portrait_list;
            this.eAr = dataRes.hide_unix.longValue() * 1000;
            this.eAs = dataRes.show_tip;
            this.eAt = dataRes.thread_count.intValue();
        }
    }
}
