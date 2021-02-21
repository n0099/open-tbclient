package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes2.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId koP = BdUniqueId.gen();
    public cb eJQ;
    public long koQ;
    public int koR;
    public boolean koS;
    public int source;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return koP;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.koQ = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.eJQ = new cb();
                this.eJQ.a(topicThread.thread_info);
                this.eJQ.boP();
            }
            this.koR = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.koQ = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.eJQ = new cb();
                this.eJQ.a(topicThread.thread_info);
                this.eJQ.boP();
            }
            this.koR = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
