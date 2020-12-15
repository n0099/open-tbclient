package com.baidu.tieba.homepage.topic.topicdetail.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes22.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId jXN = BdUniqueId.gen();
    public by eCR;
    public long jXO;
    public int jXP;
    public boolean jXQ;
    public int source;
    public long topicId;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jXN;
    }

    public void a(TopicThread topicThread) {
        if (topicThread != null) {
            this.jXO = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.eCR = new by();
                this.eCR.a(topicThread.thread_info);
                this.eCR.bpP();
            }
            this.jXP = topicThread.user_agree.intValue();
            this.source = topicThread.source.intValue();
        }
    }

    public void a(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread != null) {
            this.jXO = topicThread.feed_id.longValue();
            if (topicThread.thread_info != null) {
                this.eCR = new by();
                this.eCR.a(topicThread.thread_info);
                this.eCR.bpP();
            }
            this.jXP = Integer.parseInt(topicThread.user_agree);
            this.source = topicThread.source.intValue();
        }
    }
}
