package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes21.dex */
public class f implements q {
    public static final BdUniqueId ibS = BdUniqueId.gen();
    public int cwt;
    public String eCJ;
    public String eRa;
    public String jJp;
    public Integer jPA;
    public h jPB;
    public String jPC;
    public String jPt;
    public String jPu;
    public long jPv;
    public int jPw;
    public int jPx;
    public int jPy;
    public Long jPz;
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
        return ibS;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.eRa = String.valueOf(topicInfo.topic_id);
            this.eCJ = topicInfo.topic_name;
            this.jPt = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.jPu = topicInfo.head_photo_url;
            this.shareTitle = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
            this.jJp = topicInfo.share_pic;
            this.jPv = topicInfo.idx_num.longValue();
            this.jPz = topicInfo.pmy_topic_id;
            this.jPC = topicInfo.head_photo_jump_url;
            this.jPA = topicInfo.pmy_source;
            if (topicInfo.video_info != null && !StringUtils.isNull(topicInfo.video_info.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
                this.videoMd5 = topicInfo.video_info.video_md5;
                this.videoUrl = topicInfo.video_info.video_url;
                this.videoDuration = topicInfo.video_info.video_duration.intValue();
                this.videoWidth = topicInfo.video_info.video_width.intValue();
                this.videoHeight = topicInfo.video_info.video_height.intValue();
                this.thumbnailUrl = topicInfo.video_info.thumbnail_url;
                this.jPw = topicInfo.video_info.thumbnail_width.intValue();
                this.jPx = topicInfo.video_info.thumbnail_height.intValue();
                this.jPy = topicInfo.video_info.video_length.intValue();
                this.cwt = topicInfo.video_info.play_count.intValue();
            }
            this.tagType = topicInfo.tag_list_type;
            if (topicInfo.join_info != null) {
                this.jPB = new h();
                this.jPB.a(topicInfo.join_info);
            }
        }
    }
}
