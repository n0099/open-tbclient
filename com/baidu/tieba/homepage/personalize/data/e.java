package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes9.dex */
public class e {
    public int hQo;
    public List<String> hQp;
    public long hQq;
    public String hQr;
    public int mThreadCount;

    public boolean bZT() {
        return this.hQo > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hQo = dataRes.user_count.intValue();
            this.hQp = dataRes.portrait_list;
            this.hQq = dataRes.hide_unix.longValue() * 1000;
            this.hQr = dataRes.show_tip;
            this.mThreadCount = dataRes.thread_count.intValue();
        }
    }
}
