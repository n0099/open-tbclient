package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.HotThread;
/* loaded from: classes.dex */
public class g implements u {
    public static final BdUniqueId aRS = BdUniqueId.gen();
    public String bKP;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aRS;
    }

    public void a(HotThread hotThread) {
        if (hotThread != null) {
            this.bKP = hotThread.hot_title;
        }
    }
}
