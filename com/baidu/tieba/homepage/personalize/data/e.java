package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {
    public int fNo;
    public List<String> fNp;
    public long fNq;
    public String fNr;
    public int fNs;

    public boolean bmU() {
        return this.fNo > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fNo = dataRes.user_count.intValue();
            this.fNp = dataRes.portrait_list;
            this.fNq = dataRes.hide_unix.longValue() * 1000;
            this.fNr = dataRes.show_tip;
            this.fNs = dataRes.thread_count.intValue();
        }
    }
}
