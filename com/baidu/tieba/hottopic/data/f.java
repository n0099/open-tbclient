package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes20.dex */
public class f implements q {
    public static final BdUniqueId icG = BdUniqueId.gen();
    public int cuJ;
    public String eBa;
    public String eQb;
    public String jKa;
    public String jQd;
    public String jQe;
    public long jQf;
    public int jQg;
    public int jQh;
    public int jQi;
    public Long jQj;
    public Integer jQk;
    public h jQl;
    public String jQm;
    public long postNum;
    public String shareTitle;
    public String tagType;
    public String thumbnailUrl;
    public int videoDuration;
    public int videoHeight;
    public String videoMd5;
    public String videoUrl;
    public int videoWidth;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return icG;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.eQb = String.valueOf(topicInfo.topic_id);
            this.eBa = topicInfo.topic_name;
            this.jQd = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.jQe = topicInfo.head_photo_url;
            this.shareTitle = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
            this.jKa = topicInfo.share_pic;
            this.jQf = topicInfo.idx_num.longValue();
            this.jQj = topicInfo.pmy_topic_id;
            this.jQm = topicInfo.head_photo_jump_url;
            this.jQk = topicInfo.pmy_source;
            if (topicInfo.video_info != null && !StringUtils.isNull(topicInfo.video_info.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
                this.videoMd5 = topicInfo.video_info.video_md5;
                this.videoUrl = topicInfo.video_info.video_url;
                this.videoDuration = topicInfo.video_info.video_duration.intValue();
                this.videoWidth = topicInfo.video_info.video_width.intValue();
                this.videoHeight = topicInfo.video_info.video_height.intValue();
                this.thumbnailUrl = topicInfo.video_info.thumbnail_url;
                this.jQg = topicInfo.video_info.thumbnail_width.intValue();
                this.jQh = topicInfo.video_info.thumbnail_height.intValue();
                this.jQi = topicInfo.video_info.video_length.intValue();
                this.cuJ = topicInfo.video_info.play_count.intValue();
            }
            this.tagType = topicInfo.tag_list_type;
            if (topicInfo.join_info != null) {
                this.jQl = new h();
                this.jQl.a(topicInfo.join_info);
            }
        }
    }
}
