package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int dZi;
    public List<String> dZj;
    public long dZk;
    public String dZl;
    public int dZm;

    public boolean aEB() {
        return this.dZi > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dZi = dataRes.user_count.intValue();
            this.dZj = dataRes.portrait_list;
            this.dZk = dataRes.hide_unix.longValue() * 1000;
            this.dZl = dataRes.show_tip;
            this.dZm = dataRes.thread_count.intValue();
        }
    }
}
