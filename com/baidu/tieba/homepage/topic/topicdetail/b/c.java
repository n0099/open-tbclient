package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fOj = BdUniqueId.gen();
    public long fOk;
    public int fOl;
    public int fOm;
    public boolean fOn;
    public bg threadData;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fOj;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.fOk = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.threadData = new bg();
                this.threadData.a(topicThread.thread_info);
                this.threadData.ZE();
            }
            this.fOl = topicThread.user_agree.intValue();
            this.fOm = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.fOk = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.threadData = new bg();
                this.threadData.a(topicThread.thread_info);
                this.threadData.ZE();
            }
            this.fOl = Integer.parseInt(topicThread.user_agree);
            this.fOm = topicThread.source.intValue();
        }
    }
}
