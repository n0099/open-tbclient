package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes7.dex */
public class f implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId ivt = BdUniqueId.gen();
    public int cBF;
    public String eNh;
    public String fci;
    public String kgl;
    public String kmp;
    public String kmq;
    public long kmr;
    public int kms;
    public int kmt;
    public int kmu;
    public String kmv;
    public Long kmw;
    public Integer kmx;
    public h kmy;
    public String kmz;
    public long postNum;
    public String shareTitle;
    public String thumbnailUrl;
    public int videoDuration;
    public int videoHeight;
    public String videoMd5;
    public String videoUrl;
    public int videoWidth;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ivt;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.fci = String.valueOf(topicInfo.topic_id);
            this.eNh = topicInfo.topic_name;
            this.kmp = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.kmq = topicInfo.head_photo_url;
            this.shareTitle = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
            this.kgl = topicInfo.share_pic;
            this.kmr = topicInfo.idx_num.longValue();
            this.kmw = topicInfo.pmy_topic_id;
            this.kmz = topicInfo.head_photo_jump_url;
            this.kmx = topicInfo.pmy_source;
            if (topicInfo.video_info != null && !StringUtils.isNull(topicInfo.video_info.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
                this.videoMd5 = topicInfo.video_info.video_md5;
                this.videoUrl = topicInfo.video_info.video_url;
                this.videoDuration = topicInfo.video_info.video_duration.intValue();
                this.videoWidth = topicInfo.video_info.video_width.intValue();
                this.videoHeight = topicInfo.video_info.video_height.intValue();
                this.thumbnailUrl = topicInfo.video_info.thumbnail_url;
                this.kms = topicInfo.video_info.thumbnail_width.intValue();
                this.kmt = topicInfo.video_info.thumbnail_height.intValue();
                this.kmu = topicInfo.video_info.video_length.intValue();
                this.cBF = topicInfo.video_info.play_count.intValue();
            }
            this.kmv = topicInfo.tag_list_type;
            if (topicInfo.join_info != null) {
                this.kmy = new h();
                this.kmy.a(topicInfo.join_info);
            }
        }
    }
}
