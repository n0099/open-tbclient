package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes2.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId kqR = BdUniqueId.gen();
    public cb eLr;
    public long kqS;
    public int kqT;
    public boolean kqU;
    public int source;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kqR;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.kqS = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.eLr = new cb();
                this.eLr.a(topicThread.thread_info);
                this.eLr.boR();
            }
            this.kqT = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.kqS = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.eLr = new cb();
                this.eLr.a(topicThread.thread_info);
                this.eLr.boR();
            }
            this.kqT = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
