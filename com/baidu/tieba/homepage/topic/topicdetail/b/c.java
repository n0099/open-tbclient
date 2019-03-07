package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fOw = BdUniqueId.gen();
    public boolean fOA;
    public long fOx;
    public int fOy;
    public int fOz;
    public bg threadData;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fOw;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.fOx = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.threadData = new bg();
                this.threadData.a(topicThread.thread_info);
                this.threadData.ZH();
            }
            this.fOy = topicThread.user_agree.intValue();
            this.fOz = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.fOx = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.threadData = new bg();
                this.threadData.a(topicThread.thread_info);
                this.threadData.ZH();
            }
            this.fOy = Integer.parseInt(topicThread.user_agree);
            this.fOz = topicThread.source.intValue();
        }
    }
}
