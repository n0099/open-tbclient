package com.baidu.tieba.frs.worldcup.talkball.b;

import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class g {
    private String dLY;
    private String dLZ;
    private String dMa;
    private String dMb;
    private String mThreadId;
    private String mTitle;

    public void b(VideoCard videoCard) {
        if (videoCard != null) {
            this.mTitle = videoCard.title;
            this.dLY = videoCard.cover_image;
            this.dLZ = videoCard.video_duration;
            this.dMa = videoCard.topic_title;
            this.mThreadId = videoCard.thread_id;
            this.dMb = videoCard.thread_url;
        }
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String aBI() {
        return this.dLY;
    }

    public String aBJ() {
        return this.dLZ;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public String aBK() {
        return this.dMb;
    }
}
