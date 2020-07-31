package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes16.dex */
public class e {
    public int iAV;
    public List<String> iAW;
    public long iAX;
    public String iAY;
    public int mThreadCount;

    public boolean cnA() {
        return this.iAV > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iAV = dataRes.user_count.intValue();
            this.iAW = dataRes.portrait_list;
            this.iAX = dataRes.hide_unix.longValue() * 1000;
            this.iAY = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
