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
    public String iEj;
    public String iKo;
    public String iKp;
    public long iKq;
    public int iKr;
    public int iKs;
    public int iKt;
    public Long iKu;
    public Integer iKv;
    public h iKw;
    public String iKx;
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
            this.iKo = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.iKp = topicInfo.head_photo_url;
            this.shareTitle = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
            this.iEj = topicInfo.share_pic;
            this.iKq = topicInfo.idx_num.longValue();
            this.iKu = topicInfo.pmy_topic_id;
            this.iKx = topicInfo.head_photo_jump_url;
            this.iKv = topicInfo.pmy_source;
            if (topicInfo.video_info != null && !StringUtils.isNull(topicInfo.video_info.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
                this.videoMd5 = topicInfo.video_info.video_md5;
                this.videoUrl = topicInfo.video_info.video_url;
                this.videoDuration = topicInfo.video_info.video_duration.intValue();
                this.videoWidth = topicInfo.video_info.video_width.intValue();
                this.videoHeight = topicInfo.video_info.video_height.intValue();
                this.thumbnailUrl = topicInfo.video_info.thumbnail_url;
                this.iKr = topicInfo.video_info.thumbnail_width.intValue();
                this.iKs = topicInfo.video_info.thumbnail_height.intValue();
                this.iKt = topicInfo.video_info.video_length.intValue();
                this.bOe = topicInfo.video_info.play_count.intValue();
            }
            this.tagType = topicInfo.tag_list_type;
            if (topicInfo.join_info != null) {
                this.iKw = new h();
                this.iKw.a(topicInfo.join_info);
            }
        }
    }
}
