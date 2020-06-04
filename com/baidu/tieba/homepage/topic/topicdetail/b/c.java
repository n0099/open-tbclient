package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ihg = BdUniqueId.gen();
    public bk dEA;
    public long ihh;
    public int ihi;
    public boolean ihj;
    public int source;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return ihg;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.ihh = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.dEA = new bk();
                this.dEA.a(topicThread.thread_info);
                this.dEA.aRw();
            }
            this.ihi = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.ihh = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.dEA = new bk();
                this.dEA.a(topicThread.thread_info);
                this.dEA.aRw();
            }
            this.ihi = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
