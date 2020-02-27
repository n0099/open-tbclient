package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hgj = BdUniqueId.gen();
    public bj cRe;
    public boolean hgk;
    public String hgl;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hgj;
    }

    public void b(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.cRe = new bj();
            this.cRe.a(threadInfo);
            this.cRe.aDh();
        }
    }
}
