package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes21.dex */
public class f implements q {
    public static final BdUniqueId hVV = BdUniqueId.gen();
    public int cqv;
    public String eLl;
    public String ewR;
    public String jDs;
    public int jJA;
    public Long jJB;
    public Integer jJC;
    public h jJD;
    public String jJE;
    public String jJv;
    public String jJw;
    public long jJx;
    public int jJy;
    public int jJz;
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
        return hVV;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.eLl = String.valueOf(topicInfo.topic_id);
            this.ewR = topicInfo.topic_name;
            this.jJv = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.jJw = topicInfo.head_photo_url;
            this.shareTitle = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
            this.jDs = topicInfo.share_pic;
            this.jJx = topicInfo.idx_num.longValue();
            this.jJB = topicInfo.pmy_topic_id;
            this.jJE = topicInfo.head_photo_jump_url;
            this.jJC = topicInfo.pmy_source;
            if (topicInfo.video_info != null && !StringUtils.isNull(topicInfo.video_info.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
                this.videoMd5 = topicInfo.video_info.video_md5;
                this.videoUrl = topicInfo.video_info.video_url;
                this.videoDuration = topicInfo.video_info.video_duration.intValue();
                this.videoWidth = topicInfo.video_info.video_width.intValue();
                this.videoHeight = topicInfo.video_info.video_height.intValue();
                this.thumbnailUrl = topicInfo.video_info.thumbnail_url;
                this.jJy = topicInfo.video_info.thumbnail_width.intValue();
                this.jJz = topicInfo.video_info.thumbnail_height.intValue();
                this.jJA = topicInfo.video_info.video_length.intValue();
                this.cqv = topicInfo.video_info.play_count.intValue();
            }
            this.tagType = topicInfo.tag_list_type;
            if (topicInfo.join_info != null) {
                this.jJD = new h();
                this.jJD.a(topicInfo.join_info);
            }
        }
    }
}
