package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes9.dex */
public class e {
    public int iuR;
    public List<String> iuS;
    public long iuT;
    public String iuU;
    public int mThreadCount;

    public boolean cjY() {
        return this.iuR > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iuR = dataRes.user_count.intValue();
            this.iuS = dataRes.portrait_list;
            this.iuT = dataRes.hide_unix.longValue() * 1000;
            this.iuU = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
