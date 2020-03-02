package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hgl = BdUniqueId.gen();
    public bj cRf;
    public boolean hgm;
    public String hgn;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hgl;
    }

    public void b(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.cRf = new bj();
            this.cRf.a(threadInfo);
            this.cRf.aDj();
        }
    }
}
