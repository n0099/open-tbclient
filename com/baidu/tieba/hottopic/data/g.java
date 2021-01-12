package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.HotThread;
/* loaded from: classes7.dex */
public class g implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public String klY;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }

    public void a(HotThread hotThread) {
        if (hotThread != null) {
            this.klY = hotThread.hot_title;
        }
    }
}
