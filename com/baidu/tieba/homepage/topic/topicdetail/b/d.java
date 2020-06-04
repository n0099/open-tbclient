package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ihk = BdUniqueId.gen();
    public bk dEA;
    public boolean ihl;
    public String ihm;
    public int index;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return ihk;
    }

    public void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.dEA = new bk();
            this.dEA.a(threadInfo);
            this.dEA.aRw();
        }
    }
}
