package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gos = BdUniqueId.gen();
    public long got;
    public int gou;
    public boolean gov;
    public int source;
    public bh threadData;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gos;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.got = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.threadData = new bh();
                this.threadData.a(topicThread.thread_info);
                this.threadData.afs();
            }
            this.gou = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.got = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.threadData = new bh();
                this.threadData.a(topicThread.thread_info);
                this.threadData.afs();
            }
            this.gou = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
