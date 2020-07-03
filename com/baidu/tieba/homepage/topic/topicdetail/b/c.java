package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bu;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId iyl = BdUniqueId.gen();
    public bu dLi;
    public long iym;
    public int iyn;
    public boolean iyo;
    public int source;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iyl;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.iym = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.dLi = new bu();
                this.dLi.a(topicThread.thread_info);
                this.dLi.aTn();
            }
            this.iyn = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.iym = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.dLi = new bu();
                this.dLi.a(topicThread.thread_info);
                this.dLi.aTn();
            }
            this.iyn = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
