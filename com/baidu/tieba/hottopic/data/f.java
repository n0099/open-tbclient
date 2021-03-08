package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.Hottopic.TopicInfo;
/* loaded from: classes7.dex */
public class f implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId iDa = BdUniqueId.gen();
    public int cFB;
    public String eQU;
    public String ffX;
    public String kqJ;
    public String kwM;
    public String kwN;
    public long kwO;
    public int kwP;
    public int kwQ;
    public int kwR;
    public String kwS;
    public Long kwT;
    public Integer kwU;
    public h kwV;
    public String kwW;
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
        return iDa;
    }

    public void a(TopicInfo topicInfo) {
        if (topicInfo != null) {
            this.ffX = String.valueOf(topicInfo.topic_id);
            this.eQU = topicInfo.topic_name;
            this.kwM = topicInfo.desc;
            this.postNum = topicInfo.total_post_num.longValue();
            this.kwN = topicInfo.head_photo_url;
            this.shareTitle = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
            this.kqJ = topicInfo.share_pic;
            this.kwO = topicInfo.idx_num.longValue();
            this.kwT = topicInfo.pmy_topic_id;
            this.kwW = topicInfo.head_photo_jump_url;
            this.kwU = topicInfo.pmy_source;
            if (topicInfo.video_info != null && !StringUtils.isNull(topicInfo.video_info.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
                this.videoMd5 = topicInfo.video_info.video_md5;
                this.videoUrl = topicInfo.video_info.video_url;
                this.videoDuration = topicInfo.video_info.video_duration.intValue();
                this.videoWidth = topicInfo.video_info.video_width.intValue();
                this.videoHeight = topicInfo.video_info.video_height.intValue();
                this.thumbnailUrl = topicInfo.video_info.thumbnail_url;
                this.kwP = topicInfo.video_info.thumbnail_width.intValue();
                this.kwQ = topicInfo.video_info.thumbnail_height.intValue();
                this.kwR = topicInfo.video_info.video_length.intValue();
                this.cFB = topicInfo.video_info.play_count.intValue();
            }
            this.kwS = topicInfo.tag_list_type;
            if (topicInfo.join_info != null) {
                this.kwV = new h();
                this.kwV.a(topicInfo.join_info);
            }
        }
    }
}
