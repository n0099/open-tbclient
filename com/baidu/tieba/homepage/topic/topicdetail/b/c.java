package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fOv = BdUniqueId.gen();
    public long fOw;
    public int fOx;
    public int fOy;
    public boolean fOz;
    public bg threadData;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fOv;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.fOw = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.threadData = new bg();
                this.threadData.a(topicThread.thread_info);
                this.threadData.ZH();
            }
            this.fOx = topicThread.user_agree.intValue();
            this.fOy = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.fOw = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.threadData = new bg();
                this.threadData.a(topicThread.thread_info);
                this.threadData.ZH();
            }
            this.fOx = Integer.parseInt(topicThread.user_agree);
            this.fOy = topicThread.source.intValue();
        }
    }
}
