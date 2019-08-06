package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gmF = BdUniqueId.gen();
    public boolean gmG;
    public String gmH;
    public int index;
    public bh threadData;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gmF;
    }

    public void b(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.threadData = new bh();
            this.threadData.a(threadInfo);
            this.threadData.afo();
        }
    }
}
