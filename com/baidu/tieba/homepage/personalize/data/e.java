package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {
    public int fNp;
    public List<String> fNq;
    public long fNr;
    public String fNs;
    public int fNt;

    public boolean bmV() {
        return this.fNp > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fNp = dataRes.user_count.intValue();
            this.fNq = dataRes.portrait_list;
            this.fNr = dataRes.hide_unix.longValue() * 1000;
            this.fNs = dataRes.show_tip;
            this.fNt = dataRes.thread_count.intValue();
        }
    }
}
