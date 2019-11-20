package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gne = BdUniqueId.gen();
    public bh caz;
    public boolean gnf;
    public String gng;
    public int index;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gne;
    }

    public void b(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.caz = new bh();
            this.caz.a(threadInfo);
            this.caz.aju();
        }
    }
}
