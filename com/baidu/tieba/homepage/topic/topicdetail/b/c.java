package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId iTv = BdUniqueId.gen();
    public bw dUW;
    public long iTw;
    public int iTx;
    public boolean iTy;
    public int source;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iTv;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.iTw = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.dUW = new bw();
                this.dUW.a(topicThread.thread_info);
                this.dUW.bfC();
            }
            this.iTx = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.iTw = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.dUW = new bw();
                this.dUW.a(topicThread.thread_info);
                this.dUW.bfC();
            }
            this.iTx = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
