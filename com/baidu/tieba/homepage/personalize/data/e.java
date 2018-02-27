package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int ekm;
    public List<String> ekn;
    public long eko;
    public String ekp;
    public int ekq;

    public boolean aDc() {
        return this.ekm > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.ekm = dataRes.user_count.intValue();
            this.ekn = dataRes.portrait_list;
            this.eko = dataRes.hide_unix.longValue() * 1000;
            this.ekp = dataRes.show_tip;
            this.ekq = dataRes.thread_count.intValue();
        }
    }
}
