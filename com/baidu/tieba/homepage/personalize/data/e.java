package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int egE;
    public List<String> egF;
    public long egG;
    public String egH;
    public int egI;

    public boolean aGQ() {
        return this.egE > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.egE = dataRes.user_count.intValue();
            this.egF = dataRes.portrait_list;
            this.egG = dataRes.hide_unix.longValue() * 1000;
            this.egH = dataRes.show_tip;
            this.egI = dataRes.thread_count.intValue();
        }
    }
}
