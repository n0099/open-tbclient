package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hgh = BdUniqueId.gen();
    public bj cRf;
    public long hgi;
    public int hgj;
    public boolean hgk;
    public int source;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hgh;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.hgi = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.cRf = new bj();
                this.cRf.a(topicThread.thread_info);
                this.cRf.aDj();
            }
            this.hgj = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.hgi = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.cRf = new bj();
                this.cRf.a(topicThread.thread_info);
                this.cRf.aDj();
            }
            this.hgj = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
