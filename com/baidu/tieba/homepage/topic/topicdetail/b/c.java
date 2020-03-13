package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hgt = BdUniqueId.gen();
    public bj cRg;
    public long hgu;
    public int hgv;
    public boolean hgw;
    public int source;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hgt;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.hgu = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.cRg = new bj();
                this.cRg.a(topicThread.thread_info);
                this.cRg.aDj();
            }
            this.hgv = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.hgu = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.cRg = new bj();
                this.cRg.a(topicThread.thread_info);
                this.cRg.aDj();
            }
            this.hgv = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
