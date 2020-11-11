package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jJx = BdUniqueId.gen();
    public bw exA;
    public boolean jJA;
    public long jJy;
    public int jJz;
    public int source;
    public long topicId;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jJx;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.jJy = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.exA = new bw();
                this.exA.a(topicThread.thread_info);
                this.exA.bny();
            }
            this.jJz = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.jJy = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.exA = new bw();
                this.exA.a(topicThread.thread_info);
                this.exA.bny();
            }
            this.jJz = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
