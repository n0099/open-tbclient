package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hhX = BdUniqueId.gen();
    public bj cRt;
    public boolean hhY;
    public String hhZ;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hhX;
    }

    public void b(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.cRt = new bj();
            this.cRt.a(threadInfo);
            this.cRt.aDm();
        }
    }
}
