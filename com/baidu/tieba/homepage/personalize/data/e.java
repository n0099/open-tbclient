package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int dGk;
    public List<String> dGl;
    public long dGm;
    public String dGn;
    public int dGo;

    public boolean axZ() {
        return this.dGk > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dGk = dataRes.user_count.intValue();
            this.dGl = dataRes.portrait_list;
            this.dGm = dataRes.hide_unix.longValue() * 1000;
            this.dGn = dataRes.show_tip;
            this.dGo = dataRes.thread_count.intValue();
        }
    }
}
