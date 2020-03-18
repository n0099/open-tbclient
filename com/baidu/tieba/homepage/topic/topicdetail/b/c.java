package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hhT = BdUniqueId.gen();
    public bj cRt;
    public long hhU;
    public int hhV;
    public boolean hhW;
    public int source;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hhT;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.hhU = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.cRt = new bj();
                this.cRt.a(topicThread.thread_info);
                this.cRt.aDm();
            }
            this.hhV = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.hhU = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.cRt = new bj();
                this.cRt.a(topicThread.thread_info);
                this.cRt.aDm();
            }
            this.hhV = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
