package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId koT = BdUniqueId.gen();
    public cb eJQ;
    public int index;
    public boolean koU;
    public String koV;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return koT;
    }

    public void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.eJQ = new cb();
            this.eJQ.a(threadInfo);
            this.eJQ.boP();
        }
    }
}
