package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public long ekA;
    public String ekB;
    public int ekC;
    public int eky;
    public List<String> ekz;

    public boolean aDd() {
        return this.eky > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.eky = dataRes.user_count.intValue();
            this.ekz = dataRes.portrait_list;
            this.ekA = dataRes.hide_unix.longValue() * 1000;
            this.ekB = dataRes.show_tip;
            this.ekC = dataRes.thread_count.intValue();
        }
    }
}
