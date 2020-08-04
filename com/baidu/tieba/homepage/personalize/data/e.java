package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes16.dex */
public class e {
    public int iAX;
    public List<String> iAY;
    public long iAZ;
    public String iBa;
    public int mThreadCount;

    public boolean cnA() {
        return this.iAX > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iAX = dataRes.user_count.intValue();
            this.iAY = dataRes.portrait_list;
            this.iAZ = dataRes.hide_unix.longValue() * 1000;
            this.iBa = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
