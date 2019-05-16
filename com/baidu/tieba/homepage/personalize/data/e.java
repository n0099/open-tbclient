package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {
    public int gek;
    public List<String> gel;
    public long gem;
    public String gen;
    public int gep;

    public boolean but() {
        return this.gek > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gek = dataRes.user_count.intValue();
            this.gel = dataRes.portrait_list;
            this.gem = dataRes.hide_unix.longValue() * 1000;
            this.gen = dataRes.show_tip;
            this.gep = dataRes.thread_count.intValue();
        }
    }
}
