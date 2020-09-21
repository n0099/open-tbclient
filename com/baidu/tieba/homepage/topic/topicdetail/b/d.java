package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import tbclient.ThreadInfo;
/* loaded from: classes21.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jcf = BdUniqueId.gen();
    public bw dXg;
    public int index;
    public boolean jcg;
    public String jch;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jcf;
    }

    public void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.dXg = new bw();
            this.dXg.a(threadInfo);
            this.dXg.bgw();
        }
    }
}
