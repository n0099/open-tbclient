package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gfz = BdUniqueId.gen();
    public boolean gfA;
    public String gfB;
    public int index;
    public bg threadData;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gfz;
    }

    public void b(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.threadData = new bg();
            this.threadData.a(threadInfo);
            this.threadData.ael();
        }
    }
}
