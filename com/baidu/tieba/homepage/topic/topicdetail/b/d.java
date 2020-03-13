package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hgx = BdUniqueId.gen();
    public bj cRg;
    public boolean hgy;
    public String hgz;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hgx;
    }

    public void b(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.cRg = new bj();
            this.cRg.a(threadInfo);
            this.cRg.aDj();
        }
    }
}
