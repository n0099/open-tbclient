package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes21.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId jKi = BdUniqueId.gen();
    public bx evQ;
    public long jKj;
    public int jKk;
    public boolean jKl;
    public int source;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jKi;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.jKj = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.evQ = new bx();
                this.evQ.a(topicThread.thread_info);
                this.evQ.bmC();
            }
            this.jKk = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.jKj = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.evQ = new bx();
                this.evQ.a(topicThread.thread_info);
                this.evQ.bmC();
            }
            this.jKk = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
