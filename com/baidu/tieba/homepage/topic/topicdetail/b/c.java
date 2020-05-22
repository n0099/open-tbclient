package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId igt = BdUniqueId.gen();
    public bk dEA;
    public long igu;
    public int igv;
    public boolean igw;
    public int source;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return igt;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.igu = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.dEA = new bk();
                this.dEA.a(topicThread.thread_info);
                this.dEA.aRw();
            }
            this.igv = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.igu = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.dEA = new bk();
                this.dEA.a(topicThread.thread_info);
                this.dEA.aRw();
            }
            this.igv = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
