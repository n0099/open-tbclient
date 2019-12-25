package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId haF = BdUniqueId.gen();
    public bj cMR;
    public boolean haG;
    public String haH;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return haF;
    }

    public void b(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.cMR = new bj();
            this.cMR.a(threadInfo);
            this.cMR.aAA();
        }
    }
}
