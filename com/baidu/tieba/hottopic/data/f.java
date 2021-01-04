package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes8.dex */
public class f implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId iAa = BdUniqueId.gen();
    public int cGr;
    public String eRS;
    public String fgR;
    public String kkR;
    public String kqU;
    public String kqV;
    public long kqW;
    public int kqX;
    public int kqY;
    public int kqZ;
    public String kra;
    public Long krb;
    public Integer krc;
    public h krd;
    public String kre;
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
        return iAa;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.fgR = String.valueOf(topicInfo.topic_id);
            this.eRS = topicInfo.topic_name;
            this.kqU = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.kqV = topicInfo.head_photo_url;
            this.shareTitle = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
            this.kkR = topicInfo.share_pic;
            this.kqW = topicInfo.idx_num.longValue();
            this.krb = topicInfo.pmy_topic_id;
            this.kre = topicInfo.head_photo_jump_url;
            this.krc = topicInfo.pmy_source;
            if (topicInfo.video_info != null && !StringUtils.isNull(topicInfo.video_info.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
                this.videoMd5 = topicInfo.video_info.video_md5;
                this.videoUrl = topicInfo.video_info.video_url;
                this.videoDuration = topicInfo.video_info.video_duration.intValue();
                this.videoWidth = topicInfo.video_info.video_width.intValue();
                this.videoHeight = topicInfo.video_info.video_height.intValue();
                this.thumbnailUrl = topicInfo.video_info.thumbnail_url;
                this.kqX = topicInfo.video_info.thumbnail_width.intValue();
                this.kqY = topicInfo.video_info.thumbnail_height.intValue();
                this.kqZ = topicInfo.video_info.video_length.intValue();
                this.cGr = topicInfo.video_info.play_count.intValue();
            }
            this.kra = topicInfo.tag_list_type;
            if (topicInfo.join_info != null) {
                this.krd = new h();
                this.krd.a(topicInfo.join_info);
            }
        }
    }
}
