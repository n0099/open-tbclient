package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.HotThread;
/* loaded from: classes15.dex */
public class g implements q {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String iJV;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public void a(HotThread hotThread) {
        if (hotThread != null) {
            this.iJV = hotThread.hot_title;
        }
    }
}
