package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes9.dex */
public class e {
    public long hgA;
    public String hgB;
    public int hgy;
    public List<String> hgz;
    public int mThreadCount;

    public boolean bPu() {
        return this.hgy > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hgy = dataRes.user_count.intValue();
            this.hgz = dataRes.portrait_list;
            this.hgA = dataRes.hide_unix.longValue() * 1000;
            this.hgB = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
