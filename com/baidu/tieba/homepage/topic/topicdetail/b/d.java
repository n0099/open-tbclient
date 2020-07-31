package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bv;
import tbclient.ThreadInfo;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId iEt = BdUniqueId.gen();
    public bv dLK;
    public boolean iEu;
    public String iEv;
    public int index;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iEt;
    }

    public void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.dLK = new bv();
            this.dLK.a(threadInfo);
            this.dLK.aXj();
        }
    }
}
