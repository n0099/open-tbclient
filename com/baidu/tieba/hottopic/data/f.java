package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes20.dex */
public class f implements q {
    public static final BdUniqueId huD = BdUniqueId.gen();
    public int bVG;
    public String ecp;
    public String eqD;
    public String jbT;
    public String jhX;
    public String jhY;
    public long jhZ;
    public int jia;
    public int jib;
    public int jic;
    public Long jie;
    public Integer jif;
    public h jig;
    public String jih;
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
        return huD;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.eqD = String.valueOf(topicInfo.topic_id);
            this.ecp = topicInfo.topic_name;
            this.jhX = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.jhY = topicInfo.head_photo_url;
            this.shareTitle = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
            this.jbT = topicInfo.share_pic;
            this.jhZ = topicInfo.idx_num.longValue();
            this.jie = topicInfo.pmy_topic_id;
            this.jih = topicInfo.head_photo_jump_url;
            this.jif = topicInfo.pmy_source;
            if (topicInfo.video_info != null && !StringUtils.isNull(topicInfo.video_info.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
                this.videoMd5 = topicInfo.video_info.video_md5;
                this.videoUrl = topicInfo.video_info.video_url;
                this.videoDuration = topicInfo.video_info.video_duration.intValue();
                this.videoWidth = topicInfo.video_info.video_width.intValue();
                this.videoHeight = topicInfo.video_info.video_height.intValue();
                this.thumbnailUrl = topicInfo.video_info.thumbnail_url;
                this.jia = topicInfo.video_info.thumbnail_width.intValue();
                this.jib = topicInfo.video_info.thumbnail_height.intValue();
                this.jic = topicInfo.video_info.video_length.intValue();
                this.bVG = topicInfo.video_info.play_count.intValue();
            }
            this.tagType = topicInfo.tag_list_type;
            if (topicInfo.join_info != null) {
                this.jig = new h();
                this.jig.a(topicInfo.join_info);
            }
        }
    }
}
