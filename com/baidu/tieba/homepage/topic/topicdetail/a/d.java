package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId kld = BdUniqueId.gen();
    public bz eMv;
    public int index;
    public boolean kle;
    public String klf;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kld;
    }

    public void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.eMv = new bz();
            this.eMv.a(threadInfo);
            this.eMv.bsq();
        }
    }
}
