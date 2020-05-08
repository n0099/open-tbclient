package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hRJ = BdUniqueId.gen();
    public bj dqE;
    public long hRK;
    public int hRL;
    public boolean hRM;
    public int source;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hRJ;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.hRK = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.dqE = new bj();
                this.dqE.a(topicThread.thread_info);
                this.dqE.aLx();
            }
            this.hRL = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.hRK = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.dqE = new bj();
                this.dqE.a(topicThread.thread_info);
                this.dqE.aLx();
            }
            this.hRL = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
