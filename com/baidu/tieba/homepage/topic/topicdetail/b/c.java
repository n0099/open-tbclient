package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bv;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId iEr = BdUniqueId.gen();
    public bv dLK;
    public long iEs;
    public int iEt;
    public boolean iEu;
    public int source;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iEr;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.iEs = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.dLK = new bv();
                this.dLK.a(topicThread.thread_info);
                this.dLK.aXj();
            }
            this.iEt = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.iEs = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.dLK = new bv();
                this.dLK.a(topicThread.thread_info);
                this.dLK.aXj();
            }
            this.iEt = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
