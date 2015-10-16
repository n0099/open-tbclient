package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes.dex */
public class c implements u {
    public static final BdUniqueId boX = BdUniqueId.gen();
    public String boE;
    public String boF;
    public String boY;
    public long postNum;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return boX;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.boE = String.valueOf(topicInfo.topic_id);
            this.boF = topicInfo.topic_name;
            this.boY = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
        }
    }
}
