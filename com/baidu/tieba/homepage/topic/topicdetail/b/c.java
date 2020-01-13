package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes7.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hee = BdUniqueId.gen();
    public bj cNb;
    public long hef;
    public int heg;
    public boolean heh;
    public int source;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hee;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.hef = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.cNb = new bj();
                this.cNb.a(topicThread.thread_info);
                this.cNb.aAT();
            }
            this.heg = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.hef = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.cNb = new bj();
                this.cNb.a(topicThread.thread_info);
                this.cNb.aAT();
            }
            this.heg = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
