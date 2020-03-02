package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes9.dex */
public class e {
    public int heS;
    public List<String> heT;
    public long heU;
    public String heV;
    public int mThreadCount;

    public boolean bPf() {
        return this.heS > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.heS = dataRes.user_count.intValue();
            this.heT = dataRes.portrait_list;
            this.heU = dataRes.hide_unix.longValue() * 1000;
            this.heV = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
