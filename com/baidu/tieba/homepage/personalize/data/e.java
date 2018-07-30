package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int dZl;
    public List<String> dZm;
    public long dZn;
    public String dZo;
    public int dZp;

    public boolean aEE() {
        return this.dZl > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dZl = dataRes.user_count.intValue();
            this.dZm = dataRes.portrait_list;
            this.dZn = dataRes.hide_unix.longValue() * 1000;
            this.dZo = dataRes.show_tip;
            this.dZp = dataRes.thread_count.intValue();
        }
    }
}
