package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes2.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId kkZ = BdUniqueId.gen();
    public bz eMv;
    public long kla;
    public int klb;
    public boolean klc;
    public int source;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kkZ;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.kla = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.eMv = new bz();
                this.eMv.a(topicThread.thread_info);
                this.eMv.bsr();
            }
            this.klb = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.kla = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.eMv = new bz();
                this.eMv.a(topicThread.thread_info);
                this.eMv.bsr();
            }
            this.klb = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
