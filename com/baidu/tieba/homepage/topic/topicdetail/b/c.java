package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jra = BdUniqueId.gen();
    public bw eji;
    public long jrb;
    public int jrc;
    public boolean jrd;
    public int source;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jra;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.jrb = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.eji = new bw();
                this.eji.a(topicThread.thread_info);
                this.eji.bjf();
            }
            this.jrc = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.jrb = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.eji = new bw();
                this.eji.a(topicThread.thread_info);
                this.eji.bjf();
            }
            this.jrc = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
