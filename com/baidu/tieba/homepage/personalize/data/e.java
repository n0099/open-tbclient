package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes2.dex */
public class e {
    public int efR;
    public List<String> efS;
    public long efT;
    public String efU;
    public int efV;

    public boolean aBE() {
        return this.efR > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.efR = dataRes.user_count.intValue();
            this.efS = dataRes.portrait_list;
            this.efT = dataRes.hide_unix.longValue() * 1000;
            this.efU = dataRes.show_tip;
            this.efV = dataRes.thread_count.intValue();
        }
    }
}
