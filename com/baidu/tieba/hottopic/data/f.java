package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes8.dex */
public class f implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId iBr = BdUniqueId.gen();
    public int cEb;
    public String ePt;
    public String fey;
    public String koH;
    public String kuK;
    public String kuL;
    public long kuM;
    public int kuN;
    public int kuO;
    public int kuP;
    public String kuQ;
    public Long kuR;
    public Integer kuS;
    public h kuT;
    public String kuU;
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
        return iBr;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.fey = String.valueOf(topicInfo.topic_id);
            this.ePt = topicInfo.topic_name;
            this.kuK = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.kuL = topicInfo.head_photo_url;
            this.shareTitle = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
            this.koH = topicInfo.share_pic;
            this.kuM = topicInfo.idx_num.longValue();
            this.kuR = topicInfo.pmy_topic_id;
            this.kuU = topicInfo.head_photo_jump_url;
            this.kuS = topicInfo.pmy_source;
            if (topicInfo.video_info != null && !StringUtils.isNull(topicInfo.video_info.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
                this.videoMd5 = topicInfo.video_info.video_md5;
                this.videoUrl = topicInfo.video_info.video_url;
                this.videoDuration = topicInfo.video_info.video_duration.intValue();
                this.videoWidth = topicInfo.video_info.video_width.intValue();
                this.videoHeight = topicInfo.video_info.video_height.intValue();
                this.thumbnailUrl = topicInfo.video_info.thumbnail_url;
                this.kuN = topicInfo.video_info.thumbnail_width.intValue();
                this.kuO = topicInfo.video_info.thumbnail_height.intValue();
                this.kuP = topicInfo.video_info.video_length.intValue();
                this.cEb = topicInfo.video_info.play_count.intValue();
            }
            this.kuQ = topicInfo.tag_list_type;
            if (topicInfo.join_info != null) {
                this.kuT = new h();
                this.kuT.a(topicInfo.join_info);
            }
        }
    }
}
