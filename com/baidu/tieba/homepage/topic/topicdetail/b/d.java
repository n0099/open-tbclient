package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import tbclient.ThreadInfo;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId iTz = BdUniqueId.gen();
    public bw dUW;
    public boolean iTA;
    public String iTB;
    public int index;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iTz;
    }

    public void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.dUW = new bw();
            this.dUW.a(threadInfo);
            this.dUW.bfC();
        }
    }
}
