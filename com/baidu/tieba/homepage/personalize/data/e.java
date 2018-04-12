package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int dFh;
    public List<String> dFi;
    public long dFj;
    public String dFk;
    public int dFl;

    public boolean ayb() {
        return this.dFh > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dFh = dataRes.user_count.intValue();
            this.dFi = dataRes.portrait_list;
            this.dFj = dataRes.hide_unix.longValue() * 1000;
            this.dFk = dataRes.show_tip;
            this.dFl = dataRes.thread_count.intValue();
        }
    }
}
