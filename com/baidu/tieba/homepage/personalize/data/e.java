package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int dFe;
    public List<String> dFf;
    public long dFg;
    public String dFh;
    public int dFi;

    public boolean ayb() {
        return this.dFe > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dFe = dataRes.user_count.intValue();
            this.dFf = dataRes.portrait_list;
            this.dFg = dataRes.hide_unix.longValue() * 1000;
            this.dFh = dataRes.show_tip;
            this.dFi = dataRes.thread_count.intValue();
        }
    }
}
