package com.baidu.tieba.homepage.personalize.data;

import java.util.List;
import tbclient.UnreadTip.DataRes;
/* loaded from: classes4.dex */
public class e {
    public int gmF;
    public List<String> gmG;
    public long gmH;
    public String gmI;
    public int gmJ;

    public boolean bvh() {
        return this.gmF > 0;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.gmF = dataRes.user_count.intValue();
            this.gmG = dataRes.portrait_list;
            this.gmH = dataRes.hide_unix.longValue() * 1000;
            this.gmI = dataRes.show_tip;
            this.gmJ = dataRes.thread_count.intValue();
        }
    }
}
