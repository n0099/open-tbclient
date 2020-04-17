package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hRD = BdUniqueId.gen();
    public bj dqA;
    public long hRE;
    public int hRF;
    public boolean hRG;
    public int source;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hRD;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.hRE = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.dqA = new bj();
                this.dqA.a(topicThread.thread_info);
                this.dqA.aLz();
            }
            this.hRF = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.hRE = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.dqA = new bj();
                this.dqA.a(topicThread.thread_info);
                this.dqA.aLz();
            }
            this.hRF = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
