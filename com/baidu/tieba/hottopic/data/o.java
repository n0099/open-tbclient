package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.MediaTopic;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public class o implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId knb = BdUniqueId.gen();
    public int cBF;
    public String eNh;
    public int kms;
    public int kmt;
    public int kmu;
    public String picUrl;
    public String thumbnailUrl;
    public long topicId;
    public int videoDuration;
    public int videoHeight;
    public String videoMd5;
    public String videoUrl;
    public int videoWidth;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return knb;
    }

    public void a(MediaTopic mediaTopic) {
        if (mediaTopic != null) {
            this.topicId = mediaTopic.topic_id.longValue();
            this.eNh = mediaTopic.topic_name;
            this.picUrl = mediaTopic.pic_url;
            if (mediaTopic.video_info != null && mediaTopic.video_info.video_duration.intValue() > 0) {
                e(mediaTopic.video_info);
            }
        }
    }

    public void e(VideoInfo videoInfo) {
        this.videoMd5 = videoInfo.video_md5;
        this.videoUrl = videoInfo.video_url;
        this.videoDuration = videoInfo.video_duration.intValue();
        this.videoWidth = videoInfo.video_width.intValue();
        this.videoHeight = videoInfo.video_height.intValue();
        this.thumbnailUrl = videoInfo.thumbnail_url;
        this.kms = videoInfo.thumbnail_width.intValue();
        this.kmt = videoInfo.thumbnail_height.intValue();
        this.kmu = videoInfo.video_length.intValue();
        this.cBF = videoInfo.play_count.intValue();
    }
}
