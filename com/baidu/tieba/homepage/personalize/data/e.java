package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes6.dex */
public class e {
    public int ewM;
    public List<String> ewN;
    public long ewO;
    public String ewP;
    public int ewQ;

    public boolean aLy() {
        return this.ewM > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ewM = dataRes.user_count.intValue();
            this.ewN = dataRes.portrait_list;
            this.ewO = dataRes.hide_unix.longValue() * 1000;
            this.ewP = dataRes.show_tip;
            this.ewQ = dataRes.thread_count.intValue();
        }
    }
}
