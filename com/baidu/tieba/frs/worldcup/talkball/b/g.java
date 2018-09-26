package com.baidu.tieba.frs.worldcup.talkball.b;

import tbclient.TalkBall.VideoCard;
/* loaded from: classes3.dex */
public class g {
    private String dTq;
    private String dTr;
    private String dTs;
    private String dTt;
    private String mThreadId;
    private String mTitle;

    public void b(VideoCard videoCard) {
        if (videoCard != null) {
            this.mTitle = videoCard.title;
            this.dTq = videoCard.cover_image;
            this.dTr = videoCard.video_duration;
            this.dTs = videoCard.topic_title;
            this.mThreadId = videoCard.thread_id;
            this.dTt = videoCard.thread_url;
        }
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String aDV() {
        return this.dTq;
    }

    public String aDW() {
        return this.dTr;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public String aDX() {
        return this.dTt;
    }
}
