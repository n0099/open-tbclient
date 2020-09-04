package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes16.dex */
public class e {
    public int iPV;
    public List<String> iPW;
    public long iPX;
    public String iPY;
    public int mThreadCount;

    public boolean cyu() {
        return this.iPV > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iPV = dataRes.user_count.intValue();
            this.iPW = dataRes.portrait_list;
            this.iPX = dataRes.hide_unix.longValue() * 1000;
            this.iPY = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
