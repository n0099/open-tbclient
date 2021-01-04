package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.HotThread;
/* loaded from: classes8.dex */
public class g implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String kqD;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }

    public void a(HotThread hotThread) {
        if (hotThread != null) {
            this.kqD = hotThread.hot_title;
        }
    }
}
