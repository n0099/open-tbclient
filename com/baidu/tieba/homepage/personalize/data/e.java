package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int ekC;
    public List<String> ekD;
    public long ekE;
    public String ekF;
    public int ekG;

    public boolean aDd() {
        return this.ekC > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ekC = dataRes.user_count.intValue();
            this.ekD = dataRes.portrait_list;
            this.ekE = dataRes.hide_unix.longValue() * 1000;
            this.ekF = dataRes.show_tip;
            this.ekG = dataRes.thread_count.intValue();
        }
    }
}
