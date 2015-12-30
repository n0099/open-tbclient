package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes.dex */
public class d implements u {
    public static final BdUniqueId aQD = BdUniqueId.gen();
    public String aQB;
    public String bGN;
    public String bHt;
    public String bHu;
    public String bHv;
    public long postNum;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aQD;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.bGN = String.valueOf(topicInfo.topic_id);
            this.aQB = topicInfo.topic_name;
            this.bHt = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.bHu = topicInfo.head_photo_url;
            this.bHv = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
        }
    }
}
