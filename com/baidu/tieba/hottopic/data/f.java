package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes21.dex */
public class f implements q {
    public static final BdUniqueId hJy = BdUniqueId.gen();
    public int chU;
    public String eCP;
    public String eou;
    public String jqS;
    public String jwW;
    public String jwX;
    public long jwY;
    public int jwZ;
    public int jxa;
    public int jxb;
    public Long jxc;
    public Integer jxd;
    public h jxe;
    public String jxf;
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
        return hJy;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.eCP = String.valueOf(topicInfo.topic_id);
            this.eou = topicInfo.topic_name;
            this.jwW = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.jwX = topicInfo.head_photo_url;
            this.shareTitle = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
            this.jqS = topicInfo.share_pic;
            this.jwY = topicInfo.idx_num.longValue();
            this.jxc = topicInfo.pmy_topic_id;
            this.jxf = topicInfo.head_photo_jump_url;
            this.jxd = topicInfo.pmy_source;
            if (topicInfo.video_info != null && !StringUtils.isNull(topicInfo.video_info.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
                this.videoMd5 = topicInfo.video_info.video_md5;
                this.videoUrl = topicInfo.video_info.video_url;
                this.videoDuration = topicInfo.video_info.video_duration.intValue();
                this.videoWidth = topicInfo.video_info.video_width.intValue();
                this.videoHeight = topicInfo.video_info.video_height.intValue();
                this.thumbnailUrl = topicInfo.video_info.thumbnail_url;
                this.jwZ = topicInfo.video_info.thumbnail_width.intValue();
                this.jxa = topicInfo.video_info.thumbnail_height.intValue();
                this.jxb = topicInfo.video_info.video_length.intValue();
                this.chU = topicInfo.video_info.play_count.intValue();
            }
            this.tagType = topicInfo.tag_list_type;
            if (topicInfo.join_info != null) {
                this.jxe = new h();
                this.jxe.a(topicInfo.join_info);
            }
        }
    }
}
