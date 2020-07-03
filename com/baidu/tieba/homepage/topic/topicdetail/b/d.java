package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bu;
import tbclient.ThreadInfo;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId iyp = BdUniqueId.gen();
    public bu dLi;
    public int index;
    public boolean iyq;
    public String iyr;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iyp;
    }

    public void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.dLi = new bu();
            this.dLi.a(threadInfo);
            this.dLi.aTn();
        }
    }
}
