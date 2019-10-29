package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gnV = BdUniqueId.gen();
    public bh cbq;
    public boolean gnW;
    public String gnX;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gnV;
    }

    public void b(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.cbq = new bh();
            this.cbq.a(threadInfo);
            this.cbq.ajw();
        }
    }
}
