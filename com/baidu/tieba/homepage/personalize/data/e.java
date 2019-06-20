package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {
    public int gen;
    public List<String> gep;
    public long geq;
    public String ger;
    public int ges;

    public boolean bux() {
        return this.gen > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gen = dataRes.user_count.intValue();
            this.gep = dataRes.portrait_list;
            this.geq = dataRes.hide_unix.longValue() * 1000;
            this.ger = dataRes.show_tip;
            this.ges = dataRes.thread_count.intValue();
        }
    }
}
