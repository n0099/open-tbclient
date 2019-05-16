package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gfs = BdUniqueId.gen();
    public long gft;
    public int gfu;
    public boolean gfv;
    public int source;
    public bg threadData;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gfs;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.gft = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.threadData = new bg();
                this.threadData.a(topicThread.thread_info);
                this.threadData.ael();
            }
            this.gfu = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.gft = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.threadData = new bg();
                this.threadData.a(topicThread.thread_info);
                this.threadData.ael();
            }
            this.gfu = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
