package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gna = BdUniqueId.gen();
    public bh caz;
    public long gnb;
    public int gnc;
    public boolean gnd;
    public int source;
    public long topicId;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gna;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.gnb = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.caz = new bh();
                this.caz.a(topicThread.thread_info);
                this.caz.aju();
            }
            this.gnc = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.gnb = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.caz = new bh();
                this.caz.a(topicThread.thread_info);
                this.caz.aju();
            }
            this.gnc = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
