package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.HotThread;
/* loaded from: classes20.dex */
public class g implements q {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String jhG;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public void a(HotThread hotThread) {
        if (hotThread != null) {
            this.jhG = hotThread.hot_title;
        }
    }
}
