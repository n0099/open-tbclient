package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes9.dex */
public class e {
    public int hQi;
    public List<String> hQj;
    public long hQk;
    public String hQl;
    public int mThreadCount;

    public boolean bZV() {
        return this.hQi > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hQi = dataRes.user_count.intValue();
            this.hQj = dataRes.portrait_list;
            this.hQk = dataRes.hide_unix.longValue() * 1000;
            this.hQl = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
