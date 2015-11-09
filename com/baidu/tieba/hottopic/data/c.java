package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes.dex */
public class c implements u {
    public static final BdUniqueId bpB = BdUniqueId.gen();
    public String bpC;
    public String bpi;
    public String bpj;
    public long postNum;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bpB;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.bpi = String.valueOf(topicInfo.topic_id);
            this.bpj = topicInfo.topic_name;
            this.bpC = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
        }
    }
}
