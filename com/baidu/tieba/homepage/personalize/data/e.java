package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {
    public List<String> gkA;
    public long gkB;
    public String gkC;
    public int gkD;
    public int gkz;

    public boolean bxb() {
        return this.gkz > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gkz = dataRes.user_count.intValue();
            this.gkA = dataRes.portrait_list;
            this.gkB = dataRes.hide_unix.longValue() * 1000;
            this.gkC = dataRes.show_tip;
            this.gkD = dataRes.thread_count.intValue();
        }
    }
}
