package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import tbclient.ThreadInfo;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId iTt = BdUniqueId.gen();
    public bw dUS;
    public boolean iTu;
    public String iTv;
    public int index;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iTt;
    }

    public void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.dUS = new bw();
            this.dUS.a(threadInfo);
            this.dUS.bfC();
        }
    }
}
