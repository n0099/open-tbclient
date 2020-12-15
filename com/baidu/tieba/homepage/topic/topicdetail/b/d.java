package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.ThreadInfo;
/* loaded from: classes22.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId jXR = BdUniqueId.gen();
    public by eCR;
    public int index;
    public boolean jXS;
    public String jXT;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jXR;
    }

    public void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.eCR = new by();
            this.eCR.a(threadInfo);
            this.eCR.bpP();
        }
    }
}
