package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import tbclient.ThreadInfo;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jJB = BdUniqueId.gen();
    public bw exA;
    public int index;
    public boolean jJC;
    public String jJD;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jJB;
    }

    public void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.exA = new bw();
            this.exA.a(threadInfo);
            this.exA.bny();
        }
    }
}
