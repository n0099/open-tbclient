package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes9.dex */
public class e {
    public int hfe;
    public List<String> hff;
    public long hfg;
    public String hfh;
    public int mThreadCount;

    public boolean bPg() {
        return this.hfe > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hfe = dataRes.user_count.intValue();
            this.hff = dataRes.portrait_list;
            this.hfg = dataRes.hide_unix.longValue() * 1000;
            this.hfh = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
