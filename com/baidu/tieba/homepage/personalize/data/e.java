package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes16.dex */
public class e {
    public int iPP;
    public List<String> iPQ;
    public long iPR;
    public String iPS;
    public int mThreadCount;

    public boolean cyt() {
        return this.iPP > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iPP = dataRes.user_count.intValue();
            this.iPQ = dataRes.portrait_list;
            this.iPR = dataRes.hide_unix.longValue() * 1000;
            this.iPS = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
