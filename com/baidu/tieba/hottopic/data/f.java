package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes.dex */
public class f implements u {
    public static final BdUniqueId aSH = BdUniqueId.gen();
    public String Wm;
    public String bKm;
    public String bLd;
    public String bLe;
    public String bLf;
    public String bLg;
    public long bLh;
    public long postNum;

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aSH;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.bKm = String.valueOf(topicInfo.topic_id);
            this.Wm = topicInfo.topic_name;
            this.bLd = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.bLe = topicInfo.head_photo_url;
            this.bLf = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
            this.bLg = topicInfo.share_pic;
            this.bLh = topicInfo.idx_num.longValue();
        }
    }
}
