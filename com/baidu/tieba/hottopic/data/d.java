package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes.dex */
public class d implements u {
    public static final BdUniqueId bDP = BdUniqueId.gen();
    public String bBb;
    public String bDQ;
    public String bDR;
    public String bDS;
    public String bDj;
    public long postNum;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bDP;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.bDj = String.valueOf(topicInfo.topic_id);
            this.bBb = topicInfo.topic_name;
            this.bDQ = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.bDR = topicInfo.head_photo_url;
            this.bDS = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
        }
    }
}
