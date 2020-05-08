package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hRN = BdUniqueId.gen();
    public bj dqE;
    public boolean hRO;
    public String hRP;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hRN;
    }

    public void b(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.dqE = new bj();
            this.dqE.a(threadInfo);
            this.dqE.aLx();
        }
    }
}
