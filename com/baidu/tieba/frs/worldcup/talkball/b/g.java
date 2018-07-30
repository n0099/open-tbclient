package com.baidu.tieba.frs.worldcup.talkball.b;

import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class g {
    private String dMc;
    private String dMd;
    private String dMe;
    private String dMf;
    private String mThreadId;
    private String mTitle;

    public void b(VideoCard videoCard) {
        if (videoCard != null) {
            this.mTitle = videoCard.title;
            this.dMc = videoCard.cover_image;
            this.dMd = videoCard.video_duration;
            this.dMe = videoCard.topic_title;
            this.mThreadId = videoCard.thread_id;
            this.dMf = videoCard.thread_url;
        }
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String aBL() {
        return this.dMc;
    }

    public String aBM() {
        return this.dMd;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public String aBN() {
        return this.dMf;
    }
}
