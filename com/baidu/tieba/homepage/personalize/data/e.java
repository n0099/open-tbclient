package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int khM;
    public List<String> khN;
    public long khO;
    public String khP;
    public int mThreadCount;

    public boolean cTt() {
        return this.khM > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.khM = dataRes.user_count.intValue();
            this.khN = dataRes.portrait_list;
            this.khO = dataRes.hide_unix.longValue() * 1000;
            this.khP = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
