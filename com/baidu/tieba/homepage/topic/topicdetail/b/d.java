package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fOA = BdUniqueId.gen();
    public boolean fOB;
    public String fOC;
    public int index;
    public bg threadData;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fOA;
    }

    public void b(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.threadData = new bg();
            this.threadData.a(threadInfo);
            this.threadData.ZH();
        }
    }
}
