package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId glJ = BdUniqueId.gen();
    public long glK;
    public int glL;
    public boolean glM;
    public int source;
    public bg threadData;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return glJ;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.glK = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.threadData = new bg();
                this.threadData.a(topicThread.thread_info);
                this.threadData.afn();
            }
            this.glL = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.glK = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.threadData = new bg();
                this.threadData.a(topicThread.thread_info);
                this.threadData.afn();
            }
            this.glL = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
