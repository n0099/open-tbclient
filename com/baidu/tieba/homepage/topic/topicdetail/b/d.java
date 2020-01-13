package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hei = BdUniqueId.gen();
    public bj cNb;
    public boolean hej;
    public String hek;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hei;
    }

    public void b(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.cNb = new bj();
            this.cNb.a(threadInfo);
            this.cNb.aAT();
        }
    }
}
