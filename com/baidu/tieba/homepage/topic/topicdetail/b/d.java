package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.ThreadInfo;
/* loaded from: classes21.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId jKm = BdUniqueId.gen();
    public bx evQ;
    public int index;
    public boolean jKn;
    public String jKo;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jKm;
    }

    public void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.evQ = new bx();
            this.evQ.a(threadInfo);
            this.evQ.bmC();
        }
    }
}
