package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes21.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jcb = BdUniqueId.gen();
    public bw dXg;
    public long jcc;
    public int jcd;
    public boolean jce;
    public int source;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jcb;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.jcc = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.dXg = new bw();
                this.dXg.a(topicThread.thread_info);
                this.dXg.bgw();
            }
            this.jcd = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.jcc = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.dXg = new bw();
                this.dXg.a(topicThread.thread_info);
                this.dXg.bgw();
            }
            this.jcd = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
