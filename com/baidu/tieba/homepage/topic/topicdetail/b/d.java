package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gfx = BdUniqueId.gen();
    public boolean gfy;
    public String gfz;
    public int index;
    public bg threadData;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gfx;
    }

    public void b(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.threadData = new bg();
            this.threadData.a(threadInfo);
            this.threadData.ael();
        }
    }
}
