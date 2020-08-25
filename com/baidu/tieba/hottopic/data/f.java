package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes15.dex */
public class f implements q {
    public static final BdUniqueId hnv = BdUniqueId.gen();
    public int bTC;
    public String eab;
    public String eoj;
    public String iTh;
    public String iZm;
    public String iZn;
    public long iZo;
    public int iZp;
    public int iZq;
    public int iZr;
    public Long iZs;
    public Integer iZt;
    public h iZu;
    public String iZv;
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
        return hnv;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.eoj = String.valueOf(topicInfo.topic_id);
            this.eab = topicInfo.topic_name;
            this.iZm = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.iZn = topicInfo.head_photo_url;
            this.shareTitle = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
            this.iTh = topicInfo.share_pic;
            this.iZo = topicInfo.idx_num.longValue();
            this.iZs = topicInfo.pmy_topic_id;
            this.iZv = topicInfo.head_photo_jump_url;
            this.iZt = topicInfo.pmy_source;
            if (topicInfo.video_info != null && !StringUtils.isNull(topicInfo.video_info.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
                this.videoMd5 = topicInfo.video_info.video_md5;
                this.videoUrl = topicInfo.video_info.video_url;
                this.videoDuration = topicInfo.video_info.video_duration.intValue();
                this.videoWidth = topicInfo.video_info.video_width.intValue();
                this.videoHeight = topicInfo.video_info.video_height.intValue();
                this.thumbnailUrl = topicInfo.video_info.thumbnail_url;
                this.iZp = topicInfo.video_info.thumbnail_width.intValue();
                this.iZq = topicInfo.video_info.thumbnail_height.intValue();
                this.iZr = topicInfo.video_info.video_length.intValue();
                this.bTC = topicInfo.video_info.play_count.intValue();
            }
            this.tagType = topicInfo.tag_list_type;
            if (topicInfo.join_info != null) {
                this.iZu = new h();
                this.iZu.a(topicInfo.join_info);
            }
        }
    }
}
