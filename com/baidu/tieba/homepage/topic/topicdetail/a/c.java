package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes2.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId kgt = BdUniqueId.gen();
    public bz eHK;
    public long kgu;
    public int kgv;
    public boolean kgw;
    public int source;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kgt;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.kgu = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.eHK = new bz();
                this.eHK.a(topicThread.thread_info);
                this.eHK.box();
            }
            this.kgv = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.kgu = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.eHK = new bz();
                this.eHK.a(topicThread.thread_info);
                this.eHK.box();
            }
            this.kgv = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
