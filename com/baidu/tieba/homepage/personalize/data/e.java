package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes9.dex */
public class e {
    public int heQ;
    public List<String> heR;
    public long heS;
    public String heT;
    public int mThreadCount;

    public boolean bPd() {
        return this.heQ > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.heQ = dataRes.user_count.intValue();
            this.heR = dataRes.portrait_list;
            this.heS = dataRes.hide_unix.longValue() * 1000;
            this.heT = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
