package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes.dex */
public class c implements u {
    public static final BdUniqueId boM = BdUniqueId.gen();
    public String boN;
    public String bot;
    public String bou;
    public long postNum;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return boM;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.bot = String.valueOf(topicInfo.topic_id);
            this.bou = topicInfo.topic_name;
            this.boN = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
        }
    }
}
