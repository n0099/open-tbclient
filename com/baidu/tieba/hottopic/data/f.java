package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes8.dex */
public class f implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId iBd = BdUniqueId.gen();
    public int cEb;
    public String ePt;
    public String fey;
    public String kot;
    public int kuA;
    public int kuB;
    public String kuC;
    public Long kuD;
    public Integer kuE;
    public h kuF;
    public String kuG;
    public String kuw;
    public String kux;
    public long kuy;
    public int kuz;
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
        return iBd;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.fey = String.valueOf(topicInfo.topic_id);
            this.ePt = topicInfo.topic_name;
            this.kuw = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.kux = topicInfo.head_photo_url;
            this.shareTitle = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
            this.kot = topicInfo.share_pic;
            this.kuy = topicInfo.idx_num.longValue();
            this.kuD = topicInfo.pmy_topic_id;
            this.kuG = topicInfo.head_photo_jump_url;
            this.kuE = topicInfo.pmy_source;
            if (topicInfo.video_info != null && !StringUtils.isNull(topicInfo.video_info.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
                this.videoMd5 = topicInfo.video_info.video_md5;
                this.videoUrl = topicInfo.video_info.video_url;
                this.videoDuration = topicInfo.video_info.video_duration.intValue();
                this.videoWidth = topicInfo.video_info.video_width.intValue();
                this.videoHeight = topicInfo.video_info.video_height.intValue();
                this.thumbnailUrl = topicInfo.video_info.thumbnail_url;
                this.kuz = topicInfo.video_info.thumbnail_width.intValue();
                this.kuA = topicInfo.video_info.thumbnail_height.intValue();
                this.kuB = topicInfo.video_info.video_length.intValue();
                this.cEb = topicInfo.video_info.play_count.intValue();
            }
            this.kuC = topicInfo.tag_list_type;
            if (topicInfo.join_info != null) {
                this.kuF = new h();
                this.kuF.a(topicInfo.join_info);
            }
        }
    }
}
