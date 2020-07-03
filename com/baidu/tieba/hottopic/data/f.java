package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes8.dex */
public class f implements q {
    public static final BdUniqueId gVa = BdUniqueId.gen();
    public String dKw;
    public String dYw;
    public String iEi;
    public String iEj;
    public long iEk;
    public int iEl;
    public int iEm;
    public int iEn;
    public Long iEo;
    public Integer iEp;
    public h iEq;
    public String iEr;
    public String iyd;
    public int playCount;
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
        return gVa;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.dYw = String.valueOf(topicInfo.topic_id);
            this.dKw = topicInfo.topic_name;
            this.iEi = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.iEj = topicInfo.head_photo_url;
            this.shareTitle = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
            this.iyd = topicInfo.share_pic;
            this.iEk = topicInfo.idx_num.longValue();
            this.iEo = topicInfo.pmy_topic_id;
            this.iEr = topicInfo.head_photo_jump_url;
            this.iEp = topicInfo.pmy_source;
            if (topicInfo.video_info != null && !StringUtils.isNull(topicInfo.video_info.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
                this.videoMd5 = topicInfo.video_info.video_md5;
                this.videoUrl = topicInfo.video_info.video_url;
                this.videoDuration = topicInfo.video_info.video_duration.intValue();
                this.videoWidth = topicInfo.video_info.video_width.intValue();
                this.videoHeight = topicInfo.video_info.video_height.intValue();
                this.thumbnailUrl = topicInfo.video_info.thumbnail_url;
                this.iEl = topicInfo.video_info.thumbnail_width.intValue();
                this.iEm = topicInfo.video_info.thumbnail_height.intValue();
                this.iEn = topicInfo.video_info.video_length.intValue();
                this.playCount = topicInfo.video_info.play_count.intValue();
            }
            this.tagType = topicInfo.tag_list_type;
            if (topicInfo.join_info != null) {
                this.iEq = new h();
                this.iEq.a(topicInfo.join_info);
            }
        }
    }
}
