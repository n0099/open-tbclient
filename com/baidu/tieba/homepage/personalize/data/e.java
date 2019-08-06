package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {
    public int glp;
    public List<String> glq;
    public long glr;
    public String gls;
    public int glt;

    public boolean bxp() {
        return this.glp > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.glp = dataRes.user_count.intValue();
            this.glq = dataRes.portrait_list;
            this.glr = dataRes.hide_unix.longValue() * 1000;
            this.gls = dataRes.show_tip;
            this.glt = dataRes.thread_count.intValue();
        }
    }
}
