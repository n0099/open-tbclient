package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes6.dex */
public class e {
    public int eAq;
    public List<String> eAr;
    public long eAs;
    public String eAt;
    public int eAu;

    public boolean aML() {
        return this.eAq > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.eAq = dataRes.user_count.intValue();
            this.eAr = dataRes.portrait_list;
            this.eAs = dataRes.hide_unix.longValue() * 1000;
            this.eAt = dataRes.show_tip;
            this.eAu = dataRes.thread_count.intValue();
        }
    }
}
