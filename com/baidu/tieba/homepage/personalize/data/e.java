package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int eeC;
    public List<String> eeD;
    public long eeE;
    public String eeF;
    public int eeG;

    public boolean aBz() {
        return this.eeC > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.eeC = dataRes.user_count.intValue();
            this.eeD = dataRes.portrait_list;
            this.eeE = dataRes.hide_unix.longValue() * 1000;
            this.eeF = dataRes.show_tip;
            this.eeG = dataRes.thread_count.intValue();
        }
    }
}
