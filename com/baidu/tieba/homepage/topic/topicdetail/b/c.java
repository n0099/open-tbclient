package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gmB = BdUniqueId.gen();
    public long gmC;
    public int gmD;
    public boolean gmE;
    public int source;
    public bh threadData;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gmB;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.gmC = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.threadData = new bh();
                this.threadData.a(topicThread.thread_info);
                this.threadData.afo();
            }
            this.gmD = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.gmC = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.threadData = new bh();
                this.threadData.a(topicThread.thread_info);
                this.threadData.afo();
            }
            this.gmD = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
