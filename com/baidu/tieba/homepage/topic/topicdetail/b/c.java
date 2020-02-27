package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hgf = BdUniqueId.gen();
    public bj cRe;
    public long hgg;
    public int hgh;
    public boolean hgi;
    public int source;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hgf;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.hgg = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.cRe = new bj();
                this.cRe.a(topicThread.thread_info);
                this.cRe.aDh();
            }
            this.hgh = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.hgg = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.cRe = new bj();
                this.cRe.a(topicThread.thread_info);
                this.cRe.aDh();
            }
            this.hgh = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
