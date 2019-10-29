package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gnR = BdUniqueId.gen();
    public bh cbq;
    public long gnS;
    public int gnT;
    public boolean gnU;
    public int source;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gnR;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.gnS = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.cbq = new bh();
                this.cbq.a(topicThread.thread_info);
                this.cbq.ajw();
            }
            this.gnT = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.gnS = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.cbq = new bh();
                this.cbq.a(topicThread.thread_info);
                this.cbq.ajw();
            }
            this.gnT = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
