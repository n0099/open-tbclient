package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {
    public int gnh;
    public List<String> gni;
    public long gnj;
    public String gnk;
    public int gnl;

    public boolean byd() {
        return this.gnh > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gnh = dataRes.user_count.intValue();
            this.gni = dataRes.portrait_list;
            this.gnj = dataRes.hide_unix.longValue() * 1000;
            this.gnk = dataRes.show_tip;
            this.gnl = dataRes.thread_count.intValue();
        }
    }
}
