package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId kqV = BdUniqueId.gen();
    public cb eLr;
    public int index;
    public boolean kqW;
    public String kqX;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kqV;
    }

    public void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.eLr = new cb();
            this.eLr.a(threadInfo);
            this.eLr.boR();
        }
    }
}
