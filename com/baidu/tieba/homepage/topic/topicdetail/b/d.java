package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hRH = BdUniqueId.gen();
    public bj dqA;
    public boolean hRI;
    public String hRJ;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hRH;
    }

    public void b(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.dqA = new bj();
            this.dqA.a(threadInfo);
            this.dqA.aLz();
        }
    }
}
