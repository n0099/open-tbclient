package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId haB = BdUniqueId.gen();
    public bj cMR;
    public long haC;
    public int haD;
    public boolean haE;
    public int source;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return haB;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.haC = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.cMR = new bj();
                this.cMR.a(topicThread.thread_info);
                this.cMR.aAA();
            }
            this.haD = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.haC = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.cMR = new bj();
                this.cMR.a(topicThread.thread_info);
                this.cMR.aAA();
            }
            this.haD = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
