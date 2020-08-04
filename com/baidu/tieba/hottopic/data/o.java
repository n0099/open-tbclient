package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.TopicList.MediaTopic;
import tbclient.VideoInfo;
/* loaded from: classes15.dex */
public class o implements q {
    public static final BdUniqueId iKZ = BdUniqueId.gen();
    public int bOe;
    public String dQI;
    public int iKr;
    public int iKs;
    public int iKt;
    public String picUrl;
    public String thumbnailUrl;
    public long topicId;
    public int videoDuration;
    public int videoHeight;
    public String videoMd5;
    public String videoUrl;
    public int videoWidth;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iKZ;
    }

    public void a(MediaTopic mediaTopic) {
        if (mediaTopic != null) {
            this.topicId = mediaTopic.topic_id.longValue();
            this.dQI = mediaTopic.topic_name;
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
        this.iKr = videoInfo.thumbnail_width.intValue();
        this.iKs = videoInfo.thumbnail_height.intValue();
        this.iKt = videoInfo.video_length.intValue();
        this.bOe = videoInfo.play_count.intValue();
    }
}
