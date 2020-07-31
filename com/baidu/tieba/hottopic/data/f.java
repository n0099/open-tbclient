package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes15.dex */
public class f implements q {
    public static final BdUniqueId haE = BdUniqueId.gen();
    public int bOe;
    public String dQI;
    public String eeI;
    public String iEh;
    public String iKm;
    public String iKn;
    public long iKo;
    public int iKp;
    public int iKq;
    public int iKr;
    public Long iKs;
    public Integer iKt;
    public h iKu;
    public String iKv;
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
        return haE;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.eeI = String.valueOf(topicInfo.topic_id);
            this.dQI = topicInfo.topic_name;
            this.iKm = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.iKn = topicInfo.head_photo_url;
            this.shareTitle = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
            this.iEh = topicInfo.share_pic;
            this.iKo = topicInfo.idx_num.longValue();
            this.iKs = topicInfo.pmy_topic_id;
            this.iKv = topicInfo.head_photo_jump_url;
            this.iKt = topicInfo.pmy_source;
            if (topicInfo.video_info != null && !StringUtils.isNull(topicInfo.video_info.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
                this.videoMd5 = topicInfo.video_info.video_md5;
                this.videoUrl = topicInfo.video_info.video_url;
                this.videoDuration = topicInfo.video_info.video_duration.intValue();
                this.videoWidth = topicInfo.video_info.video_width.intValue();
                this.videoHeight = topicInfo.video_info.video_height.intValue();
                this.thumbnailUrl = topicInfo.video_info.thumbnail_url;
                this.iKp = topicInfo.video_info.thumbnail_width.intValue();
                this.iKq = topicInfo.video_info.thumbnail_height.intValue();
                this.iKr = topicInfo.video_info.video_length.intValue();
                this.bOe = topicInfo.video_info.play_count.intValue();
            }
            this.tagType = topicInfo.tag_list_type;
            if (topicInfo.join_info != null) {
                this.iKu = new h();
                this.iKu.a(topicInfo.join_info);
            }
        }
    }
}
