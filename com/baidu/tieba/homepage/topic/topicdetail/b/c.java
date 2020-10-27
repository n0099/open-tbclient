package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jDA = BdUniqueId.gen();
    public bw erH;
    public long jDB;
    public int jDC;
    public boolean jDD;
    public int source;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jDA;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.jDB = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.erH = new bw();
                this.erH.a(topicThread.thread_info);
                this.erH.bkY();
            }
            this.jDC = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.jDB = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.erH = new bw();
                this.erH.a(topicThread.thread_info);
                this.erH.bkY();
            }
            this.jDC = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
