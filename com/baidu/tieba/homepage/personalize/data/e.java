package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {
    public int fNc;
    public List<String> fNd;
    public long fNe;
    public String fNf;
    public int fNg;

    public boolean bmR() {
        return this.fNc > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fNc = dataRes.user_count.intValue();
            this.fNd = dataRes.portrait_list;
            this.fNe = dataRes.hide_unix.longValue() * 1000;
            this.fNf = dataRes.show_tip;
            this.fNg = dataRes.thread_count.intValue();
        }
    }
}
