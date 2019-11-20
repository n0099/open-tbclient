package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {
    public int glO;
    public List<String> glP;
    public long glQ;
    public String glR;
    public int glS;

    public boolean bvf() {
        return this.glO > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.glO = dataRes.user_count.intValue();
            this.glP = dataRes.portrait_list;
            this.glQ = dataRes.hide_unix.longValue() * 1000;
            this.glR = dataRes.show_tip;
            this.glS = dataRes.thread_count.intValue();
        }
    }
}
