package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int dVt;
    public List<String> dVu;
    public long dVv;
    public String dVw;
    public int dVx;

    public boolean aDE() {
        return this.dVt > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dVt = dataRes.user_count.intValue();
            this.dVu = dataRes.portrait_list;
            this.dVv = dataRes.hide_unix.longValue() * 1000;
            this.dVw = dataRes.show_tip;
            this.dVx = dataRes.thread_count.intValue();
        }
    }
}
