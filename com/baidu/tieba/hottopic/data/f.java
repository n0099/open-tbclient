package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes21.dex */
public class f implements q {
    public static final BdUniqueId inG = BdUniqueId.gen();
    public int cBB;
    public String eIa;
    public String eXq;
    public String jXF;
    public String kdI;
    public String kdJ;
    public long kdK;
    public int kdL;
    public int kdM;
    public int kdN;
    public Long kdO;
    public Integer kdP;
    public h kdQ;
    public String kdR;
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
        return inG;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.eXq = String.valueOf(topicInfo.topic_id);
            this.eIa = topicInfo.topic_name;
            this.kdI = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.kdJ = topicInfo.head_photo_url;
            this.shareTitle = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
            this.jXF = topicInfo.share_pic;
            this.kdK = topicInfo.idx_num.longValue();
            this.kdO = topicInfo.pmy_topic_id;
            this.kdR = topicInfo.head_photo_jump_url;
            this.kdP = topicInfo.pmy_source;
            if (topicInfo.video_info != null && !StringUtils.isNull(topicInfo.video_info.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
                this.videoMd5 = topicInfo.video_info.video_md5;
                this.videoUrl = topicInfo.video_info.video_url;
                this.videoDuration = topicInfo.video_info.video_duration.intValue();
                this.videoWidth = topicInfo.video_info.video_width.intValue();
                this.videoHeight = topicInfo.video_info.video_height.intValue();
                this.thumbnailUrl = topicInfo.video_info.thumbnail_url;
                this.kdL = topicInfo.video_info.thumbnail_width.intValue();
                this.kdM = topicInfo.video_info.thumbnail_height.intValue();
                this.kdN = topicInfo.video_info.video_length.intValue();
                this.cBB = topicInfo.video_info.play_count.intValue();
            }
            this.tagType = topicInfo.tag_list_type;
            if (topicInfo.join_info != null) {
                this.kdQ = new h();
                this.kdQ.a(topicInfo.join_info);
            }
        }
    }
}
