package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId kgx = BdUniqueId.gen();
    public bz eHK;
    public int index;
    public boolean kgy;
    public String kgz;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kgx;
    }

    public void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.eHK = new bz();
            this.eHK.a(threadInfo);
            this.eHK.box();
        }
    }
}
