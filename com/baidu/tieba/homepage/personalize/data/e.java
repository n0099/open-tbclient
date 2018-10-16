package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes6.dex */
public class e {
    public long eoA;
    public String eoB;
    public int eoC;
    public int eoy;
    public List<String> eoz;

    public boolean aKi() {
        return this.eoy > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.eoy = dataRes.user_count.intValue();
            this.eoz = dataRes.portrait_list;
            this.eoA = dataRes.hide_unix.longValue() * 1000;
            this.eoB = dataRes.show_tip;
            this.eoC = dataRes.thread_count.intValue();
        }
    }
}
