package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes15.dex */
public class f implements q {
    public static final BdUniqueId hnz = BdUniqueId.gen();
    public int bTG;
    public String eaf;
    public String eon;
    public String iTn;
    public h iZA;
    public String iZB;
    public String iZs;
    public String iZt;
    public long iZu;
    public int iZv;
    public int iZw;
    public int iZx;
    public Long iZy;
    public Integer iZz;
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
        return hnz;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.eon = String.valueOf(topicInfo.topic_id);
            this.eaf = topicInfo.topic_name;
            this.iZs = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.iZt = topicInfo.head_photo_url;
            this.shareTitle = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
            this.iTn = topicInfo.share_pic;
            this.iZu = topicInfo.idx_num.longValue();
            this.iZy = topicInfo.pmy_topic_id;
            this.iZB = topicInfo.head_photo_jump_url;
            this.iZz = topicInfo.pmy_source;
            if (topicInfo.video_info != null && !StringUtils.isNull(topicInfo.video_info.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
                this.videoMd5 = topicInfo.video_info.video_md5;
                this.videoUrl = topicInfo.video_info.video_url;
                this.videoDuration = topicInfo.video_info.video_duration.intValue();
                this.videoWidth = topicInfo.video_info.video_width.intValue();
                this.videoHeight = topicInfo.video_info.video_height.intValue();
                this.thumbnailUrl = topicInfo.video_info.thumbnail_url;
                this.iZv = topicInfo.video_info.thumbnail_width.intValue();
                this.iZw = topicInfo.video_info.thumbnail_height.intValue();
                this.iZx = topicInfo.video_info.video_length.intValue();
                this.bTG = topicInfo.video_info.play_count.intValue();
            }
            this.tagType = topicInfo.tag_list_type;
            if (topicInfo.join_info != null) {
                this.iZA = new h();
                this.iZA.a(topicInfo.join_info);
            }
        }
    }
}
