package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {
    public int gel;
    public List<String> gem;
    public long gen;
    public String gep;
    public int geq;

    public boolean buw() {
        return this.gel > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gel = dataRes.user_count.intValue();
            this.gem = dataRes.portrait_list;
            this.gen = dataRes.hide_unix.longValue() * 1000;
            this.gep = dataRes.show_tip;
            this.geq = dataRes.thread_count.intValue();
        }
    }
}
