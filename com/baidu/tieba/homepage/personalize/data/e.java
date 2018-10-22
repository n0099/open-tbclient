package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes6.dex */
public class e {
    public List<String> eoA;
    public long eoB;
    public String eoC;
    public int eoD;
    public int eoz;

    public boolean aKi() {
        return this.eoz > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.eoz = dataRes.user_count.intValue();
            this.eoA = dataRes.portrait_list;
            this.eoB = dataRes.hide_unix.longValue() * 1000;
            this.eoC = dataRes.show_tip;
            this.eoD = dataRes.thread_count.intValue();
        }
    }
}
