package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import tbclient.ThreadInfo;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jDE = BdUniqueId.gen();
    public bw erH;
    public int index;
    public boolean jDF;
    public String jDG;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jDE;
    }

    public void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.erH = new bw();
            this.erH.a(threadInfo);
            this.erH.bkY();
        }
    }
}
