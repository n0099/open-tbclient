package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int dRA;
    public List<String> dRB;
    public long dRC;
    public String dRD;
    public int dRE;

    public boolean aCU() {
        return this.dRA > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dRA = dataRes.user_count.intValue();
            this.dRB = dataRes.portrait_list;
            this.dRC = dataRes.hide_unix.longValue() * 1000;
            this.dRD = dataRes.show_tip;
            this.dRE = dataRes.thread_count.intValue();
        }
    }
}
