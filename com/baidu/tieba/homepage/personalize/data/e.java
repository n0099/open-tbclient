package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes7.dex */
public class e {
    public int hcQ;
    public List<String> hcR;
    public long hcS;
    public String hcT;
    public int mThreadCount;

    public boolean bNB() {
        return this.hcQ > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hcQ = dataRes.user_count.intValue();
            this.hcR = dataRes.portrait_list;
            this.hcS = dataRes.hide_unix.longValue() * 1000;
            this.hcT = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
