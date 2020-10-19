package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import tbclient.ThreadInfo;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jre = BdUniqueId.gen();
    public bw eji;
    public int index;
    public boolean jrf;
    public String jrg;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jre;
    }

    public void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.eji = new bw();
            this.eji.a(threadInfo);
            this.eji.bjf();
        }
    }
}
