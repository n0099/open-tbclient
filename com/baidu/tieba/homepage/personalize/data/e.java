package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes6.dex */
public class e {
    public int ezF;
    public List<String> ezG;
    public long ezH;
    public String ezI;
    public int ezJ;

    public boolean aMl() {
        return this.ezF > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ezF = dataRes.user_count.intValue();
            this.ezG = dataRes.portrait_list;
            this.ezH = dataRes.hide_unix.longValue() * 1000;
            this.ezI = dataRes.show_tip;
            this.ezJ = dataRes.thread_count.intValue();
        }
    }
}
